package ao.martins.shoesclean.core.security;

import ao.martins.shoesclean.domain.model.Funcionario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class AuthFuncionario  implements UserDetails {

    private Funcionario funcionario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()->this.funcionario.getCargo().getDescricao());
    }

    public Long getFuncionarioId() {
        return funcionario.getId();
    }

    @Override
    public String getPassword() {
        return funcionario.getPassword();
    }

    @Override
    public String getUsername() {
        return funcionario.getTelefone();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
//        TODO : alterar quando o admin bloquar a conta
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
