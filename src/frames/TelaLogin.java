package frames;

import info.Services;
import info.Usuario;
import javax.swing.JOptionPane;
import net.mercadobitcoin.common.exception.MercadoBitcoinException;

public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public TelaLogin() {
        initComponents();
        tfIdentificador.setText(Usuario.IDENTIFICADOR);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfIdentificador = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfSegredo = new javax.swing.JTextField();
        botaoLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Identificador");

        tfIdentificador.setEnabled(false);

        jLabel2.setText("Segredo");

        botaoLogin.setText("Usar essas chaves");
        botaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfIdentificador, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(tfSegredo, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoLogin)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSegredo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLoginActionPerformed
        String menssagem = "Identificador ou segredo inválidos";
        if(tfIdentificador.getText().length()==0 || tfSegredo.getText().length()==0){
            JOptionPane.showMessageDialog(this, menssagem);
            return;
        }
        Usuario.IDENTIFICADOR = tfIdentificador.getText();
        Usuario.SEGREDO = tfSegredo.getText();
        try {
            Services.setTAPI(Usuario.SEGREDO, Usuario.IDENTIFICADOR);
            Services.getTAPI().getAccountInfo();
            Tela.initTrade();
            
        } catch (MercadoBitcoinException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, menssagem);
            return;
        }
        
        this.setVisible(false);
        
    }//GEN-LAST:event_botaoLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTextField tfIdentificador;
    public javax.swing.JTextField tfSegredo;
    // End of variables declaration//GEN-END:variables
}
