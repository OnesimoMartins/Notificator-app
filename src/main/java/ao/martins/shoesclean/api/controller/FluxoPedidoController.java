package ao.martins.shoesclean.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ao.martins.shoesclean.domain.service.PedidoService;

@RestController
@RequestMapping("pedidos")
@AllArgsConstructor
public class FluxoPedidoController {

	private PedidoService pedidoService;

	@CacheEvict(value = "resumo",allEntries = true)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("{id}/concluir")
	public void concluirPedido(@PathVariable Long id,
							   @RequestParam(defaultValue = "true") Boolean notificar) {
		pedidoService.concluirPedido(pedidoService.procuraPedidoPorId(id),notificar);
	}

}
