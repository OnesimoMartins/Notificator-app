package ao.martins.shoesclean.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PedidoMensagem {

    private  String destinatario;
    private String corpo;

}
