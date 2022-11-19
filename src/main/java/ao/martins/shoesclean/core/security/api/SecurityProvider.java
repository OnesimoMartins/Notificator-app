package ao.martins.shoesclean.core.security.api;

import ao.martins.shoesclean.core.security.AuthFuncionario;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class SecurityProvider {

   private static final SimpleGrantedAuthority admin= new SimpleGrantedAuthority("Administrador");

   public static boolean isAdministrador(){
       return SecurityContextHolder.getContext().getAuthentication()
               .getAuthorities().contains(admin);
   }

   private static Long getFuncionarioId(){
       var jwt= (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       return jwt.getClaim("id");
   }
   public static boolean isIdFuncionarioAutenticado(Long id){
      return  getFuncionarioId() ==id;
   }

}
