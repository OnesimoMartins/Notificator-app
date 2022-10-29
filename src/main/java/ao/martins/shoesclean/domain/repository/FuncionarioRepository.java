package ao.martins.shoesclean.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ao.martins.shoesclean.domain.model.Funcionario;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{
   Optional<Funcionario> findFuncionarioByTelefone(String telefone);
}
