
package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDao {
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
    
    public int salvar(Veiculo veiculo){
        int status;
        
        try{
            PreparedStatement st = conn.prepareStatement("INSERT INTO veiculo (fabricante, modelo, anoFabricacao, anoModelo, hodometroAnterior, placa, cpfCliente) VALUES (?,?,?,?,?,?,?)");
            st.setString(1,veiculo.getFabricante());
            st.setString(2, veiculo.getModelo());
            st.setInt(3, veiculo.getAnoFabricacao());
            st.setInt(4, veiculo.getAnoModelo());
            st.setInt(5,veiculo.getHodometroAnterior()); 
            //st.setInt(6, veiculo.getHodometroAtual());
            st.setString(6, veiculo.getPlaca());
            st.setString(7,veiculo.getCpfCliente().getCpf());
            status = st.executeUpdate();
            return status;
        }catch(SQLException ex){
            return ex.getErrorCode();
        }
    }
    
    public int atualizar(Veiculo veiculo){
        int status;
        
        try{
            String sql = "UPDATE veiculo SET fabricante=?, modelo=?, anoFabricacao=?, anoModelo=?, hodometroAnterior=?, placa=? WHERE idVeiculo=?";
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,veiculo.getFabricante());
            st.setString(2, veiculo.getModelo());
            st.setInt(3, veiculo.getAnoFabricacao());
            st.setInt(4, veiculo.getAnoModelo());
            st.setInt(5,veiculo.getHodometroAnterior());
            st.setString(6, veiculo.getPlaca());
            st.setInt(7,veiculo.getIdVeiculo());
            status = st.executeUpdate();
            return status;
        }catch(SQLException ex){
            return ex.getErrorCode();
        }
    }
    
    public Veiculo consultaCpf(String cpf){
        try{
            Veiculo vel = new Veiculo();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM veiculo V inner join cliente C on (V.cpfCliente=C.cpf) WHERE V.cpfCliente = ?");
            st.setString(1, cpf);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                
                vel.setIdVeiculo(rs.getInt("idVeiculo"));
                vel.setFabricante(rs.getString("fabricante"));
                vel.setModelo(rs.getString("modelo"));
                vel.setAnoFabricacao(rs.getInt("anoFabricacao"));
                vel.setAnoModelo(rs.getInt("anoModelo"));
                vel.setHodometroAnterior(rs.getInt("hodometroAnterior"));
                vel.setPlaca(rs.getString("placa"));
                Cliente cli = new Cliente();
                cli.setCpf(rs.getString("cpf"));
                vel.setCpfCliente(cli);
                
                return vel;
            }else{
                return null;
            }
        }catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return null;
        }
    }
    
    public Veiculo consultaPlaca(String placa){
        try{
            Veiculo vel = new Veiculo();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM veiculo V inner join cliente C on (V.cpfCliente=C.cpf) WHERE V.placa = ?");
            st.setString(1, placa);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                
                vel.setIdVeiculo(rs.getInt("idVeiculo"));
                vel.setFabricante(rs.getString("fabricante"));
                vel.setModelo(rs.getString("modelo"));
                vel.setAnoFabricacao(rs.getInt("anoFabricacao"));
                vel.setAnoModelo(rs.getInt("anoModelo"));
                vel.setHodometroAnterior(rs.getInt("hodometroAnterior"));
                vel.setPlaca(rs.getString("placa"));
                Cliente cli = new Cliente();
                cli.setCpf(rs.getString("cpf"));
                cli.setNome(rs.getString("nome"));
                vel.setCpfCliente(cli);
                                
                return vel;
            }else{
                return null;
            }
        }catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return null;
        }
    }
    
    public List<Veiculo> listar(String placa){
        try{
            List<Veiculo> lista = new ArrayList<>();
            
            String sqlFiltro = "SELECT * FROM veiculo V INNER JOIN cliente C on (V.cpfCliente=C.cpf) ";
            
            if(!placa.isEmpty()){
                sqlFiltro = sqlFiltro + " WHERE V.placa LIKE ?";
            }
            
            PreparedStatement st = conn.prepareStatement(sqlFiltro);
            if(!placa.isEmpty()){
                st.setString(1, "%" + placa + "%");
            }
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                Veiculo vel = new Veiculo();
                vel.setIdVeiculo(rs.getInt("idVeiculo"));
                vel.setFabricante(rs.getString("fabricante"));
                vel.setModelo(rs.getString("modelo"));
                vel.setAnoFabricacao(rs.getInt("anoFabricacao"));
                vel.setAnoModelo(rs.getInt("anoModelo"));
                vel.setHodometroAnterior(rs.getInt("hodometroAnterior"));
                vel.setPlaca(rs.getString("placa"));
                
                Cliente cli = new Cliente();
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                vel.setCpfCliente(cli);
                lista.add(vel);
                
            }
            
            return lista;
        }catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return null;
        }        
    }    
    
    public boolean excluir(String placa){
        try{
            PreparedStatement st = conn.prepareStatement("DELETE FROM veiculo V WHERE V.placa = ?");
            st.setString(1, placa);
            st.executeUpdate();
            return true;
        }catch (SQLException ex){
            System.out.println("Erro ao conectar " + ex.getMessage());
            return false;
        }
    }
    
    public Veiculo consultaHodometro(Integer idVeiculo){
        try{
            Veiculo vel = new Veiculo();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM veiculo V WHERE V.idVeiculo = ?");
            st.setInt(1, idVeiculo);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                vel.setHodometroAtual(rs.getInt("hodometroAtual"));
                return vel;
            }else{
                return null;
            }
        }catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return null;
        }
    }
}
