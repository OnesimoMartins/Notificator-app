package ao.martins.shoesclean.api.mapper;

import ao.martins.shoesclean.api.dto.response.ClienteResponse;
import ao.martins.shoesclean.domain.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteResponse toClienteResponse(Cliente cliente){
        return  ClienteResponse.builder()
                .nome(cliente.getNome())
                .numeroTelefone(cliente.getNumeroTelefone())
                .build();
    }
}
