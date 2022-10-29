package ao.martins.shoesclean.api.mapper;

import ao.martins.shoesclean.api.dto.response.ItemPedidoResponse;
import ao.martins.shoesclean.api.dto.response.PedidoResponse;
import ao.martins.shoesclean.domain.model.ItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ao.martins.shoesclean.api.dto.input.PedidoInput;
import ao.martins.shoesclean.domain.model.Cliente;
import ao.martins.shoesclean.domain.model.Pedido;

import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    @Autowired
    private ClienteMapper clienteMapper;

    public Pedido toPedido( PedidoInput input){
        var pedido=new Pedido();

        pedido.setCliente( new Cliente(input.getNome(),input.getNumero()));
//        pedido.setItems(input.getItens().stream().map(it->new ItemPedido()));

        return pedido;
    }
    public PedidoResponse toPedidoResponse( Pedido  pedido){

        return PedidoResponse.builder()
                .statusPedido(pedido.getStatus())
                .id(pedido.getId())
                .cliente(clienteMapper.toClienteResponse(pedido.getCliente()))

                .items(pedido.getItems().stream()
                        .map(it->new ItemPedidoResponse(it.getId(),it.getDescricao()))
                        .collect(Collectors.toList()))
                .build();
    }
}

