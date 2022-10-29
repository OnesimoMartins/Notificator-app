package ao.martins.shoesclean.domain.event;

import ao.martins.shoesclean.domain.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PedidoConcluidoEvent {
    private Pedido pedido;
}
