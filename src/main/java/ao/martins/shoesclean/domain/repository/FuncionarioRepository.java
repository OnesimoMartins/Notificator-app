package ao.martins.shoesclean.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import ao.martins.shoesclean.domain.model.Funcionario;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{
   Optional<Funcionario> findFuncionarioByTelefone(String telefone);

   @Override
   @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,value = "pedido_cargo_graph")
   Page<Funcionario> findAll( Pageable pageable);
}
