package ao.martins.shoesclean.api.controller;

import ao.martins.shoesclean.api.dto.input.NovaPalavraPasseInput;
import ao.martins.shoesclean.api.mapper.FuncionarioMapper;
import ao.martins.shoesclean.domain.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ao.martins.shoesclean.api.dto.input.FuncionarioInput;
import ao.martins.shoesclean.api.dto.response.FuncionarioResponse;
import ao.martins.shoesclean.domain.model.Funcionario;
import ao.martins.shoesclean.domain.service.FuncionarioService;

import javax.validation.Valid;


@AllArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;
	private final FuncionarioMapper funcionarioMapper;
	private final FuncionarioRepository funcionarioRepository;
	
	@PostMapping
	public FuncionarioResponse criarFuncionario( @RequestBody
					@Validated(FuncionarioInput.CriarFuncionario.class) FuncionarioInput input) {

		System.out.println(input);


		Funcionario funcionario=
				funcionarioService.salvarFuncionario( funcionarioMapper.toFuncionario(input));

	 return funcionarioMapper.toFuncionarioresponse(funcionario) ;
	}


	@PutMapping("{id}")
	public FuncionarioResponse alterarFuncionario(
			@PathVariable Long id,
			@Validated(FuncionarioInput.ActualizarFuncionario.class) @RequestBody FuncionarioInput input) {

		var funcionario=funcionarioService.funcionarioByIdOrThrows(id);

		var funcionarioNovo=funcionarioMapper.toFuncionario(input);

		funcionarioMapper.copiarPropriedades(funcionarioNovo, funcionario);

		return funcionarioMapper.toFuncionarioresponse(
				funcionarioService.salvarFuncionario(funcionario)
		) ;

	}


	@GetMapping("/{id}/alterar-password")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editarPalavraPasse(
			@PathVariable Long id,
			@RequestBody @Valid NovaPalavraPasseInput novaPalavraPasseInput){

		this.funcionarioService.mudarPalavraPasse(id,novaPalavraPasseInput.getPalavraPasseActual(),
				novaPalavraPasseInput.getNovaPalavraPasse()
		);
	}

	@GetMapping("{id}")
	public FuncionarioResponse findFuncionario(@PathVariable  Long id){
		return funcionarioMapper.toFuncionarioresponse(
				this.funcionarioService.funcionarioByIdOrThrows(id));
	}

	@GetMapping
	public Page<FuncionarioResponse> pageFuncionarios(Pageable pageable) {

		return this.funcionarioRepository.findAll(pageable)
				.map(funcionarioMapper::toFuncionarioresponse);
	}


}

