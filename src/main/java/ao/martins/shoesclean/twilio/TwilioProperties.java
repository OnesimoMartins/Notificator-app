package ao.martins.shoesclean.twilio;

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
@ConfigurationProperties("twilio")
public class TwilioProperties {

    @NotBlank
    private String ssid;

    @NotBlank
    private String auth;

    @NotBlank
    private String number;
}
