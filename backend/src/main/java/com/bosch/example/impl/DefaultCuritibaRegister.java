package com.bosch.example.impl;

// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.net.HttpURLConnection;
// import java.net.URL;

import com.bosch.example.services.CEPValidatorService;
import com.bosch.example.services.CPFValidatorService;

public class DefaultCuritibaRegister implements CPFValidatorService, CEPValidatorService{
    @Override
    public Boolean validateCPF(String cpf) {
        return true;
    }

    @Override
    public Boolean validateCEP(String cep) {
        // String enderecoURL = "https://viacep.com.br/ws/" + cep + "/json/";
        // try {
        //     @SuppressWarnings("deprecation")
        //     URL url = new URL(enderecoURL);
        //     HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        //     if (conexao.getResponseCode() == 200)
        //         return true;
        //     return false;
        // } catch (Exception e) {
        //     throw new Exception("ERRO: " + e);
        // }
        return true;
    }


}
