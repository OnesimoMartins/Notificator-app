package ao.martins.shoesclean.domain.listener;

import ao.martins.shoesclean.domain.event.PedidoConcluidoEvent;
import ao.martins.shoesclean.domain.model.StatusPedido;
import ao.martins.shoesclean.domain.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class PedioEventsListener {

    @Autowired
    private PedidoService pedidoService;

    @TransactionalEventListener
    public  void aoConcluirPedidoListener(PedidoConcluidoEvent pedidoEvent){

        if(pedidoEvent.getPedido().getStatus().equals(StatusPedido.CONCLUIDO)){
      //TODO enviar notificacao para o cliente;
        }
    }

}
