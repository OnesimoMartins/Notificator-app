package ao.martins.shoesclean.twilio;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {

    @Autowired
    private TwilioProperties twilioProperties;
    @Bean
    public void init(){
        Twilio.init(twilioProperties.getSsid(),twilioProperties.getAuth());
    }
}
