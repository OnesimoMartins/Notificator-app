package ao.martins.shoesclean.domain.view;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import java.math.BigInteger;

/**
 * esta classe representa um resumo dos dados do banco de dados
 * nela é possivel sabermos a quantidade de istancias das entidades na BD
 * ideal para ser utilizado em dashboards
 * **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resumo {
    private BigInteger quantidadePedidos;
    private BigInteger quantidadePedidosPendentes;
    private BigInteger quantidadeClientes;
    private BigInteger quantidadeFuncionarios;
    private BigInteger quantidadeMensagens;
}
