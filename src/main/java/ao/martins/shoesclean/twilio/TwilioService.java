package ao.martins.shoesclean.twilio;

import ao.martins.shoesclean.domain.model.PedidoMensagem;
import ao.martins.shoesclean.domain.service.NotificacaoService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;

public class TwilioService implements NotificacaoService {

    @Autowired
    private TwilioProperties twilioProperties;

    @Override
    public void enviarMensagem(PedidoMensagem pedidoMensagem) {
        Message.creator(
              new PhoneNumber(  pedidoMensagem.getDestinatario()),
                new PhoneNumber(twilioProperties.getNumber()),
                pedidoMensagem.getCorpo()

        ).create();
    }
}
