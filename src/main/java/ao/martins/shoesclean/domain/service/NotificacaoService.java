package ao.martins.shoesclean.domain.service;

import ao.martins.shoesclean.domain.model.PedidoMensagem;

public interface NotificacaoService {

        void enviarMensagem(PedidoMensagem pedidoMensagem);
}
