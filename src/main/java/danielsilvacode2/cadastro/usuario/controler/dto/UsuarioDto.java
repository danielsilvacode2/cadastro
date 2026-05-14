package danielsilvacode2.cadastro.usuario.controler.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UsuarioDto(


        String id,
        @NotBlank(message = "campo obrigatorio")
        @Size(min = 2, max = 150, message = "campo fora do tamanho")
        String nome,
        @NotBlank(message = "campo obrigatorio")
        @Email(message = "formato de email invalido")
        @Size(min = 2, max = 150, message = "campo fora do tamanho")
        String email,

        @NotBlank(message = "campo obrigatorio")
        @Pattern(

                regexp =
                        "AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO",

                message =
                        "UF inválida"
        )
        @Size(min = 2, max = 2, message = "campo fora do tamanho")
        String estado,
        @NotBlank(message = "campo obrigatorio")
        @Size(min = 2, max = 50, message = "campo fora do tamanho")
        String cidade,
        String protocolo

) {
}
