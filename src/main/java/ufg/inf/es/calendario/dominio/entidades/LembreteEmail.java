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

    /**
    * Lembra o email especificado na intância do objeto.
    *
    * @param null - não há parametros.
    * @return null - não há parametros . 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    void lembrar() {
        System.out.println("Lembrando email: " + emailAlvo);
    }

    /**
    * retorna o email da instância da classe LembreteEmail.
    *
    * @param null - não há parametros.
    * @return string - contendo o emailAlvo da instancia LembreteEmail que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public String getEmailAlvo() {
        return emailAlvo;
    }

    /**
    * altera o emailAlvo da instância da classe LembreteEmail.
    *
    * @param string - string com o emailAlvo da instancia LembreteEmail.
    * @return null - Não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setEmailAlvo(String emailAlvo) {
        this.emailAlvo = emailAlvo;
    }

    /**
    * retorna o mesagem da instância da classe LembreteEmail.
    *
    * @param null - não há parametros.
    * @return string - contendo a mensagem da instancia LembreteEmail que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public String getMensagem() {
        return mensagem;
    }

    /**
    * altera a mensagem da instância da classe LembreteEmail.
    *
    * @param string - string com a mensagem da instancia LembreteEmail.
    * @return null - Não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
    * retorna o id da instância da classe LembreteEmail.
    *
    * @param null - não há parametros.
    * @return Long - contendo o Id da instancia LembreteEmail que chama a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public Long getId() {
        return id;
    }

    /**
    * retorna o evento da instância da classe LembreteEmail.
    *
    * @param string - string com o evento da instancia LembreteEmail.
    * @return evento - contendo o evento da instancia LembreteEmail que chama a função. . 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public Evento getEvento() {
        return evento;
    }

    /**
    * Altera o evento da instância da classe LembreteEmail.
    *
    * @param evento - evento da instancia LembreteEmail.
    * @return null - não há retorno.
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
    * Altera o id da instância da classe LembreteEmail.
    *
    * @param long - id da instancia LembreteEmail.
    * @return null - não há retorno.
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setId(Long id) {
        this.id = id;
    }
}
