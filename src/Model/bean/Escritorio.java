package Model.bean;

public class Escritorio {

    private int id_escritorio;
    private String nome_advocacia;
    private String telefone;
    private String endereco;
    private Secretaria secretaria;

    public Escritorio() {
    }

    public Escritorio(int id_escritorio, String nome_advocacia, String telefone, String endereco, Secretaria secretaria) {
        this.id_escritorio = id_escritorio;
        this.nome_advocacia = nome_advocacia;
        this.telefone = telefone;
        this.endereco = endereco;
        this.secretaria = secretaria;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public int getId_escritorio() {
        return id_escritorio;
    }

    public void setId_escritorio(int id_escritorio) {
        this.id_escritorio = id_escritorio;
    }

    public String getNome_advocacia() {
        return nome_advocacia;
    }

    public void setNome_advocacia(String nome_advocacia) {
        this.nome_advocacia = nome_advocacia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
