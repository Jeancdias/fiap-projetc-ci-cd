package br.com.fiap.SpringBootContatos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_preferencias_usuario")
public class PreferenciasUsuario {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tbl_preferencias_usuario_seq")
    @SequenceGenerator(
            name = "tbl_preferencias_usuario_seq",
            sequenceName = "tbl_preferencias_usuario_seq",
            allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Contato usuario;

    @Column(name = "cor_tema")
    private String corTema;

    @Column(name = "notificacoes_email")
    private boolean notificacoesEmail;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contato getUsuario() {
        return usuario;
    }

    public void setUsuario(Contato usuario) {
        this.usuario = usuario;
    }

    public String getCorTema() {
        return corTema;
    }

    public void setCorTema(String corTema) {
        this.corTema = corTema;
    }

    public boolean isNotificacoesEmail() {
        return notificacoesEmail;
    }

    public void setNotificacoesEmail(boolean notificacoesEmail) {
        this.notificacoesEmail = notificacoesEmail;
    }
}
