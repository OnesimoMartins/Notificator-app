package ao.martins.shoesclean.domain.repository;

import ao.martins.shoesclean.domain.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo,Integer> {
}
