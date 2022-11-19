package ao.martins.shoesclean.core.monitoring;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpTraceActuatorConfing {

    @Bean
    public HttpTraceRepository httpTrace(){
        var httpTrace= new InMemoryHttpTraceRepository();
        httpTrace.setCapacity(20);
        return httpTrace;
    }

}
