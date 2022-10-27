package ao.martins.shoesclean.api.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;


public class FuncionarioAlteracaoInput {

    @NotBlank
    @JsonProperty("palavra_passe_actual")
    private String palavraPasseActual;

    @NotBlank
    @JsonProperty("nova_palavra_passe")
    private String novaPalavraPasse;
}
