package ao.martins.shoesclean.domain.repository;

import ao.martins.shoesclean.domain.view.Resumo;
import lombok.AllArgsConstructor;
import org.hibernate.loader.custom.Return;
import org.hibernate.param.ParameterBinder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

@Repository
@AllArgsConstructor
public class ViewQueriesRepository  {
    private EntityManager manager;

   public Object getResumo(){
        return  manager.createNativeQuery( """
            select 
            (select count(*) from pedido )as c1,
            (select count(*)  from funcionario )as c2,
            (select count(*) from mensagem) as c3,
            (select count(*) from pedido as c4) as c5,
            (select count(*) as pedido_count from pedido  where status='CRIADO' ) as c4;           
            """).getSingleResult();
    }

}
