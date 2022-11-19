package ao.martins.shoesclean.api.controller;

import ao.martins.shoesclean.api.dto.input.NovaPalavraPasseInput;
import ao.martins.shoesclean.api.mapper.FuncionarioMapper;
import ao.martins.shoesclean.core.security.api.SecurityCheck;
import ao.martins.shoesclean.domain.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import ao.martins.shoesclean.api.dto.input.FuncionarioInput;
import ao.martins.shoesclean.api.dto.response.FuncionarioResponse;
import ao.martins.shoesclean.domain.model.Funcionario;
import ao.martins.shoesclean.domain.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@AllArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;
	private final FuncionarioMapper funcionarioMapper;
	private final FuncionarioRepository funcionarioRepository;
	
	@PostMapping
	@SecurityCheck.Funcionarios.PodeAcederFuncinarios
	public FuncionarioResponse criarFuncionario( @RequestBody
					@Validated(FuncionarioInput.CriarFuncionario.class) FuncionarioInput input) {

		Funcionario funcionario=
				funcionarioService.salvarFuncionario( funcionarioMapper.toFuncionario(input));

	 return funcionarioMapper.toFuncionarioresponse(funcionario) ;
	}

	@PutMapping("{id}")
	@SecurityCheck.Funcionarios.PodeModificarFuncionario
	public FuncionarioResponse alterarFuncionario(
			@PathVariable Long id, @Validated(FuncionarioInput.ActualizarFuncionario.class)
	@RequestBody FuncionarioInput input) {

		var funcionario=funcionarioService.getFuncionarioByIdOrThrows(id);

		var funcionarioNovo=funcionarioMapper.toFuncionario(input);
		funcionarioNovo.setId(id);

		return funcionarioMapper.toFuncionarioresponse(
				funcionarioService.actualizarFuncionario(funcionarioNovo,funcionario)
		);

	}


	@PutMapping("/{id}/alterar-password")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@SecurityCheck.Funcionarios.FuncionarioProprietario
	public void editarPalavraPasse(@PathVariable Long id,
			@RequestBody @Valid NovaPalavraPasseInput novaPalavraPasseInput){

		this.funcionarioService.mudarPalavraPasse(id,novaPalavraPasseInput.getPalavraPasseActual(),
				novaPalavraPasseInput.getNovaPalavraPasse()
		);
	}

	@GetMapping("{id}")
	@SecurityCheck.Funcionarios.PodeAcederFuncinario
	public FuncionarioResponse encontrarFuncionario(@PathVariable Long id){
		return funcionarioMapper.toFuncionarioresponse(
				this.funcionarioService.getFuncionarioByIdOrThrows(id));
	}
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@SecurityCheck.Funcionarios.PodeModificarFuncionario
	public void apagarFuncionario(@PathVariable Long id){
	funcionarioService.apagarFuncionario(id);
	}

	@GetMapping
	@SecurityCheck.Funcionarios.PodeAcederFuncinarios
	public Page<FuncionarioResponse> pageFuncionarios(Pageable pageable) {
		return this.funcionarioRepository.findAll(pageable)
				.map(funcionarioMapper::toFuncionarioresponse);
	}


}

