package painel;

import info.Services;
import info.Usuario;
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
public class BotVenda extends javax.swing.JPanel implements Runnable{

    private Order ordemAbertaVenda;
    private Order[] orderVenda;
    private boolean flag;
    
    public BotVenda() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfMinimo = new javax.swing.JTextField();
        botaoVenda = new javax.swing.JButton();

        jLabel1.setText("Valor Minimo de venda");

        botaoVenda.setText("Iniciar Venda");
        botaoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoVenda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoVenda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVendaActionPerformed
        if(eliminarErro(tfMinimo.getText())<0){
            JOptionPane.showMessageDialog(this, "Valor maximo INVÁLIDO");
            this.flag = false;
            return;
        }
        AccountBalance contaBalanco = null;
        try {
            Services.setTAPI(Usuario.SEGREDO, Usuario.IDENTIFICADOR);
            contaBalanco = Services.getTAPI().getAccountInfo();
        } catch (MercadoBitcoinException ex) {
            System.out.println(ex);
            this.flag = false;
            return;
        }
        
        if(Double.parseDouble(contaBalanco.getFunds().getBtc().toString())<0.009){
            JOptionPane.showMessageDialog(this, "Saldo em BTC muito baixo");
            this.flag = false;
            return;
        }
        
        this.flag = true;
    }//GEN-LAST:event_botaoVendaActionPerformed

    private void roboVenda(double valorMinimo) throws MercadoBitcoinException{
        orderVenda = Services.API.orderbook(Order.CoinPair.BTC_BRL).getAsks();
        double menorPrecoOferecido = Double.parseDouble(orderVenda[0].getPrice());
        double meuPreco = Double.parseDouble(ordemAbertaVenda.getPrice());
        if(valorMinimo < menorPrecoOferecido){
            if(menorPrecoOferecido < meuPreco){
                Services.getTAPI().cancelOrder(ordemAbertaVenda);
                String volume_BTC = Services.getTAPI().getAccountInfo().getFunds().getBtc().toString();
                String novoPreco = Double.toString(menorPrecoOferecido-0.00001);
                ordemAbertaVenda = Services.getTAPI().createSellOrder(Order.CoinPair.BTC_BRL, volume_BTC, novoPreco); 
            }
        }
    }
    
    private double eliminarErro(String valor){
        try{
            return Double.parseDouble(valor);
        }catch(Exception e){
            return -1;
        }
    }

    private void criarVendaInicial() throws MercadoBitcoinException{
        String volume_BTC = Services.getTAPI().getAccountInfo().getFunds().getBtc().toString();
        System.out.println(volume_BTC);
        ordemAbertaVenda = Services.getTAPI().createSellOrder(Order.CoinPair.BTC_BRL, volume_BTC, "4000");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tfMinimo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {               
        try {
            criarVendaInicial();
        } catch (MercadoBitcoinException ex) {
            Logger.getLogger(PainelRobo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        while(flag){
            if(eliminarErro(tfMinimo.getText())<100)
                    continue;
            try {                
                roboVenda(eliminarErro(tfMinimo.getText()));
                Thread.sleep(1*500);
            } catch (MercadoBitcoinException ex) {
                Logger.getLogger(PainelRobo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(PainelRobo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
