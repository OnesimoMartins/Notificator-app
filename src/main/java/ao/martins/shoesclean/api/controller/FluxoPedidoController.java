package ao.martins.shoesclean.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
