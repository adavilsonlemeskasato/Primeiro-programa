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
public class Comarca {

    private int id_Comarca;
    private String uf;
    private String nome_Comarca;
    private String teledone;

    public Comarca(int id_Comarca, String nome_Comarca) {
        this.id_Comarca = id_Comarca;
        this.nome_Comarca = nome_Comarca;
    }

    public Comarca(int id_Comarca, String uf, String nome_Comarca, String teledone) {
        this.id_Comarca = id_Comarca;
        this.uf = uf;
        this.nome_Comarca = nome_Comarca;
        this.teledone = teledone;
    }

    public Comarca(int id_Comarca) {

    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id_Comarca;
        hash = 67 * hash + Objects.hashCode(this.uf);
        hash = 67 * hash + Objects.hashCode(this.nome_Comarca);
        hash = 67 * hash + Objects.hashCode(this.teledone);
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
        final Comarca other = (Comarca) obj;
        if (this.id_Comarca != other.id_Comarca) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        if (!Objects.equals(this.nome_Comarca, other.nome_Comarca)) {
            return false;
        }
        if (!Objects.equals(this.teledone, other.teledone)) {
            return false;
        }
        return true;
    }

    public int getId_Comarca() {
        return id_Comarca;
    }

    public void setId_Comarca(int id_Comarca) {
        this.id_Comarca = id_Comarca;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome_Comarca() {
        return nome_Comarca;
    }

    public void setNome_Comarca(String nome_Comarca) {
        this.nome_Comarca = nome_Comarca;
    }

    public String getTeledone() {
        return teledone;
    }

    public void setTeledone(String teledone) {
        this.teledone = teledone;
    }

    @Override
    public String toString() {
        return "Comarca{" + "id_Comarca=" + id_Comarca + ", uf=" + uf + ", nome_Comarca=" + nome_Comarca + ", teledone=" + teledone + '}';
    }
}
