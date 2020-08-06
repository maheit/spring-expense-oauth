package com.maheit.expense.oauth20;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maheit.expense.config.JwtToken;
import com.maheit.expense.entity.User;
import com.maheit.expense.repository.UserRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class CustomAuthenticatonOnSuccess extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    UserRespository userRespository;

    @Autowired
    JwtToken jwtToken;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication authentication)
            throws IOException, ServletException {
        if (res.isCommitted()) {
            return;
        }
        DefaultOidcUser oidcUser = (DefaultOidcUser) authentication.getPrincipal();
        Map<String, Object> attributes = oidcUser.getAttributes();
        String email = (String) attributes.get("email");
        User user = userRespository.findByEmail(email);
        String token = jwtToken.generateToken(user);
        String redirectionalUrl = UriComponentsBuilder.fromUriString("http://localhost:8000/auth/google/callback")
                .queryParam("token", token).build().toUriString();
        getRedirectStrategy().sendRedirect(req, res, redirectionalUrl);
    }

}