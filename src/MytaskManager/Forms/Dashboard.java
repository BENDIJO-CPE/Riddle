package MytaskManager.Forms;

import MytaskManager.Components.Qoutes;
import MytaskManager.Components.Riddle;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Dashboard extends javax.swing.JPanel {
    private Riddle randomRiddle;
       
    public Dashboard() {
        initComponents();
        setOpaque(false);
        jTextPane1.setBorder(null);
        jTextPane1.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane1.setBorder(null);
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        times();
        displayQoutes();
        displayRiddle();
        
        
        jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            
            }
        });
        

    }
    
    public void displayRiddle(){
      
        randomRiddle = Riddle.getRiddle();
        jTextPane2.setText(randomRiddle.getQuestion());   
        jTextField1.setVisible(true);
        jLabel1.setVisible(true);
       
        
        jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
 
        
    }



   


private String currentQuote;
private String currentRiddle;
public void displayQoutes() {
    Qoutes qoutes = new Qoutes();
    String randomQuote = qoutes.getRandomQuote();

    jTextPane1.setText(""); // muerase sa past qoutes

    long currentTimeMillis = System.currentTimeMillis();
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(currentTimeMillis);
    int currentHour = cal.get(Calendar.HOUR_OF_DAY);
    int currentMinute = cal.get(Calendar.MINUTE);
    int currentSecond = cal.get(Calendar.SECOND);

    
    if (currentHour == 0 && currentMinute == 0 && currentSecond == 0) {
        try {
            jTextPane1.getDocument().insertString(jTextPane1.getDocument().getLength(), randomQuote + "\n", null);

            // Save the quote to a file
            FileWriter writer = new FileWriter("quote.txt");
            writer.write(randomQuote);
            writer.close();

            // Update the current quote
            currentQuote = randomQuote;

        } catch (IOException | BadLocationException e) {
            e.printStackTrace();
        }
    } else {
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("quote.txt"));
            String quote = reader.readLine();
            reader.close();

            jTextPane1.setText(quote);

            currentQuote = quote;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
        
        try {
            FileWriter writer = new FileWriter("quote.txt");
            writer.write(currentQuote);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
});
        try {
        BufferedReader reader = new BufferedReader(new FileReader("quote.txt"));
        String quote = reader.readLine();
        reader.close();

        jTextPane1.setText(quote);

        currentQuote = quote;

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    Timer t ;
    SimpleDateFormat st ;
    
public void times() {
    t = new Timer(1000, (ActionEvent e) -> {
        Calendar cal = Calendar.getInstance();
        int currentHour = cal.get(Calendar.HOUR_OF_DAY);
        int currentMinute = cal.get(Calendar.MINUTE);
        int currentSecond = cal.get(Calendar.SECOND);
//        int currentMilliSeconds = cal.get(Calendar.MILLISECOND);
        
        //time 00:00:00
        if (currentHour == 0 && currentMinute == 0 && currentSecond == 0) {
            displayQoutes();
            displayRiddle();
        }

        
        Date date = new Date();
        st = new SimpleDateFormat("HH:mm a");
        String currentTime = st.format(date);
        t_time.setText(currentTime);

        // Check the time and update the image and greeting
        if (currentHour >= 0 && currentHour < 12) {
            // Load and set the morning icon for changeimage JLabel
            ImageIcon icon = new ImageIcon(getClass().getResource("/MytaskManager/icon/morning.png"));
            changeimage.setIcon(icon);
            dayGreetings.setText("Good Morning");
        } else if (currentHour >= 12 && currentHour < 18) {
            // Load and set the afternoon icon for changeimage JLabel
            ImageIcon icon = new ImageIcon(getClass().getResource("/MytaskManager/icon/afternoon.png"));
            changeimage.setIcon(icon);
            dayGreetings.setText("Good Afternoon");
        } else {
            // Load and set the evening icon for changeimage JLabel
            ImageIcon icon = new ImageIcon(getClass().getResource("/MytaskManager/icon/evening.png"));
            changeimage.setIcon(icon);
            dayGreetings.setText("Good Evening");
        }
    });
    t.start();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new MytaskManager.Components.PanelRound();
        dayGreetings = new javax.swing.JLabel();
        t_time = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        changeimage = new javax.swing.JLabel();
        panelRound4 = new MytaskManager.Components.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        panelRound7 = new MytaskManager.Components.PanelRound();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        panelRound2 = new MytaskManager.Components.PanelRound();
        Qoutes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        panelRound1.setRoundBottomLeft(90);
        panelRound1.setRoundBottomRight(90);
        panelRound1.setRoundTopLeft(90);
        panelRound1.setRoundTopRight(90);

        dayGreetings.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dayGreetings.setForeground(new java.awt.Color(142, 117, 117));
        dayGreetings.setText("Good morning ");

        t_time.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        t_time.setForeground(new java.awt.Color(142, 117, 117));
        t_time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t_time.setText("0");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 255, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Admin");

        changeimage.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        changeimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/morning.png"))); // NOI18N

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(t_time, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeimage))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dayGreetings, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(dayGreetings, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(t_time, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(changeimage, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panelRound4.setRoundBottomLeft(90);
        panelRound4.setRoundBottomRight(90);
        panelRound4.setRoundTopLeft(90);
        panelRound4.setRoundTopRight(90);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(142, 117, 117));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Statistics");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        panelRound7.setRoundBottomLeft(90);
        panelRound7.setRoundBottomRight(90);
        panelRound7.setRoundTopLeft(90);
        panelRound7.setRoundTopRight(90);

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        panelRound2.setRoundBottomLeft(90);
        panelRound2.setRoundBottomRight(90);
        panelRound2.setRoundTopLeft(90);
        panelRound2.setRoundTopRight(90);

        Qoutes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Qoutes.setForeground(new java.awt.Color(142, 117, 117));
        Qoutes.setText("Qoute of the Day");

        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Sylfaen", 1, 20)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(142, 117, 117));
        jTextPane1.setOpaque(false);
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(Qoutes, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(Qoutes)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jTextPane2);

        jLabel1.setText("Answer:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Riddle of the Day");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
        String userAnswer = jTextField1.getText().trim().toLowerCase();
        String correctAnswer = randomRiddle.getAnswer().toLowerCase();
        
        if (userAnswer.equals(correctAnswer)) {
            JOptionPane.showMessageDialog(this, "Amazing! Correct!", "Correct", JOptionPane.INFORMATION_MESSAGE);
                
            jTextField1.setVisible(false);
            jLabel1.setVisible(false);
            jTextPane2.setText("Waiting for another riddle...");
            jTextField1.setText("");
           
            
        } else {
            JOptionPane.showMessageDialog(this, "Sorry, try again!", "Incorrect", JOptionPane.ERROR_MESSAGE);
            jTextField1.setText("");
        }

            jTextField1.selectAll();
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Qoutes;
    public javax.swing.JLabel changeimage;
    private javax.swing.JLabel dayGreetings;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private MytaskManager.Components.PanelRound panelRound1;
    private MytaskManager.Components.PanelRound panelRound2;
    private MytaskManager.Components.PanelRound panelRound4;
    private MytaskManager.Components.PanelRound panelRound7;
    private javax.swing.JLabel t_time;
    // End of variables declaration//GEN-END:variables
}
