package Lexical_Analyzer;
import java.util.*;

public class Symbols {
	public String identifier;
	public String value; 
	public int scope; 
	public String type;
	public boolean declaration; 
	public String father; 
	

	public Symbols(String _id, int _scope, String _type) { 
		
		
		identifier = _id;
		scope = _scope; 
		type = _type; 
		value = ""; 
		declaration = false;
		
		
	}
}

