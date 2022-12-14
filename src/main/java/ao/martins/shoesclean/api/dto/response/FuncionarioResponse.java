package ao.martins.shoesclean.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FuncionarioResponse {

	private final Long id;
	private final String nome;
	private final String sobrenome;
	private final String telefone;
	private final CargoResponse cargo;

	@JsonProperty("is_bloqueado")
	private final Boolean isBloqueado;
	
}
