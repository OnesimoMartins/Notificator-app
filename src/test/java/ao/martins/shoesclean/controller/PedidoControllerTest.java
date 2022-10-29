package ao.martins.shoesclean.controller;

import java.util.List;
import java.util.stream.Stream;

import ao.martins.shoesclean.ShoesCleanNotificatorApplication;
import ao.martins.shoesclean.api.dto.response.PedidoResponse;
import ao.martins.shoesclean.domain.model.Cliente;
import ao.martins.shoesclean.domain.model.ItemPedido;
import ao.martins.shoesclean.domain.model.Pedido;
import ao.martins.shoesclean.domain.model.StatusPedido;
import ao.martins.shoesclean.domain.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ao.martins.shoesclean.api.controller.PedidoController;
import ao.martins.shoesclean.api.dto.input.PedidoInput;
import org.springframework.web.client.RestTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
classes = ShoesCleanNotificatorApplication.class)
public class PedidoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ObjectMapper objectmapper;

    @LocalServerPort
    private Integer port;

    private String baseUrl;

    @BeforeEach
    public void beforeEach(){
        this.baseUrl="http://localhost:"+port+'/';
    }

//    @ParameterizedTest
//    @MethodSource("getInvalidPedidoStream")
    @Test
    public void deve_falhar_ao_criar_novo_pedido_com_body_invalido(/*PedidoInput pedido*/) {

        var pedido=new PedidoInput("Geraldo Miguel", "961897389", List.of("1 sapato", "2 tenis"));
        var body=
                testRestTemplate.postForEntity((baseUrl+"/pedidos"),pedido, PedidoResponse.class)
                        .getBody();

        System.out.println(body);

//        mvc.perform(MockMvcRequestBuilders.post("/pedidos")
//                .content(objectmapper.writeValueAsString(pedido))
//                .contentType(MediaType.APPLICATION_JSON)).andExpect(
//                        MockMvcResultMatchers.status().isBadRequest())
//
//                .andDo(
//                        MockMvcResultHandlers.print());
    }

    @ParameterizedTest
    @MethodSource("getValidPedidoStream")
    public void deve_retornar_ok_ao_criar_novo_pedido_com_body_valido(PedidoInput pedido)
            throws  Exception {

        mvc.perform(MockMvcRequestBuilders.post("/pedidos")
                .content(objectmapper.writeValueAsString(pedido))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(
                    MockMvcResultHandlers.print());
    }

    @Test
    public void deve_retornar_lista_com_pedidos_concluidos(){

    }

    private static Stream<Arguments> getInvalidPedidoStream() {

        return Stream.of(

                Arguments.of(new PedidoInput(
                        "Geraldo Miguel", "961897389", List.of("1 sapato", "2 tenis"))),
                Arguments.of(new PedidoInput(
                        "francisco Gunga", "", List.of("1 sapato"))),
                Arguments.of(new PedidoInput(
                        null, "961897389", List.of("1 sapato"))),
                Arguments.of(new PedidoInput(
                        "paulo", "911897389", List.of())),
                Arguments.of(new PedidoInput(
                        "paulo", "null", List.of("1 sapato")))

        );

    }

    private static Stream<Arguments> getValidPedidoStream() {

        return Stream.of(

                Arguments.of(new PedidoInput(
                        "Geraldo Miguel", "911897389", List.of("1 sapato", "2 tenis"))),
                Arguments.of(new PedidoInput(
                        "francisco Gunga", "921897389", List.of("1 sapato")))

        );

    }
}
