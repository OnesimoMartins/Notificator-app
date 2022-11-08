package ao.martins.shoesclean.domain.specifications;

import ao.martins.shoesclean.domain.filter.PedidoFiltro;
import ao.martins.shoesclean.domain.model.Pedido;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

public class PedidoSpecifications {

    public  static Specification<Pedido> comFiltro(PedidoFiltro filtro){
        return (root, query, criteriaBuilder) -> {

            var predicates= new ArrayList<Predicate>();

          if (filtro.getNomeCliente()!=null)
              predicates.add(criteriaBuilder.like(root.get("cliente")
                      .get("nome"), ("%"+filtro.getNomeCliente()+"%")));

          if (filtro.getNumeroTelefoneCliente()!=null)
                predicates.add(criteriaBuilder.like(root.get("cliente")
                        .get("numeroTelefone"), ("%"+filtro.getNumeroTelefoneCliente()+"%")));

          if (filtro.getStatus()!=null)
                predicates.add(criteriaBuilder.equal
                        (root.get("status"), filtro.getStatus()));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }



}
