package ao.martins.shoesclean.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {

    @Builder.Default
    private LocalDateTime timestamp=LocalDateTime.now();
    private int status;
    private String tittle;
    private String details;
}
