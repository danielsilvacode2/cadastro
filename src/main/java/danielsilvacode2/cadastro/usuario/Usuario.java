package danielsilvacode2.cadastro.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Setter
@Getter
@NoArgsConstructor
public class Usuario {


    @Id
    @Column
    private String id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "estado")
    private String estado;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "protocolo_atendimento")
    private String protocolo;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}
