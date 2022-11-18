package ao.martins.shoesclean.domain.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	private LocalDateTime dataCriacao;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_id")
	private List<ItemPedido> items;

}
