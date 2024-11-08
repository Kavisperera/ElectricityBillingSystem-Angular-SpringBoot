package edu.icet.ElecBilling.dao;

import edu.icet.ElecBilling.POJO.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

     Customer findByEmailId(@Param("email") String email);

}
