package painel;

import frames.TelaLogin;
import info.Services;
import info.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.mercadobitcoin.common.exception.MercadoBitcoinException;
import net.mercadobitcoin.tradeapi.to.Funds;
import net.mercadobitcoin.tradeapi.to.Order;

/**
 *
 * @author M47
 */
public class PainelTrade extends javax.swing.JPanel implements Runnable{
    
    private static double saldo_BRL, saldo_BTC, saldo_LTC;
    private static TelaLogin telaLogin;
    private double precoComp, quantComp, precoVend, quantVend;
    
    public PainelTrade() {
        initComponents();
        telaLogin = new TelaLogin();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelSaldos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pSaldoBRL = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jlSaldo_BRL = new javax.swing.JLabel();
        pSaldoBTC = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jlSaldo_BTC = new javax.swing.JLabel();
        pSaldoLTC = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jlSaldo_LTC = new javax.swing.JLabel();
        botaoLogin = new javax.swing.JButton();
        pComprar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfQuantCompra = new javax.swing.JTextField();
        botaoComprar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlTotalCompra = new javax.swing.JLabel();
        jlComissaoCompra = new javax.swing.JLabel();
        jlLiquidoCompra = new javax.swing.JLabel();
        tfPrecoCompra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pVender = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfQuantVenda = new javax.swing.JTextField();
        botaoVender = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jlTotalVenda = new javax.swing.JLabel();
        jlComissaoVenda = new javax.swing.JLabel();
        jlLiquidoVenda = new javax.swing.JLabel();
        tfPrecoVenda = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(70, 91, 108));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setPreferredSize(new java.awt.Dimension(580, 250));

        painelSaldos.setBackground(new java.awt.Color(70, 91, 108));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fundos");

        pSaldoBRL.setBackground(new java.awt.Color(70, 91, 108));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("R$");

        jlSaldo_BRL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlSaldo_BRL.setForeground(new java.awt.Color(255, 204, 0));
        jlSaldo_BRL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSaldo_BRL.setText("0,00");

        javax.swing.GroupLayout pSaldoBRLLayout = new javax.swing.GroupLayout(pSaldoBRL);
        pSaldoBRL.setLayout(pSaldoBRLLayout);
        pSaldoBRLLayout.setHorizontalGroup(
            pSaldoBRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSaldoBRLLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlSaldo_BRL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pSaldoBRLLayout.setVerticalGroup(
            pSaldoBRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSaldoBRLLayout.createSequentialGroup()
                .addGroup(pSaldoBRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlSaldo_BRL))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pSaldoBTC.setBackground(new java.awt.Color(70, 91, 108));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("BTC");

        jlSaldo_BTC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlSaldo_BTC.setForeground(new java.awt.Color(255, 255, 255));
        jlSaldo_BTC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSaldo_BTC.setText("0,00000000");

        javax.swing.GroupLayout pSaldoBTCLayout = new javax.swing.GroupLayout(pSaldoBTC);
        pSaldoBTC.setLayout(pSaldoBTCLayout);
        pSaldoBTCLayout.setHorizontalGroup(
            pSaldoBTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSaldoBTCLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlSaldo_BTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pSaldoBTCLayout.setVerticalGroup(
            pSaldoBTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSaldoBTCLayout.createSequentialGroup()
                .addGroup(pSaldoBTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jlSaldo_BTC))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pSaldoLTC.setBackground(new java.awt.Color(70, 91, 108));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("LTC");

        jlSaldo_LTC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlSaldo_LTC.setForeground(new java.awt.Color(255, 255, 255));
        jlSaldo_LTC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSaldo_LTC.setText("0,00000000");

        javax.swing.GroupLayout pSaldoLTCLayout = new javax.swing.GroupLayout(pSaldoLTC);
        pSaldoLTC.setLayout(pSaldoLTCLayout);
        pSaldoLTCLayout.setHorizontalGroup(
            pSaldoLTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSaldoLTCLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jlSaldo_LTC, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
        );
        pSaldoLTCLayout.setVerticalGroup(
            pSaldoLTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSaldoLTCLayout.createSequentialGroup()
                .addGroup(pSaldoLTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jlSaldo_LTC))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        botaoLogin.setBackground(new java.awt.Color(0, 0, 0));
        botaoLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoLogin.setForeground(new java.awt.Color(204, 0, 204));
        botaoLogin.setText("LOGIN");
        botaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelSaldosLayout = new javax.swing.GroupLayout(painelSaldos);
        painelSaldos.setLayout(painelSaldosLayout);
        painelSaldosLayout.setHorizontalGroup(
            painelSaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pSaldoBTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pSaldoBRL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pSaldoLTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelSaldosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelSaldosLayout.setVerticalGroup(
            painelSaldosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSaldosLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pSaldoBRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pSaldoBTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pSaldoLTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pComprar.setBackground(new java.awt.Color(70, 91, 108));

        jPanel1.setBackground(new java.awt.Color(70, 91, 108));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Líquido(B): ");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Comissão(B): ");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Total(R$): ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Preço");

        tfQuantCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQuantCompraKeyReleased(evt);
            }
        });

