package ao.martins.shoesclean.domain.view;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;

/**
 * esta classe representa um resumo dos dados do banco de dados
 * nela é possivel sabermos a quantidade de istancias das entidades na BD
 * ideal para ser utilizado em dashboards
 *
 * **/

@Getter
@Setter
public class Resumo {
    private Long quantidadePedidos;
    private Long quantidadePedidosPendentes;
    private Long quantidadeClientes;
    private Long quantidadeFuncionarios;
    private Long quantidadeMensagens;
}
