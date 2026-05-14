package danielsilvacode2.cadastro.usuario.service;


import danielsilvacode2.cadastro.usuario.Usuario;
import danielsilvacode2.cadastro.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {


    private final UsuarioRepository repository;
    private final UsuarioValidation validation;


    public void salvar(Usuario usuario) {


        validation.validar(usuario);

        String protocolo = gerarProtocolo(usuario.getId().toString());

        usuario.setProtocolo(protocolo);

        usuario.setDataCriacao(LocalDateTime.now());

        repository.save(usuario);

    }

    private String gerarProtocolo(String uuid) {

        String ultimosDigitosUUID =
                uuid.substring(
                        uuid
                                .length() - 4);

        String data = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("yyyy/MM/dd"));


        String protocolo = "ATD" + "-" + data + "-" + ultimosDigitosUUID;

        return protocolo;
    }


    public Optional<Usuario> buscarPorId(String id){
        Optional<Usuario> usuario = repository.findById(id);
        return  usuario;
    }

}
