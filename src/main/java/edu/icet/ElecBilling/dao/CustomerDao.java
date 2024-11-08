package edu.icet.ElecBilling.dao;

import edu.icet.ElecBilling.POJO.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {


}
