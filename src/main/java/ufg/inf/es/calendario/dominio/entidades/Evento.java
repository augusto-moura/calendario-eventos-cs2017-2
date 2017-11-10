package ufg.inf.es.calendario.dominio.entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Evento {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;

    private String descricao;

    private Date data;

    @ManyToOne
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evento", cascade = CascadeType.ALL)
    private Set<LembreteEmail> lembreteEmails;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Set<LembreteEmail> getLembreteEmails() {
        return lembreteEmails;
    }

    public void setLembreteEmails(Set<LembreteEmail> lembreteEmails) {
        this.lembreteEmails = lembreteEmails;
    }
}
