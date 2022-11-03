package ao.martins.shoesclean.api.dto.input;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import ao.martins.shoesclean.core.validation.NumeroTelefone;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class PedidoInput {

    @NotBlank
    private String nome;

    @NumeroTelefone
    private String numero;
    
    @NotEmpty
    private List<String> itens;

}
