package ao.martins.shoesclean.api.controller;


import ao.martins.shoesclean.domain.repository.ViewQueriesRepository;
import ao.martins.shoesclean.domain.view.Resumo;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resumo")
@AllArgsConstructor
public class ResumoController {

    private final ViewQueriesRepository views;

    @GetMapping
    @Cacheable("resumo")
    public Resumo  resumo(){
        return views.getResumo();
    }

}
