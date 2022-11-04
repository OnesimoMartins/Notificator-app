package ao.martins.shoesclean.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class Mensagem {

    private Long id;
    private LocalDateTime data;
    private String corpo;
    private Cliente cliente;

}
