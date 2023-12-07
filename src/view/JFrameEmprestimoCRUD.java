package view;

import controller.LogTrack;
import java.awt.event.WindowEvent;
import model.CopiaObra;
import model.Emprestimo;
import model.Usuario;

public class JFrameEmprestimoCRUD extends javax.swing.JFrame {

    private Emprestimo emprestimo;
    private Usuario cliente;
    private CopiaObra copiaObra;
    
    private boolean disconnectOnClose;
    
    public JFrameEmprestimoCRUD(Emprestimo emprestimo, boolean disconnectOnClose) throws Exception {
        initComponents();
        
        if(emprestimo == null) {
            this.emprestimo = new Emprestimo();
        } else {
            this.emprestimo = emprestimo;
            
            if(this.emprestimo.getUsuario() != null) {
                this.cliente = new Usuario();
                this.cliente.setCodUsuario(this.emprestimo.getUsuario().getCodUsuario());
                this.cliente.load();
            }
        
            dataUp();
            jTextFieldCliente.setEnabled(false);
            jTextFieldDataEmprestimo.setEnabled(false);
            jTextFieldID.setEnabled(false);
            jTextFieldIDCopiaObra.setEnabled(false);
            jTextFieldMulta.setEnabled(false);
            jButtonApagarCliente.setEnabled(false);
            jButtonApagarIDCopiaObra.setEnabled(false);
        }
        
        this.disconnectOnClose = disconnectOnClose;
    }

    private void checkInput() throws Exception {
        
        if(jTextFieldID.getText().isEmpty()) {
            throw new Exception("Informe ID.");
        } else {
            if(!jTextFieldID.getText().matches("\\d+")) {
                throw new Exception("O campo ID deve ser um número.");
            }
        }
    }
    
    private void dataDown() throws Exception {
        emprestimo.setCodEmprestimo(Integer.parseInt(jTextFieldID.getText()));
        emprestimo.setDataEmprestimo(jTextFieldDataEmprestimo.getText());
        
        if(jTextFieldDataDevolucao.getText() != null){
            emprestimo.setDataDevolucao(jTextFieldDataDevolucao.getText());
        }
        
        emprestimo.setValorMulta(Float.parseFloat(jTextFieldMulta.getText()));
        
        emprestimo.setUsuario(cliente);
        
        emprestimo.setCopiaObra(copiaObra);
    }
    
