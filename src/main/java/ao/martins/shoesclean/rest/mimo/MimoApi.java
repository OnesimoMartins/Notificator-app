package ao.martins.shoesclean.rest.mimo;

import ao.martins.shoesclean.mimo.MimoProperties;
import ao.martins.shoesclean.rest.mimo.request.MensagemRequest;
import ao.martins.shoesclean.rest.mimo.response.MensagemResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class MimoApi {

    private final RestTemplate restTemplate;
    private final MimoProperties mimoProperties;


   public MensagemResponse criarMensagem(String numero,String mensagem){

    String url="http://52.30.114.86:8080/mimosms/v1/message/send?token=%s"
                .formatted(mimoProperties.getToken());

       var mensagemRequest=MensagemRequest.builder()
               .sender(mimoProperties.getSender())
               .text(mensagem)
               .recipients(numero)
               .build();
       System.out.println("-------Enviar mensagem");
       System.out.println(mensagemRequest);

       var headers=new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);

       var requestEntity=new HttpEntity<>(mensagemRequest,headers);

      ResponseEntity<MensagemResponse> response= restTemplate
              .exchange(url, HttpMethod.POST,requestEntity,MensagemResponse.class);

        return response.getBody();
      }
}
