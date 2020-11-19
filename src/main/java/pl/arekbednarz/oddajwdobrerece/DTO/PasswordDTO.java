package pl.arekbednarz.oddajwdobrerece.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class PasswordDTO {


    @NotNull
    String password;


    @NotNull
    String passwordRepeat;
}