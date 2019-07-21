/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

/**
 *
 * @author Adavilson
 */
public class ClientePesquisa extends Cliente {

    int id_cliente;
    String nome_cliente;
    String cpf;
    String email;
    String telefone;
    String nun_casa;
    String endereco;

    public ClientePesquisa(int id_cliente, String nome_cliente) {
        super(id_cliente, nome_cliente);
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
    }

    public ClientePesquisa(int id_cliente, String nome_cliente, String cpf, String email, String telefone, String nun_casa, String endereco) {
        super(id_cliente, nome_cliente, cpf, email, telefone, nun_casa, endereco);
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.nun_casa = nun_casa;
        this.endereco = endereco;
    }

    public ClientePesquisa(int id_Cliente) {
        super(id_Cliente);
        this.id_cliente=id_Cliente;
    }

    @Override
    public int getId_cliente() {
        return id_cliente;
    }

    @Override
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String getNome_cliente() {
        return nome_cliente;
    }

    @Override
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
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
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String getNun_casa() {
        return nun_casa;
    }

    @Override
    public void setNun_casa(String nun_casa) {
        this.nun_casa = nun_casa;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return nome_cliente;
    }

}
