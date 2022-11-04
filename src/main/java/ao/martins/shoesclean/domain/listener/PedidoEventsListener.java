package ao.martins.shoesclean.domain.listener;

import ao.martins.shoesclean.domain.event.PedidoConcluidoEvent;
import ao.martins.shoesclean.domain.model.StatusPedido;
import ao.martins.shoesclean.domain.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@AllArgsConstructor
public class PedidoEventsListener {

    private PedidoService pedidoService;

    @TransactionalEventListener
    public  void aoConcluirPedidoListener(PedidoConcluidoEvent pedidoEvent){

        if(pedidoEvent.getPedido().getStatus().equals(StatusPedido.CONCLUIDO)){
            //TODO enviar notificacao para o cliente;

        }
    }

}
