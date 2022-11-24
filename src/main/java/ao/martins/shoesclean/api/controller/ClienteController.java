package ao.martins.shoesclean.api.controller;

import ao.martins.shoesclean.api.dto.input.MensagemRequest;
import ao.martins.shoesclean.api.dto.response.ClienteResponse;
import ao.martins.shoesclean.api.dto.response.MensagemResponse;
import ao.martins.shoesclean.api.mapper.ClienteMapper;
import ao.martins.shoesclean.api.mapper.MensagemMapper;
import ao.martins.shoesclean.domain.event.MensagemEvent;
import ao.martins.shoesclean.domain.model.Mensagem;
import ao.martins.shoesclean.domain.service.ClienteService;
import ao.martins.shoesclean.domain.service.MensagemService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;
    private final MensagemService mensagemService;
    private final MensagemMapper mensagemMapper;

    private final ApplicationEventPublisher publisher;

    @GetMapping("{id}")
    public ClienteResponse clientePorId(@PathVariable String id){
    return clienteMapper.toClienteResponse( clienteService.procuraPorNumeroTelefone(id));
    }

    @PostMapping("mensagem")
    public MensagemResponse enviarMensagem(@Valid @RequestBody MensagemRequest mensagemRequest){

        var mensagem=mensagemMapper.toMensagem(mensagemRequest);

        mensagem.setCliente(clienteService.procuraPorNumeroTelefone(mensagemRequest.getNumero()));

        publisher.publishEvent(new MensagemEvent(mensagem));

        return mensagemMapper.toMensagemResponse(mensagemService.salvarMensagem(mensagem));
    }


}
