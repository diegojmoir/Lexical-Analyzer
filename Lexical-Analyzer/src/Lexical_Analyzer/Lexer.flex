package Lexical_Analyzer;
import static Lexical_Analyzer.Token.*;

%%

%class Lexer
%type Token
%line
%column

%{
    public String token; 
    public int lineNumber; 
    public int colNumber; 
%}

/*Patterns*/
keyword = (void|int|double|bool|string|class|interface|null|this|extends|implements|for|while|if|else|return|break|New|NewArray)
decimal = ([0-9][0-9]*)
identifier = ([a-zA-Z])([a-zA-Z_decimal]*)//{0,30}
singleLineComment = \/\/.+
multiLineComment = "/*" ~"*/"
bool = true|false
hexadecimal = 0[xX][0-9a-fA-F]+
double = [0-9]+\.[0-9]*([eE][+-]?[0-9]+)?
string =  (\"([^(\")(\n)]|\\\")*\") //\".*?\"
punctuationSymbols = (;|,|\.)
error = (#|\´|\'|\_|\:|\$|\¿|\"|&|\||\~|\^|\`)
twoCharOperators = (<=|>=|==|\!=|&&|\|\||\{\}|\[\]|\(\))
oneCharOperators = (\+|\-|\*|\/|%|<|>|=|\!|\[|\]|\(|\)|\{|\})
whiteSpace = \s
doubleError = (\.)([0-9]+)
commentError = (\/\*[^*]*)//|(("/*")~(\n))
%%


/*Constants*/
{bool} {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return BOOL;}
{double} {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return DOUBLE;} 
{string} {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return STRING;}
{decimal} {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return INTEGER;}
{hexadecimal} {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return HEXADECIMAL;}

{keyword} {token = yytext(); lineNumber = yyline;  colNumber = yycolumn; return KEYWORD;}
{identifier} {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return IDENTIFIER;}
{singleLineComment}|{multiLineComment} {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return COMMENT;}

/*Validations*/
{whiteSpace} {}
{error} {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return ERROR;}
/*multilineComment error*/
{commentError} {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return COMMENTERROR; }


/*Punctuation Symbols*/
{punctuationSymbols} {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return PUNCTUATIONSYMBOL;}


/*Operators and Characters*/
{twoCharOperators} {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return TWOCHAR;}
{oneCharOperators} {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return ONECHAR;}

