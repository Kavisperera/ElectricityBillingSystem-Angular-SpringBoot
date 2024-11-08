package edu.icet.ElecBilling.restlmpl;

import edu.icet.ElecBilling.constents.ElecBillingConstents;
import edu.icet.ElecBilling.rest.CustomerRest;
import edu.icet.ElecBilling.service.CustomerService;
import edu.icet.ElecBilling.utils.ElecBillingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CustomerRestImpl implements CustomerRest {

    @Autowired
    CustomerService customerService;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
             return customerService.signUp( requestMap );
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ElecBillingUtils.getResponseEntity(ElecBillingConstents.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
