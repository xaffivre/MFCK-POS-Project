//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2018 uniCenta
//    https://unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.payment;

import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.util.LuhnAlgorithm;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;

/**
 *
 * @author adrianromero
 */
public class PaymentPanelType extends javax.swing.JPanel implements PaymentPanel {
    
    private double m_dTotal;
    private String m_sTransactionID;
    private JPaymentNotifier m_notifier;
    
    /**
     * Creates new form JPaymentCash
     */
    public PaymentPanelType(JPaymentNotifier notifier) {
        
        m_notifier = notifier;
        
        initComponents();  
        
        m_jHolderName.addPropertyChangeListener("Edition", new RecalculateName());
        m_jCardNumber.addPropertyChangeListener("Edition", new RecalculateName());
        m_jExpirationDate.addPropertyChangeListener("Edition", new RecalculateName());
        
        
        m_jHolderName.addEditorKeys(m_jKeys);
        m_jCardNumber.addEditorKeys(m_jKeys);
        m_jExpirationDate.addEditorKeys(m_jKeys);

    }
    
    public JComponent getComponent() {
        return this;
    }
    
    public void activate(String sTransaction, double dTotal) {
        
        m_sTransactionID = sTransaction;
        m_dTotal = dTotal;
        
        resetState();
        
        m_jHolderName.activate();
    }
    
    private void resetState() {
        
        m_notifier.setStatus(false, false);  
              
        m_jHolderName.setText(null);
        m_jCardNumber.setText(null);
        m_jExpirationDate.setText(null);
    }
    
    public PaymentInfoMagcard getPaymentInfoMagcard() {
        
        if (m_dTotal > 0.0) {
            return new PaymentInfoMagcard(
                    m_jHolderName.getText(),
                    m_jCardNumber.getText(), 
                    m_jExpirationDate.getText(),
                    null,
                    null,                    
                    null,                    
                    null,
                    null,
                    m_sTransactionID,
                    m_dTotal);
        } else {
            return new PaymentInfoMagcardRefund(
                    m_jHolderName.getText(),
                    m_jCardNumber.getText(), 
                    m_jExpirationDate.getText(),
                    null,
                    null,                    
                    null,                    
                    null,
                    null,
                    m_sTransactionID,
                    m_dTotal);
        }
    }    
    
    private class RecalculateName implements PropertyChangeListener {

        public void propertyChange(PropertyChangeEvent evt) {
            boolean isvalid = isValidHolder() && isValidCardNumber() && isValidExpirationDate();
            m_notifier.setStatus(isvalid, isvalid);
        }
    }  
    
    private boolean isValidHolder() {
        return !(m_jHolderName.getText() == null || m_jHolderName.getText().equals(""));
    }

    private boolean isValidCardNumber() {
        return (LuhnAlgorithm.checkCC(m_jCardNumber.getText()) && m_jCardNumber.getText().length() > 13 && m_jCardNumber.getText().length() < 20);
    }

    private boolean isValidExpirationDate() {
        return !(m_jExpirationDate.getText() == null || m_jExpirationDate.getText().length() != 4);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        m_jKeys = new com.openbravo.editor.JEditorKeys();
        jPanel4 = new javax.swing.JPanel();
        m_jCardNumber = new com.openbravo.editor.JEditorStringNumber();
        m_jExpirationDate = new com.openbravo.editor.JEditorStringNumber();
        m_jHolderName = new com.openbravo.editor.JEditorString();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        m_jKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jKeysActionPerformed(evt);
            }
        });
        jPanel1.add(m_jKeys);

        jPanel2.add(jPanel1, java.awt.BorderLayout.NORTH);

        add(jPanel2, java.awt.BorderLayout.EAST);

        jPanel4.setPreferredSize(new java.awt.Dimension(400, 105));

        m_jCardNumber.setFont(new java.awt.Font("MingLiU", 0, 14)); // NOI18N
        m_jCardNumber.setMinimumSize(new java.awt.Dimension(100, 30));
        m_jCardNumber.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jExpirationDate.setFont(new java.awt.Font("MingLiU", 0, 14)); // NOI18N
        m_jExpirationDate.setMinimumSize(new java.awt.Dimension(100, 30));
        m_jExpirationDate.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jHolderName.setFont(new java.awt.Font("MingLiU", 0, 14)); // NOI18N
        m_jHolderName.setMinimumSize(new java.awt.Dimension(100, 30));
        m_jHolderName.setPreferredSize(new java.awt.Dimension(150, 30));

        jLabel8.setFont(new java.awt.Font("MingLiU", 0, 14)); // NOI18N
        jLabel8.setText(AppLocal.getIntString("label.cardholder")); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(150, 30));

        jLabel6.setFont(new java.awt.Font("MingLiU", 0, 14)); // NOI18N
        jLabel6.setText(AppLocal.getIntString("label.cardnumber")); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(150, 30));

        jLabel7.setFont(new java.awt.Font("MingLiU", 0, 14)); // NOI18N
        jLabel7.setText(AppLocal.getIntString("label.cardexpdate")); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(150, 30));

        jLabel2.setFont(new java.awt.Font("MingLiU", 0, 14)); // NOI18N
        jLabel2.setText("MMYY");
        jLabel2.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(m_jExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(m_jHolderName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(m_jCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jHolderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(m_jExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setPreferredSize(new java.awt.Dimension(350, 45));

        jLabel1.setFont(new java.awt.Font("MingLiU", 1, 18)); // NOI18N
        jLabel1.setText(AppLocal.getIntString("message.paymentgatewaytype")); // NOI18N
        jPanel5.add(jLabel1);

        add(jPanel5, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jKeysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_jKeysActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private com.openbravo.editor.JEditorStringNumber m_jCardNumber;
    private com.openbravo.editor.JEditorStringNumber m_jExpirationDate;
    private com.openbravo.editor.JEditorString m_jHolderName;
    private com.openbravo.editor.JEditorKeys m_jKeys;
    // End of variables declaration//GEN-END:variables
}
