package com.bosch.example.impl;

import com.bosch.example.dto.ReverseResult;
import com.bosch.example.services.Plaindrome;

public class DefaultPlaindrome implements Plaindrome{
    @Override
    public ReverseResult isPlaindrome(String word){
        
        if (word == null)
			return new ReverseResult(word, false);

		String reverseString = "";

		for (int i = word.length() - 1; i >= 0; i--) {

			reverseString = reverseString + word.charAt(i);
		}

        if(word.equals(reverseString))
            return new ReverseResult(word, true);
        
        return new ReverseResult(reverseString, false);
    }
}
