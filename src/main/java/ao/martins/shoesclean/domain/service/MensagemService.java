package ao.martins.shoesclean.domain.service;

import ao.martins.shoesclean.domain.model.Mensagem;
import ao.martins.shoesclean.domain.repository.MensagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class MensagemService {
  private MensagemRepository mensagemRepository;

    public Mensagem salvarMensagem(Mensagem mensagem){
        mensagem.setData(LocalDateTime.now());
        return mensagemRepository.save(mensagem);
    }
}
