package ua.com.alevel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Iehor Funtusov, created 11/12/2020 - 8:52 PM
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USERNAME")
    private String userName;
}
