package ao.martins.shoesclean.api.dto.response;

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
	
}
