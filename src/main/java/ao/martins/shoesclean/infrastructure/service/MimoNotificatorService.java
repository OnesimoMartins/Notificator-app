package ao.martins.shoesclean.infrastructure.service;

import ao.martins.shoesclean.domain.model.PedidoMensagem;
import ao.martins.shoesclean.domain.service.NotificacaoService;
import ao.martins.shoesclean.rest.mimo.MimoApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MimoNotificatorService implements NotificacaoService {

    private final MimoApi mimoApi;

    @Override
    public void enviarMensagem(PedidoMensagem pedidoMensagem) {
        mimoApi.criarMensagem(pedidoMensagem.getDestinatario(), pedidoMensagem.getCorpo() );
    }
}
