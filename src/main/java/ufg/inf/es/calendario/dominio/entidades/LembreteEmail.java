package ufg.inf.es.calendario.dominio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Aluno: Breno de Melo Gomes e Augusto Borges de moura
 * Versão: 1.0
 * Data de Criação: 13/11/2017
 * Copyright (c) 2017 UFG - www.ufg.br
 * Todos os direitos reservados.
 * Esta classe tem o propósito de ser a classe que abstrai o lebrete de um email
 */

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

    /**
     * Lembra o email especificado na intância do objeto.
     */
    void lembrar() {
        System.out.println("Lembrando email: " + emailAlvo);
    }

    /**
     * retorna o email da instância da classe LembreteEmail.
     *
     * @return string - contendo o emailAlvo da instancia LembreteEmail que chama a função.
     */
    public String getEmailAlvo() {
        return emailAlvo;
    }

    /**
     * Altera o emailAlvo da instância da classe LembreteEmail.
     *
     * @param emailAlvo Endereço de email a ser definido como email alvo do lembrete.
     */
    public void setEmailAlvo(String emailAlvo) {
        this.emailAlvo = emailAlvo;
    }

    /**
     * Retorna o mesagem da instância da classe LembreteEmail.
     *
     * @return string - contendo a mensagem da instancia LembreteEmail que chama a função.
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * Altera a mensagem da instância da classe LembreteEmail.
     *
     * @param mensagem Texto de mensagem a ser definida como mensagem do lembrete.
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * retorna o id da instância da classe LembreteEmail.
     *
     * @return Id do LembreteEmail.
     */
    public Long getId() {
        return id;
    }

    /**
     * retorna o evento da instância da classe LembreteEmail.
     *
     * @return Evento da instancia LembreteEmail.
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * Altera o evento da instância da classe LembreteEmail.
     *
     * @param evento Evento a ser definido no lembrete.
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * Altera o id da instância da classe LembreteEmail.
     *
     * @param id Id a ser definido no lembrete.
     */
    public void setId(Long id) {
        this.id = id;
    }
}
