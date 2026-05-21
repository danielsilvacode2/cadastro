package danielsilvacode2.cadastro.usuario.controler.mapper;

import danielsilvacode2.cadastro.usuario.Usuario;
import danielsilvacode2.cadastro.usuario.controler.dto.UsuarioDto;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {


    public  Usuario toEntity(UsuarioDto dto) {

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setEstado(dto.estado());
        usuario.setCidade(dto.cidade());

        return usuario;
    }

    public  UsuarioDto toDto(Usuario usuario) {
        UsuarioDto dto = new UsuarioDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getEstado(),
                usuario.getCidade(),
                usuario.getProtocolo());

        return dto;
    }

}
