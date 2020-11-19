package pl.arekbednarz.oddajwdobrerece.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {


    @NotNull
    String name;

    @NotNull
    String surname;

    @NotNull
    String email;

    @NotNull
    String password1;

    @NotNull
    String password2;

}