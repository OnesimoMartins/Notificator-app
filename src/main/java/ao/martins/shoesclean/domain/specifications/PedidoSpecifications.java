package ao.martins.shoesclean.domain.specifications;

import ao.martins.shoesclean.domain.filter.PedidoFiltro;
import ao.martins.shoesclean.domain.model.Pedido;
import ao.martins.shoesclean.domain.model.StatusPedido;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class PedidoSpecifications {

    public static Specification<Pedido> comStatusConcluido(){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("status"), StatusPedido.CONCLUIDO);
    }

    public static Specification<Pedido> comNomeClienteTipo(String nome){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("cliente").get("nome"),("%"+nome+"%"));
    }

    public static Specification<Pedido> comNumeroTelefoneClienteTipo(String numero){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("cliente").get("numeroTelefone"), ("%"+numero+"%"));
    }

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


    public static Specification<Pedido> comStatusCriado(){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("status"), StatusPedido.CRIADO);
    }

    public static Specification<Pedido> fromString(String status) {
        if(status.equalsIgnoreCase("criado"))
            return comStatusCriado();
        else if (status.equalsIgnoreCase("concluido"))
            return comStatusConcluido();

        else
            throw  new IllegalArgumentException("Não existe pedido com o status  '"+status+"'");
    }
}
