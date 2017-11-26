package ufg.inf.es.calendario.dominio.entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Aluno: Breno de Melo Gomes e Augusto Borges de moura
 * Versão: 1.0
 * Data de Criação: 13/11/2017
 * Copyright (c) 2017 UFG - www.ufg.br
 * Todos os direitos reservados.
 * <p>
 * Esta classe tem o propósito de ser a classe que abstrai o evento.
 */

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

    @Override
    public String toString() {
        return "Evento{" +
            "id=" + id +
            ", titulo='" + titulo + '\'' +
            ", descricao='" + descricao + '\'' +
            ", data=" + data +
            ", usuario=" + usuario +
            ", lembreteEmails=" + lembreteEmails +
            '}';
    }

    /**
     * Retorna o titulo da instância da classe evento.
     *
     * @return Titulo da instancia evento que chama a função.
     */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Retorna o id da instância da classe evento.
     *
     * @return Id da instancia evento que chama a função.
     */
    public Long getId() {
        return id;
    }

    /**
     * altera o id da instância da classe Evento.
     *
     * @param id Id do objeto.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * retorna o id da instância da classe evento.
     *
     * @return Usuario da instancia evento que chama a função.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * altera o usuário do instância da classe Evento.
     *
     * @param usuario Usuario responsável pelo evento.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * retorna a descrição do instância da classe evento.
     *
     * @return Descrição do evento.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * altera a descrição da instância da classe Evento.
     *
     * @param descricao Texto a ser definido como descrição do evento.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * retorna a data do instância da classe evento.
     *
     * @return Data à acontecer o evento.
     */
    public Date getData() {
        return data;
    }

    /**
     * Altera a data do instância da classe evento.
     *
     * @param data Data a ser definida para o evento.
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * retorna o lembrete da instância da classe evento.
     *
     * @return Lembretes definidos para o evento.
     */
    public Set<LembreteEmail> getLembreteEmails() {
        return lembreteEmails;
    }

    /**
     * Altera o lebrete da instância da classe evento.
     *
     * @param lembreteEmails Lembretes que substituírão os lembretes atuais do evento.
     */
    public void setLembreteEmails(Set<LembreteEmail> lembreteEmails) {
        this.lembreteEmails = lembreteEmails;
    }
}
