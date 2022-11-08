package ao.martins.shoesclean.domain.service;


import ao.martins.shoesclean.domain.event.PedidoConcluidoEvent;
import ao.martins.shoesclean.domain.exception.PedidoJaConcluidoException;
import ao.martins.shoesclean.domain.filter.PedidoFiltro;
import static ao.martins.shoesclean.domain.specifications.PedidoSpecifications.comFiltro;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ao.martins.shoesclean.domain.model.Pedido;
import ao.martins.shoesclean.domain.model.StatusPedido;
import ao.martins.shoesclean.domain.repository.PedidoRepository;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PedidoService {

    private final ClienteService clienteService;
    private final PedidoRepository pedidoRepository;
    private final ApplicationEventPublisher publisher;


    public Pedido procuraPedidoPorId(Long id){

        return this.pedidoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(
                        String.format("cliente com o id '%s' não foi encontrado ",id)));
    }

    @Transactional
    public Pedido criarPedido(Pedido pedido){
        pedido.setStatus(StatusPedido.CRIADO);
        clienteService.salvarOuActualizar(pedido.getCliente());
        return pedidoRepository.save(pedido);
    }

    public Pedido concluirPedido(Pedido pedido,Boolean notificar){

        if(pedido.getStatus().equals(StatusPedido.CONCLUIDO))
           throw new PedidoJaConcluidoException("""
          o pedido com o id '%s' já foi maracado como concluido.""".formatted(pedido.getId()));

        pedido.setStatus(StatusPedido.CONCLUIDO);

        publisher.publishEvent(new PedidoConcluidoEvent(pedido,notificar));

        return pedidoRepository.save(pedido);
    }

}



