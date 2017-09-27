package view;

import controller.ControllerProduto;
import controller.ControllerQuarto;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelProduto;

/**
 *
 * @author Anderson
 */
public class ViewProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewProduto
     */
    public ViewProduto() {
        initComponents();
        this.mostrar("");
        this.desativar_Campos();
    }

    //Método para abrir jinternalframe centralizado
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }//FIM DA CLASSE setPosicao

    private String acao;

    //Método para ocultar linha e colunas da tabela Lista de Quartos
    public void ocultar_colunas() {
        tblLista.getColumnModel().getColumn(0).setMaxWidth(0);
        tblLista.getColumnModel().getColumn(0).setMinWidth(0);
        tblLista.getColumnModel().getColumn(0).setPreferredWidth(0);
    }//FIM DA CLASSE ocultar_colunas

    //Método para desativar e limpar os campos
    public void desativar_Campos() {
        txtIdProduto.setVisible(false);
        txtNome.setEnabled(false);
        txtDescricao.setEnabled(false);
        txtPrecoVenda.setEnabled(false);
        cboUnidadeMedida.setEnabled(false);

        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnExcluir.setEnabled(false);

        txtIdProduto.setText("");
        txtPrecoVenda.setText("");
        txtDescricao.setText("");
        txtNome.setText("");
    }//FIM DA CLASSE desativar_Campos

    //Método para habilitar e limpar os campos
    public void habilitar_Campos() {
        txtIdProduto.setVisible(false);
        txtNome.setEnabled(true);
        txtDescricao.setEnabled(true);
        cboUnidadeMedida.setEnabled(true);
        txtPrecoVenda.setEnabled(true);

        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnExcluir.setEnabled(true);

        txtIdProduto.setText("");
        txtDescricao.setText("");
        txtPrecoVenda.setText("");
        txtNome.setText("");

    }//FIM DA CLASSE habilitar_Campos

    //Método para mostrar consultas no banco de dados
    public void mostrar(String buscar) {
        try {

            //Instância da classe ControllerQuarto
            ControllerProduto func = new ControllerProduto();

            //Instância da classe DefaultTableModel
            DefaultTableModel tabelaProduto = func.mostrar(buscar);

            tblLista.setModel(tabelaProduto);
            lblTotalRegistros.setText("Total Registros: " + func.totalRegistros);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }//FIM DA CLASSE mostrar

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblTotalRegistros = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtIdProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtPrecoVenda = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboUnidadeMedida = new javax.swing.JComboBox();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setTitle("Cadastro de Produtos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Produtos"));

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblLista);

        jLabel9.setText("Buscar");

        btnBuscar.setBackground(new java.awt.Color(51, 51, 51));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(51, 51, 51));
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(51, 51, 51));
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblTotalRegistros.setText("Registros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addComponent(lblTotalRegistros))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar Produtos"));

        jLabel2.setText("Nome:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel4.setText("Descrição");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        jLabel6.setText("Preço Venda:");

        txtPrecoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoVendaActionPerformed(evt);
            }
        });

        jLabel7.setText("Unidades Medida");

        cboUnidadeMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UND", "KG", "LT" }));
        cboUnidadeMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUnidadeMedidaActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(51, 51, 51));
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("Novo");
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(51, 51, 51));
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnNovo)
                                        .addGap(61, 61, 61)
                                        .addComponent(btnSalvar)
                                        .addGap(58, 58, 58)
                                        .addComponent(btnCancelar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(44, 44, 44)
                                        .addComponent(cboUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(61, 61, 61)
                                        .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(79, 79, 79)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(101, 101, 101))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1053, 531);
    }// </editor-fold>//GEN-END:initComponents

    private void tblListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMouseClicked

        btnSalvar.setText("Editar");
        this.habilitar_Campos();
        btnExcluir.setEnabled(true);
        this.acao = "Editar";

        //Seleção da tabela tblLista produtos
        int linha = tblLista.rowAtPoint(evt.getPoint());
        txtIdProduto.setText(tblLista.getValueAt(linha, 0).toString());
        txtNome.setText(tblLista.getValueAt(linha, 1).toString());
        txtDescricao.setText(tblLista.getValueAt(linha, 2).toString());
        cboUnidadeMedida.setSelectedItem(tblLista.getValueAt(linha, 3).toString());
        txtPrecoVenda.setText(tblLista.getValueAt(linha, 4).toString());
    }//GEN-LAST:event_tblListaMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.mostrar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        if (!txtIdProduto.getText().equals("")) {
            int confirmar = JOptionPane.showConfirmDialog(null, "Você tem certeza de excluir o produto?", "Confirmar", 2);

            if (confirmar == 0) {

                //Instância da classe ModelProduto
                ModelProduto pro = new ModelProduto();

                //Instância classe ControllerProduto
                ControllerProduto func = new ControllerProduto();

                pro.setId_produto(Integer.parseInt(txtIdProduto.getText()));
                func.excluir(pro);
                this.mostrar("");
                this.desativar_Campos();

            }

        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        txtNome.transferFocus();
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtPrecoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoVendaActionPerformed

        txtPrecoVenda.transferFocus();
    }//GEN-LAST:event_txtPrecoVendaActionPerformed

    private void cboUnidadeMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUnidadeMedidaActionPerformed
        cboUnidadeMedida.transferFocus();
    }//GEN-LAST:event_cboUnidadeMedidaActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitar_Campos();
        btnSalvar.setText("Salvar");
        this.acao = "Salvar";
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        //Válidação dos Campos de cadastro
        if (txtNome.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Você deve inserir o nome do produto");
            txtNome.requestFocus();
            return;
        }
        if (txtDescricao.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Você deve inserir uma descrição para o produto");
            txtDescricao.requestFocus();
            return;
        }
        if (txtPrecoVenda.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Você deve inserir um preço para o produto");
            txtPrecoVenda.requestFocus();
            return;
        }

        //Instância da classe ModelProduto
        ModelProduto pro = new ModelProduto();

        //Instância da classe ControllerProduto
        ControllerProduto func = new ControllerProduto();

        pro.setNome(txtNome.getText());
        pro.setDescricao(txtDescricao.getText());

        int selecionado = cboUnidadeMedida.getSelectedIndex();
        pro.setUnidad_medida((String) cboUnidadeMedida.getItemAt(selecionado));

        pro.setPreco_venda(Double.parseDouble(txtPrecoVenda.getText()));

        if (this.acao.equals("Salvar")) {

            if (func.inserir(pro)) {
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                this.mostrar("");
                this.desativar_Campos();
            }

        } else if (this.acao.equals("Editar")) {
            pro.setId_produto(Integer.parseInt(txtIdProduto.getText()));

            if (func.editar(pro)) {
                JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
                this.mostrar("");
                this.desativar_Campos();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.desativar_Campos();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cboUnidadeMedida;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPrecoVenda;
    // End of variables declaration//GEN-END:variables
}
