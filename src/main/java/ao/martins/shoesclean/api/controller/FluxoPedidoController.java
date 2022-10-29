package ao.martins.shoesclean.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ao.martins.shoesclean.api.dto.input.TempoAdiamentoInput;
import ao.martins.shoesclean.domain.service.PedidoService;

@RestController
@RequestMapping("pedidos")
public class FluxoPedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("{id}/concluir")
	public void concluirPedido(@PathVariable Long id) {
		pedidoService.concluirPedido(pedidoService.procuraPedidoPorId(id));
	}

}
