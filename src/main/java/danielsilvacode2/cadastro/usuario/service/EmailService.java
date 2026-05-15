package danielsilvacode2.cadastro.usuario.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void enviar(String destinario, String assunto, String procolo, String nome){


        String corpo = "Olá "
                + nome
                + " seu cadastro foi realizado com sucesso o seu protocolo de atendimento é ( "
                + procolo
                + " ) logo mais entraremos em contato.";

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(destinario);
        msg.setSubject(assunto);
        msg.setText(corpo);

        mailSender.send(msg);

    }


}
