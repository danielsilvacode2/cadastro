package danielsilvacode2.cadastro.common;

import java.util.List;

public record ErroRespostaDto(int status, String mensagem, List<ErroCampoDto> erroCampo) {
}
