package ao.martins.shoesclean.domain.service;

import ao.martins.shoesclean.core.security.AuthFuncionario;
import ao.martins.shoesclean.core.utils.FuncionarioUtlis;
import ao.martins.shoesclean.domain.exception.NumeroTelefoneJaEmUsoException;
import ao.martins.shoesclean.domain.exception.OperacaoNaoPermitidaException;
import ao.martins.shoesclean.domain.exception.PalavraPasseIncorrectaExepion;
import ao.martins.shoesclean.domain.repository.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ao.martins.shoesclean.domain.model.Funcionario;
import ao.martins.shoesclean.domain.repository.FuncionarioRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncionarioService implements UserDetailsService {

	private final FuncionarioUtlis funcionarioUtlis;
	private final FuncionarioRepository funcionarios;
	private final CargoRepository cargos;

	public Funcionario getFuncionarioByTelefoneOrNull(String tlfn){
		return  this.funcionarios.findFuncionarioByTelefone(tlfn).orElse(null);
	}

	public Funcionario bloquearFuncionario(Long id){
		var funcionario=getFuncionarioByIdOrThrows(id);

		if(funcionario.isFuncionarioBloqueado())
			throw  new OperacaoNaoPermitidaException(
					"funcionário solicitado já se encontra bloqueado.");

		funcionario.setFuncionarioBloqueado(true);
		return funcionarios.save(funcionario);
	}

	public Funcionario desbloquearFuncionario(Long id){
		var funcionario=getFuncionarioByIdOrThrows(id);

		if(!funcionario.isFuncionarioBloqueado())
			throw  new OperacaoNaoPermitidaException(
					"O funcionário solicitado já se encontra  desbloqueado.");

		funcionario.setFuncionarioBloqueado(false);
		return funcionarios.save(funcionario);
	}

	public Funcionario salvarFuncionario(Funcionario f) {
		var cargo= cargos.findById(f.getCargo().getId()).orElseThrow(
				()-> new EntityNotFoundException("cargo com id '"+f.getCargo().getId()+"' não encotrado"));
		f.setCargo(cargo);
		return funcionarios.save(f);
	}

	public  Funcionario actualizarFuncionario(Funcionario novo, Funcionario antigo){

		var funcionarioComTelefone
				=this.funcionarios.findFuncionarioByTelefone(novo.getTelefone());

		if(!novo.equals(antigo) && funcionarioComTelefone.isPresent()
		&& !funcionarioComTelefone.get().equals(novo)) throw  new NumeroTelefoneJaEmUsoException(""" 
   Este número de telefone '%s' já esta a ser utilizado por outro funcionário.
   """.formatted(novo.getTelefone()));

		this.funcionarioUtlis.copiarPropriedades(novo,antigo);

		return funcionarios.save(antigo);
	}

    public Funcionario getFuncionarioByIdOrThrows(Long id) {
		return this.funcionarios.findById(id).orElseThrow(
				()->new EntityNotFoundException("Funcionario com o id "+id+
						" não foi encontrado.")
		);
    }

	public void mudarPalavraPasse(Long funcionarioId,String actual,String nova) {
	  Optional.of(getFuncionarioByIdOrThrows(funcionarioId)).ifPresent(it->{
		  if (actual.equals(it.getPassword())){
			  it.setPassword(nova);
			  this.funcionarios.save(it);
		  }
		  else throw
				  new PalavraPasseIncorrectaExepion("A palavra-passe actual fornecida está incorrecta. ");
	  });
	}

	@Override
	public UserDetails loadUserByUsername(String telefone) throws UsernameNotFoundException {
		return  this.funcionarios.findFuncionarioByTelefone(telefone)
				.map(AuthFuncionario::new).orElseThrow(()->
						new UsernameNotFoundException("numero de telefone ou password inválido"));
	}

	public void apagarFuncionario(Long id) {
	this.funcionarios.delete(	this.getFuncionarioByIdOrThrows(id));
	}
}