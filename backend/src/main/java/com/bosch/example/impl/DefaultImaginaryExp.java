package com.bosch.example.impl;

import com.bosch.example.dto.ResultImaginaryExp;
import com.bosch.example.services.ImaginaryExpService;
import java.lang.Math;

public class DefaultImaginaryExp implements ImaginaryExpService{
    @Override
    public ResultImaginaryExp calculate(Double A, Double b) {
        Double re = A * (Math.sin(b));
        Double im = A * (Math.cos(b));
        System.out.println(re);
        System.out.println(im);
        return new ResultImaginaryExp(re, im);
    }

    
}
