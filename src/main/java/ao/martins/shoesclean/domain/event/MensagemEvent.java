package ao.martins.shoesclean.domain.event;


import ao.martins.shoesclean.domain.model.Mensagem;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MensagemEvent {
    private Mensagem mensagem;
}
