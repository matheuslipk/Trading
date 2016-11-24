package painel;

import info.Services;
import info.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.mercadobitcoin.common.exception.MercadoBitcoinException;
import net.mercadobitcoin.tradeapi.to.Order;
import net.mercadobitcoin.tradeapi.to.OrderFilter;

/**
 *
 * @author M47
 */
public class PainelMinhasOrdens extends javax.swing.JPanel implements Runnable{

    private List<Order> ordensAtivas;
    
    public PainelMinhasOrdens() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaOrdensAtivas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfIDOrdem = new javax.swing.JTextField();
        botaoCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(70, 91, 108));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaOrdensAtivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Ordem", "Tipo", "Quantidade", "Preço", "Total"
            }
        ));
        jScrollPane1.setViewportView(tabelaOrdensAtivas);

        jPanel1.setBackground(new java.awt.Color(70, 91, 108));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cancelar Ordem"));

        jLabel1.setText("ID:  ");

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfIDOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfIDOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Minhas Ordens Ativas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        if(ordensAtivas==null){
            JOptionPane.showMessageDialog(this, "Faça login primeiro");
            return;
        }
        if(!cancelarOrdem())
            JOptionPane.showMessageDialog(this, "Digite um ID válido");
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private boolean cancelarOrdem(){
        String numOrdem = tfIDOrdem.getText();
        boolean ordemCancelada = false;        
        for(int i=0; i<ordensAtivas.size(); i++){
            if(Long.toString(ordensAtivas.get(i).getOrderId()).equals(numOrdem)){
                    try {
                        Services.getTAPI().cancelOrder(ordensAtivas.get(i));
                        ordemCancelada = true;
                } catch (MercadoBitcoinException ex) {
                    Logger.getLogger(PainelMinhasOrdens.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ordemCancelada;
    }
    
    private void setMinhasOrdens(){
        ordensAtivas = getListaOrdemAtivas();
        int tamanho = ordensAtivas.size();
        //Se nao tiver ordens ativas
        if(tamanho==0){
            setTabelaCompra(new String[1][5]);
            return;
        }
        String[][] tabelaOrdemAtiva = new String[tamanho][5];
        for(int i=0; i<tamanho; i++){
            tabelaOrdemAtiva[i][0] = ordensAtivas.get(i).getOrderId().toString();
            tabelaOrdemAtiva[i][1] = ordensAtivas.get(i).getType().toString();
            tabelaOrdemAtiva[i][2] = ordensAtivas.get(i).getVolume().toString();
            tabelaOrdemAtiva[i][3] = ordensAtivas.get(i).getPrice();
            double total = Double.parseDouble(tabelaOrdemAtiva[i][2])*Double.parseDouble(tabelaOrdemAtiva[i][3]);
            tabelaOrdemAtiva[i][4] = Double.toString(total);
        }
        setTabelaCompra(tabelaOrdemAtiva);
    }
    
    private void setTabelaCompra(Object [][]tabela){
        tabelaOrdensAtivas.setModel(new javax.swing.table.DefaultTableModel(
            tabela,
            new String [] {
                "ID Ordem", "Tipo", "Quantidade", "Preço", "Total"
            }
        ));
    }
    
    private List<Order> getListaOrdemAtivas(){
        OrderFilter filtro = new OrderFilter(Order.CoinPair.BTC_BRL);
        filtro.setStatus(Order.OrderStatus.ACTIVE);
        List<Order> ordensAtivas = null;
        try {
            Services.setTAPI(Usuario.SEGREDO, Usuario.IDENTIFICADOR);
            ordensAtivas = Services.getTAPI().listOrders(filtro);            
        } catch (MercadoBitcoinException ex) {
            Logger.getLogger(PainelMinhasOrdens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ordensAtivas;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaOrdensAtivas;
    private javax.swing.JTextField tfIDOrdem;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(true){
            setMinhasOrdens();
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PainelMinhasOrdens.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
