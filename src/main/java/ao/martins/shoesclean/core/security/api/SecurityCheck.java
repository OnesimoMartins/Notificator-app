package ao.martins.shoesclean.core.security.api;


import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public @interface SecurityCheck {

    @interface Funcionarios{

        @PreAuthorize("@securityProvider.isAdministrador()")
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        @interface PodeAcederFuncinarios{}

        @PreAuthorize("@securityProvider.isAdministrador()")
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        @interface PodeBloquearOuDesbloquearFuncionario{}


    }
}
