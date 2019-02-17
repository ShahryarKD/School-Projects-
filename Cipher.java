import java.io.*;
import java.util.*;

public class Cipher
{
  static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  
  public static void main(String[] args)
  {

    String message;
    int cipher;
    String codedMessage;
    
    cipher = Prompt.getInt("Please enter the cipher number.");
    message = getMessage();
    codedMessage = encode(message, cipher);
    saveMessage(codedMessage);
  }
  
  public static String getMessage()
  {
    String message = "";
    Scanner in = Prompt.getInputScanner("Please enter the name of the file which contains your message.");
    
    while(in.hasNextLine())
    {
      message = message.concat(in.nextLine());
    }
    in.close();
    System.out.println("File Loaded.");
    return message;
  }
  
  public static String encode(String message, int cipher)
  {
    String codedMessage="";
    
    while(message.length()>0)
    {
      String currentLetter = message.substring(0,1);
      String nextLetter;
      
      if (alphabet.indexOf(currentLetter) >-1)
      {
        int newLetterValue = alphabet.indexOf(currentLetter)+cipher;
        while (newLetterValue >25)
        {
          newLetterValue -=26;
        }
        nextLetter = alphabet.substring(newLetterValue, newLetterValue+1);
      }
      else
      {
        nextLetter = currentLetter;
      }
      
      codedMessage = codedMessage.concat(nextLetter);
      message = message.substring(1);
    }
    return codedMessage;
  }
  
  public static void saveMessage(String message)
  {
    PrintWriter out = Prompt.getPrintWriter("Please enter the name of the file that you would like to save your coded message to.");
    
    out.println(message);
    out.close();
    System.out.println("File Saved");
  }
}