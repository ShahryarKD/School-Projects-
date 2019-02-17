import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/** SwingFileProgram
  * @author J.Burns
  * Last Modified: 30/11/12
  * 
  * Copies data from one file to another. Both files are selected using a JFileChooser
  */ 
public class SwingFileChooserProgram
{
     //Variable Declaration
     private static JFileChooser chooser = new JFileChooser(); //The Filechooser
     
     //Main Method
     public static void main (String[] args)
     {
          
          //Variable Declaration
          Scanner input = inputScanner();    //The Scanner for inputting from the file
          PrintWriter output = outputFile(); //The Printwriter for outputting to the file
          
          if (input!= null && output != null) //Only runs if both files were selected
          {
               while (input.hasNextLine())  //Copy all data from one file to the other
               {
                    System.out.println("Line");
                    output.println(input.nextLine());
               }
               output.close();
          }
          
     }
     
     /**Create scanner for input from file chosen by user*/
     public static Scanner inputScanner()
     {
          if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) //If file is selected
          {
               System.out.println("You chose " + chooser.getSelectedFile().getPath());
               
               try
               {
                    return(new Scanner(chooser.getSelectedFile()));
               } catch (FileNotFoundException ex) //Should not be needed
               {
                    System.out.println(ex.getMessage());
                    System.exit(1);
               }
          }
          else  //No fle selected (ie Cancel)
          {
               System.out.println("No file chosen.");
          }
          return null;
     }
     
     /**Create PrintWriter for output to a file selected by user*/
     public static PrintWriter outputFile()
     {
          if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) //If file selected
          {
               System.out.println("You chose " + chooser.getSelectedFile().getPath());
               
               try
               {
                    return(new PrintWriter(chooser.getSelectedFile()));
               } catch (FileNotFoundException ex) //Should not be needed
               {
                    System.out.println(ex.getMessage());
                    System.exit(1);
               }
          }
          else //No file selected
          {
               System.out.println("No file chosen.");
          }
          return null;
     }
}
