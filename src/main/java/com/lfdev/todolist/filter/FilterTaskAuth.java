package com.lfdev.todolist.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.lfdev.todolist.user.IUserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var servletPath = request.getServletPath();

        if(servletPath.startsWith("/tasks/")){
            // Get the auth (user and password)
            var authorization = request.getHeader("Authorization");

            // Remove the word Basic and whitespaces (trim) from the authorization
            var authEncoded = authorization.substring("Basic".length()).trim();

            //Decode base64
            byte[] authDecode = Base64.getDecoder().decode(authEncoded);
            var authString = new String(authDecode);
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            // Validate user
            var user = this.userRepository.findByUsername(username);
            if (user == null) {
                response.sendError(401);
            } else {
                //Validate password
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if(passwordVerify.verified) {
                    //If everything is fine, GO AHEAD

                    // Add the user ID to the request
                    request.setAttribute("idUser", user.getId());
                    //Go ahead to the controller
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }
            }

        } else {
            // Go ahead
            filterChain.doFilter(request, response);
        }


    }
}

