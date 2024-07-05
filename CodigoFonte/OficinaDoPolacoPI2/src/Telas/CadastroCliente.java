package Telas;

import Dados.Cliente;
import Dados.ClienteDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class CadastroCliente extends javax.swing.JFrame {
    
    public void limpaTela() {
        jTxtNome.setText("");
        jTxtCpf.setText("");
        jTxtRg.setText("");
        jTxtRua.setText("");
        jTxtNumero.setText("");
        jTxtBairro.setText("");
        jTxtCep.setText("");
        jTxtCidade.setText("");
        jTxtEstado.setText("");
        jTxtTelefone.setText("");
        jTxtCpf.setEditable(true);
        jBtnExcluir.setEnabled(false);
        jBtnEditar.setEnabled(false);
    }
    
    public void validaDados() {
        String nome = jTxtNome.getText();
        String cpf = jTxtCpf.getText().replace(".", "").replace("-", "");
        String rg = jTxtRg.getText();
        String rua = jTxtRua.getText();
        String numero = jTxtNumero.getText();
        String bairro = jTxtBairro.getText();
        String cep = jTxtCep.getText();
        String cidade = jTxtCidade.getText();
        String estado = jTxtEstado.getText();
        String telefone = jTxtTelefone.getText();
        
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe um nome");
        } else if (rg.isEmpty()) {
            JOptionPane.showMessageDialog(null, "informe um RG");
        } else if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(null, "informe um CPF");
        } else if (telefone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "informe um telefone");
        } else if (rua.isEmpty()) {
            JOptionPane.showMessageDialog(null, "informe uma rua");
        } else if (numero.isEmpty()) {
            JOptionPane.showMessageDialog(null, "informe um número");
        } else if (cep.isEmpty()) {
            JOptionPane.showMessageDialog(null, "informe um cep");
        } else if (bairro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "informe um bairro");
        } else if (cidade.isEmpty()) {
            JOptionPane.showMessageDialog(null, "informe uma cidade");
        } else if (estado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "informe um estado");
        }
    }
    
    private void preencherTabela(String filtro) {
        ClienteDao dao = new ClienteDao();
        boolean satatus = dao.conectar();
        
        if (satatus == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            List<Cliente> listaCliente = dao.listar(filtro);
            
            DefaultTableModel tabelaCliente = (DefaultTableModel) jTcliente.getModel();
            jTcliente.setRowSorter(new TableRowSorter(tabelaCliente));
            tabelaCliente.setNumRows(0);
            
            for (Cliente c : listaCliente) {
                Object[] obj = new Object[]{
                    c.getNome(),
                    c.getRg(),
                    c.getCpf(),
                    c.getTelefone(),
                    c.getRua(),
                    c.getNumero(),
                    c.getCep(),
                    c.getBairro(),
                    c.getCidade(),
                    c.getEstado()
                };
                tabelaCliente.addRow(obj);
            }
            dao.desconectar();
        }
    }
    
    public CadastroCliente() {
        initComponents();
        preencherTabela("");
        limpaTela();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTxtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtRg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtCpf = new javax.swing.JFormattedTextField();
        jTxtTelefone = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTxtCidade = new javax.swing.JTextField();
        jTxtEstado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtBairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTxtRua = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTxtNumero = new javax.swing.JTextField();
        jTxtCep = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jBtnConsultar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnLimpar = new javax.swing.JButton();
        jBtnvoltar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTcliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Oficina Cadastro Clientes");
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

        jTxtNome.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel3.setText("CPF:");

        jTxtRg.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtRg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setText("RG:");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Dados Pessoais:");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setText("Telefone:");

        jTxtCpf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        try {
            jTxtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTxtCpf.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jTxtTelefone.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        try {
            jTxtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTxtTelefone.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCpf))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtTelefone))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(1055, 160));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel7.setText("Cep:");

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel8.setText("Cidade:");

        jTxtCidade.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtCidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTxtEstado.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtEstado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel9.setText("Estado:");

        jTxtBairro.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtBairro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel10.setText("Bairro:");

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel11.setText("Endereço:");

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel12.setText("Rua:");

        jTxtRua.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtRua.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel13.setText("Nº:");

        jTxtNumero.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jTxtNumero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTxtCep.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        try {
            jTxtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTxtCep.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCep, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtBairro)
                            .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtRua, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtNumero))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel14.setText("Cadastrar Clientes");

        jBtnConsultar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnConsultar.setText("Consultar / CPF");
        jBtnConsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConsultarActionPerformed(evt);
            }
        });

        jBtnEditar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnEditar.setText("Editar");
        jBtnEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnSalvar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnSalvar.setText("Salvar Novo");
        jBtnSalvar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });

        jBtnExcluir.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnLimpar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnLimpar.setText("Limpar");
        jBtnLimpar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimparActionPerformed(evt);
            }
        });

        jBtnvoltar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jBtnvoltar.setText("Voltar");
        jBtnvoltar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnvoltarActionPerformed(evt);
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
                            .addComponent(jBtnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnLimpar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel14))
                    .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jBtnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jBtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTcliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "RG", "CPF", "Telefone", "Rua", "Nº", "CEP", "Bairro", "Cidade", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTcliente);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
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
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnvoltarActionPerformed
        OrdemServico menu = new OrdemServico();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBtnvoltarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        OrdemServico menu = new OrdemServico();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jBtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimparActionPerformed
        limpaTela();
    }//GEN-LAST:event_jBtnLimparActionPerformed

    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        validaDados();
        Cliente cliente = new Cliente();
        ClienteDao dao = new ClienteDao();
        boolean status;
        int resposta;
        
        status = dao.conectar();
        
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            String cpf = jTxtCpf.getText().replace(".", "").replace("-", "");
            Cliente cli = dao.consulta(cpf);
            if (cli == null) {
                cliente.setNome(jTxtNome.getText());
                cliente.setRg(jTxtRg.getText());
                cliente.setCpf(cpf);
                cliente.setTelefone(jTxtTelefone.getText());
                cliente.setRua(jTxtRua.getText());
                cliente.setNumero(Integer.parseInt(jTxtNumero.getText()));
                cliente.setCep(jTxtCep.getText());
                cliente.setBairro(jTxtBairro.getText());
                cliente.setCidade(jTxtCidade.getText());
                cliente.setEstado(jTxtEstado.getText());
                
                resposta = dao.salvar(cliente);
                preencherTabela("");
                if (resposta == 1) {
                    JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso");
                    limpaTela();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar inserir dados");
                }
            } else {
                JOptionPane.showMessageDialog(null, "CPF ja cadastrado.");
            }
        }
        dao.desconectar();
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void jBtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConsultarActionPerformed
        String cpf = jTxtCpf.getText().replace(".", "").replace("-", "");
        ClienteDao dao = new ClienteDao();
        boolean status = dao.conectar();
        //dao.consulta(cpf);
        
        if (status == true) {
            Cliente cliente = dao.consulta(cpf);
            
            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "Cliente não localizado");
            } else {
                jTxtCpf.setEditable(false);
                jTxtCpf.setText(cliente.getCpf());
                jTxtNome.setText(cliente.getNome());
                jTxtRg.setText(cliente.getRg());
                jTxtTelefone.setText(cliente.getTelefone());
                jTxtRua.setText(cliente.getRua());
                jTxtNumero.setText(String.valueOf(cliente.getNumero()));
                jTxtCep.setText(cliente.getCep());
                jTxtBairro.setText(cliente.getBairro());
                jTxtCidade.setText(cliente.getCidade());
                jTxtEstado.setText(cliente.getEstado());
            }
            jBtnExcluir.setEnabled(true);
            jBtnEditar.setEnabled(true);
            dao.desconectar();
        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }

    }//GEN-LAST:event_jBtnConsultarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        String cpf;
        ClienteDao dao = new ClienteDao();
        boolean status = dao.conectar();
        
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            cpf = jTxtCpf.getText().replace(".", "").replace("-", "");
            boolean operacao = dao.excluir(cpf);
            
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja excluir pemanentemente","Confirmação exclusão",
                JOptionPane.YES_NO_OPTION);
            if(resposta == JOptionPane.YES_OPTION){
            if (operacao == true) {
                JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
                this.limpaTela();
                preencherTabela("");
            } else {
                JOptionPane.showMessageDialog(null, "Erro na exclusão do Cliente");
            }
            }
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        Cliente cliente = new Cliente();
        ClienteDao dao = new ClienteDao();
        boolean status;
        int resposta;
        
        cliente.setNome(jTxtNome.getText());
        cliente.setRg(jTxtRg.getText());
        cliente.setCpf(jTxtCpf.getText().replace(".", "").replace("-", ""));
        cliente.setTelefone(jTxtTelefone.getText());
        cliente.setRua(jTxtRua.getText());
        cliente.setNumero(Integer.parseInt(jTxtNumero.getText()));
        cliente.setCep(jTxtCep.getText());
        cliente.setBairro(jTxtBairro.getText());
        cliente.setCidade(jTxtCidade.getText());
        cliente.setEstado(jTxtEstado.getText());
        
        status = dao.conectar();
        
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            resposta = dao.atualizar(cliente);
            if (resposta == 1) {
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
                preencherTabela("");
                limpaTela();
            } else if (resposta == 1062) {
                JOptionPane.showMessageDialog(null, "Matricula já foi cadastrada");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar dados");
            }
        }
        dao.desconectar();
    }//GEN-LAST:event_jBtnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnConsultar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnLimpar;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JButton jBtnvoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTcliente;
    private javax.swing.JTextField jTxtBairro;
    private javax.swing.JFormattedTextField jTxtCep;
    private javax.swing.JTextField jTxtCidade;
    private javax.swing.JFormattedTextField jTxtCpf;
    private javax.swing.JTextField jTxtEstado;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtNumero;
    private javax.swing.JTextField jTxtRg;
    private javax.swing.JTextField jTxtRua;
    private javax.swing.JFormattedTextField jTxtTelefone;
    // End of variables declaration//GEN-END:variables
}
