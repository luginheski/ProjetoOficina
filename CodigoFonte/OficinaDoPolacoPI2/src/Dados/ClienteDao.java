
package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDao {
    
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
    
    public int salvar(Cliente cliente){
        int status;
        
        try{
            String sql = "INSERT INTO cliente(nome, rg, cpf, telefone, rua, numero, cep, bairro, cidade, estado) VALUES (?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement st = this.conn.prepareStatement(sql);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRg());
            st.setString(3, cliente.getCpf());
            st.setString(4, cliente.getTelefone());
            st.setString(5, cliente.getRua());
            st.setInt(6, cliente.getNumero());
            st.setString(7, cliente.getCep());
            st.setString(8, cliente.getBairro());
            st.setString(9, cliente.getCidade());
            st.setString(10, cliente.getEstado());
            status = st.executeUpdate();
            return status;
            
        }catch (SQLException ex) {
            System.out.println("Erro ao inserir cliente: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public boolean excluir(String cpf){
        try{
            PreparedStatement st = this.conn.prepareStatement("DELETE FROM cliente WHERE cpf = ?");
            st.setString(1,cpf);
            st.executeUpdate();
            return true;
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "erro ao conectar");
            return false;
        }
    }
    
    public Cliente consulta(String cpf){
        try{
            Cliente clienteEncontrado = new Cliente();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM cliente  WHERE cpf = ?");
            st.setString(1, cpf);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                clienteEncontrado.setNome(rs.getString("nome"));
                clienteEncontrado.setRg(rs.getString("rg"));
                clienteEncontrado.setCpf(rs.getString("cpf"));
                clienteEncontrado.setTelefone(rs.getString("telefone"));
                clienteEncontrado.setRua(rs.getString("rua"));
                clienteEncontrado.setNumero(rs.getInt("numero"));
                clienteEncontrado.setCep(rs.getString("cep"));
                clienteEncontrado.setBairro(rs.getString("bairro"));
                clienteEncontrado.setCidade(rs.getString("cidade"));
                clienteEncontrado.setEstado(rs.getString("estado"));
                
                return clienteEncontrado;
            }else{
                return null;
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "erro ao conectar2");
            return null;
        }
    }
    
    public List<Cliente> listar(String termoBusca){
        try{
            List<Cliente> lista = new ArrayList<>();
            
            String sqlFiltro = "SELECT * FROM cliente C";
                        
            PreparedStatement st = conn.prepareStatement(sqlFiltro);
            if(termoBusca.equals(true)){
                st.setString(1, "%" + termoBusca + "%");
            }
            
            if(termoBusca.equals(0)){
                sqlFiltro = sqlFiltro + " WHERE C.cpf like ?";
            }
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                Cliente clienteEncontrado = new Cliente();
                clienteEncontrado.setNome(rs.getString("nome"));
                clienteEncontrado.setRg(rs.getString("rg"));
                clienteEncontrado.setCpf(rs.getString("cpf"));
                clienteEncontrado.setTelefone(rs.getString("telefone"));
                clienteEncontrado.setRua(rs.getString("rua"));
                clienteEncontrado.setNumero(rs.getInt("numero"));
                clienteEncontrado.setCep(rs.getString("cep"));
                clienteEncontrado.setBairro(rs.getString("bairro"));
                clienteEncontrado.setCidade(rs.getString("cidade"));
                clienteEncontrado.setEstado(rs.getString("estado"));
                
                lista.add(clienteEncontrado);
            }
            
            return lista;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "erro ao conectar3" + ex);
            return null;
        }
    }
    
    public int atualizar(Cliente cliente){
        int status;
        
        try{
            String sql = "UPDATE cliente SET nome=?, rg=?, telefone=?, rua=?, numero=?, cep=?, bairro=?, cidade=?, estado=? WHERE cpf=?";
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRg());            
            st.setString(3, cliente.getTelefone());
            st.setString(4, cliente.getRua());
            st.setInt(5, cliente.getNumero());
            st.setString(6, cliente.getCep());
            st.setString(7, cliente.getBairro());
            st.setString(8, cliente.getCidade());
            st.setString(9, cliente.getEstado());
            st.setString(10, cliente.getCpf());
            status = st.executeUpdate();
            return status;
            
        }catch (SQLException ex) {
            System.out.println("Erro ao inserir cliente: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
}
