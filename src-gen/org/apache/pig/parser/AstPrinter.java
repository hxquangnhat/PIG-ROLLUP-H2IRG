// $ANTLR 3.4 /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g 2014-09-17 14:41:18

package org.apache.pig.parser;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (visitor for printing Pig script from Ast).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AstPrinter extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AMPERSAND", "AND", "ARROBA", "AS", "ASC", "ASSERT", "BAG", "BIGDECIMAL", "BIGDECIMALNUMBER", "BIGINTEGER", "BIGINTEGERNUMBER", "BOOLEAN", "BY", "BYTEARRAY", "CACHE", "CASE", "CHARARRAY", "COGROUP", "COLON", "COMMA", "CROSS", "CUBE", "DATETIME", "DCOLON", "DEFINE", "DENSE", "DESC", "DIGIT", "DISTINCT", "DIV", "DOLLAR", "DOLLARVAR", "DOUBLE", "DOUBLENUMBER", "DOUBLE_PERIOD", "ELSE", "END", "EQUAL", "EXECCOMMAND", "FALSE", "FAT_ARROW", "FILTER", "FLATTEN", "FLOAT", "FLOATINGPOINT", "FLOATNUMBER", "FOREACH", "FULL", "GENERATE", "GROUP", "ID", "IDENTIFIER", "IF", "IMPORT", "IN", "INNER", "INPUT", "INT", "INTEGER", "INTO", "INVOKE", "IS", "JOIN", "LEFT", "LEFT_BRACKET", "LEFT_CURLY", "LEFT_PAREN", "LETTER", "LIMIT", "LOAD", "LONG", "LONGINTEGER", "MAP", "MAPREDUCE", "MINUS", "ML_COMMENT", "MULTILINE_QUOTEDSTRING", "NOT", "NULL", "NUM_OP_EQ", "NUM_OP_GT", "NUM_OP_GTE", "NUM_OP_LT", "NUM_OP_LTE", "NUM_OP_NE", "ONSCHEMA", "OR", "ORDER", "OTHERWISE", "OUTER", "OUTPUT", "PARALLEL", "PARTITION", "PERCENT", "PERIOD", "PIVOT", "PLUS", "POUND", "QMARK", "QUOTEDSTRING", "RANK", "REGISTER", "RETURNS", "RIGHT", "RIGHT_BRACKET", "RIGHT_CURLY", "RIGHT_PAREN", "ROLLUP", "SAMPLE", "SEMI_COLON", "SHIP", "SL_COMMENT", "SPECIALCHAR", "SPLIT", "STAR", "STDERROR", "STDIN", "STDOUT", "STORE", "STREAM", "STR_OP_EQ", "STR_OP_GT", "STR_OP_GTE", "STR_OP_LT", "STR_OP_LTE", "STR_OP_MATCHES", "STR_OP_NE", "THEN", "THROUGH", "TRUE", "TUPLE", "UNION", "USING", "VOID", "WHEN", "WS", "ANY", "BAG_TYPE", "BAG_TYPE_CAST", "BAG_VAL", "BIN_EXPR", "BOOL", "BOOL_COND", "CASE_COND", "CASE_EXPR", "CASE_EXPR_LHS", "CASE_EXPR_RHS", "CAST_EXPR", "COL_RANGE", "EXPR_IN_PAREN", "FIELD_DEF", "FIELD_DEF_WITHOUT_IDENTIFIER", "FOREACH_PLAN_COMPLEX", "FOREACH_PLAN_SIMPLE", "FUNC", "FUNC_EVAL", "FUNC_REF", "INVOKER_FUNC_EVAL", "IN_LHS", "IN_RHS", "JOIN_ITEM", "KEY_VAL_PAIR", "MACRO_BODY", "MACRO_DEF", "MACRO_INLINE", "MAP_TYPE", "MAP_VAL", "NEG", "NESTED_CMD", "NESTED_CMD_ASSI", "NESTED_PROJ", "PARAMS", "QUERY", "REALIAS", "RETURN_VAL", "SPLIT_BRANCH", "STATEMENT", "TOBAG", "TOMAP", "TOTUPLE", "TUPLE_TYPE", "TUPLE_TYPE_CAST", "TUPLE_VAL", "EVAL", "MATCHES"
    };

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
    public static final int ANY=141;
    public static final int BAG_TYPE=142;
    public static final int BAG_TYPE_CAST=143;
    public static final int BAG_VAL=144;
    public static final int BIN_EXPR=145;
    public static final int BOOL=146;
    public static final int BOOL_COND=147;
    public static final int CASE_COND=148;
    public static final int CASE_EXPR=149;
    public static final int CASE_EXPR_LHS=150;
    public static final int CASE_EXPR_RHS=151;
    public static final int CAST_EXPR=152;
    public static final int COL_RANGE=153;
    public static final int EXPR_IN_PAREN=154;
    public static final int FIELD_DEF=155;
    public static final int FIELD_DEF_WITHOUT_IDENTIFIER=156;
    public static final int FOREACH_PLAN_COMPLEX=157;
    public static final int FOREACH_PLAN_SIMPLE=158;
    public static final int FUNC=159;
    public static final int FUNC_EVAL=160;
    public static final int FUNC_REF=161;
    public static final int INVOKER_FUNC_EVAL=162;
    public static final int IN_LHS=163;
    public static final int IN_RHS=164;
    public static final int JOIN_ITEM=165;
    public static final int KEY_VAL_PAIR=166;
    public static final int MACRO_BODY=167;
    public static final int MACRO_DEF=168;
    public static final int MACRO_INLINE=169;
    public static final int MAP_TYPE=170;
    public static final int MAP_VAL=171;
    public static final int NEG=172;
    public static final int NESTED_CMD=173;
    public static final int NESTED_CMD_ASSI=174;
    public static final int NESTED_PROJ=175;
    public static final int PARAMS=176;
    public static final int QUERY=177;
    public static final int REALIAS=178;
    public static final int RETURN_VAL=179;
    public static final int SPLIT_BRANCH=180;
    public static final int STATEMENT=181;
    public static final int TOBAG=182;
    public static final int TOMAP=183;
    public static final int TOTUPLE=184;
    public static final int TUPLE_TYPE=185;
    public static final int TUPLE_TYPE_CAST=186;
    public static final int TUPLE_VAL=187;
    public static final int EVAL=188;
    public static final int MATCHES=189;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public AstPrinter(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AstPrinter(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AstPrinter.tokenNames; }
    public String getGrammarFileName() { return "/home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g"; }



    public String getResult() { return sb.toString(); }

    private StringBuilder sb = new StringBuilder();



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:53:1: query : ^( QUERY ( statement )* ) ;
    public final AstPrinter.query_return query() throws RecognitionException {
        AstPrinter.query_return retval = new AstPrinter.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AstPrinter.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:53:7: ( ^( QUERY ( statement )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:53:9: ^( QUERY ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query80); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


            root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:53:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ASSERT||LA1_0==IMPORT||LA1_0==REGISTER||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:53:18: statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_query82);
                	    statement2=statement();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, statement2.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "query"


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:56:1: statement : ( general_statement | split_statement | import_statement | register_statement | assert_statement | realias_statement );
    public final AstPrinter.statement_return statement() throws RecognitionException {
        AstPrinter.statement_return retval = new AstPrinter.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.general_statement_return general_statement3 =null;

        AstPrinter.split_statement_return split_statement4 =null;

        AstPrinter.import_statement_return import_statement5 =null;

        AstPrinter.register_statement_return register_statement6 =null;

        AstPrinter.assert_statement_return assert_statement7 =null;

        AstPrinter.realias_statement_return realias_statement8 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:56:11: ( general_statement | split_statement | import_statement | register_statement | assert_statement | realias_statement )
            int alt2=6;
            switch ( input.LA(1) ) {
            case STATEMENT:
                {
                alt2=1;
                }
                break;
            case SPLIT:
                {
                alt2=2;
                }
                break;
            case IMPORT:
                {
                alt2=3;
                }
                break;
            case REGISTER:
                {
                alt2=4;
                }
                break;
            case ASSERT:
                {
                alt2=5;
                }
                break;
            case REALIAS:
                {
                alt2=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:56:13: general_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_general_statement_in_statement94);
                    general_statement3=general_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, general_statement3.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:57:13: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement108);
                    split_statement4=split_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_statement4.getTree());


                    if ( state.backtracking==0 ) { sb.append(";\n"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:58:13: import_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_import_statement_in_statement124);
                    import_statement5=import_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, import_statement5.getTree());


                    if ( state.backtracking==0 ) { sb.append(";\n"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:59:13: register_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_register_statement_in_statement140);
                    register_statement6=register_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, register_statement6.getTree());


                    if ( state.backtracking==0 ) { sb.append(";\n"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:60:13: assert_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_statement_in_statement156);
                    assert_statement7=assert_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_statement7.getTree());


                    if ( state.backtracking==0 ) { sb.append(";\n"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:61:13: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement172);
                    realias_statement8=realias_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, realias_statement8.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:64:1: split_statement : split_clause ;
    public final AstPrinter.split_statement_return split_statement() throws RecognitionException {
        AstPrinter.split_statement_return retval = new AstPrinter.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.split_clause_return split_clause9 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:64:17: ( split_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:64:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement181);
            split_clause9=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause9.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_statement"


    public static class realias_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:67:1: realias_statement : realias_clause ;
    public final AstPrinter.realias_statement_return realias_statement() throws RecognitionException {
        AstPrinter.realias_statement_return retval = new AstPrinter.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.realias_clause_return realias_clause10 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:67:19: ( realias_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:67:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement190);
            realias_clause10=realias_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, realias_clause10.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_statement"


    public static class import_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "import_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:70:1: import_statement : ^( IMPORT QUOTEDSTRING ) ;
    public final AstPrinter.import_statement_return import_statement() throws RecognitionException {
        AstPrinter.import_statement_return retval = new AstPrinter.import_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT11=null;
        CommonTree QUOTEDSTRING12=null;

        CommonTree IMPORT11_tree=null;
        CommonTree QUOTEDSTRING12_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:70:18: ( ^( IMPORT QUOTEDSTRING ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:70:20: ^( IMPORT QUOTEDSTRING )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IMPORT11=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_import_statement201); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IMPORT11_tree = (CommonTree)adaptor.dupNode(IMPORT11);


            root_1 = (CommonTree)adaptor.becomeRoot(IMPORT11_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING12=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_import_statement203); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING12_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING12);


            adaptor.addChild(root_1, QUOTEDSTRING12_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                                   sb.append(" ").append((IMPORT11!=null?IMPORT11.getText():null)).append(" ").append((QUOTEDSTRING12!=null?QUOTEDSTRING12.getText():null));
                               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "import_statement"


    public static class register_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "register_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:75:1: register_statement : ^( REGISTER QUOTEDSTRING ( scripting_udf_clause )? ) ;
    public final AstPrinter.register_statement_return register_statement() throws RecognitionException {
        AstPrinter.register_statement_return retval = new AstPrinter.register_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REGISTER13=null;
        CommonTree QUOTEDSTRING14=null;
        AstPrinter.scripting_udf_clause_return scripting_udf_clause15 =null;


        CommonTree REGISTER13_tree=null;
        CommonTree QUOTEDSTRING14_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:75:20: ( ^( REGISTER QUOTEDSTRING ( scripting_udf_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:75:22: ^( REGISTER QUOTEDSTRING ( scripting_udf_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REGISTER13=(CommonTree)match(input,REGISTER,FOLLOW_REGISTER_in_register_statement218); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REGISTER13_tree = (CommonTree)adaptor.dupNode(REGISTER13);


            root_1 = (CommonTree)adaptor.becomeRoot(REGISTER13_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING14=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_register_statement220); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING14_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING14);


            adaptor.addChild(root_1, QUOTEDSTRING14_tree);
            }


            if ( state.backtracking==0 ) {
                                        sb.append((REGISTER13!=null?REGISTER13.getText():null)).append(" ").append((QUOTEDSTRING14!=null?QUOTEDSTRING14.getText():null));
                                    }

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:77:27: ( scripting_udf_clause )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==USING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:77:27: scripting_udf_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scripting_udf_clause_in_register_statement224);
                    scripting_udf_clause15=scripting_udf_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, scripting_udf_clause15.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "register_statement"


    public static class assert_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:80:1: assert_statement : assert_clause ;
    public final AstPrinter.assert_statement_return assert_statement() throws RecognitionException {
        AstPrinter.assert_statement_return retval = new AstPrinter.assert_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.assert_clause_return assert_clause16 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:80:18: ( assert_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:80:20: assert_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assert_clause_in_assert_statement236);
            assert_clause16=assert_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, assert_clause16.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assert_statement"


    public static class scripting_udf_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scripting_udf_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:83:1: scripting_udf_clause : scripting_language_clause scripting_namespace_clause ;
    public final AstPrinter.scripting_udf_clause_return scripting_udf_clause() throws RecognitionException {
        AstPrinter.scripting_udf_clause_return retval = new AstPrinter.scripting_udf_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.scripting_language_clause_return scripting_language_clause17 =null;

        AstPrinter.scripting_namespace_clause_return scripting_namespace_clause18 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:83:22: ( scripting_language_clause scripting_namespace_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:83:24: scripting_language_clause scripting_namespace_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_scripting_language_clause_in_scripting_udf_clause245);
            scripting_language_clause17=scripting_language_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, scripting_language_clause17.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_scripting_namespace_clause_in_scripting_udf_clause247);
            scripting_namespace_clause18=scripting_namespace_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, scripting_namespace_clause18.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "scripting_udf_clause"


    public static class scripting_language_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scripting_language_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:86:1: scripting_language_clause : ( USING IDENTIFIER ) ;
    public final AstPrinter.scripting_language_clause_return scripting_language_clause() throws RecognitionException {
        AstPrinter.scripting_language_clause_return retval = new AstPrinter.scripting_language_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree USING19=null;
        CommonTree IDENTIFIER20=null;

        CommonTree USING19_tree=null;
        CommonTree IDENTIFIER20_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:86:27: ( ( USING IDENTIFIER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:86:29: ( USING IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:86:29: ( USING IDENTIFIER )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:86:30: USING IDENTIFIER
            {
            _last = (CommonTree)input.LT(1);
            USING19=(CommonTree)match(input,USING,FOLLOW_USING_in_scripting_language_clause257); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            USING19_tree = (CommonTree)adaptor.dupNode(USING19);


            adaptor.addChild(root_0, USING19_tree);
            }


            _last = (CommonTree)input.LT(1);
            IDENTIFIER20=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_scripting_language_clause259); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER20_tree = (CommonTree)adaptor.dupNode(IDENTIFIER20);


            adaptor.addChild(root_0, IDENTIFIER20_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }


            if ( state.backtracking==0 ) {
                                            sb.append(" ").append((USING19!=null?USING19.getText():null)).append(" ").append((IDENTIFIER20!=null?IDENTIFIER20.getText():null));
                                        }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "scripting_language_clause"


    public static class scripting_namespace_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scripting_namespace_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:91:1: scripting_namespace_clause : ( AS IDENTIFIER ) ;
    public final AstPrinter.scripting_namespace_clause_return scripting_namespace_clause() throws RecognitionException {
        AstPrinter.scripting_namespace_clause_return retval = new AstPrinter.scripting_namespace_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS21=null;
        CommonTree IDENTIFIER22=null;

        CommonTree AS21_tree=null;
        CommonTree IDENTIFIER22_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:91:28: ( ( AS IDENTIFIER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:91:30: ( AS IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:91:30: ( AS IDENTIFIER )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:91:31: AS IDENTIFIER
            {
            _last = (CommonTree)input.LT(1);
            AS21=(CommonTree)match(input,AS,FOLLOW_AS_in_scripting_namespace_clause272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS21_tree = (CommonTree)adaptor.dupNode(AS21);


            adaptor.addChild(root_0, AS21_tree);
            }


            _last = (CommonTree)input.LT(1);
            IDENTIFIER22=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_scripting_namespace_clause274); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER22_tree = (CommonTree)adaptor.dupNode(IDENTIFIER22);


            adaptor.addChild(root_0, IDENTIFIER22_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }


            if ( state.backtracking==0 ) {
                                             sb.append(" ").append((AS21!=null?AS21.getText():null)).append(" ").append((IDENTIFIER22!=null?IDENTIFIER22.getText():null));
                                         }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "scripting_namespace_clause"


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:97:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AstPrinter.general_statement_return general_statement() throws RecognitionException {
        AstPrinter.general_statement_return retval = new AstPrinter.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT23=null;
        AstPrinter.alias_return alias24 =null;

        AstPrinter.op_clause_return op_clause25 =null;

        AstPrinter.parallel_clause_return parallel_clause26 =null;


        CommonTree STATEMENT23_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:98:5: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:98:7: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT23=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement293); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT23_tree = (CommonTree)adaptor.dupNode(STATEMENT23);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT23_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:98:20: ( alias )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENTIFIER) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:98:22: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement297);
                    alias24=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias24.getTree());


                    if ( state.backtracking==0 ) { sb.append(" = "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement312);
            op_clause25=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause25.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:99:19: ( parallel_clause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PARALLEL) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:99:19: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement314);
                    parallel_clause26=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause26.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append(";\n"); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "general_statement"


    public static class realias_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:102:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AstPrinter.realias_clause_return realias_clause() throws RecognitionException {
        AstPrinter.realias_clause_return retval = new AstPrinter.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS27=null;
        CommonTree IDENTIFIER29=null;
        AstPrinter.alias_return alias28 =null;


        CommonTree REALIAS27_tree=null;
        CommonTree IDENTIFIER29_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:102:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:102:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS27=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause329); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS27_tree = (CommonTree)adaptor.dupNode(REALIAS27);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS27_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause331);
            alias28=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias28.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER29=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause333); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER29_tree = (CommonTree)adaptor.dupNode(IDENTIFIER29);


            adaptor.addChild(root_1, IDENTIFIER29_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_clause"


    public static class parallel_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parallel_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:105:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AstPrinter.parallel_clause_return parallel_clause() throws RecognitionException {
        AstPrinter.parallel_clause_return retval = new AstPrinter.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL30=null;
        CommonTree INTEGER31=null;

        CommonTree PARALLEL30_tree=null;
        CommonTree INTEGER31_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:106:5: ( ^( PARALLEL INTEGER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:106:7: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL30=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause349); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL30_tree = (CommonTree)adaptor.dupNode(PARALLEL30);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL30_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER31=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause351); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER31_tree = (CommonTree)adaptor.dupNode(INTEGER31);


            adaptor.addChild(root_1, INTEGER31_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((PARALLEL30!=null?PARALLEL30.getText():null)).append(" ").append((INTEGER31!=null?INTEGER31.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parallel_clause"


    public static class pivot_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pivot_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:109:1: pivot_clause : ^( PIVOT INTEGER ) ;
    public final AstPrinter.pivot_clause_return pivot_clause() throws RecognitionException {
        AstPrinter.pivot_clause_return retval = new AstPrinter.pivot_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PIVOT32=null;
        CommonTree INTEGER33=null;

        CommonTree PIVOT32_tree=null;
        CommonTree INTEGER33_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:110:5: ( ^( PIVOT INTEGER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:110:7: ^( PIVOT INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PIVOT32=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_pivot_clause370); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PIVOT32_tree = (CommonTree)adaptor.dupNode(PIVOT32);


            root_1 = (CommonTree)adaptor.becomeRoot(PIVOT32_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER33=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_pivot_clause372); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER33_tree = (CommonTree)adaptor.dupNode(INTEGER33);


            adaptor.addChild(root_1, INTEGER33_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((PIVOT32!=null?PIVOT32.getText():null)).append(" ").append((INTEGER33!=null?INTEGER33.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pivot_clause"


    public static class alias_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:113:1: alias : IDENTIFIER ;
    public final AstPrinter.alias_return alias() throws RecognitionException {
        AstPrinter.alias_return retval = new AstPrinter.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER34=null;

        CommonTree IDENTIFIER34_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:114:5: ( IDENTIFIER )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:114:7: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER34=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias389); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER34_tree = (CommonTree)adaptor.dupNode(IDENTIFIER34);


            adaptor.addChild(root_0, IDENTIFIER34_tree);
            }


            if ( state.backtracking==0 ) { sb.append((IDENTIFIER34!=null?IDENTIFIER34.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias"


    public static class op_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:117:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause );
    public final AstPrinter.op_clause_return op_clause() throws RecognitionException {
        AstPrinter.op_clause_return retval = new AstPrinter.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.define_clause_return define_clause35 =null;

        AstPrinter.load_clause_return load_clause36 =null;

        AstPrinter.group_clause_return group_clause37 =null;

        AstPrinter.store_clause_return store_clause38 =null;

        AstPrinter.filter_clause_return filter_clause39 =null;

        AstPrinter.distinct_clause_return distinct_clause40 =null;

        AstPrinter.limit_clause_return limit_clause41 =null;

        AstPrinter.sample_clause_return sample_clause42 =null;

        AstPrinter.order_clause_return order_clause43 =null;

        AstPrinter.rank_clause_return rank_clause44 =null;

        AstPrinter.cross_clause_return cross_clause45 =null;

        AstPrinter.join_clause_return join_clause46 =null;

        AstPrinter.union_clause_return union_clause47 =null;

        AstPrinter.stream_clause_return stream_clause48 =null;

        AstPrinter.mr_clause_return mr_clause49 =null;

        AstPrinter.split_clause_return split_clause50 =null;

        AstPrinter.foreach_clause_return foreach_clause51 =null;

        AstPrinter.cube_clause_return cube_clause52 =null;

        AstPrinter.assert_clause_return assert_clause53 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:117:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause )
            int alt6=19;
            switch ( input.LA(1) ) {
            case DEFINE:
                {
                alt6=1;
                }
                break;
            case LOAD:
                {
                alt6=2;
                }
                break;
            case COGROUP:
            case GROUP:
                {
                alt6=3;
                }
                break;
            case STORE:
                {
                alt6=4;
                }
                break;
            case FILTER:
                {
                alt6=5;
                }
                break;
            case DISTINCT:
                {
                alt6=6;
                }
                break;
            case LIMIT:
                {
                alt6=7;
                }
                break;
            case SAMPLE:
                {
                alt6=8;
                }
                break;
            case ORDER:
                {
                alt6=9;
                }
                break;
            case RANK:
                {
                alt6=10;
                }
                break;
            case CROSS:
                {
                alt6=11;
                }
                break;
            case JOIN:
                {
                alt6=12;
                }
                break;
            case UNION:
                {
                alt6=13;
                }
                break;
            case STREAM:
                {
                alt6=14;
                }
                break;
            case MAPREDUCE:
                {
                alt6=15;
                }
                break;
            case SPLIT:
                {
                alt6=16;
                }
                break;
            case FOREACH:
                {
                alt6=17;
                }
                break;
            case CUBE:
                {
                alt6=18;
                }
                break;
            case ASSERT:
                {
                alt6=19;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:117:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause400);
                    define_clause35=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause35.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:118:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause414);
                    load_clause36=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause36.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:119:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause428);
                    group_clause37=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause37.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:120:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause442);
                    store_clause38=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause38.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:121:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause456);
                    filter_clause39=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause39.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:122:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause470);
                    distinct_clause40=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause40.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:123:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause484);
                    limit_clause41=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause41.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:124:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause498);
                    sample_clause42=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause42.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:125:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause512);
                    order_clause43=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause43.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:126:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause526);
                    rank_clause44=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause44.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:127:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause540);
                    cross_clause45=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause45.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:128:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause554);
                    join_clause46=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause46.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:129:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause568);
                    union_clause47=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause47.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:130:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause582);
                    stream_clause48=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause48.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:131:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause596);
                    mr_clause49=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause49.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:132:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause610);
                    split_clause50=split_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_clause50.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:133:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause624);
                    foreach_clause51=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause51.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:134:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause638);
                    cube_clause52=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause52.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:135:13: assert_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_clause_in_op_clause652);
                    assert_clause53=assert_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_clause53.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "op_clause"


    public static class define_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "define_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:138:1: define_clause : ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) ;
    public final AstPrinter.define_clause_return define_clause() throws RecognitionException {
        AstPrinter.define_clause_return retval = new AstPrinter.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE54=null;
        CommonTree IDENTIFIER55=null;
        AstPrinter.cmd_return cmd56 =null;

        AstPrinter.func_clause_return func_clause57 =null;


        CommonTree DEFINE54_tree=null;
        CommonTree IDENTIFIER55_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:139:5: ( ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:139:7: ^( DEFINE IDENTIFIER ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE54=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause667); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE54_tree = (CommonTree)adaptor.dupNode(DEFINE54);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE54_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER55=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_define_clause669); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER55_tree = (CommonTree)adaptor.dupNode(IDENTIFIER55);


            adaptor.addChild(root_1, IDENTIFIER55_tree);
            }


            if ( state.backtracking==0 ) { sb.append((DEFINE54!=null?DEFINE54.getText():null)).append(" ").append((IDENTIFIER55!=null?IDENTIFIER55.getText():null)).append(" "); }

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:140:9: ( cmd | func_clause )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==EXECCOMMAND) ) {
                alt7=1;
            }
            else if ( (LA7_0==FUNC||LA7_0==FUNC_REF) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:140:11: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause683);
                    cmd56=cmd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd56.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:140:17: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause687);
                    func_clause57=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause57.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "define_clause"


    public static class cmd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cmd"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:143:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AstPrinter.cmd_return cmd() throws RecognitionException {
        AstPrinter.cmd_return retval = new AstPrinter.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND58=null;
        AstPrinter.ship_clause_return ship_clause59 =null;

        AstPrinter.cache_clause_return cache_clause60 =null;

        AstPrinter.input_clause_return input_clause61 =null;

        AstPrinter.output_clause_return output_clause62 =null;

        AstPrinter.error_clause_return error_clause63 =null;


        CommonTree EXECCOMMAND58_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:144:5: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:144:7: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND58=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd706); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND58_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND58);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND58_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((EXECCOMMAND58!=null?EXECCOMMAND58.getText():null)); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:145:9: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
                loop8:
                do {
                    int alt8=6;
                    switch ( input.LA(1) ) {
                    case SHIP:
                        {
                        alt8=1;
                        }
                        break;
                    case CACHE:
                        {
                        alt8=2;
                        }
                        break;
                    case INPUT:
                        {
                        alt8=3;
                        }
                        break;
                    case OUTPUT:
                        {
                        alt8=4;
                        }
                        break;
                    case STDERROR:
                        {
                        alt8=5;
                        }
                        break;

                    }

                    switch (alt8) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:145:11: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd720);
                	    ship_clause59=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause59.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:145:25: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd724);
                	    cache_clause60=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause60.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:145:40: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd728);
                	    input_clause61=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause61.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:145:55: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd732);
                	    output_clause62=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause62.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:145:71: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd736);
                	    error_clause63=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause63.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop8;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cmd"


    public static class ship_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ship_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:148:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AstPrinter.ship_clause_return ship_clause() throws RecognitionException {
        AstPrinter.ship_clause_return retval = new AstPrinter.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP64=null;
        AstPrinter.path_list_return path_list65 =null;


        CommonTree SHIP64_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:149:5: ( ^( SHIP ( path_list )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:149:7: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP64=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause756); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP64_tree = (CommonTree)adaptor.dupNode(SHIP64);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP64_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((SHIP64!=null?SHIP64.getText():null)).append(" ("); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:149:67: ( path_list )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:149:67: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause760);
                        path_list65=path_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list65.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                if ( state.backtracking==0 ) { sb.append(")"); }

                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ship_clause"


    public static class path_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "path_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:152:1: path_list : a= QUOTEDSTRING (b= QUOTEDSTRING )* ;
    public final AstPrinter.path_list_return path_list() throws RecognitionException {
        AstPrinter.path_list_return retval = new AstPrinter.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree a=null;
        CommonTree b=null;

        CommonTree a_tree=null;
        CommonTree b_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:153:5: (a= QUOTEDSTRING (b= QUOTEDSTRING )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:153:7: a= QUOTEDSTRING (b= QUOTEDSTRING )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            a=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list780); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (CommonTree)adaptor.dupNode(a);


            adaptor.addChild(root_0, a_tree);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((a!=null?a.getText():null)); }

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:154:9: (b= QUOTEDSTRING )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:154:10: b= QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    b=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list795); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    b_tree = (CommonTree)adaptor.dupNode(b);


            	    adaptor.addChild(root_0, b_tree);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", ").append((b!=null?b.getText():null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "path_list"


    public static class cache_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cache_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:157:1: cache_clause : ^( CACHE path_list ) ;
    public final AstPrinter.cache_clause_return cache_clause() throws RecognitionException {
        AstPrinter.cache_clause_return retval = new AstPrinter.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE66=null;
        AstPrinter.path_list_return path_list67 =null;


        CommonTree CACHE66_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:158:5: ( ^( CACHE path_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:158:7: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE66=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause815); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE66_tree = (CommonTree)adaptor.dupNode(CACHE66);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE66_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((CACHE66!=null?CACHE66.getText():null)).append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause819);
            path_list67=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list67.getTree());


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cache_clause"


    public static class input_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:161:1: input_clause : ^( INPUT stream_cmd ( stream_cmd )* ) ;
    public final AstPrinter.input_clause_return input_clause() throws RecognitionException {
        AstPrinter.input_clause_return retval = new AstPrinter.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT68=null;
        AstPrinter.stream_cmd_return stream_cmd69 =null;

        AstPrinter.stream_cmd_return stream_cmd70 =null;


        CommonTree INPUT68_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:162:5: ( ^( INPUT stream_cmd ( stream_cmd )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:162:7: ^( INPUT stream_cmd ( stream_cmd )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT68=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause838); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT68_tree = (CommonTree)adaptor.dupNode(INPUT68);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT68_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((INPUT68!=null?INPUT68.getText():null)).append("("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_stream_cmd_in_input_clause850);
            stream_cmd69=stream_cmd();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, stream_cmd69.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:163:20: ( stream_cmd )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==QUOTEDSTRING||(LA11_0 >= STDIN && LA11_0 <= STDOUT)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:163:22: stream_cmd
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause856);
            	    stream_cmd70=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd70.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "input_clause"


    public static class stream_cmd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:166:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AstPrinter.stream_cmd_return stream_cmd() throws RecognitionException {
        AstPrinter.stream_cmd_return retval = new AstPrinter.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN71=null;
        CommonTree STDOUT73=null;
        CommonTree QUOTEDSTRING75=null;
        AstPrinter.func_clause_return func_clause72 =null;

        AstPrinter.func_clause_return func_clause74 =null;

        AstPrinter.func_clause_return func_clause76 =null;


        CommonTree STDIN71_tree=null;
        CommonTree STDOUT73_tree=null;
        CommonTree QUOTEDSTRING75_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:167:5: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case STDIN:
                {
                alt15=1;
                }
                break;
            case STDOUT:
                {
                alt15=2;
                }
                break;
            case QUOTEDSTRING:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:167:7: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN71=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd877); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN71_tree = (CommonTree)adaptor.dupNode(STDIN71);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN71_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDIN71!=null?STDIN71.getText():null)).append(" USING "); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:167:62: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:167:62: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd881);
                                func_clause72=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause72.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:168:7: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT73=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd894); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT73_tree = (CommonTree)adaptor.dupNode(STDOUT73);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT73_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDOUT73!=null?STDOUT73.getText():null)).append(" USING "); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:168:64: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:168:64: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd898);
                                func_clause74=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause74.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:169:7: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING75=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd911); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING75_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING75);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING75_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING75!=null?QUOTEDSTRING75.getText():null)).append(" USING "); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:169:76: ( func_clause )?
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==FUNC||LA14_0==FUNC_REF) ) {
                            alt14=1;
                        }
                        switch (alt14) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:169:76: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd915);
                                func_clause76=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause76.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_cmd"


    public static class output_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:172:1: output_clause : ^( OUTPUT stream_cmd ( stream_cmd )* ) ;
    public final AstPrinter.output_clause_return output_clause() throws RecognitionException {
        AstPrinter.output_clause_return retval = new AstPrinter.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT77=null;
        AstPrinter.stream_cmd_return stream_cmd78 =null;

        AstPrinter.stream_cmd_return stream_cmd79 =null;


        CommonTree OUTPUT77_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:173:5: ( ^( OUTPUT stream_cmd ( stream_cmd )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:173:7: ^( OUTPUT stream_cmd ( stream_cmd )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT77=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause933); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT77_tree = (CommonTree)adaptor.dupNode(OUTPUT77);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT77_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((OUTPUT77!=null?OUTPUT77.getText():null)).append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_stream_cmd_in_output_clause946);
            stream_cmd78=stream_cmd();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, stream_cmd78.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:174:20: ( stream_cmd )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==QUOTEDSTRING||(LA16_0 >= STDIN && LA16_0 <= STDOUT)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:174:22: stream_cmd
            	    {
            	    if ( state.backtracking==0 ) { sb.append(","); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause952);
            	    stream_cmd79=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd79.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "output_clause"


    public static class error_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:177:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AstPrinter.error_clause_return error_clause() throws RecognitionException {
        AstPrinter.error_clause_return retval = new AstPrinter.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR80=null;
        CommonTree QUOTEDSTRING81=null;
        CommonTree INTEGER82=null;

        CommonTree STDERROR80_tree=null;
        CommonTree QUOTEDSTRING81_tree=null;
        CommonTree INTEGER82_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:178:5: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:178:7: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR80=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause973); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR80_tree = (CommonTree)adaptor.dupNode(STDERROR80);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR80_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((STDERROR80!=null?STDERROR80.getText():null)).append(" ("); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:179:9: ( QUOTEDSTRING ( INTEGER )? )?
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==QUOTEDSTRING) ) {
                    alt18=1;
                }
                switch (alt18) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:179:11: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING81=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause987); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING81_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING81);


                        adaptor.addChild(root_1, QUOTEDSTRING81_tree);
                        }


                        if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING81!=null?QUOTEDSTRING81.getText():null)); }

                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:179:59: ( INTEGER )?
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==INTEGER) ) {
                            alt17=1;
                        }
                        switch (alt17) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:179:60: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER82=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause992); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER82_tree = (CommonTree)adaptor.dupNode(INTEGER82);


                                adaptor.addChild(root_1, INTEGER82_tree);
                                }


                                if ( state.backtracking==0 ) { sb.append(" LIMIT ").append(INTEGER82); }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                if ( state.backtracking==0 ) { sb.append(")"); }

                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "error_clause"


    public static class load_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:182:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AstPrinter.load_clause_return load_clause() throws RecognitionException {
        AstPrinter.load_clause_return retval = new AstPrinter.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD83=null;
        AstPrinter.filename_return filename84 =null;

        AstPrinter.func_clause_return func_clause85 =null;

        AstPrinter.as_clause_return as_clause86 =null;


        CommonTree LOAD83_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:183:5: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:183:7: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD83=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause1019); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD83_tree = (CommonTree)adaptor.dupNode(LOAD83);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD83_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((LOAD83!=null?LOAD83.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause1023);
            filename84=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename84.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:184:9: ( func_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==FUNC||LA19_0==FUNC_REF) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:184:11: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause1037);
                    func_clause85=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause85.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:184:51: ( as_clause )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==AS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:184:51: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause1041);
                    as_clause86=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause86.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "load_clause"


    public static class filename_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:187:1: filename : QUOTEDSTRING ;
    public final AstPrinter.filename_return filename() throws RecognitionException {
        AstPrinter.filename_return retval = new AstPrinter.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING87=null;

        CommonTree QUOTEDSTRING87_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:188:5: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:188:7: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING87=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename1057); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING87_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING87);


            adaptor.addChild(root_0, QUOTEDSTRING87_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING87!=null?QUOTEDSTRING87.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filename"


    public static class as_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:191:1: as_clause : ^( AS field_def_list ) ;
    public final AstPrinter.as_clause_return as_clause() throws RecognitionException {
        AstPrinter.as_clause_return retval = new AstPrinter.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS88=null;
        AstPrinter.field_def_list_return field_def_list89 =null;


        CommonTree AS88_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:192:5: ( ^( AS field_def_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:192:7: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS88=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause1074); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS88_tree = (CommonTree)adaptor.dupNode(AS88);


            root_1 = (CommonTree)adaptor.becomeRoot(AS88_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((AS88!=null?AS88.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause1078);
            field_def_list89=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list89.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "as_clause"


    public static class field_def_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:195:1: field_def : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF type ) );
    public final AstPrinter.field_def_return field_def() throws RecognitionException {
        AstPrinter.field_def_return retval = new AstPrinter.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF90=null;
        CommonTree IDENTIFIER91=null;
        CommonTree FIELD_DEF93=null;
        AstPrinter.type_return type92 =null;

        AstPrinter.type_return type94 =null;


        CommonTree FIELD_DEF90_tree=null;
        CommonTree IDENTIFIER91_tree=null;
        CommonTree FIELD_DEF93_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:196:5: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF type ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==FIELD_DEF) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==DOWN) ) {
                    int LA22_2 = input.LA(3);

                    if ( (LA22_2==IDENTIFIER) ) {
                        alt22=1;
                    }
                    else if ( (LA22_2==BIGDECIMAL||LA22_2==BIGINTEGER||LA22_2==BOOLEAN||LA22_2==BYTEARRAY||LA22_2==CHARARRAY||LA22_2==DATETIME||LA22_2==DOUBLE||LA22_2==FLOAT||LA22_2==INT||LA22_2==LONG||LA22_2==BAG_TYPE||LA22_2==MAP_TYPE||LA22_2==TUPLE_TYPE) ) {
                        alt22=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:196:7: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF90=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def1095); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF90_tree = (CommonTree)adaptor.dupNode(FIELD_DEF90);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF90_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER91=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def1097); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER91_tree = (CommonTree)adaptor.dupNode(IDENTIFIER91);


                    adaptor.addChild(root_1, IDENTIFIER91_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER91!=null?IDENTIFIER91.getText():null)); }

                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:196:65: ( type )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==BIGDECIMAL||LA21_0==BIGINTEGER||LA21_0==BOOLEAN||LA21_0==BYTEARRAY||LA21_0==CHARARRAY||LA21_0==DATETIME||LA21_0==DOUBLE||LA21_0==FLOAT||LA21_0==INT||LA21_0==LONG||LA21_0==BAG_TYPE||LA21_0==MAP_TYPE||LA21_0==TUPLE_TYPE) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:196:67: type
                            {
                            if ( state.backtracking==0 ) {sb.append(":"); }

                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def1107);
                            type92=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type92.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:197:7: ^( FIELD_DEF type )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF93=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def1121); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF93_tree = (CommonTree)adaptor.dupNode(FIELD_DEF93);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF93_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def1123);
                    type94=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type94.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def"


    public static class field_def_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:200:1: field_def_list : ( field_def ( field_def )+ | field_def );
    public final AstPrinter.field_def_list_return field_def_list() throws RecognitionException {
        AstPrinter.field_def_list_return retval = new AstPrinter.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.field_def_return field_def95 =null;

        AstPrinter.field_def_return field_def96 =null;

        AstPrinter.field_def_return field_def97 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:201:5: ( field_def ( field_def )+ | field_def )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==FIELD_DEF) ) {
                int LA24_1 = input.LA(2);

                if ( (synpred50_AstPrinter()) ) {
                    alt24=1;
                }
                else if ( (true) ) {
                    alt24=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }
            switch (alt24) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:201:7: field_def ( field_def )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    if ( state.backtracking==0 ) { sb.append("("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_in_field_def_list1140);
                    field_def95=field_def();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def95.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:201:37: ( field_def )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==FIELD_DEF) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:201:39: field_def
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_field_def_in_field_def_list1146);
                    	    field_def96=field_def();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, field_def96.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:202:7: field_def
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_in_field_def_list1159);
                    field_def97=field_def();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def97.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:205:1: type : ( simple_type | tuple_type | bag_type | map_type );
    public final AstPrinter.type_return type() throws RecognitionException {
        AstPrinter.type_return retval = new AstPrinter.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.simple_type_return simple_type98 =null;

        AstPrinter.tuple_type_return tuple_type99 =null;

        AstPrinter.bag_type_return bag_type100 =null;

        AstPrinter.map_type_return map_type101 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:205:6: ( simple_type | tuple_type | bag_type | map_type )
            int alt25=4;
            switch ( input.LA(1) ) {
            case BIGDECIMAL:
            case BIGINTEGER:
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DATETIME:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt25=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt25=2;
                }
                break;
            case BAG_TYPE:
                {
                alt25=3;
                }
                break;
            case MAP_TYPE:
                {
                alt25=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:205:8: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type1168);
                    simple_type98=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type98.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:205:22: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type1172);
                    tuple_type99=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type99.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:205:35: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type1176);
                    bag_type100=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type100.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:205:46: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type1180);
                    map_type101=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type101.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class simple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:208:1: simple_type : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY );
    public final AstPrinter.simple_type_return simple_type() throws RecognitionException {
        AstPrinter.simple_type_return retval = new AstPrinter.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN102=null;
        CommonTree INT103=null;
        CommonTree LONG104=null;
        CommonTree FLOAT105=null;
        CommonTree DOUBLE106=null;
        CommonTree BIGINTEGER107=null;
        CommonTree BIGDECIMAL108=null;
        CommonTree DATETIME109=null;
        CommonTree CHARARRAY110=null;
        CommonTree BYTEARRAY111=null;

        CommonTree BOOLEAN102_tree=null;
        CommonTree INT103_tree=null;
        CommonTree LONG104_tree=null;
        CommonTree FLOAT105_tree=null;
        CommonTree DOUBLE106_tree=null;
        CommonTree BIGINTEGER107_tree=null;
        CommonTree BIGDECIMAL108_tree=null;
        CommonTree DATETIME109_tree=null;
        CommonTree CHARARRAY110_tree=null;
        CommonTree BYTEARRAY111_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:209:5: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY )
            int alt26=10;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt26=1;
                }
                break;
            case INT:
                {
                alt26=2;
                }
                break;
            case LONG:
                {
                alt26=3;
                }
                break;
            case FLOAT:
                {
                alt26=4;
                }
                break;
            case DOUBLE:
                {
                alt26=5;
                }
                break;
            case BIGINTEGER:
                {
                alt26=6;
                }
                break;
            case BIGDECIMAL:
                {
                alt26=7;
                }
                break;
            case DATETIME:
                {
                alt26=8;
                }
                break;
            case CHARARRAY:
                {
                alt26=9;
                }
                break;
            case BYTEARRAY:
                {
                alt26=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:209:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN102=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1193); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN102_tree = (CommonTree)adaptor.dupNode(BOOLEAN102);


                    adaptor.addChild(root_0, BOOLEAN102_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BOOLEAN102!=null?BOOLEAN102.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:210:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT103=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1203); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT103_tree = (CommonTree)adaptor.dupNode(INT103);


                    adaptor.addChild(root_0, INT103_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INT103!=null?INT103.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:211:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG104=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1213); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG104_tree = (CommonTree)adaptor.dupNode(LONG104);


                    adaptor.addChild(root_0, LONG104_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LONG104!=null?LONG104.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:212:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT105=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1223); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT105_tree = (CommonTree)adaptor.dupNode(FLOAT105);


                    adaptor.addChild(root_0, FLOAT105_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLOAT105!=null?FLOAT105.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:213:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE106=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1233); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE106_tree = (CommonTree)adaptor.dupNode(DOUBLE106);


                    adaptor.addChild(root_0, DOUBLE106_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DOUBLE106!=null?DOUBLE106.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:214:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER107=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_simple_type1243); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER107_tree = (CommonTree)adaptor.dupNode(BIGINTEGER107);


                    adaptor.addChild(root_0, BIGINTEGER107_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGINTEGER107!=null?BIGINTEGER107.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:215:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL108=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_simple_type1253); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL108_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL108);


                    adaptor.addChild(root_0, BIGDECIMAL108_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGDECIMAL108!=null?BIGDECIMAL108.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:216:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME109=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1263); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME109_tree = (CommonTree)adaptor.dupNode(DATETIME109);


                    adaptor.addChild(root_0, DATETIME109_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DATETIME109!=null?DATETIME109.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:217:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY110=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1273); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY110_tree = (CommonTree)adaptor.dupNode(CHARARRAY110);


                    adaptor.addChild(root_0, CHARARRAY110_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CHARARRAY110!=null?CHARARRAY110.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:218:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY111=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1283); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY111_tree = (CommonTree)adaptor.dupNode(BYTEARRAY111);


                    adaptor.addChild(root_0, BYTEARRAY111_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BYTEARRAY111!=null?BYTEARRAY111.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:221:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AstPrinter.tuple_type_return tuple_type() throws RecognitionException {
        AstPrinter.tuple_type_return retval = new AstPrinter.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE112=null;
        AstPrinter.field_def_list_return field_def_list113 =null;


        CommonTree TUPLE_TYPE112_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:222:5: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:222:7: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE112=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1300); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE112_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE112);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE112_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:222:21: ( field_def_list )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==FIELD_DEF) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:222:21: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1302);
                        field_def_list113=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list113.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type"


    public static class bag_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:225:1: bag_type : ^( BAG_TYPE ( ( IDENTIFIER )? tuple_type )? ) ;
    public final AstPrinter.bag_type_return bag_type() throws RecognitionException {
        AstPrinter.bag_type_return retval = new AstPrinter.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE114=null;
        CommonTree IDENTIFIER115=null;
        AstPrinter.tuple_type_return tuple_type116 =null;


        CommonTree BAG_TYPE114_tree=null;
        CommonTree IDENTIFIER115_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:226:5: ( ^( BAG_TYPE ( ( IDENTIFIER )? tuple_type )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:226:7: ^( BAG_TYPE ( ( IDENTIFIER )? tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE114=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1320); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE114_tree = (CommonTree)adaptor.dupNode(BAG_TYPE114);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE114_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append("bag{"); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:226:42: ( ( IDENTIFIER )? tuple_type )?
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==IDENTIFIER||LA29_0==TUPLE_TYPE) ) {
                    alt29=1;
                }
                switch (alt29) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:226:44: ( IDENTIFIER )? tuple_type
                        {
                        if ( state.backtracking==0 ) { sb.append("T:"); }

                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:226:65: ( IDENTIFIER )?
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==IDENTIFIER) ) {
                            alt28=1;
                        }
                        switch (alt28) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:226:65: IDENTIFIER
                                {
                                _last = (CommonTree)input.LT(1);
                                IDENTIFIER115=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1328); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                IDENTIFIER115_tree = (CommonTree)adaptor.dupNode(IDENTIFIER115);


                                adaptor.addChild(root_1, IDENTIFIER115_tree);
                                }


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1331);
                        tuple_type116=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type116.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append("}"); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:229:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AstPrinter.map_type_return map_type() throws RecognitionException {
        AstPrinter.map_type_return retval = new AstPrinter.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE117=null;
        AstPrinter.type_return type118 =null;


        CommonTree MAP_TYPE117_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:229:10: ( ^( MAP_TYPE ( type )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:229:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE117=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1349); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE117_tree = (CommonTree)adaptor.dupNode(MAP_TYPE117);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE117_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append("map["); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:229:47: ( type )?
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==BIGDECIMAL||LA30_0==BIGINTEGER||LA30_0==BOOLEAN||LA30_0==BYTEARRAY||LA30_0==CHARARRAY||LA30_0==DATETIME||LA30_0==DOUBLE||LA30_0==FLOAT||LA30_0==INT||LA30_0==LONG||LA30_0==BAG_TYPE||LA30_0==MAP_TYPE||LA30_0==TUPLE_TYPE) ) {
                    alt30=1;
                }
                switch (alt30) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:229:47: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1353);
                        type118=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type118.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append("]"); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_type"


    public static class func_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:232:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AstPrinter.func_clause_return func_clause() throws RecognitionException {
        AstPrinter.func_clause_return retval = new AstPrinter.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF119=null;
        CommonTree FUNC121=null;
        AstPrinter.func_name_return func_name120 =null;

        AstPrinter.func_name_return func_name122 =null;

        AstPrinter.func_args_return func_args123 =null;


        CommonTree FUNC_REF119_tree=null;
        CommonTree FUNC121_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:233:5: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==FUNC_REF) ) {
                alt32=1;
            }
            else if ( (LA32_0==FUNC) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;

            }
            switch (alt32) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:233:7: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF119=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1373); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF119_tree = (CommonTree)adaptor.dupNode(FUNC_REF119);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF119_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1375);
                    func_name120=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name120.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:234:7: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC121=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1387); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC121_tree = (CommonTree)adaptor.dupNode(FUNC121);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC121_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1389);
                    func_name122=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name122.getTree());


                    if ( state.backtracking==0 ) { sb.append("("); }

                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:234:45: ( func_args )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==MULTILINE_QUOTEDSTRING||LA31_0==QUOTEDSTRING) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:234:45: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1393);
                            func_args123=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args123.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_clause"


    public static class func_name_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_name"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:237:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AstPrinter.func_name_return func_name() throws RecognitionException {
        AstPrinter.func_name_return retval = new AstPrinter.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD125=null;
        CommonTree DOLLAR126=null;
        AstPrinter.eid_return eid124 =null;

        AstPrinter.eid_return eid127 =null;


        CommonTree PERIOD125_tree=null;
        CommonTree DOLLAR126_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:238:5: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:238:7: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1411);
            eid124=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid124.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:238:11: ( ( PERIOD | DOLLAR ) eid )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==DOLLAR||LA34_0==PERIOD) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:238:13: ( PERIOD | DOLLAR ) eid
            	    {
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:238:13: ( PERIOD | DOLLAR )
            	    int alt33=2;
            	    int LA33_0 = input.LA(1);

            	    if ( (LA33_0==PERIOD) ) {
            	        alt33=1;
            	    }
            	    else if ( (LA33_0==DOLLAR) ) {
            	        alt33=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 33, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt33) {
            	        case 1 :
            	            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:238:15: PERIOD
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            PERIOD125=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_func_name1417); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PERIOD125_tree = (CommonTree)adaptor.dupNode(PERIOD125);


            	            adaptor.addChild(root_0, PERIOD125_tree);
            	            }


            	            if ( state.backtracking==0 ) { sb.append((PERIOD125!=null?PERIOD125.getText():null)); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;
            	        case 2 :
            	            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:238:53: DOLLAR
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            DOLLAR126=(CommonTree)match(input,DOLLAR,FOLLOW_DOLLAR_in_func_name1423); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DOLLAR126_tree = (CommonTree)adaptor.dupNode(DOLLAR126);


            	            adaptor.addChild(root_0, DOLLAR126_tree);
            	            }


            	            if ( state.backtracking==0 ) { sb.append((DOLLAR126!=null?DOLLAR126.getText():null)); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;

            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1429);
            	    eid127=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid127.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_name"


    public static class func_args_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:241:1: func_args : func_first_arg_clause ( func_next_arg_clause )* ;
    public final AstPrinter.func_args_return func_args() throws RecognitionException {
        AstPrinter.func_args_return retval = new AstPrinter.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.func_first_arg_clause_return func_first_arg_clause128 =null;

        AstPrinter.func_next_arg_clause_return func_next_arg_clause129 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:241:11: ( func_first_arg_clause ( func_next_arg_clause )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:241:13: func_first_arg_clause ( func_next_arg_clause )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_first_arg_clause_in_func_args1441);
            func_first_arg_clause128=func_first_arg_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, func_first_arg_clause128.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:241:35: ( func_next_arg_clause )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==MULTILINE_QUOTEDSTRING||LA35_0==QUOTEDSTRING) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:241:36: func_next_arg_clause
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_func_next_arg_clause_in_func_args1444);
            	    func_next_arg_clause129=func_next_arg_clause();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, func_next_arg_clause129.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_args"


    public static class func_first_arg_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_first_arg_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:244:1: func_first_arg_clause : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING );
    public final AstPrinter.func_first_arg_clause_return func_first_arg_clause() throws RecognitionException {
        AstPrinter.func_first_arg_clause_return retval = new AstPrinter.func_first_arg_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING130=null;
        CommonTree MULTILINE_QUOTEDSTRING131=null;

        CommonTree QUOTEDSTRING130_tree=null;
        CommonTree MULTILINE_QUOTEDSTRING131_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:244:23: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==QUOTEDSTRING) ) {
                alt36=1;
            }
            else if ( (LA36_0==MULTILINE_QUOTEDSTRING) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:244:27: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING130=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_first_arg_clause1457); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING130_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING130);


                    adaptor.addChild(root_0, QUOTEDSTRING130_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING130!=null?QUOTEDSTRING130.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:245:27: MULTILINE_QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MULTILINE_QUOTEDSTRING131=(CommonTree)match(input,MULTILINE_QUOTEDSTRING,FOLLOW_MULTILINE_QUOTEDSTRING_in_func_first_arg_clause1487); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MULTILINE_QUOTEDSTRING131_tree = (CommonTree)adaptor.dupNode(MULTILINE_QUOTEDSTRING131);


                    adaptor.addChild(root_0, MULTILINE_QUOTEDSTRING131_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MULTILINE_QUOTEDSTRING131!=null?MULTILINE_QUOTEDSTRING131.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_first_arg_clause"


    public static class func_next_arg_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_next_arg_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:248:1: func_next_arg_clause : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING );
    public final AstPrinter.func_next_arg_clause_return func_next_arg_clause() throws RecognitionException {
        AstPrinter.func_next_arg_clause_return retval = new AstPrinter.func_next_arg_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING132=null;
        CommonTree MULTILINE_QUOTEDSTRING133=null;

        CommonTree QUOTEDSTRING132_tree=null;
        CommonTree MULTILINE_QUOTEDSTRING133_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:248:22: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==QUOTEDSTRING) ) {
                alt37=1;
            }
            else if ( (LA37_0==MULTILINE_QUOTEDSTRING) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:248:27: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING132=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_next_arg_clause1501); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING132_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING132);


                    adaptor.addChild(root_0, QUOTEDSTRING132_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(", ").append((QUOTEDSTRING132!=null?QUOTEDSTRING132.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:249:27: MULTILINE_QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MULTILINE_QUOTEDSTRING133=(CommonTree)match(input,MULTILINE_QUOTEDSTRING,FOLLOW_MULTILINE_QUOTEDSTRING_in_func_next_arg_clause1531); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MULTILINE_QUOTEDSTRING133_tree = (CommonTree)adaptor.dupNode(MULTILINE_QUOTEDSTRING133);


                    adaptor.addChild(root_0, MULTILINE_QUOTEDSTRING133_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(", ").append((MULTILINE_QUOTEDSTRING133!=null?MULTILINE_QUOTEDSTRING133.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_next_arg_clause"


    public static class cube_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:252:1: cube_clause : ^( CUBE cube_item ) ;
    public final AstPrinter.cube_clause_return cube_clause() throws RecognitionException {
        AstPrinter.cube_clause_return retval = new AstPrinter.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE134=null;
        AstPrinter.cube_item_return cube_item135 =null;


        CommonTree CUBE134_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:253:5: ( ^( CUBE cube_item ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:253:7: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE134=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1548); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE134_tree = (CommonTree)adaptor.dupNode(CUBE134);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE134_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((CUBE134!=null?CUBE134.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1552);
            cube_item135=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item135.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_clause"


    public static class cube_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_item"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:256:1: cube_item : rel ( cube_by_clause ) ;
    public final AstPrinter.cube_item_return cube_item() throws RecognitionException {
        AstPrinter.cube_item_return retval = new AstPrinter.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.rel_return rel136 =null;

        AstPrinter.cube_by_clause_return cube_by_clause137 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:257:5: ( rel ( cube_by_clause ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:257:7: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1567);
            rel136=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel136.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:257:11: ( cube_by_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:257:13: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1571);
            cube_by_clause137=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause137.getTree());


            if ( state.backtracking==0 ) {
            }
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_item"


    public static class cube_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:260:1: cube_by_clause : ^( BY cube_or_rollup ) ;
    public final AstPrinter.cube_by_clause_return cube_by_clause() throws RecognitionException {
        AstPrinter.cube_by_clause_return retval = new AstPrinter.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY138=null;
        AstPrinter.cube_or_rollup_return cube_or_rollup139 =null;


        CommonTree BY138_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:261:5: ( ^( BY cube_or_rollup ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:261:7: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY138=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1588); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY138_tree = (CommonTree)adaptor.dupNode(BY138);


            root_1 = (CommonTree)adaptor.becomeRoot(BY138_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((BY138!=null?BY138.getText():null)); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1592);
            cube_or_rollup139=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup139.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_clause"


    public static class cube_or_rollup_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_or_rollup"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:264:1: cube_or_rollup : cube_rollup_list ( cube_rollup_list )* ;
    public final AstPrinter.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        AstPrinter.cube_or_rollup_return retval = new AstPrinter.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.cube_rollup_list_return cube_rollup_list140 =null;

        AstPrinter.cube_rollup_list_return cube_rollup_list141 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:265:5: ( cube_rollup_list ( cube_rollup_list )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:265:7: cube_rollup_list ( cube_rollup_list )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1607);
            cube_rollup_list140=cube_rollup_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_rollup_list140.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:265:24: ( cube_rollup_list )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==CUBE||LA38_0==ROLLUP) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:265:26: cube_rollup_list
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1613);
            	    cube_rollup_list141=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list141.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_or_rollup"


    public static class cube_rollup_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:268:1: cube_rollup_list : ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ) );
    public final AstPrinter.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        AstPrinter.cube_rollup_list_return retval = new AstPrinter.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE142=null;
        CommonTree ROLLUP144=null;
        AstPrinter.cube_by_expr_list_return cube_by_expr_list143 =null;

        AstPrinter.cube_by_expr_list_return cube_by_expr_list145 =null;


        CommonTree CUBE142_tree=null;
        CommonTree ROLLUP144_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:269:5: ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==CUBE) ) {
                alt39=1;
            }
            else if ( (LA39_0==ROLLUP) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }
            switch (alt39) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:269:7: ^( CUBE cube_by_expr_list )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CUBE142=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_rollup_list1631); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE142_tree = (CommonTree)adaptor.dupNode(CUBE142);


                    root_1 = (CommonTree)adaptor.becomeRoot(CUBE142_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((CUBE142!=null?CUBE142.getText():null)).append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1635);
                    cube_by_expr_list143=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list143.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:269:96: ^( ROLLUP cube_by_expr_list )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    ROLLUP144=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_cube_rollup_list1645); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP144_tree = (CommonTree)adaptor.dupNode(ROLLUP144);


                    root_1 = (CommonTree)adaptor.becomeRoot(ROLLUP144_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((ROLLUP144!=null?ROLLUP144.getText():null)).append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1649);
                    cube_by_expr_list145=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list145.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_rollup_list"


    public static class cube_by_expr_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:272:1: cube_by_expr_list : ( cube_by_expr ( cube_by_expr )* ) ;
    public final AstPrinter.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        AstPrinter.cube_by_expr_list_return retval = new AstPrinter.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.cube_by_expr_return cube_by_expr146 =null;

        AstPrinter.cube_by_expr_return cube_by_expr147 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:273:5: ( ( cube_by_expr ( cube_by_expr )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:273:7: ( cube_by_expr ( cube_by_expr )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:273:7: ( cube_by_expr ( cube_by_expr )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:273:9: cube_by_expr ( cube_by_expr )*
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1668);
            cube_by_expr146=cube_by_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_expr146.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:273:22: ( cube_by_expr )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==BIGDECIMALNUMBER||LA40_0==BIGINTEGERNUMBER||LA40_0==CUBE||LA40_0==DIV||LA40_0==DOLLARVAR||LA40_0==DOUBLENUMBER||LA40_0==FALSE||LA40_0==FLOATNUMBER||LA40_0==GROUP||LA40_0==IDENTIFIER||LA40_0==INTEGER||LA40_0==LONGINTEGER||LA40_0==MINUS||LA40_0==NULL||LA40_0==PERCENT||LA40_0==PLUS||LA40_0==QUOTEDSTRING||LA40_0==STAR||LA40_0==TRUE||(LA40_0 >= BAG_VAL && LA40_0 <= BIN_EXPR)||(LA40_0 >= CASE_COND && LA40_0 <= CASE_EXPR)||(LA40_0 >= CAST_EXPR && LA40_0 <= EXPR_IN_PAREN)||LA40_0==FUNC_EVAL||(LA40_0 >= MAP_VAL && LA40_0 <= NEG)||LA40_0==TUPLE_VAL) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:273:24: cube_by_expr
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1674);
            	    cube_by_expr147=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr147.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_expr_list"


    public static class cube_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:276:1: cube_by_expr : ( col_range | expr | STAR );
    public final AstPrinter.cube_by_expr_return cube_by_expr() throws RecognitionException {
        AstPrinter.cube_by_expr_return retval = new AstPrinter.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR150=null;
        AstPrinter.col_range_return col_range148 =null;

        AstPrinter.expr_return expr149 =null;


        CommonTree STAR150_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:277:5: ( col_range | expr | STAR )
            int alt41=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt41=1;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt41=2;
                }
                break;
            case STAR:
                {
                int LA41_3 = input.LA(2);

                if ( (LA41_3==DOWN) ) {
                    alt41=2;
                }
                else if ( (LA41_3==EOF||LA41_3==UP||LA41_3==BIGDECIMALNUMBER||LA41_3==BIGINTEGERNUMBER||LA41_3==CUBE||LA41_3==DIV||LA41_3==DOLLARVAR||LA41_3==DOUBLENUMBER||LA41_3==FALSE||LA41_3==FLOATNUMBER||LA41_3==GROUP||LA41_3==IDENTIFIER||LA41_3==INTEGER||LA41_3==LONGINTEGER||LA41_3==MINUS||LA41_3==NULL||LA41_3==PERCENT||LA41_3==PLUS||LA41_3==QUOTEDSTRING||LA41_3==STAR||LA41_3==TRUE||(LA41_3 >= BAG_VAL && LA41_3 <= BIN_EXPR)||(LA41_3 >= CASE_COND && LA41_3 <= CASE_EXPR)||(LA41_3 >= CAST_EXPR && LA41_3 <= EXPR_IN_PAREN)||LA41_3==FUNC_EVAL||(LA41_3 >= MAP_VAL && LA41_3 <= NEG)||LA41_3==TUPLE_VAL) ) {
                    alt41=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }

            switch (alt41) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:277:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1692);
                    col_range148=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range148.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:277:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1696);
                    expr149=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr149.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:277:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR150=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1700); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR150_tree = (CommonTree)adaptor.dupNode(STAR150);


                    adaptor.addChild(root_0, STAR150_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR150!=null?STAR150.getText():null)); }

                    if ( state.backtracking==0 ) { sb.append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_expr"


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:280:1: group_clause : ^( ( GROUP | COGROUP ) group_item ( group_item )* ( group_type )? ( partition_clause )? ) ;
    public final AstPrinter.group_clause_return group_clause() throws RecognitionException {
        AstPrinter.group_clause_return retval = new AstPrinter.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP151=null;
        CommonTree COGROUP152=null;
        AstPrinter.group_item_return group_item153 =null;

        AstPrinter.group_item_return group_item154 =null;

        AstPrinter.group_type_return group_type155 =null;

        AstPrinter.partition_clause_return partition_clause156 =null;


        CommonTree GROUP151_tree=null;
        CommonTree COGROUP152_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:281:5: ( ^( ( GROUP | COGROUP ) group_item ( group_item )* ( group_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:281:7: ^( ( GROUP | COGROUP ) group_item ( group_item )* ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:281:10: ( GROUP | COGROUP )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==GROUP) ) {
                alt42=1;
            }
            else if ( (LA42_0==COGROUP) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }
            switch (alt42) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:281:12: GROUP
                    {
                    _last = (CommonTree)input.LT(1);
                    GROUP151=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_group_clause1721); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP151_tree = (CommonTree)adaptor.dupNode(GROUP151);


                    adaptor.addChild(root_1, GROUP151_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP151!=null?GROUP151.getText():null)).append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:281:60: COGROUP
                    {
                    _last = (CommonTree)input.LT(1);
                    COGROUP152=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_group_clause1727); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP152_tree = (CommonTree)adaptor.dupNode(COGROUP152);


                    adaptor.addChild(root_1, COGROUP152_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((COGROUP152!=null?COGROUP152.getText():null)).append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_group_item_in_group_clause1741);
            group_item153=group_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, group_item153.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:282:20: ( group_item )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==ASSERT||LA43_0==COGROUP||(LA43_0 >= CROSS && LA43_0 <= CUBE)||LA43_0==DEFINE||LA43_0==DISTINCT||LA43_0==FILTER||LA43_0==FOREACH||LA43_0==GROUP||LA43_0==IDENTIFIER||LA43_0==JOIN||(LA43_0 >= LIMIT && LA43_0 <= LOAD)||LA43_0==MAPREDUCE||LA43_0==ORDER||LA43_0==RANK||LA43_0==SAMPLE||LA43_0==SPLIT||(LA43_0 >= STORE && LA43_0 <= STREAM)||LA43_0==UNION) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:282:22: group_item
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1747);
            	    group_item154=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item154.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:283:7: ( group_type )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==QUOTEDSTRING) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:283:9: group_type
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1762);
                    group_type155=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type155.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:284:7: ( partition_clause )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==PARTITION) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:284:7: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1773);
                    partition_clause156=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause156.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:288:1: group_type : QUOTEDSTRING ;
    public final AstPrinter.group_type_return group_type() throws RecognitionException {
        AstPrinter.group_type_return retval = new AstPrinter.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING157=null;

        CommonTree QUOTEDSTRING157_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:288:12: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:288:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING157=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1789); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING157_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING157);


            adaptor.addChild(root_0, QUOTEDSTRING157_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING157!=null?QUOTEDSTRING157.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_type"


    public static class group_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_item"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:291:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AstPrinter.group_item_return group_item() throws RecognitionException {
        AstPrinter.group_item_return retval = new AstPrinter.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL160=null;
        CommonTree ANY161=null;
        CommonTree INNER162=null;
        CommonTree OUTER163=null;
        AstPrinter.rel_return rel158 =null;

        AstPrinter.join_group_by_clause_return join_group_by_clause159 =null;


        CommonTree ALL160_tree=null;
        CommonTree ANY161_tree=null;
        CommonTree INNER162_tree=null;
        CommonTree OUTER163_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:292:5: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:292:7: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1804);
            rel158=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel158.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:292:11: ( join_group_by_clause | ALL | ANY )
            int alt46=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt46=1;
                }
                break;
            case ALL:
                {
                alt46=2;
                }
                break;
            case ANY:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:292:13: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1808);
                    join_group_by_clause159=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause159.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:293:15: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL160=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1824); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL160_tree = (CommonTree)adaptor.dupNode(ALL160);


                    adaptor.addChild(root_0, ALL160_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ALL160!=null?ALL160.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:293:59: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY161=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1830); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY161_tree = (CommonTree)adaptor.dupNode(ANY161);


                    adaptor.addChild(root_0, ANY161_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ANY161!=null?ANY161.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:294:13: ( INNER | OUTER )?
            int alt47=3;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==INNER) ) {
                alt47=1;
            }
            else if ( (LA47_0==OUTER) ) {
                alt47=2;
            }
            switch (alt47) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:294:15: INNER
                    {
                    _last = (CommonTree)input.LT(1);
                    INNER162=(CommonTree)match(input,INNER,FOLLOW_INNER_in_group_item1850); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER162_tree = (CommonTree)adaptor.dupNode(INNER162);


                    adaptor.addChild(root_0, INNER162_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((INNER162!=null?INNER162.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:294:63: OUTER
                    {
                    _last = (CommonTree)input.LT(1);
                    OUTER163=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_group_item1856); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER163_tree = (CommonTree)adaptor.dupNode(OUTER163);


                    adaptor.addChild(root_0, OUTER163_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((OUTER163!=null?OUTER163.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:297:1: rel : ( alias | ( op_clause ( parallel_clause )? ) );
    public final AstPrinter.rel_return rel() throws RecognitionException {
        AstPrinter.rel_return retval = new AstPrinter.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.alias_return alias164 =null;

        AstPrinter.op_clause_return op_clause165 =null;

        AstPrinter.parallel_clause_return parallel_clause166 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:298:5: ( alias | ( op_clause ( parallel_clause )? ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==IDENTIFIER) ) {
                alt49=1;
            }
            else if ( (LA49_0==ASSERT||LA49_0==COGROUP||(LA49_0 >= CROSS && LA49_0 <= CUBE)||LA49_0==DEFINE||LA49_0==DISTINCT||LA49_0==FILTER||LA49_0==FOREACH||LA49_0==GROUP||LA49_0==JOIN||(LA49_0 >= LIMIT && LA49_0 <= LOAD)||LA49_0==MAPREDUCE||LA49_0==ORDER||LA49_0==RANK||LA49_0==SAMPLE||LA49_0==SPLIT||(LA49_0 >= STORE && LA49_0 <= STREAM)||LA49_0==UNION) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }
            switch (alt49) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:298:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1874);
                    alias164=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias164.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:299:7: ( op_clause ( parallel_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:299:7: ( op_clause ( parallel_clause )? )
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:299:9: op_clause ( parallel_clause )?
                    {
                    if ( state.backtracking==0 ) { sb.append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1886);
                    op_clause165=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause165.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:299:40: ( parallel_clause )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==PARALLEL) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:299:40: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1888);
                            parallel_clause166=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause166.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append(") "); }

                    if ( state.backtracking==0 ) {
                    }
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:302:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AstPrinter.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AstPrinter.flatten_generated_item_return retval = new AstPrinter.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR170=null;
        AstPrinter.flatten_clause_return flatten_clause167 =null;

        AstPrinter.col_range_return col_range168 =null;

        AstPrinter.expr_return expr169 =null;

        AstPrinter.field_def_list_return field_def_list171 =null;


        CommonTree STAR170_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:303:5: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:303:7: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:303:7: ( flatten_clause | col_range | expr | STAR )
            int alt50=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt50=1;
                }
                break;
            case COL_RANGE:
                {
                alt50=2;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt50=3;
                }
                break;
            case STAR:
                {
                int LA50_4 = input.LA(2);

                if ( (LA50_4==DOWN) ) {
                    alt50=3;
                }
                else if ( (LA50_4==EOF||LA50_4==UP||LA50_4==BIGDECIMALNUMBER||LA50_4==BIGINTEGERNUMBER||LA50_4==CUBE||LA50_4==DIV||LA50_4==DOLLARVAR||LA50_4==DOUBLENUMBER||LA50_4==FALSE||LA50_4==FLATTEN||LA50_4==FLOATNUMBER||LA50_4==GROUP||LA50_4==IDENTIFIER||LA50_4==INTEGER||LA50_4==LONGINTEGER||LA50_4==MINUS||LA50_4==NULL||LA50_4==PERCENT||LA50_4==PLUS||LA50_4==QUOTEDSTRING||LA50_4==STAR||LA50_4==TRUE||(LA50_4 >= BAG_VAL && LA50_4 <= BIN_EXPR)||(LA50_4 >= CASE_COND && LA50_4 <= CASE_EXPR)||(LA50_4 >= CAST_EXPR && LA50_4 <= FIELD_DEF)||LA50_4==FUNC_EVAL||(LA50_4 >= MAP_VAL && LA50_4 <= NEG)||LA50_4==TUPLE_VAL) ) {
                    alt50=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }

            switch (alt50) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:303:9: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1908);
                    flatten_clause167=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause167.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:303:26: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1912);
                    col_range168=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range168.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:303:38: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1916);
                    expr169=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr169.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:303:45: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR170=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1920); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR170_tree = (CommonTree)adaptor.dupNode(STAR170);


                    adaptor.addChild(root_0, STAR170_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((STAR170!=null?STAR170.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:303:91: ( field_def_list )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==FIELD_DEF) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:303:93: field_def_list
                    {
                    if ( state.backtracking==0 ) { sb.append(" AS "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1930);
                    field_def_list171=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list171.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_generated_item"


    public static class flatten_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:306:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AstPrinter.flatten_clause_return flatten_clause() throws RecognitionException {
        AstPrinter.flatten_clause_return retval = new AstPrinter.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN172=null;
        AstPrinter.expr_return expr173 =null;


        CommonTree FLATTEN172_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:307:5: ( ^( FLATTEN expr ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:307:7: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN172=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1947); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN172_tree = (CommonTree)adaptor.dupNode(FLATTEN172);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN172_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FLATTEN172!=null?FLATTEN172.getText():null)).append("("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1951);
            expr173=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr173.getTree());


            if ( state.backtracking==0 ) { sb.append(") "); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_clause"


    public static class store_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:310:1: store_clause : ^( STORE rel filename ( func_clause )? ) ;
    public final AstPrinter.store_clause_return store_clause() throws RecognitionException {
        AstPrinter.store_clause_return retval = new AstPrinter.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE174=null;
        AstPrinter.rel_return rel175 =null;

        AstPrinter.filename_return filename176 =null;

        AstPrinter.func_clause_return func_clause177 =null;


        CommonTree STORE174_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:311:5: ( ^( STORE rel filename ( func_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:311:7: ^( STORE rel filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE174=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1970); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE174_tree = (CommonTree)adaptor.dupNode(STORE174);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE174_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((STORE174!=null?STORE174.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause1974);
            rel175=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel175.getTree());


            if ( state.backtracking==0 ) { sb.append(" INTO "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1978);
            filename176=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename176.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:311:94: ( func_clause )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==FUNC||LA52_0==FUNC_REF) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:311:96: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1984);
                    func_clause177=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause177.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "store_clause"


    public static class comment_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comment"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:314:1: comment : QUOTEDSTRING ;
    public final AstPrinter.comment_return comment() throws RecognitionException {
        AstPrinter.comment_return retval = new AstPrinter.comment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING178=null;

        CommonTree QUOTEDSTRING178_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:315:5: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:315:7: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING178=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_comment2001); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING178_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING178);


            adaptor.addChild(root_0, QUOTEDSTRING178_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING178!=null?QUOTEDSTRING178.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "comment"


    public static class assert_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:318:1: assert_clause : ^( ASSERT rel cond ( comment )? ) ;
    public final AstPrinter.assert_clause_return assert_clause() throws RecognitionException {
        AstPrinter.assert_clause_return retval = new AstPrinter.assert_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSERT179=null;
        AstPrinter.rel_return rel180 =null;

        AstPrinter.cond_return cond181 =null;

        AstPrinter.comment_return comment182 =null;


        CommonTree ASSERT179_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:319:5: ( ^( ASSERT rel cond ( comment )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:319:7: ^( ASSERT rel cond ( comment )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSERT179=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause2018); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSERT179_tree = (CommonTree)adaptor.dupNode(ASSERT179);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSERT179_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((ASSERT179!=null?ASSERT179.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_assert_clause2022);
            rel180=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel180.getTree());


            if ( state.backtracking==0 ) {sb.append(" BY ("); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_assert_clause2026);
            cond181=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond181.getTree());


            if ( state.backtracking==0 ) { sb.append(")"); }

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:319:110: ( comment )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==QUOTEDSTRING) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:319:112: comment
                    {
                    if ( state.backtracking==0 ) { sb.append(" comment: "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comment_in_assert_clause2034);
                    comment182=comment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, comment182.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assert_clause"


    public static class filter_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:322:1: filter_clause : ^( FILTER rel cond ) ;
    public final AstPrinter.filter_clause_return filter_clause() throws RecognitionException {
        AstPrinter.filter_clause_return retval = new AstPrinter.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER183=null;
        AstPrinter.rel_return rel184 =null;

        AstPrinter.cond_return cond185 =null;


        CommonTree FILTER183_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:323:5: ( ^( FILTER rel cond ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:323:7: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER183=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause2054); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER183_tree = (CommonTree)adaptor.dupNode(FILTER183);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER183_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FILTER183!=null?FILTER183.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause2058);
            rel184=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel184.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY ("); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause2062);
            cond185=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond185.getTree());


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filter_clause"


    public static class cond_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cond"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:326:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) );
    public final AstPrinter.cond_return cond() throws RecognitionException {
        AstPrinter.cond_return retval = new AstPrinter.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR186=null;
        CommonTree AND189=null;
        CommonTree NOT192=null;
        CommonTree NULL194=null;
        CommonTree NOT196=null;
        CommonTree BOOL_COND202=null;
        AstPrinter.cond_return cond187 =null;

        AstPrinter.cond_return cond188 =null;

        AstPrinter.cond_return cond190 =null;

        AstPrinter.cond_return cond191 =null;

        AstPrinter.cond_return cond193 =null;

        AstPrinter.expr_return expr195 =null;

        AstPrinter.rel_op_return rel_op197 =null;

        AstPrinter.expr_return expr198 =null;

        AstPrinter.expr_return expr199 =null;

        AstPrinter.in_eval_return in_eval200 =null;

        AstPrinter.func_eval_return func_eval201 =null;

        AstPrinter.expr_return expr203 =null;


        CommonTree OR186_tree=null;
        CommonTree AND189_tree=null;
        CommonTree NOT192_tree=null;
        CommonTree NULL194_tree=null;
        CommonTree NOT196_tree=null;
        CommonTree BOOL_COND202_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:327:5: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) )
            int alt55=8;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt55=1;
                }
                break;
            case AND:
                {
                alt55=2;
                }
                break;
            case NOT:
                {
                alt55=3;
                }
                break;
            case NULL:
                {
                alt55=4;
                }
                break;
            case NUM_OP_EQ:
            case NUM_OP_GT:
            case NUM_OP_GTE:
            case NUM_OP_LT:
            case NUM_OP_LTE:
            case NUM_OP_NE:
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt55=5;
                }
                break;
            case IN:
                {
                alt55=6;
                }
                break;
            case FUNC_EVAL:
                {
                alt55=7;
                }
                break;
            case BOOL_COND:
                {
                alt55=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }

            switch (alt55) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:327:7: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR186=(CommonTree)match(input,OR,FOLLOW_OR_in_cond2081); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR186_tree = (CommonTree)adaptor.dupNode(OR186);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR186_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2085);
                    cond187=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond187.getTree());


                    if ( state.backtracking==0 ) { sb.append(") ").append((OR186!=null?OR186.getText():null)).append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2089);
                    cond188=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond188.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:328:7: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND189=(CommonTree)match(input,AND,FOLLOW_AND_in_cond2103); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND189_tree = (CommonTree)adaptor.dupNode(AND189);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND189_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2107);
                    cond190=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond190.getTree());


                    if ( state.backtracking==0 ) { sb.append(") ").append((AND189!=null?AND189.getText():null)).append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2111);
                    cond191=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond191.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:329:7: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT192=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2125); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT192_tree = (CommonTree)adaptor.dupNode(NOT192);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT192_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((NOT192!=null?NOT192.getText():null)).append(" ("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2129);
                    cond193=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond193.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:330:7: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL194=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond2143); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL194_tree = (CommonTree)adaptor.dupNode(NULL194);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL194_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2145);
                    expr195=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr195.getTree());


                    if ( state.backtracking==0 ) { sb.append(" IS "); }

                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:330:43: ( NOT )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==NOT) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:330:44: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT196=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2150); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT196_tree = (CommonTree)adaptor.dupNode(NOT196);


                            adaptor.addChild(root_1, NOT196_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append((NOT196!=null?NOT196.getText():null)).append(" "); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append((NULL194!=null?NULL194.getText():null)); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:331:7: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond2170);
                    rel_op197=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op197.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2172);
                    expr198=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr198.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((rel_op197!=null?rel_op197.result:null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2176);
                    expr199=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr199.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:332:7: in_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond2186);
                    in_eval200=in_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval200.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:333:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond2194);
                    func_eval201=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval201.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:334:7: ^( BOOL_COND expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND202=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond2204); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND202_tree = (CommonTree)adaptor.dupNode(BOOL_COND202);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND202_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2206);
                    expr203=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr203.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cond"


    public static class in_eval_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "in_eval"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:337:1: in_eval : ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) ) ( ^( IN_LHS expr ) ^( IN_RHS expr ) )* ) ;
    public final AstPrinter.in_eval_return in_eval() throws RecognitionException {
        AstPrinter.in_eval_return retval = new AstPrinter.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN204=null;
        CommonTree IN_LHS205=null;
        CommonTree IN_RHS207=null;
        CommonTree IN_LHS209=null;
        CommonTree IN_RHS211=null;
        AstPrinter.expr_return expr206 =null;

        AstPrinter.expr_return expr208 =null;

        AstPrinter.expr_return expr210 =null;

        AstPrinter.expr_return expr212 =null;


        CommonTree IN204_tree=null;
        CommonTree IN_LHS205_tree=null;
        CommonTree IN_RHS207_tree=null;
        CommonTree IN_LHS209_tree=null;
        CommonTree IN_RHS211_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:338:5: ( ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) ) ( ^( IN_LHS expr ) ^( IN_RHS expr ) )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:338:7: ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) ) ( ^( IN_LHS expr ) ^( IN_RHS expr ) )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN204=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval2223); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN204_tree = (CommonTree)adaptor.dupNode(IN204);


            root_1 = (CommonTree)adaptor.becomeRoot(IN204_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" " + (IN204!=null?IN204.getText():null) + "("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:339:10: ( ^( IN_LHS expr ) ^( IN_RHS expr ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:339:12: ^( IN_LHS expr ) ^( IN_RHS expr )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN_LHS205=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval2240); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN_LHS205_tree = (CommonTree)adaptor.dupNode(IN_LHS205);


            root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS205_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_in_eval2242);
            expr206=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_2, expr206.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN_RHS207=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval2248); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN_RHS207_tree = (CommonTree)adaptor.dupNode(IN_RHS207);


            root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS207_tree, root_2);
            }


            if ( state.backtracking==0 ) { sb.append(", "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_in_eval2252);
            expr208=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_2, expr208.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            if ( state.backtracking==0 ) {
            }
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:340:10: ( ^( IN_LHS expr ) ^( IN_RHS expr ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==IN_LHS) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:340:12: ^( IN_LHS expr ) ^( IN_RHS expr )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_LHS209=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval2271); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_LHS209_tree = (CommonTree)adaptor.dupNode(IN_LHS209);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS209_tree, root_2);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval2275);
            	    expr210=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr210.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_RHS211=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval2281); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_RHS211_tree = (CommonTree)adaptor.dupNode(IN_RHS211);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS211_tree, root_2);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval2286);
            	    expr212=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr212.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(") "); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "in_eval"


    public static class func_eval_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:343:1: func_eval : ( ^( FUNC_EVAL func_name real_arg ( real_arg )* ) | ^( FUNC_EVAL func_name ) );
    public final AstPrinter.func_eval_return func_eval() throws RecognitionException {
        AstPrinter.func_eval_return retval = new AstPrinter.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL213=null;
        CommonTree FUNC_EVAL217=null;
        AstPrinter.func_name_return func_name214 =null;

        AstPrinter.real_arg_return real_arg215 =null;

        AstPrinter.real_arg_return real_arg216 =null;

        AstPrinter.func_name_return func_name218 =null;


        CommonTree FUNC_EVAL213_tree=null;
        CommonTree FUNC_EVAL217_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:344:5: ( ^( FUNC_EVAL func_name real_arg ( real_arg )* ) | ^( FUNC_EVAL func_name ) )
            int alt58=2;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:344:7: ^( FUNC_EVAL func_name real_arg ( real_arg )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL213=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval2310); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL213_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL213);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL213_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval2312);
                    func_name214=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name214.getTree());


                    if ( state.backtracking==0 ) { sb.append("("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_real_arg_in_func_eval2316);
                    real_arg215=real_arg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, real_arg215.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:344:59: ( real_arg )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==BIGDECIMALNUMBER||LA57_0==BIGINTEGERNUMBER||LA57_0==CUBE||LA57_0==DIV||LA57_0==DOLLARVAR||LA57_0==DOUBLENUMBER||LA57_0==FALSE||LA57_0==FLOATNUMBER||LA57_0==GROUP||LA57_0==IDENTIFIER||LA57_0==INTEGER||LA57_0==LONGINTEGER||LA57_0==MINUS||LA57_0==NULL||LA57_0==PERCENT||LA57_0==PLUS||LA57_0==QUOTEDSTRING||LA57_0==STAR||LA57_0==TRUE||(LA57_0 >= BAG_VAL && LA57_0 <= BIN_EXPR)||(LA57_0 >= CASE_COND && LA57_0 <= CASE_EXPR)||(LA57_0 >= CAST_EXPR && LA57_0 <= EXPR_IN_PAREN)||LA57_0==FUNC_EVAL||(LA57_0 >= MAP_VAL && LA57_0 <= NEG)||LA57_0==TUPLE_VAL) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:344:61: real_arg
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval2322);
                    	    real_arg216=real_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg216.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:345:7: ^( FUNC_EVAL func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL217=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval2338); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL217_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL217);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL217_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval2340);
                    func_name218=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name218.getTree());


                    if ( state.backtracking==0 ) { sb.append("()"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:348:1: real_arg : ( expr | STAR | col_range );
    public final AstPrinter.real_arg_return real_arg() throws RecognitionException {
        AstPrinter.real_arg_return retval = new AstPrinter.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR220=null;
        AstPrinter.expr_return expr219 =null;

        AstPrinter.col_range_return col_range221 =null;


        CommonTree STAR220_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:349:5: ( expr | STAR | col_range )
            int alt59=3;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt59=1;
                }
                break;
            case STAR:
                {
                int LA59_2 = input.LA(2);

                if ( (LA59_2==DOWN) ) {
                    alt59=1;
                }
                else if ( (LA59_2==EOF||LA59_2==UP||LA59_2==BIGDECIMALNUMBER||LA59_2==BIGINTEGERNUMBER||LA59_2==CUBE||LA59_2==DIV||LA59_2==DOLLARVAR||LA59_2==DOUBLENUMBER||LA59_2==FALSE||LA59_2==FLOATNUMBER||LA59_2==GROUP||LA59_2==IDENTIFIER||LA59_2==INTEGER||LA59_2==LONGINTEGER||LA59_2==MINUS||LA59_2==NULL||LA59_2==PERCENT||LA59_2==PLUS||LA59_2==QUOTEDSTRING||LA59_2==STAR||LA59_2==TRUE||(LA59_2 >= BAG_VAL && LA59_2 <= BIN_EXPR)||(LA59_2 >= CASE_COND && LA59_2 <= CASE_EXPR)||(LA59_2 >= CAST_EXPR && LA59_2 <= EXPR_IN_PAREN)||LA59_2==FUNC_EVAL||(LA59_2 >= MAP_VAL && LA59_2 <= NEG)||LA59_2==TUPLE_VAL) ) {
                    alt59=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt59=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }

            switch (alt59) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:349:7: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg2358);
                    expr219=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr219.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:349:14: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR220=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg2362); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR220_tree = (CommonTree)adaptor.dupNode(STAR220);


                    adaptor.addChild(root_0, STAR220_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR220!=null?STAR220.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:349:48: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg2368);
                    col_range221=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range221.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "real_arg"


    public static class expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:352:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AstPrinter.expr_return expr() throws RecognitionException {
        AstPrinter.expr_return retval = new AstPrinter.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS222=null;
        CommonTree MINUS225=null;
        CommonTree STAR228=null;
        CommonTree DIV231=null;
        CommonTree PERCENT234=null;
        CommonTree CAST_EXPR237=null;
        CommonTree NEG242=null;
        CommonTree CAST_EXPR244=null;
        CommonTree EXPR_IN_PAREN247=null;
        AstPrinter.expr_return expr223 =null;

        AstPrinter.expr_return expr224 =null;

        AstPrinter.expr_return expr226 =null;

        AstPrinter.expr_return expr227 =null;

        AstPrinter.expr_return expr229 =null;

        AstPrinter.expr_return expr230 =null;

        AstPrinter.expr_return expr232 =null;

        AstPrinter.expr_return expr233 =null;

        AstPrinter.expr_return expr235 =null;

        AstPrinter.expr_return expr236 =null;

        AstPrinter.type_return type238 =null;

        AstPrinter.expr_return expr239 =null;

        AstPrinter.const_expr_return const_expr240 =null;

        AstPrinter.var_expr_return var_expr241 =null;

        AstPrinter.expr_return expr243 =null;

        AstPrinter.type_cast_return type_cast245 =null;

        AstPrinter.expr_return expr246 =null;

        AstPrinter.expr_return expr248 =null;


        CommonTree PLUS222_tree=null;
        CommonTree MINUS225_tree=null;
        CommonTree STAR228_tree=null;
        CommonTree DIV231_tree=null;
        CommonTree PERCENT234_tree=null;
        CommonTree CAST_EXPR237_tree=null;
        CommonTree NEG242_tree=null;
        CommonTree CAST_EXPR244_tree=null;
        CommonTree EXPR_IN_PAREN247_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:353:5: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt60=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt60=1;
                }
                break;
            case MINUS:
                {
                int LA60_2 = input.LA(2);

                if ( (synpred109_AstPrinter()) ) {
                    alt60=2;
                }
                else if ( (synpred114_AstPrinter()) ) {
                    alt60=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt60=3;
                }
                break;
            case DIV:
                {
                alt60=4;
                }
                break;
            case PERCENT:
                {
                alt60=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA60_6 = input.LA(2);

                if ( (synpred113_AstPrinter()) ) {
                    alt60=6;
                }
                else if ( (synpred117_AstPrinter()) ) {
                    alt60=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 6, input);

                    throw nvae;

                }
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case NULL:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case MAP_VAL:
            case TUPLE_VAL:
                {
                alt60=7;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case FUNC_EVAL:
                {
                alt60=8;
                }
                break;
            case NEG:
                {
                alt60=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt60=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }

            switch (alt60) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:353:7: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS222=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr2383); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS222_tree = (CommonTree)adaptor.dupNode(PLUS222);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS222_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2385);
                    expr223=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr223.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((PLUS222!=null?PLUS222.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2389);
                    expr224=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr224.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:354:7: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS225=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr2401); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS225_tree = (CommonTree)adaptor.dupNode(MINUS225);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS225_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2403);
                    expr226=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr226.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((MINUS225!=null?MINUS225.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2407);
                    expr227=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr227.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:355:7: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR228=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr2419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR228_tree = (CommonTree)adaptor.dupNode(STAR228);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR228_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2421);
                    expr229=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr229.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((STAR228!=null?STAR228.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2425);
                    expr230=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr230.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:356:7: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV231=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr2437); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV231_tree = (CommonTree)adaptor.dupNode(DIV231);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV231_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2439);
                    expr232=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr232.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((DIV231!=null?DIV231.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2443);
                    expr233=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr233.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:357:7: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT234=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr2455); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT234_tree = (CommonTree)adaptor.dupNode(PERCENT234);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT234_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2457);
                    expr235=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr235.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((PERCENT234!=null?PERCENT234.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2461);
                    expr236=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr236.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:358:7: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR237=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2473); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR237_tree = (CommonTree)adaptor.dupNode(CAST_EXPR237);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR237_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr2477);
                    type238=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type238.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2481);
                    expr239=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr239.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:359:7: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr2491);
                    const_expr240=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr240.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:360:7: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr2499);
                    var_expr241=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr241.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:361:7: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG242=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr2509); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG242_tree = (CommonTree)adaptor.dupNode(NEG242);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG242_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((NEG242!=null?NEG242.getText():null)); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2513);
                    expr243=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr243.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:362:7: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR244=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2525); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR244_tree = (CommonTree)adaptor.dupNode(CAST_EXPR244);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR244_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr2529);
                    type_cast245=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast245.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2533);
                    expr246=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr246.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:363:7: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN247=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr2545); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN247_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN247);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN247_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2549);
                    expr248=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr248.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_cast"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:366:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AstPrinter.type_cast_return type_cast() throws RecognitionException {
        AstPrinter.type_cast_return retval = new AstPrinter.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.simple_type_return simple_type249 =null;

        AstPrinter.map_type_return map_type250 =null;

        AstPrinter.tuple_type_cast_return tuple_type_cast251 =null;

        AstPrinter.bag_type_cast_return bag_type_cast252 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:367:5: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt61=4;
            switch ( input.LA(1) ) {
            case BIGDECIMAL:
            case BIGINTEGER:
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DATETIME:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt61=1;
                }
                break;
            case MAP_TYPE:
                {
                alt61=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt61=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt61=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }

            switch (alt61) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:367:7: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast2566);
                    simple_type249=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type249.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:367:21: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast2570);
                    map_type250=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type250.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:367:32: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast2574);
                    tuple_type_cast251=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast251.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:367:50: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast2578);
                    bag_type_cast252=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast252.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type_cast"


    public static class tuple_type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type_cast"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:370:1: tuple_type_cast : ( ^( TUPLE_TYPE_CAST type_cast ( type_cast )* ) | ^( TUPLE_TYPE_CAST ( type_cast )? ) );
    public final AstPrinter.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AstPrinter.tuple_type_cast_return retval = new AstPrinter.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST253=null;
        CommonTree TUPLE_TYPE_CAST256=null;
        AstPrinter.type_cast_return type_cast254 =null;

        AstPrinter.type_cast_return type_cast255 =null;

        AstPrinter.type_cast_return type_cast257 =null;


        CommonTree TUPLE_TYPE_CAST253_tree=null;
        CommonTree TUPLE_TYPE_CAST256_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:371:5: ( ^( TUPLE_TYPE_CAST type_cast ( type_cast )* ) | ^( TUPLE_TYPE_CAST ( type_cast )? ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==TUPLE_TYPE_CAST) ) {
                int LA64_1 = input.LA(2);

                if ( (synpred122_AstPrinter()) ) {
                    alt64=1;
                }
                else if ( (true) ) {
                    alt64=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }
            switch (alt64) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:371:7: ^( TUPLE_TYPE_CAST type_cast ( type_cast )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_TYPE_CAST253=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2593); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_TYPE_CAST253_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST253);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST253_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("tuple("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2597);
                    type_cast254=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast254.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:371:61: ( type_cast )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==BIGDECIMAL||LA62_0==BIGINTEGER||LA62_0==BOOLEAN||LA62_0==BYTEARRAY||LA62_0==CHARARRAY||LA62_0==DATETIME||LA62_0==DOUBLE||LA62_0==FLOAT||LA62_0==INT||LA62_0==LONG||LA62_0==BAG_TYPE_CAST||LA62_0==MAP_TYPE||LA62_0==TUPLE_TYPE_CAST) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:371:63: type_cast
                    	    {
                    	    if ( state.backtracking==0 ) {sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2603);
                    	    type_cast255=type_cast();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, type_cast255.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:372:7: ^( TUPLE_TYPE_CAST ( type_cast )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_TYPE_CAST256=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_TYPE_CAST256_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST256);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST256_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("tuple("); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:372:51: ( type_cast )?
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==BIGDECIMAL||LA63_0==BIGINTEGER||LA63_0==BOOLEAN||LA63_0==BYTEARRAY||LA63_0==CHARARRAY||LA63_0==DATETIME||LA63_0==DOUBLE||LA63_0==FLOAT||LA63_0==INT||LA63_0==LONG||LA63_0==BAG_TYPE_CAST||LA63_0==MAP_TYPE||LA63_0==TUPLE_TYPE_CAST) ) {
                            alt63=1;
                        }
                        switch (alt63) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:372:51: type_cast
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_type_cast_in_tuple_type_cast2623);
                                type_cast257=type_cast();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, type_cast257.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        if ( state.backtracking==0 ) {sb.append(")"); }

                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type_cast"


    public static class bag_type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:375:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AstPrinter.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AstPrinter.bag_type_cast_return retval = new AstPrinter.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST258=null;
        AstPrinter.tuple_type_cast_return tuple_type_cast259 =null;


        CommonTree BAG_TYPE_CAST258_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:376:5: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:376:7: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST258=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2643); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST258_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST258);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST258_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append("bag{"); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:376:47: ( tuple_type_cast )?
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==TUPLE_TYPE_CAST) ) {
                    alt65=1;
                }
                switch (alt65) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:376:47: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast2647);
                        tuple_type_cast259=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast259.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                if ( state.backtracking==0 ) {sb.append("}"); }

                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type_cast"


    public static class var_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:379:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AstPrinter.var_expr_return var_expr() throws RecognitionException {
        AstPrinter.var_expr_return retval = new AstPrinter.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.projectable_expr_return projectable_expr260 =null;

        AstPrinter.dot_proj_return dot_proj261 =null;

        AstPrinter.pound_proj_return pound_proj262 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:380:5: ( projectable_expr ( dot_proj | pound_proj )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:380:7: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr2665);
            projectable_expr260=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr260.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:380:24: ( dot_proj | pound_proj )*
            loop66:
            do {
                int alt66=3;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==PERIOD) ) {
                    alt66=1;
                }
                else if ( (LA66_0==POUND) ) {
                    alt66=2;
                }


                switch (alt66) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:380:26: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr2669);
            	    dot_proj261=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj261.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:380:37: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr2673);
            	    pound_proj262=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj262.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "var_expr"


    public static class projectable_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "projectable_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:383:1: projectable_expr : ( func_eval | col_ref | bin_expr | case_expr | case_cond );
    public final AstPrinter.projectable_expr_return projectable_expr() throws RecognitionException {
        AstPrinter.projectable_expr_return retval = new AstPrinter.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.func_eval_return func_eval263 =null;

        AstPrinter.col_ref_return col_ref264 =null;

        AstPrinter.bin_expr_return bin_expr265 =null;

        AstPrinter.case_expr_return case_expr266 =null;

        AstPrinter.case_cond_return case_cond267 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:384:5: ( func_eval | col_ref | bin_expr | case_expr | case_cond )
            int alt67=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
                {
                alt67=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt67=2;
                }
                break;
            case BIN_EXPR:
                {
                alt67=3;
                }
                break;
            case CASE_EXPR:
                {
                alt67=4;
                }
                break;
            case CASE_COND:
                {
                alt67=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }

            switch (alt67) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:384:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr2689);
                    func_eval263=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval263.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:384:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr2693);
                    col_ref264=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref264.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:384:29: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr2697);
                    bin_expr265=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr265.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:384:40: case_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr2701);
                    case_expr266=case_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr266.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:384:52: case_cond
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr2705);
                    case_cond267=case_cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond267.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "projectable_expr"


    public static class dot_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dot_proj"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:387:1: dot_proj : ^( PERIOD col_alias_or_index ( col_alias_or_index )* ) ;
    public final AstPrinter.dot_proj_return dot_proj() throws RecognitionException {
        AstPrinter.dot_proj_return retval = new AstPrinter.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD268=null;
        AstPrinter.col_alias_or_index_return col_alias_or_index269 =null;

        AstPrinter.col_alias_or_index_return col_alias_or_index270 =null;


        CommonTree PERIOD268_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:388:5: ( ^( PERIOD col_alias_or_index ( col_alias_or_index )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:388:7: ^( PERIOD col_alias_or_index ( col_alias_or_index )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD268=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj2720); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD268_tree = (CommonTree)adaptor.dupNode(PERIOD268);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD268_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(".("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2724);
            col_alias_or_index269=col_alias_or_index();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_alias_or_index269.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:388:57: ( col_alias_or_index )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==CUBE||LA68_0==DOLLARVAR||LA68_0==GROUP||LA68_0==IDENTIFIER) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:388:59: col_alias_or_index
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2730);
            	    col_alias_or_index270=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index270.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dot_proj"


    public static class col_alias_or_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:391:1: col_alias_or_index : ( col_alias | col_index );
    public final AstPrinter.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AstPrinter.col_alias_or_index_return retval = new AstPrinter.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.col_alias_return col_alias271 =null;

        AstPrinter.col_index_return col_index272 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:391:20: ( col_alias | col_index )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==CUBE||LA69_0==GROUP||LA69_0==IDENTIFIER) ) {
                alt69=1;
            }
            else if ( (LA69_0==DOLLARVAR) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;

            }
            switch (alt69) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:391:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index2746);
                    col_alias271=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias271.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:391:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index2750);
                    col_index272=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index272.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias_or_index"


    public static class col_alias_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:394:1: col_alias : ( GROUP | CUBE | IDENTIFIER );
    public final AstPrinter.col_alias_return col_alias() throws RecognitionException {
        AstPrinter.col_alias_return retval = new AstPrinter.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP273=null;
        CommonTree CUBE274=null;
        CommonTree IDENTIFIER275=null;

        CommonTree GROUP273_tree=null;
        CommonTree CUBE274_tree=null;
        CommonTree IDENTIFIER275_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:395:5: ( GROUP | CUBE | IDENTIFIER )
            int alt70=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt70=1;
                }
                break;
            case CUBE:
                {
                alt70=2;
                }
                break;
            case IDENTIFIER:
                {
                alt70=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }

            switch (alt70) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:395:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP273=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_col_alias2763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP273_tree = (CommonTree)adaptor.dupNode(GROUP273);


                    adaptor.addChild(root_0, GROUP273_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP273!=null?GROUP273.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:396:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE274=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_col_alias2773); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE274_tree = (CommonTree)adaptor.dupNode(CUBE274);


                    adaptor.addChild(root_0, CUBE274_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CUBE274!=null?CUBE274.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:397:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER275=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_col_alias2783); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER275_tree = (CommonTree)adaptor.dupNode(IDENTIFIER275);


                    adaptor.addChild(root_0, IDENTIFIER275_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER275!=null?IDENTIFIER275.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:400:1: col_index : DOLLARVAR ;
    public final AstPrinter.col_index_return col_index() throws RecognitionException {
        AstPrinter.col_index_return retval = new AstPrinter.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR276=null;

        CommonTree DOLLARVAR276_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:401:5: ( DOLLARVAR )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:401:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR276=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index2798); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR276_tree = (CommonTree)adaptor.dupNode(DOLLARVAR276);


            adaptor.addChild(root_0, DOLLARVAR276_tree);
            }


            if ( state.backtracking==0 ) { sb.append((DOLLARVAR276!=null?DOLLARVAR276.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_index"


    public static class col_range_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:404:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AstPrinter.col_range_return col_range() throws RecognitionException {
        AstPrinter.col_range_return retval = new AstPrinter.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE277=null;
        CommonTree DOUBLE_PERIOD279=null;
        AstPrinter.col_ref_return col_ref278 =null;

        AstPrinter.col_ref_return col_ref280 =null;


        CommonTree COL_RANGE277_tree=null;
        CommonTree DOUBLE_PERIOD279_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:404:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:404:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE277=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range2811); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE277_tree = (CommonTree)adaptor.dupNode(COL_RANGE277);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE277_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:404:26: ( col_ref )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==CUBE||LA71_0==DOLLARVAR||LA71_0==GROUP||LA71_0==IDENTIFIER) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:404:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2813);
                    col_ref278=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref278.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) { sb.append(".."); }

            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD279=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range2818); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD279_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD279);


            adaptor.addChild(root_1, DOUBLE_PERIOD279_tree);
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:404:70: ( col_ref )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==CUBE||LA72_0==DOLLARVAR||LA72_0==GROUP||LA72_0==IDENTIFIER) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:404:70: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2820);
                    col_ref280=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref280.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_range"


    public static class pound_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pound_proj"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:407:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AstPrinter.pound_proj_return pound_proj() throws RecognitionException {
        AstPrinter.pound_proj_return retval = new AstPrinter.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND281=null;
        CommonTree QUOTEDSTRING282=null;
        CommonTree NULL283=null;

        CommonTree POUND281_tree=null;
        CommonTree QUOTEDSTRING282_tree=null;
        CommonTree NULL283_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:408:5: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:408:7: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND281=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj2837); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND281_tree = (CommonTree)adaptor.dupNode(POUND281);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND281_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((POUND281!=null?POUND281.getText():null)); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:409:9: ( QUOTEDSTRING | NULL )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==QUOTEDSTRING) ) {
                alt73=1;
            }
            else if ( (LA73_0==NULL) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;

            }
            switch (alt73) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:409:11: QUOTEDSTRING
                    {
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING282=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_pound_proj2851); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING282_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING282);


                    adaptor.addChild(root_1, QUOTEDSTRING282_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING282!=null?QUOTEDSTRING282.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:409:61: NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    NULL283=(CommonTree)match(input,NULL,FOLLOW_NULL_in_pound_proj2857); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL283_tree = (CommonTree)adaptor.dupNode(NULL283);


                    adaptor.addChild(root_1, NULL283_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NULL283!=null?NULL283.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pound_proj"


    public static class bin_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:412:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AstPrinter.bin_expr_return bin_expr() throws RecognitionException {
        AstPrinter.bin_expr_return retval = new AstPrinter.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR284=null;
        AstPrinter.cond_return cond285 =null;

        AstPrinter.expr_return expr286 =null;

        AstPrinter.expr_return expr287 =null;


        CommonTree BIN_EXPR284_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:413:5: ( ^( BIN_EXPR cond expr expr ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:413:7: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR284=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr2878); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR284_tree = (CommonTree)adaptor.dupNode(BIN_EXPR284);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR284_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2882);
            cond285=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond285.getTree());


            if ( state.backtracking==0 ) { sb.append(" ? "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2886);
            expr286=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr286.getTree());


            if ( state.backtracking==0 ) { sb.append(" : "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2890);
            expr287=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr287.getTree());


            if ( state.backtracking==0 ) { sb.append(") "); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bin_expr"


    public static class case_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:416:1: case_expr : ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ ) ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )* ) ;
    public final AstPrinter.case_expr_return case_expr() throws RecognitionException {
        AstPrinter.case_expr_return retval = new AstPrinter.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR288=null;
        CommonTree CASE_EXPR_LHS289=null;
        CommonTree CASE_EXPR_RHS291=null;
        CommonTree CASE_EXPR_LHS293=null;
        CommonTree CASE_EXPR_RHS295=null;
        AstPrinter.expr_return expr290 =null;

        AstPrinter.expr_return expr292 =null;

        AstPrinter.expr_return expr294 =null;

        AstPrinter.expr_return expr296 =null;


        CommonTree CASE_EXPR288_tree=null;
        CommonTree CASE_EXPR_LHS289_tree=null;
        CommonTree CASE_EXPR_RHS291_tree=null;
        CommonTree CASE_EXPR_LHS293_tree=null;
        CommonTree CASE_EXPR_RHS295_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:417:5: ( ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ ) ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:417:7: ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ ) ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR288=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr2909); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR288_tree = (CommonTree)adaptor.dupNode(CASE_EXPR288);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR288_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" CASE ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:418:10: ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:418:12: ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR_LHS289=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr2926); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR_LHS289_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS289);


            root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS289_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_case_expr2928);
            expr290=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_2, expr290.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:418:36: ( ^( CASE_EXPR_RHS expr ) )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==CASE_EXPR_RHS) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:418:38: ^( CASE_EXPR_RHS expr )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_RHS291=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr2936); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_RHS291_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS291);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS291_tree, root_2);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr2940);
            	    expr292=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr292.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt74 >= 1 ) break loop74;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:419:10: ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==CASE_EXPR_LHS) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:419:12: ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_LHS293=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr2962); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_LHS293_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS293);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS293_tree, root_2);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr2966);
            	    expr294=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr294.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:419:57: ( ^( CASE_EXPR_RHS expr ) )+
            	    int cnt75=0;
            	    loop75:
            	    do {
            	        int alt75=2;
            	        int LA75_0 = input.LA(1);

            	        if ( (LA75_0==CASE_EXPR_RHS) ) {
            	            alt75=1;
            	        }


            	        switch (alt75) {
            	    	case 1 :
            	    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:419:59: ^( CASE_EXPR_RHS expr )
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    {
            	    	    CommonTree _save_last_2 = _last;
            	    	    CommonTree _first_2 = null;
            	    	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    	    _last = (CommonTree)input.LT(1);
            	    	    CASE_EXPR_RHS295=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr2974); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    CASE_EXPR_RHS295_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS295);


            	    	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS295_tree, root_2);
            	    	    }


            	    	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    	    _last = (CommonTree)input.LT(1);
            	    	    pushFollow(FOLLOW_expr_in_case_expr2978);
            	    	    expr296=expr();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) 
            	    	    adaptor.addChild(root_2, expr296.getTree());


            	    	    match(input, Token.UP, null); if (state.failed) return retval;
            	    	    adaptor.addChild(root_1, root_2);
            	    	    _last = _save_last_2;
            	    	    }


            	    	    if ( state.backtracking==0 ) {
            	    	    }
            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt75 >= 1 ) break loop75;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(75, input);
            	                throw eee;
            	        }
            	        cnt75++;
            	    } while (true);


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "case_expr"


    public static class case_cond_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_cond"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:422:1: case_cond : ^( CASE_COND ^( WHEN cond ( cond )* ) ^( THEN expr ( expr )* ) ) ;
    public final AstPrinter.case_cond_return case_cond() throws RecognitionException {
        AstPrinter.case_cond_return retval = new AstPrinter.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND297=null;
        CommonTree WHEN298=null;
        CommonTree THEN301=null;
        AstPrinter.cond_return cond299 =null;

        AstPrinter.cond_return cond300 =null;

        AstPrinter.expr_return expr302 =null;

        AstPrinter.expr_return expr303 =null;


        CommonTree CASE_COND297_tree=null;
        CommonTree WHEN298_tree=null;
        CommonTree THEN301_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:423:5: ( ^( CASE_COND ^( WHEN cond ( cond )* ) ^( THEN expr ( expr )* ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:423:7: ^( CASE_COND ^( WHEN cond ( cond )* ) ^( THEN expr ( expr )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND297=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond3005); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND297_tree = (CommonTree)adaptor.dupNode(CASE_COND297);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND297_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" CASE ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN298=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond3019); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN298_tree = (CommonTree)adaptor.dupNode(WHEN298);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN298_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_case_cond3021);
            cond299=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_2, cond299.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:424:22: ( cond )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==AND||LA77_0==IN||(LA77_0 >= NOT && LA77_0 <= NUM_OP_NE)||LA77_0==OR||(LA77_0 >= STR_OP_EQ && LA77_0 <= STR_OP_NE)||LA77_0==BOOL_COND||LA77_0==FUNC_EVAL) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:424:24: cond
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond3027);
            	    cond300=cond();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond300.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(", "); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            THEN301=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond3046); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN301_tree = (CommonTree)adaptor.dupNode(THEN301);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN301_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_case_cond3048);
            expr302=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_2, expr302.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:425:22: ( expr )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==BIGDECIMALNUMBER||LA78_0==BIGINTEGERNUMBER||LA78_0==CUBE||LA78_0==DIV||LA78_0==DOLLARVAR||LA78_0==DOUBLENUMBER||LA78_0==FALSE||LA78_0==FLOATNUMBER||LA78_0==GROUP||LA78_0==IDENTIFIER||LA78_0==INTEGER||LA78_0==LONGINTEGER||LA78_0==MINUS||LA78_0==NULL||LA78_0==PERCENT||LA78_0==PLUS||LA78_0==QUOTEDSTRING||LA78_0==STAR||LA78_0==TRUE||(LA78_0 >= BAG_VAL && LA78_0 <= BIN_EXPR)||(LA78_0 >= CASE_COND && LA78_0 <= CASE_EXPR)||LA78_0==CAST_EXPR||LA78_0==EXPR_IN_PAREN||LA78_0==FUNC_EVAL||(LA78_0 >= MAP_VAL && LA78_0 <= NEG)||LA78_0==TUPLE_VAL) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:425:24: expr
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond3054);
            	    expr303=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr303.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(") "); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "case_cond"


    public static class limit_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:428:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AstPrinter.limit_clause_return limit_clause() throws RecognitionException {
        AstPrinter.limit_clause_return retval = new AstPrinter.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT304=null;
        CommonTree INTEGER306=null;
        CommonTree LONGINTEGER307=null;
        AstPrinter.rel_return rel305 =null;

        AstPrinter.expr_return expr308 =null;


        CommonTree LIMIT304_tree=null;
        CommonTree INTEGER306_tree=null;
        CommonTree LONGINTEGER307_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:429:5: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:429:7: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT304=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause3078); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT304_tree = (CommonTree)adaptor.dupNode(LIMIT304);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT304_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((LIMIT304!=null?LIMIT304.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause3082);
            rel305=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel305.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:430:9: ( INTEGER | LONGINTEGER | expr )
            int alt79=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA79_1 = input.LA(2);

                if ( (synpred143_AstPrinter()) ) {
                    alt79=1;
                }
                else if ( (true) ) {
                    alt79=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA79_2 = input.LA(2);

                if ( (synpred144_AstPrinter()) ) {
                    alt79=2;
                }
                else if ( (true) ) {
                    alt79=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 2, input);

                    throw nvae;

                }
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case STAR:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt79=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }

            switch (alt79) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:430:11: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER306=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause3094); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER306_tree = (CommonTree)adaptor.dupNode(INTEGER306);


                    adaptor.addChild(root_1, INTEGER306_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((INTEGER306!=null?INTEGER306.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:430:63: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER307=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause3100); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER307_tree = (CommonTree)adaptor.dupNode(LONGINTEGER307);


                    adaptor.addChild(root_1, LONGINTEGER307_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((LONGINTEGER307!=null?LONGINTEGER307.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:430:123: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause3106);
                    expr308=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr308.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "limit_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:433:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AstPrinter.sample_clause_return sample_clause() throws RecognitionException {
        AstPrinter.sample_clause_return retval = new AstPrinter.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE309=null;
        CommonTree DOUBLENUMBER311=null;
        AstPrinter.rel_return rel310 =null;

        AstPrinter.expr_return expr312 =null;


        CommonTree SAMPLE309_tree=null;
        CommonTree DOUBLENUMBER311_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:434:5: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:434:7: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE309=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause3125); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE309_tree = (CommonTree)adaptor.dupNode(SAMPLE309);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE309_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((SAMPLE309!=null?SAMPLE309.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause3129);
            rel310=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel310.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:434:62: ( DOUBLENUMBER | expr )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==DOUBLENUMBER) ) {
                int LA80_1 = input.LA(2);

                if ( (synpred145_AstPrinter()) ) {
                    alt80=1;
                }
                else if ( (true) ) {
                    alt80=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 80, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA80_0==BIGDECIMALNUMBER||LA80_0==BIGINTEGERNUMBER||LA80_0==CUBE||LA80_0==DIV||LA80_0==DOLLARVAR||LA80_0==FALSE||LA80_0==FLOATNUMBER||LA80_0==GROUP||LA80_0==IDENTIFIER||LA80_0==INTEGER||LA80_0==LONGINTEGER||LA80_0==MINUS||LA80_0==NULL||LA80_0==PERCENT||LA80_0==PLUS||LA80_0==QUOTEDSTRING||LA80_0==STAR||LA80_0==TRUE||(LA80_0 >= BAG_VAL && LA80_0 <= BIN_EXPR)||(LA80_0 >= CASE_COND && LA80_0 <= CASE_EXPR)||LA80_0==CAST_EXPR||LA80_0==EXPR_IN_PAREN||LA80_0==FUNC_EVAL||(LA80_0 >= MAP_VAL && LA80_0 <= NEG)||LA80_0==TUPLE_VAL) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;

            }
            switch (alt80) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:434:64: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER311=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause3133); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER311_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER311);


                    adaptor.addChild(root_1, DOUBLENUMBER311_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DOUBLENUMBER311!=null?DOUBLENUMBER311.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:434:126: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause3139);
                    expr312=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr312.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sample_clause"


    public static class rank_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:437:1: rank_clause : ^( RANK rel ( rank_by_statement )? ) ;
    public final AstPrinter.rank_clause_return rank_clause() throws RecognitionException {
        AstPrinter.rank_clause_return retval = new AstPrinter.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK313=null;
        AstPrinter.rel_return rel314 =null;

        AstPrinter.rank_by_statement_return rank_by_statement315 =null;


        CommonTree RANK313_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:438:5: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:438:7: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK313=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause3158); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK313_tree = (CommonTree)adaptor.dupNode(RANK313);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK313_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((RANK313!=null?RANK313.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause3162);
            rel314=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel314.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:438:58: ( rank_by_statement )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==BY) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:438:60: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause3166);
                    rank_by_statement315=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement315.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_clause"


    public static class rank_by_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:441:1: rank_by_statement : ^( BY rank_by_clause ( DENSE )? ) ;
    public final AstPrinter.rank_by_statement_return rank_by_statement() throws RecognitionException {
        AstPrinter.rank_by_statement_return retval = new AstPrinter.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY316=null;
        CommonTree DENSE318=null;
        AstPrinter.rank_by_clause_return rank_by_clause317 =null;


        CommonTree BY316_tree=null;
        CommonTree DENSE318_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:442:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:442:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY316=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement3183); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY316_tree = (CommonTree)adaptor.dupNode(BY316);


            root_1 = (CommonTree)adaptor.becomeRoot(BY316_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((BY316!=null?BY316.getText():null)); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement3187);
            rank_by_clause317=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause317.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:442:62: ( DENSE )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==DENSE) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:442:64: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE318=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement3191); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE318_tree = (CommonTree)adaptor.dupNode(DENSE318);


                    adaptor.addChild(root_1, DENSE318_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DENSE318!=null?DENSE318.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_by_statement"


    public static class rank_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:445:1: rank_by_clause : ( STAR ( ASC | DESC )? | rank_col ( rank_col )* );
    public final AstPrinter.rank_by_clause_return rank_by_clause() throws RecognitionException {
        AstPrinter.rank_by_clause_return retval = new AstPrinter.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR319=null;
        CommonTree ASC320=null;
        CommonTree DESC321=null;
        AstPrinter.rank_col_return rank_col322 =null;

        AstPrinter.rank_col_return rank_col323 =null;


        CommonTree STAR319_tree=null;
        CommonTree ASC320_tree=null;
        CommonTree DESC321_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:446:2: ( STAR ( ASC | DESC )? | rank_col ( rank_col )* )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==STAR) ) {
                alt85=1;
            }
            else if ( (LA85_0==CUBE||LA85_0==DOLLARVAR||LA85_0==GROUP||LA85_0==IDENTIFIER||LA85_0==COL_RANGE) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;

            }
            switch (alt85) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:446:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR319=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause3208); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR319_tree = (CommonTree)adaptor.dupNode(STAR319);


                    adaptor.addChild(root_0, STAR319_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR319!=null?STAR319.getText():null)); }

                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:446:36: ( ASC | DESC )?
                    int alt83=3;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==ASC) ) {
                        alt83=1;
                    }
                    else if ( (LA83_0==DESC) ) {
                        alt83=2;
                    }
                    switch (alt83) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:446:38: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC320=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_by_clause3214); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC320_tree = (CommonTree)adaptor.dupNode(ASC320);


                            adaptor.addChild(root_0, ASC320_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((ASC320!=null?ASC320.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:446:82: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC321=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_by_clause3220); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC321_tree = (CommonTree)adaptor.dupNode(DESC321);


                            adaptor.addChild(root_0, DESC321_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((DESC321!=null?DESC321.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:447:7: rank_col ( rank_col )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_col_in_rank_by_clause3233);
                    rank_col322=rank_col();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_col322.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:447:16: ( rank_col )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==CUBE||LA84_0==DOLLARVAR||LA84_0==GROUP||LA84_0==IDENTIFIER||LA84_0==COL_RANGE) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:447:18: rank_col
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause3239);
                    	    rank_col323=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col323.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop84;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_by_clause"


    public static class rank_col_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_col"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:450:1: rank_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AstPrinter.rank_col_return rank_col() throws RecognitionException {
        AstPrinter.rank_col_return retval = new AstPrinter.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC326=null;
        CommonTree DESC327=null;
        AstPrinter.col_range_return col_range324 =null;

        AstPrinter.col_ref_return col_ref325 =null;


        CommonTree ASC326_tree=null;
        CommonTree DESC327_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:451:2: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:451:4: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:451:4: ( col_range | col_ref )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==COL_RANGE) ) {
                alt86=1;
            }
            else if ( (LA86_0==CUBE||LA86_0==DOLLARVAR||LA86_0==GROUP||LA86_0==IDENTIFIER) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;

            }
            switch (alt86) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:451:6: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col3254);
                    col_range324=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range324.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:451:18: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col3258);
                    col_ref325=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref325.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:451:28: ( ASC | DESC )?
            int alt87=3;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==ASC) ) {
                alt87=1;
            }
            else if ( (LA87_0==DESC) ) {
                alt87=2;
            }
            switch (alt87) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:451:30: ASC
                    {
                    _last = (CommonTree)input.LT(1);
                    ASC326=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3264); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC326_tree = (CommonTree)adaptor.dupNode(ASC326);


                    adaptor.addChild(root_0, ASC326_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ASC326!=null?ASC326.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:451:74: DESC
                    {
                    _last = (CommonTree)input.LT(1);
                    DESC327=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3270); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC327_tree = (CommonTree)adaptor.dupNode(DESC327);


                    adaptor.addChild(root_0, DESC327_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DESC327!=null?DESC327.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_col"


    public static class order_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:454:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AstPrinter.order_clause_return order_clause() throws RecognitionException {
        AstPrinter.order_clause_return retval = new AstPrinter.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER328=null;
        AstPrinter.rel_return rel329 =null;

        AstPrinter.order_by_clause_return order_by_clause330 =null;

        AstPrinter.func_clause_return func_clause331 =null;


        CommonTree ORDER328_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:455:5: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:455:7: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER328=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause3290); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER328_tree = (CommonTree)adaptor.dupNode(ORDER328);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER328_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((ORDER328!=null?ORDER328.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause3294);
            rel329=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel329.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause3306);
            order_by_clause330=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause330.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:457:9: ( func_clause )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==FUNC||LA88_0==FUNC_REF) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:457:11: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause3320);
                    func_clause331=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause331.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_clause"


    public static class order_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_by_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:460:1: order_by_clause : ( STAR ( ASC | DESC )? | order_col ( order_col )* );
    public final AstPrinter.order_by_clause_return order_by_clause() throws RecognitionException {
        AstPrinter.order_by_clause_return retval = new AstPrinter.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR332=null;
        CommonTree ASC333=null;
        CommonTree DESC334=null;
        AstPrinter.order_col_return order_col335 =null;

        AstPrinter.order_col_return order_col336 =null;


        CommonTree STAR332_tree=null;
        CommonTree ASC333_tree=null;
        CommonTree DESC334_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:461:5: ( STAR ( ASC | DESC )? | order_col ( order_col )* )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==STAR) ) {
                alt91=1;
            }
            else if ( (LA91_0==CUBE||LA91_0==DOLLARVAR||LA91_0==GROUP||LA91_0==IDENTIFIER||LA91_0==COL_RANGE) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;

            }
            switch (alt91) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:461:7: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR332=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause3338); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR332_tree = (CommonTree)adaptor.dupNode(STAR332);


                    adaptor.addChild(root_0, STAR332_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR332!=null?STAR332.getText():null)); }

                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:461:39: ( ASC | DESC )?
                    int alt89=3;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==ASC) ) {
                        alt89=1;
                    }
                    else if ( (LA89_0==DESC) ) {
                        alt89=2;
                    }
                    switch (alt89) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:461:41: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC333=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_by_clause3344); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC333_tree = (CommonTree)adaptor.dupNode(ASC333);


                            adaptor.addChild(root_0, ASC333_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((ASC333!=null?ASC333.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:461:85: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC334=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_by_clause3350); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC334_tree = (CommonTree)adaptor.dupNode(DESC334);


                            adaptor.addChild(root_0, DESC334_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((DESC334!=null?DESC334.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:462:7: order_col ( order_col )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_col_in_order_by_clause3363);
                    order_col335=order_col();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_col335.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:462:17: ( order_col )*
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==CUBE||LA90_0==DOLLARVAR||LA90_0==GROUP||LA90_0==IDENTIFIER||LA90_0==COL_RANGE) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:462:19: order_col
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause3369);
                    	    order_col336=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col336.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop90;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_by_clause"


    public static class order_col_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_col"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:465:1: order_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AstPrinter.order_col_return order_col() throws RecognitionException {
        AstPrinter.order_col_return retval = new AstPrinter.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC339=null;
        CommonTree DESC340=null;
        AstPrinter.col_range_return col_range337 =null;

        AstPrinter.col_ref_return col_ref338 =null;


        CommonTree ASC339_tree=null;
        CommonTree DESC340_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:466:5: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:466:7: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:466:7: ( col_range | col_ref )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==COL_RANGE) ) {
                alt92=1;
            }
            else if ( (LA92_0==CUBE||LA92_0==DOLLARVAR||LA92_0==GROUP||LA92_0==IDENTIFIER) ) {
                alt92=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;

            }
            switch (alt92) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:466:8: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col3385);
                    col_range337=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range337.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:466:20: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col3389);
                    col_ref338=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref338.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:466:29: ( ASC | DESC )?
            int alt93=3;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==ASC) ) {
                alt93=1;
            }
            else if ( (LA93_0==DESC) ) {
                alt93=2;
            }
            switch (alt93) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:466:31: ASC
                    {
                    _last = (CommonTree)input.LT(1);
                    ASC339=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col3394); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC339_tree = (CommonTree)adaptor.dupNode(ASC339);


                    adaptor.addChild(root_0, ASC339_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ASC339!=null?ASC339.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:466:75: DESC
                    {
                    _last = (CommonTree)input.LT(1);
                    DESC340=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col3400); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC340_tree = (CommonTree)adaptor.dupNode(DESC340);


                    adaptor.addChild(root_0, DESC340_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DESC340!=null?DESC340.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_col"


    public static class distinct_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:469:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AstPrinter.distinct_clause_return distinct_clause() throws RecognitionException {
        AstPrinter.distinct_clause_return retval = new AstPrinter.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT341=null;
        AstPrinter.rel_return rel342 =null;

        AstPrinter.partition_clause_return partition_clause343 =null;


        CommonTree DISTINCT341_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:470:5: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:470:7: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT341=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause3420); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT341_tree = (CommonTree)adaptor.dupNode(DISTINCT341);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT341_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((DISTINCT341!=null?DISTINCT341.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause3424);
            rel342=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel342.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:470:66: ( partition_clause )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==PARTITION) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:470:66: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause3426);
                    partition_clause343=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause343.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "distinct_clause"


    public static class partition_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:473:1: partition_clause : ^( PARTITION func_name ) ;
    public final AstPrinter.partition_clause_return partition_clause() throws RecognitionException {
        AstPrinter.partition_clause_return retval = new AstPrinter.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION344=null;
        AstPrinter.func_name_return func_name345 =null;


        CommonTree PARTITION344_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:474:5: ( ^( PARTITION func_name ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:474:7: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION344=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause3444); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION344_tree = (CommonTree)adaptor.dupNode(PARTITION344);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION344_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((PARTITION344!=null?PARTITION344.getText():null)).append(" BY "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause3448);
            func_name345=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name345.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partition_clause"


    public static class cross_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cross_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:477:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AstPrinter.cross_clause_return cross_clause() throws RecognitionException {
        AstPrinter.cross_clause_return retval = new AstPrinter.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS346=null;
        AstPrinter.rel_list_return rel_list347 =null;

        AstPrinter.partition_clause_return partition_clause348 =null;


        CommonTree CROSS346_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:478:5: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:478:7: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS346=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause3465); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS346_tree = (CommonTree)adaptor.dupNode(CROSS346);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS346_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((CROSS346!=null?CROSS346.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause3469);
            rel_list347=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list347.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:478:65: ( partition_clause )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==PARTITION) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:478:65: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause3471);
                    partition_clause348=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause348.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cross_clause"


    public static class rel_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:481:1: rel_list : rel ( rel )* ;
    public final AstPrinter.rel_list_return rel_list() throws RecognitionException {
        AstPrinter.rel_list_return retval = new AstPrinter.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.rel_return rel349 =null;

        AstPrinter.rel_return rel350 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:482:5: ( rel ( rel )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:482:7: rel ( rel )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rel_list3487);
            rel349=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel349.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:482:11: ( rel )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==ASSERT||LA96_0==COGROUP||(LA96_0 >= CROSS && LA96_0 <= CUBE)||LA96_0==DEFINE||LA96_0==DISTINCT||LA96_0==FILTER||LA96_0==FOREACH||LA96_0==GROUP||LA96_0==IDENTIFIER||LA96_0==JOIN||(LA96_0 >= LIMIT && LA96_0 <= LOAD)||LA96_0==MAPREDUCE||LA96_0==ORDER||LA96_0==RANK||LA96_0==SAMPLE||LA96_0==SPLIT||(LA96_0 >= STORE && LA96_0 <= STREAM)||LA96_0==UNION) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:482:13: rel
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list3493);
            	    rel350=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel350.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_list"


    public static class join_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:485:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AstPrinter.join_clause_return join_clause() throws RecognitionException {
        AstPrinter.join_clause_return retval = new AstPrinter.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN351=null;
        AstPrinter.join_sub_clause_return join_sub_clause352 =null;

        AstPrinter.join_type_return join_type353 =null;

        AstPrinter.partition_clause_return partition_clause354 =null;


        CommonTree JOIN351_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:486:5: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:486:7: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN351=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause3510); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN351_tree = (CommonTree)adaptor.dupNode(JOIN351);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN351_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((JOIN351!=null?JOIN351.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause3514);
            join_sub_clause352=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause352.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:486:70: ( join_type )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==QUOTEDSTRING) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:486:72: join_type
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause3520);
                    join_type353=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type353.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:487:5: ( partition_clause )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==PARTITION) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:487:7: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause3531);
                    partition_clause354=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause354.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:490:1: join_type : QUOTEDSTRING ;
    public final AstPrinter.join_type_return join_type() throws RecognitionException {
        AstPrinter.join_type_return retval = new AstPrinter.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING355=null;

        CommonTree QUOTEDSTRING355_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:490:11: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:490:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING355=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type3545); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING355_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING355);


            adaptor.addChild(root_0, QUOTEDSTRING355_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING355!=null?QUOTEDSTRING355.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_type"


    public static class join_sub_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_sub_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:493:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | join_item ( join_item )* );
    public final AstPrinter.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AstPrinter.join_sub_clause_return retval = new AstPrinter.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LEFT357=null;
        CommonTree RIGHT358=null;
        CommonTree FULL359=null;
        CommonTree OUTER360=null;
        AstPrinter.join_item_return join_item356 =null;

        AstPrinter.join_item_return join_item361 =null;

        AstPrinter.join_item_return join_item362 =null;

        AstPrinter.join_item_return join_item363 =null;


        CommonTree LEFT357_tree=null;
        CommonTree RIGHT358_tree=null;
        CommonTree FULL359_tree=null;
        CommonTree OUTER360_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:494:5: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | join_item ( join_item )* )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==JOIN_ITEM) ) {
                int LA102_1 = input.LA(2);

                if ( (synpred171_AstPrinter()) ) {
                    alt102=1;
                }
                else if ( (true) ) {
                    alt102=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 102, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;

            }
            switch (alt102) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:494:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3560);
                    join_item356=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item356.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:494:17: ( LEFT | RIGHT | FULL )
                    int alt99=3;
                    switch ( input.LA(1) ) {
                    case LEFT:
                        {
                        alt99=1;
                        }
                        break;
                    case RIGHT:
                        {
                        alt99=2;
                        }
                        break;
                    case FULL:
                        {
                        alt99=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 99, 0, input);

                        throw nvae;

                    }

                    switch (alt99) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:494:19: LEFT
                            {
                            _last = (CommonTree)input.LT(1);
                            LEFT357=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_join_sub_clause3564); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LEFT357_tree = (CommonTree)adaptor.dupNode(LEFT357);


                            adaptor.addChild(root_0, LEFT357_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((LEFT357!=null?LEFT357.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:495:16: RIGHT
                            {
                            _last = (CommonTree)input.LT(1);
                            RIGHT358=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_join_sub_clause3583); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RIGHT358_tree = (CommonTree)adaptor.dupNode(RIGHT358);


                            adaptor.addChild(root_0, RIGHT358_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((RIGHT358!=null?RIGHT358.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 3 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:496:16: FULL
                            {
                            _last = (CommonTree)input.LT(1);
                            FULL359=(CommonTree)match(input,FULL,FOLLOW_FULL_in_join_sub_clause3602); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            FULL359_tree = (CommonTree)adaptor.dupNode(FULL359);


                            adaptor.addChild(root_0, FULL359_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((FULL359!=null?FULL359.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:497:16: ( OUTER )?
                    int alt100=2;
                    int LA100_0 = input.LA(1);

                    if ( (LA100_0==OUTER) ) {
                        alt100=1;
                    }
                    switch (alt100) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:497:17: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER360=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause3622); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER360_tree = (CommonTree)adaptor.dupNode(OUTER360);


                            adaptor.addChild(root_0, OUTER360_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((OUTER360!=null?OUTER360.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append(", "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3631);
                    join_item361=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item361.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:498:7: join_item ( join_item )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3639);
                    join_item362=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item362.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:498:17: ( join_item )*
                    loop101:
                    do {
                        int alt101=2;
                        int LA101_0 = input.LA(1);

                        if ( (LA101_0==JOIN_ITEM) ) {
                            alt101=1;
                        }


                        switch (alt101) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:498:19: join_item
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause3645);
                    	    join_item363=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item363.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop101;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_sub_clause"


    public static class join_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_item"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:501:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AstPrinter.join_item_return join_item() throws RecognitionException {
        AstPrinter.join_item_return retval = new AstPrinter.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM364=null;
        AstPrinter.rel_return rel365 =null;

        AstPrinter.join_group_by_clause_return join_group_by_clause366 =null;


        CommonTree JOIN_ITEM364_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:502:5: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:502:7: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM364=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item3663); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM364_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM364);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM364_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item3665);
            rel365=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel365.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item3667);
            join_group_by_clause366=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause366.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:505:1: join_group_by_clause : ^( BY join_group_by_expr ( join_group_by_expr )* ) ;
    public final AstPrinter.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AstPrinter.join_group_by_clause_return retval = new AstPrinter.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY367=null;
        AstPrinter.join_group_by_expr_return join_group_by_expr368 =null;

        AstPrinter.join_group_by_expr_return join_group_by_expr369 =null;


        CommonTree BY367_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:506:5: ( ^( BY join_group_by_expr ( join_group_by_expr )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:506:7: ^( BY join_group_by_expr ( join_group_by_expr )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY367=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause3684); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY367_tree = (CommonTree)adaptor.dupNode(BY367);


            root_1 = (CommonTree)adaptor.becomeRoot(BY367_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((BY367!=null?BY367.getText():null)).append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause3692);
            join_group_by_expr368=join_group_by_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_expr368.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:507:24: ( join_group_by_expr )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==BIGDECIMALNUMBER||LA103_0==BIGINTEGERNUMBER||LA103_0==CUBE||LA103_0==DIV||LA103_0==DOLLARVAR||LA103_0==DOUBLENUMBER||LA103_0==FALSE||LA103_0==FLOATNUMBER||LA103_0==GROUP||LA103_0==IDENTIFIER||LA103_0==INTEGER||LA103_0==LONGINTEGER||LA103_0==MINUS||LA103_0==NULL||LA103_0==PERCENT||LA103_0==PLUS||LA103_0==QUOTEDSTRING||LA103_0==STAR||LA103_0==TRUE||(LA103_0 >= BAG_VAL && LA103_0 <= BIN_EXPR)||(LA103_0 >= CASE_COND && LA103_0 <= CASE_EXPR)||(LA103_0 >= CAST_EXPR && LA103_0 <= EXPR_IN_PAREN)||LA103_0==FUNC_EVAL||(LA103_0 >= MAP_VAL && LA103_0 <= NEG)||LA103_0==TUPLE_VAL) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:507:26: join_group_by_expr
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause3698);
            	    join_group_by_expr369=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr369.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop103;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_clause"


    public static class join_group_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:510:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AstPrinter.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AstPrinter.join_group_by_expr_return retval = new AstPrinter.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR372=null;
        AstPrinter.col_range_return col_range370 =null;

        AstPrinter.expr_return expr371 =null;


        CommonTree STAR372_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:511:5: ( col_range | expr | STAR )
            int alt104=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt104=1;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt104=2;
                }
                break;
            case STAR:
                {
                int LA104_3 = input.LA(2);

                if ( (LA104_3==DOWN) ) {
                    alt104=2;
                }
                else if ( (LA104_3==EOF||LA104_3==UP||LA104_3==BIGDECIMALNUMBER||LA104_3==BIGINTEGERNUMBER||LA104_3==CUBE||LA104_3==DIV||LA104_3==DOLLARVAR||LA104_3==DOUBLENUMBER||LA104_3==FALSE||LA104_3==FLOATNUMBER||LA104_3==GROUP||LA104_3==IDENTIFIER||LA104_3==INTEGER||LA104_3==LONGINTEGER||LA104_3==MINUS||LA104_3==NULL||LA104_3==PERCENT||LA104_3==PLUS||LA104_3==QUOTEDSTRING||LA104_3==STAR||LA104_3==TRUE||(LA104_3 >= BAG_VAL && LA104_3 <= BIN_EXPR)||(LA104_3 >= CASE_COND && LA104_3 <= CASE_EXPR)||(LA104_3 >= CAST_EXPR && LA104_3 <= EXPR_IN_PAREN)||LA104_3==FUNC_EVAL||(LA104_3 >= MAP_VAL && LA104_3 <= NEG)||LA104_3==TUPLE_VAL) ) {
                    alt104=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 104, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;

            }

            switch (alt104) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:511:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr3718);
                    col_range370=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range370.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:511:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr3722);
                    expr371=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr371.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:511:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR372=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr3726); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR372_tree = (CommonTree)adaptor.dupNode(STAR372);


                    adaptor.addChild(root_0, STAR372_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR372!=null?STAR372.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_expr"


    public static class union_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:514:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AstPrinter.union_clause_return union_clause() throws RecognitionException {
        AstPrinter.union_clause_return retval = new AstPrinter.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION373=null;
        CommonTree ONSCHEMA374=null;
        AstPrinter.rel_list_return rel_list375 =null;


        CommonTree UNION373_tree=null;
        CommonTree ONSCHEMA374_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:515:5: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:515:7: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION373=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause3743); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION373_tree = (CommonTree)adaptor.dupNode(UNION373);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION373_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((UNION373!=null?UNION373.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:515:56: ( ONSCHEMA )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==ONSCHEMA) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:515:57: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA374=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause3748); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA374_tree = (CommonTree)adaptor.dupNode(ONSCHEMA374);


                    adaptor.addChild(root_1, ONSCHEMA374_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ONSCHEMA374!=null?ONSCHEMA374.getText():null)).append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause3755);
            rel_list375=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list375.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "union_clause"


    public static class foreach_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:518:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AstPrinter.foreach_clause_return foreach_clause() throws RecognitionException {
        AstPrinter.foreach_clause_return retval = new AstPrinter.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH376=null;
        AstPrinter.rel_return rel377 =null;

        AstPrinter.foreach_plan_return foreach_plan378 =null;


        CommonTree FOREACH376_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:519:5: ( ^( FOREACH rel foreach_plan ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:519:7: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH376=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause3772); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH376_tree = (CommonTree)adaptor.dupNode(FOREACH376);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH376_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FOREACH376!=null?FOREACH376.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause3776);
            rel377=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel377.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause3778);
            foreach_plan378=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan378.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "foreach_clause"


    public static class foreach_plan_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_plan"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:522:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AstPrinter.foreach_plan_return foreach_plan() throws RecognitionException {
        AstPrinter.foreach_plan_return retval = new AstPrinter.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE379=null;
        CommonTree FOREACH_PLAN_COMPLEX381=null;
        AstPrinter.generate_clause_return generate_clause380 =null;

        AstPrinter.nested_blk_return nested_blk382 =null;


        CommonTree FOREACH_PLAN_SIMPLE379_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX381_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:523:5: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==FOREACH_PLAN_SIMPLE) ) {
                alt106=1;
            }
            else if ( (LA106_0==FOREACH_PLAN_COMPLEX) ) {
                alt106=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;

            }
            switch (alt106) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:523:7: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE379=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan3795); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE379_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE379);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE379_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan3797);
                    generate_clause380=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause380.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:524:7: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX381=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan3809); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX381_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX381);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX381_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan3811);
                    nested_blk382=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk382.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "foreach_plan"


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:527:1: nested_blk : ( nested_command )* generate_clause ;
    public final AstPrinter.nested_blk_return nested_blk() throws RecognitionException {
        AstPrinter.nested_blk_return retval = new AstPrinter.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.nested_command_return nested_command383 =null;

        AstPrinter.generate_clause_return generate_clause384 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:528:5: ( ( nested_command )* generate_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:528:7: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( state.backtracking==0 ) { sb.append(" { "); }

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:528:29: ( nested_command )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( ((LA107_0 >= NESTED_CMD && LA107_0 <= NESTED_CMD_ASSI)) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:528:30: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk3829);
            	    nested_command383=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command383.getTree());


            	    if ( state.backtracking==0 ) { sb.append("; "); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk3836);
            generate_clause384=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause384.getTree());


            if ( state.backtracking==0 ) { sb.append("; } "); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_blk"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:531:1: generate_clause : ^( GENERATE flatten_generated_item ( flatten_generated_item )* ) ;
    public final AstPrinter.generate_clause_return generate_clause() throws RecognitionException {
        AstPrinter.generate_clause_return retval = new AstPrinter.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE385=null;
        AstPrinter.flatten_generated_item_return flatten_generated_item386 =null;

        AstPrinter.flatten_generated_item_return flatten_generated_item387 =null;


        CommonTree GENERATE385_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:532:5: ( ^( GENERATE flatten_generated_item ( flatten_generated_item )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:532:7: ^( GENERATE flatten_generated_item ( flatten_generated_item )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE385=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause3853); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE385_tree = (CommonTree)adaptor.dupNode(GENERATE385);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE385_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((GENERATE385!=null?GENERATE385.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_flatten_generated_item_in_generate_clause3865);
            flatten_generated_item386=flatten_generated_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, flatten_generated_item386.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:533:32: ( flatten_generated_item )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==BIGDECIMALNUMBER||LA108_0==BIGINTEGERNUMBER||LA108_0==CUBE||LA108_0==DIV||LA108_0==DOLLARVAR||LA108_0==DOUBLENUMBER||LA108_0==FALSE||LA108_0==FLATTEN||LA108_0==FLOATNUMBER||LA108_0==GROUP||LA108_0==IDENTIFIER||LA108_0==INTEGER||LA108_0==LONGINTEGER||LA108_0==MINUS||LA108_0==NULL||LA108_0==PERCENT||LA108_0==PLUS||LA108_0==QUOTEDSTRING||LA108_0==STAR||LA108_0==TRUE||(LA108_0 >= BAG_VAL && LA108_0 <= BIN_EXPR)||(LA108_0 >= CASE_COND && LA108_0 <= CASE_EXPR)||(LA108_0 >= CAST_EXPR && LA108_0 <= EXPR_IN_PAREN)||LA108_0==FUNC_EVAL||(LA108_0 >= MAP_VAL && LA108_0 <= NEG)||LA108_0==TUPLE_VAL) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:533:34: flatten_generated_item
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause3871);
            	    flatten_generated_item387=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item387.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "generate_clause"


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:536:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AstPrinter.nested_command_return nested_command() throws RecognitionException {
        AstPrinter.nested_command_return retval = new AstPrinter.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD388=null;
        CommonTree IDENTIFIER389=null;
        CommonTree NESTED_CMD_ASSI391=null;
        CommonTree IDENTIFIER392=null;
        AstPrinter.nested_op_return nested_op390 =null;

        AstPrinter.expr_return expr393 =null;


        CommonTree NESTED_CMD388_tree=null;
        CommonTree IDENTIFIER389_tree=null;
        CommonTree NESTED_CMD_ASSI391_tree=null;
        CommonTree IDENTIFIER392_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:537:5: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==NESTED_CMD) ) {
                alt109=1;
            }
            else if ( (LA109_0==NESTED_CMD_ASSI) ) {
                alt109=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;

            }
            switch (alt109) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:537:7: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD388=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command3890); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD388_tree = (CommonTree)adaptor.dupNode(NESTED_CMD388);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD388_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER389=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command3892); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER389_tree = (CommonTree)adaptor.dupNode(IDENTIFIER389);


                    adaptor.addChild(root_1, IDENTIFIER389_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER389!=null?IDENTIFIER389.getText():null)).append(" = "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command3896);
                    nested_op390=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op390.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:538:7: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI391=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command3908); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI391_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI391);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI391_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER392=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command3910); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER392_tree = (CommonTree)adaptor.dupNode(IDENTIFIER392);


                    adaptor.addChild(root_1, IDENTIFIER392_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER392!=null?IDENTIFIER392.getText():null)).append(" = "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command3914);
                    expr393=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr393.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_command"


    public static class nested_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:541:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AstPrinter.nested_op_return nested_op() throws RecognitionException {
        AstPrinter.nested_op_return retval = new AstPrinter.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.nested_proj_return nested_proj394 =null;

        AstPrinter.nested_filter_return nested_filter395 =null;

        AstPrinter.nested_sort_return nested_sort396 =null;

        AstPrinter.nested_distinct_return nested_distinct397 =null;

        AstPrinter.nested_limit_return nested_limit398 =null;

        AstPrinter.nested_cross_return nested_cross399 =null;

        AstPrinter.nested_foreach_return nested_foreach400 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:541:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt110=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt110=1;
                }
                break;
            case FILTER:
                {
                alt110=2;
                }
                break;
            case ORDER:
                {
                alt110=3;
                }
                break;
            case DISTINCT:
                {
                alt110=4;
                }
                break;
            case LIMIT:
                {
                alt110=5;
                }
                break;
            case CROSS:
                {
                alt110=6;
                }
                break;
            case FOREACH:
                {
                alt110=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;

            }

            switch (alt110) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:541:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op3925);
                    nested_proj394=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj394.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:542:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op3939);
                    nested_filter395=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter395.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:543:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op3953);
                    nested_sort396=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort396.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:544:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op3967);
                    nested_distinct397=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct397.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:545:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op3981);
                    nested_limit398=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit398.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:546:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op3995);
                    nested_cross399=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross399.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:547:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op4009);
                    nested_foreach400=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach400.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op"


    public static class nested_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_proj"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:550:1: nested_proj : ^( NESTED_PROJ col_ref col_ref ( col_ref )* ) ;
    public final AstPrinter.nested_proj_return nested_proj() throws RecognitionException {
        AstPrinter.nested_proj_return retval = new AstPrinter.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ401=null;
        AstPrinter.col_ref_return col_ref402 =null;

        AstPrinter.col_ref_return col_ref403 =null;

        AstPrinter.col_ref_return col_ref404 =null;


        CommonTree NESTED_PROJ401_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:551:5: ( ^( NESTED_PROJ col_ref col_ref ( col_ref )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:551:7: ^( NESTED_PROJ col_ref col_ref ( col_ref )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ401=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj4024); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ401_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ401);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ401_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj4026);
            col_ref402=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref402.getTree());


            if ( state.backtracking==0 ) { sb.append(".("); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj4030);
            col_ref403=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref403.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:551:59: ( col_ref )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==CUBE||LA111_0==DOLLARVAR||LA111_0==GROUP||LA111_0==IDENTIFIER) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:551:61: col_ref
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj4036);
            	    col_ref404=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref404.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop111;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_proj"


    public static class nested_filter_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:554:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AstPrinter.nested_filter_return nested_filter() throws RecognitionException {
        AstPrinter.nested_filter_return retval = new AstPrinter.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER405=null;
        AstPrinter.nested_op_input_return nested_op_input406 =null;

        AstPrinter.cond_return cond407 =null;


        CommonTree FILTER405_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:555:5: ( ^( FILTER nested_op_input cond ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:555:7: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER405=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter4057); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER405_tree = (CommonTree)adaptor.dupNode(FILTER405);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER405_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FILTER405!=null?FILTER405.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter4061);
            nested_op_input406=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input406.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter4065);
            cond407=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond407.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_filter"


    public static class nested_sort_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_sort"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:558:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AstPrinter.nested_sort_return nested_sort() throws RecognitionException {
        AstPrinter.nested_sort_return retval = new AstPrinter.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER408=null;
        AstPrinter.nested_op_input_return nested_op_input409 =null;

        AstPrinter.order_by_clause_return order_by_clause410 =null;

        AstPrinter.func_clause_return func_clause411 =null;


        CommonTree ORDER408_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:559:5: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:559:7: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER408=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort4082); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER408_tree = (CommonTree)adaptor.dupNode(ORDER408);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER408_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((ORDER408!=null?ORDER408.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort4086);
            nested_op_input409=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input409.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort4098);
            order_by_clause410=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause410.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:560:48: ( func_clause )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==FUNC||LA112_0==FUNC_REF) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:560:50: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort4104);
                    func_clause411=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause411.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_sort"


    public static class nested_distinct_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_distinct"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:563:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AstPrinter.nested_distinct_return nested_distinct() throws RecognitionException {
        AstPrinter.nested_distinct_return retval = new AstPrinter.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT412=null;
        AstPrinter.nested_op_input_return nested_op_input413 =null;


        CommonTree DISTINCT412_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:564:5: ( ^( DISTINCT nested_op_input ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:564:7: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT412=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct4123); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT412_tree = (CommonTree)adaptor.dupNode(DISTINCT412);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT412_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((DISTINCT412!=null?DISTINCT412.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct4128);
            nested_op_input413=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input413.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_distinct"


    public static class nested_limit_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_limit"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:567:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AstPrinter.nested_limit_return nested_limit() throws RecognitionException {
        AstPrinter.nested_limit_return retval = new AstPrinter.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT414=null;
        CommonTree INTEGER416=null;
        AstPrinter.nested_op_input_return nested_op_input415 =null;

        AstPrinter.expr_return expr417 =null;


        CommonTree LIMIT414_tree=null;
        CommonTree INTEGER416_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:568:5: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:568:7: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT414=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit4145); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT414_tree = (CommonTree)adaptor.dupNode(LIMIT414);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT414_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((LIMIT414!=null?LIMIT414.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit4150);
            nested_op_input415=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input415.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:568:73: ( INTEGER | expr )
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==INTEGER) ) {
                int LA113_1 = input.LA(2);

                if ( (synpred189_AstPrinter()) ) {
                    alt113=1;
                }
                else if ( (true) ) {
                    alt113=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 113, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA113_0==BIGDECIMALNUMBER||LA113_0==BIGINTEGERNUMBER||LA113_0==CUBE||LA113_0==DIV||LA113_0==DOLLARVAR||LA113_0==DOUBLENUMBER||LA113_0==FALSE||LA113_0==FLOATNUMBER||LA113_0==GROUP||LA113_0==IDENTIFIER||LA113_0==LONGINTEGER||LA113_0==MINUS||LA113_0==NULL||LA113_0==PERCENT||LA113_0==PLUS||LA113_0==QUOTEDSTRING||LA113_0==STAR||LA113_0==TRUE||(LA113_0 >= BAG_VAL && LA113_0 <= BIN_EXPR)||(LA113_0 >= CASE_COND && LA113_0 <= CASE_EXPR)||LA113_0==CAST_EXPR||LA113_0==EXPR_IN_PAREN||LA113_0==FUNC_EVAL||(LA113_0 >= MAP_VAL && LA113_0 <= NEG)||LA113_0==TUPLE_VAL) ) {
                alt113=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;

            }
            switch (alt113) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:568:75: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER416=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit4154); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER416_tree = (CommonTree)adaptor.dupNode(INTEGER416);


                    adaptor.addChild(root_1, INTEGER416_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((INTEGER416!=null?INTEGER416.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:568:127: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit4160);
                    expr417=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr417.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_limit"


    public static class nested_cross_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_cross"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:571:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AstPrinter.nested_cross_return nested_cross() throws RecognitionException {
        AstPrinter.nested_cross_return retval = new AstPrinter.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS418=null;
        AstPrinter.nested_op_input_list_return nested_op_input_list419 =null;


        CommonTree CROSS418_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:572:5: ( ^( CROSS nested_op_input_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:572:7: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS418=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross4179); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS418_tree = (CommonTree)adaptor.dupNode(CROSS418);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS418_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((CROSS418!=null?CROSS418.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross4184);
            nested_op_input_list419=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list419.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_cross"


    public static class nested_foreach_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_foreach"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:575:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AstPrinter.nested_foreach_return nested_foreach() throws RecognitionException {
        AstPrinter.nested_foreach_return retval = new AstPrinter.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH420=null;
        AstPrinter.nested_op_input_return nested_op_input421 =null;

        AstPrinter.generate_clause_return generate_clause422 =null;


        CommonTree FOREACH420_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:576:2: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:576:4: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH420=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach4198); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH420_tree = (CommonTree)adaptor.dupNode(FOREACH420);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH420_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FOREACH420!=null?FOREACH420.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach4203);
            nested_op_input421=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input421.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach4205);
            generate_clause422=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause422.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_foreach"


    public static class nested_op_input_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:579:1: nested_op_input : ( col_ref | nested_proj );
    public final AstPrinter.nested_op_input_return nested_op_input() throws RecognitionException {
        AstPrinter.nested_op_input_return retval = new AstPrinter.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.col_ref_return col_ref423 =null;

        AstPrinter.nested_proj_return nested_proj424 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:579:17: ( col_ref | nested_proj )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==CUBE||LA114_0==DOLLARVAR||LA114_0==GROUP||LA114_0==IDENTIFIER) ) {
                alt114=1;
            }
            else if ( (LA114_0==NESTED_PROJ) ) {
                alt114=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;

            }
            switch (alt114) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:579:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input4216);
                    col_ref423=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref423.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:579:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input4220);
                    nested_proj424=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj424.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input"


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:582:1: nested_op_input_list : nested_op_input ( nested_op_input )* ;
    public final AstPrinter.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AstPrinter.nested_op_input_list_return retval = new AstPrinter.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.nested_op_input_return nested_op_input425 =null;

        AstPrinter.nested_op_input_return nested_op_input426 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:583:5: ( nested_op_input ( nested_op_input )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:583:7: nested_op_input ( nested_op_input )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list4233);
            nested_op_input425=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, nested_op_input425.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:583:23: ( nested_op_input )*
            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( (LA115_0==CUBE||LA115_0==DOLLARVAR||LA115_0==GROUP||LA115_0==IDENTIFIER||LA115_0==NESTED_PROJ) ) {
                    alt115=1;
                }


                switch (alt115) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:583:25: nested_op_input
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list4239);
            	    nested_op_input426=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input426.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop115;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input_list"


    public static class stream_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:586:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AstPrinter.stream_clause_return stream_clause() throws RecognitionException {
        AstPrinter.stream_clause_return retval = new AstPrinter.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM427=null;
        CommonTree EXECCOMMAND429=null;
        CommonTree IDENTIFIER430=null;
        AstPrinter.rel_return rel428 =null;

        AstPrinter.as_clause_return as_clause431 =null;


        CommonTree STREAM427_tree=null;
        CommonTree EXECCOMMAND429_tree=null;
        CommonTree IDENTIFIER430_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:587:5: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:587:7: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM427=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause4256); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM427_tree = (CommonTree)adaptor.dupNode(STREAM427);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM427_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((STREAM427!=null?STREAM427.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause4260);
            rel428=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel428.getTree());


            if ( state.backtracking==0 ) { sb.append(" THROUGH "); }

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:588:9: ( EXECCOMMAND | IDENTIFIER )
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==EXECCOMMAND) ) {
                alt116=1;
            }
            else if ( (LA116_0==IDENTIFIER) ) {
                alt116=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;

            }
            switch (alt116) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:588:11: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND429=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_stream_clause4274); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND429_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND429);


                    adaptor.addChild(root_1, EXECCOMMAND429_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((EXECCOMMAND429!=null?EXECCOMMAND429.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:589:11: IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER430=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stream_clause4288); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER430_tree = (CommonTree)adaptor.dupNode(IDENTIFIER430);


                    adaptor.addChild(root_1, IDENTIFIER430_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER430!=null?IDENTIFIER430.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:589:57: ( as_clause )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==AS) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:589:57: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause4294);
                    as_clause431=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause431.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_clause"


    public static class mr_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mr_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:592:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AstPrinter.mr_clause_return mr_clause() throws RecognitionException {
        AstPrinter.mr_clause_return retval = new AstPrinter.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE432=null;
        CommonTree QUOTEDSTRING433=null;
        CommonTree EXECCOMMAND437=null;
        AstPrinter.path_list_return path_list434 =null;

        AstPrinter.store_clause_return store_clause435 =null;

        AstPrinter.load_clause_return load_clause436 =null;


        CommonTree MAPREDUCE432_tree=null;
        CommonTree QUOTEDSTRING433_tree=null;
        CommonTree EXECCOMMAND437_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:593:5: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:593:7: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE432=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause4312); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE432_tree = (CommonTree)adaptor.dupNode(MAPREDUCE432);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE432_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING433=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause4314); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING433_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING433);


            adaptor.addChild(root_1, QUOTEDSTRING433_tree);
            }


            if ( state.backtracking==0 ) { sb.append((MAPREDUCE432!=null?MAPREDUCE432.getText():null)).append(" ").append((QUOTEDSTRING433!=null?QUOTEDSTRING433.getText():null)).append(" "); }

            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:594:9: ( path_list )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==QUOTEDSTRING) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:594:10: path_list
                    {
                    if ( state.backtracking==0 ) { sb.append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause4329);
                    path_list434=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list434.getTree());


                    if ( state.backtracking==0 ) { sb.append(") "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause4336);
            store_clause435=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause435.getTree());


            if ( state.backtracking==0 ) { sb.append(" "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause4340);
            load_clause436=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause436.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:595:9: ( EXECCOMMAND )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==EXECCOMMAND) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:595:10: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND437=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause4351); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND437_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND437);


                    adaptor.addChild(root_1, EXECCOMMAND437_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((EXECCOMMAND437!=null?EXECCOMMAND437.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "mr_clause"


    public static class split_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:598:1: split_clause : ^( SPLIT rel split_branch ( split_branch )* ( split_otherwise )? ) ;
    public final AstPrinter.split_clause_return split_clause() throws RecognitionException {
        AstPrinter.split_clause_return retval = new AstPrinter.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT438=null;
        AstPrinter.rel_return rel439 =null;

        AstPrinter.split_branch_return split_branch440 =null;

        AstPrinter.split_branch_return split_branch441 =null;

        AstPrinter.split_otherwise_return split_otherwise442 =null;


        CommonTree SPLIT438_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:599:5: ( ^( SPLIT rel split_branch ( split_branch )* ( split_otherwise )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:599:7: ^( SPLIT rel split_branch ( split_branch )* ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT438=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause4373); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT438_tree = (CommonTree)adaptor.dupNode(SPLIT438);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT438_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((SPLIT438!=null?SPLIT438.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause4386);
            rel439=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel439.getTree());


            if ( state.backtracking==0 ) { sb.append(" INTO "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_branch_in_split_clause4390);
            split_branch440=split_branch();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, split_branch440.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:600:51: ( split_branch )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==SPLIT_BRANCH) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:600:53: split_branch
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause4396);
            	    split_branch441=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch441.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop120;
                }
            } while (true);


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:600:90: ( split_otherwise )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==OTHERWISE) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:600:92: split_otherwise
                    {
                    if ( state.backtracking==0 ) { sb.append(", "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause4405);
                    split_otherwise442=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise442.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_clause"


    public static class split_branch_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_branch"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:603:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AstPrinter.split_branch_return split_branch() throws RecognitionException {
        AstPrinter.split_branch_return retval = new AstPrinter.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH443=null;
        AstPrinter.alias_return alias444 =null;

        AstPrinter.cond_return cond445 =null;


        CommonTree SPLIT_BRANCH443_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:604:5: ( ^( SPLIT_BRANCH alias cond ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:604:7: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH443=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch4425); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH443_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH443);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH443_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch4427);
            alias444=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias444.getTree());


            if ( state.backtracking==0 ) { sb.append(" IF "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch4431);
            cond445=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond445.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:607:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AstPrinter.split_otherwise_return split_otherwise() throws RecognitionException {
        AstPrinter.split_otherwise_return retval = new AstPrinter.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE446=null;
        AstPrinter.alias_return alias447 =null;


        CommonTree OTHERWISE446_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:608:5: ( ^( OTHERWISE alias ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:608:7: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE446=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise4448); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE446_tree = (CommonTree)adaptor.dupNode(OTHERWISE446);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE446_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise4450);
            alias447=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias447.getTree());


            if ( state.backtracking==0 ) { sb.append(" " + (OTHERWISE446!=null?OTHERWISE446.getText():null)); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:611:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AstPrinter.col_ref_return col_ref() throws RecognitionException {
        AstPrinter.col_ref_return retval = new AstPrinter.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.alias_col_ref_return alias_col_ref448 =null;

        AstPrinter.dollar_col_ref_return dollar_col_ref449 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:611:9: ( alias_col_ref | dollar_col_ref )
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==CUBE||LA122_0==GROUP||LA122_0==IDENTIFIER) ) {
                alt122=1;
            }
            else if ( (LA122_0==DOLLARVAR) ) {
                alt122=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;

            }
            switch (alt122) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:611:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref4463);
                    alias_col_ref448=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref448.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:611:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref4467);
                    dollar_col_ref449=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref449.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_ref"


    public static class alias_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias_col_ref"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:614:1: alias_col_ref : ( GROUP | CUBE | IDENTIFIER );
    public final AstPrinter.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AstPrinter.alias_col_ref_return retval = new AstPrinter.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP450=null;
        CommonTree CUBE451=null;
        CommonTree IDENTIFIER452=null;

        CommonTree GROUP450_tree=null;
        CommonTree CUBE451_tree=null;
        CommonTree IDENTIFIER452_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:615:5: ( GROUP | CUBE | IDENTIFIER )
            int alt123=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt123=1;
                }
                break;
            case CUBE:
                {
                alt123=2;
                }
                break;
            case IDENTIFIER:
                {
                alt123=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;

            }

            switch (alt123) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:615:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP450=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref4480); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP450_tree = (CommonTree)adaptor.dupNode(GROUP450);


                    adaptor.addChild(root_0, GROUP450_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP450!=null?GROUP450.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:616:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE451=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref4490); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE451_tree = (CommonTree)adaptor.dupNode(CUBE451);


                    adaptor.addChild(root_0, CUBE451_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CUBE451!=null?CUBE451.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:617:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER452=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref4500); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER452_tree = (CommonTree)adaptor.dupNode(IDENTIFIER452);


                    adaptor.addChild(root_0, IDENTIFIER452_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER452!=null?IDENTIFIER452.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:620:1: dollar_col_ref : DOLLARVAR ;
    public final AstPrinter.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AstPrinter.dollar_col_ref_return retval = new AstPrinter.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR453=null;

        CommonTree DOLLARVAR453_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:621:5: ( DOLLARVAR )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:621:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR453=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref4515); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR453_tree = (CommonTree)adaptor.dupNode(DOLLARVAR453);


            adaptor.addChild(root_0, DOLLARVAR453_tree);
            }


            if ( state.backtracking==0 ) { sb.append((DOLLARVAR453!=null?DOLLARVAR453.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dollar_col_ref"


    public static class const_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:624:1: const_expr : literal ;
    public final AstPrinter.const_expr_return const_expr() throws RecognitionException {
        AstPrinter.const_expr_return retval = new AstPrinter.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.literal_return literal454 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:624:12: ( literal )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:624:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr4526);
            literal454=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal454.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "const_expr"


    public static class literal_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:627:1: literal : ( scalar | map | bag | tuple );
    public final AstPrinter.literal_return literal() throws RecognitionException {
        AstPrinter.literal_return retval = new AstPrinter.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.scalar_return scalar455 =null;

        AstPrinter.map_return map456 =null;

        AstPrinter.bag_return bag457 =null;

        AstPrinter.tuple_return tuple458 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:627:9: ( scalar | map | bag | tuple )
            int alt124=4;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case QUOTEDSTRING:
            case TRUE:
                {
                alt124=1;
                }
                break;
            case MAP_VAL:
                {
                alt124=2;
                }
                break;
            case BAG_VAL:
                {
                alt124=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt124=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;

            }

            switch (alt124) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:627:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal4535);
                    scalar455=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar455.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:627:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal4539);
                    map456=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map456.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:627:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal4543);
                    bag457=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag457.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:627:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal4547);
                    tuple458=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple458.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal"


    public static class scalar_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalar"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:630:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AstPrinter.scalar_return scalar() throws RecognitionException {
        AstPrinter.scalar_return retval = new AstPrinter.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING460=null;
        CommonTree NULL461=null;
        CommonTree TRUE462=null;
        CommonTree FALSE463=null;
        AstPrinter.num_scalar_return num_scalar459 =null;


        CommonTree QUOTEDSTRING460_tree=null;
        CommonTree NULL461_tree=null;
        CommonTree TRUE462_tree=null;
        CommonTree FALSE463_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:630:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt125=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt125=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt125=2;
                }
                break;
            case NULL:
                {
                alt125=3;
                }
                break;
            case TRUE:
                {
                alt125=4;
                }
                break;
            case FALSE:
                {
                alt125=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;

            }

            switch (alt125) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:630:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar4556);
                    num_scalar459=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar459.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:631:10: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING460=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar4567); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING460_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING460);


                    adaptor.addChild(root_0, QUOTEDSTRING460_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING460!=null?QUOTEDSTRING460.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:632:10: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL461=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar4580); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL461_tree = (CommonTree)adaptor.dupNode(NULL461);


                    adaptor.addChild(root_0, NULL461_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NULL461!=null?NULL461.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:633:10: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE462=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar4593); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE462_tree = (CommonTree)adaptor.dupNode(TRUE462);


                    adaptor.addChild(root_0, TRUE462_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TRUE462!=null?TRUE462.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:634:10: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE463=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar4606); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE463_tree = (CommonTree)adaptor.dupNode(FALSE463);


                    adaptor.addChild(root_0, FALSE463_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FALSE463!=null?FALSE463.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "scalar"


    public static class num_scalar_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:637:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final AstPrinter.num_scalar_return num_scalar() throws RecognitionException {
        AstPrinter.num_scalar_return retval = new AstPrinter.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS464=null;
        CommonTree INTEGER465=null;
        CommonTree LONGINTEGER466=null;
        CommonTree FLOATNUMBER467=null;
        CommonTree DOUBLENUMBER468=null;
        CommonTree BIGINTEGERNUMBER469=null;
        CommonTree BIGDECIMALNUMBER470=null;

        CommonTree MINUS464_tree=null;
        CommonTree INTEGER465_tree=null;
        CommonTree LONGINTEGER466_tree=null;
        CommonTree FLOATNUMBER467_tree=null;
        CommonTree DOUBLENUMBER468_tree=null;
        CommonTree BIGINTEGERNUMBER469_tree=null;
        CommonTree BIGDECIMALNUMBER470_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:637:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:637:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:637:14: ( MINUS )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==MINUS) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:637:16: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS464=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar4619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS464_tree = (CommonTree)adaptor.dupNode(MINUS464);


                    adaptor.addChild(root_0, MINUS464_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append( "-" ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:638:14: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            int alt127=6;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt127=1;
                }
                break;
            case LONGINTEGER:
                {
                alt127=2;
                }
                break;
            case FLOATNUMBER:
                {
                alt127=3;
                }
                break;
            case DOUBLENUMBER:
                {
                alt127=4;
                }
                break;
            case BIGINTEGERNUMBER:
                {
                alt127=5;
                }
                break;
            case BIGDECIMALNUMBER:
                {
                alt127=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;

            }

            switch (alt127) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:638:16: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER465=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_num_scalar4641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER465_tree = (CommonTree)adaptor.dupNode(INTEGER465);


                    adaptor.addChild(root_0, INTEGER465_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INTEGER465!=null?INTEGER465.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:639:16: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER466=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_num_scalar4660); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER466_tree = (CommonTree)adaptor.dupNode(LONGINTEGER466);


                    adaptor.addChild(root_0, LONGINTEGER466_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LONGINTEGER466!=null?LONGINTEGER466.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:640:16: FLOATNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    FLOATNUMBER467=(CommonTree)match(input,FLOATNUMBER,FOLLOW_FLOATNUMBER_in_num_scalar4679); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOATNUMBER467_tree = (CommonTree)adaptor.dupNode(FLOATNUMBER467);


                    adaptor.addChild(root_0, FLOATNUMBER467_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLOATNUMBER467!=null?FLOATNUMBER467.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:641:16: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER468=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_num_scalar4698); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER468_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER468);


                    adaptor.addChild(root_0, DOUBLENUMBER468_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DOUBLENUMBER468!=null?DOUBLENUMBER468.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:642:16: BIGINTEGERNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGINTEGERNUMBER469=(CommonTree)match(input,BIGINTEGERNUMBER,FOLLOW_BIGINTEGERNUMBER_in_num_scalar4717); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGERNUMBER469_tree = (CommonTree)adaptor.dupNode(BIGINTEGERNUMBER469);


                    adaptor.addChild(root_0, BIGINTEGERNUMBER469_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGINTEGERNUMBER469!=null?BIGINTEGERNUMBER469.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:643:16: BIGDECIMALNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGDECIMALNUMBER470=(CommonTree)match(input,BIGDECIMALNUMBER,FOLLOW_BIGDECIMALNUMBER_in_num_scalar4736); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMALNUMBER470_tree = (CommonTree)adaptor.dupNode(BIGDECIMALNUMBER470);


                    adaptor.addChild(root_0, BIGDECIMALNUMBER470_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGDECIMALNUMBER470!=null?BIGDECIMALNUMBER470.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "num_scalar"


    public static class map_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:647:1: map : ( ^( MAP_VAL keyvalue ( keyvalue )* ) | ^( MAP_VAL ) );
    public final AstPrinter.map_return map() throws RecognitionException {
        AstPrinter.map_return retval = new AstPrinter.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL471=null;
        CommonTree MAP_VAL474=null;
        AstPrinter.keyvalue_return keyvalue472 =null;

        AstPrinter.keyvalue_return keyvalue473 =null;


        CommonTree MAP_VAL471_tree=null;
        CommonTree MAP_VAL474_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:648:5: ( ^( MAP_VAL keyvalue ( keyvalue )* ) | ^( MAP_VAL ) )
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==MAP_VAL) ) {
                int LA129_1 = input.LA(2);

                if ( (LA129_1==DOWN) ) {
                    int LA129_2 = input.LA(3);

                    if ( (LA129_2==KEY_VAL_PAIR) ) {
                        alt129=1;
                    }
                    else if ( (LA129_2==UP) ) {
                        alt129=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 129, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 129, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;

            }
            switch (alt129) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:648:7: ^( MAP_VAL keyvalue ( keyvalue )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MAP_VAL471=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map4768); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP_VAL471_tree = (CommonTree)adaptor.dupNode(MAP_VAL471);


                    root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL471_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("["); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_keyvalue_in_map4772);
                    keyvalue472=keyvalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, keyvalue472.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:648:47: ( keyvalue )*
                    loop128:
                    do {
                        int alt128=2;
                        int LA128_0 = input.LA(1);

                        if ( (LA128_0==KEY_VAL_PAIR) ) {
                            alt128=1;
                        }


                        switch (alt128) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:648:49: keyvalue
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyvalue_in_map4778);
                    	    keyvalue473=keyvalue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, keyvalue473.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop128;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append("]"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:649:7: ^( MAP_VAL )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MAP_VAL474=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map4794); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP_VAL474_tree = (CommonTree)adaptor.dupNode(MAP_VAL474);


                    root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL474_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("[]"); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:652:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AstPrinter.keyvalue_return keyvalue() throws RecognitionException {
        AstPrinter.keyvalue_return retval = new AstPrinter.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR475=null;
        AstPrinter.map_key_return map_key476 =null;

        AstPrinter.const_expr_return const_expr477 =null;


        CommonTree KEY_VAL_PAIR475_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:653:5: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:653:7: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR475=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue4813); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR475_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR475);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR475_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue4815);
            map_key476=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key476.getTree());


            if ( state.backtracking==0 ) { sb.append("#"); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue4819);
            const_expr477=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr477.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "keyvalue"


    public static class map_key_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_key"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:656:1: map_key : QUOTEDSTRING ;
    public final AstPrinter.map_key_return map_key() throws RecognitionException {
        AstPrinter.map_key_return retval = new AstPrinter.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING478=null;

        CommonTree QUOTEDSTRING478_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:656:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:656:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING478=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key4830); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING478_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING478);


            adaptor.addChild(root_0, QUOTEDSTRING478_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING478!=null?QUOTEDSTRING478.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_key"


    public static class bag_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:659:1: bag : ( ^( BAG_VAL tuple ( tuple )* ) | ^( BAG_VAL ) );
    public final AstPrinter.bag_return bag() throws RecognitionException {
        AstPrinter.bag_return retval = new AstPrinter.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL479=null;
        CommonTree BAG_VAL482=null;
        AstPrinter.tuple_return tuple480 =null;

        AstPrinter.tuple_return tuple481 =null;


        CommonTree BAG_VAL479_tree=null;
        CommonTree BAG_VAL482_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:660:5: ( ^( BAG_VAL tuple ( tuple )* ) | ^( BAG_VAL ) )
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==BAG_VAL) ) {
                int LA131_1 = input.LA(2);

                if ( (LA131_1==DOWN) ) {
                    int LA131_2 = input.LA(3);

                    if ( (LA131_2==TUPLE_VAL) ) {
                        alt131=1;
                    }
                    else if ( (LA131_2==UP) ) {
                        alt131=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 131, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 131, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;

            }
            switch (alt131) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:660:7: ^( BAG_VAL tuple ( tuple )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BAG_VAL479=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag4847); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG_VAL479_tree = (CommonTree)adaptor.dupNode(BAG_VAL479);


                    root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL479_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("{"); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_bag4851);
                    tuple480=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, tuple480.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:660:44: ( tuple )*
                    loop130:
                    do {
                        int alt130=2;
                        int LA130_0 = input.LA(1);

                        if ( (LA130_0==TUPLE_VAL) ) {
                            alt130=1;
                        }


                        switch (alt130) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:660:46: tuple
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_tuple_in_bag4857);
                    	    tuple481=tuple();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, tuple481.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop130;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append("}"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:661:7: ^( BAG_VAL )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BAG_VAL482=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag4873); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG_VAL482_tree = (CommonTree)adaptor.dupNode(BAG_VAL482);


                    root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL482_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("{}"); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag"


    public static class tuple_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:664:1: tuple : ( ^( TUPLE_VAL literal ( literal )* ) | ^( TUPLE_VAL ) );
    public final AstPrinter.tuple_return tuple() throws RecognitionException {
        AstPrinter.tuple_return retval = new AstPrinter.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL483=null;
        CommonTree TUPLE_VAL486=null;
        AstPrinter.literal_return literal484 =null;

        AstPrinter.literal_return literal485 =null;


        CommonTree TUPLE_VAL483_tree=null;
        CommonTree TUPLE_VAL486_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:665:5: ( ^( TUPLE_VAL literal ( literal )* ) | ^( TUPLE_VAL ) )
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==TUPLE_VAL) ) {
                int LA133_1 = input.LA(2);

                if ( (LA133_1==DOWN) ) {
                    int LA133_2 = input.LA(3);

                    if ( (LA133_2==BIGDECIMALNUMBER||LA133_2==BIGINTEGERNUMBER||LA133_2==DOUBLENUMBER||LA133_2==FALSE||LA133_2==FLOATNUMBER||LA133_2==INTEGER||LA133_2==LONGINTEGER||LA133_2==MINUS||LA133_2==NULL||LA133_2==QUOTEDSTRING||LA133_2==TRUE||LA133_2==BAG_VAL||LA133_2==MAP_VAL||LA133_2==TUPLE_VAL) ) {
                        alt133=1;
                    }
                    else if ( (LA133_2==UP) ) {
                        alt133=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 133, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 133, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;

            }
            switch (alt133) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:665:7: ^( TUPLE_VAL literal ( literal )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_VAL483=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple4892); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_VAL483_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL483);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL483_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_literal_in_tuple4896);
                    literal484=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, literal484.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:665:48: ( literal )*
                    loop132:
                    do {
                        int alt132=2;
                        int LA132_0 = input.LA(1);

                        if ( (LA132_0==BIGDECIMALNUMBER||LA132_0==BIGINTEGERNUMBER||LA132_0==DOUBLENUMBER||LA132_0==FALSE||LA132_0==FLOATNUMBER||LA132_0==INTEGER||LA132_0==LONGINTEGER||LA132_0==MINUS||LA132_0==NULL||LA132_0==QUOTEDSTRING||LA132_0==TRUE||LA132_0==BAG_VAL||LA132_0==MAP_VAL||LA132_0==TUPLE_VAL) ) {
                            alt132=1;
                        }


                        switch (alt132) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:665:50: literal
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_literal_in_tuple4903);
                    	    literal485=literal();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, literal485.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop132;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:666:7: ^( TUPLE_VAL )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_VAL486=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple4919); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_VAL486_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL486);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL486_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("()"); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple"


    public static class eid_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:670:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | PIVOT | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | IN | CASE | ASSERT );
    public final AstPrinter.eid_return eid() throws RecognitionException {
        AstPrinter.eid_return retval = new AstPrinter.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT488=null;
        CommonTree RETURNS489=null;
        CommonTree DEFINE490=null;
        CommonTree LOAD491=null;
        CommonTree FILTER492=null;
        CommonTree FOREACH493=null;
        CommonTree CUBE494=null;
        CommonTree ROLLUP495=null;
        CommonTree PIVOT496=null;
        CommonTree MATCHES497=null;
        CommonTree ORDER498=null;
        CommonTree RANK499=null;
        CommonTree DISTINCT500=null;
        CommonTree COGROUP501=null;
        CommonTree JOIN502=null;
        CommonTree CROSS503=null;
        CommonTree UNION504=null;
        CommonTree SPLIT505=null;
        CommonTree INTO506=null;
        CommonTree IF507=null;
        CommonTree ALL508=null;
        CommonTree AS509=null;
        CommonTree BY510=null;
        CommonTree USING511=null;
        CommonTree INNER512=null;
        CommonTree OUTER513=null;
        CommonTree PARALLEL514=null;
        CommonTree PARTITION515=null;
        CommonTree GROUP516=null;
        CommonTree AND517=null;
        CommonTree OR518=null;
        CommonTree NOT519=null;
        CommonTree GENERATE520=null;
        CommonTree FLATTEN521=null;
        CommonTree EVAL522=null;
        CommonTree ASC523=null;
        CommonTree DESC524=null;
        CommonTree BOOLEAN525=null;
        CommonTree INT526=null;
        CommonTree LONG527=null;
        CommonTree FLOAT528=null;
        CommonTree DOUBLE529=null;
        CommonTree BIGINTEGER530=null;
        CommonTree BIGDECIMAL531=null;
        CommonTree DATETIME532=null;
        CommonTree CHARARRAY533=null;
        CommonTree BYTEARRAY534=null;
        CommonTree BAG535=null;
        CommonTree TUPLE536=null;
        CommonTree MAP537=null;
        CommonTree IS538=null;
        CommonTree NULL539=null;
        CommonTree TRUE540=null;
        CommonTree FALSE541=null;
        CommonTree STREAM542=null;
        CommonTree THROUGH543=null;
        CommonTree STORE544=null;
        CommonTree MAPREDUCE545=null;
        CommonTree SHIP546=null;
        CommonTree CACHE547=null;
        CommonTree INPUT548=null;
        CommonTree OUTPUT549=null;
        CommonTree STDERROR550=null;
        CommonTree STDIN551=null;
        CommonTree STDOUT552=null;
        CommonTree LIMIT553=null;
        CommonTree SAMPLE554=null;
        CommonTree LEFT555=null;
        CommonTree RIGHT556=null;
        CommonTree FULL557=null;
        CommonTree IDENTIFIER558=null;
        CommonTree TOBAG559=null;
        CommonTree TOMAP560=null;
        CommonTree TOTUPLE561=null;
        CommonTree IN562=null;
        CommonTree CASE563=null;
        CommonTree ASSERT564=null;
        AstPrinter.rel_str_op_return rel_str_op487 =null;


        CommonTree IMPORT488_tree=null;
        CommonTree RETURNS489_tree=null;
        CommonTree DEFINE490_tree=null;
        CommonTree LOAD491_tree=null;
        CommonTree FILTER492_tree=null;
        CommonTree FOREACH493_tree=null;
        CommonTree CUBE494_tree=null;
        CommonTree ROLLUP495_tree=null;
        CommonTree PIVOT496_tree=null;
        CommonTree MATCHES497_tree=null;
        CommonTree ORDER498_tree=null;
        CommonTree RANK499_tree=null;
        CommonTree DISTINCT500_tree=null;
        CommonTree COGROUP501_tree=null;
        CommonTree JOIN502_tree=null;
        CommonTree CROSS503_tree=null;
        CommonTree UNION504_tree=null;
        CommonTree SPLIT505_tree=null;
        CommonTree INTO506_tree=null;
        CommonTree IF507_tree=null;
        CommonTree ALL508_tree=null;
        CommonTree AS509_tree=null;
        CommonTree BY510_tree=null;
        CommonTree USING511_tree=null;
        CommonTree INNER512_tree=null;
        CommonTree OUTER513_tree=null;
        CommonTree PARALLEL514_tree=null;
        CommonTree PARTITION515_tree=null;
        CommonTree GROUP516_tree=null;
        CommonTree AND517_tree=null;
        CommonTree OR518_tree=null;
        CommonTree NOT519_tree=null;
        CommonTree GENERATE520_tree=null;
        CommonTree FLATTEN521_tree=null;
        CommonTree EVAL522_tree=null;
        CommonTree ASC523_tree=null;
        CommonTree DESC524_tree=null;
        CommonTree BOOLEAN525_tree=null;
        CommonTree INT526_tree=null;
        CommonTree LONG527_tree=null;
        CommonTree FLOAT528_tree=null;
        CommonTree DOUBLE529_tree=null;
        CommonTree BIGINTEGER530_tree=null;
        CommonTree BIGDECIMAL531_tree=null;
        CommonTree DATETIME532_tree=null;
        CommonTree CHARARRAY533_tree=null;
        CommonTree BYTEARRAY534_tree=null;
        CommonTree BAG535_tree=null;
        CommonTree TUPLE536_tree=null;
        CommonTree MAP537_tree=null;
        CommonTree IS538_tree=null;
        CommonTree NULL539_tree=null;
        CommonTree TRUE540_tree=null;
        CommonTree FALSE541_tree=null;
        CommonTree STREAM542_tree=null;
        CommonTree THROUGH543_tree=null;
        CommonTree STORE544_tree=null;
        CommonTree MAPREDUCE545_tree=null;
        CommonTree SHIP546_tree=null;
        CommonTree CACHE547_tree=null;
        CommonTree INPUT548_tree=null;
        CommonTree OUTPUT549_tree=null;
        CommonTree STDERROR550_tree=null;
        CommonTree STDIN551_tree=null;
        CommonTree STDOUT552_tree=null;
        CommonTree LIMIT553_tree=null;
        CommonTree SAMPLE554_tree=null;
        CommonTree LEFT555_tree=null;
        CommonTree RIGHT556_tree=null;
        CommonTree FULL557_tree=null;
        CommonTree IDENTIFIER558_tree=null;
        CommonTree TOBAG559_tree=null;
        CommonTree TOMAP560_tree=null;
        CommonTree TOTUPLE561_tree=null;
        CommonTree IN562_tree=null;
        CommonTree CASE563_tree=null;
        CommonTree ASSERT564_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:670:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | PIVOT | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | IN | CASE | ASSERT )
            int alt134=78;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt134=1;
                }
                break;
            case IMPORT:
                {
                alt134=2;
                }
                break;
            case RETURNS:
                {
                alt134=3;
                }
                break;
            case DEFINE:
                {
                alt134=4;
                }
                break;
            case LOAD:
                {
                alt134=5;
                }
                break;
            case FILTER:
                {
                alt134=6;
                }
                break;
            case FOREACH:
                {
                alt134=7;
                }
                break;
            case CUBE:
                {
                alt134=8;
                }
                break;
            case ROLLUP:
                {
                alt134=9;
                }
                break;
            case PIVOT:
                {
                alt134=10;
                }
                break;
            case MATCHES:
                {
                alt134=11;
                }
                break;
            case ORDER:
                {
                alt134=12;
                }
                break;
            case RANK:
                {
                alt134=13;
                }
                break;
            case DISTINCT:
                {
                alt134=14;
                }
                break;
            case COGROUP:
                {
                alt134=15;
                }
                break;
            case JOIN:
                {
                alt134=16;
                }
                break;
            case CROSS:
                {
                alt134=17;
                }
                break;
            case UNION:
                {
                alt134=18;
                }
                break;
            case SPLIT:
                {
                alt134=19;
                }
                break;
            case INTO:
                {
                alt134=20;
                }
                break;
            case IF:
                {
                alt134=21;
                }
                break;
            case ALL:
                {
                alt134=22;
                }
                break;
            case AS:
                {
                alt134=23;
                }
                break;
            case BY:
                {
                alt134=24;
                }
                break;
            case USING:
                {
                alt134=25;
                }
                break;
            case INNER:
                {
                alt134=26;
                }
                break;
            case OUTER:
                {
                alt134=27;
                }
                break;
            case PARALLEL:
                {
                alt134=28;
                }
                break;
            case PARTITION:
                {
                alt134=29;
                }
                break;
            case GROUP:
                {
                alt134=30;
                }
                break;
            case AND:
                {
                alt134=31;
                }
                break;
            case OR:
                {
                alt134=32;
                }
                break;
            case NOT:
                {
                alt134=33;
                }
                break;
            case GENERATE:
                {
                alt134=34;
                }
                break;
            case FLATTEN:
                {
                alt134=35;
                }
                break;
            case EVAL:
                {
                alt134=36;
                }
                break;
            case ASC:
                {
                alt134=37;
                }
                break;
            case DESC:
                {
                alt134=38;
                }
                break;
            case BOOLEAN:
                {
                alt134=39;
                }
                break;
            case INT:
                {
                alt134=40;
                }
                break;
            case LONG:
                {
                alt134=41;
                }
                break;
            case FLOAT:
                {
                alt134=42;
                }
                break;
            case DOUBLE:
                {
                alt134=43;
                }
                break;
            case BIGINTEGER:
                {
                alt134=44;
                }
                break;
            case BIGDECIMAL:
                {
                alt134=45;
                }
                break;
            case DATETIME:
                {
                alt134=46;
                }
                break;
            case CHARARRAY:
                {
                alt134=47;
                }
                break;
            case BYTEARRAY:
                {
                alt134=48;
                }
                break;
            case BAG:
                {
                alt134=49;
                }
                break;
            case TUPLE:
                {
                alt134=50;
                }
                break;
            case MAP:
                {
                alt134=51;
                }
                break;
            case IS:
                {
                alt134=52;
                }
                break;
            case NULL:
                {
                alt134=53;
                }
                break;
            case TRUE:
                {
                alt134=54;
                }
                break;
            case FALSE:
                {
                alt134=55;
                }
                break;
            case STREAM:
                {
                alt134=56;
                }
                break;
            case THROUGH:
                {
                alt134=57;
                }
                break;
            case STORE:
                {
                alt134=58;
                }
                break;
            case MAPREDUCE:
                {
                alt134=59;
                }
                break;
            case SHIP:
                {
                alt134=60;
                }
                break;
            case CACHE:
                {
                alt134=61;
                }
                break;
            case INPUT:
                {
                alt134=62;
                }
                break;
            case OUTPUT:
                {
                alt134=63;
                }
                break;
            case STDERROR:
                {
                alt134=64;
                }
                break;
            case STDIN:
                {
                alt134=65;
                }
                break;
            case STDOUT:
                {
                alt134=66;
                }
                break;
            case LIMIT:
                {
                alt134=67;
                }
                break;
            case SAMPLE:
                {
                alt134=68;
                }
                break;
            case LEFT:
                {
                alt134=69;
                }
                break;
            case RIGHT:
                {
                alt134=70;
                }
                break;
            case FULL:
                {
                alt134=71;
                }
                break;
            case IDENTIFIER:
                {
                alt134=72;
                }
                break;
            case TOBAG:
                {
                alt134=73;
                }
                break;
            case TOMAP:
                {
                alt134=74;
                }
                break;
            case TOTUPLE:
                {
                alt134=75;
                }
                break;
            case IN:
                {
                alt134=76;
                }
                break;
            case CASE:
                {
                alt134=77;
                }
                break;
            case ASSERT:
                {
                alt134=78;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;

            }

            switch (alt134) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:670:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid4933);
                    rel_str_op487=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op487.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:671:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT488=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid4941); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT488_tree = (CommonTree)adaptor.dupNode(IMPORT488);


                    adaptor.addChild(root_0, IMPORT488_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IMPORT488!=null?IMPORT488.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:672:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS489=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid4954); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS489_tree = (CommonTree)adaptor.dupNode(RETURNS489);


                    adaptor.addChild(root_0, RETURNS489_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((RETURNS489!=null?RETURNS489.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:673:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE490=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid4966); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE490_tree = (CommonTree)adaptor.dupNode(DEFINE490);


                    adaptor.addChild(root_0, DEFINE490_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DEFINE490!=null?DEFINE490.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:674:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD491=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid4979); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD491_tree = (CommonTree)adaptor.dupNode(LOAD491);


                    adaptor.addChild(root_0, LOAD491_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LOAD491!=null?LOAD491.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:675:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER492=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid4994); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER492_tree = (CommonTree)adaptor.dupNode(FILTER492);


                    adaptor.addChild(root_0, FILTER492_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FILTER492!=null?FILTER492.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:676:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH493=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid5007); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH493_tree = (CommonTree)adaptor.dupNode(FOREACH493);


                    adaptor.addChild(root_0, FOREACH493_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FOREACH493!=null?FOREACH493.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:677:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE494=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid5019); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE494_tree = (CommonTree)adaptor.dupNode(CUBE494);


                    adaptor.addChild(root_0, CUBE494_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CUBE494!=null?CUBE494.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:678:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP495=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid5034); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP495_tree = (CommonTree)adaptor.dupNode(ROLLUP495);


                    adaptor.addChild(root_0, ROLLUP495_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ROLLUP495!=null?ROLLUP495.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:679:7: PIVOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PIVOT496=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_eid5047); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PIVOT496_tree = (CommonTree)adaptor.dupNode(PIVOT496);


                    adaptor.addChild(root_0, PIVOT496_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((PIVOT496!=null?PIVOT496.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:680:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES497=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid5061); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES497_tree = (CommonTree)adaptor.dupNode(MATCHES497);


                    adaptor.addChild(root_0, MATCHES497_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MATCHES497!=null?MATCHES497.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:681:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER498=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid5073); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER498_tree = (CommonTree)adaptor.dupNode(ORDER498);


                    adaptor.addChild(root_0, ORDER498_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ORDER498!=null?ORDER498.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:682:7: RANK
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RANK499=(CommonTree)match(input,RANK,FOLLOW_RANK_in_eid5087); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RANK499_tree = (CommonTree)adaptor.dupNode(RANK499);


                    adaptor.addChild(root_0, RANK499_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((RANK499!=null?RANK499.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:683:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT500=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid5102); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT500_tree = (CommonTree)adaptor.dupNode(DISTINCT500);


                    adaptor.addChild(root_0, DISTINCT500_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DISTINCT500!=null?DISTINCT500.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:684:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP501=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid5113); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP501_tree = (CommonTree)adaptor.dupNode(COGROUP501);


                    adaptor.addChild(root_0, COGROUP501_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((COGROUP501!=null?COGROUP501.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:685:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN502=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid5125); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN502_tree = (CommonTree)adaptor.dupNode(JOIN502);


                    adaptor.addChild(root_0, JOIN502_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((JOIN502!=null?JOIN502.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:686:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS503=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid5140); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS503_tree = (CommonTree)adaptor.dupNode(CROSS503);


                    adaptor.addChild(root_0, CROSS503_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CROSS503!=null?CROSS503.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:687:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION504=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid5154); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION504_tree = (CommonTree)adaptor.dupNode(UNION504);


                    adaptor.addChild(root_0, UNION504_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((UNION504!=null?UNION504.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:688:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT505=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid5168); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT505_tree = (CommonTree)adaptor.dupNode(SPLIT505);


                    adaptor.addChild(root_0, SPLIT505_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((SPLIT505!=null?SPLIT505.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:689:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO506=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid5182); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO506_tree = (CommonTree)adaptor.dupNode(INTO506);


                    adaptor.addChild(root_0, INTO506_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INTO506!=null?INTO506.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:690:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF507=(CommonTree)match(input,IF,FOLLOW_IF_in_eid5197); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF507_tree = (CommonTree)adaptor.dupNode(IF507);


                    adaptor.addChild(root_0, IF507_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IF507!=null?IF507.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:691:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL508=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid5214); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL508_tree = (CommonTree)adaptor.dupNode(ALL508);


                    adaptor.addChild(root_0, ALL508_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ALL508!=null?ALL508.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:692:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS509=(CommonTree)match(input,AS,FOLLOW_AS_in_eid5230); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS509_tree = (CommonTree)adaptor.dupNode(AS509);


                    adaptor.addChild(root_0, AS509_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((AS509!=null?AS509.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:693:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY510=(CommonTree)match(input,BY,FOLLOW_BY_in_eid5247); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY510_tree = (CommonTree)adaptor.dupNode(BY510);


                    adaptor.addChild(root_0, BY510_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BY510!=null?BY510.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:694:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING511=(CommonTree)match(input,USING,FOLLOW_USING_in_eid5264); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING511_tree = (CommonTree)adaptor.dupNode(USING511);


                    adaptor.addChild(root_0, USING511_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((USING511!=null?USING511.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:695:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER512=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid5278); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER512_tree = (CommonTree)adaptor.dupNode(INNER512);


                    adaptor.addChild(root_0, INNER512_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INNER512!=null?INNER512.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:696:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER513=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid5292); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER513_tree = (CommonTree)adaptor.dupNode(OUTER513);


                    adaptor.addChild(root_0, OUTER513_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((OUTER513!=null?OUTER513.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:697:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL514=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid5306); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL514_tree = (CommonTree)adaptor.dupNode(PARALLEL514);


                    adaptor.addChild(root_0, PARALLEL514_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((PARALLEL514!=null?PARALLEL514.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:698:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION515=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid5317); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION515_tree = (CommonTree)adaptor.dupNode(PARTITION515);


                    adaptor.addChild(root_0, PARTITION515_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((PARTITION515!=null?PARTITION515.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:699:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP516=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid5327); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP516_tree = (CommonTree)adaptor.dupNode(GROUP516);


                    adaptor.addChild(root_0, GROUP516_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP516!=null?GROUP516.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:700:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND517=(CommonTree)match(input,AND,FOLLOW_AND_in_eid5341); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND517_tree = (CommonTree)adaptor.dupNode(AND517);


                    adaptor.addChild(root_0, AND517_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((AND517!=null?AND517.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:701:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR518=(CommonTree)match(input,OR,FOLLOW_OR_in_eid5357); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR518_tree = (CommonTree)adaptor.dupNode(OR518);


                    adaptor.addChild(root_0, OR518_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((OR518!=null?OR518.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:702:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT519=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid5374); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT519_tree = (CommonTree)adaptor.dupNode(NOT519);


                    adaptor.addChild(root_0, NOT519_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NOT519!=null?NOT519.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:703:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE520=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid5390); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE520_tree = (CommonTree)adaptor.dupNode(GENERATE520);


                    adaptor.addChild(root_0, GENERATE520_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GENERATE520!=null?GENERATE520.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:704:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN521=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid5401); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN521_tree = (CommonTree)adaptor.dupNode(FLATTEN521);


                    adaptor.addChild(root_0, FLATTEN521_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLATTEN521!=null?FLATTEN521.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:705:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL522=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid5413); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL522_tree = (CommonTree)adaptor.dupNode(EVAL522);


                    adaptor.addChild(root_0, EVAL522_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((EVAL522!=null?EVAL522.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:706:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC523=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid5428); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC523_tree = (CommonTree)adaptor.dupNode(ASC523);


                    adaptor.addChild(root_0, ASC523_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ASC523!=null?ASC523.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:707:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC524=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid5444); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC524_tree = (CommonTree)adaptor.dupNode(DESC524);


                    adaptor.addChild(root_0, DESC524_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DESC524!=null?DESC524.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:708:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN525=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid5459); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN525_tree = (CommonTree)adaptor.dupNode(BOOLEAN525);


                    adaptor.addChild(root_0, BOOLEAN525_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BOOLEAN525!=null?BOOLEAN525.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:709:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT526=(CommonTree)match(input,INT,FOLLOW_INT_in_eid5471); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT526_tree = (CommonTree)adaptor.dupNode(INT526);


                    adaptor.addChild(root_0, INT526_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INT526!=null?INT526.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:710:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG527=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid5487); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG527_tree = (CommonTree)adaptor.dupNode(LONG527);


                    adaptor.addChild(root_0, LONG527_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LONG527!=null?LONG527.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:711:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT528=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid5502); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT528_tree = (CommonTree)adaptor.dupNode(FLOAT528);


                    adaptor.addChild(root_0, FLOAT528_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLOAT528!=null?FLOAT528.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:712:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE529=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid5516); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE529_tree = (CommonTree)adaptor.dupNode(DOUBLE529);


                    adaptor.addChild(root_0, DOUBLE529_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DOUBLE529!=null?DOUBLE529.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:713:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER530=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid5529); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER530_tree = (CommonTree)adaptor.dupNode(BIGINTEGER530);


                    adaptor.addChild(root_0, BIGINTEGER530_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGINTEGER530!=null?BIGINTEGER530.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:714:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL531=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid5538); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL531_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL531);


                    adaptor.addChild(root_0, BIGDECIMAL531_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGDECIMAL531!=null?BIGDECIMAL531.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:715:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME532=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid5547); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME532_tree = (CommonTree)adaptor.dupNode(DATETIME532);


                    adaptor.addChild(root_0, DATETIME532_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DATETIME532!=null?DATETIME532.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:716:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY533=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid5558); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY533_tree = (CommonTree)adaptor.dupNode(CHARARRAY533);


                    adaptor.addChild(root_0, CHARARRAY533_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CHARARRAY533!=null?CHARARRAY533.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:717:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY534=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid5568); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY534_tree = (CommonTree)adaptor.dupNode(BYTEARRAY534);


                    adaptor.addChild(root_0, BYTEARRAY534_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BYTEARRAY534!=null?BYTEARRAY534.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:718:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG535=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid5578); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG535_tree = (CommonTree)adaptor.dupNode(BAG535);


                    adaptor.addChild(root_0, BAG535_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BAG535!=null?BAG535.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:719:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE536=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid5594); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE536_tree = (CommonTree)adaptor.dupNode(TUPLE536);


                    adaptor.addChild(root_0, TUPLE536_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TUPLE536!=null?TUPLE536.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:720:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP537=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid5608); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP537_tree = (CommonTree)adaptor.dupNode(MAP537);


                    adaptor.addChild(root_0, MAP537_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MAP537!=null?MAP537.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:721:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS538=(CommonTree)match(input,IS,FOLLOW_IS_in_eid5624); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS538_tree = (CommonTree)adaptor.dupNode(IS538);


                    adaptor.addChild(root_0, IS538_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IS538!=null?IS538.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:722:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL539=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid5641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL539_tree = (CommonTree)adaptor.dupNode(NULL539);


                    adaptor.addChild(root_0, NULL539_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NULL539!=null?NULL539.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:723:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE540=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid5656); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE540_tree = (CommonTree)adaptor.dupNode(TRUE540);


                    adaptor.addChild(root_0, TRUE540_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TRUE540!=null?TRUE540.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:724:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE541=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid5671); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE541_tree = (CommonTree)adaptor.dupNode(FALSE541);


                    adaptor.addChild(root_0, FALSE541_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FALSE541!=null?FALSE541.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:725:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM542=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid5685); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM542_tree = (CommonTree)adaptor.dupNode(STREAM542);


                    adaptor.addChild(root_0, STREAM542_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STREAM542!=null?STREAM542.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:726:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH543=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid5698); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH543_tree = (CommonTree)adaptor.dupNode(THROUGH543);


                    adaptor.addChild(root_0, THROUGH543_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((THROUGH543!=null?THROUGH543.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:727:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE544=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid5710); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE544_tree = (CommonTree)adaptor.dupNode(STORE544);


                    adaptor.addChild(root_0, STORE544_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STORE544!=null?STORE544.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:728:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE545=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid5724); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE545_tree = (CommonTree)adaptor.dupNode(MAPREDUCE545);


                    adaptor.addChild(root_0, MAPREDUCE545_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MAPREDUCE545!=null?MAPREDUCE545.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:729:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP546=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid5734); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP546_tree = (CommonTree)adaptor.dupNode(SHIP546);


                    adaptor.addChild(root_0, SHIP546_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((SHIP546!=null?SHIP546.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:730:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE547=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid5749); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE547_tree = (CommonTree)adaptor.dupNode(CACHE547);


                    adaptor.addChild(root_0, CACHE547_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CACHE547!=null?CACHE547.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:731:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT548=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid5763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT548_tree = (CommonTree)adaptor.dupNode(INPUT548);


                    adaptor.addChild(root_0, INPUT548_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INPUT548!=null?INPUT548.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:732:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT549=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid5777); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT549_tree = (CommonTree)adaptor.dupNode(OUTPUT549);


                    adaptor.addChild(root_0, OUTPUT549_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((OUTPUT549!=null?OUTPUT549.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:733:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR550=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid5790); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR550_tree = (CommonTree)adaptor.dupNode(STDERROR550);


                    adaptor.addChild(root_0, STDERROR550_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDERROR550!=null?STDERROR550.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:734:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN551=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid5801); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN551_tree = (CommonTree)adaptor.dupNode(STDIN551);


                    adaptor.addChild(root_0, STDIN551_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDIN551!=null?STDIN551.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:735:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT552=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid5815); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT552_tree = (CommonTree)adaptor.dupNode(STDOUT552);


                    adaptor.addChild(root_0, STDOUT552_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDOUT552!=null?STDOUT552.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:736:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT553=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid5828); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT553_tree = (CommonTree)adaptor.dupNode(LIMIT553);


                    adaptor.addChild(root_0, LIMIT553_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LIMIT553!=null?LIMIT553.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:737:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE554=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid5842); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE554_tree = (CommonTree)adaptor.dupNode(SAMPLE554);


                    adaptor.addChild(root_0, SAMPLE554_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((SAMPLE554!=null?SAMPLE554.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:738:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT555=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid5855); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT555_tree = (CommonTree)adaptor.dupNode(LEFT555);


                    adaptor.addChild(root_0, LEFT555_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LEFT555!=null?LEFT555.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:739:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT556=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid5870); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT556_tree = (CommonTree)adaptor.dupNode(RIGHT556);


                    adaptor.addChild(root_0, RIGHT556_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((RIGHT556!=null?RIGHT556.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:740:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL557=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid5884); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL557_tree = (CommonTree)adaptor.dupNode(FULL557);


                    adaptor.addChild(root_0, FULL557_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FULL557!=null?FULL557.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:741:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER558=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid5899); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER558_tree = (CommonTree)adaptor.dupNode(IDENTIFIER558);


                    adaptor.addChild(root_0, IDENTIFIER558_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER558!=null?IDENTIFIER558.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:742:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG559=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid5909); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG559_tree = (CommonTree)adaptor.dupNode(TOBAG559);


                    adaptor.addChild(root_0, TOBAG559_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TOBAG559!=null?TOBAG559.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:743:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP560=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid5924); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP560_tree = (CommonTree)adaptor.dupNode(TOMAP560);


                    adaptor.addChild(root_0, TOMAP560_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TOMAP560!=null?TOMAP560.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 75 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:744:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE561=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid5939); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE561_tree = (CommonTree)adaptor.dupNode(TOTUPLE561);


                    adaptor.addChild(root_0, TOTUPLE561_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TOTUPLE561!=null?TOTUPLE561.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 76 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:745:7: IN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IN562=(CommonTree)match(input,IN,FOLLOW_IN_in_eid5952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IN562_tree = (CommonTree)adaptor.dupNode(IN562);


                    adaptor.addChild(root_0, IN562_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IN562!=null?IN562.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 77 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:746:7: CASE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CASE563=(CommonTree)match(input,CASE,FOLLOW_CASE_in_eid5970); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CASE563_tree = (CommonTree)adaptor.dupNode(CASE563);


                    adaptor.addChild(root_0, CASE563_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CASE563!=null?CASE563.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 78 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:747:7: ASSERT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASSERT564=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_eid5986); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSERT564_tree = (CommonTree)adaptor.dupNode(ASSERT564);


                    adaptor.addChild(root_0, ASSERT564_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ASSERT564!=null?ASSERT564.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "eid"


    public static class rel_op_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:751:1: rel_op returns [String result] : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AstPrinter.rel_op_return rel_op() throws RecognitionException {
        AstPrinter.rel_op_return retval = new AstPrinter.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES571=null;
        AstPrinter.rel_op_eq_return rel_op_eq565 =null;

        AstPrinter.rel_op_ne_return rel_op_ne566 =null;

        AstPrinter.rel_op_gt_return rel_op_gt567 =null;

        AstPrinter.rel_op_gte_return rel_op_gte568 =null;

        AstPrinter.rel_op_lt_return rel_op_lt569 =null;

        AstPrinter.rel_op_lte_return rel_op_lte570 =null;


        CommonTree STR_OP_MATCHES571_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:752:5: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt135=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt135=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt135=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt135=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt135=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt135=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt135=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt135=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;

            }

            switch (alt135) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:752:7: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op6009);
                    rel_op_eq565=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq565.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_eq565!=null?rel_op_eq565.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:753:7: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op6023);
                    rel_op_ne566=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne566.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_ne566!=null?rel_op_ne566.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:754:7: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op6037);
                    rel_op_gt567=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt567.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_gt567!=null?rel_op_gt567.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:755:7: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op6051);
                    rel_op_gte568=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte568.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_gte568!=null?rel_op_gte568.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:756:7: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op6064);
                    rel_op_lt569=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt569.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_lt569!=null?rel_op_lt569.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:757:7: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op6078);
                    rel_op_lte570=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte570.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_lte570!=null?rel_op_lte570.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:758:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES571=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op6091); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES571_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES571);


                    adaptor.addChild(root_0, STR_OP_MATCHES571_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_MATCHES571!=null?STR_OP_MATCHES571.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op"


    public static class rel_op_eq_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_eq"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:761:1: rel_op_eq returns [String result] : ( STR_OP_EQ | NUM_OP_EQ );
    public final AstPrinter.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AstPrinter.rel_op_eq_return retval = new AstPrinter.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ572=null;
        CommonTree NUM_OP_EQ573=null;

        CommonTree STR_OP_EQ572_tree=null;
        CommonTree NUM_OP_EQ573_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:762:5: ( STR_OP_EQ | NUM_OP_EQ )
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==STR_OP_EQ) ) {
                alt136=1;
            }
            else if ( (LA136_0==NUM_OP_EQ) ) {
                alt136=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;

            }
            switch (alt136) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:762:7: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ572=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_op_eq6110); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ572_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ572);


                    adaptor.addChild(root_0, STR_OP_EQ572_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_EQ572!=null?STR_OP_EQ572.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:763:7: NUM_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_EQ573=(CommonTree)match(input,NUM_OP_EQ,FOLLOW_NUM_OP_EQ_in_rel_op_eq6120); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_EQ573_tree = (CommonTree)adaptor.dupNode(NUM_OP_EQ573);


                    adaptor.addChild(root_0, NUM_OP_EQ573_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_EQ573!=null?NUM_OP_EQ573.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:766:1: rel_op_ne returns [String result] : ( STR_OP_NE | NUM_OP_NE );
    public final AstPrinter.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AstPrinter.rel_op_ne_return retval = new AstPrinter.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_NE574=null;
        CommonTree NUM_OP_NE575=null;

        CommonTree STR_OP_NE574_tree=null;
        CommonTree NUM_OP_NE575_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:767:5: ( STR_OP_NE | NUM_OP_NE )
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==STR_OP_NE) ) {
                alt137=1;
            }
            else if ( (LA137_0==NUM_OP_NE) ) {
                alt137=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;

            }
            switch (alt137) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:767:7: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE574=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_op_ne6138); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE574_tree = (CommonTree)adaptor.dupNode(STR_OP_NE574);


                    adaptor.addChild(root_0, STR_OP_NE574_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_NE574!=null?STR_OP_NE574.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:768:7: NUM_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_NE575=(CommonTree)match(input,NUM_OP_NE,FOLLOW_NUM_OP_NE_in_rel_op_ne6148); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_NE575_tree = (CommonTree)adaptor.dupNode(NUM_OP_NE575);


                    adaptor.addChild(root_0, NUM_OP_NE575_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_NE575!=null?NUM_OP_NE575.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_ne"


    public static class rel_op_gt_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gt"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:771:1: rel_op_gt returns [String result] : ( STR_OP_GT | NUM_OP_GT );
    public final AstPrinter.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AstPrinter.rel_op_gt_return retval = new AstPrinter.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_GT576=null;
        CommonTree NUM_OP_GT577=null;

        CommonTree STR_OP_GT576_tree=null;
        CommonTree NUM_OP_GT577_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:772:5: ( STR_OP_GT | NUM_OP_GT )
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==STR_OP_GT) ) {
                alt138=1;
            }
            else if ( (LA138_0==NUM_OP_GT) ) {
                alt138=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;

            }
            switch (alt138) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:772:7: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT576=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_op_gt6166); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT576_tree = (CommonTree)adaptor.dupNode(STR_OP_GT576);


                    adaptor.addChild(root_0, STR_OP_GT576_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_GT576!=null?STR_OP_GT576.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:773:7: NUM_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_GT577=(CommonTree)match(input,NUM_OP_GT,FOLLOW_NUM_OP_GT_in_rel_op_gt6176); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_GT577_tree = (CommonTree)adaptor.dupNode(NUM_OP_GT577);


                    adaptor.addChild(root_0, NUM_OP_GT577_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_GT577!=null?NUM_OP_GT577.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gt"


    public static class rel_op_gte_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gte"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:776:1: rel_op_gte returns [String result] : ( STR_OP_GTE | NUM_OP_GTE );
    public final AstPrinter.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AstPrinter.rel_op_gte_return retval = new AstPrinter.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_GTE578=null;
        CommonTree NUM_OP_GTE579=null;

        CommonTree STR_OP_GTE578_tree=null;
        CommonTree NUM_OP_GTE579_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:777:5: ( STR_OP_GTE | NUM_OP_GTE )
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==STR_OP_GTE) ) {
                alt139=1;
            }
            else if ( (LA139_0==NUM_OP_GTE) ) {
                alt139=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;

            }
            switch (alt139) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:777:7: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE578=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_op_gte6194); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE578_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE578);


                    adaptor.addChild(root_0, STR_OP_GTE578_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_GTE578!=null?STR_OP_GTE578.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:778:7: NUM_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_GTE579=(CommonTree)match(input,NUM_OP_GTE,FOLLOW_NUM_OP_GTE_in_rel_op_gte6204); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_GTE579_tree = (CommonTree)adaptor.dupNode(NUM_OP_GTE579);


                    adaptor.addChild(root_0, NUM_OP_GTE579_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_GTE579!=null?NUM_OP_GTE579.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gte"


    public static class rel_op_lt_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lt"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:781:1: rel_op_lt returns [String result] : ( STR_OP_LT | NUM_OP_LT );
    public final AstPrinter.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AstPrinter.rel_op_lt_return retval = new AstPrinter.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_LT580=null;
        CommonTree NUM_OP_LT581=null;

        CommonTree STR_OP_LT580_tree=null;
        CommonTree NUM_OP_LT581_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:782:5: ( STR_OP_LT | NUM_OP_LT )
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==STR_OP_LT) ) {
                alt140=1;
            }
            else if ( (LA140_0==NUM_OP_LT) ) {
                alt140=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;

            }
            switch (alt140) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:782:7: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT580=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_op_lt6222); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT580_tree = (CommonTree)adaptor.dupNode(STR_OP_LT580);


                    adaptor.addChild(root_0, STR_OP_LT580_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_LT580!=null?STR_OP_LT580.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:783:7: NUM_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_LT581=(CommonTree)match(input,NUM_OP_LT,FOLLOW_NUM_OP_LT_in_rel_op_lt6232); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_LT581_tree = (CommonTree)adaptor.dupNode(NUM_OP_LT581);


                    adaptor.addChild(root_0, NUM_OP_LT581_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_LT581!=null?NUM_OP_LT581.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lt"


    public static class rel_op_lte_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lte"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:786:1: rel_op_lte returns [String result] : ( STR_OP_LTE | NUM_OP_LTE );
    public final AstPrinter.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AstPrinter.rel_op_lte_return retval = new AstPrinter.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_LTE582=null;
        CommonTree NUM_OP_LTE583=null;

        CommonTree STR_OP_LTE582_tree=null;
        CommonTree NUM_OP_LTE583_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:787:5: ( STR_OP_LTE | NUM_OP_LTE )
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==STR_OP_LTE) ) {
                alt141=1;
            }
            else if ( (LA141_0==NUM_OP_LTE) ) {
                alt141=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;

            }
            switch (alt141) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:787:7: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE582=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_op_lte6250); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE582_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE582);


                    adaptor.addChild(root_0, STR_OP_LTE582_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_LTE582!=null?STR_OP_LTE582.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:788:7: NUM_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_LTE583=(CommonTree)match(input,NUM_OP_LTE,FOLLOW_NUM_OP_LTE_in_rel_op_lte6260); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_LTE583_tree = (CommonTree)adaptor.dupNode(NUM_OP_LTE583);


                    adaptor.addChild(root_0, NUM_OP_LTE583_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_LTE583!=null?NUM_OP_LTE583.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lte"


    public static class rel_str_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:791:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AstPrinter.rel_str_op_return rel_str_op() throws RecognitionException {
        AstPrinter.rel_str_op_return retval = new AstPrinter.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ584=null;
        CommonTree STR_OP_NE585=null;
        CommonTree STR_OP_GT586=null;
        CommonTree STR_OP_LT587=null;
        CommonTree STR_OP_GTE588=null;
        CommonTree STR_OP_LTE589=null;
        CommonTree STR_OP_MATCHES590=null;

        CommonTree STR_OP_EQ584_tree=null;
        CommonTree STR_OP_NE585_tree=null;
        CommonTree STR_OP_GT586_tree=null;
        CommonTree STR_OP_LT587_tree=null;
        CommonTree STR_OP_GTE588_tree=null;
        CommonTree STR_OP_LTE589_tree=null;
        CommonTree STR_OP_MATCHES590_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:792:5: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            int alt142=7;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
                {
                alt142=1;
                }
                break;
            case STR_OP_NE:
                {
                alt142=2;
                }
                break;
            case STR_OP_GT:
                {
                alt142=3;
                }
                break;
            case STR_OP_LT:
                {
                alt142=4;
                }
                break;
            case STR_OP_GTE:
                {
                alt142=5;
                }
                break;
            case STR_OP_LTE:
                {
                alt142=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt142=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 142, 0, input);

                throw nvae;

            }

            switch (alt142) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:792:7: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ584=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_str_op6275); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ584_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ584);


                    adaptor.addChild(root_0, STR_OP_EQ584_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_EQ584!=null?STR_OP_EQ584.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:793:7: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE585=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_str_op6285); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE585_tree = (CommonTree)adaptor.dupNode(STR_OP_NE585);


                    adaptor.addChild(root_0, STR_OP_NE585_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_NE585!=null?STR_OP_NE585.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:794:7: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT586=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_str_op6295); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT586_tree = (CommonTree)adaptor.dupNode(STR_OP_GT586);


                    adaptor.addChild(root_0, STR_OP_GT586_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_GT586!=null?STR_OP_GT586.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:795:7: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT587=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_str_op6305); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT587_tree = (CommonTree)adaptor.dupNode(STR_OP_LT587);


                    adaptor.addChild(root_0, STR_OP_LT587_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_LT587!=null?STR_OP_LT587.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:796:7: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE588=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_str_op6315); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE588_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE588);


                    adaptor.addChild(root_0, STR_OP_GTE588_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_GTE588!=null?STR_OP_GTE588.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:797:7: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE589=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_str_op6325); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE589_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE589);


                    adaptor.addChild(root_0, STR_OP_LTE589_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_LTE589!=null?STR_OP_LTE589.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:798:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES590=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_str_op6335); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES590_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES590);


                    adaptor.addChild(root_0, STR_OP_MATCHES590_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_MATCHES590!=null?STR_OP_MATCHES590.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred50_AstPrinter
    public final void synpred50_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:201:7: ( field_def ( field_def )+ )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:201:7: field_def ( field_def )+
        {
        pushFollow(FOLLOW_field_def_in_synpred50_AstPrinter1140);
        field_def();

        state._fsp--;
        if (state.failed) return ;

        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:201:37: ( field_def )+
        int cnt147=0;
        loop147:
        do {
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==FIELD_DEF) ) {
                alt147=1;
            }


            switch (alt147) {
        	case 1 :
        	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:201:39: field_def
        	    {
        	    pushFollow(FOLLOW_field_def_in_synpred50_AstPrinter1146);
        	    field_def();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt147 >= 1 ) break loop147;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(147, input);
                    throw eee;
            }
            cnt147++;
        } while (true);


        }

    }
    // $ANTLR end synpred50_AstPrinter

    // $ANTLR start synpred109_AstPrinter
    public final void synpred109_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:354:7: ( ^( MINUS expr expr ) )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:354:7: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred109_AstPrinter2401); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred109_AstPrinter2403);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred109_AstPrinter2407);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred109_AstPrinter

    // $ANTLR start synpred113_AstPrinter
    public final void synpred113_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:358:7: ( ^( CAST_EXPR type expr ) )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:358:7: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred113_AstPrinter2473); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred113_AstPrinter2477);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred113_AstPrinter2481);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred113_AstPrinter

    // $ANTLR start synpred114_AstPrinter
    public final void synpred114_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:359:7: ( const_expr )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:359:7: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred114_AstPrinter2491);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred114_AstPrinter

    // $ANTLR start synpred117_AstPrinter
    public final void synpred117_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:362:7: ( ^( CAST_EXPR type_cast expr ) )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:362:7: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred117_AstPrinter2525); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred117_AstPrinter2529);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred117_AstPrinter2533);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred117_AstPrinter

    // $ANTLR start synpred122_AstPrinter
    public final void synpred122_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:371:7: ( ^( TUPLE_TYPE_CAST type_cast ( type_cast )* ) )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:371:7: ^( TUPLE_TYPE_CAST type_cast ( type_cast )* )
        {
        match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_synpred122_AstPrinter2593); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred122_AstPrinter2597);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:371:61: ( type_cast )*
        loop151:
        do {
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==BIGDECIMAL||LA151_0==BIGINTEGER||LA151_0==BOOLEAN||LA151_0==BYTEARRAY||LA151_0==CHARARRAY||LA151_0==DATETIME||LA151_0==DOUBLE||LA151_0==FLOAT||LA151_0==INT||LA151_0==LONG||LA151_0==BAG_TYPE_CAST||LA151_0==MAP_TYPE||LA151_0==TUPLE_TYPE_CAST) ) {
                alt151=1;
            }


            switch (alt151) {
        	case 1 :
        	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:371:63: type_cast
        	    {
        	    pushFollow(FOLLOW_type_cast_in_synpred122_AstPrinter2603);
        	    type_cast();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop151;
            }
        } while (true);


        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred122_AstPrinter

    // $ANTLR start synpred143_AstPrinter
    public final void synpred143_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:430:11: ( INTEGER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:430:11: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred143_AstPrinter3094); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred143_AstPrinter

    // $ANTLR start synpred144_AstPrinter
    public final void synpred144_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:430:63: ( LONGINTEGER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:430:63: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred144_AstPrinter3100); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred144_AstPrinter

    // $ANTLR start synpred145_AstPrinter
    public final void synpred145_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:434:64: ( DOUBLENUMBER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:434:64: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred145_AstPrinter3133); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred145_AstPrinter

    // $ANTLR start synpred171_AstPrinter
    public final void synpred171_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:494:7: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:494:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred171_AstPrinter3560);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
            input.consume();
            state.errorRecovery=false;
            state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:497:16: ( OUTER )?
        int alt155=2;
        int LA155_0 = input.LA(1);

        if ( (LA155_0==OUTER) ) {
            alt155=1;
        }
        switch (alt155) {
            case 1 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:497:17: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred171_AstPrinter3622); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred171_AstPrinter3631);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred171_AstPrinter

    // $ANTLR start synpred189_AstPrinter
    public final void synpred189_AstPrinter_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:568:75: ( INTEGER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstPrinter.g:568:75: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred189_AstPrinter4154); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred189_AstPrinter

    // Delegated rules

    public final boolean synpred189_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred189_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred144_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred144_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred145_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred145_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred171_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred171_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred143_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred143_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred122_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred122_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA58 dfa58 = new DFA58(this);
    static final String DFA58_eotS =
        "\u00af\uffff";
    static final String DFA58_eofS =
        "\u00af\uffff";
    static final String DFA58_minS =
        "\1\u00a0\1\2\1\4\124\3\2\4\2\uffff\124\3";
    static final String DFA58_maxS =
        "\1\u00a0\1\2\1\u00bd\124\u00bb\2\u00bd\2\uffff\124\u00bb";
    static final String DFA58_acceptS =
        "\131\uffff\1\1\1\2\124\uffff";
    static final String DFA58_specialS =
        "\u00af\uffff}>";
    static final String[] DFA58_transitionS = {
            "\1\1",
            "\1\2",
            "\1\36\1\uffff\1\47\1\uffff\1\37\1\55\1\126\1\71\1\65\1\uffff"+
            "\1\64\1\uffff\1\57\1\40\1\70\1\105\1\125\1\67\1\27\2\uffff\1"+
            "\31\1\20\1\66\1\uffff\1\14\1\uffff\1\56\1\uffff\1\26\3\uffff"+
            "\1\63\6\uffff\1\77\1\uffff\1\16\1\53\1\62\2\uffff\1\17\1\117"+
            "\1\52\1\46\1\uffff\1\120\1\35\1\12\1\124\1\42\1\106\1\60\1\uffff"+
            "\1\34\1\uffff\1\74\1\30\1\115\4\uffff\1\113\1\15\1\61\1\uffff"+
            "\1\73\1\103\3\uffff\1\51\1\75\7\uffff\1\50\1\24\1\uffff\1\43"+
            "\1\107\1\44\1\45\2\uffff\1\22\4\uffff\1\25\1\uffff\1\13\1\116"+
            "\3\uffff\1\21\1\114\1\uffff\1\104\2\uffff\1\33\1\uffff\1\110"+
            "\1\111\1\112\1\102\1\100\1\3\1\5\1\7\1\6\1\10\1\11\1\4\1\uffff"+
            "\1\101\1\76\1\72\1\32\1\41\54\uffff\1\121\1\122\1\123\3\uffff"+
            "\1\54\1\23",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\166\1\uffff\1\177\1\uffff\1\167\1\u0085\1\u00ae\1\u0091"+
            "\1\u008d\1\uffff\1\u008c\1\uffff\1\u0087\1\170\1\u0090\1\u009d"+
            "\1\u00ad\1\u008f\1\157\2\uffff\1\161\1\150\1\u008e\1\uffff\1"+
            "\144\1\uffff\1\u0086\1\uffff\1\156\3\uffff\1\u008b\6\uffff\1"+
            "\u0097\1\uffff\1\146\1\u0083\1\u008a\2\uffff\1\147\1\u00a7\1"+
            "\u0082\1\176\1\uffff\1\u00a8\1\165\1\142\1\u00ac\1\172\1\u009e"+
            "\1\u0088\1\uffff\1\164\1\uffff\1\u0094\1\160\1\u00a5\4\uffff"+
            "\1\u00a3\1\145\1\u0089\1\uffff\1\u0093\1\u009b\3\uffff\1\u0081"+
            "\1\u0095\7\uffff\1\u0080\1\154\1\uffff\1\173\1\u009f\1\174\1"+
            "\175\2\uffff\1\152\4\uffff\1\155\1\uffff\1\143\1\u00a6\3\uffff"+
            "\1\151\1\u00a4\1\uffff\1\u009c\2\uffff\1\163\1\uffff\1\u00a0"+
            "\1\u00a1\1\u00a2\1\u009a\1\u0098\1\133\1\135\1\137\1\136\1\140"+
            "\1\141\1\134\1\uffff\1\u0099\1\u0096\1\u0092\1\162\1\171\54"+
            "\uffff\1\u00a9\1\u00aa\1\u00ab\3\uffff\1\u0084\1\153",
            "\1\166\1\uffff\1\177\1\uffff\1\167\1\u0085\1\u00ae\1\u0091"+
            "\1\u008d\1\uffff\1\u008c\1\uffff\1\u0087\1\170\1\u0090\1\u009d"+
            "\1\u00ad\1\u008f\1\157\2\uffff\1\161\1\150\1\u008e\1\uffff\1"+
            "\144\1\uffff\1\u0086\1\uffff\1\156\3\uffff\1\u008b\6\uffff\1"+
            "\u0097\1\uffff\1\146\1\u0083\1\u008a\2\uffff\1\147\1\u00a7\1"+
            "\u0082\1\176\1\uffff\1\u00a8\1\165\1\142\1\u00ac\1\172\1\u009e"+
            "\1\u0088\1\uffff\1\164\1\uffff\1\u0094\1\160\1\u00a5\4\uffff"+
            "\1\u00a3\1\145\1\u0089\1\uffff\1\u0093\1\u009b\3\uffff\1\u0081"+
            "\1\u0095\7\uffff\1\u0080\1\154\1\uffff\1\173\1\u009f\1\174\1"+
            "\175\2\uffff\1\152\4\uffff\1\155\1\uffff\1\143\1\u00a6\3\uffff"+
            "\1\151\1\u00a4\1\uffff\1\u009c\2\uffff\1\163\1\uffff\1\u00a0"+
            "\1\u00a1\1\u00a2\1\u009a\1\u0098\1\133\1\135\1\137\1\136\1\140"+
            "\1\141\1\134\1\uffff\1\u0099\1\u0096\1\u0092\1\162\1\171\54"+
            "\uffff\1\u00a9\1\u00aa\1\u00ab\3\uffff\1\u0084\1\153",
            "",
            "",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131",
            "\1\132\11\uffff\1\131\1\uffff\1\131\12\uffff\1\131\7\uffff"+
            "\1\131\1\130\1\131\1\uffff\1\131\5\uffff\1\131\5\uffff\1\131"+
            "\3\uffff\1\131\1\uffff\1\131\6\uffff\1\131\14\uffff\1\131\2"+
            "\uffff\1\131\3\uffff\1\131\16\uffff\1\131\1\127\1\uffff\1\131"+
            "\2\uffff\1\131\16\uffff\1\131\16\uffff\1\131\11\uffff\2\131"+
            "\2\uffff\2\131\2\uffff\3\131\5\uffff\1\131\12\uffff\2\131\16"+
            "\uffff\1\131"
    };

    static final short[] DFA58_eot = DFA.unpackEncodedString(DFA58_eotS);
    static final short[] DFA58_eof = DFA.unpackEncodedString(DFA58_eofS);
    static final char[] DFA58_min = DFA.unpackEncodedStringToUnsignedChars(DFA58_minS);
    static final char[] DFA58_max = DFA.unpackEncodedStringToUnsignedChars(DFA58_maxS);
    static final short[] DFA58_accept = DFA.unpackEncodedString(DFA58_acceptS);
    static final short[] DFA58_special = DFA.unpackEncodedString(DFA58_specialS);
    static final short[][] DFA58_transition;

    static {
        int numStates = DFA58_transitionS.length;
        DFA58_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA58_transition[i] = DFA.unpackEncodedString(DFA58_transitionS[i]);
        }
    }

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = DFA58_eot;
            this.eof = DFA58_eof;
            this.min = DFA58_min;
            this.max = DFA58_max;
            this.accept = DFA58_accept;
            this.special = DFA58_special;
            this.transition = DFA58_transition;
        }
        public String getDescription() {
            return "343:1: func_eval : ( ^( FUNC_EVAL func_name real_arg ( real_arg )* ) | ^( FUNC_EVAL func_name ) );";
        }
    }
 

    public static final BitSet FOLLOW_QUERY_in_query80 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query82 = new BitSet(new long[]{0x0400000000000408L,0x0040040000000000L,0x0024000000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_import_statement_in_statement124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_register_statement_in_statement140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_import_statement201 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_import_statement203 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REGISTER_in_register_statement218 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_register_statement220 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_scripting_udf_clause_in_register_statement224 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_assert_clause_in_assert_statement236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scripting_language_clause_in_scripting_udf_clause245 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_scripting_namespace_clause_in_scripting_udf_clause247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_scripting_language_clause257 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_scripting_language_clause259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_scripting_namespace_clause272 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_scripting_namespace_clause274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement293 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement297 = new BitSet(new long[]{0x0048400226400400L,0x1842020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_op_clause_in_general_statement312 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement314 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause329 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause331 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause333 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause349 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause351 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIVOT_in_pivot_clause370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_pivot_clause372 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_op_clause652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause667 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_define_clause669 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause683 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause687 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd706 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd720 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd724 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd728 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd732 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd736 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause756 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause760 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list780 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list795 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause815 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause819 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause838 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause850 = new BitSet(new long[]{0x0000000000000008L,0x0600010000000000L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause856 = new BitSet(new long[]{0x0000000000000008L,0x0600010000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd877 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd881 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd894 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd898 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd911 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd915 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause933 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause946 = new BitSet(new long[]{0x0000000000000008L,0x0600010000000000L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause952 = new BitSet(new long[]{0x0000000000000008L,0x0600010000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause973 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause987 = new BitSet(new long[]{0x8000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause992 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause1019 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause1023 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause1037 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause1041 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause1074 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause1078 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def1095 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def1097 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0200040000004000L});
    public static final BitSet FOLLOW_type_in_field_def1107 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def1121 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def1123 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list1140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_field_def_in_field_def_list1146 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_field_def_in_field_def_list1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_type_in_type1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_simple_type1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_simple_type1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_simple_type1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1300 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1302 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1320 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1328 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1331 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1349 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1353 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1373 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1375 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1389 = new BitSet(new long[]{0x0000000000000008L,0x0000010000020000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1393 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1411 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_PERIOD_in_func_name1417 = new BitSet(new long[]{0x7F79D022AE7F5F50L,0xFF4B1A13D80C6E1DL,0x31C00000000003EFL});
    public static final BitSet FOLLOW_DOLLAR_in_func_name1423 = new BitSet(new long[]{0x7F79D022AE7F5F50L,0xFF4B1A13D80C6E1DL,0x31C00000000003EFL});
    public static final BitSet FOLLOW_eid_in_func_name1429 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_func_first_arg_clause_in_func_args1441 = new BitSet(new long[]{0x0000000000000002L,0x0000010000020000L});
    public static final BitSet FOLLOW_func_next_arg_clause_in_func_args1444 = new BitSet(new long[]{0x0000000000000002L,0x0000010000020000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_first_arg_clause1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULTILINE_QUOTEDSTRING_in_func_first_arg_clause1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_next_arg_clause1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULTILINE_QUOTEDSTRING_in_func_next_arg_clause1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1548 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1552 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1567 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1588 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1592 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1607 = new BitSet(new long[]{0x0000000004000002L,0x0001000000000000L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1613 = new BitSet(new long[]{0x0000000004000002L,0x0001000000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1631 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1635 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1649 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1668 = new BitSet(new long[]{0x814410540400A002L,0x0080012400089000L,0x0800180107330040L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1674 = new BitSet(new long[]{0x814410540400A002L,0x0080012400089000L,0x0800180107330040L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_group_clause1721 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COGROUP_in_group_clause1727 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1741 = new BitSet(new long[]{0x0148400226400408L,0x1842030210004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_group_item_in_group_clause1747 = new BitSet(new long[]{0x0148400226400408L,0x1842030210004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_group_type_in_group_clause1762 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1773 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1804 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1808 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1824 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1830 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_INNER_in_group_item1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_group_item1856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_rel1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1886 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1908 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1912 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1916 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1920 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1947 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1951 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1970 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause1974 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause1978 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1984 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_comment2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_assert_clause2018 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_assert_clause2022 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_assert_clause2026 = new BitSet(new long[]{0x0000000000000008L,0x0000010000000000L});
    public static final BitSet FOLLOW_comment_in_assert_clause2034 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause2054 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause2058 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_filter_clause2062 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond2081 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2085 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_cond2089 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond2103 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2107 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_cond2111 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond2125 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2129 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond2143 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2145 = new BitSet(new long[]{0x0000000000000008L,0x0000000000040000L});
    public static final BitSet FOLLOW_NOT_in_cond2150 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond2170 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2172 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_cond2176 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond2186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond2204 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2206 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval2223 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval2240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2242 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval2248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2252 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval2271 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2275 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval2281 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2286 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval2310 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval2312 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180107330040L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2316 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180107330040L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2322 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180107330040L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval2338 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval2340 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_real_arg2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg2362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg2368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr2383 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2385 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr2389 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr2401 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2403 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr2407 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr2419 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2421 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr2425 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr2437 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2439 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr2443 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr2455 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2457 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr2461 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2473 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr2477 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr2481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr2499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr2509 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2513 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2525 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr2529 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr2533 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr2545 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2549 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast2570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2593 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2597 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0400040000008000L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2603 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0400040000008000L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2619 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2623 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2643 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast2647 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr2665 = new BitSet(new long[]{0x0000000000000002L,0x0000004800000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr2669 = new BitSet(new long[]{0x0000000000000002L,0x0000004800000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr2673 = new BitSet(new long[]{0x0000000000000002L,0x0000004800000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr2693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr2697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr2701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr2705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj2720 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2724 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2730 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index2746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_col_alias2763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_col_alias2773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_col_alias2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index2798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range2811 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range2813 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range2818 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range2820 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj2837 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_pound_proj2851 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_pound_proj2857 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr2878 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2882 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_bin_expr2886 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_bin_expr2890 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr2909 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr2926 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2928 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr2936 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2940 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr2962 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2966 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr2974 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2978 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond3005 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond3019 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond3021 = new BitSet(new long[]{0x0800000000000048L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_case_cond3027 = new BitSet(new long[]{0x0800000000000048L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_THEN_in_case_cond3046 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond3048 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_case_cond3054 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause3078 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause3082 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause3094 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause3100 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause3106 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause3125 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause3129 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause3133 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause3139 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause3158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause3162 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause3166 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement3183 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement3187 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement3191 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause3208 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_rank_by_clause3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_by_clause3220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause3233 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause3239 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_col_range_in_rank_col3254 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_col_ref_in_rank_col3258 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_rank_col3264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col3270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_order_clause3290 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause3294 = new BitSet(new long[]{0x0140001004000000L,0x0080000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause3306 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause3320 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause3338 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_order_by_clause3344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_by_clause3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause3363 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause3369 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_col_range_in_order_col3385 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_col_ref_in_order_col3389 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_order_col3394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col3400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause3420 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause3424 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause3426 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause3444 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause3448 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause3465 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause3469 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause3471 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list3487 = new BitSet(new long[]{0x0148400226400402L,0x1842020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_rel_in_rel_list3493 = new BitSet(new long[]{0x0148400226400402L,0x1842020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_JOIN_in_join_clause3510 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause3514 = new BitSet(new long[]{0x0000000000000008L,0x0000010200000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause3520 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause3531 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type3545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3560 = new BitSet(new long[]{0x0010000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_LEFT_in_join_sub_clause3564 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_RIGHT_in_join_sub_clause3583 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_FULL_in_join_sub_clause3602 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause3622 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3639 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3645 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item3663 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item3665 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item3667 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause3684 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause3692 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180107330040L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause3698 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180107330040L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr3718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr3726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause3743 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause3748 = new BitSet(new long[]{0x0148400226400400L,0x1842020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_rel_list_in_union_clause3755 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause3772 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause3776 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause3778 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan3795 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan3797 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan3809 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan3811 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk3829 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000000L,0x0000600000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk3836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause3853 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause3865 = new BitSet(new long[]{0x814490540400A008L,0x0080012400089000L,0x0800180107330040L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause3871 = new BitSet(new long[]{0x814490540400A008L,0x0080012400089000L,0x0800180107330040L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command3890 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command3892 = new BitSet(new long[]{0x0008400202000000L,0x0000000010000200L,0x0000800000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command3896 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command3908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command3910 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_nested_command3914 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op3925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op3939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op3953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op3967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op3981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op3995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op4009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj4024 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4026 = new BitSet(new long[]{0x0140001004000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4030 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4036 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter4057 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter4061 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_nested_filter4065 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort4082 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort4086 = new BitSet(new long[]{0x0140001004000000L,0x0080000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort4098 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort4104 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct4123 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct4128 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit4145 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit4150 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit4154 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit4160 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross4179 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross4184 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach4198 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach4203 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach4205 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input4216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input4220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list4233 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list4239 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause4256 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause4260 = new BitSet(new long[]{0x0100080000000000L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_stream_clause4274 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stream_clause4288 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause4294 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause4312 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause4314 = new BitSet(new long[]{0x0000000000000000L,0x0800010000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause4329 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause4336 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause4340 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause4351 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause4373 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause4386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause4390 = new BitSet(new long[]{0x0000000000000008L,0x0000000020000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause4396 = new BitSet(new long[]{0x0000000000000008L,0x0000000020000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause4405 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch4425 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch4427 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_split_branch4431 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise4448 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise4450 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref4463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref4467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref4480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref4490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref4500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref4515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr4526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal4535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal4539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal4543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal4547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar4556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar4567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar4580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar4593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar4606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar4619 = new BitSet(new long[]{0x800400400000A000L,0x0000000000001000L});
    public static final BitSet FOLLOW_INTEGER_in_num_scalar4641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_num_scalar4660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATNUMBER_in_num_scalar4679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_num_scalar4698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGERNUMBER_in_num_scalar4717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMALNUMBER_in_num_scalar4736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map4768 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map4772 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_keyvalue_in_map4778 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_MAP_VAL_in_map4794 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue4813 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue4815 = new BitSet(new long[]{0x800410400000A000L,0x0000010000089000L,0x0800080000010040L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue4819 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key4830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag4847 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag4851 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_tuple_in_bag4857 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag4873 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple4892 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple4896 = new BitSet(new long[]{0x800410400000A008L,0x0000010000089000L,0x0800080000010040L});
    public static final BitSet FOLLOW_literal_in_tuple4903 = new BitSet(new long[]{0x800410400000A008L,0x0000010000089000L,0x0800080000010040L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple4919 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_str_op_in_eid4933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid4941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid4954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid4966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid4979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid4994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid5007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid5019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid5034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIVOT_in_eid5047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid5061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid5073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANK_in_eid5087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid5102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid5113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid5125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid5140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid5154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid5168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid5182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid5197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid5214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid5230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid5247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid5264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid5278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid5292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid5306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid5317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid5327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid5341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid5357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid5374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid5390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid5401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid5413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid5428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid5444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid5459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid5471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid5487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid5502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid5516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid5529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid5538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid5547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid5558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid5568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid5578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid5594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid5608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid5624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid5641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid5656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid5671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid5685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid5698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid5710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid5724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid5734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid5749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid5763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid5777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid5790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid5801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid5815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid5828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid5842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid5855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid5870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid5884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid5899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid5909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid5924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid5939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_in_eid5952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_eid5970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_eid5986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op6009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op6023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op6037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op6051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op6064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op6078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op6091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_op_eq6110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_EQ_in_rel_op_eq6120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_op_ne6138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_NE_in_rel_op_ne6148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_op_gt6166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_GT_in_rel_op_gt6176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_op_gte6194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_GTE_in_rel_op_gte6204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_op_lt6222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_LT_in_rel_op_lt6232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_op_lte6250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_LTE_in_rel_op_lte6260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_str_op6275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_str_op6285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_str_op6295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_str_op6305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_str_op6315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_str_op6325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_str_op6335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_def_in_synpred50_AstPrinter1140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_field_def_in_synpred50_AstPrinter1146 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_MINUS_in_synpred109_AstPrinter2401 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred109_AstPrinter2403 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_synpred109_AstPrinter2407 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred113_AstPrinter2473 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred113_AstPrinter2477 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_synpred113_AstPrinter2481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred114_AstPrinter2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred117_AstPrinter2525 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred117_AstPrinter2529 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_synpred117_AstPrinter2533 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_synpred122_AstPrinter2593 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred122_AstPrinter2597 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0400040000008000L});
    public static final BitSet FOLLOW_type_cast_in_synpred122_AstPrinter2603 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0400040000008000L});
    public static final BitSet FOLLOW_INTEGER_in_synpred143_AstPrinter3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred144_AstPrinter3100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred145_AstPrinter3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred171_AstPrinter3560 = new BitSet(new long[]{0x0010000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_set_in_synpred171_AstPrinter3562 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred171_AstPrinter3622 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_join_item_in_synpred171_AstPrinter3631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred189_AstPrinter4154 = new BitSet(new long[]{0x0000000000000002L});

}