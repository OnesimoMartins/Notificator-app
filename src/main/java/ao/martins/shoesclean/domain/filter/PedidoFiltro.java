package ao.martins.shoesclean.domain.filter;

import ao.martins.shoesclean.domain.model.StatusPedido;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class PedidoFiltro {

   private String nomeCliente;
   private String numeroTelefoneCliente;
   private StatusPedido status;

   public void setStatus(String status) {
      this.status = StatusPedido.fromString(status);
   }
}
