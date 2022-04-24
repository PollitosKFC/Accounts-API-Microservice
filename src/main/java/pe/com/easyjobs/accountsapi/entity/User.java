package pe.com.easyjobs.accountsapi.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(unique = true, length = 200)
    private String userName;
    @Column(unique = true, length = 250)
    private String password;
    @Column(unique = true, length = 250)
    private String email;
    @Column(unique = true, length = 50)
    private String type;
    @Column(unique = true, length = 200)
    private String identificationType;
    @Column(unique = true)
    private int identificationNumber;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

}