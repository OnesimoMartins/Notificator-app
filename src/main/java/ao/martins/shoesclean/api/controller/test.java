package ao.martins.shoesclean.api.controller;


import ao.martins.shoesclean.api.dto.response.CargoResponse;
import ao.martins.shoesclean.api.mapper.CargoMapper;
import ao.martins.shoesclean.domain.repository.CargoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("xx")
@AllArgsConstructor
public class test {

    @GetMapping
    public void listarCargos() throws Exception {
        System.out.println("aquinnn");

        log.info("rttt");
        throw new Exception();
    }
}
