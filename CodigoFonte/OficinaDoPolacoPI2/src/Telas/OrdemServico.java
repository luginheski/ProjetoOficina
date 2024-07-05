package Telas;

import Dados.Orcamento;
import Dados.OrcamentoDao;
import Dados.Peca;
import Dados.PecaDao;
import Dados.Veiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class OrdemServico extends javax.swing.JFrame {

    public void limpaTelaVeiculo() {
        jTxtPlaca.setText("");
        jTxtOrdemServico.setText("");
        jTxtDataServico.setText("");
        jTxtHodometroAtual.setText("");
        jTxtHodometroAnterior.setText("");
        jTveiculoId.setText("");
        jTxtPlaca.setEditable(true);
        jTxtTotal.setText("");
        jBtnCriarOs.setEnabled(false);
        jBtnExcluirOs.setEnabled(false);
        preencherTabelaPeca(-1);
    }

    public void limpaTelaPecas() {
        jTxtDescricaoPeca.setText("");
        jTxtValorUnt.setText("");
        jTxtQuantidade.setText("");
        jBtnExcluirItens.setEnabled(false);
        jTxtPorcento.setText("30");
        
    }

    public static String formataData(String formato, java.time.LocalDate data) {
        var form = DateTimeFormatter.ofPattern(formato);
        String dataString = form.format(data);
        return dataString;
    }

    public static String formataDataSql(String formato, Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String dataString = sdf.format(data);
        return dataString;
    }

    public static java.util.Date converteData(String data) {
        String model = "dd/MM/yyyy";
        SimpleDateFormat conversor = new SimpleDateFormat(model);
        try {
            java.util.Date dataConvertida = conversor.parse(data);
            java.sql.Date sqlDate = new java.sql.Date(dataConvertida.getTime());
            return sqlDate;
        } catch (ParseException pe) {
            System.out.println("Erro ao converter data" + pe.getMessage());
            return null;
        }
    }

    private void preencherTabelaOs() {
        OrcamentoDao dao = new OrcamentoDao();
        boolean status = dao.conectar();

        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            List<Orcamento> listaOs = dao.listar();

            DefaultTableModel tabelaOs = (DefaultTableModel) jTabelaOs.getModel();
            jTabelaOs.setRowSorter(new TableRowSorter(tabelaOs));
            tabelaOs.setNumRows(0);

            for (Orcamento o : listaOs) {
                Object[] obj = new Object[]{
                    o.getIdOrcamento(),
                    o.getVeiculoId().getPlaca(),
                    o.getHodometroAtual(),
                    formataDataSql("dd/MM/YYYY", o.getDataServico())
                };
                tabelaOs.addRow(obj);
            }
            dao.desconectar();
        }
    }

    private void preencherTabelaPeca(int idOrcamento) {
        PecaDao dao = new PecaDao();
        boolean status = dao.conectar();

        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            List<Peca> listaPeca = dao.listarPc(idOrcamento);
            DefaultTableModel tabelaPeca = (DefaultTableModel) jTabelaPeca.getModel();
            jTabelaPeca.setRowSorter(new TableRowSorter(tabelaPeca));
            tabelaPeca.setNumRows(0);

            for (Peca p : listaPeca) {
                Object[] obj = new Object[]{
                    p.getIdPeca(),
                    p.getDescricao(),
                    p.getQuantidade(),
                    p.getValorPunt(),
                    p.getValorTotal()
                };
                tabelaPeca.addRow(obj);
                Peca pc = new Peca();
                pc = dao.valorTotal(idOrcamento);
                jTxtTotal.setText(String.valueOf(pc.getValorTotal()));
            }
            dao.desconectar();
        }
    }

    public OrdemServico() {
        initComponents();
        jTxtOrdemServico.setEditable(false);
        jTxtNunOs.setVisible(false);
        jTxtIdPeca.setVisible(false);
        jTveiculoId.setVisible(false);
        preencherTabelaOs();
        //limpaTelaVeiculo();
        //limpaTelaPecas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTxtPlaca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtOrdemServico = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTxtHodometroAtual = new javax.swing.JTextField();
        jTxtHodometroAnterior = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTveiculoId = new javax.swing.JTextField();
        jTxtDataServico = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTxtNunOs = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaPeca = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jBtnConsultarPlaca = new javax.swing.JButton();
        jBtnCriarOs = new javax.swing.JButton();
        jBtnExcluirOs = new javax.swing.JButton();
        jBtnLimparOs = new javax.swing.JButton();
        jBtnVoltarOs = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtDescricaoPeca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtValorUnt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jBtnAdicionarPeca = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTxtTotal = new javax.swing.JTextField();
        jBtnLimparPeca = new javax.swing.JButton();
        jBtnExcluirItens = new javax.swing.JButton();
        jTxtPorcento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTxtQuantidade = new javax.swing.JTextField();
        jTxtIdPeca = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaOs = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mbtnCliente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mbtnVeiculo = new javax.swing.JMenuItem();
        mbtnRelatorio = new javax.swing.JMenu();
        mbtnGerarOs = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Oficina Ordem de Serviço");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 36)); // NOI18N
        jLabel1.setText("OFICINA DO POLACO");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(1055, 160));

        jTxtPlaca.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtPlaca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setText("PLaca:");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Veiculo:");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel3.setText("Ordem de Serviço:");

        jTxtOrdemServico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtOrdemServico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel10.setText("Data do serviço:");

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel12.setText("Km anterior:");

        jTxtHodometroAtual.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtHodometroAtual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTxtHodometroAnterior.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtHodometroAnterior.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel15.setText("Km atual:");

        jTxtDataServico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        try {
            jTxtDataServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTxtDataServico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtHodometroAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(127, 127, 127)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtHodometroAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTveiculoId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(218, 218, 218)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTxtDataServico, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addComponent(jTveiculoId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtHodometroAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtHodometroAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtOrdemServico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtDataServico, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(1055, 160));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel11.setText("Serviços Realizados:");

        jTabelaPeca.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jTabelaPeca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Peça", "Quantidade", "Valor unitário", "Valor total"
            }
        ));
        jTabelaPeca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPecaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaPeca);

        jScrollPane3.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNunOs, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addComponent(jTxtNunOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel14.setText("Ordem de Serviço OS");

        jBtnConsultarPlaca.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnConsultarPlaca.setText("Consultar / Placa");
        jBtnConsultarPlaca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnConsultarPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConsultarPlacaActionPerformed(evt);
            }
        });

        jBtnCriarOs.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnCriarOs.setText("Criar Ordem de Serviço");
        jBtnCriarOs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnCriarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCriarOsActionPerformed(evt);
            }
        });

        jBtnExcluirOs.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnExcluirOs.setText("Excluir");
        jBtnExcluirOs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnExcluirOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirOsActionPerformed(evt);
            }
        });

        jBtnLimparOs.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnLimparOs.setText("Limpar");
        jBtnLimparOs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnLimparOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimparOsActionPerformed(evt);
            }
        });

        jBtnVoltarOs.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnVoltarOs.setText("Sair");
        jBtnVoltarOs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnVoltarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVoltarOsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnConsultarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnLimparOs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnCriarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnVoltarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel14))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnExcluirOs, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jBtnConsultarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnCriarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnExcluirOs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnLimparOs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jBtnVoltarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setText("Peças:");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setText("Descrição da peça:");

        jTxtDescricaoPeca.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtDescricaoPeca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setText("Valor unitario / litro:");

        jTxtValorUnt.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtValorUnt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel8.setText("Quantidade:");

        jBtnAdicionarPeca.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnAdicionarPeca.setText("Adicionar");
        jBtnAdicionarPeca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnAdicionarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionarPecaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel9.setText("Valor total à pagar");

        jTxtTotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jBtnLimparPeca.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnLimparPeca.setText("Limpar");
        jBtnLimparPeca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnLimparPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimparPecaActionPerformed(evt);
            }
        });

        jBtnExcluirItens.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnExcluirItens.setText("Excluir itens");
        jBtnExcluirItens.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnExcluirItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirItensActionPerformed(evt);
            }
        });

        jTxtPorcento.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtPorcento.setText("30");
        jTxtPorcento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel13.setText("%");

        jTxtQuantidade.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtQuantidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluirItens, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtDescricaoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jBtnAdicionarPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jBtnLimparPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtValorUnt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGap(59, 59, 59)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jTxtPorcento, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtIdPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(185, 185, 185))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTxtIdPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtDescricaoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtValorUnt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtPorcento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAdicionarPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnLimparPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnExcluirItens, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabelaOs.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jTabelaOs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Ordem de serviço", "Placa", "Km Atual", "Data Serviço"
            }
        ));
        jTabelaOs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaOsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaOs);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(482, 482, 482)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(452, 452, 452))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Cadastros");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        mbtnCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mbtnCliente.setText("Cadastrar Cliente");
        mbtnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnClienteActionPerformed(evt);
            }
        });
        jMenu1.add(mbtnCliente);
        jMenu1.add(jSeparator1);

        mbtnVeiculo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mbtnVeiculo.setText("Cadastrar Veiculo");
        mbtnVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnVeiculoActionPerformed(evt);
            }
        });
        jMenu1.add(mbtnVeiculo);

        jMenuBar1.add(jMenu1);

        mbtnRelatorio.setText("Relatório");
        mbtnRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        mbtnGerarOs.setText("Gerar OS");
        mbtnGerarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtnGerarOsActionPerformed(evt);
            }
        });
        mbtnRelatorio.add(mbtnGerarOs);
        mbtnRelatorio.add(jSeparator2);

        jMenuItem2.setText("Relatório vendas");
        mbtnRelatorio.add(jMenuItem2);

        jMenuBar1.add(mbtnRelatorio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnVoltarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVoltarOsActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBtnVoltarOsActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Login menu = new Login();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jBtnLimparOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparOsActionPerformed
        limpaTelaVeiculo();
        limpaTelaPecas();
    }//GEN-LAST:event_jBtnLimparOsActionPerformed

    private void jBtnLimparPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparPecaActionPerformed
        limpaTelaPecas();
    }//GEN-LAST:event_jBtnLimparPecaActionPerformed

    private void jBtnConsultarPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConsultarPlacaActionPerformed
        OrcamentoDao dao = new OrcamentoDao();
        boolean status = dao.conectar();

        if (status == true) {
            Veiculo veiculo = dao.consultaPlaca(jTxtPlaca.getText());

            if (veiculo == null) {
                JOptionPane.showMessageDialog(null, "Veiculo não encontrado.");
            } else {
                Orcamento orca = new Orcamento();
                int id = veiculo.getIdVeiculo();
                orca = dao.cosultaOrcamento(id);
                if (orca == null) {
                    jTxtPlaca.setEditable(false);
                    jTxtPlaca.setText(veiculo.getPlaca());
                    jTxtHodometroAnterior.setText(String.valueOf(veiculo.getHodometroAnterior()));
                    jTveiculoId.setText(String.valueOf(veiculo.getIdVeiculo()));
                    var dataAtual = LocalDate.now();
                    jTxtDataServico.setText(formataData("dd/MM/YYYY", dataAtual));
                } else {
                    jTxtPlaca.setEditable(false);
                    jTxtPlaca.setText(veiculo.getPlaca());
                    jTxtHodometroAnterior.setText(String.valueOf(orca.getHodometroAtual()));
                    jTveiculoId.setText(String.valueOf(veiculo.getIdVeiculo()));
                    var dataAtual = LocalDate.now();
                    jTxtDataServico.setText(formataData("dd/MM/YYYY", dataAtual));
                }
                jBtnCriarOs.setEnabled(true);
                jBtnExcluirOs.setEnabled(true);
                dao.desconectar();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
    }//GEN-LAST:event_jBtnConsultarPlacaActionPerformed

    private void jBtnCriarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCriarOsActionPerformed

        OrcamentoDao dao = new OrcamentoDao();
        boolean status;
        int resposta;

        status = dao.conectar();

        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            if (jTxtHodometroAtual.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe a Km atual do veiculo.");
            } else {
                Orcamento orc = new Orcamento();
                Veiculo id = new Veiculo();
                orc.setHodometroAntigo(Integer.parseInt(jTxtHodometroAnterior.getText()));
                orc.setHodometroAtual(Integer.parseInt(jTxtHodometroAtual.getText()));
                orc.setDataServico((java.sql.Date) converteData(jTxtDataServico.getText()));
                id.setIdVeiculo(Integer.parseInt(jTveiculoId.getText()));
                orc.setVeiculoId(id);
                resposta = dao.gerarOrcamento(orc);

                if (resposta == 1) {
                    JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso");
                    preencherTabelaOs();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar inserir dados");
                }

            }
        }
        dao.desconectar();
    }//GEN-LAST:event_jBtnCriarOsActionPerformed

    private void jTabelaOsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaOsMouseClicked
        OrcamentoDao dao = new OrcamentoDao();
        boolean status = dao.conectar();

        if (status == true) {
            int linhaSelecionada = jTabelaOs.getSelectedRow();
            String idSt = String.valueOf(jTabelaOs.getValueAt(linhaSelecionada, 0));
            int id = Integer.parseInt(idSt);
            Orcamento orc = dao.cosultaOrcamentoTabela(id);
            jTxtPlaca.setEditable(false);
            jTxtPlaca.setText(orc.getVeiculoId().getPlaca());
            jTxtHodometroAnterior.setText(String.valueOf(orc.getHodometroAntigo()));
            jTxtHodometroAtual.setText(String.valueOf(orc.getHodometroAtual()));
            jTveiculoId.setText(String.valueOf(orc.getVeiculoId().getIdVeiculo()));
            jTxtDataServico.setText(formataDataSql("dd/MM/YYYY", orc.getDataServico()));
            jTxtOrdemServico.setText(String.valueOf(orc.getIdOrcamento()));
            jTxtNunOs.setText(String.valueOf(orc.getIdOrcamento()));
            dao.desconectar();
            preencherTabelaPeca(id);
            jBtnExcluirOs.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
    }//GEN-LAST:event_jTabelaOsMouseClicked

    private void jBtnAdicionarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarPecaActionPerformed
        Peca pc = new Peca();
        PecaDao dao = new PecaDao();
        boolean status;
        int resposta;
        double valorTotal;

        if (jTxtDescricaoPeca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma peça que deseja adicionar");
        } else if (jTxtValorUnt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o valor unitário");
        } else if (jTxtQuantidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade");
        } else {
            String desc = jTxtDescricaoPeca.getText().toUpperCase();
            double valorUnt = Double.parseDouble(jTxtValorUnt.getText().replace(",", "."));
            double qnt = Double.parseDouble(jTxtQuantidade.getText().replace(",", "."));
            int porcento = Integer.parseInt(jTxtPorcento.getText());
            if ("MO".equals(desc)) {
                valorTotal = valorUnt * qnt;
                porcento = 0;
            } else {
                valorTotal = ((valorUnt * porcento / 100) + valorUnt) * qnt;
            }

            status = dao.conectar();
            int idOrc = Integer.parseInt(jTxtOrdemServico.getText());
            if (status == false) {
                JOptionPane.showMessageDialog(null, "Erro de conexão");
            } else {
                pc.setDescricao(desc);
                pc.setValorUnt(valorUnt);
                pc.setQuantidade(qnt);
                pc.setPorcento(porcento);
                pc.setValorTotal(valorTotal);
                pc.setValorPunt((valorUnt*porcento/100)+valorUnt);
                Orcamento orc = new Orcamento();
                orc.setIdOrcamento(idOrc);
                pc.setOrcamentoId(orc);

                resposta = dao.inserirPeca(pc);

                if (resposta == 1) {
                    JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso");
                    limpaTelaPecas();
                    preencherTabelaPeca(idOrc);                 
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar inserir dados");
                }
            }
        }
        dao.desconectar();

    }//GEN-LAST:event_jBtnAdicionarPecaActionPerformed

    private void jBtnExcluirOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirOsActionPerformed
        int idOrcamento = Integer.parseInt(jTxtOrdemServico.getText());
        OrcamentoDao dao = new OrcamentoDao();
        boolean status = dao.conectar();

        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            boolean operacao = dao.excluir(idOrcamento);
            if (operacao == true) {
                JOptionPane.showMessageDialog(null, "Orçamento excluido:");
                limpaTelaVeiculo();
                preencherTabelaOs();
            } else {
                JOptionPane.showMessageDialog(null, "Erro na exclusão do veiculo");
            }
            dao.desconectar();
        }
    }//GEN-LAST:event_jBtnExcluirOsActionPerformed

    private void jBtnExcluirItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirItensActionPerformed
        int idPeca = Integer.parseInt(jTxtIdPeca.getText());
        int idOrc = Integer.parseInt(jTxtNunOs.getText());
        PecaDao dao = new PecaDao();
        boolean status = dao.conectar();

        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            boolean operacao = dao.excluirPeca(idPeca);
            if (operacao == true) {
                JOptionPane.showMessageDialog(null, "Peça excluida:");
                limpaTelaPecas();
                preencherTabelaPeca(idOrc);
            } else {
                JOptionPane.showMessageDialog(null, "Erro na exclusão da peça");
            }
            dao.desconectar();
        }
    }//GEN-LAST:event_jBtnExcluirItensActionPerformed

    private void mbtnVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnVeiculoActionPerformed
        CadastrarVeiculo veiculo = new CadastrarVeiculo();
        veiculo.setVisible(true);
        dispose();
    }//GEN-LAST:event_mbtnVeiculoActionPerformed

    private void mbtnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnClienteActionPerformed
        CadastroCliente cliente = new CadastroCliente();
        cliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_mbtnClienteActionPerformed

    private void mbtnGerarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtnGerarOsActionPerformed
        OrcamentoDao dao = new OrcamentoDao();
        Map<String, Object> map = new HashMap<>();
        String parametro = jTxtOrdemServico.getText();

        if (parametro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma ordem de serviço");
        } else {
            String caminho = "src/Imagens/blank.jrxml";
            String total = jTxtTotal.getText();
            map.put("os", parametro);
            map.put("total", total);
            dao.relatorioOS(caminho, map);
        }
    }//GEN-LAST:event_mbtnGerarOsActionPerformed

    private void jTabelaPecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPecaMouseClicked
        PecaDao dao = new PecaDao();
        boolean status = dao.conectar();

        if (status == true) {
            int linhaSelecionada = jTabelaPeca.getSelectedRow();
            String idSt = String.valueOf(jTabelaPeca.getValueAt(linhaSelecionada, 0));
            int id = Integer.parseInt(idSt);

            Peca pc = dao.consultaPeca(id);
            jTxtIdPeca.setText(String.valueOf(pc.getIdPeca()));
            jTxtDescricaoPeca.setText(pc.getDescricao());
            jTxtValorUnt.setText(String.valueOf(pc.getValorUnt()));
            jTxtQuantidade.setText(String.valueOf(pc.getQuantidade()));
            jTxtPorcento.setText(String.valueOf(pc.getPorcento()));
            jBtnExcluirItens.setEnabled(true);
            dao.desconectar();

        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
    }//GEN-LAST:event_jTabelaPecaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdemServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdicionarPeca;
    private javax.swing.JButton jBtnConsultarPlaca;
    private javax.swing.JButton jBtnCriarOs;
    private javax.swing.JButton jBtnExcluirItens;
    private javax.swing.JButton jBtnExcluirOs;
    private javax.swing.JButton jBtnLimparOs;
    private javax.swing.JButton jBtnLimparPeca;
    private javax.swing.JButton jBtnVoltarOs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable jTabelaOs;
    private javax.swing.JTable jTabelaPeca;
    private javax.swing.JTextField jTveiculoId;
    private javax.swing.JFormattedTextField jTxtDataServico;
    private javax.swing.JTextField jTxtDescricaoPeca;
    private javax.swing.JTextField jTxtHodometroAnterior;
    private javax.swing.JTextField jTxtHodometroAtual;
    private javax.swing.JTextField jTxtIdPeca;
    private javax.swing.JTextField jTxtNunOs;
    private javax.swing.JTextField jTxtOrdemServico;
    private javax.swing.JTextField jTxtPlaca;
    private javax.swing.JTextField jTxtPorcento;
    private javax.swing.JTextField jTxtQuantidade;
    private javax.swing.JTextField jTxtTotal;
    private javax.swing.JTextField jTxtValorUnt;
    private javax.swing.JMenuItem mbtnCliente;
    private javax.swing.JMenuItem mbtnGerarOs;
    private javax.swing.JMenu mbtnRelatorio;
    private javax.swing.JMenuItem mbtnVeiculo;
    // End of variables declaration//GEN-END:variables
}
