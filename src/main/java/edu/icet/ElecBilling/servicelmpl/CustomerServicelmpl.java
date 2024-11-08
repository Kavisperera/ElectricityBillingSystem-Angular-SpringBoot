package edu.icet.ElecBilling.servicelmpl;

import edu.icet.ElecBilling.constents.ElecBillingConstents;
import edu.icet.ElecBilling.service.CustomerService;
import edu.icet.ElecBilling.utils.ElecBillingUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class CustomerServicelmpl implements CustomerService {
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signUp {}",requestMap);
        if (validateSignUpMap(requestMap)){

        }
        else{
            return ElecBillingUtils.getResponseEntity(ElecBillingConstents.INVALID_DATA, HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    private boolean validateSignUpMap(Map<String,String> requestMap){
      if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("password"))
      {
          return true;
      }
      return false;
    }
}
