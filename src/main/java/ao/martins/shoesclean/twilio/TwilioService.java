package ao.martins.shoesclean.twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioAPI {

    @Autowired
    private TwilioProperties twilioProperties;

    public void sendMessage(String to){

        Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(twilioProperties.getNumber()),
                "TESTETT"

        ).create();
    }
}
