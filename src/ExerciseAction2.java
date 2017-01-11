/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 */

import java.awt.*;
import java.awt.event.*;	 
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.*;
public class ExerciseAction2 extends JFrame {
    JPanel jPanel = new JPanel(new GridLayout(3, 2));
    JLabel JLabel = new JLabel("Enter n");
    JLabel JLabel1 = new JLabel("Enter r");
    JButton jButton = new JButton("Submit");
    JTextField jTextField = new JTextField(10);
    JTextField jTextField1 = new JTextField(10);
    Container cp = getContentPane();
    int i = 0;
    
    public void setGui(){
	    try {
                //jPanel.add(getTable);
	        setLocation(0, 100);
                setSize(800, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          
                JLabel JLabel3 = new JLabel("");
                JLabel JLabel4 = new JLabel("");
                JLabel JLabel5 = new JLabel("");
                jPanel.add(JLabel);
                jPanel.add(jTextField);
                jPanel.add(JLabel3);
                jPanel.add(JLabel1);
                jPanel.add(jTextField1);
                jPanel.add(JLabel4);
                jPanel.add(JLabel5);
                jPanel.add(jButton);
                jPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
                cp.add(jPanel,BorderLayout.NORTH);
                
                //call the table
	        cp.add(getTable(),BorderLayout.CENTER);
                setVisible(true);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
            
            //handler class
            HandlerClass handler = new HandlerClass();
            jButton.addActionListener(handler);
            //ExerciseAction exerciseAction = ExerciseAction("sam","");
            
	}
    
    
        

    public Component getTable() {
    String[] headers = { "S/No", "n", "r", "nPr", "nCr", "n!", "f(n,r)" };
	    DefaultTableModel dtm = new DefaultTableModel(getDataVector(), new Vector<Object>(Arrays.asList(headers)));
	    return new JScrollPane(new JTable(dtm));
	    }

    private Vector<Vector<Object>> getDataVector() {

	    Scanner s = null;
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    try {
                int count = 0;
	        s = new Scanner(new File("maths.txt"));
	        while (s.hasNextLine()) {
                    count++;
	        String line = s.nextLine();
	   	String[] atoms = line.split("\t");

	            Vector<Object> row = new Vector<Object>();
                    row.add(count);
                    row.add(atoms[0]);
	            row.add(atoms[1]);
                    row.add(atoms[2]);
	            row.add(atoms[3]);
                    row.add(atoms[4]);
                    row.add(atoms[5]);
	            data.add(row);
	        }
	    }
            catch(IOException e) {

	        e.printStackTrace();   
	    }
	    finally {
	        if (s != null) {
	        s.close();
	        }
	    }
	    return data;
	    }
    
    //inner class for actionListener
    private class HandlerClass implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
            String getN = jTextField.getText();
            String getR = jTextField1.getText(); 
            
            //check whether the textfield is empty
            if(getN.equals("") || getR.equals("")){
                JOptionPane.showMessageDialog (null, "TextField cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                //check if the input are numbers or not
                boolean getResult1 = isValidNumber(getN);
                boolean getResult2 = isValidNumber(getR);
                if(getResult1 ==  false || getResult2 == false){
                    JOptionPane.showMessageDialog (null, "Only integer is allowed", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    ExerciseAction exerciseAction = new ExerciseAction(getN,getR);
                    ExerciseAction2 exerciseAction2 = new ExerciseAction2();
                    exerciseAction2.dispose();
                    exerciseAction2.setGui();
                }
             
            
            }
            
        }
       }

    //method to check if input is integer
    public boolean isValidNumber(String number){
        String regex = "^[0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
            
}