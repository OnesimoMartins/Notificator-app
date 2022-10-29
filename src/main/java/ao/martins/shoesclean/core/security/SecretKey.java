package ao.martins.shoesclean.core.security;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class SecretKey {

    public String getSecret(){
        try {
            return Files.readString( Paths.get("src/main/resources/keys/secret.key"));
        } catch (IOException e) {
            throw new RuntimeException("Erro durante a leitura da chave secreta");
        }
    }
}
