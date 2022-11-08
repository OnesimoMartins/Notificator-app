package ao.martins.shoesclean.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data;

    @Transient
    private String corpo;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
}
