/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.ui;
import java.sql.ResultSet;
import java.util.ArrayList;
import timetable.core.*;
import javax.swing.table.DefaultTableModel;
import timetable.data.DBHelper;

/**
 *
 * @author DELL
 */
public class generate extends javax.swing.JFrame {

     ArrayList<String> tmp = new ArrayList<String>();
     ArrayList<Integer> tmp1 = new ArrayList<Integer>();
     ArrayList<String> tmp2 = new ArrayList<String>();
    /**
     * Creates new form generate
     */
    public generate() {
        initComponents();
        read();
        DefaultTableModel a = (DefaultTableModel) jTable1.getModel();
        ArrayList<Room> temp = Room.get();
        course c = new course();
        ArrayList<course> courses = c.get();
        ArrayList<Section> sections = new ArrayList<Section>();
        for(course b:courses){
           Section temmp = new Section(b);
           sections.add(temmp);
        }
        
        String data1[] = new String[temp.size()];
        String slot1[] = new String[temp.size()];
        String slot2[] = new String[temp.size()];
        String slot3[] = new String[temp.size()];
        String slot4[] = new String[temp.size()];
        String slot5[] = new String[temp.size()];
        
        
        
        int i= 0;
        for (Room b:temp) {
             data1[i] = b.RoomNo;
             i = i + 1;
        }
        boolean flag = false;
        for(Section b:sections){
            for(int j = 0; j < b.sections; j++) {
                int random_int = (int)Math.floor(Math.random()*(1-0+1)+0);
                for (int k = 0; k < tmp.size(); k++){
                    if (tmp.get(k).equals(b.temp.name)) {             
                        if (tmp1.get(k) == 1){slot1[tmp1.get(k)] = b.temp.name + "Mon-wed"+ ""+(j+1);}
                        else if (tmp1.get(k) == 2){slot2[tmp1.get(k)] = b.temp.name + "Mon-wed"+ ""+(j+1);}
                        else if (tmp1.get(k) == 3){slot3[tmp1.get(k)] = b.temp.name + "Mon-wed"+ ""+(j+1);}
                        else if (tmp1.get(k) == 4){slot4[tmp1.get(k)] = b.temp.name + "Mon-wed"+ ""+(j+1);}
                        else if (tmp1.get(k) == 5){slot5[tmp1.get(k)] = b.temp.name + "Mon-wed"+ ""+(j+1);}
                        flag = true;
                        //break;
                    }
                }
                System.out.println(b.temp.name + " " + b.sections + " " + random_int + " " + flag);
                if (random_int == 0 && flag == false) {
                    System.out.println(b.temp.name);
                    int random_slot = (int)Math.floor(Math.random()*(5-1+1)+1);
                    if (random_slot == 1){
                        int room = (int) Math.floor(Math.random()*((temp.size())-1+1)+1);
                        slot1[room-1] = b.temp.name + "Mon-wed"+ ""+(j+1);
                    } else if (random_slot == 2){
                        int room = (int) Math.floor(Math.random()*((temp.size())-1+1)+1);
                        slot2[room-1] = b.temp.name + "Mon-wed" + ""+(j+1);
                    } else if (random_slot == 3){
                        int room = (int) Math.floor(Math.random()*((temp.size())-1+1)+1);
                        slot3[room-1] = b.temp.name + "Mon-wed"+ ""+(j+1);
                    } else if (random_slot == 4){
                        int room = (int) Math.floor(Math.random()*((temp.size())-1+1)+1);
                        slot4[room-1] = b.temp.name + "Mon-wed"+ ""+(j+1);
                    } else if (random_slot == 5){
                        int room = (int) Math.floor(Math.random()*((temp.size())-1+1)+1);
                        slot5[room-1] = b.temp.name + "Mon-wed"+ ""+(j+1);
                    }
                    flag = false;
                } else if (random_int == 1 && flag == false) {
                    System.out.println(b.temp.name);
                    int random_slot = (int)Math.floor(Math.random()*(5-1+1)+1);
                    if (random_slot == 1){
                        int room = (int) Math.floor(Math.random()*((temp.size())-1+1)+1);
                        slot1[room-1] = b.temp.name + "tue-thursday"+ ""+(j+1);
                    } else if (random_slot == 2){
                        int room = (int) Math.floor(Math.random()*((temp.size())-1+1)+1);
                        slot2[room-1] = b.temp.name + "tue-thursday" + ""+(j+1);
                    } else if (random_slot == 3){
                        int room = (int) Math.floor(Math.random()*((temp.size())-1+1)+1);
                        slot3[room-1] = b.temp.name + "tue-thursday"+ ""+(j+1);
                    } else if (random_slot == 4){
                        int room = (int) Math.floor(Math.random()*((temp.size())-1+1)+1);
                        slot4[room-1] = b.temp.name + "tue-thursday"+ ""+(j+1);
                    } else if (random_slot == 5){
                        int room = (int) Math.floor(Math.random()*((temp.size())-1+1)+1);
                        slot5[room-1] = b.temp.name + "tue-thursday"+ ""+(j+1);
                    }
                    flag = false;
                }
            }
        }
        a.addColumn("rooms", data1);
        a.addColumn("slot1", slot1);
        a.addColumn("slot2", slot2);
        a.addColumn("slot3", slot3);
        a.addColumn("slot4", slot4);
        a.addColumn("slot5", slot5);
        
        String data[] = {"rooms", "slot1", "slot2", "slot3", "slot4", "slot5" };
        a.setColumnIdentifiers(data);
        a.setColumnCount(6);
    }
    
    public void read() {
       
        
        try{

            String query;
            query = "SELECT * FROM Instructorpre";
            ResultSet rs = DBHelper.executeQuery(query);

            while(rs.next()){

                String name = rs.getString("course_name");
                int slot_pre = rs.getInt("slot_pre");
                String insname = rs.getString("Instructor_id");
                tmp.add(name);
                tmp1.add(slot_pre);
                tmp2.add(insname);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        //return tmp;
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
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new generate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
