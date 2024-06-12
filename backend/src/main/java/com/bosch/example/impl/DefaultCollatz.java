package com.bosch.example.impl;

import com.bosch.example.dto.CollatzResult;
import com.bosch.example.services.CollatzService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DefaultCollatz implements CollatzService {
    @Override
    public CollatzResult calculate(int current, int step) {
        if (current < 0 || step < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "");

            int alter_num = current;

        for(int i = 0; i < step;i++){
            if (alter_num % 2 == 0) {
                alter_num = alter_num / 2;
            } else {
                alter_num = (alter_num * 3) + 1;
            }
        }

        return new CollatzResult(alter_num);
    }

}
