package pe.com.easyjobs.accountsapi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {
    @Column(unique = true, length = 40)
    private String phoneNumber;
    @Column(unique = true, length = 200)
    private String firstName;
    @Column(unique = true, length = 200)
    private String lastName;
    @Column(unique = true, length = 200)
    private String address;
    @Column(unique = true, length = 200)
    private String city;
    @Column(unique = true, length = 200)
    private String district;
    @Column(unique = true, length = 200)
    private String gender;
}
