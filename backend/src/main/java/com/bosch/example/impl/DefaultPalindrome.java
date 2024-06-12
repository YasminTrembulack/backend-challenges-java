package com.bosch.example.impl;

import com.bosch.example.dto.PalindromeResult;
import com.bosch.example.services.PalindromeService;

public class DefaultPalindrome implements PalindromeService{
    @Override
    public PalindromeResult isPlaindrome(String word){
        
        if (word == null)
			return new PalindromeResult(word, false);

		String reverseString = "";

		for (int i = word.length() - 1; i >= 0; i--) {

			reverseString = reverseString + word.charAt(i);
		}

        if(word.equals(reverseString))
            return new PalindromeResult(word, true);
        
        return new PalindromeResult(reverseString, false);
    }
}
