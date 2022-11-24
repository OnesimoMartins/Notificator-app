package ao.martins.shoesclean.rest.mimo.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class MensagemRequest {

      private String sender;
      private String recipients;
      private String  text;

      public String toJSON(){
            return """
                    { "sender":"%s",
                       "recipients":"%s",
                       "text":"%s"
                    }
                    """.formatted(this.sender,this.recipients,this.text);
      }
}
