package ao.martins.shoesclean.api.controller;


import ao.martins.shoesclean.api.dto.response.CargoResponse;
import ao.martins.shoesclean.api.mapper.CargoMapper;
import ao.martins.shoesclean.domain.repository.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cargos")
@AllArgsConstructor
public class CargoController {

    private CargoRepository cargos;
    private CargoMapper cargoMapper;

    @GetMapping
    @Cacheable("cargos")
    public List<CargoResponse> listarCargos(){
    return  cargos.findAll().stream().map(cargoMapper::toCargoResponse).toList();
    }
}
