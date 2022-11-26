package ao.martins.shoesclean.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoggingController {

    @PostMapping("logs")
    public void criarLog(@RequestBody String text){
      log.error(text);
    }
}
