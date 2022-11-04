package ao.martins.shoesclean.domain.service;

import ao.martins.shoesclean.domain.model.Mensagem;
import ao.martins.shoesclean.twilio.TwilioService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class MensagemService extends TwilioService {

  private  ApplicationEventPublisher publisher;
    public Mensagem salvarMensagem(Mensagem mensagem){
        mensagem.setData(LocalDateTime.now());
        return  mensagem;
    }
}
