package ao.martins.shoesclean.domain.model;

import javax.persistence.NamedAttributeNode;
import javax.persistence.JoinColumn;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.PostPersist;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import ao.martins.shoesclean.domain.event.PedidoConcluidoEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@NamedEntityGraph(
		attributeNodes = {@NamedAttributeNode("items"),@NamedAttributeNode("cliente")},
		name = "pedido_items_graph")
public class Pedido extends AbstractAggregateRoot<Pedido> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne()
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	@OneToMany()
	@JoinColumn(name = "pedido_id")
	private List<ItemPedido> items;

	@PostPersist
	private void afterPersist(){
		if(this.getStatus().equals(StatusPedido.CONCLUIDO))
		    registerEvent( new PedidoConcluidoEvent(this));
	}
}
