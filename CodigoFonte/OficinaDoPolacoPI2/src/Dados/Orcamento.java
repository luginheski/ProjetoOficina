package Dados;

import java.sql.Date;

public class Orcamento {
    private int idOrcamento;
    private int hodometroAntigo;
    private int hodometroAtual;    
    private Date dataServico;
    private Veiculo veiculoId;

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    public Veiculo getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Veiculo veiculoId) {
        this.veiculoId = veiculoId;
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public int getHodometroAtual() {
        return hodometroAtual;
    }

    public void setHodometroAtual(int hodometroAtual) {
        this.hodometroAtual = hodometroAtual;
    }

    public int getHodometroAntigo() {
        return hodometroAntigo;
    }

    public void setHodometroAntigo(int hodometroAntigo) {
        this.hodometroAntigo = hodometroAntigo;
    }
    
    @Override
    public boolean equals(Object objeto){
        Orcamento o = (Orcamento) objeto;
        if (this.veiculoId == o.getVeiculoId()){
            return true;
        }else{
            return false;
        }
    }

    
    
}
