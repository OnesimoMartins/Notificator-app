package ao.martins.shoesclean.service;

import ao.martins.shoesclean.domain.model.Cliente;
import ao.martins.shoesclean.domain.repository.ClienteRepository;
import ao.martins.shoesclean.domain.service.ClienteService;
import static org.mockito.BDDMockito.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    private  ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    void inicializarClienteService() {
        this.clienteService=new ClienteService(clienteRepository);
    }

    @Test
    public void Deve_econtrar_clinte_dado_numero_de_telefone_correcto(){

        var cliente= new Cliente("931897645","José Manaús");
        when(clienteRepository.findById("931897645")).thenReturn(Optional.of(cliente));

        assertEquals(
                clienteService.procuraPorNumeroTelefone("931897645")
                ,cliente);
    }

    @Test
    public void Deve_lancar_EntityNotFoundException_dado_numero_de_telefone_incorrecto(){

        when(clienteRepository.findById("912345678")).thenReturn(Optional.empty());

        assertThrows(
                EntityNotFoundException.class,
                ()-> clienteService.procuraPorNumeroTelefone("912345678"));

    }
    @Test
    public void Deve_salvar_cliente_dado_novo_cliente(){

        var clienteSalvo= new Cliente("931897645","José Manaús");
        when(clienteRepository.findById("931897645")).thenReturn(Optional.empty());
        when(clienteRepository.save(clienteSalvo)).thenReturn(clienteSalvo);

        assertEquals(
                clienteService.salvarOuActualizar(clienteSalvo)
                ,clienteSalvo);
    }
    @Test
    public void Deve_actualizar_cliente_dado_novo_cliente_com_nome_alterado(){

        var clienteSalvo= new Cliente("931897645","José Manaús");
        var clienteActualizado=new Cliente("931897645","Manuel Garcia");

        when(clienteRepository.findById("931897645")).thenReturn(Optional.of(clienteSalvo));

        when(clienteRepository.save(clienteSalvo)).thenReturn(clienteSalvo);

        assertEquals(
                clienteService.salvarOuActualizar(clienteActualizado).getNome()
                ,"Manuel Garcia");
    }

}
