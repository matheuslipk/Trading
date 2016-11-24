package painel;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.mercadobitcoin.common.exception.MercadoBitcoinException;
import net.mercadobitcoin.tradeapi.service.ApiService;
import net.mercadobitcoin.tradeapi.to.Order;
import net.mercadobitcoin.tradeapi.to.Orderbook;

/**
 *
 * @author M47
 */
public class PainelLivroOrdens extends javax.swing.JPanel implements Runnable{
    private static Order[] orderVenda;
    private static Order[] orderCompra;
    private double volVenda_BTC, volVenda_BRL;
    private double volCompra_BTC, volCompra_BRL;
    private int numVendas = 10, numCompras = 10;

    /**
     * Creates new form PainelTabOrdens
     */
    public PainelLivroOrdens() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVenda = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlVolVendas_BTC = new javax.swing.JLabel();
        sNumOrdensVenda = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jlVolVendas_BRL = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCompra = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlVolCompras_BTC = new javax.swing.JLabel();
        sNumOrdensCompra = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jlVolCompras_BRL = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(70, 91, 108));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Num", "Quantidade", "Preço"
            }
        ));
        tabelaVenda.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelaVenda);
        if (tabelaVenda.getColumnModel().getColumnCount() > 0) {
            tabelaVenda.getColumnModel().getColumn(0).setResizable(false);
            tabelaVenda.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ordens de Venda");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Volume das");

        jlVolVendas_BTC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlVolVendas_BTC.setForeground(new java.awt.Color(255, 255, 255));
        jlVolVendas_BTC.setText("0,00000");

        sNumOrdensVenda.setEditor(new javax.swing.JSpinner.NumberEditor(sNumOrdensVenda, ""));
        sNumOrdensVenda.setValue(10);
        sNumOrdensVenda.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sNumOrdensVendaStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("primeiras");

        jlVolVendas_BRL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlVolVendas_BRL.setForeground(new java.awt.Color(255, 255, 255));
        jlVolVendas_BRL.setText("0,00");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("BTC");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("R$ ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlVolVendas_BTC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlVolVendas_BRL, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sNumOrdensVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sNumOrdensVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlVolVendas_BTC)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlVolVendas_BRL)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Num", "Quantidade", "Preço"
            }
        ));
        tabelaCompra.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaCompra);
        if (tabelaCompra.getColumnModel().getColumnCount() > 0) {
            tabelaCompra.getColumnModel().getColumn(0).setResizable(false);
            tabelaCompra.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ordens de Compra");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Volume das ");

        jlVolCompras_BTC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlVolCompras_BTC.setForeground(new java.awt.Color(102, 102, 102));
        jlVolCompras_BTC.setText("0,00000");

        sNumOrdensCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sNumOrdensCompra.setEditor(new javax.swing.JSpinner.NumberEditor(sNumOrdensCompra, ""));
        sNumOrdensCompra.setFocusable(false);
        sNumOrdensCompra.setValue(10);
        sNumOrdensCompra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sNumOrdensCompraStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("primeiras");

        jlVolCompras_BRL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlVolCompras_BRL.setForeground(new java.awt.Color(102, 102, 102));
        jlVolCompras_BRL.setText("0,00");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("BTC");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("R$ ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sNumOrdensCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlVolCompras_BTC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlVolCompras_BRL, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sNumOrdensCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlVolCompras_BTC)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlVolCompras_BRL)
                    .addComponent(jLabel8))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sNumOrdensCompraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sNumOrdensCompraStateChanged
        numCompras = eliminarErro(sNumOrdensCompra.getValue().toString());
        if(numCompras<2){
            JOptionPane.showMessageDialog(this, "O numero mínimo é 2");
            numCompras = 2;
            sNumOrdensCompra.setValue(numCompras);
            return;
        }
        
        if(numCompras>orderCompra.length-1){
            JOptionPane.showMessageDialog(this, "Valor muito alto");
            numCompras = orderCompra.length-10;
            sNumOrdensCompra.setValue(numCompras);
            return;
        }        
        sNumOrdensCompra.setValue(numCompras);
        
    }//GEN-LAST:event_sNumOrdensCompraStateChanged

    private void sNumOrdensVendaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sNumOrdensVendaStateChanged
        numVendas = eliminarErro(sNumOrdensVenda.getValue().toString());
        if(numVendas<2){
            JOptionPane.showMessageDialog(this, "O numero mínimo é 2");
            numVendas = 2;
            sNumOrdensVenda.setValue(numVendas);
            return;
        }
        
        if(numVendas>orderVenda.length-1){
            JOptionPane.showMessageDialog(this, "Valor muito alto");
            numVendas = orderVenda.length-10;
            sNumOrdensVenda.setValue(numVendas);
            return;
        }        
        sNumOrdensVenda.setValue(numVendas);
    }//GEN-LAST:event_sNumOrdensVendaStateChanged

    public static Order[] getOrdensVenda(){
        return orderVenda;
    }
    
    public static Order[] getOrdensCompra(){
        return orderCompra;
    }
    
    private void setLivroOrdens() throws MercadoBitcoinException{
        ApiService apiService = new ApiService();
        Orderbook orderBook = apiService.orderbook(Order.CoinPair.BTC_BRL);
        this.orderVenda = orderBook.getAsks();
        this.orderCompra = orderBook.getBids();
        String tabelaVenda[][] = new String[orderVenda.length][3];
        String tabelaCompra[][] = new String[orderCompra.length][3];
        
        volCompra_BTC = 0;
        volVenda_BTC = 0;
        volCompra_BRL = 0;
        volVenda_BRL = 0;
        
        for (int i=0; i<orderVenda.length; i++) {
            String pVenda = String.format("%.5f", Double.parseDouble(orderVenda[i].getPrice()));
            tabelaVenda[i][0] = ""+(i+1);
            tabelaVenda[i][1] = orderVenda[i].getVolume().toString();
            tabelaVenda[i][2] = pVenda;
            //
            if(i<numVendas){
                volVenda_BTC += Double.parseDouble(orderVenda[i].getVolume().toString());
                volVenda_BRL += Double.parseDouble(orderVenda[i].getPrice())*
                        Double.parseDouble(orderVenda[i].getVolume().toString());
            }
        } 
        for (int i=0; i<orderCompra.length; i++) {
            String pCompra = String.format("%.5f", Double.parseDouble(orderCompra[i].getPrice()));
            tabelaCompra[i][0] = ""+(i+1);
            tabelaCompra[i][1] = orderCompra[i].getVolume().toString();
            tabelaCompra[i][2] = pCompra;
            if(i<numCompras){
                volCompra_BTC += Double.parseDouble(orderCompra[i].getVolume().toString());
                volCompra_BRL += Double.parseDouble(orderCompra[i].getPrice())*
                        Double.parseDouble(orderCompra[i].getVolume().toString());
            }
        } 
        setTabelaVenda(tabelaVenda);
        setTabecaCompra(tabelaCompra);
    }
    
    private void setTabecaCompra(Object [][]tabela){
        tabelaCompra.setModel(new javax.swing.table.DefaultTableModel(
            tabela,
            new String [] {
                "Num", "Quantidade", "Preço"
            }
        ));
        
        if (tabelaCompra.getColumnModel().getColumnCount() > 0) {
            tabelaCompra.getColumnModel().getColumn(0).setResizable(false);
            tabelaCompra.getColumnModel().getColumn(0).setPreferredWidth(10);
        }
        jlVolCompras_BRL.setText(String.format("%.2f", volCompra_BRL));
        jlVolCompras_BTC.setText(String.format("%.5f", volCompra_BTC));
    }
    
    private void setTabelaVenda(Object [][]tabela){
        tabelaVenda.setModel(new javax.swing.table.DefaultTableModel(
            tabela,
            new String [] {
                "Num", "Quantidade", "Preço"
            }
        ));
        
        if (tabelaVenda.getColumnModel().getColumnCount() > 0) {
            tabelaVenda.getColumnModel().getColumn(0).setResizable(false);
            tabelaVenda.getColumnModel().getColumn(0).setPreferredWidth(10);
        }
        jlVolVendas_BRL.setText(String.format("%.2f", volVenda_BRL));
        jlVolVendas_BTC.setText(String.format("%.5f", volVenda_BTC));
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlVolCompras_BRL;
    private javax.swing.JLabel jlVolCompras_BTC;
    private javax.swing.JLabel jlVolVendas_BRL;
    private javax.swing.JLabel jlVolVendas_BTC;
    private javax.swing.JSpinner sNumOrdensCompra;
    private javax.swing.JSpinner sNumOrdensVenda;
    private static javax.swing.JTable tabelaCompra;
    private static javax.swing.JTable tabelaVenda;
    // End of variables declaration//GEN-END:variables

    
    private int eliminarErro(String num){
        try{
            return Integer.parseInt(num);
        }catch(Exception e){
            return 10;
        }
    }
    
    @Override
    public void run() {
        
        while(true){
            try {
                setLivroOrdens();
                Thread.sleep(1*1000);
            } catch (MercadoBitcoinException ex) {
                Logger.getLogger(PainelLivroOrdens.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(PainelLivroOrdens.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
