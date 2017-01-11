
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samdwise
 */
public class ExerciseAction {
    private int permutation;
    private int combination;
    private  String factorial;
    private int factor;
    private int getN;
    private int getR;
    
     public ExerciseAction(String n, String r){
        //String n = jTextFieldN.getText();
        //String r = jTextFieldR.getText();
        
         getN = Integer.parseInt(n);
         getR = Integer.parseInt(r);
      
       //call action class
        ExerciseFormular exerciseFormular = new ExerciseFormular();
        permutation = exerciseFormular.permutation(getN, getR);
        combination = exerciseFormular.combination(getN, getR);
       //exerciseAction.result.intValue();
       //System.out.println();
        factorial = String.valueOf(exerciseFormular.factorial(getN));
      // System.out.println(factorial);
        factor = exerciseFormular.function(getN, getR);
        
        insertFile();
        //ExerciseAction2 exerciseAction2 = new ExerciseAction2();
        
        //fillTable();
     
     }
     
     public void insertFile(){
         // The name of the file to open.
        String fileName = "maths.txt";

        try {
            // Assume default encoding.
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file.getName(),true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

           //S/N n r nP r nC r n! f(n,r)
              bufferedWriter.write(getN+"\t"+getR+"\t"+permutation+"\t"+combination+"\t"+
                      factorial+"\t"+factor);
              bufferedWriter.newLine();
              bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
    
}
