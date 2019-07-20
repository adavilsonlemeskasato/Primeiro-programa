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
public class Advogado {

    private int id_Advogado;
    private String nome_Advogado;
    private String registro_Oab;
    private String telefone;
    private String email;
    private String endereco;
    private String login_Advogado;
    private int senha;
    private int id_escritorio;

    public Advogado(int id_Advogado, String nome_Advogado) {
        this.id_Advogado = id_Advogado;
        this.nome_Advogado = nome_Advogado;
    }

    public Advogado(String nome_Advogado, String registro_Oab, String telefone, String email, String endereco, String login_Advogado, int senha, int id_escritorio) {
        this.nome_Advogado = nome_Advogado;
        this.registro_Oab = registro_Oab;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.login_Advogado = login_Advogado;
        this.senha = senha;
        this.id_escritorio = id_escritorio;
    }

    public Advogado(int id_Advogado, String nome_Advogado, String registro_Oab, String telefone, String email, String endereco, String login_Advogado, int senha, int id_escritorio) {
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

    public Advogado(int id_Advogado) {

    }

    public int getId_Advogado() {
        return id_Advogado;
    }

    public void setId_Advogado(int id_Advogado) {
        this.id_Advogado = id_Advogado;
    }

    public String getNome_Advogado() {
        return nome_Advogado;
    }

    public void setNome_Advogado(String nome_Advogado) {
        this.nome_Advogado = nome_Advogado;
    }

    public String getRegistro_Oab() {
        return registro_Oab;
    }

    public void setRegistro_Oab(String registro_Oab) {
        this.registro_Oab = registro_Oab;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLogin_Advogado() {
        return login_Advogado;
    }

    public void setLogin_Advogado(String login_Advogado) {
        this.login_Advogado = login_Advogado;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getId_escritorio() {
        return id_escritorio;
    }

    public void setId_escritorio(int id_escritorio) {
        this.id_escritorio = id_escritorio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id_Advogado;
        hash = 37 * hash + Objects.hashCode(this.nome_Advogado);
        hash = 37 * hash + Objects.hashCode(this.registro_Oab);
        hash = 37 * hash + Objects.hashCode(this.telefone);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.endereco);
        hash = 37 * hash + Objects.hashCode(this.login_Advogado);
        hash = 37 * hash + this.senha;
        hash = 37 * hash + this.id_escritorio;
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
        final Advogado other = (Advogado) obj;
        if (this.id_Advogado != other.id_Advogado) {
            return false;
        }
        if (this.senha != other.senha) {
            return false;
        }
        if (this.id_escritorio != other.id_escritorio) {
            return false;
        }
        if (!Objects.equals(this.nome_Advogado, other.nome_Advogado)) {
            return false;
        }
        if (!Objects.equals(this.registro_Oab, other.registro_Oab)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.login_Advogado, other.login_Advogado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Advogado{" + "id_Advogado=" + id_Advogado + ", nome_Advogado="
                + nome_Advogado + ", registro_Oab=" + registro_Oab + ","
                + " telefone=" + telefone + ", email=" + email + ", "
                + "endereco=" + endereco + ", login_Advogado="
                + login_Advogado + ", senha=" + senha + ", id_escritorio="
                + id_escritorio + '}';
    }

}
