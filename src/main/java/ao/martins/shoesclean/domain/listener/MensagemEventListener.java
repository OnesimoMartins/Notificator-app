package ao.martins.shoesclean.domain.listener;

import ao.martins.shoesclean.domain.event.MensagemEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MensagemEventListener {

    @EventListener
    public  void aoCriarMensagem(MensagemEvent mensagemEvent){
        System.out.println("""
                Enviando a menssage %s ao numero %s
                """.formatted(mensagemEvent.getMensagem().getCorpo(),
                mensagemEvent.getMensagem().getCliente().getNumeroTelefone()));
    }

}
