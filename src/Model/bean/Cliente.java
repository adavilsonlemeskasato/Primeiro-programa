/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import java.util.Objects;

/**
 *
 * @author Adavilson
 */
public class Cliente {

    private int id_cliente;
    private String nome_cliente;
    private String cpf;
    private String email;
    private String telefone;
    private String nun_casa;
    private String endereco;

    public Cliente(int id_cliente, String nome_cliente) {
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
    }

    public Cliente(int id_Cliente) {

    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNun_casa() {
        return nun_casa;
    }

    public void setNun_casa(String nun_casa) {
        this.nun_casa = nun_casa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id_cliente;
        hash = 67 * hash + Objects.hashCode(this.nome_cliente);
        hash = 67 * hash + Objects.hashCode(this.cpf);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.telefone);
        hash = 67 * hash + Objects.hashCode(this.nun_casa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id_cliente != other.id_cliente) {
            return false;
        }
        if (!Objects.equals(this.nome_cliente, other.nome_cliente)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.nun_casa, other.nun_casa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nome_cliente="
                + nome_cliente + ", cpf=" + cpf + ", email=" + email + ", telefone="
                + telefone + ", nun_casa=" + nun_casa + '}';
    }

    public Cliente(int id_cliente, String nome_cliente, String cpf, String email, String telefone, String nun_casa, String endereco) {
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.nun_casa = nun_casa;
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
