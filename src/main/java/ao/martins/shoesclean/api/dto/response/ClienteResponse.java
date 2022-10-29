package ao.martins.shoesclean.api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ClienteResponse {
    private String nome;

    @JsonProperty("numero_telefone")
    private String numeroTelefone;
}
