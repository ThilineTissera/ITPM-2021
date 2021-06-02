/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagement;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author SANDEEP
 */
public class sessionRooms extends javax.swing.JInternalFrame {

    /**
     * Creates new form sessionRooms
     */
    public sessionRooms() {
        initComponents();
        fillLecturer1();
       // fillLecturer2();
        
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI)this.getUI();
        bui.setNorthPane(null);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        selectSession = new javax.swing.JComboBox<>();
        dateChooser = new com.toedter.calendar.JDateChooser();
        timeFrom = new javax.swing.JComboBox<>();
        selectRoom = new javax.swing.JComboBox<>();
        selectLecturer = new javax.swing.JComboBox<>();
        timeTo = new javax.swing.JComboBox<>();
        tag = new javax.swing.JComboBox<>();
        subLecturer = new javax.swing.JComboBox<>();
        dateSub = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        dLabel = new java.awt.Label();
        dateOutLabel = new javax.swing.JLabel();
        sLabel = new java.awt.Label();
        sessionOutLabel = new javax.swing.JLabel();
        l1Label = new java.awt.Label();
        lec1OutLabel = new javax.swing.JLabel();
        l2Label = new java.awt.Label();
        rLabel = new java.awt.Label();
        tLabel = new java.awt.Label();
        timeFromOut = new javax.swing.JLabel();
        roomOutLabel = new javax.swing.JLabel();
        timeToOut = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lec2OutLabel = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        clear1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        selectSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectSessionActionPerformed(evt);
            }
        });

        dateChooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateChooserMouseClicked(evt);
            }
        });

        timeFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Time From", "8.30 am", "9.00 am", "9.30 am", "10.00 am", "10.30 am", "11.00 am", "11.30 am", "12.00 pm", "12.30 pm", "1.00 pm", "1.30 pm", "2.00 pm", "2.30 pm", "3.00 pm", "3.30 pm", "4.00 pm", "4.30 pm", "5.00 pm", "5.30 pm", "6.00 pm", "6.30 pm", "7.00 pm" }));
        timeFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeFromActionPerformed(evt);
            }
        });

        selectRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRoomActionPerformed(evt);
            }
        });

        selectLecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectLecturerActionPerformed(evt);
            }
        });

        timeTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Time To", "8.30 am", "9.00 am", "9.30 am", "10.00 am", "10.30 am", "11.00 am", "11.30 am", "12.00 pm", "12.30 pm", "1.00 pm", "1.30 pm", "2.00 pm", "2.30 pm", "3.00 pm", "3.30 pm", "4.00 pm", "4.30 pm", "5.00 pm", "5.30 pm", "6.00 pm", "6.30 pm", "7.00 pm" }));
        timeTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeToActionPerformed(evt);
            }
        });

        subLecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subLecturerActionPerformed(evt);
            }
        });

        dateSub.setText("--");
        dateSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateSubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectSession, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateSub)
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeFrom, 0, 196, Short.MAX_VALUE))
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectLecturer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeTo, 0, 370, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(subLecturer, 0, 306, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tag, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectSession, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateSub, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(timeTo)
                    .addComponent(tag, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeFrom))
                .addGap(23, 23, 23))
        );

        jCheckBox1.setText("Click here if you have consecutive sessions");

        dLabel.setText("DATE");

        dateOutLabel.setText("-----------------------------");

        sLabel.setText("Session");

        sessionOutLabel.setText("-----------------------------");

        l1Label.setText("Lecturer 1");

        lec1OutLabel.setText("-----------------------------");

        l2Label.setText("Lecturer 2");

        rLabel.setText("Room");

        tLabel.setText("TIME");

        timeFromOut.setText("-----------");

        roomOutLabel.setText("-----------------------------");

        timeToOut.setText("------------");

        jLabel1.setText("--");

        lec2OutLabel.setText("-----------------------------");

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGap(730, 730, 730))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(l1Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(lec1OutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sessionOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roomOutLabel)
                            .addComponent(lec2OutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeFromOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addComponent(timeToOut, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(264, 264, 264))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jCheckBox1)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(timeFromOut, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(timeToOut, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l2Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lec2OutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sessionOutLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l1Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lec1OutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        clear1.setText("Clear");
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 602, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(757, 757, 757)
                    .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(757, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(370, 370, 370)
                    .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(370, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String ss = ""; // session
    String sr = ""; // rooms
    String sl1 = ""; // select lec
    String sl2 = ""; // sublec
    String d = ""; // date 
    String tf = ""; // time from
    String tt = ""; //time to
    String tags = "";
    
    
    private void selectSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSessionActionPerformed
        ss = selectSession.getSelectedItem().toString();
        sessionOutLabel.setText(ss);
    }//GEN-LAST:event_selectSessionActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clearFileds();
    }//GEN-LAST:event_clearActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
            tags = tag.getSelectedItem().toString();
            
            
            if(sl1 == "Select Lecturer" || sl2 == "Select Lecturer")
            {
                 JOptionPane.showMessageDialog(null, "Select Lecturer");
            }
            
            else if(ss == "Select Session")
            {
                 JOptionPane.showMessageDialog(null, "Select Session");
            }
            else if(tags == "Select Tag")
            {
                 JOptionPane.showMessageDialog(null, "Select Tag");
            }
            
            else if(sr == "Select Room")
            {
                 JOptionPane.showMessageDialog(null, "Select Room");
            }
            else if(tf.equalsIgnoreCase("") || tt.equalsIgnoreCase(""))
            {
                 JOptionPane.showMessageDialog(null, "Select Valid time");
            }
            else
            {
                try
                {
                    DataBase.setData("insert into session_room(lecture1,lecture2,session_,room_,date_, from_t, to_t, tag) values('"+sl1+"','"+sl2+"','"+ss+"','"+sr+"', '"+d+"', '"+tf+"', '"+tt+"', '"+tags+"')");
                    JOptionPane.showMessageDialog(null, "Added Successfully");

                }
                catch (Exception e)
                {
                            JOptionPane.showMessageDialog(null, "Failed To Add Location" + e);
                }
            }
        
      System.out.println("Date" + d.toString());
             
        
    }//GEN-LAST:event_submitActionPerformed

    private void selectRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRoomActionPerformed
         sr = selectRoom.getSelectedItem().toString();
        roomOutLabel.setText(sr);
    }//GEN-LAST:event_selectRoomActionPerformed

    private void selectLecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectLecturerActionPerformed
        sl1 = selectLecturer.getSelectedItem().toString();
        lec1OutLabel.setText(sl1);
        
      var lec = selectLecturer.getSelectedItem();
      if(lec == "Select Lecturer"){     
      }else{
      subLecturer.removeItem(lec);
      }  
    }//GEN-LAST:event_selectLecturerActionPerformed

    private void subLecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subLecturerActionPerformed

        sl2 = subLecturer.getSelectedItem().toString();
        lec2OutLabel.setText(sl2);
    }//GEN-LAST:event_subLecturerActionPerformed

    private void dateChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateChooserMouseClicked
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
//        d = sdf.format(dateChooser.getDate() );
//        dateOutLabel.setText(d); 
        
    }//GEN-LAST:event_dateChooserMouseClicked

    private void timeFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeFromActionPerformed
        tf = timeFrom.getSelectedItem().toString();
        timeFromOut.setText(tf);
    }//GEN-LAST:event_timeFromActionPerformed

    private void timeToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeToActionPerformed
       tt = timeTo.getSelectedItem().toString();
        timeToOut.setText(tt);
    }//GEN-LAST:event_timeToActionPerformed

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear1ActionPerformed

    private void dateSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateSubActionPerformed
        if(d.equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Invalid Date");
        }
        else
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            d = sdf.format(dateChooser.getDate());
            dateOutLabel.setText(d);
            System.out.println("Date" + d.toString());
        }
    }//GEN-LAST:event_dateSubActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JButton clear1;
    private java.awt.Label dLabel;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel dateOutLabel;
    private javax.swing.JButton dateSub;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label l1Label;
    private java.awt.Label l2Label;
    private javax.swing.JLabel lec1OutLabel;
    private javax.swing.JLabel lec2OutLabel;
    private java.awt.Label rLabel;
    private javax.swing.JLabel roomOutLabel;
    private java.awt.Label sLabel;
    private javax.swing.JComboBox<String> selectLecturer;
    private javax.swing.JComboBox<String> selectRoom;
    private javax.swing.JComboBox<String> selectSession;
    private javax.swing.JLabel sessionOutLabel;
    private javax.swing.JComboBox<String> subLecturer;
    private javax.swing.JButton submit;
    private java.awt.Label tLabel;
    private javax.swing.JComboBox<String> tag;
    private javax.swing.JComboBox<String> timeFrom;
    private javax.swing.JLabel timeFromOut;
    private javax.swing.JComboBox<String> timeTo;
    private javax.swing.JLabel timeToOut;
    // End of variables declaration//GEN-END:variables
    
    
        private void clearFileds() {
           selectLecturer.setSelectedIndex(0);
           selectRoom.setSelectedIndex(0);
           selectSession.setSelectedIndex(0);
           timeTo.setSelectedIndex(0);
           timeFrom.setSelectedIndex(0);
           subLecturer.setSelectedIndex(0);
           tag.setSelectedIndex(0);
    }
        
        
   private void fillLecturer1(){
       
        selectLecturer.removeAllItems();
        selectLecturer.addItem("Select Lecturer");
        
        subLecturer.removeAllItems();
        subLecturer.addItem("Select Lecturer");
       
       try{
          
            ResultSet rs = DataBase.getData("SELECT * FROM lecturer");
//           pst = conn.prepareStatement(sql);
//           rs=pst.executeQuery();
           
           while(rs.next()){
               String name = rs.getString("Lecturer_name");
               selectLecturer.addItem(name);
               subLecturer.addItem(name);
               
                       
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
//--------------------------------------Add Tags ----------------------------------------------------------

        tag.removeAllItems();
        tag.addItem("Select Tag");
        
        try{
           ResultSet rs = DataBase.getData("SELECT DISTINCT RelatedTag FROM tag");
          
          
           
           while(rs.next()){
               String name = rs.getString("RelatedTag");
               tag.addItem(name);
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }

//-------------------------------------Session--------------------------------------------------------------


        selectSession.removeAllItems();
        selectSession.addItem("Select Session");
        
        try{
           ResultSet rs = DataBase.getData("SELECT sessioncode FROM session");
          
          
           
           while(rs.next()){
               String name = rs.getString("sessioncode");
               selectSession.addItem(name);
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
        
//------------------------------------Room------------------------------------------------------------------

        selectRoom.removeAllItems();
        selectRoom.addItem("Select Room");
        
        try{
           ResultSet rs = DataBase.getData("SELECT roomName FROM location");
          
          
           
           while(rs.next()){
               String name = rs.getString("roomName");
               selectRoom.addItem(name);
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
       
   }
}
