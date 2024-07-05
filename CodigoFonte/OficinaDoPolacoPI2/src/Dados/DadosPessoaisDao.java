
package Dados;

import java.sql.Connection;
import java.sql.SQLException;

public class DadosPessoaisDao {
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
}
