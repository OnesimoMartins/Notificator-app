package ao.martins.shoesclean.core.security;

import ao.martins.shoesclean.domain.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.time.Duration;
import java.util.List;
import java.util.Map;


@Configuration
@AllArgsConstructor
@EnableMethodSecurity
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final int ACCESS_TOKEN_DUARION= (int)Duration.ofMinutes(950).toSeconds();
    private final int REFRESH_TOKEN_DUARION= (int)Duration.ofDays(7).toSeconds();

    @Autowired
    private SecretKey secretKey;
    private final AuthenticationManager authenticationManager;
    private final FuncionarioService funcionarioService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints){
        var tokenEnhacerChain=new TokenEnhancerChain();
        tokenEnhacerChain.setTokenEnhancers(List.of(tokenEnhancer(),accessTokenConverter()));

        endpoints
                .reuseRefreshTokens(true)
                .tokenStore(new InMemoryTokenStore())
                .authenticationManager(authenticationManager)
                .userDetailsService(funcionarioService)
                .tokenEnhancer(tokenEnhacerChain);
    }
    private TokenEnhancer tokenEnhancer(){
        return (accessToken,OAuth2Authentication)->{

        var funcionarioId=  ((AuthFuncionario) OAuth2Authentication
                .getPrincipal()).getFuncionarioId();

            ( (DefaultOAuth2AccessToken) accessToken)
                    .setAdditionalInformation(Map.of("id",funcionarioId));

            return accessToken;
        };
    }
    private JwtAccessTokenConverter accessTokenConverter(){
        var jwtConverter=new JwtAccessTokenConverter();
        jwtConverter.setSigningKey(secretKey.getSecret());
       return jwtConverter;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("FRONTEND").secret(passwordEncoder.encode("123"))
                .accessTokenValiditySeconds(ACCESS_TOKEN_DUARION)
                .refreshTokenValiditySeconds(REFRESH_TOKEN_DUARION)
                .authorizedGrantTypes("password","refresh_token")
                .scopes("read");
    }
}
