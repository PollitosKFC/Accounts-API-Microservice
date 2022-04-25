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
    private Long phoneNumber_n;

    @NotNull
    @Column(unique = true, length = 200)
    private String firstName_n;

    @NotNull
    @Column(unique = true, length = 200)
    private String lastName_n;

    @NotNull
    @Column(unique = true, length = 200)
    private String address_n;

    @NotNull
    @Column(unique = true, length = 200)
    private String city_n;

    @NotNull
    @Column(unique = true, length = 200)
    private String district_n;

    @NotNull
    @Column(unique = true, length = 200)
    private String gender_n;
}
