package ao.martins.shoesclean.mimo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Valid
@Getter
@Setter
@Component
@ConfigurationProperties("mimo")
public class MimoProperties {

    @NotBlank
    private String token;

    @NotBlank
    private String sender;

}
