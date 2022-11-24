package ao.martins.shoesclean.domain.listener;

import ao.martins.shoesclean.domain.event.MensagemEvent;
import ao.martins.shoesclean.domain.event.PedidoConcluidoEvent;
import ao.martins.shoesclean.domain.model.Mensagem;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoConcluidoEventListener {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Value("${shoesclean.numero}")
    private String shoesCleanNumero;

    @EventListener
    public  void aoConcluirPedidoListener(PedidoConcluidoEvent pedidoEvent){

        if(pedidoEvent.notificar()){
            var msg=new Mensagem();

            msg.setCorpo("Caro(a) %s o seu pedido foi concluído.Para mais informações ligue %s".formatted(
                    pedidoEvent.getPedido().getCliente().getNome(),
                    shoesCleanNumero
            ));

            msg.setCliente(pedidoEvent.getPedido().getCliente());
            publisher.publishEvent(new MensagemEvent(msg));
        }

    }

}