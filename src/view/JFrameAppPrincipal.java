package view;

import controller.LogTrack;
import model.Usuario;

/**
 *
 * @author Vitor
 */
public class JFrameAppPrincipal extends javax.swing.JFrame {

    private Usuario usuario;
    
    public JFrameAppPrincipal() {
        initComponents();
        
        logout();
    }

    private void logout() {
        usuario = new Usuario();
        
        jMenuAdministrativo.setEnabled(false);
        jMenuAtendimento.setEnabled(false);
        
        jMenuUsuario.setVisible(false);
        
        jPanelLogin.setVisible(true);
    }
    
    private void login() {
        jMenuUsuario.setText(usuario.getNomeCompleto());
        jMenuUsuario.setVisible(true);
        
        jTextFieldUsuario.setText("");
        jPasswordFieldSenha.setText("");
        
        jPanelLogin.setVisible(false);
        
        if(usuario.getTipoUsuario().getModAdministrativo().equals("S")) {
            jMenuAdministrativo.setEnabled(true);
        }
        
        if(usuario.getTipoUsuario().getModAtendimento().equals("S")) {
            jMenuAtendimento.setEnabled(true);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jPanelLogin = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAdministrativo = new javax.swing.JMenu();
        jMenuItemConsultaTipoUsuario = new javax.swing.JMenuItem();
        jMenuItemConsultaUsuario = new javax.swing.JMenuItem();
        jMenuItemConsultaTipoObra = new javax.swing.JMenuItem();
        jMenuItemConsultaObra = new javax.swing.JMenuItem();
        jMenuItemConsultaCopiaObra = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCadastroTipoUsuario = new javax.swing.JMenuItem();
        jMenuItemCadastroUsuario = new javax.swing.JMenuItem();
        jMenuItemCadastroTipoObra = new javax.swing.JMenuItem();
        jMenuItemCadastroObra = new javax.swing.JMenuItem();
        jMenuItemCadastroCopiaObra = new javax.swing.JMenuItem();
        jMenuAtendimento = new javax.swing.JMenu();
        jMenuItemConsultaEmprestimo = new javax.swing.JMenuItem();
        jMenuUsuario = new javax.swing.JMenu();
        jMenuItemMeusEmprestimos = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        jMenuItem14.setText("jMenuItem14");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gerenciamento de Biblioteca");

        jPanelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelUsuario.setText("Usuário");

        jLabelSenha.setText("Senha");

        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelSenha)
                            .addComponent(jLabelUsuario)
                            .addComponent(jTextFieldUsuario)
                            .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButtonLogin)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLogin)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jMenuAdministrativo.setText("Administrativo");

        jMenuItemConsultaTipoUsuario.setText("Consulta Tipo Usuário");
        jMenuItemConsultaTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaTipoUsuarioActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaTipoUsuario);

        jMenuItemConsultaUsuario.setText("Consulta Usuário");
        jMenuItemConsultaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaUsuarioActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaUsuario);

        jMenuItemConsultaTipoObra.setText("Consulta Tipo Obra");
        jMenuItemConsultaTipoObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaTipoObraActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaTipoObra);

        jMenuItemConsultaObra.setText("Consulta Obra Literária");
        jMenuItemConsultaObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaObraActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaObra);

        jMenuItemConsultaCopiaObra.setText("Consulta Cópia de Obra");
        jMenuItemConsultaCopiaObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaCopiaObraActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemConsultaCopiaObra);
        jMenuAdministrativo.add(jSeparator1);

        jMenuItemCadastroTipoUsuario.setText("Cadastro Tipo Usuário");
        jMenuItemCadastroTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroTipoUsuarioActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroTipoUsuario);

        jMenuItemCadastroUsuario.setText("Cadastro Usuários");
        jMenuItemCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroUsuarioActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroUsuario);

        jMenuItemCadastroTipoObra.setText("Cadastro Tipo Obra");
        jMenuItemCadastroTipoObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroTipoObraActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroTipoObra);

        jMenuItemCadastroObra.setText("Cadastro Obra Literária");
        jMenuItemCadastroObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroObraActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroObra);

        jMenuItemCadastroCopiaObra.setText("Cadastro Cópia de Obra");
        jMenuItemCadastroCopiaObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroCopiaObraActionPerformed(evt);
            }
        });
        jMenuAdministrativo.add(jMenuItemCadastroCopiaObra);

        jMenuBar1.add(jMenuAdministrativo);

        jMenuAtendimento.setText("Atendimento");

        jMenuItemConsultaEmprestimo.setText("Consulta Empréstimos");
        jMenuItemConsultaEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaEmprestimoActionPerformed(evt);
            }
        });
        jMenuAtendimento.add(jMenuItemConsultaEmprestimo);

        jMenuBar1.add(jMenuAtendimento);

        jMenuUsuario.setText("Usuário");

        jMenuItemMeusEmprestimos.setText("Meus Empréstimos");
        jMenuItemMeusEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMeusEmprestimosActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuItemMeusEmprestimos);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuItemSair);

        jMenuBar1.add(jMenuUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastroTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroTipoUsuarioActionPerformed
        try {
            JFrameTipoUsuarioCRUD jFrameCRUD;
            jFrameCRUD = new JFrameTipoUsuarioCRUD(null, true);
            jFrameCRUD.setVisible(true);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemCadastroTipoUsuarioActionPerformed

    private void jMenuItemCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroUsuarioActionPerformed
        try {
            JFrameUsuarioCRUD jFrameCRUD;
            jFrameCRUD = new JFrameUsuarioCRUD(null, true);
            jFrameCRUD.setVisible(true);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemCadastroUsuarioActionPerformed

    private void jMenuItemCadastroTipoObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroTipoObraActionPerformed
        try {
            JFrameTipoObraCRUD jFrameCRUD;
            jFrameCRUD = new JFrameTipoObraCRUD(null, true);
            jFrameCRUD.setVisible(true);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemCadastroTipoObraActionPerformed

    private void jMenuItemCadastroObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroObraActionPerformed
        try {
            JFrameObraLiterariaCRUD jFrameCRUD;
            jFrameCRUD = new JFrameObraLiterariaCRUD(null, true);
            jFrameCRUD.setVisible(true);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemCadastroObraActionPerformed

    private void jMenuItemCadastroCopiaObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroCopiaObraActionPerformed
        try {
            JFrameCopiaObraCRUD jFrameCRUD;
            jFrameCRUD = new JFrameCopiaObraCRUD(null, true);
            jFrameCRUD.setVisible(true);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemCadastroCopiaObraActionPerformed

    private void jMenuItemConsultaTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaTipoUsuarioActionPerformed
        try {
            JFrameConsultaTipoUsuario jFrameConsulta;
            jFrameConsulta = new JFrameConsultaTipoUsuario( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemConsultaTipoUsuarioActionPerformed

    private void jMenuItemConsultaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaUsuarioActionPerformed
        try {
            JFrameConsultaUsuario jFrameConsulta;
            jFrameConsulta = new JFrameConsultaUsuario(false, true, null);
            jFrameConsulta.setVisible(true);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemConsultaUsuarioActionPerformed

    private void jMenuItemConsultaTipoObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaTipoObraActionPerformed
        try {
            JFrameConsultaTipoObra jFrameConsulta;
            jFrameConsulta = new JFrameConsultaTipoObra(false, true, null);
            jFrameConsulta.setVisible(true);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemConsultaTipoObraActionPerformed

    private void jMenuItemConsultaObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaObraActionPerformed
        try {
            JFrameConsultaObraLiteraria jFrameConsulta;
            jFrameConsulta = new JFrameConsultaObraLiteraria(false, true, null);
            jFrameConsulta.setVisible(true);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemConsultaObraActionPerformed

    private void jMenuItemConsultaCopiaObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaCopiaObraActionPerformed
        try {
            JFrameConsultaCopiaObra jFrameConsulta;
            jFrameConsulta = new JFrameConsultaCopiaObra( false, true, null );
            jFrameConsulta.setVisible(true);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemConsultaCopiaObraActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
        try {
            usuario.setCodUsuario(Integer.parseInt(jTextFieldUsuario.getText()));
            usuario.load();
            
            Usuario login = new Usuario();
            
            login.setCodUsuario(Integer.parseInt( jTextFieldUsuario.getText()));
            login.setSenhaAcesso(jPasswordFieldSenha.getText());
            
            if(usuario.getSenhaAcesso().equals(login.getSenhaAcesso())) {
                login();
                usuario.disconnectFromDatabase();
            } else {
                throw new Exception("Senha Inválida!");
            }
            
        
        } catch(Exception ex) {
            LogTrack.getInstance().addException(ex, true, this);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jMenuItemConsultaEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaEmprestimoActionPerformed
        // TODO add your handling code here:
         try {
            JFrameConsultaEmprestimo jFrameConsulta;
            jFrameConsulta = new JFrameConsultaEmprestimo( false, null);
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemConsultaEmprestimoActionPerformed

    private void jMenuItemMeusEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMeusEmprestimosActionPerformed
        try {
            JFrameConsultaEmprestimo jFrameConsulta;
            jFrameConsulta = new JFrameConsultaEmprestimo( false, usuario );
            jFrameConsulta.setVisible(true);
        } catch( Exception ex ){
            LogTrack.getInstance().addException( ex, true, this );
        }
    }//GEN-LAST:event_jMenuItemMeusEmprestimosActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        logout();
    }//GEN-LAST:event_jMenuItemSairActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameAppPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAppPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAppPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAppPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAppPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenuAdministrativo;
    private javax.swing.JMenu jMenuAtendimento;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItemCadastroCopiaObra;
    private javax.swing.JMenuItem jMenuItemCadastroObra;
    private javax.swing.JMenuItem jMenuItemCadastroTipoObra;
    private javax.swing.JMenuItem jMenuItemCadastroTipoUsuario;
    private javax.swing.JMenuItem jMenuItemCadastroUsuario;
    private javax.swing.JMenuItem jMenuItemConsultaCopiaObra;
    private javax.swing.JMenuItem jMenuItemConsultaEmprestimo;
    private javax.swing.JMenuItem jMenuItemConsultaObra;
    private javax.swing.JMenuItem jMenuItemConsultaTipoObra;
    private javax.swing.JMenuItem jMenuItemConsultaTipoUsuario;
    private javax.swing.JMenuItem jMenuItemConsultaUsuario;
    private javax.swing.JMenuItem jMenuItemMeusEmprestimos;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenu jMenuUsuario;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}