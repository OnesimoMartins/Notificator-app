package ao.martins.shoesclean.service;

import ao.martins.shoesclean.domain.exception.PalavraPasseIncorrectaExepion;
import ao.martins.shoesclean.domain.repository.FuncionarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ao.martins.shoesclean.domain.model.Funcionario;
import ao.martins.shoesclean.domain.service.FuncionarioService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTest {

	 FuncionarioService fService;

	 @Mock
	 FuncionarioRepository funcionarioRepository;

	 @BeforeEach
	 public void inicializarFuncionarioService(){
//		 this.fService=new FuncionarioService(this.funcionarioRepository);
	 }

	@Test
	 void shouldCreateNewFuncionario() {
		
		Funcionario f=new Funcionario();
		Assertions.assertNotNull(f);

	}
	@Test
	 void should() {
		
		Funcionario f=new Funcionario();
		Assertions.assertNotNull(f);

	}

	@Test
	public void deve_Alterar_palavra_passe_dados_parametro_corretos(){
		Mockito.when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(
				new Funcionario(1L,"crisnaldo",
						"Mendes","1234",null,"931897267")));
		assertDoesNotThrow(
				()->	this.fService.mudarPalavraPasse(1L,"1234","crispill")
	 );
	 }

	@Test
	public void deve_lancar_excessao_dados_parametro_Incorretos(){
		Mockito.when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(
				new Funcionario(1L,"crisnaldo",
						"Mendes","134",null,"931897267")));
		assertThrows(PalavraPasseIncorrectaExepion.class,
				()->	this.fService.mudarPalavraPasse(1L,"1234","crispill")
		);
	}

}
