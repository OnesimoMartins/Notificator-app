package ao.martins.shoesclean.api.dto.input;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NovaPalavraPasseInput {

  @NotBlank
  @JsonProperty("palavra_passe_actual")
  private String palavraPasseActual;

  @NotBlank
  @JsonProperty("nova_palavra_passe")
  private String novaPalavraPasse;
}
