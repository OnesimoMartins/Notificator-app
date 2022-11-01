package ao.martins.shoesclean.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {

    @Builder.Default
    private final LocalDateTime timestamp=LocalDateTime.now();
    private final String code;
    private final int status;
    private final String tittle;
    private final String details;
}
