package edu.icet.ElecBilling.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CustomerService {
    ResponseEntity<String>signUp(Map<String,String> requestMap);
}
