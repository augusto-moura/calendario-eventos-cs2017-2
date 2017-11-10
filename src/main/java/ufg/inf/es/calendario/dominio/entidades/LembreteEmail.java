package ufg.inf.es.calendario.dominio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.*;

@Entity
public class LembreteEmail {

    @Id
    @GeneratedValue
    private Long id;

    private String mensagem;

    private String emailAlvo;

    @ManyToOne
    @JsonIgnore
    private Evento evento;

    void lembrar() {
        System.out.println("Lembrando email: " + emailAlvo);
    }

    public String getEmailAlvo() {
        return emailAlvo;
    }

    public void setEmailAlvo(String emailAlvo) {
        this.emailAlvo = emailAlvo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getId() {
        return id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
