package ufg.inf.es.calendario.dominio;

public class ApplicationInfo {

    private String nome;
    private String versao;

    public ApplicationInfo(String nome, String versao) {
        this.nome = nome;
        this.versao = versao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationInfo that = (ApplicationInfo) o;

        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        return versao != null ? versao.equals(that.versao) : that.versao == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (versao != null ? versao.hashCode() : 0);
        return result;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }
}
