package ao.martins.shoesclean.domain.service;

import ao.martins.shoesclean.domain.model.Mensagem;
import ao.martins.shoesclean.domain.repository.MensagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MensagemService {
  private final MensagemRepository mensagemRepository;

    public Mensagem salvarMensagem(final Mensagem mensagem){
        return mensagemRepository.save(mensagem);
    }
}
