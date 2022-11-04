package ao.martins.shoesclean.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Builder
@Getter
public class MensagemResponse {

    private final ClienteResponse cliente;
    private final String corpo;
    private final LocalDateTime data;
}
