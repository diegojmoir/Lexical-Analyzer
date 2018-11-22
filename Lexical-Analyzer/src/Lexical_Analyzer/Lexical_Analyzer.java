package Lexical_Analyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
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
    		 	String all = joinFiles(minicPath);
    		 	if(!all.equals("ERROR llamadas recursivas")) {
			     GenerateCup(cupPath);
			     GenerateJflex(path);
			     CheckLex(all); 
	    		 //CheckLex(new File(all));
	    		 flag = false; 
    		 	}else {
    		 		return; 
    		 	}
	    	 }
	     }
	    
	}
	
	public static String joinFiles(String path ) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		List<String> everything = new ArrayList<String>();
		List<String> paths = new ArrayList<String>(); 
		try {

		    String line = br.readLine();

		    while (line.contains("include")) {
		    	System.out.println(line.substring(10, line.length()-1)); 
		    	paths.add(line.substring(10, line.length()-1)); 
		        line = br.readLine();
		    }
		    
		} finally {
		    br.close();
		}
		paths.add(path); 
		if(!hasDuplicates(paths)) {			
			for(int i = 0; i < paths.size(); i++) {
				
				BufferedReader brr = new BufferedReader(new FileReader(paths.get(i)));
				try {
					String line = brr.readLine();
					while(line != null){
						everything.add(line); 
						line = brr.readLine(); 
					}
				}finally {
					brr.close(); 
				}
			}
			return writeTable(everything); 
		}
		
		return "ERROR llamadas recursivas"; 

	}
	
	public static boolean hasDuplicates(List<String> file) {
		
		for (int i = 0; i < file.size(); i++) { 
			System.out.println(file.get(i));
			for (int j = i + 1 ; j < file.size(); j++) { 
				
				if (file.get(i).equals(file.get(j))) { 
					// got the duplicate element } } }
					return true; 
				}
			}
		}
		return false; 
			
	}
	
	public static String writeTable(List<String> file) throws IOException{
		String path = new File(".").getAbsolutePath();
		PrintWriter out = new PrintWriter(new FileWriter(path+"\\all.txt"));
		for(int i = 0; i < file.size(); i++){
 
			out.println(file.get(i)); 
		}
		out.close(); 
		return path; 
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

	public static void CheckLex(String file) throws FileNotFoundException, IOException, Exception{
        boolean flag = true; 
        Reader reader = new BufferedReader(new FileReader(file+ "\\all.txt"));
        Lexer lex = new Lexer(reader);
        parser p = new parser(lex);
        
        //p.debug_parse();
        p.parse();
        if((p.numErr + lex.numLErr) == 0) {
        	System.out.println("Archivo sintacticamente correcto :J");
        }
        
        
    }
    
     
    

}
