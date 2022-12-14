package ao.martins.shoesclean.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Getter
@Entity
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    private String numeroTelefone;
    private String nome;
}
