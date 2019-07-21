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
public class AdvogadoPesquisa extends Advogado {

    public int id_Advogado;
    public String nome_Advogado;
    public String registro_Oab;
    public String telefone;
    public String email;
    public String endereco;
    public String login_Advogado;
    public int senha;
    public int id_escritorio;

    public AdvogadoPesquisa(int id_Advogado, String nome_Advogado) {
        super(id_Advogado, nome_Advogado);
        this.id_Advogado = id_Advogado;
        this.nome_Advogado = nome_Advogado;
    }

    public AdvogadoPesquisa(String nome_Advogado, String registro_Oab, String telefone, String email, String endereco, String login_Advogado, int senha, int id_escritorio) {
        super(nome_Advogado, registro_Oab, telefone, email, endereco, login_Advogado, senha, id_escritorio);
        this.nome_Advogado = nome_Advogado;
        this.registro_Oab = registro_Oab;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.login_Advogado = login_Advogado;
        this.senha = senha;
        this.id_escritorio = id_escritorio;
    }

    public AdvogadoPesquisa(int id_Advogado, String nome_Advogado, String registro_Oab, String telefone, String email, String endereco, String login_Advogado, int senha, int id_escritorio) {
        super(id_Advogado, nome_Advogado, registro_Oab, telefone, email, endereco, login_Advogado, senha, id_escritorio);
        this.id_Advogado = id_Advogado;
        this.nome_Advogado = nome_Advogado;
        this.registro_Oab = registro_Oab;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.login_Advogado = login_Advogado;
        this.senha = senha;
        this.id_escritorio = id_escritorio;
    }

    public AdvogadoPesquisa(int id_Advogado) {
        super(id_Advogado);
    }

    @Override
    public int getId_Advogado() {
        return id_Advogado;
    }

    @Override
    public void setId_Advogado(int id_Advogado) {
        this.id_Advogado = id_Advogado;
    }

    @Override
    public String getNome_Advogado() {
        return nome_Advogado;
    }

    @Override
    public void setNome_Advogado(String nome_Advogado) {
        this.nome_Advogado = nome_Advogado;
    }

    @Override
    public String getRegistro_Oab() {
        return registro_Oab;
    }

    @Override
    public void setRegistro_Oab(String registro_Oab) {
        this.registro_Oab = registro_Oab;
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
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
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
    public String getLogin_Advogado() {
        return login_Advogado;
    }

    @Override
    public void setLogin_Advogado(String login_Advogado) {
        this.login_Advogado = login_Advogado;
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
    public int getId_escritorio() {
        return id_escritorio;
    }

    @Override
    public void setId_escritorio(int id_escritorio) {
        this.id_escritorio = id_escritorio;
    }

    @Override
    public String toString() {
        return nome_Advogado;
    }
}
