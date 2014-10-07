package accounts;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author AARM DB 2
 */
public class HomeScreen extends javax.swing.JFrame {
    public static String uname;
    Connection con=null;
    ResultSet rs = null ;
    PreparedStatement pst=null;
    Statement stmt;
    
    Double balence;
    int open_balanceG=0;
    String open_dateG="";
    ResultSet rs2 = null ;
    
    public HomeScreen() {
        initComponents();
        preview_but.setEnabled(false);
        opbal.setVisible(false);
        rec_by.setText(uname);
        ent_by.setText(uname);
        Double in_total, ex_total;
        con = connect.ConnectDB();
        try{
            stmt = con.createStatement();
            stmt.executeQuery("USE employee_database");
            System.out.println("Database Connected...");
            
            String Query = "select name from expense_catagory_type;";
            PreparedStatement pps = con.prepareStatement(Query);
            rs = pps.executeQuery();
            while(rs.next()){
                type.addItem(rs.getString("name"));
            }
            
            String Query2 = "select * from opening_bal;"; 
            PreparedStatement pst2 = con.prepareStatement(Query2);
            rs2 = pst2.executeQuery();
            rs2.next();
            open_balanceG=rs2.getInt("balance");
            open_dateG=rs2.getString("date");
            open_bal.setText(String.valueOf(open_balanceG));
            open_date.setText(open_dateG);
            
            add_ex_op_bal.setText(String.valueOf(open_balanceG));
            add_in_op_bal.setText(String.valueOf(open_balanceG));
            view_op_bal.setText(String.valueOf(open_balanceG));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            String sql_query1 = "Select SUM(amount_paid) sum from expense;";
            System.out.println(sql_query1);
            PreparedStatement pps = con.prepareStatement(sql_query1);
            rs = pps.executeQuery();
            rs.next();
            ex_total = Double.parseDouble(rs.getString("sum"));
            
            sql_query1 = "Select SUM(amount_withdraw) sum from income;";
            System.out.println(sql_query1);
            pps = con.prepareStatement(sql_query1);
            rs = pps.executeQuery();
            rs.next();
            in_total = Double.parseDouble(rs.getString("sum"));
            
            balence = in_total - ex_total;
            
            bal.setText(String.valueOf(balence));
            in_rem_bal.setText(String.valueOf(balence));
            ex_rem_bal.setText(String.valueOf(balence));
            System.out.println("Remaining bal : "+ balence);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        delete_item = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ent_date = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        receipt_no = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        des = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        amt_dep = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        dep_type = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        saveDB = new javax.swing.JButton();
        add_category = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        ex_rem_bal = new javax.swing.JTextField();
        rec_by = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        add_ex_op_bal = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        date_income = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        amt_wd = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        wd_type = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        in_note = new javax.swing.JTextField();
        addIncomeToDB = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        in_rem_bal = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        i_rec_no = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        ent_by = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        add_in_op_bal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sel_in_exp = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        from_date = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        to_date = new com.toedter.calendar.JDateChooser();
        but_view = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        view_table = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        total_debit = new javax.swing.JLabel();
        bal = new javax.swing.JTextField();
        rembal = new javax.swing.JLabel();
        total_field = new javax.swing.JTextField();
        preview_but = new javax.swing.JButton();
        total_credit = new javax.swing.JLabel();
        view_op_bal = new javax.swing.JTextField();
        opbal = new javax.swing.JLabel();
        opbalvalue = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        view_history = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        open_date = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        open_bal = new javax.swing.JLabel();
        chang_openbal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Accounts", 0, 0, new java.awt.Font("Times New Roman", 3, 48))); // NOI18N

        delete_item.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Enter New Expense Here...");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Date :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Receipt No. :");

        receipt_no.setText("0");
        receipt_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receipt_noActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Description :");

        des.setText("xyz");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Amount Paid :");

        amt_dep.setText("0");
        amt_dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amt_depActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Category Type :");

        type.setEditable(true);
        type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Depostie Type :");

        dep_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Cash", "Online", "Debit Card", "Credit Card" }));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Received By :");