    private void dataUp() {
        jTextFieldID.setText(String.valueOf(emprestimo.getCodEmprestimo()));
        jTextFieldDataEmprestimo.setText(emprestimo.getDataEmprestimo());
        
        jTextFieldDataDevolucao.setText(emprestimo.getDataDevolucao());
        
        jTextFieldMulta.setText(String.valueOf(emprestimo.getValorMulta()));
        
        if(emprestimo.getUsuario().getNomeCompleto() != null) {
            jTextFieldCliente.setText(emprestimo.getUsuario().getNomeCompleto());
        }
        
        jTextFieldIDCopiaObra.setText(String.valueOf(emprestimo.getCopiaObra().getCodCopiaObra()));
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelID = new javax.swing.JLabel();
        jLabelDataEmprestimo = new javax.swing.JLabel();
        jLabelDataDevolucao = new javax.swing.JLabel();
        jLabelMulta = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jLabelIDCopiaObra = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldDataEmprestimo = new javax.swing.JTextField();
        jTextFieldIDCopiaObra = new javax.swing.JTextField();
        jTextFieldDataDevolucao = new javax.swing.JTextField();
        jTextFieldMulta = new javax.swing.JTextField();
        jTextFieldCliente = new javax.swing.JTextField();
        jButtonSelecionarCliente = new javax.swing.JButton();
        jButtonSelecionarIDCopiaObra = new javax.swing.JButton();
        jButtonApagarCliente = new javax.swing.JButton();
        jButtonApagarIDCopiaObra = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelID.setText("ID");

        jLabelDataEmprestimo.setText("Data Empréstimo");

        jLabelDataDevolucao.setText("Data Devolução");

        jLabelMulta.setText("Valor Multa");

        jLabelCliente.setText("Cliente");

        jLabelIDCopiaObra.setText("ID Cópia Obra");

        jButtonSelecionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarClienteActionPerformed(evt);
            }
        });

        jButtonSelecionarIDCopiaObra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/search-icon.png"))); // NOI18N
        jButtonSelecionarIDCopiaObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarIDCopiaObraActionPerformed(evt);
            }
        });

        jButtonApagarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarClienteActionPerformed(evt);
            }
        });

        jButtonApagarIDCopiaObra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/eraser-icon.png"))); // NOI18N
        jButtonApagarIDCopiaObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarIDCopiaObraActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldID))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIDCopiaObra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIDCopiaObra, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSelecionarIDCopiaObra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonApagarIDCopiaObra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDataEmprestimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDataEmprestimo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDataDevolucao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDataDevolucao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelMulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMulta))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSelecionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonApagarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataEmprestimo)
                    .addComponent(jTextFieldDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataDevolucao)
                    .addComponent(jTextFieldDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMulta)
                    .addComponent(jTextFieldMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCliente)
                        .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonSelecionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonApagarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelIDCopiaObra)
                        .addComponent(jTextFieldIDCopiaObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonSelecionarIDCopiaObra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonApagarIDCopiaObra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        System.out.println("Excluir");

        try {
            checkInput();
            dataDown();
            emprestimo.delete();
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            checkInput();
            dataDown();
            emprestimo.save();
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        } catch(Exception ex) {            
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarClienteActionPerformed
        try {
            if(cliente == null) {
                cliente = new Usuario();
            }
            
            JFrameConsultaUsuario crud;
            crud = new JFrameConsultaUsuario(true, false, cliente);
            
            crud.addWindowListener(new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if(cliente.getNomeCompleto() != null) {
                        jTextFieldCliente.setText(cliente.getNomeCompleto());
                    }
                }
            });
            
            crud.setVisible(true);
        } catch(Exception ex) {
            ex.printStackTrace();
            cliente = null;
        }
    }//GEN-LAST:event_jButtonSelecionarClienteActionPerformed

    private void jButtonApagarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarClienteActionPerformed
        cliente = null;
        jTextFieldCliente.setText(null);
    }//GEN-LAST:event_jButtonApagarClienteActionPerformed

    private void jButtonSelecionarIDCopiaObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarIDCopiaObraActionPerformed
        try {
            if(copiaObra == null) {
                copiaObra = new CopiaObra();
            }
            
            JFrameConsultaCopiaObra crud;
            crud = new JFrameConsultaCopiaObra(true, false, copiaObra);
            
            crud.addWindowListener(new java.awt.event.WindowAdapter(){
                @Override
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if(copiaObra.getObraLiteraria().getTitulo() != null) {
                        jTextFieldIDCopiaObra.setText(String.valueOf(copiaObra.getCodCopiaObra()));
                    }
                }
            });
            
            crud.setVisible(true);
        } catch(Exception ex) {
            ex.printStackTrace();
            copiaObra = null;
        }
    }//GEN-LAST:event_jButtonSelecionarIDCopiaObraActionPerformed

    private void jButtonApagarIDCopiaObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarIDCopiaObraActionPerformed
        // TODO add your handling code here:
        copiaObra = null;
        jTextFieldIDCopiaObra.setText(null);
    }//GEN-LAST:event_jButtonApagarIDCopiaObraActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagarCliente;
    private javax.swing.JButton jButtonApagarIDCopiaObra;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionarCliente;
    private javax.swing.JButton jButtonSelecionarIDCopiaObra;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelDataDevolucao;
    private javax.swing.JLabel jLabelDataEmprestimo;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelIDCopiaObra;
    private javax.swing.JLabel jLabelMulta;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldDataDevolucao;
    private javax.swing.JTextField jTextFieldDataEmprestimo;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldIDCopiaObra;
    private javax.swing.JTextField jTextFieldMulta;
    // End of variables declaration//GEN-END:variables
}