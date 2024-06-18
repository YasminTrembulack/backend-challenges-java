package com.bosch.example.impl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Utf8;

import com.bosch.example.JWTService;
import com.bosch.example.services.SignatureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class DefaultJWTService<T> implements JWTService<T>{

    @Autowired
    SignatureService signatureService;

    @Override
    public String get(T obj) {
        try {
            ObjectWriter ow = new ObjectMapper()
                .writer()
                .withDefaultPrettyPrinter();
            
            String json = ow.writeValueAsString(obj);
            String base64Json = Base64.getEncoder().encodeToString(
                json.getBytes(StandardCharsets.UTF_8)
            );

            String header = "{ \"alg\": \"RS256\", \"typ\": \"JWT\" }";
            String base64Header = Base64.getEncoder().encodeToString(
                header.getBytes(StandardCharsets.UTF_8)
            );

            String signature = signatureService.sign(
                base64Header + "." + base64Json
            );

            return base64Header + "." + base64Json + "." + signature;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> validate(String jwt) {
        var parts = jwt.split("\\.");
        var header = parts[0];
        var payload = parts[1];
        var signature = parts[2];

        if (!signatureService.verify(header + "." + payload, signature)) 
            return null;
        
        try 
        {
            var json = Utf8.decode(
                Base64.getDecoder().decode(payload)
            );
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(json, Map.class);
            return map;
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        
    }
    
}
