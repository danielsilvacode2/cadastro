package danielsilvacode2.cadastro.usuario.service;

import danielsilvacode2.cadastro.common.exceptions.RegistroDuplicadoException;
import danielsilvacode2.cadastro.usuario.Usuario;
import danielsilvacode2.cadastro.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UsuarioValidation {

    private final UsuarioRepository repository;

    public void validar(Usuario usuario){
        if(validarAux(usuario)){
            throw new RegistroDuplicadoException("Já existe uma conta cadastrada com este e-mail.");
        }
    }

    private boolean validarAux(Usuario usuario){

        Optional<Usuario> possivelUsuario = repository.findByEmail(usuario.getEmail());

        if(possivelUsuario.isEmpty()){
            return false;
        }

        Usuario usuarioEncontrado = possivelUsuario.get();

        return !usuario.getId().equals(usuarioEncontrado.getId());
    }
}
