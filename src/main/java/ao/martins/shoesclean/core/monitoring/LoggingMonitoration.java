package ao.martins.shoesclean.core.monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoggingMonitoration implements HealthIndicator {
    @Override
    public Health health() {

        var details=new HashMap<String,String >();

        details.put("Is working","yea");

        return  Health.status(Status.UP).withDetails(details).build();
    }
}
