package danielsilvacode2.cadastro.usuario.controler;


import danielsilvacode2.cadastro.common.dto.ErroRespostaDto;
import danielsilvacode2.cadastro.usuario.Usuario;
import danielsilvacode2.cadastro.usuario.controler.dto.UsuarioDto;
import danielsilvacode2.cadastro.usuario.controler.dto.UsuarioMapper;
import danielsilvacode2.cadastro.usuario.service.EmailService;
import danielsilvacode2.cadastro.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController()
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioControler {

    private final UsuarioService service;
    private final UsuarioMapper mapper;
    private final EmailService emailService;


    @PostMapping
    public ResponseEntity<UsuarioDto> salvar(@Valid @RequestBody UsuarioDto dtoRequest) {

        Usuario usuario = mapper.toEntity(dtoRequest);
        usuario.setId(UUID.randomUUID().toString());
        service.salvar(usuario);



        emailService.enviar(usuario.getEmail(),"Protocolo de Atendimento", usuario.getProtocolo(), usuario.getNome());

        UsuarioDto dtoResponse = mapper.toDto(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(dtoResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> buscar(@PathVariable("id") String id) {
        Optional<Usuario> possivelUsuario = service.buscarPorId(id);

        if (possivelUsuario.isEmpty()) {
            ErroRespostaDto erroRespostaDto = new ErroRespostaDto(
                    HttpStatus.NOT_FOUND.value(),
                    "usuario nao encontrado",
                    List.of());
            return ResponseEntity.status(erroRespostaDto.status()).body(erroRespostaDto);
        }

        Usuario usuario = possivelUsuario.get();
        UsuarioDto dto = mapper.toDto(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(dto);

    }
}