        botaoComprar.setBackground(new java.awt.Color(0, 255, 0));
        botaoComprar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoComprar.setForeground(new java.awt.Color(255, 255, 255));
        botaoComprar.setText("Comprar");
        botaoComprar.setEnabled(false);
        botaoComprar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        botaoComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoComprarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(70, 91, 108));

        jlTotalCompra.setForeground(new java.awt.Color(255, 255, 255));
        jlTotalCompra.setText("0.00");

        jlComissaoCompra.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jlComissaoCompra.setForeground(new java.awt.Color(255, 255, 255));
        jlComissaoCompra.setText("0.00000000");

        jlLiquidoCompra.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jlLiquidoCompra.setForeground(new java.awt.Color(255, 255, 255));
        jlLiquidoCompra.setText("0.00000000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jlTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
            .addComponent(jlComissaoCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlLiquidoCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jlTotalCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlComissaoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlLiquidoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tfPrecoCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPrecoCompraKeyReleased(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Volume BTC");

        javax.swing.GroupLayout pComprarLayout = new javax.swing.GroupLayout(pComprar);
        pComprar.setLayout(pComprarLayout);
        pComprarLayout.setHorizontalGroup(
            pComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pComprarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfPrecoCompra)
                .addContainerGap())
            .addGroup(pComprarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(botaoComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(pComprarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pComprarLayout.createSequentialGroup()
                        .addGroup(pComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addContainerGap())
                    .addGroup(pComprarLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pComprarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfQuantCompra)
                .addContainerGap())
        );
        pComprarLayout.setVerticalGroup(
            pComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pComprarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfQuantCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pVender.setBackground(new java.awt.Color(70, 91, 108));

        jPanel4.setBackground(new java.awt.Color(70, 91, 108));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Líquido(R$): ");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Comissão(R$): ");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Total(R$): ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Preço");

        tfQuantVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQuantVendaKeyReleased(evt);
            }
        });

        botaoVender.setBackground(new java.awt.Color(255, 51, 51));
        botaoVender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoVender.setForeground(new java.awt.Color(255, 255, 255));
        botaoVender.setText("Vender");
        botaoVender.setEnabled(false);
        botaoVender.setMargin(new java.awt.Insets(0, 0, 0, 0));
        botaoVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVenderActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(70, 91, 108));

        jlTotalVenda.setForeground(new java.awt.Color(255, 255, 255));
        jlTotalVenda.setText("0.00");

        jlComissaoVenda.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jlComissaoVenda.setForeground(new java.awt.Color(255, 255, 255));
        jlComissaoVenda.setText("0.00000000");

        jlLiquidoVenda.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jlLiquidoVenda.setForeground(new java.awt.Color(255, 255, 255));
        jlLiquidoVenda.setText("0.00000000");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jlTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
            .addComponent(jlComissaoVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlLiquidoVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jlTotalVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlComissaoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlLiquidoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tfPrecoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPrecoVendaKeyReleased(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Volume BTC");

        javax.swing.GroupLayout pVenderLayout = new javax.swing.GroupLayout(pVender);
        pVender.setLayout(pVenderLayout);
        pVenderLayout.setHorizontalGroup(
            pVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVenderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfPrecoVenda)
                .addContainerGap())
            .addGroup(pVenderLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(botaoVender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(pVenderLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pVenderLayout.createSequentialGroup()
                        .addGroup(pVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addContainerGap())
                    .addGroup(pVenderLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pVenderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfQuantVenda)
                .addContainerGap())
        );
        pVenderLayout.setVerticalGroup(
            pVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVenderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfQuantVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoVender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(painelSaldos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pComprar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pVender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pVender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelSaldos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoComprarActionPerformed
        double volume = Double.parseDouble(tfQuantCompra.getText());
        double preco = Double.parseDouble(tfPrecoCompra.getText());
        double taxaMinima = volume*(1-0.003);
        double taxaMaxima = volume*(1-0.007);
        try {
            Order createBuyOrder = Services.getTAPI().createBuyOrder(Order.CoinPair.BTC_BRL,tfQuantCompra.getText(), tfPrecoCompra.getText());
        } catch (MercadoBitcoinException ex) {
            Logger.getLogger(PainelTrade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoComprarActionPerformed

    private void botaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLoginActionPerformed
        telaLogin.setLocationRelativeTo(this);
        telaLogin.setVisible(true);
        telaLogin.tfSegredo.setText(Usuario.SEGREDO);
    }//GEN-LAST:event_botaoLoginActionPerformed

    private void tfQuantCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantCompraKeyReleased
        quantComp = eliminarErro(tfQuantCompra.getText());
        precoComp = eliminarErro(tfPrecoCompra.getText());
        jlTotalCompra.setText(String.format("%.2f", precoComp*quantComp));
        jlComissaoCompra.setText(String.format("%.5f - %.5f", quantComp*0.003, quantComp*0.007));
        jlLiquidoCompra.setText(String.format("%.5f - %.5f", quantComp*0.997, quantComp*0.993));
    }//GEN-LAST:event_tfQuantCompraKeyReleased

    private void tfPrecoCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoCompraKeyReleased
        quantComp = eliminarErro(tfQuantCompra.getText());
        precoComp = eliminarErro(tfPrecoCompra.getText());
        jlTotalCompra.setText(String.format("%.2f", precoComp*quantComp));
        jlComissaoCompra.setText(String.format("%.5f - %.5f", quantComp*0.003, quantComp*0.007));
        jlLiquidoCompra.setText(String.format("%.5f - %.5f", quantComp*0.997, quantComp*0.993));
    }//GEN-LAST:event_tfPrecoCompraKeyReleased

    private void tfQuantVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantVendaKeyReleased
        quantVend = eliminarErro(tfQuantVenda.getText());
        precoVend = eliminarErro(tfPrecoVenda.getText());
        double totalVenda = precoVend*quantVend;        
        jlTotalVenda.setText(String.format("%.3f", totalVenda));
        jlComissaoVenda.setText(String.format("%.3f - %.3f", totalVenda*0.003, totalVenda*0.007));
        jlLiquidoVenda.setText(String.format("%.3f - %.3f", totalVenda*0.997, totalVenda*0.993));
    }//GEN-LAST:event_tfQuantVendaKeyReleased

    private void tfPrecoVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecoVendaKeyReleased
       quantVend = eliminarErro(tfQuantVenda.getText());
        precoVend = eliminarErro(tfPrecoVenda.getText());
        double totalVenda = precoVend*quantVend;        
        jlTotalVenda.setText(String.format("%.3f", totalVenda));
        jlComissaoVenda.setText(String.format("%.3f - %.3f", totalVenda*0.003, totalVenda*0.007));
        jlLiquidoVenda.setText(String.format("%.3f - %.3f", totalVenda*0.997, totalVenda*0.993));
    }//GEN-LAST:event_tfPrecoVendaKeyReleased

    private void botaoVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoVenderActionPerformed

    
    public static void setFundos(Funds fundos){
        jlSaldo_BRL.setText(fundos.getBrl().toString());
        saldo_BRL = Double.parseDouble(fundos.getBrl().toString());
        jlSaldo_BTC.setText(fundos.getBtc().toString());
        saldo_BTC = Double.parseDouble(fundos.getBtc().toString());
        jlSaldo_LTC.setText(fundos.getLtc().toString());
        saldo_LTC = Double.parseDouble(fundos.getLtc().toString());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoComprar;
    private javax.swing.JButton botaoLogin;
    private javax.swing.JButton botaoVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jlComissaoCompra;
    private javax.swing.JLabel jlComissaoVenda;
    private javax.swing.JLabel jlLiquidoCompra;
    private javax.swing.JLabel jlLiquidoVenda;
    private static javax.swing.JLabel jlSaldo_BRL;
    private static javax.swing.JLabel jlSaldo_BTC;
    private static javax.swing.JLabel jlSaldo_LTC;
    private javax.swing.JLabel jlTotalCompra;
    private javax.swing.JLabel jlTotalVenda;
    private javax.swing.JPanel pComprar;
    private javax.swing.JPanel pSaldoBRL;
    private javax.swing.JPanel pSaldoBTC;
    private javax.swing.JPanel pSaldoLTC;
    private javax.swing.JPanel pVender;
    private javax.swing.JPanel painelSaldos;
    private javax.swing.JTextField tfPrecoCompra;
    private javax.swing.JTextField tfPrecoVenda;
    private javax.swing.JTextField tfQuantCompra;
    private javax.swing.JTextField tfQuantVenda;
    // End of variables declaration//GEN-END:variables

    private double eliminarErro(String num){
        try{
            if(num.contains(","))
                    JOptionPane.showMessageDialog(this, "Ultilize ponto"
                            + " ao inves de vírgula");
            return Double.parseDouble(num);
        }catch(Exception e){
                return 0;
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                setFundos(Services.getTAPI().getAccountInfo().getFunds());
                Thread.sleep(5*1000);
            } catch (MercadoBitcoinException ex) {
                Logger.getLogger(PainelTrade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(PainelTrade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
