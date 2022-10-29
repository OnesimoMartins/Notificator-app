package ao.martins.shoesclean.domain.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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

}
