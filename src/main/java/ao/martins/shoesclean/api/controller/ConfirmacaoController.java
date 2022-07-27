package ao.martins.shoesclean.api.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ao.martins.shoesclean.api.dto.input.TempoAdiamentoInput;

@RequestMapping("/pedidos")
public class ConfirmacaoController {
	
	@PutMapping("/{id}/concluir")
	public void concluirPedido() {}
	
	//se a data estipulada nao estiver concluido entao envie automaticament
	@PutMapping("/{id}/adiar")
	public void AdiarPedido(TempoAdiamentoInput adiament) {}

}
