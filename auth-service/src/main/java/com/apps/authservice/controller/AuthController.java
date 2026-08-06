package com.apps.authservice.controller;

import com.apps.authservice.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/api/auth/login")
    public String login() {
        return "redirect:/oauth2/authorization/google";
    }

    @GetMapping("/api/auth/callback")
    public String callback() {
        return "Google Login Successful";
    }

    // UC21 UPDATE
    // Called by operation-service (via OpenFeign) on every request that
    // carries a Bearer token, to confirm it's genuine before honoring it.
    // @ResponseBody is required here specifically because this class is
    // @Controller (not @RestController) — login()/callback() above rely
    // on their String return values being treated as view/redirect
    // directives, so the class-level annotation has to stay @Controller.

    @GetMapping("/api/auth/validate")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> validate(
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader
    ) {

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body(Map.of("valid", false));
        }

        String token = authorizationHeader.substring(7);

        try {
            String email = jwtService.extractUsername(token);
            return ResponseEntity.ok(Map.of("valid", true, "email", email));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("valid", false));
        }
    }
}