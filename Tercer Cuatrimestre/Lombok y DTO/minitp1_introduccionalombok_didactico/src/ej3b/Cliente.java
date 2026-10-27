package ej3b;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
@EqualsAndHashCode(of = "id")
public class Cliente {
    private Long id;
    private String nombre;
    private String email;
    private String password;
}