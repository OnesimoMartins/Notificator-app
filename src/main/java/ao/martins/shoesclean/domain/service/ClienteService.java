package ao.martins.shoesclean.domain.service;

import ao.martins.shoesclean.domain.model.Cliente;
import ao.martins.shoesclean.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clientes;

    public ClienteService(ClienteRepository clienteRepository){
        this.clientes= clienteRepository;
    }
    /*
    * não devem existir clientes com o mesmo número de telefone,
    * logo, quando já existe um cliente com o mesmo número, o seu nome é atualizado.
    * */
    public final Cliente salvarOuActualizar(Cliente cliente){

       return this.clientes.findById(cliente.getNumeroTelefone()).map(it->{

           it.setNome(cliente.getNome());
           return  this.clientes.save(it);

       }).or(
                ()-> Optional.of(this.clientes.save(cliente))
            ).get();
    }

    public final Cliente procuraPorNumeroTelefone(String numero){
        return this.clientes.findById(numero)
                .orElseThrow(()-> new EntityNotFoundException(
                        String.format("clinete com o número '%s' não encontrado ",numero)));
    }



}
