package Lexical_Analyzer;

import java_cup.runtime.Symbol;
import java.util.*;

%%
%cup
%class Lexer
%line
%column

%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }

%}

/*Patterns*/
decimal = ([1-9][0-9]*|0)
identifier = ([a-zA-Z])([a-zA-Z_decimal]*)//{0,30}
singleLineComment = \/\/.+
multiLineComment = "/*" ~"*/"
bool = true|false
hexadecimal = 0[xX][decimala-fA-F]+
double = [0-9]+\.[0-9]*([eE][+-]?[0-9]+)?
string =  (\"([^(\")(\n)]|\\\")*\") //\".*?\"
error = (#|\´|\'|\_|\:|\$|\¿|\"|&|\||\~|\^|\`)

whiteSpace = \s
doubleError = (\.)([0-9]+)
commentError = (\/\*[^*]*)//|(("/*")~(\n))
%%


punctuationSymbols = (;|,|\.)
/*Punctuation Symbols*/
";" {return new Symbol(sym.SEMICOLON);}
"," {return new Symbol(sym.COMMA);}
"." {return new Symbol(sym.POINT);}

/*One char operators*/
"+" {return new Symbol(sym.PLUS);}
"-" {return new Symbol(sym.MINUS);}
"*" {return new Symbol(sym.MULT);}
"/" {return new Symbol(sym.DIV);}
"%" {return new Symbol(sym.MOD);}
"<" {return new Symbol(sym.LT);}
">" {return new Symbol(sym.GT);}
"=" {return new Symbol(sym.EQUAL);}
"!" {return new Symbol(sym.NEG);}
"[" {return new Symbol(sym.LBRACE);}
"]" {return new Symbol(sym.RBRACE);}
"(" {return new Symbol(sym.LPAREN);}
")" {return new Symbol(sym.RPAREN);}
"{" {return new Symbol(sym.LBRACKET);}
"}" {return new Symbol(sym.RBRACKET);}

/*twoCharOperators*/
"<=" {return new Symbol(sym.LTE);}
">=" {return new Symbol(sym.GTE);}
"==" {return new Symbol(sym.CMP);}
"!=" {return new Symbol(sym.NEQ);}
"&&" {return new Symbol(sym.AND);}
"||" {return new Symbol(sym.OR);}
"[]" {return new Symbol(sym.BRACES);}

/*Reserved Words*/
"void" {return new Symbol(sym.VOID);}
"int" {return new Symbol(sym.INT);}
"double" {return new Symbol(sym.DOUBLE);}
"bool" {return new Symbol(sym.BOOL);}
"string" {return new Symbol(sym.STRING);}
"class" {return new Symbol(sym.CLASS);}
"interface" {return new Symbol(sym.INTERFACE);}
"null" {return new Symbol(sym.NULL);}
"this" {return new Symbol(sym.THIS);}
"extends" {return new Symbol(sym.EXTENDS);}
"implements" {return new Symbol(sym.IMPLEMENTS);}
"for" {return new Symbol(sym.FOR);}
"while" {return new Symbol(sym.WHILE);}
"if" {return new Symbol(sym.IF);}
"else" {return new Symbol(sym.ELSE);}
"return" {return new Symbol(sym.RETURN);}
"break" {return new Symbol(sym.BREAK);}
"New" {return new Symbol(sym.NEW);}
"NewArray" {return new Symbol(sym.NEWARRAY);}
"Print" {return new Symbol(sym.PRINT);}
"ReadInteger" {return new Symbol(sym.READINT);}
"ReadLine" {return new Symbol(sym.READLINE);}
"Malloc" {return new Symbol(sym.MALLOC);}

/*Constants*/
{bool} {return new Symbol(sym.BOOLC, yytext());}
{double} {return new Symbol(sym.DOUBLEC, yytext());} 
{string} {return new Symbol(sym.STRINGC, yytext());}
{decimal}|{hexadecimal} {return new Symbol(sym.INTC, yytext());}
{identifier} {return new Symbol(sym.ID, yytext());}
