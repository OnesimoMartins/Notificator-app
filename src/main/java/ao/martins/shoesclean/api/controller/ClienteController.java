package ao.martins.shoesclean.api.controller;

import ao.martins.shoesclean.api.dto.response.ClienteResponse;
import ao.martins.shoesclean.api.mapper.ClienteMapper;
import ao.martins.shoesclean.domain.service.ClienteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteService clienteService,ClienteMapper clienteMapper){
        this.clienteMapper=clienteMapper;
        this.clienteService=clienteService;
    }

    @GetMapping("{id}")
    public ClienteResponse clientePorId(@PathVariable String id){

    return clienteMapper.
                    toClienteResponse( clienteService.procuraPorNumeroTelefone(id));
    }
}
