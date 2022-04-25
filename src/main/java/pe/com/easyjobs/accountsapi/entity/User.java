package pe.com.easyjobs.accountsapi.entity;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;



@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true, length = 200)
    private String userName_n;

    @NotNull
    @Column(unique = true, length = 250)
    private String password_n;

    @NotNull
    @Column(unique = true, length = 250)
    private String email_n;

    @NotNull
    @Column(unique = true, length = 50)
    private String type_n;

    @NotNull
    @Column(unique = true, length = 200)
    private String identificationType_n;

    @NotNull
    @Column()
    private int identificationNumber_n;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(unique = true)
    private Date registerDate_n;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(unique = true)
    private Date updatedDate_n;

}