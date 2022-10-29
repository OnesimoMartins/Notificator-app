package ao.martins.shoesclean.api.mapper;

import ao.martins.shoesclean.api.dto.response.CargoResponse;
import ao.martins.shoesclean.domain.model.Cargo;
import org.springframework.stereotype.Component;

@Component
public class CargoMapper {

    public CargoResponse toCargoResponse(Cargo cargo){
        return CargoResponse.builder()
                .id(cargo.getId())
                .descricao(cargo.getDescricao())
                .build();
    }
}
