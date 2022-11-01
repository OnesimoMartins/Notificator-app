package ao.martins.shoesclean.domain.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraph(
		attributeNodes = {@NamedAttributeNode("cargo")},
		name = "pedido_cargo_graph")
public class Funcionario  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	private String password;

	@OneToOne
	private Cargo cargo;

	@Column(name = "numero_telefone")
	private String telefone;

	@Override
	public boolean equals(Object obj) {

		System.out.println(((Funcionario) obj).telefone.equalsIgnoreCase(this.getTelefone()));

		return obj instanceof  Funcionario &&
				((Funcionario) obj).id.equals(this.id) &&
		((Funcionario) obj).telefone.equalsIgnoreCase(this.getTelefone());
	}
}
