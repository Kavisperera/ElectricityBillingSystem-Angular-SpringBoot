package edu.icet.ElecBilling.JWT;

import edu.icet.ElecBilling.dao.CustomerDao;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    CustomerDao customerDao;

    @Getter
    private edu.icet.ElecBilling.POJO.Customer customerDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername {}",username);
        customerDetail = customerDao.findByEmailId(username);
        if(!Objects.isNull(customerDetail))
            return new User(customerDetail.getEmail(),customerDetail.getPassword(),new ArrayList<>());
        else
            throw new UsernameNotFoundException("Customer not found.");
    }
}
