package Model.bean;

/**
 *
 * @author Adavilson
 */
public class ComarcaPesquisa extends Comarca {

    public int id_Comarca;
    public String uf;
    public String nome_Comarca;
    public String teledone;

    public ComarcaPesquisa(int id_Comarca, String uf, String nome_Comarca, String teledone) {
        super(id_Comarca, uf, nome_Comarca, teledone);
        this.id_Comarca = id_Comarca;
        this.uf = uf;
        this.nome_Comarca = nome_Comarca;
        this.teledone = teledone;
    }

    public ComarcaPesquisa(int id_Comarca) {
        super(id_Comarca);
        this.id_Comarca=id_Comarca;
    }

    public ComarcaPesquisa(int id_Comarca, String nome_Comarca) {
        super(id_Comarca, nome_Comarca);
        this.id_Comarca = id_Comarca;
        this.nome_Comarca = nome_Comarca;
    }

    @Override
    public int getId_Comarca() {
        return id_Comarca;
    }

    @Override
    public void setId_Comarca(int id_Comarca) {
        this.id_Comarca = id_Comarca;
    }

    @Override
    public String getUf() {
        return uf;
    }

    @Override
    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String getNome_Comarca() {
        return nome_Comarca;
    }

    @Override
    public void setNome_Comarca(String nome_Comarca) {
        this.nome_Comarca = nome_Comarca;
    }

    @Override
    public String getTeledone() {
        return teledone;
    }

    @Override
    public void setTeledone(String teledone) {
        this.teledone = teledone;
    }

    @Override
    public String toString() {
        return nome_Comarca;
    }
}
