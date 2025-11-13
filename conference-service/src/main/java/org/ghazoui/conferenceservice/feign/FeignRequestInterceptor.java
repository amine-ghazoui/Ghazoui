package org.ghazoui.conferenceservice.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

/**
 * Intercepteur Feign pour transmettre le token JWT dans les requêtes inter-services
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        // Récupérer l'authentification actuelle depuis le contexte de sécurité
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            // Ajouter le token JWT dans l'en-tête Authorization
            template.header("Authorization", "Bearer " + jwt.getTokenValue());
        }
    }
}

