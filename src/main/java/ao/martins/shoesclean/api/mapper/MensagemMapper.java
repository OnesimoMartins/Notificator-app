package ao.martins.shoesclean.api.mapper;


import ao.martins.shoesclean.api.dto.input.MensagemRequest;
import ao.martins.shoesclean.api.dto.response.MensagemResponse;
import ao.martins.shoesclean.domain.model.Cliente;
import ao.martins.shoesclean.domain.model.Mensagem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MensagemMapper {

    private final ClienteMapper clienteMapper;

    public Mensagem toMensagem(MensagemRequest mensagemRequest){
        var msg=new Mensagem();

        msg.setCorpo(mensagemRequest.getCorpo());

        var cliente=new Cliente();
        cliente.setNumeroTelefone(mensagemRequest.getNumero());
        msg.setCliente(cliente);

        return  msg;
    }

    public MensagemResponse toMensagemResponse(Mensagem mensagem){
        return  MensagemResponse.builder()
                .corpo(mensagem.getCorpo())
                .cliente( clienteMapper.toClienteResponse(mensagem.getCliente()) )
                .data(mensagem.getData())
                .build();
    }
}
