package ao.martins.shoesclean.domain.repository;

import ao.martins.shoesclean.domain.view.Resumo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigInteger;

@Repository
@AllArgsConstructor
public class ViewQueriesRepository  {

    private EntityManager manager;

    private BigInteger getCountTable(final String tableName){
        return (BigInteger) manager.createNativeQuery("select count(*) from %s ;".formatted(tableName))
                .getSingleResult();
    }

   public Resumo getResumo(){

        var resumo=new Resumo();

       resumo.setQuantidadeClientes(getCountTable("cliente"));
       resumo.setQuantidadeMensagens(getCountTable("mensagem"));
       resumo.setQuantidadePedidos(getCountTable("pedido"));
       resumo.setQuantidadePedidosPendentes(getCountTable(" pedido  where status='CRIADO'"));
       resumo.setQuantidadeFuncionarios(getCountTable("funcionario"));

         return resumo;
    }


}
