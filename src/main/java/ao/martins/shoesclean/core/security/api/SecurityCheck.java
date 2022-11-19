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

        @PreAuthorize("@securityProvider.isIdFuncionarioAutenticado(#id)" +
                " || @securityProvider.isAdministrador()")
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        @interface PodeAcederFuncinario{}

        @PreAuthorize("@securityProvider.isIdFuncionarioAutenticado(#id)" )
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        @interface FuncionarioProprietario{}

        @PreAuthorize("@securityProvider.isAdministrador()")
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        @interface PodeBloquearOuDesbloquearFuncionario{}


        @PreAuthorize("@securityProvider.isAdministrador() || @securityProvider.isIdFuncionarioAutenticado(#id) ")
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        @interface PodeModificarFuncionario{}


    }
}
