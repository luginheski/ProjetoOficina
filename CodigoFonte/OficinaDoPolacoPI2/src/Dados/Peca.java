package Dados;

public class Peca {
    private int idPeca; 
    private String descricao;
    private double valorUnt;
    private double quantidade;
    private double valorTotal;
    private int porcento;
    private Orcamento orcamentoId;
    private double valorPunt;

    public double getValorPunt() {
        return valorPunt;
    }

    public void setValorPunt(double valorPunt) {
        this.valorPunt = valorPunt;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnt() {
        return valorUnt;
    }

    public void setValorUnt(double valorUnitario) {
        this.valorUnt = valorUnitario;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public int getPorcento() {
        return porcento;
    }

    public void setPorcento(int porcento) {
        this.porcento = porcento;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public Orcamento getOrcamentoId() {
        return orcamentoId;
    }

    public void setOrcamentoId(Orcamento orcamentoId) {
        this.orcamentoId = orcamentoId;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    @Override
    public boolean equals(Object objeto){
        Peca p = (Peca) objeto;
        if (this.orcamentoId == p.getOrcamentoId()){
            return true;
        }else{
            return false;
        }
    }
   
    
    
}
