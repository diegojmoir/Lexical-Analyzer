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

public class Lexical_Analyzer {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		 String path = new File(".").getAbsolutePath();
	     path = path.substring(0, path.length()-1) + "/src" + "/Lexical_Analyzer" + "/Lexer.flex";
	     GenerateJflex(path); 
	     CheckLex(new File("C:/Users/Diego Pérez Moir/Desktop/prueba.txt"));
	}
	
	public static String getFormat(String text, int line, int column, String token) {
		String result = text + "      Line:" + (line+1) + "      Columns:" + (column+1) + "-" + (column+text.length()) +  "      is: " + token;
        return result;
	}

	public static void GenerateJflex(String path) {
		File file = new File(path);
		jflex.Main.generate(file);
	}

	public static void CheckLex(File file) throws FileNotFoundException, IOException{
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
                String pathOut = file.getCanonicalPath().substring(0 , file.getCanonicalPath().length() -3) + "out";
                File out = new File(pathOut); 
                FileOutputStream fos = new FileOutputStream(out);
                OutputStreamWriter osw = new OutputStreamWriter(fos);    
                Writer w = new BufferedWriter(osw);
                
                w.write(result);
                
                w.close();
                return; 
            }
            switch(token){
                case IDENTIFIER:
                    if(text.length() >= 31){
                        result += "ERROR la longitud de la cadena es demasiado larga: " +text.substring(0,30) + 
                                " Linea: " + lineNumber + System.getProperty("line.separator");
                    }else{
                    	
                        result += getFormat(text, lineNumber, colNumber, token + System.getProperty("line.separator"));
                    }                    
                    break; 
                    
                case KEYWORD:
                    result += getFormat(text, lineNumber, colNumber, text.toUpperCase() + System.getProperty("line.separator"));
                    break; 
                case COMMENT:
                    result += getFormat(text, lineNumber, colNumber, token + System.getProperty("line.separator"));
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
                default:
                    result += "ERROR unrecognized char: " + text + "      Line:" + lineNumber + System.getProperty("line.separator");
                    break; 
            }
            
        }
    }
    
     
    

}
