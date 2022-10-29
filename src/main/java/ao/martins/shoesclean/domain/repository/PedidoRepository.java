package ao.martins.shoesclean.domain.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import ao.martins.shoesclean.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,Long>
        , JpaSpecificationExecutor<Pedido> {

    @Override
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,value = "pedido_items_graph")
    Page<Pedido> findAll(Specification spec, Pageable pageable);

    @Override
    <S extends Pedido> List<S> findAll(Example<S> example);
    //    Page<Pedido> pesquisarPorNomeCliente(String nome);
//
//    Page<Pedido> pesquisarPorNumeroCliente(String numero);
}
