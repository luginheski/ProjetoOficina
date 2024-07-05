package Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class OrcamentoDao {

    private Conexao conexao;
    private Connection conn;
    private Connection con;

    public boolean conectar() {
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

    public Veiculo consultaPlaca(String placa) {
        try {
            Veiculo vel = new Veiculo();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM veiculo V WHERE V.placa = ?");
            st.setString(1, placa);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                vel.setPlaca(rs.getString("placa"));
                vel.setHodometroAnterior(rs.getInt("hodometroAnterior"));
                vel.setIdVeiculo(rs.getInt("Idveiculo"));

                return vel;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return null;
        }
    }

    public int gerarOrcamento(Orcamento orcamento) {
        int status;

        try {
            String sql = "INSERT INTO orcamento (hodometroAntigo, hodometroAtual, dataServico, veiculoId) VALUES(?,?,?,?)";
            PreparedStatement st = this.conn.prepareStatement(sql);
            st.setInt(1, orcamento.getHodometroAntigo());
            st.setInt(2, orcamento.getHodometroAtual());
            st.setDate(3, orcamento.getDataServico());
            st.setInt(4, orcamento.getVeiculoId().getIdVeiculo());
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir orçamento: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public Orcamento cosultaOrcamento(Integer idVeiculo) {
        try {
            Orcamento orc = new Orcamento();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM orcamento O INNER JOIN veiculo V ON (O.veiculoId=V.idVeiculo) WHERE O.veiculoId = ? ORDER BY O.idOrcamento DESC");
            st.setInt(1, idVeiculo);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                orc.setHodometroAntigo(rs.getInt("hodometroAntigo"));
                orc.setHodometroAtual(rs.getInt("hodometroAtual"));
                orc.setDataServico(rs.getDate("dataServico"));
                orc.setIdOrcamento(rs.getInt("idOrcamento"));
                Veiculo vel = new Veiculo();
                vel.setIdVeiculo(rs.getInt("idVeiculo"));
                vel.setPlaca(rs.getString("placa"));
                orc.setVeiculoId(vel);

                return orc;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return null;
        }
    }

    public Orcamento cosultaOrcamentoTabela(Integer idVeiculo) {
        try {
            Orcamento orc = new Orcamento();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM orcamento O INNER JOIN veiculo V ON (O.veiculoId=V.idVeiculo) WHERE O.idOrcamento = ? ORDER BY O.idOrcamento DESC");
            st.setInt(1, idVeiculo);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                orc.setHodometroAntigo(rs.getInt("hodometroAntigo"));
                orc.setHodometroAtual(rs.getInt("hodometroAtual"));
                orc.setDataServico(rs.getDate("dataServico"));
                orc.setIdOrcamento(rs.getInt("idOrcamento"));
                Veiculo vel = new Veiculo();
                vel.setIdVeiculo(rs.getInt("idVeiculo"));
                vel.setPlaca(rs.getString("placa"));
                orc.setVeiculoId(vel);

                return orc;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return null;
        }
    }

    public List<Orcamento> listar() {
        try {
            List<Orcamento> lista = new ArrayList<>();

            String sqlFiltro = "SELECT * FROM orcamento O INNER JOIN veiculo V ON (O.veiculoId=V.idVeiculo)";
            PreparedStatement st = conn.prepareStatement(sqlFiltro);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Orcamento orc = new Orcamento();
                orc.setIdOrcamento(rs.getInt("idOrcamento"));
                Veiculo vel = new Veiculo();
                vel.setPlaca(rs.getString("placa"));

                orc.setHodometroAtual(rs.getInt("hodometroAtual"));
                orc.setDataServico(rs.getDate("dataServico"));
                orc.setVeiculoId(vel);

                lista.add(orc);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Erro ao chamar lista " + ex.getMessage());
            return null;
        }
    }

    public boolean excluir(Integer numOrcamento) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM orcamento O WHERE O.idOrcamento = ?");
            st.setInt(1, numOrcamento);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar " + ex.getMessage());
            return false;
        }
    }

    public void relatorioOS(String caminho, Map parametros) {
        Conexao conex = new Conexao();
        con = conex.getConexao();
        try {
            JasperReport relatorio = JasperCompileManager.compileReport(caminho);
            JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorio, parametros, con);
            JasperViewer.viewReport(relatorioPreenchido, false);
            System.out.println("map " + parametros);
            System.out.println("caminho " + caminho);
            try {
                con.close();

            } catch (SQLException ex) {
                System.out.print("erro ao desconectar " + ex.getMessage());
            }

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar relatório!" + "\n" + ex);
        }

    }

}
