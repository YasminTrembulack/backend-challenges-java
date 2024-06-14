package com.bosch.example.impl;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import com.bosch.example.services.CEPValidatorService;
import com.bosch.example.services.CPFValidatorService;

public class DefaultCuritibaRegister implements CPFValidatorService, CEPValidatorService {
    @Override
    public Boolean validateCPF(String cpf) {
        return true;
    }

    @Override
    public Boolean validateCEP(String cep){
        try {
            String enderecoURL = "https://viacep.com.br/ws/" + cep + "/json/";
            URL url = new URI(enderecoURL).toURL();
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setDoInput(true);
    
            int responseCode = conexao.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            // Em caso de erro, imprime a mensagem de erro e retorna false
            System.out.println("Erro ao validar CEP: " + e.getMessage());
            return false;
        }
    }

}
