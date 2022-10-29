package ao.martins.shoesclean.domain.service;

import ao.martins.shoesclean.api.dto.response.PedidoResponse;
import ao.martins.shoesclean.core.validation.TelefoneValidator;
import ao.martins.shoesclean.domain.exception.PedidoJaConcluidoException;
import ao.martins.shoesclean.domain.filter.PedidoFiltro;
import static ao.martins.shoesclean.domain.specifications.PedidoSpecifications.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ao.martins.shoesclean.domain.model.Pedido;
import ao.martins.shoesclean.domain.model.StatusPedido;
import ao.martins.shoesclean.domain.repository.PedidoRepository;
//static import ao.martins.
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

@Service
public class PedidoService {

    private final ClienteService clienteService;
    private final PedidoRepository pedidoRepository;


    public PedidoService(ClienteService clienteService, PedidoRepository pedidoRepository){
        this.clienteService=clienteService;
        this.pedidoRepository=pedidoRepository;
    }

    public Pedido procuraPedidoPorId(Long id){

        return this.pedidoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(
                        String.format("clinete com o id '%s' não encontrado ",id)));
    }

    public Pedido criarPedido(Pedido pedido){

        pedido.setStatus(StatusPedido.CRIADO);
        clienteService.salvarOuActualizar(pedido.getCliente());
        return pedidoRepository.save(pedido);

    }

    public Pedido concluirPedido(Pedido pedido){

        if(pedido.getStatus().equals(StatusPedido.CONCLUIDO))
           throw new PedidoJaConcluidoException("o pedido com o id '"+pedido.getId()+
          "' já foi maracado como concluido.");
//TODO  alter status pedido
        return pedidoRepository.save(pedido);
    }

    public Page<Pedido> ProcurarPedido(PedidoFiltro filtro, Pageable pageable) {

//        var predicates =new ArrayList<Predicate>();
//
//        if(filtro.getNomeCliente()!=null)
//            predicates.add(comNumeroTelefoneClienteTipo(filtro.getNumeroTelefoneCliente())
//                    );

   return  pedidoRepository.findAll(
          comFiltro(filtro),pageable);

    }


}

//    public Page<Pedido> procuraPedidoPorNomeCliente(String value) {
//
//        return t
//
//    }
//    public Page<Pedido> procuraPedidoPorNumeroCliente(String value) {
//
//        return t
//
//    }


