package ao.martins.shoesclean.rest.mimo.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@ToString
public class MensagemResponse {

    private String user;
    private Long id;
    private String sender;
    private String text;
    private Boolean unicode;
    private Integer size;
    private Integer  parts;
    private String recordDate;
   private List<RecipientResponse> recipients;
}
