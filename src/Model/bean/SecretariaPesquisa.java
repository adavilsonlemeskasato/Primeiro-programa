package Model.bean;

/**
 *
 * @author adavilson
 */
public class SecretariaPesquisa extends Secretaria {

    public int id_secretaria;
    public String nome_secretaria;
    public String cpf;
    public String login_secretaria;
    public int senha;

    public SecretariaPesquisa(int id_secretaria, String nome_secretaria) {
        this.id_secretaria = id_secretaria;
        this.nome_secretaria = nome_secretaria;
    }

    public SecretariaPesquisa(int id_secretaria, String nome_secretaria, String cpf, String login_secretaria, int senha) {
        this.id_secretaria = id_secretaria;
        this.nome_secretaria = nome_secretaria;
        this.cpf = cpf;
        this.login_secretaria = login_secretaria;
        this.senha = senha;
    }

    public SecretariaPesquisa(String nome_secretaria, String cpf, String login_secretaria, int senha) {
        this.nome_secretaria = nome_secretaria;
        this.cpf = cpf;
        this.login_secretaria = login_secretaria;
        this.senha = senha;
    }

    public SecretariaPesquisa() {

    }

    @Override
    public int getId_secretaria() {
        return id_secretaria;
    }

    @Override
    public void setId_secretaria(int id_secretaria) {
        this.id_secretaria = id_secretaria;
    }

    @Override
    public String getNome_secretaria() {
        return nome_secretaria;
    }

    @Override
    public void setNome_secretaria(String nome_secretaria) {


        this.nome_secretaria = nome_secretaria;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getLogin_secretaria() {
        return login_secretaria;
    }

    @Override
    public void setLogin_secretaria(String login_secretaria) {
        this.login_secretaria = login_secretaria;
    }

    @Override
    public int getSenha() {
        return senha;
    }

    @Override
    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return nome_secretaria;
    }

}
