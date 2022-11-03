package ao.martins.shoesclean.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

    @Id
    private String id;
    private String descricao;

    public ItemPedido(String descricao){
        this.descricao=descricao;
    }

    @PrePersist
    private void gerarId(){
        this.id= UUID.randomUUID().toString();
    }
}
