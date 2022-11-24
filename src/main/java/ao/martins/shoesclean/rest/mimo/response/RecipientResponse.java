package ao.martins.shoesclean.rest.mimo.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecipientResponse {

    private String phone;
    private String  messageId;
    private String status;

}
