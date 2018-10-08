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

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		 String path = new File(".").getAbsolutePath();
		 String cupPath = path.substring(0, path.length()-1)  + "\\Lexical_Analyzer" + "\\parser.cup";
	     path = path.substring(0, path.length()-1)  + "/Lexical_Analyzer" + "/Lexer.flex";
	     
	     GenerateJflex(path); 
	     GenerateCup(cupPath);
	     /*String minicPath = "";
	     boolean flag = true;
	     Scanner sc = new Scanner(System.in); 
	     while(flag) {
		     System.out.println("Insert the path of the file..");
		     minicPath = sc.nextLine();     
		    	
	    	 if(new File(minicPath).exists()) {
	    		 CheckLex(new File(minicPath));
	    		 flag = false; 
	    	 }
	     }*/
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

	/*public static void CheckLex(File file) throws FileNotFoundException, IOException{
        String path = file.getPath();
        boolean flag = true; 
        Reader reader = new BufferedReader(new FileReader(path));
        Lexer lex = new Lexer(reader);
        String result = "";
        while(true){
            Token token = lex.yylex();
            String text = lex.token;
            int lineNumber = lex.lineNumber; 
            int colNumber = lex.colNumber;
            if(token == null){
                result += "EOF";
                //here you should generate the new file
                //String pathOut = file.getCanonicalPath().substring(0 , file.getCanonicalPath().length() -4) + "out";
                String pathT = file.getPath().split(Pattern.quote("."))[0] + ".out";
                File out = new File(pathT); 
                FileOutputStream fos = new FileOutputStream(out);
                OutputStreamWriter osw = new OutputStreamWriter(fos);    
                Writer w = new BufferedWriter(osw);
                
                w.write(result);
                
                w.close();
                System.out.println("The generated file is in:" + pathT);
                return; 
            }
            switch(token){
                case IDENTIFIER:
                    if(text.length() >= 31){
                        result += "ERROR the length of the string it's too long: " +text.substring(0,30) + 
                                " Linea: " + lineNumber + System.getProperty("line.separator");
                    }else{
                    	
                        result += getFormat(text, lineNumber, colNumber, token + System.getProperty("line.separator"));
                    }                    
                    break; 
                    
                case KEYWORD:
                    result += getFormat(text, lineNumber, colNumber, text.toUpperCase() + System.getProperty("line.separator"));
                    break; 
                case COMMENT:
                    //result += getFormat(text, lineNumber, colNumber, token + System.getProperty("line.separator"));
                    break; 
                case TWOCHAR:
                    result += getFormat(text, lineNumber, colNumber, text+ System.getProperty("line.separator"));
                    break;
                case ONECHAR:
                    result += getFormat(text, lineNumber, colNumber, text+ System.getProperty("line.separator"));
                    break; 
                case PUNCTUATIONSYMBOL:
                    result += getFormat(text, lineNumber, colNumber, text+ System.getProperty("line.separator"));
                    break;
                case BOOL:
                    result += getFormat(text, lineNumber, colNumber, (token + "      value:("+text+")"))+ System.getProperty("line.separator");
                    break; 
                case INTEGER:
                    result += getFormat(text, lineNumber, colNumber, (token + "      value:("+text+")"))+ System.getProperty("line.separator");
                    break; 
                case DOUBLE: 
                    result += getFormat(text, lineNumber, colNumber, (token + "      value:("+text+")"))+ System.getProperty("line.separator");
                    break; 
                case STRING: 
                    result += getFormat(text, lineNumber, colNumber, (token + "      value:("+text+")")) + System.getProperty("line.separator");
                    break;
                case DOUBLERROR:
                	result += "ERROR invalid double number: " + text + "      Line:" + lineNumber + System.getProperty("line.separator");
                	break; 
                case COMMENTERROR: 
                	//result += "ERROR invalid multiline comment: " + text + "      Line: " + lineNumber + System.getProperty("line.separator");
                	System.out.println("ERROR invalid multiline comment   Line: " + lineNumber);
                	return;
                default:
                    result += "ERROR invalid char: " + text + "      Line:" + lineNumber + System.getProperty("line.separator");
                    break; 
            }
            
        }
    }*/
    
     
    

}
