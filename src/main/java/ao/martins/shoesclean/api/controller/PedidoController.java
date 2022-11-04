package ao.martins.shoesclean.api.controller;

import javax.validation.Valid;

import ao.martins.shoesclean.api.dto.response.PedidoResponse;
import ao.martins.shoesclean.domain.filter.PedidoFiltro;
import ao.martins.shoesclean.domain.repository.PedidoRepository;
import ao.martins.shoesclean.domain.specifications.PedidoSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import ao.martins.shoesclean.api.dto.input.PedidoInput;
import ao.martins.shoesclean.api.mapper.PedidoMapper;
import ao.martins.shoesclean.domain.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("pedidos")
@AllArgsConstructor
public class PedidoController {

   private final PedidoMapper pedidoMapper;
   private final PedidoService pedidoService;
   private final PedidoRepository pedidoRepository;

   @GetMapping("{id}")
   public PedidoResponse encontrarPedidoPorId(@PathVariable Long id){
       return pedidoMapper.toPedidoResponse(this.pedidoService.procuraPedidoPorId(id));
   }

    @GetMapping
    public Page<PedidoResponse> listarPedidos(
        @PageableDefault(direction = Sort.Direction.DESC,size = 5) Pageable pageable
        ,PedidoFiltro filtro){

      var page= PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),
                   Sort.by(Sort.Order.desc("id")));

     return  pedidoRepository.findAll(PedidoSpecifications.comFiltro(filtro),page)
           .map(pedidoMapper::toPedidoResponse);
   }
   @PostMapping
   public PedidoResponse criarPedido(@RequestBody @Valid  PedidoInput pedidoInput){
     var pedido= pedidoService
             .criarPedido(this.pedidoMapper.toPedido(pedidoInput));
      return pedidoMapper.toPedidoResponse( pedido);
   }

}
 