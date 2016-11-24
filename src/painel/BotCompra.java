package painel;

import info.Services;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.mercadobitcoin.common.exception.MercadoBitcoinException;
import net.mercadobitcoin.tradeapi.to.AccountBalance;
import net.mercadobitcoin.tradeapi.to.Order;

/**
 *
 * @author M47
 */
public class BotCompra extends javax.swing.JPanel implements Runnable{

    private AccountBalance balancoConta;
    private Order ordemAbertaVenda;
    private Order[] orderVenda;
    private Order[] orderCompra;
    /**
     * Creates new form BotCompra
     */
    public BotCompra() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botaoIniciarVenda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfMinimo = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        botaoIniciarVenda.setText("INICIAR ");
        botaoIniciarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIniciarVendaActionPerformed(evt);
            }
        });

        jLabel1.setText("Valor mínimo de venda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botaoIniciarVenda))
                    .addComponent(jLabel1)
                    .addComponent(tfMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoIniciarVenda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoIniciarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIniciarVendaActionPerformed
        if(verificarRequisitosVendas()){
            Thread t = new Thread(this);
            t.start();
        }
    }//GEN-LAST:event_botaoIniciarVendaActionPerformed

    private void initBotVendas(){
        double valorMinimo = Double.parseDouble(tfMinimo.toString());
        double ordemMenor = Double.parseDouble(PainelLivroOrdens.getOrdensVenda()[0].getPrice());
        double meuPreco = Double.parseDouble(ordemAbertaVenda.getPrice());
        if(valorMinimo < ordemMenor){
            if(ordemMenor < meuPreco){
                try {
                    Services.getTAPI().cancelOrder(ordemAbertaVenda);
                    String volume_BTC = Services.getTAPI().getAccountInfo().getFunds().getBtc().toString();
                    String novoPreco = Double.toString(ordemMenor-0.00001);
                    ordemAbertaVenda = Services.getTAPI().createSellOrder(Order.CoinPair.BTC_BRL, 
                            volume_BTC, novoPreco);

                } catch (MercadoBitcoinException ex) {
                    Logger.getLogger(BotCompra.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
    
    private void criarVendaInicial() throws MercadoBitcoinException{
        String volume_BTC = balancoConta.getFunds().getBtc().toString();
        System.out.println(volume_BTC);
        ordemAbertaVenda = Services.getTAPI().createSellOrder(Order.CoinPair.BTC_BRL, volume_BTC, "4000");
    }
    
    private boolean verificarRequisitosVendas(){
        if(eliminarErro(tfMinimo.getText())<0){
            JOptionPane.showMessageDialog(this, "Valor minimo INVÁLIDO");
            return false;
        }        
        try {
            balancoConta = Services.getTAPI().getAccountInfo();
        } catch (MercadoBitcoinException ex) {
            System.out.println(ex);
            return false;
        }
        
        if(Double.parseDouble(balancoConta.getFunds().getBtc().toString())<0.009){
            JOptionPane.showMessageDialog(this, "Saldo em BTC muito baixo");
            return false;
        }
        
        return true;
    }

    private double eliminarErro(String valor){
        try{
            return Double.parseDouble(valor);
        }catch(Exception e){
            return -1;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoIniciarVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfMinimo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            criarVendaInicial();
            while(true){
                initBotVendas();
            }
        } catch (MercadoBitcoinException ex) {
            
        }
        
    }
}
