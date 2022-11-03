package ao.martins.shoesclean.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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
