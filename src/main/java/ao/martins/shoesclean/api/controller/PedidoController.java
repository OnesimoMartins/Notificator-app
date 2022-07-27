package ao.martins.shoesclean.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ao.martins.shoesclean.api.dto.input.PedidoInpput;

@RequestMapping("pedidos")
public class PedidoController {

	@PostMapping
    void criarPedido(PedidoInpput pedidoInput){}
}
