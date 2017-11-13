package ufg.inf.es.calendario.dominio;

/**
 * Aluno: Breno de Melo Gomes e Augusto Borges de moura
 * Versão: <1.0>
 * Data de Criação: 13/11/2017
 * Copyright (c) 2017 UFG - www.ufg.br
 * Todos os direitos reservados.
 *
 * Esta classe tem o propósito de ser a classe que abstrai o calendário
 */


public class ApplicationInfo {

    private String nome;
    private String versao;

    public ApplicationInfo(String nome, String versao) {
        this.nome = nome;
        this.versao = versao;
    }

    /**
    *  verifica a igualdade dentre dois objetos da classe Objeto .
    *
    * @param objeto - objeto com os atributos de objeto.
    * @return boolean - contendo a comparação da iguladade entre o objeto passado
    * como aprametro e a intancia do objeo que chamou a função.
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationInfo that = (ApplicationInfo) o;

        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        return versao != null ? versao.equals(that.versao) : that.versao == null;
    }

    /**
    * retorna o hashcode de um objeto.
    *
    * @param null - não há parametros.
    * @return int - contendo o resultado do hashcode de um objeto. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (versao != null ? versao.hashCode() : 0);
        return result;
    }

    /**
    * retorna o nome do objeto da classe Objeto.
    *
    * @param null - não há parametros.
    * @return string - contendo o nome da instancia objeto que chaa a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public String getNome() {
        return nome;
    }


    /**
    * altera o nome do objeto da classe Objeto.
    *
    * @param string - string com o nome do objeto.
    * @return null - Não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
    * retorna o nome do objeto da classe Objeto.
    *
    * @param null - não há parametros.
    * @return string - contendo a versão da instancia objeto que chaa a função. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public String getVersao() {
        return versao;
    }

    /**
    * altera a versão do objeto da classe Objeto.
    *
    * @param string - string com o nome do objeto.
    * @return null - Não há retorno. 
    * @throws IOException - no caso de problema  a função não retorna nenhuma exceção.
    */
    public void setVersao(String versao) {
        this.versao = versao;
    }
}
