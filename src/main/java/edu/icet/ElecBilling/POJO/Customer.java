package edu.icet.ElecBilling.POJO;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@NamedQuery(name ="Customer.findByEmailId",query = "select u from Customer u where u.email=:email" )

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="Customer")
public class Customer implements Serializable {

    private static final long serialVersionCID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="contactNumber")
    private String contactNumber;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="active")
    private String active;

    @Column(name="accountType")
    private String  accountType;

}
