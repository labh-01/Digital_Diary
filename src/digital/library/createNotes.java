package digital.library;

import static digital.library.createDiary.JDBC_DRIVER;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class createNotes extends javax.swing.JFrame {

    String diary = "";
    String backup = "";
    int listfav = 0;
     Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst;
     DefaultTableModel model;
    ArrayList<Eventdetail> events ;
    ArrayList<Eventdetail> favevents;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/digital_diary";
    static final String user = "root";
    static final String password = "welcome";
     Date date = new Date();//For reference
     SimpleDateFormat sdf = new SimpleDateFormat("d MMM YYYY");
 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();    
    public createNotes(String text) {
        diary = text;
        backup = diary+"restore";
        initComponents();
        showCurrentDate.setText(sdf.format(date));
        showCurrTime();
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
        SwingUtilities.updateComponentTreeUI(this);
        this.setResizable(false);
         this.setLocation(350,100);
        addAcceleratorToMenu();
        setFalseVisible();
        model = (DefaultTableModel)eventTable.getModel();
        String qry = "SELECT * from "+diary;
        showInTable(qry);
         }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        createNotesPanel = new javax.swing.JPanel();
        eventScroll = new javax.swing.JScrollPane();
        eventTable = new javax.swing.JTable();
        DateNotes = new com.toedter.calendar.JDateChooser();
        search = new javax.swing.JButton();
        innerFrame = new javax.swing.JInternalFrame();
        writeNotesPanel = new javax.swing.JPanel();
        favrte = new javax.swing.JCheckBox();
        titlefield = new javax.swing.JTextField();
        tlabel = new javax.swing.JLabel();
        detailScroll = new javax.swing.JScrollPane();
        detailArea = new javax.swing.JEditorPane();
        showCurrentDate = new javax.swing.JTextField();
        showCurrentTime = new javax.swing.JTextField();
        bglabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        create = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        undo = new javax.swing.JMenuItem();
        cut = new javax.swing.JMenuItem();
        copy = new javax.swing.JMenuItem();
        paste = new javax.swing.JMenuItem();
        delete = new javax.swing.JMenuItem();
        selectAll = new javax.swing.JMenuItem();
        FormatMenu = new javax.swing.JMenu();
        Font = new javax.swing.JMenuItem();
        Background = new javax.swing.JMenuItem();
        ThemeMenu = new javax.swing.JMenu();
        Comic = new javax.swing.JMenuItem();
        Study = new javax.swing.JMenuItem();
        Sunshine = new javax.swing.JMenuItem();
        Shadow = new javax.swing.JMenuItem();
        Dark = new javax.swing.JMenuItem();
        favButton = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 100));
        setMaximumSize(new java.awt.Dimension(750, 500));
        setPreferredSize(new java.awt.Dimension(740, 500));

        createNotesPanel.setBackground(new java.awt.Color(0, 102, 102));
        createNotesPanel.setPreferredSize(new java.awt.Dimension(750, 500));

        eventScroll.setBackground(new java.awt.Color(0, 102, 102));
        eventScroll.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        eventScroll.setOpaque(false);

        eventTable.setBackground(new java.awt.Color(255, 204, 255));
        eventTable.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        eventTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event", "Last Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eventTable.setGridColor(new java.awt.Color(255, 153, 153));
        eventTable.setRowSelectionAllowed(false);
        eventTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openNotes(evt);
            }
        });
        eventScroll.setViewportView(eventTable);
        if (eventTable.getColumnModel().getColumnCount() > 0) {
            eventTable.getColumnModel().getColumn(1).setResizable(false);
            eventTable.getColumnModel().getColumn(1).setPreferredWidth(16);
        }

        DateNotes.setBackground(new java.awt.Color(0, 102, 102));
        DateNotes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DateNotes.setDateFormatString("d MMM yyyy");
        DateNotes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        search.setBackground(new java.awt.Color(153, 255, 204));
        search.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search By Date");
        search.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 255, 153), new java.awt.Color(153, 255, 102), null, null));
        search.setOpaque(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        innerFrame.setVisible(true);

        writeNotesPanel.setBackground(new java.awt.Color(204, 255, 204));
        writeNotesPanel.setLayout(null);

        favrte.setBackground(new java.awt.Color(255, 250, 240));
        favrte.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        favrte.setForeground(new java.awt.Color(255, 250, 240));
        favrte.setText("Favourite");
        favrte.setBorder(null);
        favrte.setOpaque(false);
        writeNotesPanel.add(favrte);
        favrte.setBounds(360, 0, 100, 25);

        titlefield.setBackground(new java.awt.Color(255, 250, 240));
        titlefield.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        titlefield.setForeground(new java.awt.Color(255, 250, 240));
        titlefield.setText(" ");
        titlefield.setOpaque(false);
        writeNotesPanel.add(titlefield);
        titlefield.setBounds(140, 25, 250, 30);

        tlabel.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        tlabel.setForeground(new java.awt.Color(51, 255, 204));
        tlabel.setText("Title :*");
        writeNotesPanel.add(tlabel);
        tlabel.setBounds(42, 25, 68, 30);

        detailScroll.setOpaque(false);

        detailArea.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        detailScroll.setViewportView(detailArea);

        writeNotesPanel.add(detailScroll);
        detailScroll.setBounds(45, 70, 380, 320);

        showCurrentDate.setEditable(false);
        showCurrentDate.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        showCurrentDate.setForeground(new java.awt.Color(204, 255, 204));
        showCurrentDate.setBorder(null);
        showCurrentDate.setOpaque(false);
        writeNotesPanel.add(showCurrentDate);
        showCurrentDate.setBounds(291, 392, 102, 20);

        showCurrentTime.setEditable(false);
        showCurrentTime.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        showCurrentTime.setForeground(new java.awt.Color(153, 255, 153));
        showCurrentTime.setBorder(null);
        showCurrentTime.setOpaque(false);
        writeNotesPanel.add(showCurrentTime);
        showCurrentTime.setBounds(394, 392, 80, 20);

        bglabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pen.jpg"))); // NOI18N
        writeNotesPanel.add(bglabel);
        bglabel.setBounds(0, 0, 473, 450);

        menuBar.setBackground(new java.awt.Color(204, 255, 255));
        menuBar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 153), null));
        menuBar.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N

        FileMenu.setText("File");

        create.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        create.setText("New");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        FileMenu.add(create);

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        FileMenu.add(Save);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        FileMenu.add(Exit);

        menuBar.add(FileMenu);

        EditMenu.setText("Edit");

        undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undo.setText("Undo");
        EditMenu.add(undo);

        cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cut.setText("Cut");
        cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutActionPerformed(evt);
            }
        });
        EditMenu.add(cut);

        copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copy.setText("Copy");
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copy(evt);
            }
        });
        EditMenu.add(copy);

        paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        paste.setText("Paste");
        paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paste(evt);
            }
        });
        EditMenu.add(paste);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNote(evt);
            }
        });
        EditMenu.add(delete);

        selectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        selectAll.setText("Select All");
        EditMenu.add(selectAll);

        menuBar.add(EditMenu);

        FormatMenu.setText("Format");

        Font.setText("Font");
        FormatMenu.add(Font);

        Background.setText("Background");
        FormatMenu.add(Background);

        ThemeMenu.setText("Themes");

        Comic.setText("SunShine");
        ThemeMenu.add(Comic);

        Study.setText("Shadow");
        ThemeMenu.add(Study);

        Sunshine.setText("Dark");
        ThemeMenu.add(Sunshine);

        Shadow.setText("Study");
        ThemeMenu.add(Shadow);

        Dark.setText("Comic");
        ThemeMenu.add(Dark);

        FormatMenu.add(ThemeMenu);

        menuBar.add(FormatMenu);

        innerFrame.setJMenuBar(menuBar);

        javax.swing.GroupLayout innerFrameLayout = new javax.swing.GroupLayout(innerFrame.getContentPane());
        innerFrame.getContentPane().setLayout(innerFrameLayout);
        innerFrameLayout.setHorizontalGroup(
            innerFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(writeNotesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );
        innerFrameLayout.setVerticalGroup(
            innerFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(writeNotesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        favButton.setBackground(new java.awt.Color(255, 204, 255));
        favButton.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        favButton.setForeground(new java.awt.Color(255, 255, 255));
        favButton.setText("Favourites");
        favButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 255, 153), new java.awt.Color(153, 255, 102), null, null));
        favButton.setOpaque(false);
        favButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favList(evt);
            }
        });

        javax.swing.GroupLayout createNotesPanelLayout = new javax.swing.GroupLayout(createNotesPanel);
        createNotesPanel.setLayout(createNotesPanelLayout);
        createNotesPanelLayout.setHorizontalGroup(
            createNotesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createNotesPanelLayout.createSequentialGroup()
                .addGroup(createNotesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eventScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createNotesPanelLayout.createSequentialGroup()
                        .addComponent(favButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search)))
                .addComponent(innerFrame)
                .addGap(0, 0, 0))
        );
        createNotesPanelLayout.setVerticalGroup(
            createNotesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createNotesPanelLayout.createSequentialGroup()
                .addComponent(eventScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(DateNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createNotesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(favButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 140, Short.MAX_VALUE))
            .addComponent(innerFrame)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(createNotesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(createNotesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

        String qry = "SELECT * from "+diary+" where last_modified_date = '"+dateString()+"'";
        if(!dateString().equals(""))
        showInTable(qry);
        else
            JOptionPane.showMessageDialog(createNotesPanel, "Select date to search");
        System.out.println(dateString());
    }//GEN-LAST:event_searchActionPerformed

    private void cutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutActionPerformed
        String str = detailArea.getSelectedText();
        StringSelection str2 = new StringSelection(str);
        clipboard.setContents(str2,str2);
        detailArea.replaceSelection("");
    }//GEN-LAST:event_cutActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        savenotes();
    }//GEN-LAST:event_SaveActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
       if(isOpenAny())
       {
       int cnfrm = JOptionPane.showConfirmDialog(innerFrame,"Save current notes ?");
       if(cnfrm == JOptionPane.YES_OPTION)
       {
           savenotes();
           setTrueVisible();
       }
       else{
           if(cnfrm == JOptionPane.NO_OPTION)
               setTrueVisible();         
       }
       }
       else
       setTrueVisible();
       
    }//GEN-LAST:event_createActionPerformed

    private void openNotes(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openNotes
        int i = eventTable.getSelectedRow();
        Eventdetail event = null;
        if(listfav%2 == 1)
            event = favevents.get(i);
        else
            event = events.get(i);
        setTrueVisible();
        titlefield.setText(event.title);
        detailArea.setText(event.notes);
            favrte.setSelected(event.fav);
        
    }//GEN-LAST:event_openNotes

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed

        if(isOpenAny()){
        int cnfrm = JOptionPane.showConfirmDialog(innerFrame,"Save current notes ?");
       if(cnfrm == JOptionPane.YES_OPTION)
       {
           savenotes();
           System.exit(0);
       }
       else{
           if(cnfrm == JOptionPane.NO_OPTION)
               System.exit(0);
       }
        }
        else
            System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void copy(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copy
         String str = detailArea.getSelectedText();
        StringSelection str2 = new StringSelection(str);
        clipboard.setContents(str2,str2);
    }//GEN-LAST:event_copy

    private void paste(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paste
        Transferable data = clipboard.getContents(clipboard);
        if(data.isDataFlavorSupported(DataFlavor.stringFlavor)){
            try {
                String str = (String)(data.getTransferData(DataFlavor.stringFlavor));
                detailArea.replaceSelection(str);
            } catch (UnsupportedFlavorException ex) {
                Logger.getLogger(createNotes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(createNotes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_paste

    private void deleteNote(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNote
        try {
            delete();
        } catch (SQLException ex) {
            Logger.getLogger(createNotes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteNote

    private void favList(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favList
                 resetTable();
                 listfav++;
                  Object[] col = new Object[2];
                 if(listfav%2 == 1)
                 {
                    for(int i=0;i<favevents.size();i++)
                    {
                    col[0] = favevents.get(i).title;
                    col[1] = favevents.get(i).last_modified_date;
                    model.addRow(col);
                 }
                 }
                 else
                 {
                      for(int i=0;i<events.size();i++)
                    {
                    col[0] = events.get(i).title;
                    col[1] = events.get(i).last_modified_date;
                    model.addRow(col);
                 }
                 }
    }//GEN-LAST:event_favList

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
            java.util.logging.Logger.getLogger(createNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createNotes("me").setVisible(true);
            }
        });
    }



void showInTable(String qry){
            resetTable();
    getEventdetail(qry);
    Object[] col = new Object[2];
    for(int i=0;i<events.size();i++)
    {
    col[0] = events.get(i).title;
    col[1] = events.get(i).last_modified_date;
    model.addRow(col);
    }
}    
void getEventdetail(String qry){
     events = new ArrayList<Eventdetail>();
     favevents = new ArrayList<Eventdetail>();
    getconnection();
    Eventdetail event;
    try{
        stmt = con.createStatement();
        rs = stmt.executeQuery(qry);
        while(rs.next())
        {
            event = new Eventdetail(rs.getString(1),rs.getString(2),rs.getString(3),rs.getBoolean(4));
            events.add(event);
            if(event.fav==true)
                favevents.add(event);
        }
    }
     catch(Exception ex){
        ex.printStackTrace();
    }
        finally{
                try{
                if(rs!=null)
                    rs.close();
                }
                catch(Exception ex){}
                }
    try{
                if(stmt!=null)
                    stmt.close();
                }
                catch(Exception ex){}
    if(con!=null)
        try {
            con.close();
     } catch (SQLException ex) {
         Logger.getLogger(createNotes.class.getName()).log(Level.SEVERE, null, ex);
     }                       
}
void getconnection(){
    try{
    Class.forName(JDBC_DRIVER);
    con = DriverManager.getConnection(DB_URL, user, password); 
    }
    catch(Exception ex){
        ex.printStackTrace();
    } 
 }
public void resetTable()
{
    int row = model.getRowCount();
    for(int i= row-1;i>=0;i--)
        model.removeRow(i);
}
public String dateString() {
        Date dt = (Date )DateNotes.getDate();
        if(dt!=null)
        {
        String d = dt.toString();
        String[] da = d.split(" ");
        String date = da[2]+" "+da[1]+" "+da[5];
        return date;
        }
        else
            return "";
    }
public void savenotes() {
         String title = titlefield.getText();
    String last_modified_date = sdf.format(date);
    String notes = detailArea.getText();
    Boolean fav = favrte.isSelected();
    String qry = "INSERT INTO "+diary+" (nname,last_modified_date,notes,fav,images) VALUES ('"+title+"','"+last_modified_date+"','"+notes+"','"+fav+"',NULL)"; 
    if(title.equals(""))
        JOptionPane.showMessageDialog(null,"Title is mandatory !!");
    else
    {
        boolean status = true;
        int size = events.size();
        for(int i = 0;i<size;i++)
        {
            if(events.get(i).title.equals(title) && events.get(i).last_modified_date.equals(last_modified_date))
            {
                status = false;
                break;
            }
        }
        if(status==true)
        executeQuery(qry);
        else
            updateEvent(title,last_modified_date,notes,fav);
        
        String show = "SELECT * from "+diary;    
        showInTable(show);
    }
    }
public void executeQuery(String sql){
        getconnection();
        try{
       stmt = con.createStatement();
       stmt.executeUpdate(sql);
        }
        catch(Exception ex){ex.printStackTrace();}
        finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }
            catch(Exception ex){}
            if(con!=null)
                try {
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(createNotes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
public void setFalseVisible() {
        tlabel.setVisible(false);
        titlefield.setVisible(false);
        detailScroll.setVisible(false);
        favrte.setVisible(false);
    }
public void setTrueVisible() {
        if(!tlabel.isVisible())
        tlabel.setVisible(true);
        if(!titlefield.isVisible())
        titlefield.setVisible(true);
        titlefield.setText("");
        if(!detailScroll.isVisible())
        detailScroll.setVisible(true);
        detailArea.setText("");
        if(!favrte.isVisible())
        favrte.setVisible(true);
        favrte.setSelected(false);
        
    }
public boolean isOpenAny()
    {
        if(tlabel.isVisible()|| titlefield.isVisible() || detailScroll.isVisible()|| favrte.isVisible())
            return true;
        else
            return false;
    }
public void updateEvent(String title,String last_modified_date,String notes,boolean fav)
{
    String qry = "UPDATE "+diary+" SET nname = '"+title+"' , last_modified_date = '"+last_modified_date+"' , notes = '"+notes+"' , fav = '"+fav+"' ,images = NULL WHERE nname = '"+title+"' AND last_modified_date = '"+last_modified_date+"'";
    executeQuery(qry);
}
 public void addAcceleratorToMenu()  {
   create.setMnemonic(KeyEvent.VK_N);
   Save.setMnemonic(KeyEvent.VK_S);
   Exit.setMnemonic(KeyEvent.VK_I);
   undo.setMnemonic(KeyEvent.VK_Z);
   cut.setMnemonic(KeyEvent.VK_X);
   copy.setMnemonic(KeyEvent.VK_C);
   paste.setMnemonic(KeyEvent.VK_V);
   selectAll.setMnemonic(KeyEvent.VK_A);
    }
 public void showCurrTime()
 {
     Thread t = new Thread(new Runnable() {
         @Override
         public void run() {
             while(true)
             {
                 try {
                     LocalTime t = LocalTime.now();
                     int h = t.getHour();
                     int m = t.getMinute();
                     int s = t.getSecond();
                     Thread.sleep(1000);
                     showCurrentTime.setText(h+":"+m+":"+s);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(createNotes.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
     });
     t.start();
 }
 public void delete() throws SQLException
 {
     int cnfrm = JOptionPane.YES_NO_OPTION;
     cnfrm = JOptionPane.showConfirmDialog(detailArea,"Confirm to delete this note ?",null,cnfrm);
     if(cnfrm == JOptionPane.YES_OPTION)
     {
        try {
            Eventdetail event;
            int i = eventTable.getSelectedRow();
            if(listfav%2 ==1)
                event = favevents.get(i);
            else
                event = events.get(i);
            backupnotes(event);
            getconnection();
            String del = "DELETE FROM "+diary+" WHERE nname = ? AND last_modified_date = ?";
            pst = con.prepareStatement(del);
            pst.setString(1,event.title);
            pst.setString(2,event.last_modified_date);
            pst.executeUpdate();
            pst.close();
            model.removeRow(i);
            if(listfav%2 == 1)
            {
                for(int j = 0;j<events.size();j++)
                {
                    if(events.get(i).last_modified_date == event.last_modified_date && events.get(i).title.equals(event.title))
                    {
                        events.remove(j);
                        break;
                    }
                }
                favevents.remove(i);
            }
            else
            {
                 for(int j = 0;j<favevents.size();j++)
                {
                    if(favevents.get(i).last_modified_date == event.last_modified_date && favevents.get(i).title.equals(event.title))
                    {
                        favevents.remove(j);
                        break;
                    }
                }
                events.remove(i);
            }
            setTrueVisible();
            setFalseVisible();
        } catch (SQLException ex) {
            Logger.getLogger(createNotes.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(con!=null)
                con.close();
        }
     }
 }
 public void backupnotes(Eventdetail event)
 {
            String qry = "INSERT INTO "+backup+" (nname,last_modified_date,notes,fav,images) VALUES ('"+event.title+"','"+event.last_modified_date+"','"+event.notes+"','"+event.fav+"',NULL)";
            executeQuery(qry);
 }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Background;
    private javax.swing.JMenuItem Comic;
    private javax.swing.JMenuItem Dark;
    private com.toedter.calendar.JDateChooser DateNotes;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem Font;
    private javax.swing.JMenu FormatMenu;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem Shadow;
    private javax.swing.JMenuItem Study;
    private javax.swing.JMenuItem Sunshine;
    private javax.swing.JMenu ThemeMenu;
    private javax.swing.JLabel bglabel;
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem create;
    private javax.swing.JPanel createNotesPanel;
    private javax.swing.JMenuItem cut;
    private javax.swing.JMenuItem delete;
    private javax.swing.JEditorPane detailArea;
    private javax.swing.JScrollPane detailScroll;
    private javax.swing.JScrollPane eventScroll;
    private javax.swing.JTable eventTable;
    private javax.swing.JButton favButton;
    private javax.swing.JCheckBox favrte;
    private javax.swing.JInternalFrame innerFrame;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem paste;
    private javax.swing.JButton search;
    private javax.swing.JMenuItem selectAll;
    private javax.swing.JTextField showCurrentDate;
    private javax.swing.JTextField showCurrentTime;
    private javax.swing.JTextField titlefield;
    private javax.swing.JLabel tlabel;
    private javax.swing.JMenuItem undo;
    private javax.swing.JPanel writeNotesPanel;
    // End of variables declaration//GEN-END:variables
   }
