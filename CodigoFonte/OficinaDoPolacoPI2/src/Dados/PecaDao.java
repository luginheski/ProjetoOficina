
package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PecaDao {
    private Conexao conexao;
    private Connection conn;
    
    public boolean conectar(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
        if (this.conn == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public void desconectar() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.out.print("erro ao desconectar " + ex.getMessage());
        }
    }
    
    public int inserirPeca(Peca peca){
        int status;
        
        try{
            String sql = "INSERT INTO peca (descricao, valorUnitario, quantidade, porcento, orcamentoId, valorTotal, valorPunt) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st = this.conn.prepareStatement(sql);
            st.setString(1, peca.getDescricao());
            st.setDouble(2, peca.getValorUnt());
            st.setDouble(3, peca.getQuantidade());
            st.setInt(4, peca.getPorcento());
            st.setInt(5, peca.getOrcamentoId().getIdOrcamento());
            st.setDouble(6, peca.getValorTotal());
            st.setDouble(7, peca.getValorPunt());
            status = st.executeUpdate();
            return status;
        }catch (SQLException ex) {
            System.out.println("Erro ao inserir orçamento: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public List<Peca> listarPc(Integer idOrcamento){
        try{
            List<Peca> lista = new ArrayList<>();
            
            String sql = "SELECT * FROM peca P INNER JOIN orcamento O ON (P.orcamentoId=O.idOrcamento) WHERE P.orcamentoId like ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + idOrcamento + "%");            
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Peca pc = new Peca();
                Orcamento orc = new Orcamento();
                
                pc.setIdPeca(rs.getInt("idPeca"));
                pc.setDescricao(rs.getString("descricao"));
                pc.setValorUnt(rs.getDouble("valorUnitario"));
                pc.setQuantidade(rs.getDouble("quantidade"));
                pc.setPorcento(rs.getInt("porcento"));
                pc.setValorTotal(rs.getDouble("valorTotal"));
                pc.setValorPunt(rs.getDouble("valorPunt"));
                orc.setIdOrcamento(rs.getInt("orcamentoId"));
                pc.setOrcamentoId(orc);
                
                lista.add(pc);
            }
            return lista;
        }catch (SQLException ex) {
            System.out.println("Erro ao chamar lista " + ex.getMessage());
            return null;
        }
    } 
    
    public Peca consultaPeca(Integer idPeca){
        try{
            Peca pc = new Peca();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM peca P INNER JOIN orcamento O ON (P.orcamentoId=O.idOrcamento)WHERE P.idPeca = ?");
            st.setInt(1, idPeca);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                pc.setIdPeca(rs.getInt("idPeca"));
                pc.setDescricao(rs.getString("descricao"));
                pc.setValorUnt(rs.getDouble("valorUnitario"));
                pc.setQuantidade(rs.getDouble("quantidade"));
                pc.setPorcento(rs.getInt("porcento"));
                pc.setValorTotal(rs.getDouble("valorTotal"));
                Orcamento orc = new Orcamento();
                orc.setIdOrcamento(rs.getInt("idOrcamento"));
                pc.setOrcamentoId(orc);
                
                return pc;
            }else{
                return null;
            }
        }catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return null;
        }
    }
    
    public boolean excluirPeca(Integer idPeca){
        try{
            PreparedStatement st = conn.prepareStatement("DELETE FROM peca P WHERE P.idPeca = ?");
            st.setInt(1, idPeca);
            st.executeUpdate();
            return true;
        }catch (SQLException ex){
            System.out.println("Erro ao conectar " + ex.getMessage());
            return false;
        }
    }
    
    public Peca valorTotal(Integer idOrc){
        try{
            Peca pc = new Peca();
            String sql = "SELECT SUM(valorTotal) FROM peca P WHERE P.orcamentoId = ? GROUP BY P.orcamentoId";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idOrc);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
            pc.setValorTotal(rs.getDouble("SUM(valorTotal)"));
            return pc;
            }else{
                return null;
            }
        }catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return null;
        }
       
    }
}
