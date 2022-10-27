package ao.martins.shoesclean.domain.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class PedidoFilter {
   private String nomeCliente;
   private String numeroTelefoneCliente;
}
