package ao.martins.shoesclean.api.dto.input;

import ao.martins.shoesclean.core.validation.NumeroTelefone;
import ao.martins.shoesclean.core.validation.NumeroTelefoneNaoRegistrado;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@AllArgsConstructor
@ToString
public class FuncionarioInput {

	public interface CriarFuncionario{}
	public interface ActualizarFuncionario{}

	@NotBlank(groups = {CriarFuncionario.class,ActualizarFuncionario.class})
	private String nome;

	@NotBlank(groups = {CriarFuncionario.class,ActualizarFuncionario.class})
	private String sobrenome;

	@NumeroTelefone(groups = {CriarFuncionario.class,ActualizarFuncionario.class})
	@NumeroTelefoneNaoRegistrado(groups = {FuncionarioInput.CriarFuncionario.class})
	private String telefone;

	@NotNull(groups = {CriarFuncionario.class,ActualizarFuncionario.class})
	@JsonProperty("cargo_id")
	private Integer cargoId;

	@Null(groups = {ActualizarFuncionario.class})
	@NotNull(groups = {CriarFuncionario.class}, message = "O campo 'password' é obrigatório")
	private String password;
}
