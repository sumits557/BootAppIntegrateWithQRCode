package com.org.quickresponse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QuickresponseApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("Successfully runs the initial test.");
    }

    @Test
    void testPositoningOfStringOutput() {
        String impbBarcode = "V_1234567FG7890FGHMqwerfg707";
        String result = logic(impbBarcode);
        assertEquals("34567", result);
    }

    @Test
    void testOutputIsDigit() {
        String impbBarcode = "V_1234Q67FG7890FGHMqwerfg707";
        String result = logic(impbBarcode);
        assertEquals("Zipcode should be 5 digit", result);
    }

    private String logic(String impbBarcode) {
        String str = impbBarcode.trim();
        String zipcode = "";
        for (int i = 4; i <= 9; i++) {
            char chrs = str.charAt(i);
            if (Character.isDigit(chrs)) {
                zipcode = zipcode + chrs;
            }
        }
        if (zipcode.length() == 5) {
            return zipcode;
        } else return "Zipcode should be 5 digit";
    }

}
