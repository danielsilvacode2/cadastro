package danielsilvacode2.cadastro.common;

import danielsilvacode2.cadastro.common.exceptions.RegistroDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExpecetionHandler {


    @ExceptionHandler(RegistroDuplicadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErroRespostaDto> RegistroDuplicadoExceptionHandler(RegistroDuplicadoException e) {

        ErroRespostaDto dto = new ErroRespostaDto(HttpStatus.CONFLICT.value(), e.getMessage(), List.of());

        return ResponseEntity.status(dto.status()).body(dto);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErroRespostaDto> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {

        List<FieldError> fieldErrors = e.getFieldErrors();

        List<ErroCampoDto> collect = fieldErrors
                .stream()
                .map(fieldError -> new ErroCampoDto(fieldError.getField(), fieldError.getDefaultMessage()))
                .toList();

        ErroRespostaDto dto = new ErroRespostaDto(HttpStatus.BAD_REQUEST.value(), "preencha todos os campos de forma correta",collect);

        return ResponseEntity.status(dto.status()).body(dto);

    }



}
