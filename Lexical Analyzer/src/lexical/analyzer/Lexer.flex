package LexicalAnalyzer;
import static LexicalAnalyzer.Token.*;

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
decimal = ([0-9])
identifier = ([a-zA-Z])([a-zA-Z_decimal){0,30}
whitespace = \s
singleLineComment = \/\/.+
multiLineComment = (?s)\/\*.*?\*\/
comments = (singleLineComment|multiLineComment)
bool = (true|false)
hexadecimal = 0[xX][decimala-fA-F]+
double = [0-9]+\.[0-9]*([eE][+-]?[0-9]+|)
string = "[^\u2028\u2029\u000A\u000B\u000C\u000D\u0085\"\\]*"
specialCharacters = (\+|\-|\*|\/|%|<|<=|>|>=|=|==|!=|&&|\|\||!|;|,|.|\[\]|\(\)|{}|\[|\]|\(|\)|{|})
integer = (decimal|hexadecimal)
/*Keywords*/

{keyword} = {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return KEYWORD ;}
{identifier} = {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return IDENTIFIER;}
{comments} = {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return COMMENT;}
/*Operators and Characters*/
{specialCharacters} = {token = yytetx(); lineNumber = yyline; colNumber = yycolumn; return SPECIALCHARACTERS;}
/*Constants*/
{bool} = {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return BOOL;}
{double} = {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return DOUBLE;} 
{string} = {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return STRING;}
{integer} = {token = yytext(); lineNumber = yyline; colNumber = yycolumn; return INTEGER;}