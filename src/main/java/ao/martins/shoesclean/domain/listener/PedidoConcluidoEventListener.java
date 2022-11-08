package ao.martins.shoesclean.domain.listener;

import ao.martins.shoesclean.domain.event.MensagemEvent;
import ao.martins.shoesclean.domain.event.PedidoConcluidoEvent;
import ao.martins.shoesclean.domain.model.Mensagem;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PedidoConcluidoEventListener {

    private ApplicationEventPublisher publisher;

    @EventListener
    public  void aoConcluirPedidoListener(PedidoConcluidoEvent pedidoEvent){

        if(pedidoEvent.notificar()){
            System.out.println("Concluir pedido e notificar");
            var msg=new Mensagem();
            msg.setCorpo("Caro(a) cliente o s");
            msg.setCliente(pedidoEvent.getPedido().getCliente());
            publisher.publishEvent(new MensagemEvent(msg));
        }

    }

}