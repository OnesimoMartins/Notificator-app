package ao.martins.shoesclean.api.dto.input;

import ao.martins.shoesclean.core.validation.NumeroTelefone;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MensagemRequest {
    @NumeroTelefone
    private String numero;
    @NotBlank
    private String corpo;
}
