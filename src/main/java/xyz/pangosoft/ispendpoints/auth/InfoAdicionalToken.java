package xyz.pangosoft.ispendpoints.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
import xyz.pangosoft.ispendpoints.model.AppMovilUsuario;
import xyz.pangosoft.ispendpoints.service.IAppMovilUsuarioService;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    private Logger logger = LoggerFactory.getLogger(InfoAdicionalToken.class);
    @Autowired
    private IAppMovilUsuarioService usuarioService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        AppMovilUsuario usuario = usuarioService.findUsuarioByUsername(authentication.getName());
        logger.debug("Usuario => {}", usuario);

        Map<String, Object> info = new HashMap<>();
        info.put("info_adicional", "Hola que tal!: ".concat(authentication.getName()));

        info.put("id_usuario", usuario.getId().toString());
        info.put("nombre", usuario.getNombre());
        info.put("habilitado", usuario.isEnabled());
        info.put("fecha_registro", usuario.getFechaRegistro());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }

}
