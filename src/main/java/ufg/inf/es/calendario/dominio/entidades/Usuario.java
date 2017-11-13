package ufg.inf.es.calendario.dominio.entidades;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Aluno: Breno de Melo Gomes e Augusto Borges de moura
 * Versão: <1.0>
 * Data de Criação: 13/11/2017
 * Copyright (c) 2017 UFG - www.ufg.br
 * Todos os direitos reservados.
 *
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
    * cria um objeto da classe usuário, que extende a classe GrantedAuthority
    *
    * @param String username, String password, Collection<? extends GrantedAuthority 
    * @return null - não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public Usuario(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public Usuario(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    /**
    * retorna o titulo da instância da classe usuario.
    *
    * @param null - não há parametros.
    * @return string - contendo o nome da instancia usuario que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public String getNome() {
        return nome;
    }

    /**
    * altera o nome da instância da classe usuario.
    *
    * @param string - string com o titulo do objeto.
    * @return null - Não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
    * retorna o evento da instância da classe usuario.
    *
    * @param null - não há parametros.
    * @return Evento - contendo o evento da instancia usuario que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public Set<Evento> getEventos() {
        return eventos;
    }
    
    /**
    * retorna o id da instância da classe usuario.
    *
    * @param null - não há parametros.
    * @return Evento - contendo o nome da instancia usuario que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public Long getId() {
        return id;
    }

    /**
    * altera o id da instância da classe usuario.
    *
    * @param long - long com o id do objeto.
    * @return null - Não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    * altera o Evento da instância da classe usuario.
    *
    * @param Evento - evento do objeto.
    * @return null - Não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    /**
    * retorna o email da instância da classe usuário.
    *
    * @param null - não há parametros.
    * @return string - contendo o email da instancia usuario que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public String getEmail() {
        return email;
    }

    /**
    * altera o Email da instância da classe Evento.
    *
    * @param string - email do usuário.
    * @return null - Não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setEmail(String email) {
        this.email = email;
    }

}
