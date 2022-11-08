package ao.martins.shoesclean.core.security.api;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityProvider {

   private static final SimpleGrantedAuthority admin= new SimpleGrantedAuthority("Administrador");

   public static boolean isAdministrador(){
       return SecurityContextHolder.getContext().getAuthentication()
               .getAuthorities().contains(admin);
   }

}
