package Dados;

public class Veiculo {
    private int idVeiculo;
    private String fabricante;
    private String modelo;
    private int anoFabricacao;
    private int anoModelo;
    private int hodometroAnterior;
    private int hodometroAtual;
    private String placa;
    private Cliente cpfCliente;

    public Veiculo(){
        
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getHodometroAnterior() {
        return hodometroAnterior;
    }

    public void setHodometroAnterior(int hodometroAnterior) {
        this.hodometroAnterior = hodometroAnterior;
    }

    public int getHodometroAtual() {
        return hodometroAtual;
    }

    public void setHodometroAtual(int hodometroAtual) {
        this.hodometroAtual = hodometroAtual;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Cliente getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(Cliente cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    
     @Override
    public String toString() {
        return this.placa;
    }

    @Override
    public boolean equals(Object objeto) {
        Veiculo e = (Veiculo) objeto;
        if (this.cpfCliente == e.getCpfCliente()) {
            return true;
        } else {
            return false;
        }
    }
        
    
}
