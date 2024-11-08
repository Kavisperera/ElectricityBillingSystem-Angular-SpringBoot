package edu.icet.ElecBilling.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ElecBillingUtils {

    private ElecBillingUtils(){

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
    }
}
