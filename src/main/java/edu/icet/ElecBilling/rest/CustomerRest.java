package edu.icet.ElecBilling.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(path = "/customer")
public interface CustomerRest {
    @PostMapping(path ="/signUp" )
    public ResponseEntity<String> signUp(@RequestBody(required = true)Map<String,String> requestMap);
}
