
package pe.gob.unmsm.sgv.security;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import pe.gob.unmsm.sgv.models.Usuario;
import pe.gob.unmsm.sgv.service.UsuarioService;

@Component
public class InfoAdicToken implements TokenEnhancer{

    @Autowired
    private UsuarioService usuarioService;
    
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        
        Usuario usuario= usuarioService.datosUsuario(authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("Info adicional", "".concat(authentication.getName()));
        info.put("nombre", usuario.getNombre());
        info.put("apellido", usuario.getApellido());
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(info);
        return accessToken;
    }
    
    
}
