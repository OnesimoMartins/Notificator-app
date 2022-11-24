package ao.martins.shoesclean.domain.listener;

import ao.martins.shoesclean.domain.event.MensagemEvent;
import ao.martins.shoesclean.domain.model.PedidoMensagem;
import ao.martins.shoesclean.domain.repository.MensagemRepository;
import ao.martins.shoesclean.domain.service.MensagemService;
import ao.martins.shoesclean.domain.service.NotificacaoService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MensagemEventListener {

   private final MensagemService mensagemService;
   private final NotificacaoService notificacaoService;

    @EventListener
    public  void mensagemCriada(MensagemEvent mensagemEvent){

        notificacaoService.enviarMensagem(PedidoMensagem.builder()
                        .corpo(mensagemEvent.getMensagem().getCorpo())
                        .destinatario(mensagemEvent.getMensagem().getCliente().getNumeroTelefone())
                .build());

        mensagemService.salvarMensagem(mensagemEvent.getMensagem());
    }

}
