package painel;

import info.Services;
import info.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.mercadobitcoin.common.exception.MercadoBitcoinException;
import net.mercadobitcoin.tradeapi.service.ApiService;
import net.mercadobitcoin.tradeapi.service.TradeApiService;
import net.mercadobitcoin.tradeapi.to.AccountBalance;
import net.mercadobitcoin.tradeapi.to.Order;
import net.mercadobitcoin.tradeapi.to.Orderbook;

/**
 *
 * @author M47
 */
public class PainelRobo extends javax.swing.JPanel implements Runnable{

    private Order ordemAbertaVenda;
    private Order ordemAbertaCompra;
    private Order[] listaOrdensVenda;
    private Order[] listaOrdensCompra;
    private boolean flag;
    /**
     * Creates new form PainelRobo
     * 
     */
    public PainelRobo(){
        initComponents();
        jlIdentificador.setText(Usuario.IDENTIFICADOR);
        tfSegredo.setText(Usuario.SEGREDO);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTabOrdens1 = new painel.PainelLivroOrdens();
        jPanel1 = new javax.swing.JPanel();
        botaoIniciarVenda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfMinimo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jlIdentificador = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfSegredo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        botaoIniciarCompra = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfMaximo = new javax.swing.JTextField();

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
                    .addComponent(jLabel1)
                    .addComponent(tfMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoIniciarVenda))
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

        jLabel2.setText("Identificador:  ");

        jlIdentificador.setText("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        jLabel3.setText("Sergedo:  ");

        botaoIniciarCompra.setText("INICIAR ");
        botaoIniciarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIniciarCompraActionPerformed(evt);
            }
        });

        jLabel4.setText("Valor mínimo de Compra");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tfMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoIniciarCompra))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoIniciarCompra)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelTabOrdens1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlIdentificador, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(tfSegredo))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(painelTabOrdens1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlIdentificador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfSegredo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoIniciarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIniciarVendaActionPerformed
        
        if(eliminarErro(tfMinimo.getText())<0){
            JOptionPane.showMessageDialog(this, "Valor maximo INVÁLIDO");
            this.flag = false;
            return;
        }
        AccountBalance contaBalanco = null;
        try {
            Services.setTAPI(Usuario.SEGREDO, Usuario.IDENTIFICADOR);
            contaBalanco = Services.getTAPI().getAccountInfo();
            listaOrdensVenda = PainelLivroOrdens.getOrdensVenda();
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
    }//GEN-LAST:event_botaoIniciarVendaActionPerformed

    private void botaoIniciarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIniciarCompraActionPerformed
        if(eliminarErro(tfMaximo.getText())<10){
            JOptionPane.showMessageDialog(this, "Valor INVÁLIDO");
            this.flag = false;
            return;
        }
        AccountBalance contaBalanco = null;
        try {
            Services.setTAPI(Usuario.SEGREDO, Usuario.IDENTIFICADOR);
            contaBalanco = Services.getTAPI().getAccountInfo();
            listaOrdensCompra = PainelLivroOrdens.getOrdensCompra();
        } catch (MercadoBitcoinException ex) {
            System.out.println(ex);
            this.flag = false;
            return;
        }
        
        this.flag = true;
    }//GEN-LAST:event_botaoIniciarCompraActionPerformed

    private void roboVenda(double valorMinimo) throws MercadoBitcoinException{
        listaOrdensVenda = PainelLivroOrdens.getOrdensVenda();
        double menorPrecoOferecido = Double.parseDouble(listaOrdensVenda[0].getPrice());
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
    
    private void roboCompra(double valorMaximo) throws MercadoBitcoinException{
        listaOrdensCompra = PainelLivroOrdens.getOrdensCompra();
        double maiorPrecoOferecido = Double.parseDouble(listaOrdensCompra[0].getPrice());
        double meuPreco = Double.parseDouble(ordemAbertaCompra.getPrice());
        if(valorMaximo > maiorPrecoOferecido){
            if(maiorPrecoOferecido > meuPreco){
                Services.getTAPI().cancelOrder(ordemAbertaCompra);
                String volume_BRL = Services.getTAPI().getAccountInfo().getFunds().getBrl().toString();
                double volumeCompra_BTC = (Double.parseDouble(volume_BRL)-0.1)/maiorPrecoOferecido+0.00001;
                ordemAbertaCompra = Services.getTAPI().createBuyOrder(Order.CoinPair.BTC_BRL, 
                        Double.toString(volumeCompra_BTC), Double.toString(maiorPrecoOferecido+0.00001)); 
            }
        }
    }
    
    private void criarVendaInicial() throws MercadoBitcoinException{
        String volume_BTC = Services.getTAPI().getAccountInfo().getFunds().getBtc().toString();
        System.out.println(volume_BTC);
        ordemAbertaVenda = Services.getTAPI().createSellOrder(Order.CoinPair.BTC_BRL, volume_BTC, "4000");
    }

    private void criarCompraInicial() throws MercadoBitcoinException{
        String volume_BRL = Services.getTAPI().getAccountInfo().getFunds().getBrl().toString();
        System.out.println(volume_BRL);
        double preco = 100;
        double vomume_BTC = (Double.parseDouble(volume_BRL)-0.1)/preco;
        ordemAbertaCompra = Services.getTAPI().createBuyOrder(Order.CoinPair.BTC_BRL,
                Double.toString(vomume_BTC), Double.toString(preco));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoIniciarCompra;
    private javax.swing.JButton botaoIniciarVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlIdentificador;
    private painel.PainelLivroOrdens painelTabOrdens1;
    private javax.swing.JTextField tfMaximo;
    private javax.swing.JTextField tfMinimo;
    private javax.swing.JTextField tfSegredo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread iniciarLivroOrdem = new Thread(painelTabOrdens1);
        iniciarLivroOrdem.start();
        
        while(!flag){
            try {
                Thread.sleep(1*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PainelRobo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(flag){
            try {
                criarVendaInicial();
//                criarCompraInicial();
            } catch (MercadoBitcoinException ex) {
                Logger.getLogger(PainelRobo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        while(flag){
            try {                
                roboVenda(eliminarErro(tfMinimo.getText()));
//                roboCompra(eliminarErro(tfMaximo.getText()));
                Thread.sleep(1*500);
            } catch (MercadoBitcoinException ex) {
                Logger.getLogger(PainelRobo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(PainelRobo.class.getName()).log(Level.SEVERE, null, ex);
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
}
