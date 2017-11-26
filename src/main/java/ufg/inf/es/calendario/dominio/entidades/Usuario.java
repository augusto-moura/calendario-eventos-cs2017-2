package ufg.inf.es.calendario.dominio.entidades;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Aluno: Breno de Melo Gomes e Augusto Borges de moura
 * Versão: 1.0
 * Data de Criação: 13/11/2017
 * Copyright (c) 2017 UFG - www.ufg.br
 * Todos os direitos reservados.
 * <p>
 * Esta classe tem o propósito de ser a classe que abstrai o usuário.
 */

@Entity
public class Usuario extends User {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Evento> eventos;

    private String email;

    /**
     * Cria novo usuário a partir de um nome, senha e autoridades.
     *
     * @param username Nome do usuário, deve ser único
     * @param password Senha do usuário
     * @param authorities Autoridades do usuário
     */
    public Usuario(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    @Override
    public String toString() {
        return "Usuario{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", eventos=" + eventos +
            ", email='" + email + '\'' +
            '}';
    }

    /**
     * Retorna o nome do usuário.
     *
     * @return Nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * altera o nome da instância da classe usuario.
     *
     * @param nome Nome a substituir o nome atual do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna os eventos do usuário.
     *
     * @return Eventos os quais o usuário é responsável.
     */
    public Set<Evento> getEventos() {
        return eventos;
    }

    /**
     * Retorna o ID atual do usuário.
     *
     * @return Identificador do usuário.
     */
    public Long getId() {
        return id;
    }

    /**
     * Altera o ID do usuário.
     *
     * @param id ID a ser setado como do usuário.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Altera os eventos do usuário.
     *
     * @param eventos Eventos a serem definidos como do usuário.
     */
    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    /**
     * Retorna o email atual do usuário.
     *
     * @return Email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Altera o email do usuário.
     *
     * @param email Email a ser definido como email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
