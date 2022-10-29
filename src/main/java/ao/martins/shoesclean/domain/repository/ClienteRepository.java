package ao.martins.shoesclean.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ao.martins.shoesclean.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,String>{}
