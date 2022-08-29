package uz.isystem.AsaxiyUz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;
    @NotNull(message = ("Ism noto'g'ri"))
    @Size(min = 5,max = 15,message = ("Ism kamida 5 ta harfdan iborat bo'lishi kerak"))
    private String name;
    @NotBlank(message = ("Familiya noto'g'ri"))
    @Size(min = 5,max = 15,message = ("Familiyasi kamida 5 ta harfdan iborat bo'lishi kerak"))
    private String surname;
    @NotBlank(message = ("Address ni kiriting"))
    @Size(min = 10,max = 15,message = ("Kamida 10 ta belgidan iborat bo'lsin"))
    private String address;
    private String countryOfOrigin;
    @NotEmpty
    @NotNull(message = ("Emailni kiriting"))
    private String email;
    @NotEmpty
    @NotNull(message = ("Raqamni to'g'ri kiriting"))
    @Size(min = 12,max = 13,message = ("Raqamni to'g'ri kirit 12-13 oralig'ida"))
    private String phone;
    @NotNull(message = ("Age ni kiriting"))
    private Integer age;
    private Boolean hired;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
