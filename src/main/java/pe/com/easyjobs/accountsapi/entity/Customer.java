package pe.com.easyjobs.accountsapi.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_customer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Customer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true, length = 40)
    private Long phoneNumber;

    @NotNull
    @Column(unique = true, length = 200)
    private String firstName;

    @NotNull
    @Column(unique = true, length = 200)
    private String lastName;

    @NotNull
    @Column(unique = true, length = 200)
    private String address;

    @NotNull
    @Column(unique = true, length = 200)
    private String city;

    @NotNull
    @Column(unique = true, length = 200)
    private String district;

    @NotNull
    @Column(unique = true, length = 200)
    private String gender;
}
