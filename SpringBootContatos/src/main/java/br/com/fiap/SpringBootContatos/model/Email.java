package br.com.fiap.SpringBootContatos.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_emails")
public class Email {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tbl_email_seq"
    )
    @SequenceGenerator(
            name = "tbl_email_seq",
            sequenceName = "tbl_email_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "enviar_para")
    private String to;

    @Column(name = "enviar_de")
    private String from;

    @Column(name = "assunto")
    private String subject;

    private String body;

    @Column(name = "dt_envio")
    private LocalDateTime dt_envio;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getSentAt() {
        return dt_envio;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.dt_envio = sentAt;
    }
}

