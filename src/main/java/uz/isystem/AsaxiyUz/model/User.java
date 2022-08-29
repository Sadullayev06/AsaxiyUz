package uz.isystem.AsaxiyUz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String address;
    private String countryOfOrigin;
    private String email;
    private String phone;
    private Integer age;
    private Boolean hired;
    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
