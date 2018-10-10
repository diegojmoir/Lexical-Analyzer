package Lexical_Analyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lexical_Analyzer {

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		// TODO Auto-generated method stub
		 String path = new File(".").getAbsolutePath();
		 String cupPath = path.substring(0, path.length()-1)  + "\\Lexical_Analyzer" + "\\parser.cup";
	     path = path.substring(0, path.length()-1)  + "/Lexical_Analyzer" + "/Lexer.flex";
 

	     String minicPath = "";
	     boolean flag = true;
	     Scanner sc = new Scanner(System.in); 
	     while(flag) {
		     System.out.println("Insert the path of the file..");
		     minicPath = sc.nextLine();    
		     
	    	 if(new File(minicPath).exists()) {
			     GenerateCup(cupPath);
			     GenerateJflex(path);
	    		 CheckLex(new File(minicPath));
	    		 flag = false; 
	    	 }
	     }
	    
	}
	
	
	public static String getFormat(String text, int line, int column, String token) {
		String result = text + "      Line:" + (line+1) + "      Columns:" + (column+1) + "-" + (column+text.length()) +  "      is: " + token;
        return result;
	}

	public static void GenerateJflex(String path) {
		File file = new File(path);
		jflex.Main.generate(file);
	}
	
	public static void GenerateCup(String path) {

		String pathCup = path.substring(0, path.length() - 11);
		String[] commands = {/* "-expect", "32" ,*/"-destdir", pathCup ,"-parser", "parser", path};
		try {
			java_cup.Main.main(commands);
		}catch(Exception ex) {
			
		}
	}

	public static void CheckLex(File file) throws FileNotFoundException, IOException, Exception{
        String path = file.getPath();
        boolean flag = true; 
        parser p = new parser(new Lexer(new FileReader(path)));
        //p.debug_parse();
        p.parse();
    }
    
     
    

}
