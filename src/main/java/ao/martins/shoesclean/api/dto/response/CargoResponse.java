package ao.martins.shoesclean.api.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CargoResponse {
    private int id;
    private String descricao;
}
