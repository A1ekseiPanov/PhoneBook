package com.example.phonebook.security;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistrationForm {

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
    @Pattern(regexp ="^([А-Я][а-я]+|[A-Z][a-z]+)",
            message = "Имя должно начинается с заглавной буквы, далее строчные. Либо только английскими буквами, либо русскими")
    private String name;


    @NotEmpty(message = "Поле фамилия не должно быть пустым")
    @Size(min = 2, message = "Имя должен содержать не меньше 2 символов")
    @Pattern(regexp ="^([А-Я][а-я]+|[A-Z][a-z]+)",
            message = "Фамилия должна начинается с заглавной буквы, далее строчные. Либо только английскими буквами, либо русскими")
    private String surname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Поле день рождение не должно быть пустым")//дд/мм/гггг
    private Date dateOfBirthday;


    private String confirm;


    @Email(message = "Адрес электронной почты должен быть валидным")
    @NotEmpty(message = "Поле электронная почта не должно быть пустым")
    private String email;

    public User toUser() {
        return new User(
                username, password,
                name, surname, dateOfBirthday, email);
    }
}

