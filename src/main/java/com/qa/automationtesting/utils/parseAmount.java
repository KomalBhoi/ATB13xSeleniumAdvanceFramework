package com.qa.automationtesting.utils;

public class parseAmount {

    public double parseAmount(String amount){

        String cleanedTxt = amount.replace("+","")
                .replace("-","")
                .replace("USD","")
                .replace(",","")
                .trim();

        double amt = Double.parseDouble(cleanedTxt);
        return amt;
    }
}
