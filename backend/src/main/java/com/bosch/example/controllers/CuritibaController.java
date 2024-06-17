package com.bosch.example.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.CuritibaRegister;
import com.bosch.example.dto.CuritibaRegisterResult;
import com.bosch.example.services.CPFValidatorService;
import com.bosch.example.services.CityValidatorService;

@RestController
public class CuritibaController {
    @Autowired
	private CityValidatorService cepService;

	@Autowired
	private CPFValidatorService cpfService;
    
    @GetMapping("curitiba")
    public CuritibaRegisterResult validate(CuritibaRegister input){
        
        ArrayList<String> messages = new ArrayList<>();

        if (input.cep() == null || input.cep().length() != 8 || !isNumeric(input.cep())) {
            messages.add("cep is not valid.");
        }
        else if (!cepService.validate(input.cep(), "Curitiba")) {
            messages.add("The cef is not from Curitiba.");
        }

        String cpf =
            input.cpf() == null ? "" :
            input.cpf()
                .replace(".", "")
                .replace("-", "");
        if (!cpfService.validare(cpf)) {
            messages.add("cpf is not valid.");
        }

        if (messages.size() == 0) {
            return new CuritibaRegisterResult(true,
            "cpf and cep are both valid and cep is from Curitiba.");
        }

        String msg = "";
        for (var m : messages) {
            msg += m + "\n";
        }

        return new CuritibaRegisterResult(false, msg);
    }

    boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}

		try {
			Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}

		return true;
	} 
    
}
