
package Dados;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    public Connection getConexao(){
        
        try{
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/oficinaPolaco", // linha de conexao
                    "root", // usuario do mysql
                    "mysql"// senha do mysql
            );
            return conn;
        } catch (Exception e){
            System.out.println("Erro ao conectar: 1" + e.getMessage());
            return null;
        }
    }
}
