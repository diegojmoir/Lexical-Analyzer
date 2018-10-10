package Lexical_Analyzer;

import java_cup.runtime.*;
import java.util.*;

%%
%cup
%class Lexer
%line
%column

%{
	private Symbol symbol(int type, int row, int col){
		return new Symbol(type, row, col, yytext());	
	}
	
    private Symbol symbol(int type, int row, int col, Object value){
        return new Symbol(type, row, col, value);
    }
    
    private void showError(String error, int row, int col){
    	
    		System.out.println("Error Lexico 	                              Linea:" + row + " Columna:" + col + "  " + error);	
    }
    
    private void checkLength(String value, int row, int col){
    	if(value.length() >= 31){
    		System.out.println("Error Lexico Id Posee mas de 31 caracteres    Linea:" + row + " Columna:" + col + "  " + value );
    	}
    }

%}

/*Patterns*/
decimal = ([1-9][0-9]*|0)
identifier = ((_)*)?[a-zA-Z][a-zA-Z0-9]* 
singleLineComment = \/\/.+
multiLineComment = "/*" ~"*/" 
bool = true|false
hexadecimal = 0[xX][decimala-fA-F]+
double = [0-9]+\.[0-9]*([eE][+-]?[0-9]+)?
string =  (\"([^(\")(\n)]|\\\")*\") //\".*?\"

error = (#|\´|\'|\_|\:|\$|\¿|\"|&|\||\~|\^|\`)

whiteSpace = \s
commentError = (\/\*[^*]*)//|(("/*")~(\n))
punctuationSymbols = (;|,|\.)
%%

/*Punctuation Symbols*/
";" {return new Symbol(sym.SEMICOLON, yyline, yycolumn, yytext());}
"," {return new Symbol(sym.COMMA, yyline, yycolumn, yytext());}
"." {return new Symbol(sym.POINT, yyline, yycolumn, yytext());}

/*twoCharOperators*/
"<=" {return new Symbol(sym.LTE, yyline, yycolumn, yytext());}
">=" {return new Symbol(sym.GTE, yyline, yycolumn, yytext());}
"==" {return new Symbol(sym.CMP, yyline, yycolumn, yytext());}
"!=" {return new Symbol(sym.NEQ, yyline, yycolumn, yytext());}
"&&" {return new Symbol(sym.AND, yyline, yycolumn, yytext());}
"||" {return new Symbol(sym.OR, yyline, yycolumn, yytext());}
"[]" {return new Symbol(sym.BRACES, yyline, yycolumn, yytext());}
"()" {return new Symbol(sym.PARENS, yyline, yycolumn, yytext());}

/*One char operators*/
"+" {return new Symbol(sym.PLUS, yyline, yycolumn, yytext());}
"-" {return new Symbol(sym.MINUS, yyline, yycolumn, yytext());}
"*" {return new Symbol(sym.MULT, yyline, yycolumn, yytext());}
"/" {return new Symbol(sym.DIV, yyline, yycolumn, yytext());}
"%" {return new Symbol(sym.MOD, yyline, yycolumn, yytext());}
"<" {return new Symbol(sym.LT, yyline, yycolumn, yytext());}
">" {return new Symbol(sym.GT, yyline, yycolumn, yytext());}
"=" {return new Symbol(sym.EQUAL, yyline, yycolumn, yytext());}
"!" {return new Symbol(sym.NEG, yyline, yycolumn, yytext());}
"[" {return new Symbol(sym.LBRACE, yyline, yycolumn, yytext());}
"]" {return new Symbol(sym.RBRACE, yyline, yycolumn, yytext());}
"(" {return new Symbol(sym.LPAREN, yyline, yycolumn, yytext());}
")" {return new Symbol(sym.RPAREN, yyline, yycolumn, yytext());}
"{" {return new Symbol(sym.LBRACKET, yyline, yycolumn, yytext());}
"}" {return new Symbol(sym.RBRACKET, yyline, yycolumn, yytext());}



/*Reserved Words*/
"void" {return new Symbol(sym.VOID, yyline, yycolumn, yytext());}
"int" {return new Symbol(sym.INT, yyline, yycolumn, yytext());}
"double" {return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());}
"bool" {return new Symbol(sym.BOOL, yyline, yycolumn, yytext());}
"string" {return new Symbol(sym.STRING, yyline, yycolumn, yytext());}
"class" {return new Symbol(sym.CLASS, yyline, yycolumn, yytext());}
"interface" {return new Symbol(sym.INTERFACE, yyline, yycolumn, yytext());}
"null" {return new Symbol(sym.NULL, yyline, yycolumn, yytext());}
"this" {return new Symbol(sym.THIS, yyline, yycolumn, yytext());}
"extends" {return new Symbol(sym.EXTENDS, yyline, yycolumn, yytext());}
"implements" {return new Symbol(sym.IMPLEMENTS, yyline, yycolumn, yytext());}
"for" {return new Symbol(sym.FOR, yyline, yycolumn, yytext());}
"while" {return new Symbol(sym.WHILE, yyline, yycolumn, yytext());}
"if" {return new Symbol(sym.IF, yyline, yycolumn, yytext());}
"else" {return new Symbol(sym.ELSE, yyline, yycolumn, yytext());}
"return" {return new Symbol(sym.RETURN, yyline, yycolumn, yytext());}
"break" {return new Symbol(sym.BREAK, yyline, yycolumn, yytext());}
"New" {return new Symbol(sym.NEW, yyline, yycolumn, yytext());}
"NewArray" {return new Symbol(sym.NEWARRAY, yyline, yycolumn, yytext());}
"Print" {return new Symbol(sym.PRINT, yyline, yycolumn, yytext());}
"ReadInteger" {return new Symbol(sym.READINT, yyline, yycolumn, yytext());}
"ReadLine" {return new Symbol(sym.READLINE, yyline, yycolumn, yytext());}
"Malloc" {return new Symbol(sym.MALLOC, yyline, yycolumn, yytext());}

/*Constants*/
{bool} {return new Symbol(sym.BOOLC, yyline, yycolumn, yytext());}
{double} {return new Symbol(sym.DOUBLEC,  yyline, yycolumn, yytext());} 
{string} {return new Symbol(sym.STRINGC,  yyline, yycolumn, yytext());}
{decimal}|{hexadecimal} {return new Symbol(sym.INTC, yyline, yycolumn, yytext());}
{identifier} { checkLength(yytext(), yyline, yycolumn);
					return new Symbol(sym.ID,  yyline, yycolumn ,yytext());}


[ \t\r]+ {}
[\n]+    {}
{whiteSpace} {}

{singleLineComment}|{multiLineComment} {}
. {showError(yytext(), yyline, yycolumn);}
