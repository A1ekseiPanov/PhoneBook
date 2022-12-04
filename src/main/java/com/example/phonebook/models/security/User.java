package com.example.phonebook.models.security;

import com.example.phonebook.models.BaseEntity;
import com.example.phonebook.models.Person.Person;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;


@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity implements UserDetails  {

    @NotEmpty(message = "Поле логин не должно быть пустым")
    @Size(min = 2, max = 30, message = "Логин должен содержать от 2 до 30 символов")
    private String username;

    @NotEmpty(message = "Поле пароль не должно быть пустым")
    @Size(min = 5, message = "Пароль должен быть не меньше 5 символов")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[а-яa-z])(?=.*[А-ЯA-Z])(?!.*\\s).*$",
            message ="Пароль должен содержать строчные и прописные латинские буквы, цифры" )
    private String password;

    @NotEmpty(message = "Поле имя не должно быть пустым")
    @Size(min = 2, message = "Имя должен содержать не меньше 2 символов")
    @Pattern(regexp ="^([А-ЯA-Z][а-яa-z]+)",
            message = "Имя должно начинается с заглавной буквы и не должно содержать сторонние символы")
    private String name;


    @NotEmpty(message = "Поле фамилия не должно быть пустым")
    @Size(min = 2, message = "Имя должен содержать не меньше 2 символов")
    @Pattern(regexp ="^([А-ЯA-Z][а-яa-z]+)",
            message = "Фамилия должна начинается с заглавной буквы и не должна содержать сторонние символы")
    private String surname;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Поле день рождение не должно быть пустым")//дд/мм/гггг
    private Date dateOfBirthday;


    @Email(message = "Адрес электронной почты должен быть валидным")
    @NotEmpty(message = "Поле электронная почта не должно быть пустым")
    private String email;

    @Transient
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Person> persons;


    public User(String username, String password, String name, String surname, Date dateOfBirthday, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateOfBirthday = dateOfBirthday;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Collections.singletonList(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
