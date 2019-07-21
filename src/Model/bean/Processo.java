package Model.bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Processo {

   

    private int id_processo;
    private String num_processo;
    private String descricao;
    private LocalDate dt_inicio;
    private LocalDate dt_fim;
    private float vl_causa;

    private Cliente cliente;
    private Secretaria secretaria;
    private Advogado advogado;
    private Comarca comarca;

    public Comarca getComarca() {
        return comarca;
    }

    public void setComarca(Comarca comarca) {
        this.comarca = comarca;
    }

    public Processo(int id_processo, String num_processo, String descricao, LocalDate dt_inicio, LocalDate dt_fim, float vl_causa, Cliente cliente, Advogado advogado, Secretaria secretaria, Comarca comarca) {
        this.id_processo = id_processo;
        this.num_processo = num_processo;
        this.descricao = descricao;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
        this.vl_causa = vl_causa;
        this.cliente = cliente;
        this.secretaria = secretaria;
        this.advogado = advogado;
        this.comarca = comarca;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public Processo() {

    }

    public int getId_processo() {
        return id_processo;
    }

    public void setId_processo(int id_processo) {
        this.id_processo = id_processo;
    }

    public String getNum_processo() {
        return num_processo;
    }

    public void setNum_processo(String num_processo) {
        this.num_processo = num_processo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDt_inicio() {
        return dt_inicio;
    }

    public Date getDataNascimentoBDInicio() {
        java.util.Date dataInicio = Date.from(
                getDt_inicio().atStartOfDay(ZoneId.systemDefault()).toInstant());
        return new  java.sql.Date(dataInicio.getDate());
    }

    public void setDt_inicio(LocalDate dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public LocalDate getDt_fim() {
        return dt_fim;
    }

    public Date getDataNascimentoBDFim() {
        java.util.Date dataFim = Date.from(
                getDt_fim().atStartOfDay(ZoneId.systemDefault()).toInstant());
        return new java.sql.Date(dataFim.getTime());
    }

    public void setDt_fim(LocalDate dt_fim) {
        this.dt_fim = dt_fim;
    }

    public float getVl_causa() {
        return vl_causa;
    }

    public void setVl_causa(float vl_causa) {
        this.vl_causa = vl_causa;
    }

//    public Processo(int id_processo, String num_processo, String descricao, LocalDate dt_inicio, LocalDate dt_fim, float vl_causa, int id_cliente, int id_advogado, int id_secretaria, int id_comarca) {
//        this.id_processo = id_processo;
//        this.num_processo = num_processo;
//        this.descricao = descricao;
//        this.dt_inicio = dt_inicio;
//        this.dt_fim = dt_fim;
//        this.vl_causa = vl_causa;
//
//    }

     @Override
    public String toString() {
        return "Processo{" + "id_processo=" + id_processo + ", num_processo=" + num_processo + ", descricao=" + descricao + ", dt_inicio=" + dt_inicio + ", dt_fim=" + dt_fim + ", vl_causa=" + vl_causa + ", cliente=" + cliente + ", secretaria=" + secretaria + ", advogado=" + advogado + ", comarca=" + comarca + '}';
    }

}
