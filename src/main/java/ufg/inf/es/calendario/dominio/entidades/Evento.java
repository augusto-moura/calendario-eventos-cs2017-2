package ufg.inf.es.calendario.dominio.entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
/**
 * Aluno: Breno de Melo Gomes e Augusto Borges de moura
 * Versão: <1.0>
 * Data de Criação: 13/11/2017
 * Copyright (c) 2017 UFG - www.ufg.br
 * Todos os direitos reservados.
 *
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

    /**
    * retorna o titulo da instância da classe evento.
    *
    * @param null - não há parametros.
    * @return string - contendo o titulo da instancia evento que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public String getTitulo() {
        return titulo;
    }

    /**
    * altera o nome da instância da classe Evento.
    *
    * @param string - string com o titulo do objeto.
    * @return null - Não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
    * retorna o id da instância da classe evento.
    *
    * @param null - não há parametros.
    * @return Long - contendo o id da instancia evento que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public Long getId() {
        return id;
    }

    /**
    * altera o id da instância da classe Evento.
    *
    * @param Long - long com o id do objeto.
    * @return null - Não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    * retorna o id da instância da classe evento.
    *
    * @param null - não há parametros.
    * @return Usuario - contendo o usuario da instancia evento que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
    * altera o usuário do instância da classe Evento.
    *
    * @param Usuario - objeto da classe Usuario.
    * @return null - Não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
    * retorna a descrição do instância da classe evento.
    *
    * @param null - não há parametros.
    * @return Long - contendo o descrição da instancia evento que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public String getDescricao() {
        return descricao;
    }

    /**
    * altera a descrição da instância da classe Evento.
    *
    * @param Usuario - objeto da classe Usuario.
    * @return null - Não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
    * retorna a data do instância da classe evento.
    *
    * @param null - não há parametros.
    * @return Long - contendo a data da instancia evento que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public Date getData() {
        return data;
    }

    /**
    * Altera a data do instância da classe evento.
    *
    * @param data - objeto da classe data.
    * @return null -não há retorno.
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setData(Date data) {
        this.data = data;
    }

    /**
    * retorna o lembrete da instância da classe evento.
    *
    * @param null - não há parametros.
    * @return Long - contendo a data da instancia evento que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public Set<LembreteEmail> getLembreteEmails() {
        return lembreteEmails;
    }

    /**
    * Altera o lebrete da instância da classe evento.
    *
    * @param LembreteEmail - objeto da classe lebretesEmail.
    * @return null - não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setLembreteEmails(Set<LembreteEmail> lembreteEmails) {
        this.lembreteEmails = lembreteEmails;
    }
}
