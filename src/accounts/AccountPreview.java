/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author AARM DB 2
 */
public class AccountPreview extends javax.swing.JFrame {
    public static String uname;
    public static String from;
    public static String to;
    public static String i_e;
    public static String row;
    public static String op_bal;
    public static String remem_bal;
    
    Connection con=null;
    ResultSet rs = null ;
    PreparedStatement pst=null;
    
    Statement stmt;
    /**
     * Creates new form AccountPreview
     */
    public AccountPreview() {
        initComponents();
        con = connect.ConnectDB();
        
        total_credit_label.setVisible(false);
        
        from_date.setText(from);
        to_date.setText(to);
        opening_bal.setText(op_bal);
        rem_bal.setText(remem_bal);
        try{
            stmt = con.createStatement();
            stmt.executeQuery("USE employee_database");
            System.out.println("Database Connected...");
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        DefaultTableModel view_model = (DefaultTableModel)view_table.getModel();
        double in_total, ex_total, balence;
        
        if(!to.equals("0")||!from.equals("0")){
            if(i_e.equals("All")){
                i_e = "acc_all";
                total_credit_label.setVisible(true);
                total_debit_label.setText("Total Debit");
                balance_all.setText("Balance");
            }
            
                String sql_query = "Select * from "+ i_e +" e where e.date >= \""+from+"\" AND e.date <= \""+to+"\" order by date;";
                if(i_e.equals("acc_all")){
                    sql_query = "SELECT\n" +
                    "  `date` \"Date\",\n" +
                    "  `receipt_no` \"Receipt No.\",\n" +
                    "  `desc` \"Description\",\n" +
                    "  `cat_type` \"Category\",\n" +
                    "  `amt_with`\"Withdrawn\",\n" +
                    "  `amt_depo` \"Amount Paid\",\n" +
                    "  `trans_type` \"Transaction Type\",\n" +
                    "  `done_by` \"Done By\",\n" +
                    "  `i_e` \"Income/Expense\" from acc_all e where e.date >= \""+from+"\" AND e.date <= \""+to+"\" order by date;";
                }
                System.out.println(sql_query);
                try{
                    
                    PreparedStatement pps = con.prepareStatement(sql_query);
                    rs = pps.executeQuery();

                    view_table.setModel(DbUtils.resultSetToTableModel(rs));

                    if(i_e.equals("Income")){
                        String sql_query1 = "Select SUM(amount_withdraw) sum from "+ i_e +" e where e.date >= \""+from+"\" AND e.date <= \""+to+"\";";
                        System.out.println(sql_query1);
                        pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        in_total = Double.parseDouble(rs.getString("sum"));
                        total_field.setText(String.valueOf(in_total));
                    }
                    else if(i_e.equals("Expense")){
                        String sql_query1 = "Select SUM(amount_deposited) sum from "+ i_e +" e where e.date >= \""+from+"\" AND e.date <= \""+to+"\";";
                        System.out.println(sql_query1);
                        pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        ex_total = Double.parseDouble(rs.getString("sum"));
                        total_field.setText(String.valueOf(ex_total));
                    }
                    else{
                        String sql_query1 = "SELECT SUM(amt_with) total_credit,SUM(amt_depo) total_debit,SUM(amt_with)-SUM(amt_depo) balance FROM acc_all e where e.date >= \""+from+"\" AND e.date <= \""+to+"\";";
                        System.out.println(sql_query1);
                        pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        int x = rs.getInt("total_credit") + Integer.parseInt(op_bal);
                        total_credit.setText(String.valueOf(x));
                        rem_bal.setText(rs.getString("total_debit"));
                        int dup = rs.getInt("balance")+Integer.parseInt(op_bal);
                        total_field.setText(String.valueOf(dup));
                    }
                
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            if(i_e.equals("All")){
                i_e = "acc_all";
                total_credit_label.setVisible(true);
                total_debit_label.setText("Total Debit");
                balance_all.setText("Balance");
            }
                String sql_query = "Select * from "+ i_e +" order by date;";
                if(i_e.equals("acc_all")){
                    sql_query = "SELECT\n" +
                        "  `date` \"Date\",\n" +
                        "  `receipt_no` \"Receipt No.\",\n" +
                        "  `desc` \"Description\",\n" +
                        "  `cat_type` \"Category\",\n" +
                        "  `amt_with`\"Withdrawn\",\n" +
                        "  `amt_depo` \"Amount Paid\",\n" +
                        "  `trans_type` \"Transaction Type\",\n" +
                        "  `done_by` \"Done By\",\n" +
                        "  `i_e` \"Income/Expense\" from acc_all order by date;";
                }
                System.out.println(sql_query);
                try{
                    PreparedStatement pps = con.prepareStatement(sql_query);
                    rs = pps.executeQuery();

                    view_table.setModel(DbUtils.resultSetToTableModel(rs));

                    if(i_e.equals("Income")){
                        String sql_query1 = "Select SUM(amount_withdraw) sum from "+ i_e +";";
                        System.out.println(sql_query1);
                        pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        in_total = Double.parseDouble(rs.getString("sum"));
                        total_field.setText(String.valueOf(in_total));
                    }
                    else if(i_e.equals("Expense")){
                        String sql_query1 = "Select SUM(amount_deposited) sum from "+ i_e +";";
                        System.out.println(sql_query1);
                        pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        ex_total = Double.parseDouble(rs.getString("sum"));
                        total_field.setText(String.valueOf(ex_total));
                    }
                    else{
                        String sql_query1 = "SELECT SUM(amt_with) total_credit,SUM(amt_depo) total_debit,SUM(amt_with)-SUM(amt_depo) balance FROM acc_all;";
                        System.out.println(sql_query1);
                        pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        int x = rs.getInt("total_credit") + Integer.parseInt(op_bal);
                        total_credit.setText(String.valueOf(x));
                        rem_bal.setText(rs.getString("total_debit"));
                        int dup = rs.getInt("balance")+Integer.parseInt(op_bal);
                        total_field.setText(String.valueOf(dup));
                    }
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        total_field = new javax.swing.JLabel();
        from_date = new javax.swing.JLabel();
        to_date = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        view_table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        total_debit_label = new javax.swing.JLabel();
        rem_bal = new javax.swing.JLabel();
        balance_all = new javax.swing.JLabel();
        opening_bal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        total_credit_label = new javax.swing.JLabel();
        total_credit = new javax.swing.JLabel();
        back_but = new javax.swing.JButton();
        print_but = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(593, 771));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounts/headerfinal.png"))); // NOI18N

        jLabel5.setText(" ______________________________________________________________________________________________________");
        jLabel5.setMaximumSize(new java.awt.Dimension(615, 7));
        jLabel5.setMinimumSize(new java.awt.Dimension(615, 7));

        jLabel6.setText("Registered Office");

        jLabel8.setText("Alternatives Analysis & Risk Management, 14-40-5, Emani Colony, Gokhale Road, Maharani Peta,");

        jLabel9.setText("Visakhapatnam - 530002, A.P., INDIA. Tel: +0891 - 2794110.");

        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setText("www.aarmcorp.com");

        jLabel12.setText("Web :");

        total_field.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        total_field.setText(" ");

        from_date.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        to_date.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        view_table.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        view_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(view_table);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Opening Balance :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Account");

        total_debit_label.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        total_debit_label.setText("Remaining Balance :");

        rem_bal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rem_bal.setText(" ");

        balance_all.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        balance_all.setText("Total :");

        opening_bal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        opening_bal.setText(" ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText(" To");

        total_credit_label.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        total_credit_label.setText("Total Credit :");

        total_credit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        total_credit.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(from_date, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(to_date, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opening_bal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(63, 63, 63))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(total_credit_label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(total_credit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(total_debit_label)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rem_bal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(balance_all)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(total_field, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(to_date, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opening_bal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(from_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total_credit_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(total_field)
                        .addComponent(total_debit_label)
                        .addComponent(rem_bal)
                        .addComponent(balance_all)
                        .addComponent(total_credit)))
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        back_but.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        back_but.setText("Back");
        back_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_butActionPerformed(evt);
            }
        });

        print_but.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        print_but.setText("Print");
        print_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_butActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(back_but, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(print_but, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(back_but, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(print_but))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_butActionPerformed
        // TODO add your handling code here:
        dispose();
        String info[] = new String [10];
        info[0] = uname;
        HomeScreen.main(info);
    }//GEN-LAST:event_back_butActionPerformed

    private void print_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_butActionPerformed
        // TODO add your handling code here:
        try{
            Toolkit tkp = jPanel1.getToolkit();
                 PrintJob pjp = tkp.getPrintJob(this, null, null);
                 Graphics g = pjp.getGraphics();
                 jPanel1.print(g);
                 g.dispose();
                 pjp.end(); 
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_print_butActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        from = args[0];
        System.out.println(from);
        to = args[1];
        System.out.println(to);
        i_e = args[2];
        System.out.println(i_e);
//        row = args[3];
//        System.out.println(row);
        uname = args[3];
        System.out.println(uname);
        op_bal = args[4];
        System.out.println(op_bal);
        remem_bal = args[5];
        System.out.println(remem_bal);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountPreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountPreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountPreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountPreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountPreview().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_but;
    private javax.swing.JLabel balance_all;
    private javax.swing.JLabel from_date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel opening_bal;
    private javax.swing.JButton print_but;
    private javax.swing.JLabel rem_bal;
    private javax.swing.JLabel to_date;
    private javax.swing.JLabel total_credit;
    private javax.swing.JLabel total_credit_label;
    private javax.swing.JLabel total_debit_label;
    private javax.swing.JLabel total_field;
    private javax.swing.JTable view_table;
    // End of variables declaration//GEN-END:variables
}