        saveDB.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        saveDB.setText("Add Expense");
        saveDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDBActionPerformed(evt);
            }
        });

        add_category.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        add_category.setText("Add Category");
        add_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_categoryActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setText("Remaining Balance :");

        ex_rem_bal.setEditable(false);
        ex_rem_bal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        rec_by.setEditable(false);

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setText("Opening Balance :");

        add_ex_op_bal.setEditable(false);
        add_ex_op_bal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add_ex_op_bal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ex_rem_bal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(saveDB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ent_date, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amt_dep, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(type, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(des, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(receipt_no, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(add_category, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(rec_by, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dep_type, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ex_rem_bal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(add_ex_op_bal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ent_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(receipt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(des, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_category, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amt_dep, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rec_by, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dep_type, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(saveDB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        delete_item.addTab("Add Expense", jPanel3);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel10.setText("Enter New Income Here...");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Date :");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Amount Withdraw :");

        amt_wd.setText("0");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Withdraw Type :");

        wd_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Cash", "Online", "Debit Card", "Credit Card" }));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Note :");

        in_note.setText("XYZ");

        addIncomeToDB.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        addIncomeToDB.setText("Add Income");
        addIncomeToDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIncomeToDBActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setText("Remaining Balance :");

        in_rem_bal.setEditable(false);
        in_rem_bal.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setText("Receipt No. :");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setText("Entered By :");

        ent_by.setEditable(false);

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setText("Opening Balance :");

        add_in_op_bal.setEditable(false);
        add_in_op_bal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_in_op_bal, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(in_rem_bal, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(addIncomeToDB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(date_income, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amt_wd)
                            .addComponent(wd_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(in_note)
                            .addComponent(i_rec_no)
                            .addComponent(ent_by, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add_in_op_bal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(in_rem_bal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_income, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amt_wd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(i_rec_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wd_type, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(in_note, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ent_by, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(addIncomeToDB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );

        delete_item.addTab("Add Income", jPanel4);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel14.setText("View & Edit Your Income/Expense Here...");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Income/Expense :");

        sel_in_exp.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        sel_in_exp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "All", "expense", "income" }));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("From:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("To:");

        but_view.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        but_view.setText("View");
        but_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_viewActionPerformed(evt);
            }
        });

        view_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        view_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(view_table);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel18.setText("Note : To Edit/Delete Click On The Particular Row.");

        total_debit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        total_debit.setText("Remaining Balance :");

        bal.setEditable(false);
        bal.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N

        rembal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rembal.setText("Total :");

        total_field.setEditable(false);
        total_field.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N

        preview_but.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        preview_but.setText("Preview");
        preview_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preview_butActionPerformed(evt);
            }
        });

        total_credit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        total_credit.setText("Opening Balance :");

        view_op_bal.setEditable(false);
        view_op_bal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        opbal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        opbal.setText("Opening Balance :");

        opbalvalue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        opbalvalue.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sel_in_exp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(from_date, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(to_date, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(opbal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opbalvalue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(total_credit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(view_op_bal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total_debit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rembal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total_field, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(but_view, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(preview_but, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(opbal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(4, 4, 4)))
                    .addComponent(opbalvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(to_date, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sel_in_exp, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                        .addComponent(from_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(preview_but, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(but_view, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total_credit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(view_op_bal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(total_debit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bal)
                        .addComponent(rembal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total_field, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))))
        );

        delete_item.addTab("View Edit & Delete", jPanel2);

        jLabel25.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel25.setText("View Your History Here Just By Clicking The Below Button...");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("View History");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        view_history.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "History Date", "Name", "Type", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(view_history);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );

        delete_item.addTab("View Log History", jPanel5);

        jLabel26.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel26.setText("Your current opening balance till :");

        open_date.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        open_date.setText(" ");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel27.setText("Is :");

        open_bal.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        open_bal.setText(" ");

        chang_openbal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        chang_openbal.setText("Change Opening Balance");
        chang_openbal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chang_openbalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(open_date, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(open_bal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chang_openbal)
                .addGap(259, 259, 259))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(open_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(open_bal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(chang_openbal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(432, Short.MAX_VALUE))
        );

        delete_item.addTab("Opening Balance", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(delete_item)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(delete_item)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void view_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_tableMouseClicked
        
        DefaultTableModel view_model1 = (DefaultTableModel)view_table.getModel();
        String tp = (String) sel_in_exp.getSelectedItem();
        if(tp.equals("All")){
            JOptionPane.showMessageDialog(null, "You Have Selected Date : "+view_model1.getValueAt(view_table.getSelectedRow(), 0).toString());
        }
        else{
            JOptionPane.showMessageDialog(null, "You Have Selected ID : "+view_model1.getValueAt(view_table.getSelectedRow(), 0).toString());
        Object[] options = {"Edit",
            "Delete",
            "Cancle"};
        int n = JOptionPane.showOptionDialog(null,
            "Press Edit For Editing "
            + "Or Delete For Deleting...",
            "A Silly Question",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[2]);

        if (n == JOptionPane.NO_OPTION){
            System.out.println("Delete button clicked...");
            try{
                String query_delete = "delete from "+ tp +" where id='"+view_model1.getValueAt(view_table.getSelectedRow(), 0).toString()+"' ;";
                PreparedStatement pps = con.prepareStatement(query_delete);
                pps.execute();
                JOptionPane.showMessageDialog(null, "Deleted Sucessfully...");
                
                SimpleDateFormat df = new SimpleDateFormat("dd  MMMM  yyyy  HH:mm:ss");
                java.util.Date ddd=new java.util.Date();
                String dt=df.format(ddd);

                String act = "Deleted";

                String sql = "insert into accounts_history ("
                +"his_date,"
                +"name,"
                +"type,"
                +"action)"
                +"values('"+ dt +"','"+  uname +"','"+ tp +"','"+ act +"')";

                pps = con.prepareStatement(sql);
                pps.execute();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else if(n == JOptionPane.YES_OPTION){
            System.out.println("Edit Button Clicked... : "+tp);
            if(tp.equals("expense")){
                dispose();
                expense_edit ee = new expense_edit(view_model1.getValueAt(view_table.getSelectedRow(), 0).toString(), uname);
                ee.setVisible(true);
            }
            else{
                dispose();
                income_edit ee = new income_edit(view_model1.getValueAt(view_table.getSelectedRow(), 0).toString());
                ee.setVisible(true);
            }
        }
        else{
            System.out.println("Cancle Button Clicked...");
        }
    }
    }//GEN-LAST:event_view_tableMouseClicked

    private void but_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_viewActionPerformed
        
        DefaultTableModel view_model = (DefaultTableModel)view_table.getModel();

        double in_total, ex_total;
        
        total_credit.setText("Opening Balance :");
        total_debit.setText("Remaining Balance :");
        rembal.setText("Total");
        opbal.setVisible(false);
        opbalvalue.setVisible(false);
        bal.setText(String.valueOf(balence));
        view_op_bal.setText(String.valueOf(open_balanceG));

        String type = (String) sel_in_exp.getSelectedItem();
        String f_date = "", t_date = "";
        if(type.equals("Select")){
            JOptionPane.showMessageDialog(null, "Please Select Income/Excepense...");
            sel_in_exp.grabFocus();
        }
        else{
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                f_date = sdf.format(from_date.getDate());
                t_date = sdf.format(to_date.getDate());
                
                 preview_but.setEnabled(true);
                 
                if(type.equals("All"))
                {
                    String query_all = "TRUNCATE TABLE acc_all;";
                    stmt.executeQuery(query_all);
                    System.out.println("Truncate Sucessful...with date");
                    query_all = "CALL show_all();";
                    stmt.executeQuery(query_all);
                    System.out.println("CALL Show_all query Sucessful...");
                        
                    String sql_query = "SELECT\n" +
                    "  `date` \"Date\",\n" +
                    "  `receipt_no` \"Receipt No.\",\n" +
                    "  `desc` \"Description\",\n" +
                    "  `cat_type` \"Category\",\n" +
                    "  `amt_with`\"Withdrawn\",\n" +
                    "  `amt_depo` \"Amount Paid\",\n" +
                    "  `trans_type` \"Transaction Type\",\n" +
                    "  `done_by` \"Done By\",\n" +
                    "  `i_e` \"Income/Expense\" from acc_all e where e.date >= \""+f_date+"\" AND e.date <= \""+t_date+"\" order by date;";
                    System.out.println(sql_query);
                    rs=stmt.executeQuery(sql_query);

                    System.out.println(rs);
                    view_table.setModel(DbUtils.resultSetToTableModel(rs));
                    
                    total_credit.setText("Total Credit:");
                    total_debit.setText("Total Debit:");
                    rembal.setText("Remaining Balance:");
                    
                    String sql_query1 = "SELECT SUM(amt_with) total_credit,SUM(amt_depo) total_debit,SUM(amt_with)-SUM(amt_depo) balance FROM acc_all e where e.date >= \""+f_date+"\" AND e.date <= \""+t_date+"\";";
                    System.out.println(sql_query1);
                    PreparedStatement pps = con.prepareStatement(sql_query1);
                    rs = pps.executeQuery();
                    rs.next();
                    opbal.setVisible(true);
                    opbalvalue.setVisible(true);
                    rembal.setText("Balance :");
                    int x = rs.getInt("total_credit") + open_balanceG;
                    opbalvalue.setText(String.valueOf(open_balanceG));
                    view_op_bal.setText(String.valueOf(x));
                    bal.setText(rs.getString("total_debit"));
                    int dup = rs.getInt("balance")+(open_balanceG);
                    total_field.setText(String.valueOf(dup));
                }    
                else{
                    String sql_query = "Select * from "+ type +" e where e.date >= \""+f_date+"\" AND e.date <= \""+t_date+"\";";
                    System.out.println(sql_query);
                
                    PreparedStatement pps = con.prepareStatement(sql_query);
                    rs = pps.executeQuery();

                    view_table.setModel(DbUtils.resultSetToTableModel(rs));

                    if(type.equals("income")){
                        String sql_query1 = "Select SUM(amount_withdraw) sum from "+ type +" e where e.date >= \""+f_date+"\" AND e.date <= \""+t_date+"\";";
                        System.out.println(sql_query1);
                        pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        in_total = Double.parseDouble(rs.getString("sum"));
                        total_field.setText(String.valueOf(in_total));
                    }
                    else if(type.equals("expense")){
                        String sql_query1 = "Select SUM(amount_paid) sum from "+ type +" e where e.date >= \""+f_date+"\" AND e.date <= \""+t_date+"\";";
                        System.out.println(sql_query1);
                        pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        ex_total = Double.parseDouble(rs.getString("sum"));
                        total_field.setText(String.valueOf(ex_total));
                    }
                    else{
                        String sql_query1 = "SELECT SUM(amt_with) total_credit,SUM(amt_depo) total_debit,SUM(amt_with)-SUM(amt_depo) balance FROM acc_all e where e.date >= \""+f_date+"\" AND e.date <= \""+t_date+"\";";
                        System.out.println(sql_query1);
                        pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        int x = rs.getInt("total_credit") + open_balanceG;
                        rembal.setText("Balance :");
                        total_credit.setText(String.valueOf(x));
                        bal.setText(rs.getString("total_debit"));
                        int dup = rs.getInt("balance")+(open_balanceG);
                        total_field.setText(String.valueOf(dup));
                    }
                }
            }
            catch(NullPointerException e){
                if(type.equals("All")){
                    try{
                        preview_but.setEnabled(true);
                        
                        String query_all = "TRUNCATE TABLE acc_all;";
                        stmt.executeQuery(query_all);
                        System.out.println("Truncate Sucessful...");
                        query_all = "CALL show_all();";
                        stmt.executeQuery(query_all);
                        System.out.println("CALL Show_all query Sucessful...");
                        
                        String sql_query = "SELECT\n" +
                        "  `date` \"Date\",\n" +
                        "  `receipt_no` \"Receipt No.\",\n" +
                        "  `desc` \"Description\",\n" +
                        "  `cat_type` \"Category\",\n" +
                        "  `amt_with`\"Withdrawn\",\n" +
                        "  `amt_depo` \"Amount Paid\",\n" +
                        "  `trans_type` \"Transaction Type\",\n" +
                        "  `done_by` \"Done By\",\n" +
                        "  `i_e` \"Income/Expense\" from acc_all order by date;";
                        System.out.println(sql_query);

                        rs = stmt.executeQuery(sql_query);
                        //System.out.println(rs);
                        view_table.setModel(DbUtils.resultSetToTableModel(rs));
                        
                        total_credit.setText("Total Credit:");
                        total_debit.setText("Total Debit:");

                        String sql_query1 = "SELECT SUM(amt_with) total_credit,SUM(amt_depo) total_debit,SUM(amt_with)-SUM(amt_depo) balance FROM acc_all;";
                        System.out.println(sql_query1);
                        PreparedStatement pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        opbal.setVisible(true);
                        opbalvalue.setVisible(true);
                        rembal.setText("Balance :");
                        int x = rs.getInt("total_credit") + open_balanceG;
                        System.out.println("total credit : "+rs.getString("total_credit"));
                        opbalvalue.setText(String.valueOf(open_balanceG));
                        view_op_bal.setText(String.valueOf(x));
                        bal.setText(rs.getString("total_debit"));
                        int dup = rs.getInt("balance")+(open_balanceG);
                        total_field.setText(String.valueOf(dup));
                        
                  }catch(Exception ex)
                  {
                    JOptionPane.showMessageDialog(null,ex+"\n Please contact your developer");
                  }
                }
                else{

                String sql_query = "Select * from "+ type +";";
                System.out.println(sql_query);
                try{
                    PreparedStatement pps = con.prepareStatement(sql_query);
                    rs = pps.executeQuery();

                    view_table.setModel(DbUtils.resultSetToTableModel(rs));

                    if(type.equals("income")){
                        String sql_query1 = "Select SUM(amount_withdraw) sum from "+ type +";";
                        System.out.println(sql_query1);
                        pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        in_total = Double.parseDouble(rs.getString("sum"));
                        total_field.setText(String.valueOf(in_total));
                    }
                    else if(type.equals("expense")){
                        String sql_query1 = "Select SUM(amount_paid) sum from "+ type +";";
                        System.out.println(sql_query1);
                        pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        ex_total = Double.parseDouble(rs.getString("sum"));
                        total_field.setText(String.valueOf(ex_total));
                    }
                    else{
                        String sql_query1 = "SELECT SUM(amt_with) total_credit,SUM(amt_depo) total_debit,SUM(amt_with)-SUM(amt_depo) balance FROM acc_all;";
                        System.out.println(sql_query1+"...................");
                        pps = con.prepareStatement(sql_query1);
                        rs = pps.executeQuery();
                        rs.next();
                        int x = rs.getInt("total_credit") + open_balanceG;
                        System.out.println("total credit : "+rs.getString("total_credit"));
                        rembal.setText("Balance :");
                        total_credit.setText(String.valueOf(x));
                        bal.setText(rs.getString("total_debit"));
                        int dup = rs.getInt("balance")+(open_balanceG);
                        total_field.setText(String.valueOf(dup));
                    }
                    preview_but.setEnabled(true);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }  
        
            }
            catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex);
                }
        }
    }//GEN-LAST:event_but_viewActionPerformed

    private void addIncomeToDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIncomeToDBActionPerformed
        
        String d_in="";

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            d_in = sdf.format(date_income.getDate());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Select Date...");
            ent_date.grabFocus();
        }

        String amt_widn = amt_wd.getText();
        String widn_type = (String) wd_type.getSelectedItem();
        String inc_note = in_note.getText();
        String rep_no = i_rec_no.getText();
        String entby = ent_by.getText();

        if(!amt_widn.equals("")||amt_widn.equals(null)){
            if(!widn_type.equals("Select")){
                try{
                    int id;
                    String sql="SELECT id FROM income WHERE id=(SELECT MAX(id) FROM income);";
                    PreparedStatement pps = con.prepareStatement(sql);
                    rs = pps.executeQuery();
                    if(rs.first()){
                        System.out.println("Came If...");
                        id = Integer.parseInt(rs.getString("id"));
                    }
                    else{
                        id=1;
                    }
                    System.out.println("sgalsidgalisdga");
                    sql = "insert into income ("
                    +"id,"
                    +"amount_withdraw,"
                    +"date,"
                    +"note,"
                    +"receipt_no,"
                    +"entered_by,"
                    +"type)"
                    +"values('"+ (id+1) +"','"+ amt_widn +"','"+ d_in +"','"+ inc_note +"','"+ rep_no +"','"+ entby +"','"+ widn_type +"')";

                    pps = con.prepareStatement(sql);
                    pps.execute();

                    JOptionPane.showMessageDialog(null, "Data Entered Successfully Into Database...");
                    
                    SimpleDateFormat df = new SimpleDateFormat("dd  MMMM  yyyy  HH:mm:ss");
                    java.util.Date ddd=new java.util.Date();
                    String dt=df.format(ddd);

                    String tpe = "Income", act = "Entered";

                    sql = "insert into accounts_history ("
                    +"his_date,"
                    +"name,"
                    +"type,"
                    +"action)"
                    +"values('"+ dt +"','"+  entby +"','"+ tpe +"','"+ act +"')";

                    pps = con.prepareStatement(sql);
                    pps.execute();
                    
                    dispose();
                    HomeScreen s = new HomeScreen();
                    s.setVisible(true);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please Select Withdraw Type...");
                wd_type.grabFocus();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Amount Withdrawn Should Not Be Empty...");
            amt_wd.grabFocus();
        }
    }//GEN-LAST:event_addIncomeToDBActionPerformed

    private void add_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_categoryActionPerformed
        
        dispose();
        addCategory s = new addCategory();
        s.setVisible(true);

    }//GEN-LAST:event_add_categoryActionPerformed

    private void saveDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDBActionPerformed
        
        String d="";

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            d = sdf.format(ent_date.getDate());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Select Date...");
            ent_date.grabFocus();
        }

        String rec_no = receipt_no.getText();
        String desc = des.getText();
        String tp = (String) type.getSelectedItem();
        String amt_depo = amt_dep.getText();
        String depo_type = (String) dep_type.getSelectedItem();
        String recp_by = rec_by.getText();

        if(desc.equals("xyz")||!desc.equals("")||!desc.equals(null)){
            if(!tp.equals("Select")){
                if(!depo_type.equals("Select")){
                    if(!recp_by.equals("Select")){
                        if(!amt_depo.equals("")||!amt_depo.equals(null)||!amt_depo.equals("0")){
                            try{
                                String sql="SELECT id FROM expense WHERE id=(SELECT MAX(id) FROM expense);";
                                PreparedStatement pps = con.prepareStatement(sql);
                                rs = pps.executeQuery();
                                rs.next();

                                int id=0;

                                if(rs.first()){
                                    id = Integer.parseInt(rs.getString("id"));
                                }
                                else{
                                    id=1;
                                }

                                sql = "insert into expense ("
                                +"id,"
                                +"date,"
                                +"receipt_no,"
                                +"description,"
                                +"type,"
                                +"amount_paid,"
                                +"deposite_type,"
                                +"received_by)"
                                +"values('"+ (id+1) +"','"+  d +"','"+ rec_no +"','"+ desc +"','"+ tp +"','"+ amt_depo +"','"+ depo_type +"','"+ recp_by +"')";

                                pps = con.prepareStatement(sql);
                                pps.execute();

                                JOptionPane.showMessageDialog(null, "Data Entered Successfully Into Database...");
                                
                                SimpleDateFormat df = new SimpleDateFormat("dd  MMMM  yyyy  HH:mm:ss");
                                java.util.Date ddd=new java.util.Date();
                                String dt=df.format(ddd);
                                
                                String tpe = "Expense", act = "Entered";
                                
                                sql = "insert into accounts_history ("
                                +"his_date,"
                                +"name,"
                                +"type,"
                                +"action)"
                                +"values('"+ dt +"','"+  recp_by +"','"+ tpe +"','"+ act +"')";
                                
                                pps = con.prepareStatement(sql);
                                pps.execute();
                                
                                dispose();
                                HomeScreen s = new HomeScreen();
                                s.setVisible(true);
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null, e);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Amount Deposited Should Not Be Empty...");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Please Select Receiced By...");
                        rec_by.grabFocus();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please Select Deposite Type...");
                    dep_type.grabFocus();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Please Select Category Type...");
                type.grabFocus();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Description Should Not Be Empty...");
            des.grabFocus();
        }

    }//GEN-LAST:event_saveDBActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void amt_depActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amt_depActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amt_depActionPerformed

    private void receipt_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receipt_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receipt_noActionPerformed

    private void preview_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preview_butActionPerformed
        // TODO add your handling code here:
        String info[] = new String [10];
        DefaultTableModel view_model1 = (DefaultTableModel)view_table.getModel();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            info[0] = sdf.format(from_date.getDate());
            info[1] = sdf.format(to_date.getDate());
            info[2] = (String) sel_in_exp.getSelectedItem();
            //info[3] = view_model1.getValueAt(view_table.getSelectedRow(), 0).toString();
            info[3] = uname;
            info[4] = String.valueOf(open_balanceG);
            info[5] = String.valueOf(balence);
            dispose();
            System.out.println("Preview pressed....");
            AccountPreview.main(info);
        }
        catch(Exception e){
            info[0] = "0";
            info[1] = "0";
            info[2] = (String) sel_in_exp.getSelectedItem();
            //info[3] = view_model1.getValueAt(view_table.getSelectedRow(), 0).toString();
            info[3] = uname;
            info[4] = String.valueOf(open_balanceG);
            info[5] = String.valueOf(balence);
            dispose();
            System.out.println("Preview pressed....");
            AccountPreview.main(info);
        }
        
    }//GEN-LAST:event_preview_butActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel view_model = (DefaultTableModel)view_history.getModel();
        
        String sql = "select * from accounts_history";
        
        try{
            PreparedStatement pps = con.prepareStatement(sql);
            rs = pps.executeQuery();
            
            view_history.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chang_openbalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chang_openbalActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf=new SimpleDateFormat("dd");
        SimpleDateFormat cur_sdf=new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date end_date=new java.util.Date();
        
        String end_datS=sdf.format(end_date);
        int end_dat=Integer.parseInt(end_datS);
        System.out.println(end_dat);
        
        String cur_date=cur_sdf.format(end_date);
        
        if(end_dat==28||end_dat==29||end_dat==30||end_dat==31)
        {
          try{
            stmt = con.createStatement();
            stmt.executeQuery("USE employee_database");
            System.out.println("Database Connected...");

           String Query = "SELECT SUM(e.amount_paid) exp_bal FROM expense e WHERE e.date>=\""+open_dateG+"\" AND e.date<=\""+cur_date+"\";"; 
           PreparedStatement pst = con.prepareStatement(Query);
           System.out.println(Query);
           rs = pst.executeQuery();
           if(rs.first()){
               int exp_bal=rs.getInt("exp_bal");
                System.out.println(exp_bal);

                String Query2 = "SELECT SUM(i.amount_withdraw) income_bal FROM income i WHERE i.date>=\""+open_dateG+"\" AND i.date<=\""+cur_date+"\";"; 
                PreparedStatement pst2 = con.prepareStatement(Query2);
                System.out.println(Query2);
                rs2 = pst2.executeQuery();
                rs2.next();
                int income_bal=rs2.getInt("income_bal");
                System.out.println(income_bal);
                
                if(income_bal==0&&exp_bal==0){
                    JOptionPane.showMessageDialog(null, "No Entries From :"+open_dateG+" To :"+cur_date);
                }
                else{
                    String update_query = "UPDATE opening_bal SET date = \""+cur_date+"\",balance=\""+((income_bal+open_balanceG)-exp_bal)+"\";";
                    System.out.println(update_query);
                    PreparedStatement pst3 = con.prepareStatement(update_query);
                    pst3.execute();

                    JOptionPane.showMessageDialog(null,"Your current opening balance is :"+((income_bal+open_balanceG)-exp_bal)+" ");

                    open_bal.setText(String.valueOf(((income_bal+open_balanceG)-exp_bal)));
                    open_date.setText(cur_date);
                }
           }
           else{
               JOptionPane.showMessageDialog(null, "No Entries From :"+open_dateG+" To :"+cur_date);
           }
          }
          catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
          }
            
        }
        else
           JOptionPane.showMessageDialog(null, "This is not month ending...");
        
    }//GEN-LAST:event_chang_openbalActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        
        con = connect.ConnectDB();
    } 

    public static void main(String args[]) {
        uname = args[0];
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
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addIncomeToDB;
    private javax.swing.JButton add_category;
    private javax.swing.JTextField add_ex_op_bal;
    private javax.swing.JTextField add_in_op_bal;
    private javax.swing.JTextField amt_dep;
    private javax.swing.JTextField amt_wd;
    private javax.swing.JTextField bal;
    private javax.swing.JButton but_view;
    private javax.swing.JButton chang_openbal;
    private com.toedter.calendar.JDateChooser date_income;
    private javax.swing.JTabbedPane delete_item;
    private javax.swing.JComboBox dep_type;
    private javax.swing.JTextField des;
    private javax.swing.JTextField ent_by;
    private com.toedter.calendar.JDateChooser ent_date;
    private javax.swing.JTextField ex_rem_bal;
    private com.toedter.calendar.JDateChooser from_date;
    private javax.swing.JTextField i_rec_no;
    private javax.swing.JTextField in_note;
    private javax.swing.JTextField in_rem_bal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel opbal;
    private javax.swing.JLabel opbalvalue;
    private javax.swing.JLabel open_bal;
    private javax.swing.JLabel open_date;
    private javax.swing.JButton preview_but;
    private javax.swing.JTextField rec_by;
    private javax.swing.JTextField receipt_no;
    private javax.swing.JLabel rembal;
    private javax.swing.JButton saveDB;
    private javax.swing.JComboBox sel_in_exp;
    private com.toedter.calendar.JDateChooser to_date;
    private javax.swing.JLabel total_credit;
    private javax.swing.JLabel total_debit;
    private javax.swing.JTextField total_field;
    public javax.swing.JComboBox type;
    private javax.swing.JTable view_history;
    private javax.swing.JTextField view_op_bal;
    private javax.swing.JTable view_table;
    private javax.swing.JComboBox wd_type;
    // End of variables declaration//GEN-END:variables
}
