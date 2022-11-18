package ao.martins.shoesclean.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import ao.martins.shoesclean.domain.model.StatusPedido;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PedidoResponse {

    private final Long id;

	private final ClienteResponse cliente;

	@JsonProperty("status_pedido")
	private final StatusPedido statusPedido;

	@JsonProperty("data_criacao")
	private LocalDateTime dataCriacao;

	private final List<ItemPedidoResponse> items;
}
