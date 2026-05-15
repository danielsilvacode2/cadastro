package danielsilvacode2.cadastro.common.dto;

import java.util.List;

public record ErroRespostaDto(int status, String mensagem, List<ErroCampoDto> erroCampo) {
}
