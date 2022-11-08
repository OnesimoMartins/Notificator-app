package ao.martins.shoesclean.domain.listener;

import ao.martins.shoesclean.domain.event.MensagemEvent;
import ao.martins.shoesclean.domain.repository.MensagemRepository;
import ao.martins.shoesclean.domain.service.MensagemService;
import ao.martins.shoesclean.domain.service.NotificacaoService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MensagemEventListener {

   private MensagemService mensagemService;

    @EventListener
    public  void mensagemCriada(MensagemEvent mensagemEvent){

        // TODO usar o twillio para notificar

        mensagemService.salvarMensagem(mensagemEvent.getMensagem());
    }

}
