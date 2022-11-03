package ao.martins.shoesclean.api.controller;

import ao.martins.shoesclean.api.dto.response.FuncionarioResponse;
import ao.martins.shoesclean.api.mapper.FuncionarioMapper;
import ao.martins.shoesclean.domain.model.Funcionario;
import ao.martins.shoesclean.domain.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioBloqueioController {

	private final FuncionarioService funcionarioService;
	private final FuncionarioMapper funcionarioMapper;

	@PutMapping("{id}/bloqueio")
	public FuncionarioResponse bloquearFuncionario(@PathVariable Long id) {
		Funcionario funcionario= funcionarioService.bloquearFuncionario(id);
	 return funcionarioMapper.toFuncionarioresponse(funcionario) ;
	}

	@DeleteMapping("{id}/bloqueio")
	public FuncionarioResponse desbloquearFuncionario(@PathVariable Long id) {
		Funcionario funcionario= funcionarioService.desbloquearFuncionario(id);
		return funcionarioMapper.toFuncionarioresponse(funcionario) ;
	}

}

