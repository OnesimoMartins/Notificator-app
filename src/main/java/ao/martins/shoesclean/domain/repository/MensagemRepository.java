package ao.martins.shoesclean.domain.repository;

import ao.martins.shoesclean.domain.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem,Long>{ }
