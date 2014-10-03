// $ANTLR 3.4 /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g 2014-09-17 14:41:09

package org.apache.pig.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Lexer file for Pig Parser
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class QueryLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ALL=4;
    public static final int AMPERSAND=5;
    public static final int AND=6;
    public static final int ARROBA=7;
    public static final int AS=8;
    public static final int ASC=9;
    public static final int ASSERT=10;
    public static final int BAG=11;
    public static final int BIGDECIMAL=12;
    public static final int BIGDECIMALNUMBER=13;
    public static final int BIGINTEGER=14;
    public static final int BIGINTEGERNUMBER=15;
    public static final int BOOLEAN=16;
    public static final int BY=17;
    public static final int BYTEARRAY=18;
    public static final int CACHE=19;
    public static final int CASE=20;
    public static final int CHARARRAY=21;
    public static final int COGROUP=22;
    public static final int COLON=23;
    public static final int COMMA=24;
    public static final int CROSS=25;
    public static final int CUBE=26;
    public static final int DATETIME=27;
    public static final int DCOLON=28;
    public static final int DEFINE=29;
    public static final int DENSE=30;
    public static final int DESC=31;
    public static final int DIGIT=32;
    public static final int DISTINCT=33;
    public static final int DIV=34;
    public static final int DOLLAR=35;
    public static final int DOLLARVAR=36;
    public static final int DOUBLE=37;
    public static final int DOUBLENUMBER=38;
    public static final int DOUBLE_PERIOD=39;
    public static final int ELSE=40;
    public static final int END=41;
    public static final int EQUAL=42;
    public static final int EXECCOMMAND=43;
    public static final int FALSE=44;
    public static final int FAT_ARROW=45;
    public static final int FILTER=46;
    public static final int FLATTEN=47;
    public static final int FLOAT=48;
    public static final int FLOATINGPOINT=49;
    public static final int FLOATNUMBER=50;
    public static final int FOREACH=51;
    public static final int FULL=52;
    public static final int GENERATE=53;
    public static final int GROUP=54;
    public static final int ID=55;
    public static final int IDENTIFIER=56;
    public static final int IF=57;
    public static final int IMPORT=58;
    public static final int IN=59;
    public static final int INNER=60;
    public static final int INPUT=61;
    public static final int INT=62;
    public static final int INTEGER=63;
    public static final int INTO=64;
    public static final int INVOKE=65;
    public static final int IS=66;
    public static final int JOIN=67;
    public static final int LEFT=68;
    public static final int LEFT_BRACKET=69;
    public static final int LEFT_CURLY=70;
    public static final int LEFT_PAREN=71;
    public static final int LETTER=72;
    public static final int LIMIT=73;
    public static final int LOAD=74;
    public static final int LONG=75;
    public static final int LONGINTEGER=76;
    public static final int MAP=77;
    public static final int MAPREDUCE=78;
    public static final int MINUS=79;
    public static final int ML_COMMENT=80;
    public static final int MULTILINE_QUOTEDSTRING=81;
    public static final int NOT=82;
    public static final int NULL=83;
    public static final int NUM_OP_EQ=84;
    public static final int NUM_OP_GT=85;
    public static final int NUM_OP_GTE=86;
    public static final int NUM_OP_LT=87;
    public static final int NUM_OP_LTE=88;
    public static final int NUM_OP_NE=89;
    public static final int ONSCHEMA=90;
    public static final int OR=91;
    public static final int ORDER=92;
    public static final int OTHERWISE=93;
    public static final int OUTER=94;
    public static final int OUTPUT=95;
    public static final int PARALLEL=96;
    public static final int PARTITION=97;
    public static final int PERCENT=98;
    public static final int PERIOD=99;
    public static final int PIVOT=100;
    public static final int PLUS=101;
    public static final int POUND=102;
    public static final int QMARK=103;
    public static final int QUOTEDSTRING=104;
    public static final int RANK=105;
    public static final int REGISTER=106;
    public static final int RETURNS=107;
    public static final int RIGHT=108;
    public static final int RIGHT_BRACKET=109;
    public static final int RIGHT_CURLY=110;
    public static final int RIGHT_PAREN=111;
    public static final int ROLLUP=112;
    public static final int SAMPLE=113;
    public static final int SEMI_COLON=114;
    public static final int SHIP=115;
    public static final int SL_COMMENT=116;
    public static final int SPECIALCHAR=117;
    public static final int SPLIT=118;
    public static final int STAR=119;
    public static final int STDERROR=120;
    public static final int STDIN=121;
    public static final int STDOUT=122;
    public static final int STORE=123;
    public static final int STREAM=124;
    public static final int STR_OP_EQ=125;
    public static final int STR_OP_GT=126;
    public static final int STR_OP_GTE=127;
    public static final int STR_OP_LT=128;
    public static final int STR_OP_LTE=129;
    public static final int STR_OP_MATCHES=130;
    public static final int STR_OP_NE=131;
    public static final int THEN=132;
    public static final int THROUGH=133;
    public static final int TRUE=134;
    public static final int TUPLE=135;
    public static final int UNION=136;
    public static final int USING=137;
    public static final int VOID=138;
    public static final int WHEN=139;
    public static final int WS=140;


    @Override
    public void reportError(RecognitionException e) {
        super.reportError( e );

        // The method of this signature doesn't permit checked exception. Here we have to
        // throw a unchecked execption in order to stop at the first error.
        // For more information, visit http://www.antlr.org/wiki/pages/viewpage.action?pageId=5341217.
        StringBuilder sb = new StringBuilder();
        sb.append( getErrorHeader( e ) ).append( " " );
        sb.append( getErrorMessage( e, getTokenNames() ) );
        throw new RuntimeException( sb.toString() );
    }

    @Override
    public String getErrorMessage(RecognitionException e, String[] tokenNames ) {
        if( e instanceof NoViableAltException ) {
            return "Unexpected character " + getCharErrorDisplay( e.c );
        } else {
            return super.getErrorMessage( e, tokenNames );
        }
    }

    @Override
    public String getErrorHeader(RecognitionException ex) {
    	return QueryParserUtils.generateErrorHeader( ex, this.getSourceName() );
    }



    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public QueryLexer() {} 
    public QueryLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public QueryLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g"; }

    // $ANTLR start "VOID"
    public final void mVOID() throws RecognitionException {
        try {
            int _type = VOID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:60:9: ( 'VOID' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:60:11: 'VOID'
            {
            match("VOID"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VOID"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:63:9: ( 'NULL' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:63:11: 'NULL'
            {
            match("NULL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "IMPORT"
    public final void mIMPORT() throws RecognitionException {
        try {
            int _type = IMPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:66:9: ( 'IMPORT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:66:11: 'IMPORT'
            {
            match("IMPORT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IMPORT"

    // $ANTLR start "REGISTER"
    public final void mREGISTER() throws RecognitionException {
        try {
            int _type = REGISTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:69:10: ( 'REGISTER' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:69:12: 'REGISTER'
            {
            match("REGISTER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REGISTER"

    // $ANTLR start "RETURNS"
    public final void mRETURNS() throws RecognitionException {
        try {
            int _type = RETURNS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:72:9: ( 'RETURNS' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:72:11: 'RETURNS'
            {
            match("RETURNS"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RETURNS"

    // $ANTLR start "DEFINE"
    public final void mDEFINE() throws RecognitionException {
        try {
            int _type = DEFINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:75:8: ( 'DEFINE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:75:10: 'DEFINE'
            {
            match("DEFINE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEFINE"

    // $ANTLR start "LOAD"
    public final void mLOAD() throws RecognitionException {
        try {
            int _type = LOAD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:78:8: ( 'LOAD' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:78:10: 'LOAD'
            {
            match("LOAD"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOAD"

    // $ANTLR start "FILTER"
    public final void mFILTER() throws RecognitionException {
        try {
            int _type = FILTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:81:8: ( 'FILTER' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:81:10: 'FILTER'
            {
            match("FILTER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FILTER"

    // $ANTLR start "FOREACH"
    public final void mFOREACH() throws RecognitionException {
        try {
            int _type = FOREACH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:84:9: ( 'FOREACH' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:84:11: 'FOREACH'
            {
            match("FOREACH"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FOREACH"

    // $ANTLR start "ORDER"
    public final void mORDER() throws RecognitionException {
        try {
            int _type = ORDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:87:9: ( 'ORDER' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:87:12: 'ORDER'
            {
            match("ORDER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ORDER"

    // $ANTLR start "RANK"
    public final void mRANK() throws RecognitionException {
        try {
            int _type = RANK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:90:8: ( 'RANK' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:90:11: 'RANK'
            {
            match("RANK"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RANK"

    // $ANTLR start "DENSE"
    public final void mDENSE() throws RecognitionException {
        try {
            int _type = DENSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:93:9: ( 'DENSE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:93:12: 'DENSE'
            {
            match("DENSE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DENSE"

    // $ANTLR start "CUBE"
    public final void mCUBE() throws RecognitionException {
        try {
            int _type = CUBE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:96:9: ( 'CUBE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:96:11: 'CUBE'
            {
            match("CUBE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CUBE"

    // $ANTLR start "ROLLUP"
    public final void mROLLUP() throws RecognitionException {
        try {
            int _type = ROLLUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:99:8: ( 'ROLLUP' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:99:10: 'ROLLUP'
            {
            match("ROLLUP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ROLLUP"

    // $ANTLR start "INVOKE"
    public final void mINVOKE() throws RecognitionException {
        try {
            int _type = INVOKE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:102:9: ( 'INVOKE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:102:11: 'INVOKE'
            {
            match("INVOKE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INVOKE"

    // $ANTLR start "DISTINCT"
    public final void mDISTINCT() throws RecognitionException {
        try {
            int _type = DISTINCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:105:10: ( 'DISTINCT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:105:12: 'DISTINCT'
            {
            match("DISTINCT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DISTINCT"

    // $ANTLR start "COGROUP"
    public final void mCOGROUP() throws RecognitionException {
        try {
            int _type = COGROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:108:9: ( 'COGROUP' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:108:11: 'COGROUP'
            {
            match("COGROUP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COGROUP"

    // $ANTLR start "JOIN"
    public final void mJOIN() throws RecognitionException {
        try {
            int _type = JOIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:111:6: ( 'JOIN' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:111:8: 'JOIN'
            {
            match("JOIN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "JOIN"

    // $ANTLR start "CROSS"
    public final void mCROSS() throws RecognitionException {
        try {
            int _type = CROSS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:114:7: ( 'CROSS' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:114:9: 'CROSS'
            {
            match("CROSS"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CROSS"

    // $ANTLR start "UNION"
    public final void mUNION() throws RecognitionException {
        try {
            int _type = UNION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:117:7: ( 'UNION' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:117:9: 'UNION'
            {
            match("UNION"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNION"

    // $ANTLR start "SPLIT"
    public final void mSPLIT() throws RecognitionException {
        try {
            int _type = SPLIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:120:7: ( 'SPLIT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:120:9: 'SPLIT'
            {
            match("SPLIT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPLIT"

    // $ANTLR start "INTO"
    public final void mINTO() throws RecognitionException {
        try {
            int _type = INTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:123:6: ( 'INTO' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:123:8: 'INTO'
            {
            match("INTO"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTO"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:126:4: ( 'IF' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:126:6: 'IF'
            {
            match("IF"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "OTHERWISE"
    public final void mOTHERWISE() throws RecognitionException {
        try {
            int _type = OTHERWISE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:129:11: ( 'OTHERWISE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:129:13: 'OTHERWISE'
            {
            match("OTHERWISE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OTHERWISE"

    // $ANTLR start "ALL"
    public final void mALL() throws RecognitionException {
        try {
            int _type = ALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:132:5: ( 'ALL' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:132:7: 'ALL'
            {
            match("ALL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ALL"

    // $ANTLR start "AS"
    public final void mAS() throws RecognitionException {
        try {
            int _type = AS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:135:4: ( 'AS' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:135:6: 'AS'
            {
            match("AS"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AS"

    // $ANTLR start "BY"
    public final void mBY() throws RecognitionException {
        try {
            int _type = BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:138:4: ( 'BY' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:138:6: 'BY'
            {
            match("BY"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BY"

    // $ANTLR start "USING"
    public final void mUSING() throws RecognitionException {
        try {
            int _type = USING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:141:7: ( 'USING' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:141:9: 'USING'
            {
            match("USING"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "USING"

    // $ANTLR start "INNER"
    public final void mINNER() throws RecognitionException {
        try {
            int _type = INNER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:144:7: ( 'INNER' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:144:9: 'INNER'
            {
            match("INNER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INNER"

    // $ANTLR start "OUTER"
    public final void mOUTER() throws RecognitionException {
        try {
            int _type = OUTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:147:7: ( 'OUTER' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:147:9: 'OUTER'
            {
            match("OUTER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OUTER"

    // $ANTLR start "ONSCHEMA"
    public final void mONSCHEMA() throws RecognitionException {
        try {
            int _type = ONSCHEMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:150:10: ( 'ONSCHEMA' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:150:12: 'ONSCHEMA'
            {
            match("ONSCHEMA"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ONSCHEMA"

    // $ANTLR start "PARALLEL"
    public final void mPARALLEL() throws RecognitionException {
        try {
            int _type = PARALLEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:153:10: ( 'PARALLEL' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:153:12: 'PARALLEL'
            {
            match("PARALLEL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARALLEL"

    // $ANTLR start "PIVOT"
    public final void mPIVOT() throws RecognitionException {
        try {
            int _type = PIVOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:156:7: ( 'PIVOT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:156:9: 'PIVOT'
            {
            match("PIVOT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PIVOT"

    // $ANTLR start "PARTITION"
    public final void mPARTITION() throws RecognitionException {
        try {
            int _type = PARTITION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:159:11: ( 'PARTITION' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:159:13: 'PARTITION'
            {
            match("PARTITION"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARTITION"

    // $ANTLR start "GROUP"
    public final void mGROUP() throws RecognitionException {
        try {
            int _type = GROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:162:7: ( 'GROUP' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:162:9: 'GROUP'
            {
            match("GROUP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GROUP"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:165:5: ( 'AND' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:165:7: 'AND'
            {
            match("AND"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:168:4: ( 'OR' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:168:6: 'OR'
            {
            match("OR"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:171:5: ( 'NOT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:171:7: 'NOT'
            {
            match("NOT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "GENERATE"
    public final void mGENERATE() throws RecognitionException {
        try {
            int _type = GENERATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:174:10: ( 'GENERATE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:174:12: 'GENERATE'
            {
            match("GENERATE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GENERATE"

    // $ANTLR start "FLATTEN"
    public final void mFLATTEN() throws RecognitionException {
        try {
            int _type = FLATTEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:177:9: ( 'FLATTEN' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:177:11: 'FLATTEN'
            {
            match("FLATTEN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLATTEN"

    // $ANTLR start "ASC"
    public final void mASC() throws RecognitionException {
        try {
            int _type = ASC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:180:5: ( 'ASC' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:180:7: 'ASC'
            {
            match("ASC"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASC"

    // $ANTLR start "DESC"
    public final void mDESC() throws RecognitionException {
        try {
            int _type = DESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:183:6: ( 'DESC' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:183:8: 'DESC'
            {
            match("DESC"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DESC"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:186:9: ( 'BOOLEAN' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:186:11: 'BOOLEAN'
            {
            match("BOOLEAN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:189:5: ( 'INT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:189:7: 'INT'
            {
            match("INT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "LONG"
    public final void mLONG() throws RecognitionException {
        try {
            int _type = LONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:192:6: ( 'LONG' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:192:8: 'LONG'
            {
            match("LONG"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LONG"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:195:7: ( 'FLOAT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:195:9: 'FLOAT'
            {
            match("FLOAT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "BIGDECIMAL"
    public final void mBIGDECIMAL() throws RecognitionException {
        try {
            int _type = BIGDECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:198:12: ( 'BIGDECIMAL' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:198:14: 'BIGDECIMAL'
            {
            match("BIGDECIMAL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BIGDECIMAL"

    // $ANTLR start "BIGINTEGER"
    public final void mBIGINTEGER() throws RecognitionException {
        try {
            int _type = BIGINTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:201:12: ( 'BIGINTEGER' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:201:14: 'BIGINTEGER'
            {
            match("BIGINTEGER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BIGINTEGER"

    // $ANTLR start "DOUBLE"
    public final void mDOUBLE() throws RecognitionException {
        try {
            int _type = DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:204:8: ( 'DOUBLE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:204:10: 'DOUBLE'
            {
            match("DOUBLE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLE"

    // $ANTLR start "DATETIME"
    public final void mDATETIME() throws RecognitionException {
        try {
            int _type = DATETIME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:207:10: ( 'DATETIME' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:207:12: 'DATETIME'
            {
            match("DATETIME"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DATETIME"

    // $ANTLR start "CHARARRAY"
    public final void mCHARARRAY() throws RecognitionException {
        try {
            int _type = CHARARRAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:210:11: ( 'CHARARRAY' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:210:13: 'CHARARRAY'
            {
            match("CHARARRAY"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHARARRAY"

    // $ANTLR start "BYTEARRAY"
    public final void mBYTEARRAY() throws RecognitionException {
        try {
            int _type = BYTEARRAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:213:11: ( 'BYTEARRAY' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:213:13: 'BYTEARRAY'
            {
            match("BYTEARRAY"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BYTEARRAY"

    // $ANTLR start "BAG"
    public final void mBAG() throws RecognitionException {
        try {
            int _type = BAG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:216:5: ( 'BAG' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:216:7: 'BAG'
            {
            match("BAG"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BAG"

    // $ANTLR start "TUPLE"
    public final void mTUPLE() throws RecognitionException {
        try {
            int _type = TUPLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:219:7: ( 'TUPLE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:219:9: 'TUPLE'
            {
            match("TUPLE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TUPLE"

    // $ANTLR start "MAP"
    public final void mMAP() throws RecognitionException {
        try {
            int _type = MAP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:222:5: ( 'MAP' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:222:7: 'MAP'
            {
            match("MAP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MAP"

    // $ANTLR start "IS"
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:225:4: ( 'IS' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:225:6: 'IS'
            {
            match("IS"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IS"

    // $ANTLR start "STREAM"
    public final void mSTREAM() throws RecognitionException {
        try {
            int _type = STREAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:228:8: ( 'STREAM' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:228:10: 'STREAM'
            {
            match("STREAM"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STREAM"

    // $ANTLR start "THROUGH"
    public final void mTHROUGH() throws RecognitionException {
        try {
            int _type = THROUGH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:231:9: ( 'THROUGH' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:231:11: 'THROUGH'
            {
            match("THROUGH"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THROUGH"

    // $ANTLR start "STORE"
    public final void mSTORE() throws RecognitionException {
        try {
            int _type = STORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:234:7: ( 'STORE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:234:9: 'STORE'
            {
            match("STORE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STORE"

    // $ANTLR start "ASSERT"
    public final void mASSERT() throws RecognitionException {
        try {
            int _type = ASSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:237:8: ( 'ASSERT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:237:10: 'ASSERT'
            {
            match("ASSERT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSERT"

    // $ANTLR start "MAPREDUCE"
    public final void mMAPREDUCE() throws RecognitionException {
        try {
            int _type = MAPREDUCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:240:11: ( 'MAPREDUCE' | 'NATIVE' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='M') ) {
                alt1=1;
            }
            else if ( (LA1_0=='N') ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:240:13: 'MAPREDUCE'
                    {
                    match("MAPREDUCE"); if (state.failed) return ;



                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:240:27: 'NATIVE'
                    {
                    match("NATIVE"); if (state.failed) return ;



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MAPREDUCE"

    // $ANTLR start "SHIP"
    public final void mSHIP() throws RecognitionException {
        try {
            int _type = SHIP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:243:6: ( 'SHIP' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:243:8: 'SHIP'
            {
            match("SHIP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHIP"

    // $ANTLR start "CACHE"
    public final void mCACHE() throws RecognitionException {
        try {
            int _type = CACHE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:246:7: ( 'CACHE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:246:9: 'CACHE'
            {
            match("CACHE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CACHE"

    // $ANTLR start "INPUT"
    public final void mINPUT() throws RecognitionException {
        try {
            int _type = INPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:249:7: ( 'INPUT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:249:9: 'INPUT'
            {
            match("INPUT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INPUT"

    // $ANTLR start "OUTPUT"
    public final void mOUTPUT() throws RecognitionException {
        try {
            int _type = OUTPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:252:8: ( 'OUTPUT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:252:10: 'OUTPUT'
            {
            match("OUTPUT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OUTPUT"

    // $ANTLR start "STDERROR"
    public final void mSTDERROR() throws RecognitionException {
        try {
            int _type = STDERROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:255:10: ( 'STDERR' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:255:12: 'STDERR'
            {
            match("STDERR"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STDERROR"

    // $ANTLR start "STDIN"
    public final void mSTDIN() throws RecognitionException {
        try {
            int _type = STDIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:258:7: ( 'STDIN' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:258:9: 'STDIN'
            {
            match("STDIN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STDIN"

    // $ANTLR start "STDOUT"
    public final void mSTDOUT() throws RecognitionException {
        try {
            int _type = STDOUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:261:8: ( 'STDOUT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:261:10: 'STDOUT'
            {
            match("STDOUT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STDOUT"

    // $ANTLR start "LIMIT"
    public final void mLIMIT() throws RecognitionException {
        try {
            int _type = LIMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:264:7: ( 'LIMIT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:264:9: 'LIMIT'
            {
            match("LIMIT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LIMIT"

    // $ANTLR start "SAMPLE"
    public final void mSAMPLE() throws RecognitionException {
        try {
            int _type = SAMPLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:267:8: ( 'SAMPLE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:267:10: 'SAMPLE'
            {
            match("SAMPLE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SAMPLE"

    // $ANTLR start "LEFT"
    public final void mLEFT() throws RecognitionException {
        try {
            int _type = LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:270:6: ( 'LEFT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:270:8: 'LEFT'
            {
            match("LEFT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT"

    // $ANTLR start "RIGHT"
    public final void mRIGHT() throws RecognitionException {
        try {
            int _type = RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:273:7: ( 'RIGHT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:273:9: 'RIGHT'
            {
            match("RIGHT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT"

    // $ANTLR start "FULL"
    public final void mFULL() throws RecognitionException {
        try {
            int _type = FULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:276:6: ( 'FULL' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:276:8: 'FULL'
            {
            match("FULL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FULL"

    // $ANTLR start "CASE"
    public final void mCASE() throws RecognitionException {
        try {
            int _type = CASE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:279:6: ( 'CASE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:279:8: 'CASE'
            {
            match("CASE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CASE"

    // $ANTLR start "WHEN"
    public final void mWHEN() throws RecognitionException {
        try {
            int _type = WHEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:282:6: ( 'WHEN' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:282:8: 'WHEN'
            {
            match("WHEN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHEN"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:285:6: ( 'THEN' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:285:8: 'THEN'
            {
            match("THEN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:288:6: ( 'ELSE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:288:8: 'ELSE'
            {
            match("ELSE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:291:5: ( 'END' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:291:7: 'END'
            {
            match("END"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "STR_OP_EQ"
    public final void mSTR_OP_EQ() throws RecognitionException {
        try {
            int _type = STR_OP_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:294:11: ( 'EQ' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:294:13: 'EQ'
            {
            match("EQ"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_EQ"

    // $ANTLR start "STR_OP_GT"
    public final void mSTR_OP_GT() throws RecognitionException {
        try {
            int _type = STR_OP_GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:297:11: ( 'GT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:297:13: 'GT'
            {
            match("GT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_GT"

    // $ANTLR start "STR_OP_LT"
    public final void mSTR_OP_LT() throws RecognitionException {
        try {
            int _type = STR_OP_LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:300:11: ( 'LT' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:300:13: 'LT'
            {
            match("LT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_LT"

    // $ANTLR start "STR_OP_GTE"
    public final void mSTR_OP_GTE() throws RecognitionException {
        try {
            int _type = STR_OP_GTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:303:12: ( 'GTE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:303:14: 'GTE'
            {
            match("GTE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_GTE"

    // $ANTLR start "STR_OP_LTE"
    public final void mSTR_OP_LTE() throws RecognitionException {
        try {
            int _type = STR_OP_LTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:306:12: ( 'LTE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:306:14: 'LTE'
            {
            match("LTE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_LTE"

    // $ANTLR start "STR_OP_NE"
    public final void mSTR_OP_NE() throws RecognitionException {
        try {
            int _type = STR_OP_NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:309:11: ( 'NEQ' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:309:13: 'NEQ'
            {
            match("NEQ"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_NE"

    // $ANTLR start "STR_OP_MATCHES"
    public final void mSTR_OP_MATCHES() throws RecognitionException {
        try {
            int _type = STR_OP_MATCHES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:312:16: ( 'MATCHES' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:312:18: 'MATCHES'
            {
            match("MATCHES"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_MATCHES"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:315:4: ( 'IN' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:315:6: 'IN'
            {
            match("IN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:318:6: ( 'TRUE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:318:8: 'TRUE'
            {
            match("TRUE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:321:7: ( 'FALSE' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:321:9: 'FALSE'
            {
            match("FALSE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "NUM_OP_EQ"
    public final void mNUM_OP_EQ() throws RecognitionException {
        try {
            int _type = NUM_OP_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:324:11: ( '==' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:324:13: '=='
            {
            match("=="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_EQ"

    // $ANTLR start "NUM_OP_LT"
    public final void mNUM_OP_LT() throws RecognitionException {
        try {
            int _type = NUM_OP_LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:327:11: ( '<' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:327:13: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_LT"

    // $ANTLR start "NUM_OP_LTE"
    public final void mNUM_OP_LTE() throws RecognitionException {
        try {
            int _type = NUM_OP_LTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:330:12: ( '<=' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:330:14: '<='
            {
            match("<="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_LTE"

    // $ANTLR start "NUM_OP_GT"
    public final void mNUM_OP_GT() throws RecognitionException {
        try {
            int _type = NUM_OP_GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:333:11: ( '>' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:333:13: '>'
            {
            match('>'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_GT"

    // $ANTLR start "NUM_OP_GTE"
    public final void mNUM_OP_GTE() throws RecognitionException {
        try {
            int _type = NUM_OP_GTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:336:12: ( '>=' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:336:14: '>='
            {
            match(">="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_GTE"

    // $ANTLR start "NUM_OP_NE"
    public final void mNUM_OP_NE() throws RecognitionException {
        try {
            int _type = NUM_OP_NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:339:11: ( '!=' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:339:13: '!='
            {
            match("!="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_NE"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:342:16: ( '0' .. '9' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:345:17: ( 'A' .. 'Z' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "SPECIALCHAR"
    public final void mSPECIALCHAR() throws RecognitionException {
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:348:22: ( '_' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:348:24: '_'
            {
            match('_'); if (state.failed) return ;

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPECIALCHAR"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:351:12: ( LETTER ( DIGIT | LETTER | SPECIALCHAR )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:351:14: LETTER ( DIGIT | LETTER | SPECIALCHAR )*
            {
            mLETTER(); if (state.failed) return ;


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:351:21: ( DIGIT | LETTER | SPECIALCHAR )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "DCOLON"
    public final void mDCOLON() throws RecognitionException {
        try {
            int _type = DCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:354:8: ( '::' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:354:10: '::'
            {
            match("::"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DCOLON"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:362:7: ( ( ID DCOLON )=> ( ID DCOLON IDENTIFIER ) | ID )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:362:9: ( ID DCOLON )=> ( ID DCOLON IDENTIFIER )
                    {
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:362:26: ( ID DCOLON IDENTIFIER )
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:362:28: ID DCOLON IDENTIFIER
                    {
                    mID(); if (state.failed) return ;


                    mDCOLON(); if (state.failed) return ;


                    mIDENTIFIER(); if (state.failed) return ;


                    }


                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:362:53: ID
                    {
                    mID(); if (state.failed) return ;


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
            if ( state.backtracking==0 ) {
                    if("null".equalsIgnoreCase(getText())){
                        state.type = NULL;
                    }
                }
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "FLOATINGPOINT"
    public final void mFLOATINGPOINT() throws RecognitionException {
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:365:24: ( INTEGER ( PERIOD INTEGER )? | PERIOD INTEGER )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='.') ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:365:26: INTEGER ( PERIOD INTEGER )?
                    {
                    mINTEGER(); if (state.failed) return ;


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:365:34: ( PERIOD INTEGER )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='.') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:365:36: PERIOD INTEGER
                            {
                            mPERIOD(); if (state.failed) return ;


                            mINTEGER(); if (state.failed) return ;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:365:56: PERIOD INTEGER
                    {
                    mPERIOD(); if (state.failed) return ;


                    mINTEGER(); if (state.failed) return ;


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOATINGPOINT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:368:8: ( ( DIGIT )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:368:10: ( DIGIT )+
            {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:368:10: ( DIGIT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "LONGINTEGER"
    public final void mLONGINTEGER() throws RecognitionException {
        try {
            int _type = LONGINTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:371:12: ( INTEGER 'L' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:371:14: INTEGER 'L'
            {
            mINTEGER(); if (state.failed) return ;


            match('L'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LONGINTEGER"

    // $ANTLR start "DOLLARVAR"
    public final void mDOLLARVAR() throws RecognitionException {
        try {
            int _type = DOLLARVAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:374:11: ( DOLLAR INTEGER )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:374:13: DOLLAR INTEGER
            {
            mDOLLAR(); if (state.failed) return ;


            mINTEGER(); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOLLARVAR"

    // $ANTLR start "DOUBLENUMBER"
    public final void mDOUBLENUMBER() throws RecognitionException {
        try {
            int _type = DOUBLENUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:377:14: ( FLOATINGPOINT ( 'E' ( MINUS | PLUS )? INTEGER )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:377:16: FLOATINGPOINT ( 'E' ( MINUS | PLUS )? INTEGER )?
            {
            mFLOATINGPOINT(); if (state.failed) return ;


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:377:30: ( 'E' ( MINUS | PLUS )? INTEGER )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='E') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:377:32: 'E' ( MINUS | PLUS )? INTEGER
                    {
                    match('E'); if (state.failed) return ;

                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:377:36: ( MINUS | PLUS )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='+'||LA7_0=='-') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    mINTEGER(); if (state.failed) return ;


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLENUMBER"

    // $ANTLR start "BIGDECIMALNUMBER"
    public final void mBIGDECIMALNUMBER() throws RecognitionException {
        try {
            int _type = BIGDECIMALNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:380:18: ( DOUBLENUMBER 'BD' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:380:20: DOUBLENUMBER 'BD'
            {
            mDOUBLENUMBER(); if (state.failed) return ;


            match("BD"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BIGDECIMALNUMBER"

    // $ANTLR start "BIGINTEGERNUMBER"
    public final void mBIGINTEGERNUMBER() throws RecognitionException {
        try {
            int _type = BIGINTEGERNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:383:18: ( INTEGER 'BI' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:383:20: INTEGER 'BI'
            {
            mINTEGER(); if (state.failed) return ;


            match("BI"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BIGINTEGERNUMBER"

    // $ANTLR start "FLOATNUMBER"
    public final void mFLOATNUMBER() throws RecognitionException {
        try {
            int _type = FLOATNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:386:13: ( DOUBLENUMBER 'F' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:386:15: DOUBLENUMBER 'F'
            {
            mDOUBLENUMBER(); if (state.failed) return ;


            match('F'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOATNUMBER"

    // $ANTLR start "QUOTEDSTRING"
    public final void mQUOTEDSTRING() throws RecognitionException {
        try {
            int _type = QUOTEDSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:389:14: ( '\\'' ( (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\'' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:389:17: '\\'' ( (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\''
            {
            match('\''); if (state.failed) return ;

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:389:22: ( (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )*
            loop9:
            do {
                int alt9=4;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '\u0000' && LA9_0 <= '\t')||(LA9_0 >= '\u000B' && LA9_0 <= '\f')||(LA9_0 >= '\u000E' && LA9_0 <= '&')||(LA9_0 >= '(' && LA9_0 <= '[')||(LA9_0 >= ']' && LA9_0 <= '\uFFFF')) ) {
                    alt9=1;
                }
                else if ( (LA9_0=='\\') ) {
                    int LA9_3 = input.LA(2);

                    if ( (LA9_3=='\''||LA9_3=='B'||LA9_3=='F'||LA9_3=='N'||LA9_3=='R'||LA9_3=='T'||LA9_3=='\\') ) {
                        alt9=2;
                    }
                    else if ( (LA9_3=='U') ) {
                        alt9=3;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:389:26: (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:390:26: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) )
            	    {
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:390:26: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) )
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:390:28: '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) )
            	    {
            	    match('\\'); if (state.failed) return ;

            	    if ( input.LA(1)=='\''||input.LA(1)=='B'||input.LA(1)=='F'||input.LA(1)=='N'||input.LA(1)=='R'||input.LA(1)=='T'||input.LA(1)=='\\' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:391:26: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
            	    {
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:391:26: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:391:28: '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' )
            	    {
            	    match("\\U"); if (state.failed) return ;



            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTEDSTRING"

    // $ANTLR start "MULTILINE_QUOTEDSTRING"
    public final void mMULTILINE_QUOTEDSTRING() throws RecognitionException {
        try {
            int _type = MULTILINE_QUOTEDSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:399:24: ( '\\'' ( (~ ( '\\'' | '\\\\' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\'' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:399:27: '\\'' ( (~ ( '\\'' | '\\\\' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\''
            {
            match('\''); if (state.failed) return ;

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:399:32: ( (~ ( '\\'' | '\\\\' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )*
            loop10:
            do {
                int alt10=4;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '\u0000' && LA10_0 <= '&')||(LA10_0 >= '(' && LA10_0 <= '[')||(LA10_0 >= ']' && LA10_0 <= '\uFFFF')) ) {
                    alt10=1;
                }
                else if ( (LA10_0=='\\') ) {
                    int LA10_3 = input.LA(2);

                    if ( (LA10_3=='\''||LA10_3=='B'||LA10_3=='F'||LA10_3=='N'||LA10_3=='R'||LA10_3=='T'||LA10_3=='\\'||LA10_3=='n'||LA10_3=='r') ) {
                        alt10=2;
                    }
                    else if ( (LA10_3=='U') ) {
                        alt10=3;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:399:36: (~ ( '\\'' | '\\\\' ) )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:400:36: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) )
            	    {
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:400:36: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) )
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:400:38: '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) )
            	    {
            	    match('\\'); if (state.failed) return ;

            	    if ( input.LA(1)=='\''||input.LA(1)=='B'||input.LA(1)=='F'||input.LA(1)=='N'||input.LA(1)=='R'||input.LA(1)=='T'||input.LA(1)=='\\'||input.LA(1)=='n'||input.LA(1)=='r' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:401:36: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
            	    {
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:401:36: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:401:38: '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' )
            	    {
            	    match("\\U"); if (state.failed) return ;



            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULTILINE_QUOTEDSTRING"

    // $ANTLR start "EXECCOMMAND"
    public final void mEXECCOMMAND() throws RecognitionException {
        try {
            int _type = EXECCOMMAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:409:13: ( '`' (~ ( '`' ) )* '`' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:409:15: '`' (~ ( '`' ) )* '`'
            {
            match('`'); if (state.failed) return ;

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:409:19: (~ ( '`' ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '\u0000' && LA11_0 <= '_')||(LA11_0 >= 'a' && LA11_0 <= '\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '_')||(input.LA(1) >= 'a' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            match('`'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXECCOMMAND"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:412:6: ( '*' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:412:8: '*'
            {
            match('*'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:415:7: ( ':' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:415:9: ':'
            {
            match(':'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:418:8: ( '$' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:418:10: '$'
            {
            match('$'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:421:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:421:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( state.backtracking==0 ) { _channel = HIDDEN; }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:424:12: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:424:14: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); if (state.failed) return ;



            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:424:19: (~ ( '\\r' | '\\n' ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\t')||(LA12_0 >= '\u000B' && LA12_0 <= '\f')||(LA12_0 >= '\u000E' && LA12_0 <= '\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            if ( state.backtracking==0 ) { _channel = HIDDEN; }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:427:12: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:427:14: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); if (state.failed) return ;



            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:427:19: ( options {greedy=false; } : . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='*') ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1=='/') ) {
                        alt13=2;
                    }
                    else if ( ((LA13_1 >= '\u0000' && LA13_1 <= '.')||(LA13_1 >= '0' && LA13_1 <= '\uFFFF')) ) {
                        alt13=1;
                    }


                }
                else if ( ((LA13_0 >= '\u0000' && LA13_0 <= ')')||(LA13_0 >= '+' && LA13_0 <= '\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:427:49: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            match("*/"); if (state.failed) return ;



            if ( state.backtracking==0 ) { _channel = HIDDEN; }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "SEMI_COLON"
    public final void mSEMI_COLON() throws RecognitionException {
        try {
            int _type = SEMI_COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:430:12: ( ';' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:430:14: ';'
            {
            match(';'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMI_COLON"

    // $ANTLR start "LEFT_PAREN"
    public final void mLEFT_PAREN() throws RecognitionException {
        try {
            int _type = LEFT_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:433:12: ( '(' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:433:14: '('
            {
            match('('); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT_PAREN"

    // $ANTLR start "RIGHT_PAREN"
    public final void mRIGHT_PAREN() throws RecognitionException {
        try {
            int _type = RIGHT_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:436:13: ( ')' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:436:15: ')'
            {
            match(')'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT_PAREN"

    // $ANTLR start "LEFT_CURLY"
    public final void mLEFT_CURLY() throws RecognitionException {
        try {
            int _type = LEFT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:439:12: ( '{' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:439:14: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT_CURLY"

    // $ANTLR start "RIGHT_CURLY"
    public final void mRIGHT_CURLY() throws RecognitionException {
        try {
            int _type = RIGHT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:442:13: ( '}' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:442:15: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT_CURLY"

    // $ANTLR start "LEFT_BRACKET"
    public final void mLEFT_BRACKET() throws RecognitionException {
        try {
            int _type = LEFT_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:445:14: ( '[' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:445:16: '['
            {
            match('['); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT_BRACKET"

    // $ANTLR start "RIGHT_BRACKET"
    public final void mRIGHT_BRACKET() throws RecognitionException {
        try {
            int _type = RIGHT_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:448:15: ( ']' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:448:17: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT_BRACKET"

    // $ANTLR start "POUND"
    public final void mPOUND() throws RecognitionException {
        try {
            int _type = POUND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:451:7: ( '#' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:451:9: '#'
            {
            match('#'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "POUND"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:454:7: ( '=' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:454:9: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:457:7: ( ',' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:457:9: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "PERIOD"
    public final void mPERIOD() throws RecognitionException {
        try {
            int _type = PERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:460:8: ( '.' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:460:10: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PERIOD"

    // $ANTLR start "DOUBLE_PERIOD"
    public final void mDOUBLE_PERIOD() throws RecognitionException {
        try {
            int _type = DOUBLE_PERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:463:15: ( '..' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:463:17: '..'
            {
            match(".."); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLE_PERIOD"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:466:5: ( '/' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:466:7: '/'
            {
            match('/'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:469:9: ( '%' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:469:11: '%'
            {
            match('%'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:472:6: ( '+' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:472:8: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:475:7: ( '-' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:475:9: '-'
            {
            match('-'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "QMARK"
    public final void mQMARK() throws RecognitionException {
        try {
            int _type = QMARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:478:7: ( '?' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:478:9: '?'
            {
            match('?'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QMARK"

    // $ANTLR start "ARROBA"
    public final void mARROBA() throws RecognitionException {
        try {
            int _type = ARROBA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:481:8: ( '@' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:481:10: '@'
            {
            match('@'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ARROBA"

    // $ANTLR start "AMPERSAND"
    public final void mAMPERSAND() throws RecognitionException {
        try {
            int _type = AMPERSAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:484:11: ( '&' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:484:13: '&'
            {
            match('&'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AMPERSAND"

    // $ANTLR start "FAT_ARROW"
    public final void mFAT_ARROW() throws RecognitionException {
        try {
            int _type = FAT_ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:487:11: ( '=>' )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:487:13: '=>'
            {
            match("=>"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FAT_ARROW"

    public void mTokens() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:8: ( VOID | NULL | IMPORT | REGISTER | RETURNS | DEFINE | LOAD | FILTER | FOREACH | ORDER | RANK | DENSE | CUBE | ROLLUP | INVOKE | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | OTHERWISE | ALL | AS | BY | USING | INNER | OUTER | ONSCHEMA | PARALLEL | PIVOT | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | BIGDECIMAL | BIGINTEGER | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | STREAM | THROUGH | STORE | ASSERT | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | CASE | WHEN | THEN | ELSE | END | STR_OP_EQ | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_NE | STR_OP_MATCHES | IN | TRUE | FALSE | NUM_OP_EQ | NUM_OP_LT | NUM_OP_LTE | NUM_OP_GT | NUM_OP_GTE | NUM_OP_NE | DCOLON | IDENTIFIER | INTEGER | LONGINTEGER | DOLLARVAR | DOUBLENUMBER | BIGDECIMALNUMBER | BIGINTEGERNUMBER | FLOATNUMBER | QUOTEDSTRING | MULTILINE_QUOTEDSTRING | EXECCOMMAND | STAR | COLON | DOLLAR | WS | SL_COMMENT | ML_COMMENT | SEMI_COLON | LEFT_PAREN | RIGHT_PAREN | LEFT_CURLY | RIGHT_CURLY | LEFT_BRACKET | RIGHT_BRACKET | POUND | EQUAL | COMMA | PERIOD | DOUBLE_PERIOD | DIV | PERCENT | PLUS | MINUS | QMARK | ARROBA | AMPERSAND | FAT_ARROW )
        int alt14=132;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:10: VOID
                {
                mVOID(); if (state.failed) return ;


                }
                break;
            case 2 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:15: NULL
                {
                mNULL(); if (state.failed) return ;


                }
                break;
            case 3 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:20: IMPORT
                {
                mIMPORT(); if (state.failed) return ;


                }
                break;
            case 4 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:27: REGISTER
                {
                mREGISTER(); if (state.failed) return ;


                }
                break;
            case 5 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:36: RETURNS
                {
                mRETURNS(); if (state.failed) return ;


                }
                break;
            case 6 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:44: DEFINE
                {
                mDEFINE(); if (state.failed) return ;


                }
                break;
            case 7 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:51: LOAD
                {
                mLOAD(); if (state.failed) return ;


                }
                break;
            case 8 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:56: FILTER
                {
                mFILTER(); if (state.failed) return ;


                }
                break;
            case 9 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:63: FOREACH
                {
                mFOREACH(); if (state.failed) return ;


                }
                break;
            case 10 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:71: ORDER
                {
                mORDER(); if (state.failed) return ;


                }
                break;
            case 11 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:77: RANK
                {
                mRANK(); if (state.failed) return ;


                }
                break;
            case 12 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:82: DENSE
                {
                mDENSE(); if (state.failed) return ;


                }
                break;
            case 13 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:88: CUBE
                {
                mCUBE(); if (state.failed) return ;


                }
                break;
            case 14 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:93: ROLLUP
                {
                mROLLUP(); if (state.failed) return ;


                }
                break;
            case 15 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:100: INVOKE
                {
                mINVOKE(); if (state.failed) return ;


                }
                break;
            case 16 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:107: DISTINCT
                {
                mDISTINCT(); if (state.failed) return ;


                }
                break;
            case 17 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:116: COGROUP
                {
                mCOGROUP(); if (state.failed) return ;


                }
                break;
            case 18 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:124: JOIN
                {
                mJOIN(); if (state.failed) return ;


                }
                break;
            case 19 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:129: CROSS
                {
                mCROSS(); if (state.failed) return ;


                }
                break;
            case 20 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:135: UNION
                {
                mUNION(); if (state.failed) return ;


                }
                break;
            case 21 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:141: SPLIT
                {
                mSPLIT(); if (state.failed) return ;


                }
                break;
            case 22 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:147: INTO
                {
                mINTO(); if (state.failed) return ;


                }
                break;
            case 23 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:152: IF
                {
                mIF(); if (state.failed) return ;


                }
                break;
            case 24 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:155: OTHERWISE
                {
                mOTHERWISE(); if (state.failed) return ;


                }
                break;
            case 25 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:165: ALL
                {
                mALL(); if (state.failed) return ;


                }
                break;
            case 26 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:169: AS
                {
                mAS(); if (state.failed) return ;


                }
                break;
            case 27 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:172: BY
                {
                mBY(); if (state.failed) return ;


                }
                break;
            case 28 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:175: USING
                {
                mUSING(); if (state.failed) return ;


                }
                break;
            case 29 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:181: INNER
                {
                mINNER(); if (state.failed) return ;


                }
                break;
            case 30 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:187: OUTER
                {
                mOUTER(); if (state.failed) return ;


                }
                break;
            case 31 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:193: ONSCHEMA
                {
                mONSCHEMA(); if (state.failed) return ;


                }
                break;
            case 32 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:202: PARALLEL
                {
                mPARALLEL(); if (state.failed) return ;


                }
                break;
            case 33 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:211: PIVOT
                {
                mPIVOT(); if (state.failed) return ;


                }
                break;
            case 34 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:217: PARTITION
                {
                mPARTITION(); if (state.failed) return ;


                }
                break;
            case 35 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:227: GROUP
                {
                mGROUP(); if (state.failed) return ;


                }
                break;
            case 36 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:233: AND
                {
                mAND(); if (state.failed) return ;


                }
                break;
            case 37 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:237: OR
                {
                mOR(); if (state.failed) return ;


                }
                break;
            case 38 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:240: NOT
                {
                mNOT(); if (state.failed) return ;


                }
                break;
            case 39 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:244: GENERATE
                {
                mGENERATE(); if (state.failed) return ;


                }
                break;
            case 40 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:253: FLATTEN
                {
                mFLATTEN(); if (state.failed) return ;


                }
                break;
            case 41 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:261: ASC
                {
                mASC(); if (state.failed) return ;


                }
                break;
            case 42 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:265: DESC
                {
                mDESC(); if (state.failed) return ;


                }
                break;
            case 43 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:270: BOOLEAN
                {
                mBOOLEAN(); if (state.failed) return ;


                }
                break;
            case 44 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:278: INT
                {
                mINT(); if (state.failed) return ;


                }
                break;
            case 45 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:282: LONG
                {
                mLONG(); if (state.failed) return ;


                }
                break;
            case 46 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:287: FLOAT
                {
                mFLOAT(); if (state.failed) return ;


                }
                break;
            case 47 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:293: BIGDECIMAL
                {
                mBIGDECIMAL(); if (state.failed) return ;


                }
                break;
            case 48 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:304: BIGINTEGER
                {
                mBIGINTEGER(); if (state.failed) return ;


                }
                break;
            case 49 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:315: DOUBLE
                {
                mDOUBLE(); if (state.failed) return ;


                }
                break;
            case 50 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:322: DATETIME
                {
                mDATETIME(); if (state.failed) return ;


                }
                break;
            case 51 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:331: CHARARRAY
                {
                mCHARARRAY(); if (state.failed) return ;


                }
                break;
            case 52 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:341: BYTEARRAY
                {
                mBYTEARRAY(); if (state.failed) return ;


                }
                break;
            case 53 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:351: BAG
                {
                mBAG(); if (state.failed) return ;


                }
                break;
            case 54 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:355: TUPLE
                {
                mTUPLE(); if (state.failed) return ;


                }
                break;
            case 55 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:361: MAP
                {
                mMAP(); if (state.failed) return ;


                }
                break;
            case 56 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:365: IS
                {
                mIS(); if (state.failed) return ;


                }
                break;
            case 57 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:368: STREAM
                {
                mSTREAM(); if (state.failed) return ;


                }
                break;
            case 58 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:375: THROUGH
                {
                mTHROUGH(); if (state.failed) return ;


                }
                break;
            case 59 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:383: STORE
                {
                mSTORE(); if (state.failed) return ;


                }
                break;
            case 60 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:389: ASSERT
                {
                mASSERT(); if (state.failed) return ;


                }
                break;
            case 61 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:396: MAPREDUCE
                {
                mMAPREDUCE(); if (state.failed) return ;


                }
                break;
            case 62 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:406: SHIP
                {
                mSHIP(); if (state.failed) return ;


                }
                break;
            case 63 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:411: CACHE
                {
                mCACHE(); if (state.failed) return ;


                }
                break;
            case 64 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:417: INPUT
                {
                mINPUT(); if (state.failed) return ;


                }
                break;
            case 65 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:423: OUTPUT
                {
                mOUTPUT(); if (state.failed) return ;


                }
                break;
            case 66 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:430: STDERROR
                {
                mSTDERROR(); if (state.failed) return ;


                }
                break;
            case 67 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:439: STDIN
                {
                mSTDIN(); if (state.failed) return ;


                }
                break;
            case 68 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:445: STDOUT
                {
                mSTDOUT(); if (state.failed) return ;


                }
                break;
            case 69 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:452: LIMIT
                {
                mLIMIT(); if (state.failed) return ;


                }
                break;
            case 70 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:458: SAMPLE
                {
                mSAMPLE(); if (state.failed) return ;


                }
                break;
            case 71 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:465: LEFT
                {
                mLEFT(); if (state.failed) return ;


                }
                break;
            case 72 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:470: RIGHT
                {
                mRIGHT(); if (state.failed) return ;


                }
                break;
            case 73 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:476: FULL
                {
                mFULL(); if (state.failed) return ;


                }
                break;
            case 74 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:481: CASE
                {
                mCASE(); if (state.failed) return ;


                }
                break;
            case 75 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:486: WHEN
                {
                mWHEN(); if (state.failed) return ;


                }
                break;
            case 76 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:491: THEN
                {
                mTHEN(); if (state.failed) return ;


                }
                break;
            case 77 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:496: ELSE
                {
                mELSE(); if (state.failed) return ;


                }
                break;
            case 78 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:501: END
                {
                mEND(); if (state.failed) return ;


                }
                break;
            case 79 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:505: STR_OP_EQ
                {
                mSTR_OP_EQ(); if (state.failed) return ;


                }
                break;
            case 80 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:515: STR_OP_GT
                {
                mSTR_OP_GT(); if (state.failed) return ;


                }
                break;
            case 81 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:525: STR_OP_LT
                {
                mSTR_OP_LT(); if (state.failed) return ;


                }
                break;
            case 82 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:535: STR_OP_GTE
                {
                mSTR_OP_GTE(); if (state.failed) return ;


                }
                break;
            case 83 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:546: STR_OP_LTE
                {
                mSTR_OP_LTE(); if (state.failed) return ;


                }
                break;
            case 84 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:557: STR_OP_NE
                {
                mSTR_OP_NE(); if (state.failed) return ;


                }
                break;
            case 85 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:567: STR_OP_MATCHES
                {
                mSTR_OP_MATCHES(); if (state.failed) return ;


                }
                break;
            case 86 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:582: IN
                {
                mIN(); if (state.failed) return ;


                }
                break;
            case 87 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:585: TRUE
                {
                mTRUE(); if (state.failed) return ;


                }
                break;
            case 88 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:590: FALSE
                {
                mFALSE(); if (state.failed) return ;


                }
                break;
            case 89 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:596: NUM_OP_EQ
                {
                mNUM_OP_EQ(); if (state.failed) return ;


                }
                break;
            case 90 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:606: NUM_OP_LT
                {
                mNUM_OP_LT(); if (state.failed) return ;


                }
                break;
            case 91 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:616: NUM_OP_LTE
                {
                mNUM_OP_LTE(); if (state.failed) return ;


                }
                break;
            case 92 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:627: NUM_OP_GT
                {
                mNUM_OP_GT(); if (state.failed) return ;


                }
                break;
            case 93 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:637: NUM_OP_GTE
                {
                mNUM_OP_GTE(); if (state.failed) return ;


                }
                break;
            case 94 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:648: NUM_OP_NE
                {
                mNUM_OP_NE(); if (state.failed) return ;


                }
                break;
            case 95 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:658: DCOLON
                {
                mDCOLON(); if (state.failed) return ;


                }
                break;
            case 96 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:665: IDENTIFIER
                {
                mIDENTIFIER(); if (state.failed) return ;


                }
                break;
            case 97 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:676: INTEGER
                {
                mINTEGER(); if (state.failed) return ;


                }
                break;
            case 98 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:684: LONGINTEGER
                {
                mLONGINTEGER(); if (state.failed) return ;


                }
                break;
            case 99 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:696: DOLLARVAR
                {
                mDOLLARVAR(); if (state.failed) return ;


                }
                break;
            case 100 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:706: DOUBLENUMBER
                {
                mDOUBLENUMBER(); if (state.failed) return ;


                }
                break;
            case 101 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:719: BIGDECIMALNUMBER
                {
                mBIGDECIMALNUMBER(); if (state.failed) return ;


                }
                break;
            case 102 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:736: BIGINTEGERNUMBER
                {
                mBIGINTEGERNUMBER(); if (state.failed) return ;


                }
                break;
            case 103 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:753: FLOATNUMBER
                {
                mFLOATNUMBER(); if (state.failed) return ;


                }
                break;
            case 104 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:765: QUOTEDSTRING
                {
                mQUOTEDSTRING(); if (state.failed) return ;


                }
                break;
            case 105 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:778: MULTILINE_QUOTEDSTRING
                {
                mMULTILINE_QUOTEDSTRING(); if (state.failed) return ;


                }
                break;
            case 106 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:801: EXECCOMMAND
                {
                mEXECCOMMAND(); if (state.failed) return ;


                }
                break;
            case 107 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:813: STAR
                {
                mSTAR(); if (state.failed) return ;


                }
                break;
            case 108 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:818: COLON
                {
                mCOLON(); if (state.failed) return ;


                }
                break;
            case 109 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:824: DOLLAR
                {
                mDOLLAR(); if (state.failed) return ;


                }
                break;
            case 110 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:831: WS
                {
                mWS(); if (state.failed) return ;


                }
                break;
            case 111 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:834: SL_COMMENT
                {
                mSL_COMMENT(); if (state.failed) return ;


                }
                break;
            case 112 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:845: ML_COMMENT
                {
                mML_COMMENT(); if (state.failed) return ;


                }
                break;
            case 113 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:856: SEMI_COLON
                {
                mSEMI_COLON(); if (state.failed) return ;


                }
                break;
            case 114 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:867: LEFT_PAREN
                {
                mLEFT_PAREN(); if (state.failed) return ;


                }
                break;
            case 115 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:878: RIGHT_PAREN
                {
                mRIGHT_PAREN(); if (state.failed) return ;


                }
                break;
            case 116 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:890: LEFT_CURLY
                {
                mLEFT_CURLY(); if (state.failed) return ;


                }
                break;
            case 117 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:901: RIGHT_CURLY
                {
                mRIGHT_CURLY(); if (state.failed) return ;


                }
                break;
            case 118 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:913: LEFT_BRACKET
                {
                mLEFT_BRACKET(); if (state.failed) return ;


                }
                break;
            case 119 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:926: RIGHT_BRACKET
                {
                mRIGHT_BRACKET(); if (state.failed) return ;


                }
                break;
            case 120 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:940: POUND
                {
                mPOUND(); if (state.failed) return ;


                }
                break;
            case 121 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:946: EQUAL
                {
                mEQUAL(); if (state.failed) return ;


                }
                break;
            case 122 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:952: COMMA
                {
                mCOMMA(); if (state.failed) return ;


                }
                break;
            case 123 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:958: PERIOD
                {
                mPERIOD(); if (state.failed) return ;


                }
                break;
            case 124 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:965: DOUBLE_PERIOD
                {
                mDOUBLE_PERIOD(); if (state.failed) return ;


                }
                break;
            case 125 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:979: DIV
                {
                mDIV(); if (state.failed) return ;


                }
                break;
            case 126 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:983: PERCENT
                {
                mPERCENT(); if (state.failed) return ;


                }
                break;
            case 127 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:991: PLUS
                {
                mPLUS(); if (state.failed) return ;


                }
                break;
            case 128 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:996: MINUS
                {
                mMINUS(); if (state.failed) return ;


                }
                break;
            case 129 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:1002: QMARK
                {
                mQMARK(); if (state.failed) return ;


                }
                break;
            case 130 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:1008: ARROBA
                {
                mARROBA(); if (state.failed) return ;


                }
                break;
            case 131 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:1015: AMPERSAND
                {
                mAMPERSAND(); if (state.failed) return ;


                }
                break;
            case 132 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:1:1025: FAT_ARROW
                {
                mFAT_ARROW(); if (state.failed) return ;


                }
                break;

        }

    }

    // $ANTLR start synpred1_QueryLexer
    public final void synpred1_QueryLexer_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:362:9: ( ID DCOLON )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/QueryLexer.g:362:11: ID DCOLON
        {
        mID(); if (state.failed) return ;


        mDCOLON(); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred1_QueryLexer

    public final boolean synpred1_QueryLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_QueryLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA3_eotS =
        "\1\uffff\1\2\1\uffff\1\2\1\uffff";
    static final String DFA3_eofS =
        "\5\uffff";
    static final String DFA3_minS =
        "\1\101\1\60\1\uffff\1\60\1\uffff";
    static final String DFA3_maxS =
        "\1\132\1\137\1\uffff\1\137\1\uffff";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA3_specialS =
        "\1\uffff\1\1\1\uffff\1\0\1\uffff}>";
    static final String[] DFA3_transitionS = {
            "\32\1",
            "\12\3\1\4\6\uffff\32\3\4\uffff\1\3",
            "",
            "\12\3\1\4\6\uffff\32\3\4\uffff\1\3",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "357:1: IDENTIFIER : ( ( ID DCOLON )=> ( ID DCOLON IDENTIFIER ) | ID );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_3 = input.LA(1);

                         
                        int index3_3 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA3_3==':') && (synpred1_QueryLexer())) {s = 4;}

                        else if ( ((LA3_3 >= '0' && LA3_3 <= '9')||(LA3_3 >= 'A' && LA3_3 <= 'Z')||LA3_3=='_') ) {s = 3;}

                        else s = 2;

                         
                        input.seek(index3_3);

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA3_1 = input.LA(1);

                         
                        int index3_1 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA3_1 >= '0' && LA3_1 <= '9')||(LA3_1 >= 'A' && LA3_1 <= 'Z')||LA3_1=='_') ) {s = 3;}

                        else if ( (LA3_1==':') && (synpred1_QueryLexer())) {s = 4;}

                        else s = 2;

                         
                        input.seek(index3_1);

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA14_eotS =
        "\1\uffff\24\32\1\162\1\164\1\166\1\uffff\1\170\1\uffff\1\171\1\177"+
        "\1\u0082\4\uffff\1\u0089\1\u008b\16\uffff\6\32\1\u0096\1\u0097\1"+
        "\u0098\13\32\1\u00a9\5\32\1\u00b1\20\32\1\u00c7\1\32\1\u00ca\7\32"+
        "\1\u00d3\7\32\1\u00dd\23\uffff\1\u00e3\10\uffff\2\32\1\u00e9\1\32"+
        "\1\u00eb\2\32\1\u00ef\2\32\3\uffff\17\32\1\u0101\1\uffff\7\32\1"+
        "\uffff\22\32\1\u011e\1\u011f\1\32\1\uffff\1\u0121\1\32\1\uffff\2"+
        "\32\1\u0126\4\32\1\u012c\1\uffff\4\32\1\u0132\3\32\1\u0136\1\uffff"+
        "\1\u00e3\1\uffff\1\u00e3\6\uffff\1\u0138\1\u0139\1\uffff\1\32\1"+
        "\uffff\2\32\1\u013d\1\uffff\4\32\1\u0142\4\32\1\u0147\3\32\1\u014b"+
        "\1\u014c\1\32\1\u014e\1\uffff\4\32\1\u0153\6\32\1\u015a\4\32\1\u015f"+
        "\1\u0160\10\32\1\u0169\1\32\2\uffff\1\32\1\uffff\4\32\1\uffff\5"+
        "\32\1\uffff\2\32\1\u0177\1\u0178\1\32\1\uffff\1\32\1\u017b\1\u017c"+
        "\4\uffff\3\32\1\uffff\1\u0181\1\u0182\2\32\1\uffff\1\32\1\u0186"+
        "\1\32\1\u0188\1\uffff\3\32\2\uffff\1\u018c\1\uffff\3\32\1\u0190"+
        "\1\uffff\1\u0191\1\u0192\1\32\1\u0194\2\32\1\uffff\1\32\1\u0198"+
        "\1\32\1\u019a\2\uffff\1\u019b\1\u019c\1\u019d\1\32\1\u019f\1\32"+
        "\1\u01a1\1\32\1\uffff\10\32\1\u01ab\1\u01ac\1\32\1\u01ae\1\32\2"+
        "\uffff\2\32\3\uffff\1\u01b3\1\u01b4\1\u01b5\2\uffff\2\32\1\u01b8"+
        "\1\uffff\1\u01b9\1\uffff\1\32\1\u01bb\1\32\1\uffff\1\u01bd\2\32"+
        "\3\uffff\1\32\1\uffff\1\u01c1\2\32\1\uffff\1\32\4\uffff\1\u01c5"+
        "\1\uffff\1\u01c6\1\uffff\1\u01c7\1\u01c8\1\u01c9\6\32\2\uffff\1"+
        "\32\1\uffff\3\32\4\uffff\1\32\1\u01d6\2\uffff\1\32\1\uffff\1\32"+
        "\1\uffff\1\u01d9\1\u01da\1\32\1\uffff\1\32\1\u01dd\1\32\5\uffff"+
        "\1\32\1\u01e0\5\32\1\u01e6\1\32\1\u01e8\1\uffff\1\u01e9\1\uffff"+
        "\1\u01ea\1\u01eb\2\uffff\1\32\1\u01ed\1\uffff\2\32\1\uffff\2\32"+
        "\1\u01f2\1\32\1\u01f4\1\uffff\1\32\4\uffff\1\u01f6\1\uffff\1\u01f7"+
        "\1\u01f8\2\32\1\uffff\1\u01fb\1\uffff\1\u01b3\3\uffff\1\u01fc\1"+
        "\u01fd\3\uffff";
    static final String DFA14_eofS =
        "\u01fe\uffff";
    static final String DFA14_minS =
        "\1\11\1\117\1\101\1\106\2\101\1\105\1\101\1\116\1\101\1\117\1\116"+
        "\1\101\1\114\2\101\1\105\1\110\1\101\1\110\1\114\3\75\1\uffff\1"+
        "\72\1\uffff\1\56\1\60\1\56\1\0\3\uffff\1\55\1\52\16\uffff\1\111"+
        "\1\114\2\124\1\121\1\120\3\60\1\107\1\116\1\114\1\107\1\106\1\123"+
        "\1\125\1\124\1\101\1\115\1\106\1\60\1\114\1\122\1\101\2\114\1\60"+
        "\1\110\1\124\1\123\1\102\1\107\1\117\1\101\1\103\3\111\1\114\1\104"+
        "\1\111\1\115\1\114\1\60\1\104\1\60\1\117\2\107\1\122\1\126\1\117"+
        "\1\116\1\60\1\120\1\105\1\125\1\120\1\105\1\123\1\104\1\60\13\uffff"+
        "\1\60\1\53\1\104\5\uffff\1\60\1\0\1\47\6\uffff\1\104\1\114\1\60"+
        "\1\111\1\60\2\117\1\60\1\105\1\125\3\uffff\1\111\1\125\1\113\1\114"+
        "\1\110\1\111\1\123\1\103\1\124\1\102\1\105\1\104\1\107\1\111\1\124"+
        "\1\60\1\uffff\1\124\1\105\1\124\1\101\1\114\1\123\1\105\1\uffff"+
        "\2\105\1\103\1\105\1\122\1\123\1\122\1\110\1\105\1\116\1\117\1\116"+
        "\1\111\1\105\1\122\1\105\2\120\2\60\1\105\1\uffff\1\60\1\105\1\uffff"+
        "\1\114\1\104\1\60\1\101\1\117\1\125\1\105\1\60\1\uffff\1\114\1\117"+
        "\1\116\1\105\1\60\1\103\1\116\1\105\1\60\1\uffff\3\60\3\uffff\1"+
        "\0\1\60\1\uffff\2\60\1\uffff\1\126\1\uffff\1\122\1\113\1\60\1\uffff"+
        "\1\122\1\124\1\123\1\122\1\60\1\125\1\124\1\116\1\105\1\60\1\111"+
        "\1\114\1\124\2\60\1\124\1\60\1\uffff\1\105\1\101\2\124\1\60\1\105"+
        "\3\122\1\125\1\110\1\60\1\117\1\123\1\101\1\105\2\60\1\116\1\107"+
        "\1\124\1\101\1\105\1\122\1\116\1\125\1\60\1\114\2\uffff\1\122\1"+
        "\uffff\1\101\2\105\1\116\1\uffff\1\114\1\111\1\124\1\120\1\122\1"+
        "\uffff\1\105\1\125\2\60\1\105\1\uffff\1\110\2\60\1\uffff\1\60\2"+
        "\uffff\1\105\1\124\1\105\1\uffff\2\60\1\124\1\116\1\uffff\1\120"+
        "\1\60\1\105\1\60\1\uffff\1\116\1\105\1\111\2\uffff\1\60\1\uffff"+
        "\1\122\1\103\1\105\1\60\1\uffff\2\60\1\127\1\60\1\124\1\105\1\uffff"+
        "\1\125\1\60\1\122\1\60\2\uffff\3\60\1\115\1\60\1\122\1\60\1\124"+
        "\1\uffff\1\105\1\124\1\122\1\101\1\103\1\124\1\114\1\124\2\60\1"+
        "\101\1\60\1\107\2\uffff\1\104\1\105\2\uffff\4\60\2\uffff\1\105\1"+
        "\123\1\60\1\uffff\1\60\1\uffff\1\103\1\60\1\115\1\uffff\1\60\1\110"+
        "\1\116\3\uffff\1\111\1\uffff\1\60\1\115\1\120\1\uffff\1\122\4\uffff"+
        "\1\60\1\uffff\1\60\1\uffff\3\60\1\122\1\116\1\111\2\105\1\111\2"+
        "\uffff\1\124\1\uffff\1\110\1\125\1\123\1\60\3\uffff\1\122\1\60\2"+
        "\uffff\1\124\1\uffff\1\105\1\uffff\2\60\1\123\1\uffff\1\101\1\60"+
        "\1\101\5\uffff\1\101\1\60\1\115\1\107\1\114\1\117\1\105\1\60\1\103"+
        "\1\60\1\0\1\60\1\uffff\2\60\2\uffff\1\105\1\60\1\uffff\2\131\1\uffff"+
        "\1\101\1\105\1\60\1\116\1\60\1\uffff\1\105\4\uffff\1\60\1\uffff"+
        "\2\60\1\114\1\122\1\uffff\1\60\1\uffff\1\60\3\uffff\2\60\3\uffff";
    static final String DFA14_maxS =
        "\1\175\1\117\1\125\1\123\2\117\1\124\3\125\1\117\1\123\1\124\1\123"+
        "\1\131\1\111\1\124\1\125\1\101\1\110\1\121\1\76\2\75\1\uffff\1\72"+
        "\1\uffff\1\114\2\71\1\uffff\3\uffff\1\55\1\52\16\uffff\1\111\1\114"+
        "\2\124\1\121\1\120\3\137\1\124\1\116\1\114\1\107\2\123\1\125\1\124"+
        "\1\116\1\115\1\106\1\137\1\114\1\122\1\117\2\114\1\137\1\110\1\124"+
        "\1\123\1\102\1\107\1\117\1\101\1\123\3\111\1\114\1\122\1\111\1\115"+
        "\1\114\1\137\1\104\1\137\1\117\2\107\1\122\1\126\1\117\1\116\1\137"+
        "\1\120\1\122\1\125\1\124\1\105\1\123\1\104\1\137\13\uffff\2\71\1"+
        "\111\5\uffff\1\106\1\uffff\1\162\6\uffff\1\104\1\114\1\137\1\111"+
        "\1\137\2\117\1\137\1\105\1\125\3\uffff\1\111\1\125\1\113\1\114\1"+
        "\110\1\111\1\123\1\103\1\124\1\102\1\105\1\104\1\107\1\111\1\124"+
        "\1\137\1\uffff\1\124\1\105\1\124\1\101\1\114\1\123\1\105\1\uffff"+
        "\1\105\1\120\1\103\1\105\1\122\1\123\1\122\1\110\1\105\1\116\1\117"+
        "\1\116\1\111\1\105\1\122\1\117\2\120\2\137\1\105\1\uffff\1\137\1"+
        "\105\1\uffff\1\114\1\111\1\137\1\124\1\117\1\125\1\105\1\137\1\uffff"+
        "\1\114\1\117\1\116\1\105\1\137\1\103\1\116\1\105\1\137\1\uffff\1"+
        "\106\1\71\1\106\3\uffff\1\uffff\1\106\1\uffff\2\137\1\uffff\1\126"+
        "\1\uffff\1\122\1\113\1\137\1\uffff\1\122\1\124\1\123\1\122\1\137"+
        "\1\125\1\124\1\116\1\105\1\137\1\111\1\114\1\124\2\137\1\124\1\137"+
        "\1\uffff\1\105\1\101\2\124\1\137\1\105\3\122\1\125\1\110\1\137\1"+
        "\117\1\123\1\101\1\105\2\137\1\116\1\107\1\124\1\101\1\105\1\122"+
        "\1\116\1\125\1\137\1\114\2\uffff\1\122\1\uffff\1\101\2\105\1\116"+
        "\1\uffff\1\114\1\111\1\124\1\120\1\122\1\uffff\1\105\1\125\2\137"+
        "\1\105\1\uffff\1\110\2\137\1\uffff\1\106\2\uffff\1\105\1\124\1\105"+
        "\1\uffff\2\137\1\124\1\116\1\uffff\1\120\1\137\1\105\1\137\1\uffff"+
        "\1\116\1\105\1\111\2\uffff\1\137\1\uffff\1\122\1\103\1\105\1\137"+
        "\1\uffff\2\137\1\127\1\137\1\124\1\105\1\uffff\1\125\1\137\1\122"+
        "\1\137\2\uffff\3\137\1\115\1\137\1\122\1\137\1\124\1\uffff\1\105"+
        "\1\124\1\122\1\101\1\103\1\124\1\114\1\124\2\137\1\101\1\137\1\107"+
        "\2\uffff\1\104\1\105\2\uffff\1\106\3\137\2\uffff\1\105\1\123\1\137"+
        "\1\uffff\1\137\1\uffff\1\103\1\137\1\115\1\uffff\1\137\1\110\1\116"+
        "\3\uffff\1\111\1\uffff\1\137\1\115\1\120\1\uffff\1\122\4\uffff\1"+
        "\137\1\uffff\1\137\1\uffff\3\137\1\122\1\116\1\111\2\105\1\111\2"+
        "\uffff\1\124\1\uffff\1\110\1\125\1\123\1\106\3\uffff\1\122\1\137"+
        "\2\uffff\1\124\1\uffff\1\105\1\uffff\2\137\1\123\1\uffff\1\101\1"+
        "\137\1\101\5\uffff\1\101\1\137\1\115\1\107\1\114\1\117\1\105\1\137"+
        "\1\103\1\137\1\uffff\1\137\1\uffff\2\137\2\uffff\1\105\1\137\1\uffff"+
        "\2\131\1\uffff\1\101\1\105\1\137\1\116\1\137\1\uffff\1\105\4\uffff"+
        "\1\137\1\uffff\2\137\1\114\1\122\1\uffff\1\137\1\uffff\1\137\3\uffff"+
        "\2\137\3\uffff";
    static final String DFA14_acceptS =
        "\30\uffff\1\136\1\uffff\1\140\4\uffff\1\152\1\153\1\156\2\uffff"+
        "\1\161\1\162\1\163\1\164\1\165\1\166\1\167\1\170\1\172\1\176\1\177"+
        "\1\u0081\1\u0082\1\u0083\76\uffff\1\131\1\u0084\1\171\1\133\1\132"+
        "\1\135\1\134\1\137\1\154\1\141\1\142\3\uffff\1\147\1\155\1\143\1"+
        "\174\1\173\3\uffff\1\150\1\151\1\157\1\u0080\1\160\1\175\12\uffff"+
        "\1\126\1\27\1\70\20\uffff\1\121\7\uffff\1\45\25\uffff\1\32\2\uffff"+
        "\1\33\10\uffff\1\120\11\uffff\1\117\3\uffff\1\145\1\146\1\144\2"+
        "\uffff\1\150\2\uffff\1\46\1\uffff\1\124\3\uffff\1\54\21\uffff\1"+
        "\123\34\uffff\1\31\1\51\1\uffff\1\44\4\uffff\1\65\5\uffff\1\122"+
        "\5\uffff\1\67\3\uffff\1\116\1\uffff\1\1\1\2\3\uffff\1\26\4\uffff"+
        "\1\13\4\uffff\1\52\3\uffff\1\7\1\55\1\uffff\1\107\4\uffff\1\111"+
        "\6\uffff\1\15\4\uffff\1\112\1\22\10\uffff\1\76\15\uffff\1\114\1"+
        "\127\2\uffff\1\113\1\115\4\uffff\1\35\1\100\3\uffff\1\110\1\uffff"+
        "\1\14\3\uffff\1\105\3\uffff\1\56\1\130\1\12\1\uffff\1\36\3\uffff"+
        "\1\23\1\uffff\1\77\1\24\1\34\1\25\1\uffff\1\73\1\uffff\1\103\11"+
        "\uffff\1\41\1\43\1\uffff\1\66\4\uffff\1\75\1\3\1\17\2\uffff\1\16"+
        "\1\6\1\uffff\1\61\1\uffff\1\10\3\uffff\1\101\3\uffff\1\71\1\102"+
        "\1\104\1\106\1\74\14\uffff\1\5\2\uffff\1\11\1\50\2\uffff\1\21\2"+
        "\uffff\1\53\5\uffff\1\72\1\uffff\1\125\1\4\1\20\1\62\1\uffff\1\37"+
        "\4\uffff\1\40\1\uffff\1\47\1\uffff\1\30\1\63\1\64\2\uffff\1\42\1"+
        "\57\1\60";
    static final String DFA14_specialS =
        "\36\uffff\1\0\145\uffff\1\2\137\uffff\1\1\u00ef\uffff\1\3\51\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\41\1\uffff\2\41\22\uffff\1\41\1\30\1\uffff\1\53\1\34\1\55"+
            "\1\61\1\36\1\45\1\46\1\40\1\56\1\54\1\42\1\35\1\43\12\33\1\31"+
            "\1\44\1\26\1\25\1\27\1\57\1\60\1\15\1\16\1\11\1\5\1\24\1\7\1"+
            "\20\1\32\1\3\1\12\1\32\1\6\1\22\1\2\1\10\1\17\1\32\1\4\1\14"+
            "\1\21\1\13\1\1\1\23\3\32\1\51\1\uffff\1\52\2\uffff\1\37\32\uffff"+
            "\1\47\1\uffff\1\50",
            "\1\62",
            "\1\65\3\uffff\1\66\11\uffff\1\64\5\uffff\1\63",
            "\1\71\6\uffff\1\67\1\70\4\uffff\1\72",
            "\1\74\3\uffff\1\73\3\uffff\1\76\5\uffff\1\75",
            "\1\102\3\uffff\1\77\3\uffff\1\100\5\uffff\1\101",
            "\1\105\3\uffff\1\104\5\uffff\1\103\4\uffff\1\106",
            "\1\113\7\uffff\1\107\2\uffff\1\111\2\uffff\1\110\5\uffff\1"+
            "\112",
            "\1\117\3\uffff\1\114\1\uffff\1\115\1\116",
            "\1\124\6\uffff\1\123\6\uffff\1\121\2\uffff\1\122\2\uffff\1"+
            "\120",
            "\1\125",
            "\1\126\4\uffff\1\127",
            "\1\133\6\uffff\1\132\7\uffff\1\130\3\uffff\1\131",
            "\1\134\1\uffff\1\136\4\uffff\1\135",
            "\1\142\7\uffff\1\141\5\uffff\1\140\11\uffff\1\137",
            "\1\143\7\uffff\1\144",
            "\1\146\14\uffff\1\145\1\uffff\1\147",
            "\1\151\11\uffff\1\152\2\uffff\1\150",
            "\1\153",
            "\1\154",
            "\1\155\1\uffff\1\156\2\uffff\1\157",
            "\1\160\1\161",
            "\1\163",
            "\1\165",
            "",
            "\1\167",
            "",
            "\1\173\1\uffff\12\33\10\uffff\1\175\2\uffff\1\174\1\176\5\uffff"+
            "\1\172",
            "\12\u0080",
            "\1\u0081\1\uffff\12\u0083",
            "\12\u0084\1\u0087\2\u0084\1\u0087\31\u0084\1\u0086\64\u0084"+
            "\1\u0085\uffa3\u0084",
            "",
            "",
            "",
            "\1\u0088",
            "\1\u008a",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\13\32\6\uffff\15\32\1\u0094\1\32\1\u0095\3\32\1\u0093\1\32"+
            "\1\u0092\4\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0099\14\uffff\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e\7\uffff\1\u009f\4\uffff\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4\14\uffff\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\13\32\6\uffff\4\32\1\u00a8\25\32\4\uffff\1\32",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac\15\uffff\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\13\32\6\uffff\3\32\1\u00b0\26\32\4\uffff\1\32",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9\17\uffff\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00c1\12\uffff\1\u00c0\2\uffff\1\u00bf",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\13\32\6\uffff\2\32\1\u00c5\17\32\1\u00c6\7\32\4\uffff\1\32",
            "\1\u00c8",
            "\13\32\6\uffff\23\32\1\u00c9\6\32\4\uffff\1\32",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\13\32\6\uffff\4\32\1\u00d2\25\32\4\uffff\1\32",
            "\1\u00d4",
            "\1\u00d6\14\uffff\1\u00d5",
            "\1\u00d7",
            "\1\u00d8\3\uffff\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\u00de",
            "\1\u00df\1\uffff\1\u00df\2\uffff\12\u00e0",
            "\1\u00e1\4\uffff\1\u00e2",
            "",
            "",
            "",
            "",
            "",
            "\12\u0083\10\uffff\1\u00e1\2\uffff\1\174\1\176",
            "\12\u0084\1\u0087\2\u0084\1\u0087\31\u0084\1\u0086\64\u0084"+
            "\1\u0085\uffa3\u0084",
            "\1\u00e4\32\uffff\1\u00e4\3\uffff\1\u00e4\7\uffff\1\u00e4\3"+
            "\uffff\1\u00e4\1\uffff\1\u00e4\1\u00e5\6\uffff\1\u00e4\21\uffff"+
            "\1\u0087\3\uffff\1\u0087",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00e7",
            "\1\u00e8",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u00ea",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u00ec",
            "\1\u00ed",
            "\13\32\6\uffff\16\32\1\u00ee\13\32\4\uffff\1\32",
            "\1\u00f0",
            "\1\u00f1",
            "",
            "",
            "",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "",
            "\1\u0109",
            "\1\u010a\12\uffff\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119\3\uffff\1\u011a\5\uffff\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0120",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0122",
            "",
            "\1\u0123",
            "\1\u0124\4\uffff\1\u0125",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0127\22\uffff\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\13\32\6\uffff\21\32\1\u0131\10\32\4\uffff\1\32",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\12\u00de\10\uffff\1\u00e1\2\uffff\1\174\1\176",
            "\12\u00e0",
            "\12\u00e0\10\uffff\1\u00e1\3\uffff\1\176",
            "",
            "",
            "",
            "\12\u0084\1\u0087\2\u0084\1\u0087\31\u0084\1\u0086\64\u0084"+
            "\1\u0085\uffa3\u0084",
            "\12\u0137\7\uffff\6\u0137",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u013a",
            "",
            "\1\u013b",
            "\1\u013c",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u014d",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\1\u0159",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "\1\u015e",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u016a",
            "",
            "",
            "\1\u016b",
            "",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f",
            "",
            "\1\u0170",
            "\1\u0171",
            "\1\u0172",
            "\1\u0173",
            "\1\u0174",
            "",
            "\1\u0175",
            "\1\u0176",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0179",
            "",
            "\1\u017a",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\12\u017d\7\uffff\6\u017d",
            "",
            "",
            "\1\u017e",
            "\1\u017f",
            "\1\u0180",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0183",
            "\1\u0184",
            "",
            "\1\u0185",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0187",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u0189",
            "\1\u018a",
            "\1\u018b",
            "",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0193",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0195",
            "\1\u0196",
            "",
            "\1\u0197",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0199",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u019e",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01a0",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01a2",
            "",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\1\u01a9",
            "\1\u01aa",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01ad",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01af",
            "",
            "",
            "\1\u01b0",
            "\1\u01b1",
            "",
            "",
            "\12\u01b2\7\uffff\6\u01b2",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "\1\u01b6",
            "\1\u01b7",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u01ba",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01bc",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01be",
            "\1\u01bf",
            "",
            "",
            "",
            "\1\u01c0",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01c2",
            "\1\u01c3",
            "",
            "\1\u01c4",
            "",
            "",
            "",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01ca",
            "\1\u01cb",
            "\1\u01cc",
            "\1\u01cd",
            "\1\u01ce",
            "\1\u01cf",
            "",
            "",
            "\1\u01d0",
            "",
            "\1\u01d1",
            "\1\u01d2",
            "\1\u01d3",
            "\12\u01d4\7\uffff\6\u01d4",
            "",
            "",
            "",
            "\1\u01d5",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "\1\u01d7",
            "",
            "\1\u01d8",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01db",
            "",
            "\1\u01dc",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01de",
            "",
            "",
            "",
            "",
            "",
            "\1\u01df",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01e1",
            "\1\u01e2",
            "\1\u01e3",
            "\1\u01e4",
            "\1\u01e5",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01e7",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\12\u0084\1\u0087\2\u0084\1\u0087\31\u0084\1\u0086\64\u0084"+
            "\1\u0085\uffa3\u0084",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "\1\u01ec",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u01ee",
            "\1\u01ef",
            "",
            "\1\u01f0",
            "\1\u01f1",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01f3",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u01f5",
            "",
            "",
            "",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01f9",
            "\1\u01fa",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( VOID | NULL | IMPORT | REGISTER | RETURNS | DEFINE | LOAD | FILTER | FOREACH | ORDER | RANK | DENSE | CUBE | ROLLUP | INVOKE | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | OTHERWISE | ALL | AS | BY | USING | INNER | OUTER | ONSCHEMA | PARALLEL | PIVOT | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | BIGDECIMAL | BIGINTEGER | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | STREAM | THROUGH | STORE | ASSERT | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | CASE | WHEN | THEN | ELSE | END | STR_OP_EQ | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_NE | STR_OP_MATCHES | IN | TRUE | FALSE | NUM_OP_EQ | NUM_OP_LT | NUM_OP_LTE | NUM_OP_GT | NUM_OP_GTE | NUM_OP_NE | DCOLON | IDENTIFIER | INTEGER | LONGINTEGER | DOLLARVAR | DOUBLENUMBER | BIGDECIMALNUMBER | BIGINTEGERNUMBER | FLOATNUMBER | QUOTEDSTRING | MULTILINE_QUOTEDSTRING | EXECCOMMAND | STAR | COLON | DOLLAR | WS | SL_COMMENT | ML_COMMENT | SEMI_COLON | LEFT_PAREN | RIGHT_PAREN | LEFT_CURLY | RIGHT_CURLY | LEFT_BRACKET | RIGHT_BRACKET | POUND | EQUAL | COMMA | PERIOD | DOUBLE_PERIOD | DIV | PERCENT | PLUS | MINUS | QMARK | ARROBA | AMPERSAND | FAT_ARROW );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_30 = input.LA(1);

                        s = -1;
                        if ( ((LA14_30 >= '\u0000' && LA14_30 <= '\t')||(LA14_30 >= '\u000B' && LA14_30 <= '\f')||(LA14_30 >= '\u000E' && LA14_30 <= '&')||(LA14_30 >= '(' && LA14_30 <= '[')||(LA14_30 >= ']' && LA14_30 <= '\uFFFF')) ) {s = 132;}

                        else if ( (LA14_30=='\\') ) {s = 133;}

                        else if ( (LA14_30=='\'') ) {s = 134;}

                        else if ( (LA14_30=='\n'||LA14_30=='\r') ) {s = 135;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_228 = input.LA(1);

                        s = -1;
                        if ( (LA14_228=='\'') ) {s = 134;}

                        else if ( ((LA14_228 >= '\u0000' && LA14_228 <= '\t')||(LA14_228 >= '\u000B' && LA14_228 <= '\f')||(LA14_228 >= '\u000E' && LA14_228 <= '&')||(LA14_228 >= '(' && LA14_228 <= '[')||(LA14_228 >= ']' && LA14_228 <= '\uFFFF')) ) {s = 132;}

                        else if ( (LA14_228=='\\') ) {s = 133;}

                        else if ( (LA14_228=='\n'||LA14_228=='\r') ) {s = 135;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_132 = input.LA(1);

                        s = -1;
                        if ( (LA14_132=='\'') ) {s = 134;}

                        else if ( ((LA14_132 >= '\u0000' && LA14_132 <= '\t')||(LA14_132 >= '\u000B' && LA14_132 <= '\f')||(LA14_132 >= '\u000E' && LA14_132 <= '&')||(LA14_132 >= '(' && LA14_132 <= '[')||(LA14_132 >= ']' && LA14_132 <= '\uFFFF')) ) {s = 132;}

                        else if ( (LA14_132=='\\') ) {s = 133;}

                        else if ( (LA14_132=='\n'||LA14_132=='\r') ) {s = 135;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_468 = input.LA(1);

                        s = -1;
                        if ( (LA14_468=='\'') ) {s = 134;}

                        else if ( ((LA14_468 >= '\u0000' && LA14_468 <= '\t')||(LA14_468 >= '\u000B' && LA14_468 <= '\f')||(LA14_468 >= '\u000E' && LA14_468 <= '&')||(LA14_468 >= '(' && LA14_468 <= '[')||(LA14_468 >= ']' && LA14_468 <= '\uFFFF')) ) {s = 132;}

                        else if ( (LA14_468=='\\') ) {s = 133;}

                        else if ( (LA14_468=='\n'||LA14_468=='\r') ) {s = 135;}

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}