package ao.martins.shoesclean.domain.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

public class Pedido {
	
	private Long id;

	String nomeCliente;

	public int clientId;
	
	@CreationTimestamp
	LocalDateTime tempoCriacao;
	
	LocalDateTime tempoExpectavel;

	Integer quantitdadeItens;
	
	StatusPedido statusPedido;
	
	private Funcionario criadoPor;
	
}
