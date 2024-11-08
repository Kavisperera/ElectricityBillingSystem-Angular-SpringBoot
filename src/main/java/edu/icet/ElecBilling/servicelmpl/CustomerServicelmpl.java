package edu.icet.ElecBilling.servicelmpl;

import edu.icet.ElecBilling.POJO.Customer;
import edu.icet.ElecBilling.constents.ElecBillingConstents;
import edu.icet.ElecBilling.dao.CustomerDao;
import edu.icet.ElecBilling.service.CustomerService;
import edu.icet.ElecBilling.utils.ElecBillingUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class CustomerServicelmpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signUp {}", requestMap);
        try {
            if (validateSignUpMap(requestMap)) {
                Customer customer = customerDao.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(customer)) {
                    customerDao.save(getCustomerFromMap(requestMap));
                    return ElecBillingUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);
                } else {
                    return ElecBillingUtils.getResponseEntity("Email already exists.", HttpStatus.BAD_REQUEST);
                }
            } else {
                return ElecBillingUtils.getResponseEntity(ElecBillingConstents.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ElecBillingUtils.getResponseEntity(ElecBillingConstents.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateSignUpMap(Map<String,String> requestMap){
      if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("password"))
      {
          return true;
      }
      return false;
    }

    private Customer getCustomerFromMap(Map<String,String> requestMap){
        Customer customer = new Customer();
        customer.setName(requestMap.get("name"));
        customer.setContactNumber(requestMap.get("contactNumber"));
        customer.setEmail(requestMap.get("email"));
        customer.setPassword(requestMap.get("password"));
        customer.setActive("false");
        customer.setAccountType("residential");
        return customer;
    }
}
