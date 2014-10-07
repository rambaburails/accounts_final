package accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.*;

public class addCategory extends javax.swing.JFrame {
    Connection con=null;
    ResultSet rs = null ;
    PreparedStatement pst=null;
    
    Statement stmt;

    public addCategory() {
        initComponents();
        con = connect.ConnectDB();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        category = new javax.swing.JTextField();
        but_add_category = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Category Name :");

        but_add_category.setText("Add");
        but_add_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_add_categoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(but_add_category, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(but_add_category, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void but_add_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_add_categoryActionPerformed
        // TODO add your handling code here:
        
        HomeScreen ac = new HomeScreen();
        //ac.type.addItem(category.getText());
        try{
            stmt = con.createStatement();
            stmt.executeQuery("USE employee_database");
            System.out.println("Database Connected...");
            
            String Query = "insert into expense_catagory_type ("
                +"name)"
                +"values('"+ category.getText() +"')";
            PreparedStatement pps = con.prepareStatement(Query);
            pps.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
        JOptionPane.showMessageDialog(null, category.getText() +" Added Sucessflly");
        dispose();
        ac.setVisible(false);
        new HomeScreen().setVisible(true);
    }//GEN-LAST:event_but_add_categoryActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCategory().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_add_category;
    private javax.swing.JTextField category;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}