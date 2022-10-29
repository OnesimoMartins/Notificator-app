package ao.martins.shoesclean.controller;

import ao.martins.shoesclean.api.controller.FuncionarioController;
import ao.martins.shoesclean.api.dto.input.NovaPalavraPasseInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@WebMvcTest(FuncionarioController.class)
public class FuncionarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void deve_falhar_ao_mudar_password_com_campos_invalidos() throws Exception {

        var password=new NovaPalavraPasseInput("123","onesimo");

        mvc.perform(MockMvcRequestBuilders.put("funcionarios/mudar-password")
                .content(mapper.writeValueAsString(password))
                .accept(MediaType.APPLICATION_JSON)

        ).andDo(MockMvcResultHandlers.print());
    }

}
