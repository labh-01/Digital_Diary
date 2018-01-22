package digital.library;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author parth
 */
public class createDiary extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/digital_diary";
    static final String user = "root";
    static final String password = "welcome";
    public createDiary() {
         try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(createDiary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(createDiary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(createDiary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(createDiary.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(createDiary.this);
        initComponents();
        this.setResizable(false);
         this.setLocation(350,100);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createDiary = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        titlelabel = new javax.swing.JLabel();
        diaryName = new javax.swing.JLabel();
        diarypassword = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        passwdField = new javax.swing.JPasswordField();
        open = new javax.swing.JButton();
        backlabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        titlelabel1 = new javax.swing.JLabel();
        diaryName1 = new javax.swing.JLabel();
        diarypassword1 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        paswd2 = new javax.swing.JPasswordField();
        create = new javax.swing.JButton();
        paswd3 = new javax.swing.JPasswordField();
        diarypassword2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        backlabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 100));
        setPreferredSize(new java.awt.Dimension(605, 527));

        createDiary.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        jPanel1.setLayout(null);

        titlelabel.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        titlelabel.setForeground(new java.awt.Color(204, 255, 204));
        titlelabel.setText("Open Diary");
        jPanel1.add(titlelabel);
        titlelabel.setBounds(210, 50, 200, 60);

        diaryName.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        diaryName.setForeground(new java.awt.Color(0, 0, 153));
        diaryName.setText("Diary Title :");
        jPanel1.add(diaryName);
        diaryName.setBounds(80, 170, 140, 28);

        diarypassword.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        diarypassword.setForeground(new java.awt.Color(0, 0, 153));
        diarypassword.setText(" Password :");
        jPanel1.add(diarypassword);
        diarypassword.setBounds(80, 250, 130, 30);

        nameField.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        nameField.setForeground(new java.awt.Color(0, 102, 102));
        nameField.setOpaque(false);
        jPanel1.add(nameField);
        nameField.setBounds(240, 170, 250, 30);

        passwdField.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        passwdField.setForeground(new java.awt.Color(0, 102, 102));
        passwdField.setOpaque(false);
        jPanel1.add(passwdField);
        passwdField.setBounds(240, 250, 250, 30);

        open.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        open.setForeground(new java.awt.Color(102, 0, 102));
        open.setText("Open");
        open.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 255), new java.awt.Color(0, 204, 204), null, null));
        open.setOpaque(false);
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        jPanel1.add(open);
        open.setBounds(240, 320, 110, 30);

        backlabel.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        backlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/digital_diary.jpg"))); // NOI18N
        jPanel1.add(backlabel);
        backlabel.setBounds(0, 0, 595, 475);

        createDiary.addTab("Open", jPanel1);

        jPanel2.setLayout(null);

        titlelabel1.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        titlelabel1.setForeground(new java.awt.Color(204, 255, 204));
        titlelabel1.setText("Create Diary");
        jPanel2.add(titlelabel1);
        titlelabel1.setBounds(210, 40, 220, 60);

        diaryName1.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        diaryName1.setForeground(new java.awt.Color(0, 0, 153));
        diaryName1.setText("Diary Title :");
        jPanel2.add(diaryName1);
        diaryName1.setBounds(80, 150, 140, 28);

        diarypassword1.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        diarypassword1.setForeground(new java.awt.Color(0, 0, 153));
        diarypassword1.setText(" Password :");
        jPanel2.add(diarypassword1);
        diarypassword1.setBounds(80, 220, 130, 30);

        title.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        title.setForeground(new java.awt.Color(0, 102, 102));
        title.setOpaque(false);
        jPanel2.add(title);
        title.setBounds(240, 150, 250, 30);

        paswd2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        paswd2.setForeground(new java.awt.Color(0, 102, 102));
        paswd2.setOpaque(false);
        jPanel2.add(paswd2);
        paswd2.setBounds(240, 220, 250, 30);

        create.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        create.setForeground(new java.awt.Color(102, 0, 102));
        create.setText("Create");
        create.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 255), new java.awt.Color(0, 204, 204), null, null));
        create.setOpaque(false);
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create(evt);
            }
        });
        jPanel2.add(create);
        create.setBounds(240, 360, 110, 30);

        paswd3.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        paswd3.setForeground(new java.awt.Color(0, 102, 102));
        paswd3.setOpaque(false);
        jPanel2.add(paswd3);
        paswd3.setBounds(240, 300, 250, 30);

        diarypassword2.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        diarypassword2.setForeground(new java.awt.Color(0, 0, 153));
        diarypassword2.setText(" Password :");
        jPanel2.add(diarypassword2);
        diarypassword2.setBounds(80, 220, 130, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText(" Re-Password :");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(40, 300, 170, 30);

        backlabel1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        backlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/digital_diary.jpg"))); // NOI18N
        jPanel2.add(backlabel1);
        backlabel1.setBounds(0, 0, 595, 475);

        createDiary.addTab("Create", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(createDiary, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(createDiary, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void create(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create
        String pass1 = paswd2.getText();
        String pass2 = paswd3.getText();
        System.out.println(pass1);
        if(pass1.equals(pass2))
            createDiary();
        else
            JOptionPane.showMessageDialog(null,"Password not matched !!");
    }//GEN-LAST:event_create

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        try {
            String diary = nameField.getText();
            String pswd = passwdField.getText();
            getconnection();
            boolean status1 = false;
            boolean status2 = false;
            String listDiaries = "Select* from diarytitle";
            pst = con.prepareStatement(listDiaries);
            rs = pst.executeQuery();
            while(rs.next())
            {
                String a = rs.getString(1);
                String b = rs.getString(2);
                if(a.equals(diary))
                {
                    status1 = true;
                    if(b.equals(pswd))
                    {
                        status2 = true;
                    JOptionPane.showMessageDialog(null,"Hey ! Add notes to your diary...");
                    setVisible(false);
                    createNotes notes =  new createNotes(diary);
                    notes.setVisible(true);
                    break;
                }
                }
            }
            if(status1 == false && status2 == false)
                JOptionPane.showMessageDialog(null,"Diary doesn't exist !");
            else
            {
                if(status1 == true && status2 == false)
                    JOptionPane.showMessageDialog(null,"Password didn't match !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(createDiary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_openActionPerformed
 void getconnection(){
    try{
    Class.forName(JDBC_DRIVER);
    con = DriverManager.getConnection(DB_URL, user, password); 
    }
    catch(Exception ex){
        ex.printStackTrace();
    } 
 }
 void createDiary()
 {     
     String checkDiaryName = "Select* from diarytitle where title = ?";
     String createDiary = "CREATE TABLE "+title.getText()+
             "(nname VARCHAR(50) NOT NULL,"+
              "last_modified_date VARCHAR(20) NOT NULL,"+
              "notes VARCHAR(10000) , "+
             "fav VARCHAR(10) ,"+
             "images MEDIUMBLOB )";
     String backupDiary ="CREATE TABLE "+title.getText()+"Restore"+
             "(nname VARCHAR(50) NOT NULL,"+
              "last_modified_date VARCHAR(20) NOT NULL,"+
              "notes VARCHAR(10000) , "+
             "fav VARCHAR(10) ,"+
             "images MEDIUMBLOB )"; 
            getconnection();   
        try{
         pst =  con.prepareStatement(checkDiaryName);
        pst.setString(1,title.getText());
        rs = pst.executeQuery();
        if(rs.next())
            JOptionPane.showMessageDialog(null,"Diary already exist");
        else
        {
            stmt = con.createStatement();
            stmt.executeUpdate(createDiary);
            JOptionPane.showMessageDialog(null,"Your diary is created !");
            stmt.close();
             stmt = con.createStatement();
            stmt.executeUpdate(backupDiary);
            stmt.close();
             createNotes notes =  new createNotes(title.getText());
                    notes.setVisible(true);
            entryIndiaryList();
        }
            }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            try {
                    if(pst!=null)
                    pst.close();
                    if(con!=null)
                        con.close();
                    if(rs!=null)
                        rs.close();
                     this.setVisible(false);
            } catch (SQLException ex1) {
            ex1.printStackTrace();
            }
        }
 }
 void entryIndiaryList(){
        try {
            String str = "INSERT INTO diarytitle (title, pswd) VALUES ('"+title.getText()+"','"+paswd2.getText()+"')";
            stmt = con.createStatement();
            stmt.executeUpdate(str);
            stmt.close();
             String bkp = "INSERT INTO diarytitle (title, pswd) VALUES ('"+title.getText()+"restore"+"','"+paswd2.getText()+"')";
            stmt = con.createStatement();
            stmt.executeUpdate(bkp);
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(createDiary.class.getName()).log(Level.SEVERE, null, ex);
        }
     
 }
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(createDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createDiary().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backlabel;
    private javax.swing.JLabel backlabel1;
    private javax.swing.JButton create;
    private javax.swing.JTabbedPane createDiary;
    private javax.swing.JLabel diaryName;
    private javax.swing.JLabel diaryName1;
    private javax.swing.JLabel diarypassword;
    private javax.swing.JLabel diarypassword1;
    private javax.swing.JLabel diarypassword2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton open;
    private javax.swing.JPasswordField passwdField;
    private javax.swing.JPasswordField paswd2;
    private javax.swing.JPasswordField paswd3;
    private javax.swing.JTextField title;
    private javax.swing.JLabel titlelabel;
    private javax.swing.JLabel titlelabel1;
    // End of variables declaration//GEN-END:variables
}
