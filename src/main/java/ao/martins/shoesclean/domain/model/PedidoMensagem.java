package ao.martins.shoesclean.domain.model;

import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PedidoMensagem {

    private  String destinatario;
    private String corpo;

}
