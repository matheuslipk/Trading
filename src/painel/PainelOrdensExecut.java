package painel;

import info.Services;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.mercadobitcoin.common.exception.MercadoBitcoinException;
import net.mercadobitcoin.tradeapi.service.ApiService;
import net.mercadobitcoin.tradeapi.to.Operation;
import net.mercadobitcoin.tradeapi.to.Order;
import net.mercadobitcoin.util.TimestampInterval;

/**
 *
 * @author M47
 */
public class PainelOrdensExecut extends javax.swing.JPanel implements Runnable{

    /**
     * Creates new form PainelOrdensExecut
     */
    public PainelOrdensExecut() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabOrdensExecutadas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(70, 91, 108));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabOrdensExecutadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data", "Tipo", "Quantidade", "Preço"
            }
        ));
        jScrollPane1.setViewportView(tabOrdensExecutadas);
        if (tabOrdensExecutadas.getColumnModel().getColumnCount() > 0) {
            tabOrdensExecutadas.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabOrdensExecutadas.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabOrdensExecutadas.getColumnModel().getColumn(2).setResizable(false);
            tabOrdensExecutadas.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabOrdensExecutadas.getColumnModel().getColumn(3).setResizable(false);
            tabOrdensExecutadas.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ultimas negociações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setTabOperation(){
        try {
            Operation[] listaOperacao = Services.API.tradeList(Order.CoinPair.BTC_BRL);         
            int tam = listaOperacao.length;
            String [][] stringsTabOrden = new String[listaOperacao.length][4];
            Date data = null;
            for(int i=0; i<tam; i++){
                data = new Date(Long.parseLong(listaOperacao[tam-i-1].getDate().toString()+"000"));
                stringsTabOrden[i][0] = getDataFormatada(data);
                stringsTabOrden[i][1] = getTipoFormatado(listaOperacao[tam-i-1].getType().toString());
                stringsTabOrden[i][2] = listaOperacao[tam-i-1].getAmount().toString();
                stringsTabOrden[i][3] = getPrecoFormatado(listaOperacao[tam-i-1].getPrice());
//                System.out.println(stringsTabOrden[i][3]);
            }
            setTabela(stringsTabOrden);
        } catch (MercadoBitcoinException ex) {
            Logger.getLogger(PainelOrdensExecut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setTabela(String [][]tab){
        tabOrdensExecutadas.setModel(new javax.swing.table.DefaultTableModel(
            tab,
            new String [] {
                "Data", "Tipo", "Quantidade", "Preço"
            }
        ));
        
        jScrollPane1.setViewportView(tabOrdensExecutadas);

        if (tabOrdensExecutadas.getColumnModel().getColumnCount() > 0) {
            tabOrdensExecutadas.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabOrdensExecutadas.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabOrdensExecutadas.getColumnModel().getColumn(2).setResizable(false);
            tabOrdensExecutadas.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabOrdensExecutadas.getColumnModel().getColumn(3).setResizable(false);
            tabOrdensExecutadas.getColumnModel().getColumn(3).setPreferredWidth(50);
        }
    }
    
    private String getPrecoFormatado(BigDecimal preco){
        return String.format("%.5f", Double.parseDouble(preco.toString()));
    }
    
    private String getTipoFormatado(String tipo){
        if("BUY".equals(tipo))
            return "COMPRA";
        else 
            return "VENDA";
    }
    
    private String getDataFormatada(Date data){
        return String.format("%02d/%02d/%04d - %02d:%02d:%02d", data.getDate(), 
                data.getMonth()+1, data.getYear()+1900,data.getHours(), 
                data.getMinutes(), data.getSeconds());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabOrdensExecutadas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(true){
            setTabOperation();
            try {
                Thread.sleep(20*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PainelOrdensExecut.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
}
