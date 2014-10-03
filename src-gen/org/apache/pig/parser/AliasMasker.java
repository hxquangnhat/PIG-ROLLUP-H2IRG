// $ANTLR 3.4 /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g 2014-09-17 14:41:16

package org.apache.pig.parser;

import java.util.HashSet;
import java.util.Set;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (visitor for default data type insertion).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AliasMasker extends TreeParser {
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


    public AliasMasker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AliasMasker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AliasMasker.tokenNames; }
    public String getGrammarFileName() { return "/home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g"; }



    @Override
    public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    	if (e instanceof ParserValidationException) {
    		return e.toString();
    	}
    	return super.getErrorMessage(e, tokenNames);
    }

    public void setParams(Set ps, String macro, long idx) {
        params = ps;
        macroName = macro;
        index = idx;
    }

    private String getMask(String alias) {
        return params.contains( alias )
            ? alias
            : "macro_" + macroName + "_" + alias + "_" + index;
    }

    private Set<String> params = new HashSet<String>();

    private Set<String> aliasSeen = new HashSet<String>();

    private String macroName = "";

    private long index = 0;

    private boolean inAsOrGenClause = false;



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:82:1: query : ^( QUERY ( statement )* ) ;
    public final AliasMasker.query_return query() throws RecognitionException {
        AliasMasker.query_return retval = new AliasMasker.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AliasMasker.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:82:7: ( ^( QUERY ( statement )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:82:9: ^( QUERY ( statement )* )
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
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:82:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ASSERT||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:82:18: statement
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:85:1: statement : ( general_statement | split_statement | realias_statement | assert_statement );
    public final AliasMasker.statement_return statement() throws RecognitionException {
        AliasMasker.statement_return retval = new AliasMasker.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.general_statement_return general_statement3 =null;

        AliasMasker.split_statement_return split_statement4 =null;

        AliasMasker.realias_statement_return realias_statement5 =null;

        AliasMasker.assert_statement_return assert_statement6 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:85:11: ( general_statement | split_statement | realias_statement | assert_statement )
            int alt2=4;
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
            case REALIAS:
                {
                alt2=3;
                }
                break;
            case ASSERT:
                {
                alt2=4;
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:85:13: general_statement
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:86:13: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement108);
                    split_statement4=split_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_statement4.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:87:13: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement122);
                    realias_statement5=realias_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, realias_statement5.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:88:13: assert_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_statement_in_statement136);
                    assert_statement6=assert_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_statement6.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:91:1: split_statement : split_clause ;
    public final AliasMasker.split_statement_return split_statement() throws RecognitionException {
        AliasMasker.split_statement_return retval = new AliasMasker.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.split_clause_return split_clause7 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:91:17: ( split_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:91:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement145);
            split_clause7=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause7.getTree());


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


    public static class assert_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:94:1: assert_statement : assert_clause ;
    public final AliasMasker.assert_statement_return assert_statement() throws RecognitionException {
        AliasMasker.assert_statement_return retval = new AliasMasker.assert_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.assert_clause_return assert_clause8 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:94:17: ( assert_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:94:19: assert_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assert_clause_in_assert_statement153);
            assert_clause8=assert_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, assert_clause8.getTree());


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


    public static class realias_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:97:1: realias_statement : realias_clause ;
    public final AliasMasker.realias_statement_return realias_statement() throws RecognitionException {
        AliasMasker.realias_statement_return retval = new AliasMasker.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.realias_clause_return realias_clause9 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:97:19: ( realias_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:97:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement162);
            realias_clause9=realias_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, realias_clause9.getTree());


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


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:101:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AliasMasker.general_statement_return general_statement() throws RecognitionException {
        AliasMasker.general_statement_return retval = new AliasMasker.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT10=null;
        AliasMasker.alias_return alias11 =null;

        AliasMasker.op_clause_return op_clause12 =null;

        AliasMasker.parallel_clause_return parallel_clause13 =null;


        CommonTree STATEMENT10_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:102:5: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:102:7: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT10=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement178); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT10_tree = (CommonTree)adaptor.dupNode(STATEMENT10);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT10_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:102:20: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:102:22: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement182);
                    alias11=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias11.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement195);
            op_clause12=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause12.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:103:19: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:103:19: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement197);
                    parallel_clause13=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause13.getTree());


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
    // $ANTLR end "general_statement"


    public static class realias_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:106:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AliasMasker.realias_clause_return realias_clause() throws RecognitionException {
        AliasMasker.realias_clause_return retval = new AliasMasker.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS14=null;
        CommonTree IDENTIFIER16=null;
        AliasMasker.alias_return alias15 =null;


        CommonTree REALIAS14_tree=null;
        CommonTree IDENTIFIER16_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:106:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:106:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS14=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause210); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS14_tree = (CommonTree)adaptor.dupNode(REALIAS14);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS14_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause212);
            alias15=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias15.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER16=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause214); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER16_tree = (CommonTree)adaptor.dupNode(IDENTIFIER16);


            adaptor.addChild(root_1, IDENTIFIER16_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:109:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AliasMasker.parallel_clause_return parallel_clause() throws RecognitionException {
        AliasMasker.parallel_clause_return retval = new AliasMasker.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL17=null;
        CommonTree INTEGER18=null;

        CommonTree PARALLEL17_tree=null;
        CommonTree INTEGER18_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:110:5: ( ^( PARALLEL INTEGER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:110:7: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL17=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause230); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL17_tree = (CommonTree)adaptor.dupNode(PARALLEL17);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL17_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER18=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause232); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER18_tree = (CommonTree)adaptor.dupNode(INTEGER18);


            adaptor.addChild(root_1, INTEGER18_tree);
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
    // $ANTLR end "parallel_clause"


    public static class alias_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:113:1: alias : IDENTIFIER ;
    public final AliasMasker.alias_return alias() throws RecognitionException {
        AliasMasker.alias_return retval = new AliasMasker.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER19=null;

        CommonTree IDENTIFIER19_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:114:5: ( IDENTIFIER )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:114:7: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER19=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias247); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER19_tree = (CommonTree)adaptor.dupNode(IDENTIFIER19);


            adaptor.addChild(root_0, IDENTIFIER19_tree);
            }


            if ( state.backtracking==0 ) {
                        aliasSeen.add((IDENTIFIER19!=null?IDENTIFIER19.getText():null));
                        IDENTIFIER19.getToken().setText(getMask((IDENTIFIER19!=null?IDENTIFIER19.getText():null)));
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
    // $ANTLR end "alias"


    public static class op_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:121:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause );
    public final AliasMasker.op_clause_return op_clause() throws RecognitionException {
        AliasMasker.op_clause_return retval = new AliasMasker.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.define_clause_return define_clause20 =null;

        AliasMasker.load_clause_return load_clause21 =null;

        AliasMasker.group_clause_return group_clause22 =null;

        AliasMasker.store_clause_return store_clause23 =null;

        AliasMasker.filter_clause_return filter_clause24 =null;

        AliasMasker.distinct_clause_return distinct_clause25 =null;

        AliasMasker.limit_clause_return limit_clause26 =null;

        AliasMasker.sample_clause_return sample_clause27 =null;

        AliasMasker.order_clause_return order_clause28 =null;

        AliasMasker.rank_clause_return rank_clause29 =null;

        AliasMasker.cross_clause_return cross_clause30 =null;

        AliasMasker.join_clause_return join_clause31 =null;

        AliasMasker.union_clause_return union_clause32 =null;

        AliasMasker.stream_clause_return stream_clause33 =null;

        AliasMasker.mr_clause_return mr_clause34 =null;

        AliasMasker.split_clause_return split_clause35 =null;

        AliasMasker.foreach_clause_return foreach_clause36 =null;

        AliasMasker.cube_clause_return cube_clause37 =null;

        AliasMasker.assert_clause_return assert_clause38 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:121:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause )
            int alt5=19;
            switch ( input.LA(1) ) {
            case DEFINE:
                {
                alt5=1;
                }
                break;
            case LOAD:
                {
                alt5=2;
                }
                break;
            case COGROUP:
            case GROUP:
                {
                alt5=3;
                }
                break;
            case STORE:
                {
                alt5=4;
                }
                break;
            case FILTER:
                {
                alt5=5;
                }
                break;
            case DISTINCT:
                {
                alt5=6;
                }
                break;
            case LIMIT:
                {
                alt5=7;
                }
                break;
            case SAMPLE:
                {
                alt5=8;
                }
                break;
            case ORDER:
                {
                alt5=9;
                }
                break;
            case RANK:
                {
                alt5=10;
                }
                break;
            case CROSS:
                {
                alt5=11;
                }
                break;
            case JOIN:
                {
                alt5=12;
                }
                break;
            case UNION:
                {
                alt5=13;
                }
                break;
            case STREAM:
                {
                alt5=14;
                }
                break;
            case MAPREDUCE:
                {
                alt5=15;
                }
                break;
            case SPLIT:
                {
                alt5=16;
                }
                break;
            case FOREACH:
                {
                alt5=17;
                }
                break;
            case CUBE:
                {
                alt5=18;
                }
                break;
            case ASSERT:
                {
                alt5=19;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:121:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause266);
                    define_clause20=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause20.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:122:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause280);
                    load_clause21=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause21.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:123:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause294);
                    group_clause22=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause22.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:124:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause308);
                    store_clause23=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause23.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:125:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause322);
                    filter_clause24=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause24.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:126:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause336);
                    distinct_clause25=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause25.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:127:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause350);
                    limit_clause26=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause26.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:128:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause364);
                    sample_clause27=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause27.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:129:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause378);
                    order_clause28=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause28.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:130:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause392);
                    rank_clause29=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause29.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:131:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause406);
                    cross_clause30=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause30.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:132:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause420);
                    join_clause31=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause31.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:133:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause434);
                    union_clause32=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause32.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:134:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause448);
                    stream_clause33=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause33.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:135:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause462);
                    mr_clause34=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause34.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:136:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause476);
                    split_clause35=split_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_clause35.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:137:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause490);
                    foreach_clause36=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause36.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:138:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause504);
                    cube_clause37=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause37.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:139:13: assert_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_clause_in_op_clause518);
                    assert_clause38=assert_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_clause38.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:142:1: define_clause : ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) ;
    public final AliasMasker.define_clause_return define_clause() throws RecognitionException {
        AliasMasker.define_clause_return retval = new AliasMasker.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE39=null;
        CommonTree IDENTIFIER40=null;
        AliasMasker.cmd_return cmd41 =null;

        AliasMasker.func_clause_return func_clause42 =null;


        CommonTree DEFINE39_tree=null;
        CommonTree IDENTIFIER40_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:143:5: ( ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:143:7: ^( DEFINE IDENTIFIER ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE39=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause533); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE39_tree = (CommonTree)adaptor.dupNode(DEFINE39);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE39_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER40=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_define_clause535); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER40_tree = (CommonTree)adaptor.dupNode(IDENTIFIER40);


            adaptor.addChild(root_1, IDENTIFIER40_tree);
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:143:29: ( cmd | func_clause )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==EXECCOMMAND) ) {
                alt6=1;
            }
            else if ( (LA6_0==FUNC||LA6_0==FUNC_REF) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:143:31: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause540);
                    cmd41=cmd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd41.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:143:37: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause544);
                    func_clause42=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause42.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:146:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AliasMasker.cmd_return cmd() throws RecognitionException {
        AliasMasker.cmd_return retval = new AliasMasker.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND43=null;
        AliasMasker.ship_clause_return ship_clause44 =null;

        AliasMasker.cache_clause_return cache_clause45 =null;

        AliasMasker.input_clause_return input_clause46 =null;

        AliasMasker.output_clause_return output_clause47 =null;

        AliasMasker.error_clause_return error_clause48 =null;


        CommonTree EXECCOMMAND43_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:147:5: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:147:7: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND43=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd563); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND43_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND43);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND43_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:148:9: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
                loop7:
                do {
                    int alt7=6;
                    switch ( input.LA(1) ) {
                    case SHIP:
                        {
                        alt7=1;
                        }
                        break;
                    case CACHE:
                        {
                        alt7=2;
                        }
                        break;
                    case INPUT:
                        {
                        alt7=3;
                        }
                        break;
                    case OUTPUT:
                        {
                        alt7=4;
                        }
                        break;
                    case STDERROR:
                        {
                        alt7=5;
                        }
                        break;

                    }

                    switch (alt7) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:148:11: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd575);
                	    ship_clause44=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause44.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:148:25: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd579);
                	    cache_clause45=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause45.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:148:40: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd583);
                	    input_clause46=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause46.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:148:55: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd587);
                	    output_clause47=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause47.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:148:71: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd591);
                	    error_clause48=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause48.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop7;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:151:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AliasMasker.ship_clause_return ship_clause() throws RecognitionException {
        AliasMasker.ship_clause_return retval = new AliasMasker.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP49=null;
        AliasMasker.path_list_return path_list50 =null;


        CommonTree SHIP49_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:152:5: ( ^( SHIP ( path_list )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:152:7: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP49=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause611); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP49_tree = (CommonTree)adaptor.dupNode(SHIP49);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP49_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:152:15: ( path_list )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:152:15: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause613);
                        path_list50=path_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list50.getTree());


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
    // $ANTLR end "ship_clause"


    public static class path_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "path_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:155:1: path_list : ( QUOTEDSTRING )+ ;
    public final AliasMasker.path_list_return path_list() throws RecognitionException {
        AliasMasker.path_list_return retval = new AliasMasker.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING51=null;

        CommonTree QUOTEDSTRING51_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:156:5: ( ( QUOTEDSTRING )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:156:7: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:156:7: ( QUOTEDSTRING )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:156:7: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING51=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list629); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING51_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING51);


            	    adaptor.addChild(root_0, QUOTEDSTRING51_tree);
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:159:1: cache_clause : ^( CACHE path_list ) ;
    public final AliasMasker.cache_clause_return cache_clause() throws RecognitionException {
        AliasMasker.cache_clause_return retval = new AliasMasker.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE52=null;
        AliasMasker.path_list_return path_list53 =null;


        CommonTree CACHE52_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:160:5: ( ^( CACHE path_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:160:7: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE52=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause645); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE52_tree = (CommonTree)adaptor.dupNode(CACHE52);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE52_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause647);
            path_list53=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list53.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:163:1: input_clause : ^( INPUT ( stream_cmd )+ ) ;
    public final AliasMasker.input_clause_return input_clause() throws RecognitionException {
        AliasMasker.input_clause_return retval = new AliasMasker.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT54=null;
        AliasMasker.stream_cmd_return stream_cmd55 =null;


        CommonTree INPUT54_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:164:5: ( ^( INPUT ( stream_cmd )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:164:7: ^( INPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT54=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause664); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT54_tree = (CommonTree)adaptor.dupNode(INPUT54);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT54_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:164:16: ( stream_cmd )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING||(LA10_0 >= STDIN && LA10_0 <= STDOUT)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:164:16: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause666);
            	    stream_cmd55=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd55.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
    // $ANTLR end "input_clause"


    public static class stream_cmd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:167:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AliasMasker.stream_cmd_return stream_cmd() throws RecognitionException {
        AliasMasker.stream_cmd_return retval = new AliasMasker.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN56=null;
        CommonTree STDOUT58=null;
        CommonTree QUOTEDSTRING60=null;
        AliasMasker.func_clause_return func_clause57 =null;

        AliasMasker.func_clause_return func_clause59 =null;

        AliasMasker.func_clause_return func_clause61 =null;


        CommonTree STDIN56_tree=null;
        CommonTree STDOUT58_tree=null;
        CommonTree QUOTEDSTRING60_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:168:5: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case STDIN:
                {
                alt14=1;
                }
                break;
            case STDOUT:
                {
                alt14=2;
                }
                break;
            case QUOTEDSTRING:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:168:7: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN56=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd684); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN56_tree = (CommonTree)adaptor.dupNode(STDIN56);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN56_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:168:16: ( func_clause )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:168:16: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd686);
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
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:169:7: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT58=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT58_tree = (CommonTree)adaptor.dupNode(STDOUT58);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT58_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:169:17: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:169:17: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd701);
                                func_clause59=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause59.getTree());


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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:170:7: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING60=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd714); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING60_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING60);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING60_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:170:23: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:170:23: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd716);
                                func_clause61=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause61.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:173:1: output_clause : ^( OUTPUT ( stream_cmd )+ ) ;
    public final AliasMasker.output_clause_return output_clause() throws RecognitionException {
        AliasMasker.output_clause_return retval = new AliasMasker.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT62=null;
        AliasMasker.stream_cmd_return stream_cmd63 =null;


        CommonTree OUTPUT62_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:174:5: ( ^( OUTPUT ( stream_cmd )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:174:7: ^( OUTPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT62=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause734); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT62_tree = (CommonTree)adaptor.dupNode(OUTPUT62);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT62_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:174:17: ( stream_cmd )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==QUOTEDSTRING||(LA15_0 >= STDIN && LA15_0 <= STDOUT)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:174:17: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause736);
            	    stream_cmd63=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd63.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
    // $ANTLR end "output_clause"


    public static class error_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:177:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AliasMasker.error_clause_return error_clause() throws RecognitionException {
        AliasMasker.error_clause_return retval = new AliasMasker.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR64=null;
        CommonTree QUOTEDSTRING65=null;
        CommonTree INTEGER66=null;

        CommonTree STDERROR64_tree=null;
        CommonTree QUOTEDSTRING65_tree=null;
        CommonTree INTEGER66_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:178:5: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:178:7: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR64=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause754); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR64_tree = (CommonTree)adaptor.dupNode(STDERROR64);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR64_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:178:19: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:178:21: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING65=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause758); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING65_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING65);


                        adaptor.addChild(root_1, QUOTEDSTRING65_tree);
                        }


                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:178:34: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:178:34: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER66=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause760); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER66_tree = (CommonTree)adaptor.dupNode(INTEGER66);


                                adaptor.addChild(root_1, INTEGER66_tree);
                                }


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:181:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AliasMasker.load_clause_return load_clause() throws RecognitionException {
        AliasMasker.load_clause_return retval = new AliasMasker.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD67=null;
        AliasMasker.filename_return filename68 =null;

        AliasMasker.func_clause_return func_clause69 =null;

        AliasMasker.as_clause_return as_clause70 =null;


        CommonTree LOAD67_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:182:5: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:182:7: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD67=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause781); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD67_tree = (CommonTree)adaptor.dupNode(LOAD67);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD67_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause783);
            filename68=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename68.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:182:24: ( func_clause )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:182:24: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause785);
                    func_clause69=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause69.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:182:37: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:182:37: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause788);
                    as_clause70=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause70.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:185:1: filename : QUOTEDSTRING ;
    public final AliasMasker.filename_return filename() throws RecognitionException {
        AliasMasker.filename_return retval = new AliasMasker.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING71=null;

        CommonTree QUOTEDSTRING71_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:186:5: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:186:7: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING71=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename804); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING71_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING71);


            adaptor.addChild(root_0, QUOTEDSTRING71_tree);
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
    // $ANTLR end "filename"


    public static class as_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:189:1: as_clause : ^( AS field_def_list ) ;
    public final AliasMasker.as_clause_return as_clause() throws RecognitionException {
        AliasMasker.as_clause_return retval = new AliasMasker.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS72=null;
        AliasMasker.field_def_list_return field_def_list73 =null;


        CommonTree AS72_tree=null;


        	inAsOrGenClause = true;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:196:5: ( ^( AS field_def_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:196:7: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS72=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause829); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS72_tree = (CommonTree)adaptor.dupNode(AS72);


            root_1 = (CommonTree)adaptor.becomeRoot(AS72_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause831);
            field_def_list73=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list73.getTree());


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

            if ( state.backtracking==0 ) {
            	inAsOrGenClause = false;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:199:1: field_def : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) );
    public final AliasMasker.field_def_return field_def() throws RecognitionException {
        AliasMasker.field_def_return retval = new AliasMasker.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF74=null;
        CommonTree IDENTIFIER75=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER77=null;
        AliasMasker.type_return type76 =null;

        AliasMasker.type_return type78 =null;


        CommonTree FIELD_DEF74_tree=null;
        CommonTree IDENTIFIER75_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER77_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:200:5: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==FIELD_DEF) ) {
                alt21=1;
            }
            else if ( (LA21_0==FIELD_DEF_WITHOUT_IDENTIFIER) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:200:7: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF74=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def848); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF74_tree = (CommonTree)adaptor.dupNode(FIELD_DEF74);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF74_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER75=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def850); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER75_tree = (CommonTree)adaptor.dupNode(IDENTIFIER75);


                    adaptor.addChild(root_1, IDENTIFIER75_tree);
                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:200:31: ( type )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==BIGDECIMAL||LA20_0==BIGINTEGER||LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DATETIME||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:200:31: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def852);
                            type76=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type76.getTree());


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
                    	if (inAsOrGenClause) {
                    		if (aliasSeen.contains((IDENTIFIER75!=null?IDENTIFIER75.getText():null))) {
                    			throw new ParserValidationException(input, new SourceLocation((PigParserNode)((CommonTree)retval.start)),
                    				"Macro doesn't support user defined schema that contains name that conflicts with alias name: " + (IDENTIFIER75!=null?IDENTIFIER75.getText():null));
                    		}
                    	}
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:208:7: ^( FIELD_DEF_WITHOUT_IDENTIFIER type )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER77=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def867); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER77_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER77);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER77_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def869);
                    type78=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type78.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:211:1: field_def_list : ( field_def )+ ;
    public final AliasMasker.field_def_list_return field_def_list() throws RecognitionException {
        AliasMasker.field_def_list_return retval = new AliasMasker.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.field_def_return field_def79 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:212:5: ( ( field_def )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:212:7: ( field_def )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:212:7: ( field_def )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0 >= FIELD_DEF && LA22_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:212:7: field_def
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list884);
            	    field_def79=field_def();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def79.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
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
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:215:1: type : ( simple_type | tuple_type | bag_type | map_type );
    public final AliasMasker.type_return type() throws RecognitionException {
        AliasMasker.type_return retval = new AliasMasker.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.simple_type_return simple_type80 =null;

        AliasMasker.tuple_type_return tuple_type81 =null;

        AliasMasker.bag_type_return bag_type82 =null;

        AliasMasker.map_type_return map_type83 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:215:6: ( simple_type | tuple_type | bag_type | map_type )
            int alt23=4;
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
                alt23=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt23=2;
                }
                break;
            case BAG_TYPE:
                {
                alt23=3;
                }
                break;
            case MAP_TYPE:
                {
                alt23=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }

            switch (alt23) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:215:8: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type894);
                    simple_type80=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type80.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:215:22: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type898);
                    tuple_type81=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type81.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:215:35: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type902);
                    bag_type82=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type82.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:215:46: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type906);
                    map_type83=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type83.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:218:1: simple_type : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | BIGINTEGER | BIGDECIMAL | CHARARRAY | BYTEARRAY );
    public final AliasMasker.simple_type_return simple_type() throws RecognitionException {
        AliasMasker.simple_type_return retval = new AliasMasker.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set84=null;

        CommonTree set84_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:219:5: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | BIGINTEGER | BIGDECIMAL | CHARARRAY | BYTEARRAY )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set84=(CommonTree)input.LT(1);

            if ( input.LA(1)==BIGDECIMAL||input.LA(1)==BIGINTEGER||input.LA(1)==BOOLEAN||input.LA(1)==BYTEARRAY||input.LA(1)==CHARARRAY||input.LA(1)==DATETIME||input.LA(1)==DOUBLE||input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==LONG ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set84_tree = (CommonTree)adaptor.dupNode(set84);


                adaptor.addChild(root_0, set84_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:222:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AliasMasker.tuple_type_return tuple_type() throws RecognitionException {
        AliasMasker.tuple_type_return retval = new AliasMasker.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE85=null;
        AliasMasker.field_def_list_return field_def_list86 =null;


        CommonTree TUPLE_TYPE85_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:223:5: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:223:7: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE85=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type970); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE85_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE85);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE85_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:223:21: ( field_def_list )?
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0 >= FIELD_DEF && LA24_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt24=1;
                }
                switch (alt24) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:223:21: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type972);
                        field_def_list86=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list86.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:226:1: bag_type : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final AliasMasker.bag_type_return bag_type() throws RecognitionException {
        AliasMasker.bag_type_return retval = new AliasMasker.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE87=null;
        CommonTree IDENTIFIER88=null;
        AliasMasker.tuple_type_return tuple_type89 =null;


        CommonTree BAG_TYPE87_tree=null;
        CommonTree IDENTIFIER88_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:227:5: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:227:7: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE87=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type990); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE87_tree = (CommonTree)adaptor.dupNode(BAG_TYPE87);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE87_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:227:19: ( IDENTIFIER )?
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==IDENTIFIER) ) {
                    alt25=1;
                }
                switch (alt25) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:227:19: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER88=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type992); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER88_tree = (CommonTree)adaptor.dupNode(IDENTIFIER88);


                        adaptor.addChild(root_1, IDENTIFIER88_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:227:31: ( tuple_type )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==TUPLE_TYPE) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:227:31: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type995);
                        tuple_type89=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type89.getTree());


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
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:230:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AliasMasker.map_type_return map_type() throws RecognitionException {
        AliasMasker.map_type_return retval = new AliasMasker.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE90=null;
        AliasMasker.type_return type91 =null;


        CommonTree MAP_TYPE90_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:230:10: ( ^( MAP_TYPE ( type )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:230:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE90=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1009); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE90_tree = (CommonTree)adaptor.dupNode(MAP_TYPE90);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE90_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:230:24: ( type )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==BIGDECIMAL||LA27_0==BIGINTEGER||LA27_0==BOOLEAN||LA27_0==BYTEARRAY||LA27_0==CHARARRAY||LA27_0==DATETIME||LA27_0==DOUBLE||LA27_0==FLOAT||LA27_0==INT||LA27_0==LONG||LA27_0==BAG_TYPE||LA27_0==MAP_TYPE||LA27_0==TUPLE_TYPE) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:230:24: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1011);
                        type91=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type91.getTree());


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
    // $ANTLR end "map_type"


    public static class func_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:233:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AliasMasker.func_clause_return func_clause() throws RecognitionException {
        AliasMasker.func_clause_return retval = new AliasMasker.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF92=null;
        CommonTree FUNC94=null;
        AliasMasker.func_name_return func_name93 =null;

        AliasMasker.func_name_return func_name95 =null;

        AliasMasker.func_args_return func_args96 =null;


        CommonTree FUNC_REF92_tree=null;
        CommonTree FUNC94_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:234:5: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==FUNC_REF) ) {
                alt29=1;
            }
            else if ( (LA29_0==FUNC) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:234:7: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF92=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1029); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF92_tree = (CommonTree)adaptor.dupNode(FUNC_REF92);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF92_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1031);
                    func_name93=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name93.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:235:7: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC94=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1043); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC94_tree = (CommonTree)adaptor.dupNode(FUNC94);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC94_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1045);
                    func_name95=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name95.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:235:25: ( func_args )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==QUOTEDSTRING) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:235:25: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1047);
                            func_args96=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args96.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:238:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AliasMasker.func_name_return func_name() throws RecognitionException {
        AliasMasker.func_name_return retval = new AliasMasker.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set98=null;
        AliasMasker.eid_return eid97 =null;

        AliasMasker.eid_return eid99 =null;


        CommonTree set98_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:239:5: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:239:7: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1063);
            eid97=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid97.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:239:11: ( ( PERIOD | DOLLAR ) eid )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==DOLLAR||LA30_0==PERIOD) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:239:13: ( PERIOD | DOLLAR ) eid
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    set98=(CommonTree)input.LT(1);

            	    if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) {
            	        set98_tree = (CommonTree)adaptor.dupNode(set98);


            	        adaptor.addChild(root_0, set98_tree);
            	        }

            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1077);
            	    eid99=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid99.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop30;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:242:1: func_args : ( QUOTEDSTRING )+ ;
    public final AliasMasker.func_args_return func_args() throws RecognitionException {
        AliasMasker.func_args_return retval = new AliasMasker.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING100=null;

        CommonTree QUOTEDSTRING100_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:243:5: ( ( QUOTEDSTRING )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:243:7: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:243:7: ( QUOTEDSTRING )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==QUOTEDSTRING) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:243:7: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING100=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1093); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING100_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING100);


            	    adaptor.addChild(root_0, QUOTEDSTRING100_tree);
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
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


    public static class cube_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:246:1: cube_clause : ^( CUBE cube_item ) ;
    public final AliasMasker.cube_clause_return cube_clause() throws RecognitionException {
        AliasMasker.cube_clause_return retval = new AliasMasker.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE101=null;
        AliasMasker.cube_item_return cube_item102 =null;


        CommonTree CUBE101_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:247:5: ( ^( CUBE cube_item ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:247:7: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE101=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1109); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE101_tree = (CommonTree)adaptor.dupNode(CUBE101);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE101_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1111);
            cube_item102=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item102.getTree());


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


    public static class pivot_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pivot_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:250:1: pivot_clause : ^( PIVOT INTEGER ) ;
    public final AliasMasker.pivot_clause_return pivot_clause() throws RecognitionException {
        AliasMasker.pivot_clause_return retval = new AliasMasker.pivot_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PIVOT103=null;
        CommonTree INTEGER104=null;

        CommonTree PIVOT103_tree=null;
        CommonTree INTEGER104_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:251:5: ( ^( PIVOT INTEGER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:251:7: ^( PIVOT INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PIVOT103=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_pivot_clause1128); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PIVOT103_tree = (CommonTree)adaptor.dupNode(PIVOT103);


            root_1 = (CommonTree)adaptor.becomeRoot(PIVOT103_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER104=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_pivot_clause1130); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER104_tree = (CommonTree)adaptor.dupNode(INTEGER104);


            adaptor.addChild(root_1, INTEGER104_tree);
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
    // $ANTLR end "pivot_clause"


    public static class cube_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_item"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:254:1: cube_item : rel ( cube_by_clause ) ;
    public final AliasMasker.cube_item_return cube_item() throws RecognitionException {
        AliasMasker.cube_item_return retval = new AliasMasker.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.rel_return rel105 =null;

        AliasMasker.cube_by_clause_return cube_by_clause106 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:255:5: ( rel ( cube_by_clause ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:255:7: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1145);
            rel105=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel105.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:255:11: ( cube_by_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:255:13: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1149);
            cube_by_clause106=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause106.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:258:1: cube_by_clause : ^( BY cube_or_rollup ) ;
    public final AliasMasker.cube_by_clause_return cube_by_clause() throws RecognitionException {
        AliasMasker.cube_by_clause_return retval = new AliasMasker.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY107=null;
        AliasMasker.cube_or_rollup_return cube_or_rollup108 =null;


        CommonTree BY107_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:259:5: ( ^( BY cube_or_rollup ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:259:7: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY107=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1166); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY107_tree = (CommonTree)adaptor.dupNode(BY107);


            root_1 = (CommonTree)adaptor.becomeRoot(BY107_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1168);
            cube_or_rollup108=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup108.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:262:1: cube_or_rollup : ( cube_rollup_list )+ ;
    public final AliasMasker.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        AliasMasker.cube_or_rollup_return retval = new AliasMasker.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.cube_rollup_list_return cube_rollup_list109 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:263:5: ( ( cube_rollup_list )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:263:7: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:263:7: ( cube_rollup_list )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==CUBE||LA32_0==ROLLUP) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:263:7: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1183);
            	    cube_rollup_list109=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list109.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:266:1: cube_rollup_list : ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ( pivot_clause )? ) );
    public final AliasMasker.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        AliasMasker.cube_rollup_list_return retval = new AliasMasker.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE110=null;
        CommonTree ROLLUP112=null;
        AliasMasker.cube_by_expr_list_return cube_by_expr_list111 =null;

        AliasMasker.cube_by_expr_list_return cube_by_expr_list113 =null;

        AliasMasker.pivot_clause_return pivot_clause114 =null;


        CommonTree CUBE110_tree=null;
        CommonTree ROLLUP112_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:267:5: ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ( pivot_clause )? ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==CUBE) ) {
                alt34=1;
            }
            else if ( (LA34_0==ROLLUP) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }
            switch (alt34) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:267:7: ^( CUBE cube_by_expr_list )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CUBE110=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_rollup_list1199); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE110_tree = (CommonTree)adaptor.dupNode(CUBE110);


                    root_1 = (CommonTree)adaptor.becomeRoot(CUBE110_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1201);
                    cube_by_expr_list111=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list111.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:267:37: ^( ROLLUP cube_by_expr_list ( pivot_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    ROLLUP112=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_cube_rollup_list1209); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP112_tree = (CommonTree)adaptor.dupNode(ROLLUP112);


                    root_1 = (CommonTree)adaptor.becomeRoot(ROLLUP112_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1211);
                    cube_by_expr_list113=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list113.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:267:65: ( pivot_clause )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==PIVOT) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:267:65: pivot_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_pivot_clause_in_cube_rollup_list1213);
                            pivot_clause114=pivot_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, pivot_clause114.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:270:1: cube_by_expr_list : ( cube_by_expr )+ ;
    public final AliasMasker.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        AliasMasker.cube_by_expr_list_return retval = new AliasMasker.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.cube_by_expr_return cube_by_expr115 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:271:5: ( ( cube_by_expr )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:271:7: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:271:7: ( cube_by_expr )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==BIGDECIMALNUMBER||LA35_0==BIGINTEGERNUMBER||LA35_0==CUBE||LA35_0==DIV||LA35_0==DOLLARVAR||LA35_0==DOUBLENUMBER||LA35_0==FALSE||LA35_0==FLOATNUMBER||LA35_0==GROUP||LA35_0==IDENTIFIER||LA35_0==INTEGER||LA35_0==LONGINTEGER||LA35_0==MINUS||LA35_0==NULL||LA35_0==PERCENT||LA35_0==PLUS||LA35_0==QUOTEDSTRING||LA35_0==STAR||LA35_0==TRUE||(LA35_0 >= BAG_VAL && LA35_0 <= BIN_EXPR)||(LA35_0 >= CASE_COND && LA35_0 <= CASE_EXPR)||(LA35_0 >= CAST_EXPR && LA35_0 <= EXPR_IN_PAREN)||LA35_0==FUNC_EVAL||(LA35_0 >= MAP_VAL && LA35_0 <= NEG)||LA35_0==TUPLE_VAL) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:271:7: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1229);
            	    cube_by_expr115=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr115.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
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
    // $ANTLR end "cube_by_expr_list"


    public static class cube_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:274:1: cube_by_expr : ( col_range | expr | STAR );
    public final AliasMasker.cube_by_expr_return cube_by_expr() throws RecognitionException {
        AliasMasker.cube_by_expr_return retval = new AliasMasker.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR118=null;
        AliasMasker.col_range_return col_range116 =null;

        AliasMasker.expr_return expr117 =null;


        CommonTree STAR118_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:275:5: ( col_range | expr | STAR )
            int alt36=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt36=1;
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
                alt36=2;
                }
                break;
            case STAR:
                {
                int LA36_3 = input.LA(2);

                if ( (LA36_3==DOWN) ) {
                    alt36=2;
                }
                else if ( (LA36_3==EOF||LA36_3==UP||LA36_3==BIGDECIMALNUMBER||LA36_3==BIGINTEGERNUMBER||LA36_3==CUBE||LA36_3==DIV||LA36_3==DOLLARVAR||LA36_3==DOUBLENUMBER||LA36_3==FALSE||LA36_3==FLOATNUMBER||LA36_3==GROUP||LA36_3==IDENTIFIER||LA36_3==INTEGER||LA36_3==LONGINTEGER||LA36_3==MINUS||LA36_3==NULL||LA36_3==PERCENT||(LA36_3 >= PIVOT && LA36_3 <= PLUS)||LA36_3==QUOTEDSTRING||LA36_3==STAR||LA36_3==TRUE||(LA36_3 >= BAG_VAL && LA36_3 <= BIN_EXPR)||(LA36_3 >= CASE_COND && LA36_3 <= CASE_EXPR)||(LA36_3 >= CAST_EXPR && LA36_3 <= EXPR_IN_PAREN)||LA36_3==FUNC_EVAL||(LA36_3 >= MAP_VAL && LA36_3 <= NEG)||LA36_3==TUPLE_VAL) ) {
                    alt36=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }

            switch (alt36) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:275:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1243);
                    col_range116=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range116.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:275:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1247);
                    expr117=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr117.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:275:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR118=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1251); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR118_tree = (CommonTree)adaptor.dupNode(STAR118);


                    adaptor.addChild(root_0, STAR118_tree);
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
    // $ANTLR end "cube_by_expr"


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:278:1: group_clause : ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) ;
    public final AliasMasker.group_clause_return group_clause() throws RecognitionException {
        AliasMasker.group_clause_return retval = new AliasMasker.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set119=null;
        AliasMasker.group_item_return group_item120 =null;

        AliasMasker.group_type_return group_type121 =null;

        AliasMasker.partition_clause_return partition_clause122 =null;


        CommonTree set119_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:279:5: ( ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:279:7: ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set119=(CommonTree)input.LT(1);

            if ( input.LA(1)==COGROUP||input.LA(1)==GROUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set119_tree = (CommonTree)adaptor.dupNode(set119);


                root_1 = (CommonTree)adaptor.becomeRoot(set119_tree, root_1);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:279:30: ( group_item )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==ASSERT||LA37_0==COGROUP||(LA37_0 >= CROSS && LA37_0 <= CUBE)||LA37_0==DEFINE||LA37_0==DISTINCT||LA37_0==FILTER||LA37_0==FOREACH||LA37_0==GROUP||LA37_0==IDENTIFIER||LA37_0==JOIN||(LA37_0 >= LIMIT && LA37_0 <= LOAD)||LA37_0==MAPREDUCE||LA37_0==ORDER||LA37_0==RANK||LA37_0==SAMPLE||LA37_0==SPLIT||(LA37_0 >= STORE && LA37_0 <= STREAM)||LA37_0==UNION) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:279:30: group_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1276);
            	    group_item120=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item120.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:279:42: ( group_type )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==QUOTEDSTRING) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:279:42: group_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1279);
                    group_type121=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type121.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:279:54: ( partition_clause )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==PARTITION) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:279:54: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1282);
                    partition_clause122=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause122.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:282:1: group_type : QUOTEDSTRING ;
    public final AliasMasker.group_type_return group_type() throws RecognitionException {
        AliasMasker.group_type_return retval = new AliasMasker.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING123=null;

        CommonTree QUOTEDSTRING123_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:282:12: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:282:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING123=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1294); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING123_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING123);


            adaptor.addChild(root_0, QUOTEDSTRING123_tree);
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
    // $ANTLR end "group_type"


    public static class group_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_item"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:285:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AliasMasker.group_item_return group_item() throws RecognitionException {
        AliasMasker.group_item_return retval = new AliasMasker.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL126=null;
        CommonTree ANY127=null;
        CommonTree set128=null;
        AliasMasker.rel_return rel124 =null;

        AliasMasker.join_group_by_clause_return join_group_by_clause125 =null;


        CommonTree ALL126_tree=null;
        CommonTree ANY127_tree=null;
        CommonTree set128_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:286:5: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:286:7: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1307);
            rel124=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel124.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:286:11: ( join_group_by_clause | ALL | ANY )
            int alt40=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt40=1;
                }
                break;
            case ALL:
                {
                alt40=2;
                }
                break;
            case ANY:
                {
                alt40=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }

            switch (alt40) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:286:13: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1311);
                    join_group_by_clause125=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause125.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:286:36: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL126=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1315); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL126_tree = (CommonTree)adaptor.dupNode(ALL126);


                    adaptor.addChild(root_0, ALL126_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:286:42: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY127=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1319); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY127_tree = (CommonTree)adaptor.dupNode(ANY127);


                    adaptor.addChild(root_0, ANY127_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:286:48: ( INNER | OUTER )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==INNER||LA41_0==OUTER) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set128=(CommonTree)input.LT(1);

                    if ( input.LA(1)==INNER||input.LA(1)==OUTER ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set128_tree = (CommonTree)adaptor.dupNode(set128);


                        adaptor.addChild(root_0, set128_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:289:1: rel : ( alias | ( op_clause ( parallel_clause )? ) );
    public final AliasMasker.rel_return rel() throws RecognitionException {
        AliasMasker.rel_return retval = new AliasMasker.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.alias_return alias129 =null;

        AliasMasker.op_clause_return op_clause130 =null;

        AliasMasker.parallel_clause_return parallel_clause131 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:290:5: ( alias | ( op_clause ( parallel_clause )? ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==IDENTIFIER) ) {
                alt43=1;
            }
            else if ( (LA43_0==ASSERT||LA43_0==COGROUP||(LA43_0 >= CROSS && LA43_0 <= CUBE)||LA43_0==DEFINE||LA43_0==DISTINCT||LA43_0==FILTER||LA43_0==FOREACH||LA43_0==GROUP||LA43_0==JOIN||(LA43_0 >= LIMIT && LA43_0 <= LOAD)||LA43_0==MAPREDUCE||LA43_0==ORDER||LA43_0==RANK||LA43_0==SAMPLE||LA43_0==SPLIT||(LA43_0 >= STORE && LA43_0 <= STREAM)||LA43_0==UNION) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:290:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1345);
                    alias129=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias129.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:290:15: ( op_clause ( parallel_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:290:15: ( op_clause ( parallel_clause )? )
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:290:17: op_clause ( parallel_clause )?
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1351);
                    op_clause130=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause130.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:290:27: ( parallel_clause )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==PARALLEL) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:290:27: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1353);
                            parallel_clause131=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause131.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:293:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AliasMasker.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AliasMasker.flatten_generated_item_return retval = new AliasMasker.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR135=null;
        AliasMasker.flatten_clause_return flatten_clause132 =null;

        AliasMasker.col_range_return col_range133 =null;

        AliasMasker.expr_return expr134 =null;

        AliasMasker.field_def_list_return field_def_list136 =null;


        CommonTree STAR135_tree=null;


        	inAsOrGenClause = true;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:300:5: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:300:7: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:300:7: ( flatten_clause | col_range | expr | STAR )
            int alt44=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt44=1;
                }
                break;
            case COL_RANGE:
                {
                alt44=2;
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
                alt44=3;
                }
                break;
            case STAR:
                {
                int LA44_4 = input.LA(2);

                if ( (LA44_4==DOWN) ) {
                    alt44=3;
                }
                else if ( (LA44_4==EOF||LA44_4==UP||LA44_4==BIGDECIMALNUMBER||LA44_4==BIGINTEGERNUMBER||LA44_4==CUBE||LA44_4==DIV||LA44_4==DOLLARVAR||LA44_4==DOUBLENUMBER||LA44_4==FALSE||LA44_4==FLATTEN||LA44_4==FLOATNUMBER||LA44_4==GROUP||LA44_4==IDENTIFIER||LA44_4==INTEGER||LA44_4==LONGINTEGER||LA44_4==MINUS||LA44_4==NULL||LA44_4==PERCENT||LA44_4==PLUS||LA44_4==QUOTEDSTRING||LA44_4==STAR||LA44_4==TRUE||(LA44_4 >= BAG_VAL && LA44_4 <= BIN_EXPR)||(LA44_4 >= CASE_COND && LA44_4 <= CASE_EXPR)||(LA44_4 >= CAST_EXPR && LA44_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA44_4==FUNC_EVAL||(LA44_4 >= MAP_VAL && LA44_4 <= NEG)||LA44_4==TUPLE_VAL) ) {
                    alt44=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }

            switch (alt44) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:300:9: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1381);
                    flatten_clause132=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause132.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:300:26: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1385);
                    col_range133=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range133.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:300:38: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1389);
                    expr134=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr134.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:300:45: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR135=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1393); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR135_tree = (CommonTree)adaptor.dupNode(STAR135);


                    adaptor.addChild(root_0, STAR135_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:300:52: ( field_def_list )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0 >= FIELD_DEF && LA45_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:300:52: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1397);
                    field_def_list136=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list136.getTree());


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

            if ( state.backtracking==0 ) {
            	inAsOrGenClause = false;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:303:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AliasMasker.flatten_clause_return flatten_clause() throws RecognitionException {
        AliasMasker.flatten_clause_return retval = new AliasMasker.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN137=null;
        AliasMasker.expr_return expr138 =null;


        CommonTree FLATTEN137_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:304:5: ( ^( FLATTEN expr ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:304:7: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN137=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1413); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN137_tree = (CommonTree)adaptor.dupNode(FLATTEN137);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN137_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1415);
            expr138=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr138.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:307:1: store_clause : ^( STORE alias filename ( func_clause )? ) ;
    public final AliasMasker.store_clause_return store_clause() throws RecognitionException {
        AliasMasker.store_clause_return retval = new AliasMasker.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE139=null;
        AliasMasker.alias_return alias140 =null;

        AliasMasker.filename_return filename141 =null;

        AliasMasker.func_clause_return func_clause142 =null;


        CommonTree STORE139_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:308:5: ( ^( STORE alias filename ( func_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:308:7: ^( STORE alias filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE139=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1432); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE139_tree = (CommonTree)adaptor.dupNode(STORE139);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE139_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_store_clause1434);
            alias140=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias140.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1436);
            filename141=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename141.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:308:31: ( func_clause )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==FUNC||LA46_0==FUNC_REF) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:308:31: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1438);
                    func_clause142=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause142.getTree());


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


    public static class assert_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:311:1: assert_clause : ^( ASSERT alias cond ( comment )? ) ;
    public final AliasMasker.assert_clause_return assert_clause() throws RecognitionException {
        AliasMasker.assert_clause_return retval = new AliasMasker.assert_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSERT143=null;
        AliasMasker.alias_return alias144 =null;

        AliasMasker.cond_return cond145 =null;

        AliasMasker.comment_return comment146 =null;


        CommonTree ASSERT143_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:312:5: ( ^( ASSERT alias cond ( comment )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:312:7: ^( ASSERT alias cond ( comment )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSERT143=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause1456); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSERT143_tree = (CommonTree)adaptor.dupNode(ASSERT143);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSERT143_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_assert_clause1458);
            alias144=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias144.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_assert_clause1460);
            cond145=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond145.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:312:28: ( comment )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==QUOTEDSTRING) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:312:28: comment
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comment_in_assert_clause1462);
                    comment146=comment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, comment146.getTree());


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


    public static class comment_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comment"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:315:1: comment : QUOTEDSTRING ;
    public final AliasMasker.comment_return comment() throws RecognitionException {
        AliasMasker.comment_return retval = new AliasMasker.comment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING147=null;

        CommonTree QUOTEDSTRING147_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:315:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:315:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING147=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_comment1474); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING147_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING147);


            adaptor.addChild(root_0, QUOTEDSTRING147_tree);
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
    // $ANTLR end "comment"


    public static class filter_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:318:1: filter_clause : ^( FILTER rel cond ) ;
    public final AliasMasker.filter_clause_return filter_clause() throws RecognitionException {
        AliasMasker.filter_clause_return retval = new AliasMasker.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER148=null;
        AliasMasker.rel_return rel149 =null;

        AliasMasker.cond_return cond150 =null;


        CommonTree FILTER148_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:319:5: ( ^( FILTER rel cond ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:319:7: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER148=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1489); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER148_tree = (CommonTree)adaptor.dupNode(FILTER148);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER148_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1491);
            rel149=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel149.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1493);
            cond150=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond150.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:322:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) );
    public final AliasMasker.cond_return cond() throws RecognitionException {
        AliasMasker.cond_return retval = new AliasMasker.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR151=null;
        CommonTree AND154=null;
        CommonTree NOT157=null;
        CommonTree NULL159=null;
        CommonTree NOT161=null;
        CommonTree BOOL_COND167=null;
        AliasMasker.cond_return cond152 =null;

        AliasMasker.cond_return cond153 =null;

        AliasMasker.cond_return cond155 =null;

        AliasMasker.cond_return cond156 =null;

        AliasMasker.cond_return cond158 =null;

        AliasMasker.expr_return expr160 =null;

        AliasMasker.rel_op_return rel_op162 =null;

        AliasMasker.expr_return expr163 =null;

        AliasMasker.expr_return expr164 =null;

        AliasMasker.in_eval_return in_eval165 =null;

        AliasMasker.func_eval_return func_eval166 =null;

        AliasMasker.expr_return expr168 =null;


        CommonTree OR151_tree=null;
        CommonTree AND154_tree=null;
        CommonTree NOT157_tree=null;
        CommonTree NULL159_tree=null;
        CommonTree NOT161_tree=null;
        CommonTree BOOL_COND167_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:323:5: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) )
            int alt49=8;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt49=1;
                }
                break;
            case AND:
                {
                alt49=2;
                }
                break;
            case NOT:
                {
                alt49=3;
                }
                break;
            case NULL:
                {
                alt49=4;
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
                alt49=5;
                }
                break;
            case IN:
                {
                alt49=6;
                }
                break;
            case FUNC_EVAL:
                {
                alt49=7;
                }
                break;
            case BOOL_COND:
                {
                alt49=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }

            switch (alt49) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:323:7: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR151=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1510); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR151_tree = (CommonTree)adaptor.dupNode(OR151);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR151_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1512);
                    cond152=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond152.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1514);
                    cond153=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond153.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:324:7: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND154=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1526); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND154_tree = (CommonTree)adaptor.dupNode(AND154);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND154_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1528);
                    cond155=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond155.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1530);
                    cond156=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond156.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:325:7: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT157=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1542); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT157_tree = (CommonTree)adaptor.dupNode(NOT157);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT157_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1544);
                    cond158=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond158.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:326:7: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL159=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1556); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL159_tree = (CommonTree)adaptor.dupNode(NULL159);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL159_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1558);
                    expr160=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr160.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:326:20: ( NOT )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==NOT) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:326:20: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT161=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1560); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT161_tree = (CommonTree)adaptor.dupNode(NOT161);


                            adaptor.addChild(root_1, NOT161_tree);
                            }


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
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:327:7: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1573);
                    rel_op162=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op162.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1575);
                    expr163=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr163.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1577);
                    expr164=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr164.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:328:7: in_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond1587);
                    in_eval165=in_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval165.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:329:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1595);
                    func_eval166=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval166.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:330:7: ^( BOOL_COND expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND167=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond1605); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND167_tree = (CommonTree)adaptor.dupNode(BOOL_COND167);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND167_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1607);
                    expr168=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr168.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:333:1: in_eval : ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ ) ;
    public final AliasMasker.in_eval_return in_eval() throws RecognitionException {
        AliasMasker.in_eval_return retval = new AliasMasker.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN169=null;
        CommonTree IN_LHS170=null;
        CommonTree IN_RHS172=null;
        AliasMasker.expr_return expr171 =null;

        AliasMasker.expr_return expr173 =null;


        CommonTree IN169_tree=null;
        CommonTree IN_LHS170_tree=null;
        CommonTree IN_RHS172_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:334:5: ( ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:334:7: ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN169=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval1624); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN169_tree = (CommonTree)adaptor.dupNode(IN169);


            root_1 = (CommonTree)adaptor.becomeRoot(IN169_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:334:13: ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==IN_LHS) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:334:15: ^( IN_LHS expr ) ^( IN_RHS expr )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_LHS170=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval1630); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_LHS170_tree = (CommonTree)adaptor.dupNode(IN_LHS170);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS170_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1632);
            	    expr171=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr171.getTree());


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
            	    IN_RHS172=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval1638); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_RHS172_tree = (CommonTree)adaptor.dupNode(IN_RHS172);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS172_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1640);
            	    expr173=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr173.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
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
    // $ANTLR end "in_eval"


    public static class func_eval_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:337:1: func_eval : ^( FUNC_EVAL func_name ( real_arg )* ) ;
    public final AliasMasker.func_eval_return func_eval() throws RecognitionException {
        AliasMasker.func_eval_return retval = new AliasMasker.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL174=null;
        AliasMasker.func_name_return func_name175 =null;

        AliasMasker.real_arg_return real_arg176 =null;


        CommonTree FUNC_EVAL174_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:338:5: ( ^( FUNC_EVAL func_name ( real_arg )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:338:7: ^( FUNC_EVAL func_name ( real_arg )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FUNC_EVAL174=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1662); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNC_EVAL174_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL174);


            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL174_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_func_eval1664);
            func_name175=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name175.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:338:30: ( real_arg )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==BIGDECIMALNUMBER||LA51_0==BIGINTEGERNUMBER||LA51_0==CUBE||LA51_0==DIV||LA51_0==DOLLARVAR||LA51_0==DOUBLENUMBER||LA51_0==FALSE||LA51_0==FLOATNUMBER||LA51_0==GROUP||LA51_0==IDENTIFIER||LA51_0==INTEGER||LA51_0==LONGINTEGER||LA51_0==MINUS||LA51_0==NULL||LA51_0==PERCENT||LA51_0==PLUS||LA51_0==QUOTEDSTRING||LA51_0==STAR||LA51_0==TRUE||(LA51_0 >= BAG_VAL && LA51_0 <= BIN_EXPR)||(LA51_0 >= CASE_COND && LA51_0 <= CASE_EXPR)||LA51_0==CAST_EXPR||LA51_0==EXPR_IN_PAREN||LA51_0==FUNC_EVAL||(LA51_0 >= MAP_VAL && LA51_0 <= NEG)||LA51_0==TUPLE_VAL) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:338:30: real_arg
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_real_arg_in_func_eval1666);
            	    real_arg176=real_arg();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, real_arg176.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop51;
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
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:341:1: real_arg : ( expr | STAR );
    public final AliasMasker.real_arg_return real_arg() throws RecognitionException {
        AliasMasker.real_arg_return retval = new AliasMasker.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR178=null;
        AliasMasker.expr_return expr177 =null;


        CommonTree STAR178_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:342:5: ( expr | STAR )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==BIGDECIMALNUMBER||LA52_0==BIGINTEGERNUMBER||LA52_0==CUBE||LA52_0==DIV||LA52_0==DOLLARVAR||LA52_0==DOUBLENUMBER||LA52_0==FALSE||LA52_0==FLOATNUMBER||LA52_0==GROUP||LA52_0==IDENTIFIER||LA52_0==INTEGER||LA52_0==LONGINTEGER||LA52_0==MINUS||LA52_0==NULL||LA52_0==PERCENT||LA52_0==PLUS||LA52_0==QUOTEDSTRING||LA52_0==TRUE||(LA52_0 >= BAG_VAL && LA52_0 <= BIN_EXPR)||(LA52_0 >= CASE_COND && LA52_0 <= CASE_EXPR)||LA52_0==CAST_EXPR||LA52_0==EXPR_IN_PAREN||LA52_0==FUNC_EVAL||(LA52_0 >= MAP_VAL && LA52_0 <= NEG)||LA52_0==TUPLE_VAL) ) {
                alt52=1;
            }
            else if ( (LA52_0==STAR) ) {
                int LA52_2 = input.LA(2);

                if ( (LA52_2==DOWN) ) {
                    alt52=1;
                }
                else if ( (LA52_2==EOF||LA52_2==UP||LA52_2==BIGDECIMALNUMBER||LA52_2==BIGINTEGERNUMBER||LA52_2==CUBE||LA52_2==DIV||LA52_2==DOLLARVAR||LA52_2==DOUBLENUMBER||LA52_2==FALSE||LA52_2==FLOATNUMBER||LA52_2==GROUP||LA52_2==IDENTIFIER||LA52_2==INTEGER||LA52_2==LONGINTEGER||LA52_2==MINUS||LA52_2==NULL||LA52_2==PERCENT||LA52_2==PLUS||LA52_2==QUOTEDSTRING||LA52_2==STAR||LA52_2==TRUE||(LA52_2 >= BAG_VAL && LA52_2 <= BIN_EXPR)||(LA52_2 >= CASE_COND && LA52_2 <= CASE_EXPR)||LA52_2==CAST_EXPR||LA52_2==EXPR_IN_PAREN||LA52_2==FUNC_EVAL||(LA52_2 >= MAP_VAL && LA52_2 <= NEG)||LA52_2==TUPLE_VAL) ) {
                    alt52=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }
            switch (alt52) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:342:7: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg1682);
                    expr177=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr177.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:342:14: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR178=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg1686); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR178_tree = (CommonTree)adaptor.dupNode(STAR178);


                    adaptor.addChild(root_0, STAR178_tree);
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
    // $ANTLR end "real_arg"


    public static class expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:345:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AliasMasker.expr_return expr() throws RecognitionException {
        AliasMasker.expr_return retval = new AliasMasker.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS179=null;
        CommonTree MINUS182=null;
        CommonTree STAR185=null;
        CommonTree DIV188=null;
        CommonTree PERCENT191=null;
        CommonTree CAST_EXPR194=null;
        CommonTree NEG199=null;
        CommonTree CAST_EXPR201=null;
        CommonTree EXPR_IN_PAREN204=null;
        AliasMasker.expr_return expr180 =null;

        AliasMasker.expr_return expr181 =null;

        AliasMasker.expr_return expr183 =null;

        AliasMasker.expr_return expr184 =null;

        AliasMasker.expr_return expr186 =null;

        AliasMasker.expr_return expr187 =null;

        AliasMasker.expr_return expr189 =null;

        AliasMasker.expr_return expr190 =null;

        AliasMasker.expr_return expr192 =null;

        AliasMasker.expr_return expr193 =null;

        AliasMasker.type_return type195 =null;

        AliasMasker.expr_return expr196 =null;

        AliasMasker.const_expr_return const_expr197 =null;

        AliasMasker.var_expr_return var_expr198 =null;

        AliasMasker.expr_return expr200 =null;

        AliasMasker.type_cast_return type_cast202 =null;

        AliasMasker.expr_return expr203 =null;

        AliasMasker.expr_return expr205 =null;


        CommonTree PLUS179_tree=null;
        CommonTree MINUS182_tree=null;
        CommonTree STAR185_tree=null;
        CommonTree DIV188_tree=null;
        CommonTree PERCENT191_tree=null;
        CommonTree CAST_EXPR194_tree=null;
        CommonTree NEG199_tree=null;
        CommonTree CAST_EXPR201_tree=null;
        CommonTree EXPR_IN_PAREN204_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:346:5: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt53=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt53=1;
                }
                break;
            case MINUS:
                {
                int LA53_2 = input.LA(2);

                if ( (synpred102_AliasMasker()) ) {
                    alt53=2;
                }
                else if ( (synpred107_AliasMasker()) ) {
                    alt53=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt53=3;
                }
                break;
            case DIV:
                {
                alt53=4;
                }
                break;
            case PERCENT:
                {
                alt53=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA53_6 = input.LA(2);

                if ( (synpred106_AliasMasker()) ) {
                    alt53=6;
                }
                else if ( (synpred110_AliasMasker()) ) {
                    alt53=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 6, input);

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
                alt53=7;
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
                alt53=8;
                }
                break;
            case NEG:
                {
                alt53=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt53=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }

            switch (alt53) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:346:7: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS179=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1701); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS179_tree = (CommonTree)adaptor.dupNode(PLUS179);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS179_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1703);
                    expr180=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr180.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1705);
                    expr181=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr181.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:347:7: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS182=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1717); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS182_tree = (CommonTree)adaptor.dupNode(MINUS182);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS182_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1719);
                    expr183=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr183.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1721);
                    expr184=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr184.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:348:7: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR185=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr1733); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR185_tree = (CommonTree)adaptor.dupNode(STAR185);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR185_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1735);
                    expr186=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr186.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1737);
                    expr187=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr187.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:349:7: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV188=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1749); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV188_tree = (CommonTree)adaptor.dupNode(DIV188);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV188_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1751);
                    expr189=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr189.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1753);
                    expr190=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr190.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:350:7: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT191=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr1765); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT191_tree = (CommonTree)adaptor.dupNode(PERCENT191);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT191_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1767);
                    expr192=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr192.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1769);
                    expr193=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr193.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:351:7: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR194=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1781); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR194_tree = (CommonTree)adaptor.dupNode(CAST_EXPR194);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR194_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr1783);
                    type195=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type195.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1785);
                    expr196=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr196.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:352:7: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr1795);
                    const_expr197=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr197.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:353:7: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr1803);
                    var_expr198=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr198.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:354:7: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG199=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr1813); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG199_tree = (CommonTree)adaptor.dupNode(NEG199);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG199_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1815);
                    expr200=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr200.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:355:7: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR201=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1827); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR201_tree = (CommonTree)adaptor.dupNode(CAST_EXPR201);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR201_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr1829);
                    type_cast202=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast202.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1831);
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
                case 11 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:356:7: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN204=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr1843); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN204_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN204);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN204_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1845);
                    expr205=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr205.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:359:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AliasMasker.type_cast_return type_cast() throws RecognitionException {
        AliasMasker.type_cast_return retval = new AliasMasker.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.simple_type_return simple_type206 =null;

        AliasMasker.map_type_return map_type207 =null;

        AliasMasker.tuple_type_cast_return tuple_type_cast208 =null;

        AliasMasker.bag_type_cast_return bag_type_cast209 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:360:5: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt54=4;
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
                alt54=1;
                }
                break;
            case MAP_TYPE:
                {
                alt54=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt54=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt54=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }

            switch (alt54) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:360:7: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast1860);
                    simple_type206=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type206.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:360:21: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast1864);
                    map_type207=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type207.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:360:32: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast1868);
                    tuple_type_cast208=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast208.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:360:50: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast1872);
                    bag_type_cast209=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast209.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:363:1: tuple_type_cast : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final AliasMasker.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AliasMasker.tuple_type_cast_return retval = new AliasMasker.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST210=null;
        AliasMasker.type_cast_return type_cast211 =null;


        CommonTree TUPLE_TYPE_CAST210_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:364:5: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:364:7: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST210=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1887); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST210_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST210);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST210_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:364:26: ( type_cast )*
                loop55:
                do {
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==BIGDECIMAL||LA55_0==BIGINTEGER||LA55_0==BOOLEAN||LA55_0==BYTEARRAY||LA55_0==CHARARRAY||LA55_0==DATETIME||LA55_0==DOUBLE||LA55_0==FLOAT||LA55_0==INT||LA55_0==LONG||LA55_0==BAG_TYPE_CAST||LA55_0==MAP_TYPE||LA55_0==TUPLE_TYPE_CAST) ) {
                        alt55=1;
                    }


                    switch (alt55) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:364:26: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast1889);
                	    type_cast211=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast211.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop55;
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
    // $ANTLR end "tuple_type_cast"


    public static class bag_type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:367:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AliasMasker.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AliasMasker.bag_type_cast_return retval = new AliasMasker.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST212=null;
        AliasMasker.tuple_type_cast_return tuple_type_cast213 =null;


        CommonTree BAG_TYPE_CAST212_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:368:5: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:368:7: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST212=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1907); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST212_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST212);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST212_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:368:24: ( tuple_type_cast )?
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==TUPLE_TYPE_CAST) ) {
                    alt56=1;
                }
                switch (alt56) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:368:24: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast1909);
                        tuple_type_cast213=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast213.getTree());


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
    // $ANTLR end "bag_type_cast"


    public static class var_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:371:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AliasMasker.var_expr_return var_expr() throws RecognitionException {
        AliasMasker.var_expr_return retval = new AliasMasker.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.projectable_expr_return projectable_expr214 =null;

        AliasMasker.dot_proj_return dot_proj215 =null;

        AliasMasker.pound_proj_return pound_proj216 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:372:5: ( projectable_expr ( dot_proj | pound_proj )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:372:7: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr1925);
            projectable_expr214=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr214.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:372:24: ( dot_proj | pound_proj )*
            loop57:
            do {
                int alt57=3;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==PERIOD) ) {
                    alt57=1;
                }
                else if ( (LA57_0==POUND) ) {
                    alt57=2;
                }


                switch (alt57) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:372:26: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr1929);
            	    dot_proj215=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj215.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:372:37: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr1933);
            	    pound_proj216=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj216.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop57;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:375:1: projectable_expr : ( func_eval | col_ref | bin_expr | case_expr | case_cond );
    public final AliasMasker.projectable_expr_return projectable_expr() throws RecognitionException {
        AliasMasker.projectable_expr_return retval = new AliasMasker.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.func_eval_return func_eval217 =null;

        AliasMasker.col_ref_return col_ref218 =null;

        AliasMasker.bin_expr_return bin_expr219 =null;

        AliasMasker.case_expr_return case_expr220 =null;

        AliasMasker.case_cond_return case_cond221 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:376:5: ( func_eval | col_ref | bin_expr | case_expr | case_cond )
            int alt58=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
                {
                alt58=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt58=2;
                }
                break;
            case BIN_EXPR:
                {
                alt58=3;
                }
                break;
            case CASE_EXPR:
                {
                alt58=4;
                }
                break;
            case CASE_COND:
                {
                alt58=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }

            switch (alt58) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:376:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr1949);
                    func_eval217=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval217.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:376:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr1953);
                    col_ref218=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref218.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:376:29: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr1957);
                    bin_expr219=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr219.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:376:40: case_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr1961);
                    case_expr220=case_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr220.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:376:52: case_cond
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr1965);
                    case_cond221=case_cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond221.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:379:1: dot_proj : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final AliasMasker.dot_proj_return dot_proj() throws RecognitionException {
        AliasMasker.dot_proj_return retval = new AliasMasker.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD222=null;
        AliasMasker.col_alias_or_index_return col_alias_or_index223 =null;


        CommonTree PERIOD222_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:380:5: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:380:7: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD222=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj1980); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD222_tree = (CommonTree)adaptor.dupNode(PERIOD222);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD222_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:380:17: ( col_alias_or_index )+
            int cnt59=0;
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==CUBE||LA59_0==DOLLARVAR||LA59_0==GROUP||LA59_0==IDENTIFIER) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:380:17: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj1982);
            	    col_alias_or_index223=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index223.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt59 >= 1 ) break loop59;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(59, input);
                        throw eee;
                }
                cnt59++;
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
    // $ANTLR end "dot_proj"


    public static class col_alias_or_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:383:1: col_alias_or_index : ( col_alias | col_index );
    public final AliasMasker.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AliasMasker.col_alias_or_index_return retval = new AliasMasker.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.col_alias_return col_alias224 =null;

        AliasMasker.col_index_return col_index225 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:383:20: ( col_alias | col_index )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==CUBE||LA60_0==GROUP||LA60_0==IDENTIFIER) ) {
                alt60=1;
            }
            else if ( (LA60_0==DOLLARVAR) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }
            switch (alt60) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:383:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index1994);
                    col_alias224=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias224.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:383:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index1998);
                    col_index225=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index225.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:386:1: col_alias : ( GROUP | CUBE | IDENTIFIER );
    public final AliasMasker.col_alias_return col_alias() throws RecognitionException {
        AliasMasker.col_alias_return retval = new AliasMasker.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set226=null;

        CommonTree set226_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:387:5: ( GROUP | CUBE | IDENTIFIER )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set226=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set226_tree = (CommonTree)adaptor.dupNode(set226);


                adaptor.addChild(root_0, set226_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:392:1: col_index : DOLLARVAR ;
    public final AliasMasker.col_index_return col_index() throws RecognitionException {
        AliasMasker.col_index_return retval = new AliasMasker.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR227=null;

        CommonTree DOLLARVAR227_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:393:5: ( DOLLARVAR )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:393:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR227=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index2040); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR227_tree = (CommonTree)adaptor.dupNode(DOLLARVAR227);


            adaptor.addChild(root_0, DOLLARVAR227_tree);
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
    // $ANTLR end "col_index"


    public static class col_range_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:396:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AliasMasker.col_range_return col_range() throws RecognitionException {
        AliasMasker.col_range_return retval = new AliasMasker.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE228=null;
        CommonTree DOUBLE_PERIOD230=null;
        AliasMasker.col_ref_return col_ref229 =null;

        AliasMasker.col_ref_return col_ref231 =null;


        CommonTree COL_RANGE228_tree=null;
        CommonTree DOUBLE_PERIOD230_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:396:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:396:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE228=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range2051); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE228_tree = (CommonTree)adaptor.dupNode(COL_RANGE228);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE228_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:396:26: ( col_ref )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==CUBE||LA61_0==DOLLARVAR||LA61_0==GROUP||LA61_0==IDENTIFIER) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:396:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2053);
                    col_ref229=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref229.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD230=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range2056); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD230_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD230);


            adaptor.addChild(root_1, DOUBLE_PERIOD230_tree);
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:396:49: ( col_ref )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==CUBE||LA62_0==DOLLARVAR||LA62_0==GROUP||LA62_0==IDENTIFIER) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:396:49: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2058);
                    col_ref231=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref231.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:399:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AliasMasker.pound_proj_return pound_proj() throws RecognitionException {
        AliasMasker.pound_proj_return retval = new AliasMasker.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND232=null;
        CommonTree set233=null;

        CommonTree POUND232_tree=null;
        CommonTree set233_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:400:5: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:400:7: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND232=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj2075); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND232_tree = (CommonTree)adaptor.dupNode(POUND232);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND232_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            set233=(CommonTree)input.LT(1);

            if ( input.LA(1)==NULL||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set233_tree = (CommonTree)adaptor.dupNode(set233);


                adaptor.addChild(root_1, set233_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:403:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AliasMasker.bin_expr_return bin_expr() throws RecognitionException {
        AliasMasker.bin_expr_return retval = new AliasMasker.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR234=null;
        AliasMasker.cond_return cond235 =null;

        AliasMasker.expr_return expr236 =null;

        AliasMasker.expr_return expr237 =null;


        CommonTree BIN_EXPR234_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:404:5: ( ^( BIN_EXPR cond expr expr ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:404:7: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR234=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr2102); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR234_tree = (CommonTree)adaptor.dupNode(BIN_EXPR234);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR234_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2104);
            cond235=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond235.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2106);
            expr236=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr236.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2108);
            expr237=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr237.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:407:1: case_expr : ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ ) ;
    public final AliasMasker.case_expr_return case_expr() throws RecognitionException {
        AliasMasker.case_expr_return retval = new AliasMasker.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR238=null;
        CommonTree CASE_EXPR_LHS239=null;
        CommonTree CASE_EXPR_RHS241=null;
        AliasMasker.expr_return expr240 =null;

        AliasMasker.expr_return expr242 =null;


        CommonTree CASE_EXPR238_tree=null;
        CommonTree CASE_EXPR_LHS239_tree=null;
        CommonTree CASE_EXPR_RHS241_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:408:5: ( ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:408:7: ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR238=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr2125); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR238_tree = (CommonTree)adaptor.dupNode(CASE_EXPR238);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR238_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:408:20: ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==CASE_EXPR_LHS) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:408:22: ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_LHS239=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr2131); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_LHS239_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS239);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS239_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr2133);
            	    expr240=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr240.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:408:46: ( ^( CASE_EXPR_RHS expr ) )+
            	    int cnt63=0;
            	    loop63:
            	    do {
            	        int alt63=2;
            	        int LA63_0 = input.LA(1);

            	        if ( (LA63_0==CASE_EXPR_RHS) ) {
            	            alt63=1;
            	        }


            	        switch (alt63) {
            	    	case 1 :
            	    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:408:48: ^( CASE_EXPR_RHS expr )
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    {
            	    	    CommonTree _save_last_2 = _last;
            	    	    CommonTree _first_2 = null;
            	    	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    	    _last = (CommonTree)input.LT(1);
            	    	    CASE_EXPR_RHS241=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr2141); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    CASE_EXPR_RHS241_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS241);


            	    	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS241_tree, root_2);
            	    	    }


            	    	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    	    _last = (CommonTree)input.LT(1);
            	    	    pushFollow(FOLLOW_expr_in_case_expr2143);
            	    	    expr242=expr();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) 
            	    	    adaptor.addChild(root_2, expr242.getTree());


            	    	    match(input, Token.UP, null); if (state.failed) return retval;
            	    	    adaptor.addChild(root_1, root_2);
            	    	    _last = _save_last_2;
            	    	    }


            	    	    if ( state.backtracking==0 ) {
            	    	    }
            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt63 >= 1 ) break loop63;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(63, input);
            	                throw eee;
            	        }
            	        cnt63++;
            	    } while (true);


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
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
    // $ANTLR end "case_expr"


    public static class case_cond_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_cond"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:411:1: case_cond : ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ;
    public final AliasMasker.case_cond_return case_cond() throws RecognitionException {
        AliasMasker.case_cond_return retval = new AliasMasker.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND243=null;
        CommonTree WHEN244=null;
        CommonTree THEN246=null;
        AliasMasker.cond_return cond245 =null;

        AliasMasker.expr_return expr247 =null;


        CommonTree CASE_COND243_tree=null;
        CommonTree WHEN244_tree=null;
        CommonTree THEN246_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:412:5: ( ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:412:7: ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND243=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond2167); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND243_tree = (CommonTree)adaptor.dupNode(CASE_COND243);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND243_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN244=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond2171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN244_tree = (CommonTree)adaptor.dupNode(WHEN244);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN244_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:412:28: ( cond )+
            int cnt65=0;
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==AND||LA65_0==IN||(LA65_0 >= NOT && LA65_0 <= NUM_OP_NE)||LA65_0==OR||(LA65_0 >= STR_OP_EQ && LA65_0 <= STR_OP_NE)||LA65_0==BOOL_COND||LA65_0==FUNC_EVAL) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:412:28: cond
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond2173);
            	    cond245=cond();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond245.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt65 >= 1 ) break loop65;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(65, input);
                        throw eee;
                }
                cnt65++;
            } while (true);


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
            THEN246=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond2180); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN246_tree = (CommonTree)adaptor.dupNode(THEN246);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN246_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:412:44: ( expr )+
            int cnt66=0;
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==BIGDECIMALNUMBER||LA66_0==BIGINTEGERNUMBER||LA66_0==CUBE||LA66_0==DIV||LA66_0==DOLLARVAR||LA66_0==DOUBLENUMBER||LA66_0==FALSE||LA66_0==FLOATNUMBER||LA66_0==GROUP||LA66_0==IDENTIFIER||LA66_0==INTEGER||LA66_0==LONGINTEGER||LA66_0==MINUS||LA66_0==NULL||LA66_0==PERCENT||LA66_0==PLUS||LA66_0==QUOTEDSTRING||LA66_0==STAR||LA66_0==TRUE||(LA66_0 >= BAG_VAL && LA66_0 <= BIN_EXPR)||(LA66_0 >= CASE_COND && LA66_0 <= CASE_EXPR)||LA66_0==CAST_EXPR||LA66_0==EXPR_IN_PAREN||LA66_0==FUNC_EVAL||(LA66_0 >= MAP_VAL && LA66_0 <= NEG)||LA66_0==TUPLE_VAL) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:412:44: expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond2182);
            	    expr247=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr247.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt66 >= 1 ) break loop66;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(66, input);
                        throw eee;
                }
                cnt66++;
            } while (true);


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:415:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AliasMasker.limit_clause_return limit_clause() throws RecognitionException {
        AliasMasker.limit_clause_return retval = new AliasMasker.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT248=null;
        CommonTree INTEGER250=null;
        CommonTree LONGINTEGER251=null;
        AliasMasker.rel_return rel249 =null;

        AliasMasker.expr_return expr252 =null;


        CommonTree LIMIT248_tree=null;
        CommonTree INTEGER250_tree=null;
        CommonTree LONGINTEGER251_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:416:5: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:416:7: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT248=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2202); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT248_tree = (CommonTree)adaptor.dupNode(LIMIT248);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT248_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause2204);
            rel249=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel249.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:416:20: ( INTEGER | LONGINTEGER | expr )
            int alt67=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA67_1 = input.LA(2);

                if ( (synpred133_AliasMasker()) ) {
                    alt67=1;
                }
                else if ( (true) ) {
                    alt67=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA67_2 = input.LA(2);

                if ( (synpred134_AliasMasker()) ) {
                    alt67=2;
                }
                else if ( (true) ) {
                    alt67=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 2, input);

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
                alt67=3;
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:416:22: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER250=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause2208); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER250_tree = (CommonTree)adaptor.dupNode(INTEGER250);


                    adaptor.addChild(root_1, INTEGER250_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:416:32: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER251=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause2212); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER251_tree = (CommonTree)adaptor.dupNode(LONGINTEGER251);


                    adaptor.addChild(root_1, LONGINTEGER251_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:416:46: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause2216);
                    expr252=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr252.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:419:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AliasMasker.sample_clause_return sample_clause() throws RecognitionException {
        AliasMasker.sample_clause_return retval = new AliasMasker.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE253=null;
        CommonTree DOUBLENUMBER255=null;
        AliasMasker.rel_return rel254 =null;

        AliasMasker.expr_return expr256 =null;


        CommonTree SAMPLE253_tree=null;
        CommonTree DOUBLENUMBER255_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:420:5: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:420:8: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE253=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause2236); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE253_tree = (CommonTree)adaptor.dupNode(SAMPLE253);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE253_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause2238);
            rel254=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel254.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:420:22: ( DOUBLENUMBER | expr )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==DOUBLENUMBER) ) {
                int LA68_1 = input.LA(2);

                if ( (synpred135_AliasMasker()) ) {
                    alt68=1;
                }
                else if ( (true) ) {
                    alt68=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA68_0==BIGDECIMALNUMBER||LA68_0==BIGINTEGERNUMBER||LA68_0==CUBE||LA68_0==DIV||LA68_0==DOLLARVAR||LA68_0==FALSE||LA68_0==FLOATNUMBER||LA68_0==GROUP||LA68_0==IDENTIFIER||LA68_0==INTEGER||LA68_0==LONGINTEGER||LA68_0==MINUS||LA68_0==NULL||LA68_0==PERCENT||LA68_0==PLUS||LA68_0==QUOTEDSTRING||LA68_0==STAR||LA68_0==TRUE||(LA68_0 >= BAG_VAL && LA68_0 <= BIN_EXPR)||(LA68_0 >= CASE_COND && LA68_0 <= CASE_EXPR)||LA68_0==CAST_EXPR||LA68_0==EXPR_IN_PAREN||LA68_0==FUNC_EVAL||(LA68_0 >= MAP_VAL && LA68_0 <= NEG)||LA68_0==TUPLE_VAL) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;

            }
            switch (alt68) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:420:24: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER255=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause2242); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER255_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER255);


                    adaptor.addChild(root_1, DOUBLENUMBER255_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:420:39: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause2246);
                    expr256=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr256.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:423:1: rank_clause : ^( RANK rel ( rank_by_statement )? ) ;
    public final AliasMasker.rank_clause_return rank_clause() throws RecognitionException {
        AliasMasker.rank_clause_return retval = new AliasMasker.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK257=null;
        AliasMasker.rel_return rel258 =null;

        AliasMasker.rank_by_statement_return rank_by_statement259 =null;


        CommonTree RANK257_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:424:2: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:424:4: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK257=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause2262); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK257_tree = (CommonTree)adaptor.dupNode(RANK257);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK257_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause2264);
            rel258=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel258.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:424:16: ( rank_by_statement )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==BY) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:424:18: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause2268);
                    rank_by_statement259=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement259.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:427:1: rank_by_statement : ^( BY rank_by_clause ( DENSE )? ) ;
    public final AliasMasker.rank_by_statement_return rank_by_statement() throws RecognitionException {
        AliasMasker.rank_by_statement_return retval = new AliasMasker.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY260=null;
        CommonTree DENSE262=null;
        AliasMasker.rank_by_clause_return rank_by_clause261 =null;


        CommonTree BY260_tree=null;
        CommonTree DENSE262_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:428:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:428:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY260=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement2285); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY260_tree = (CommonTree)adaptor.dupNode(BY260);


            root_1 = (CommonTree)adaptor.becomeRoot(BY260_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement2287);
            rank_by_clause261=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause261.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:428:25: ( DENSE )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==DENSE) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:428:27: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE262=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement2291); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE262_tree = (CommonTree)adaptor.dupNode(DENSE262);


                    adaptor.addChild(root_1, DENSE262_tree);
                    }


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:431:1: rank_by_clause : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final AliasMasker.rank_by_clause_return rank_by_clause() throws RecognitionException {
        AliasMasker.rank_by_clause_return retval = new AliasMasker.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR263=null;
        CommonTree set264=null;
        AliasMasker.rank_col_return rank_col265 =null;


        CommonTree STAR263_tree=null;
        CommonTree set264_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:432:2: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==STAR) ) {
                alt73=1;
            }
            else if ( (LA73_0==CUBE||LA73_0==DOLLARVAR||LA73_0==GROUP||LA73_0==IDENTIFIER||LA73_0==COL_RANGE) ) {
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:432:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR263=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause2306); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR263_tree = (CommonTree)adaptor.dupNode(STAR263);


                    adaptor.addChild(root_0, STAR263_tree);
                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:432:9: ( ASC | DESC )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==ASC||LA71_0==DESC) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set264=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set264_tree = (CommonTree)adaptor.dupNode(set264);


                                adaptor.addChild(root_0, set264_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:433:7: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:433:7: ( rank_col )+
                    int cnt72=0;
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==CUBE||LA72_0==DOLLARVAR||LA72_0==GROUP||LA72_0==IDENTIFIER||LA72_0==COL_RANGE) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:433:7: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause2325);
                    	    rank_col265=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col265.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt72 >= 1 ) break loop72;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(72, input);
                                throw eee;
                        }
                        cnt72++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:436:1: rank_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AliasMasker.rank_col_return rank_col() throws RecognitionException {
        AliasMasker.rank_col_return retval = new AliasMasker.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set268=null;
        AliasMasker.col_range_return col_range266 =null;

        AliasMasker.col_ref_return col_ref267 =null;


        CommonTree set268_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:437:2: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:437:4: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:437:4: ( col_range | col_ref )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==COL_RANGE) ) {
                alt74=1;
            }
            else if ( (LA74_0==CUBE||LA74_0==DOLLARVAR||LA74_0==GROUP||LA74_0==IDENTIFIER) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;

            }
            switch (alt74) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:437:6: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col2338);
                    col_range266=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range266.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:437:18: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col2342);
                    col_ref267=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref267.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:437:28: ( ASC | DESC )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==ASC||LA75_0==DESC) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set268=(CommonTree)input.LT(1);

                    if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set268_tree = (CommonTree)adaptor.dupNode(set268);


                        adaptor.addChild(root_0, set268_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:440:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AliasMasker.order_clause_return order_clause() throws RecognitionException {
        AliasMasker.order_clause_return retval = new AliasMasker.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER269=null;
        AliasMasker.rel_return rel270 =null;

        AliasMasker.order_by_clause_return order_by_clause271 =null;

        AliasMasker.func_clause_return func_clause272 =null;


        CommonTree ORDER269_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:441:5: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:441:7: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER269=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause2370); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER269_tree = (CommonTree)adaptor.dupNode(ORDER269);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER269_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause2372);
            rel270=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel270.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause2374);
            order_by_clause271=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause271.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:441:36: ( func_clause )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==FUNC||LA76_0==FUNC_REF) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:441:36: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause2376);
                    func_clause272=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause272.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:444:1: order_by_clause : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final AliasMasker.order_by_clause_return order_by_clause() throws RecognitionException {
        AliasMasker.order_by_clause_return retval = new AliasMasker.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR273=null;
        CommonTree set274=null;
        AliasMasker.order_col_return order_col275 =null;


        CommonTree STAR273_tree=null;
        CommonTree set274_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:445:5: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==STAR) ) {
                alt79=1;
            }
            else if ( (LA79_0==CUBE||LA79_0==DOLLARVAR||LA79_0==GROUP||LA79_0==IDENTIFIER||LA79_0==COL_RANGE) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }
            switch (alt79) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:445:7: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR273=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause2392); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR273_tree = (CommonTree)adaptor.dupNode(STAR273);


                    adaptor.addChild(root_0, STAR273_tree);
                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:445:12: ( ASC | DESC )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==ASC||LA77_0==DESC) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set274=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set274_tree = (CommonTree)adaptor.dupNode(set274);


                                adaptor.addChild(root_0, set274_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:446:7: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:446:7: ( order_col )+
                    int cnt78=0;
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==CUBE||LA78_0==DOLLARVAR||LA78_0==GROUP||LA78_0==IDENTIFIER||LA78_0==COL_RANGE) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:446:7: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause2411);
                    	    order_col275=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col275.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt78 >= 1 ) break loop78;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(78, input);
                                throw eee;
                        }
                        cnt78++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:449:1: order_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AliasMasker.order_col_return order_col() throws RecognitionException {
        AliasMasker.order_col_return retval = new AliasMasker.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set278=null;
        AliasMasker.col_range_return col_range276 =null;

        AliasMasker.col_ref_return col_ref277 =null;


        CommonTree set278_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:450:5: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:450:7: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:450:7: ( col_range | col_ref )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==COL_RANGE) ) {
                alt80=1;
            }
            else if ( (LA80_0==CUBE||LA80_0==DOLLARVAR||LA80_0==GROUP||LA80_0==IDENTIFIER) ) {
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:450:8: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col2426);
                    col_range276=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range276.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:450:20: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col2430);
                    col_ref277=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref277.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:450:29: ( ASC | DESC )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==ASC||LA81_0==DESC) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set278=(CommonTree)input.LT(1);

                    if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set278_tree = (CommonTree)adaptor.dupNode(set278);


                        adaptor.addChild(root_0, set278_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:453:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AliasMasker.distinct_clause_return distinct_clause() throws RecognitionException {
        AliasMasker.distinct_clause_return retval = new AliasMasker.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT279=null;
        AliasMasker.rel_return rel280 =null;

        AliasMasker.partition_clause_return partition_clause281 =null;


        CommonTree DISTINCT279_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:454:5: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:454:7: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT279=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause2457); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT279_tree = (CommonTree)adaptor.dupNode(DISTINCT279);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT279_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause2459);
            rel280=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel280.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:454:23: ( partition_clause )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==PARTITION) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:454:23: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause2461);
                    partition_clause281=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause281.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:457:1: partition_clause : ^( PARTITION func_name ) ;
    public final AliasMasker.partition_clause_return partition_clause() throws RecognitionException {
        AliasMasker.partition_clause_return retval = new AliasMasker.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION282=null;
        AliasMasker.func_name_return func_name283 =null;


        CommonTree PARTITION282_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:458:5: ( ^( PARTITION func_name ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:458:7: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION282=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause2479); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION282_tree = (CommonTree)adaptor.dupNode(PARTITION282);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION282_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause2481);
            func_name283=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name283.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:461:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AliasMasker.cross_clause_return cross_clause() throws RecognitionException {
        AliasMasker.cross_clause_return retval = new AliasMasker.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS284=null;
        AliasMasker.rel_list_return rel_list285 =null;

        AliasMasker.partition_clause_return partition_clause286 =null;


        CommonTree CROSS284_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:462:5: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:462:7: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS284=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause2498); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS284_tree = (CommonTree)adaptor.dupNode(CROSS284);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS284_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause2500);
            rel_list285=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list285.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:462:25: ( partition_clause )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==PARTITION) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:462:25: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause2502);
                    partition_clause286=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause286.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:465:1: rel_list : ( rel )+ ;
    public final AliasMasker.rel_list_return rel_list() throws RecognitionException {
        AliasMasker.rel_list_return retval = new AliasMasker.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.rel_return rel287 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:466:5: ( ( rel )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:466:7: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:466:7: ( rel )+
            int cnt84=0;
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==ASSERT||LA84_0==COGROUP||(LA84_0 >= CROSS && LA84_0 <= CUBE)||LA84_0==DEFINE||LA84_0==DISTINCT||LA84_0==FILTER||LA84_0==FOREACH||LA84_0==GROUP||LA84_0==IDENTIFIER||LA84_0==JOIN||(LA84_0 >= LIMIT && LA84_0 <= LOAD)||LA84_0==MAPREDUCE||LA84_0==ORDER||LA84_0==RANK||LA84_0==SAMPLE||LA84_0==SPLIT||(LA84_0 >= STORE && LA84_0 <= STREAM)||LA84_0==UNION) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:466:7: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list2518);
            	    rel287=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel287.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt84 >= 1 ) break loop84;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(84, input);
                        throw eee;
                }
                cnt84++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:469:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AliasMasker.join_clause_return join_clause() throws RecognitionException {
        AliasMasker.join_clause_return retval = new AliasMasker.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN288=null;
        AliasMasker.join_sub_clause_return join_sub_clause289 =null;

        AliasMasker.join_type_return join_type290 =null;

        AliasMasker.partition_clause_return partition_clause291 =null;


        CommonTree JOIN288_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:470:5: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:470:7: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN288=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause2534); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN288_tree = (CommonTree)adaptor.dupNode(JOIN288);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN288_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause2536);
            join_sub_clause289=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause289.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:470:31: ( join_type )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==QUOTEDSTRING) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:470:31: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause2538);
                    join_type290=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type290.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:470:42: ( partition_clause )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==PARTITION) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:470:42: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause2541);
                    partition_clause291=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause291.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:473:1: join_type : QUOTEDSTRING ;
    public final AliasMasker.join_type_return join_type() throws RecognitionException {
        AliasMasker.join_type_return retval = new AliasMasker.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING292=null;

        CommonTree QUOTEDSTRING292_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:473:11: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:473:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING292=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type2553); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING292_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING292);


            adaptor.addChild(root_0, QUOTEDSTRING292_tree);
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
    // $ANTLR end "join_type"


    public static class join_sub_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_sub_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:476:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final AliasMasker.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AliasMasker.join_sub_clause_return retval = new AliasMasker.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set294=null;
        CommonTree OUTER295=null;
        AliasMasker.join_item_return join_item293 =null;

        AliasMasker.join_item_return join_item296 =null;

        AliasMasker.join_item_return join_item297 =null;


        CommonTree set294_tree=null;
        CommonTree OUTER295_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:477:5: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==JOIN_ITEM) ) {
                int LA89_1 = input.LA(2);

                if ( (synpred161_AliasMasker()) ) {
                    alt89=1;
                }
                else if ( (true) ) {
                    alt89=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;

            }
            switch (alt89) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:477:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2566);
                    join_item293=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item293.getTree());


                    _last = (CommonTree)input.LT(1);
                    set294=(CommonTree)input.LT(1);

                    if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set294_tree = (CommonTree)adaptor.dupNode(set294);


                        adaptor.addChild(root_0, set294_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:480:16: ( OUTER )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==OUTER) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:480:16: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER295=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause2621); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER295_tree = (CommonTree)adaptor.dupNode(OUTER295);


                            adaptor.addChild(root_0, OUTER295_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2624);
                    join_item296=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item296.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:481:7: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:481:7: ( join_item )+
                    int cnt88=0;
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==JOIN_ITEM) ) {
                            alt88=1;
                        }


                        switch (alt88) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:481:7: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause2632);
                    	    join_item297=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item297.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt88 >= 1 ) break loop88;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(88, input);
                                throw eee;
                        }
                        cnt88++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:484:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AliasMasker.join_item_return join_item() throws RecognitionException {
        AliasMasker.join_item_return retval = new AliasMasker.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM298=null;
        AliasMasker.rel_return rel299 =null;

        AliasMasker.join_group_by_clause_return join_group_by_clause300 =null;


        CommonTree JOIN_ITEM298_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:485:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:485:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM298=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item2645); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM298_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM298);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM298_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item2647);
            rel299=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel299.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item2649);
            join_group_by_clause300=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause300.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:488:1: join_group_by_clause : ^( BY ( join_group_by_expr )+ ) ;
    public final AliasMasker.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AliasMasker.join_group_by_clause_return retval = new AliasMasker.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY301=null;
        AliasMasker.join_group_by_expr_return join_group_by_expr302 =null;


        CommonTree BY301_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:489:5: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:489:7: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY301=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause2666); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY301_tree = (CommonTree)adaptor.dupNode(BY301);


            root_1 = (CommonTree)adaptor.becomeRoot(BY301_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:489:13: ( join_group_by_expr )+
            int cnt90=0;
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==BIGDECIMALNUMBER||LA90_0==BIGINTEGERNUMBER||LA90_0==CUBE||LA90_0==DIV||LA90_0==DOLLARVAR||LA90_0==DOUBLENUMBER||LA90_0==FALSE||LA90_0==FLOATNUMBER||LA90_0==GROUP||LA90_0==IDENTIFIER||LA90_0==INTEGER||LA90_0==LONGINTEGER||LA90_0==MINUS||LA90_0==NULL||LA90_0==PERCENT||LA90_0==PLUS||LA90_0==QUOTEDSTRING||LA90_0==STAR||LA90_0==TRUE||(LA90_0 >= BAG_VAL && LA90_0 <= BIN_EXPR)||(LA90_0 >= CASE_COND && LA90_0 <= CASE_EXPR)||(LA90_0 >= CAST_EXPR && LA90_0 <= EXPR_IN_PAREN)||LA90_0==FUNC_EVAL||(LA90_0 >= MAP_VAL && LA90_0 <= NEG)||LA90_0==TUPLE_VAL) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:489:13: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2668);
            	    join_group_by_expr302=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr302.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt90 >= 1 ) break loop90;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(90, input);
                        throw eee;
                }
                cnt90++;
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
    // $ANTLR end "join_group_by_clause"


    public static class join_group_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:492:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AliasMasker.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AliasMasker.join_group_by_expr_return retval = new AliasMasker.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR305=null;
        AliasMasker.col_range_return col_range303 =null;

        AliasMasker.expr_return expr304 =null;


        CommonTree STAR305_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:493:5: ( col_range | expr | STAR )
            int alt91=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt91=1;
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
                alt91=2;
                }
                break;
            case STAR:
                {
                int LA91_3 = input.LA(2);

                if ( (LA91_3==DOWN) ) {
                    alt91=2;
                }
                else if ( (LA91_3==EOF||LA91_3==UP||LA91_3==BIGDECIMALNUMBER||LA91_3==BIGINTEGERNUMBER||LA91_3==CUBE||LA91_3==DIV||LA91_3==DOLLARVAR||LA91_3==DOUBLENUMBER||LA91_3==FALSE||LA91_3==FLOATNUMBER||LA91_3==GROUP||LA91_3==IDENTIFIER||LA91_3==INTEGER||LA91_3==LONGINTEGER||LA91_3==MINUS||LA91_3==NULL||LA91_3==PERCENT||LA91_3==PLUS||LA91_3==QUOTEDSTRING||LA91_3==STAR||LA91_3==TRUE||(LA91_3 >= BAG_VAL && LA91_3 <= BIN_EXPR)||(LA91_3 >= CASE_COND && LA91_3 <= CASE_EXPR)||(LA91_3 >= CAST_EXPR && LA91_3 <= EXPR_IN_PAREN)||LA91_3==FUNC_EVAL||(LA91_3 >= MAP_VAL && LA91_3 <= NEG)||LA91_3==TUPLE_VAL) ) {
                    alt91=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 91, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;

            }

            switch (alt91) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:493:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr2684);
                    col_range303=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range303.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:493:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr2688);
                    expr304=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr304.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:493:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR305=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr2692); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR305_tree = (CommonTree)adaptor.dupNode(STAR305);


                    adaptor.addChild(root_0, STAR305_tree);
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
    // $ANTLR end "join_group_by_expr"


    public static class union_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:496:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AliasMasker.union_clause_return union_clause() throws RecognitionException {
        AliasMasker.union_clause_return retval = new AliasMasker.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION306=null;
        CommonTree ONSCHEMA307=null;
        AliasMasker.rel_list_return rel_list308 =null;


        CommonTree UNION306_tree=null;
        CommonTree ONSCHEMA307_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:497:5: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:497:7: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION306=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause2707); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION306_tree = (CommonTree)adaptor.dupNode(UNION306);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION306_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:497:16: ( ONSCHEMA )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==ONSCHEMA) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:497:16: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA307=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause2709); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA307_tree = (CommonTree)adaptor.dupNode(ONSCHEMA307);


                    adaptor.addChild(root_1, ONSCHEMA307_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause2712);
            rel_list308=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list308.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:500:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AliasMasker.foreach_clause_return foreach_clause() throws RecognitionException {
        AliasMasker.foreach_clause_return retval = new AliasMasker.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH309=null;
        AliasMasker.rel_return rel310 =null;

        AliasMasker.foreach_plan_return foreach_plan311 =null;


        CommonTree FOREACH309_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:501:5: ( ^( FOREACH rel foreach_plan ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:501:7: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH309=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause2729); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH309_tree = (CommonTree)adaptor.dupNode(FOREACH309);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH309_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause2731);
            rel310=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel310.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause2733);
            foreach_plan311=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan311.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:504:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AliasMasker.foreach_plan_return foreach_plan() throws RecognitionException {
        AliasMasker.foreach_plan_return retval = new AliasMasker.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE312=null;
        CommonTree FOREACH_PLAN_COMPLEX314=null;
        AliasMasker.generate_clause_return generate_clause313 =null;

        AliasMasker.nested_blk_return nested_blk315 =null;


        CommonTree FOREACH_PLAN_SIMPLE312_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX314_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:505:5: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==FOREACH_PLAN_SIMPLE) ) {
                alt93=1;
            }
            else if ( (LA93_0==FOREACH_PLAN_COMPLEX) ) {
                alt93=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;

            }
            switch (alt93) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:505:7: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE312=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2750); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE312_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE312);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE312_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan2752);
                    generate_clause313=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause313.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:506:7: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX314=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2764); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX314_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX314);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX314_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan2766);
                    nested_blk315=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk315.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:509:1: nested_blk : ( nested_command )* generate_clause ;
    public final AliasMasker.nested_blk_return nested_blk() throws RecognitionException {
        AliasMasker.nested_blk_return retval = new AliasMasker.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_command_return nested_command316 =null;

        AliasMasker.generate_clause_return generate_clause317 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:510:5: ( ( nested_command )* generate_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:510:7: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:510:7: ( nested_command )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( ((LA94_0 >= NESTED_CMD && LA94_0 <= NESTED_CMD_ASSI)) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:510:7: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk2781);
            	    nested_command316=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command316.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk2784);
            generate_clause317=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause317.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:513:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final AliasMasker.generate_clause_return generate_clause() throws RecognitionException {
        AliasMasker.generate_clause_return retval = new AliasMasker.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE318=null;
        AliasMasker.flatten_generated_item_return flatten_generated_item319 =null;


        CommonTree GENERATE318_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:514:5: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:514:7: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE318=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause2799); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE318_tree = (CommonTree)adaptor.dupNode(GENERATE318);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE318_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:514:19: ( flatten_generated_item )+
            int cnt95=0;
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==BIGDECIMALNUMBER||LA95_0==BIGINTEGERNUMBER||LA95_0==CUBE||LA95_0==DIV||LA95_0==DOLLARVAR||LA95_0==DOUBLENUMBER||LA95_0==FALSE||LA95_0==FLATTEN||LA95_0==FLOATNUMBER||LA95_0==GROUP||LA95_0==IDENTIFIER||LA95_0==INTEGER||LA95_0==LONGINTEGER||LA95_0==MINUS||LA95_0==NULL||LA95_0==PERCENT||LA95_0==PLUS||LA95_0==QUOTEDSTRING||LA95_0==STAR||LA95_0==TRUE||(LA95_0 >= BAG_VAL && LA95_0 <= BIN_EXPR)||(LA95_0 >= CASE_COND && LA95_0 <= CASE_EXPR)||(LA95_0 >= CAST_EXPR && LA95_0 <= EXPR_IN_PAREN)||LA95_0==FUNC_EVAL||(LA95_0 >= MAP_VAL && LA95_0 <= NEG)||LA95_0==TUPLE_VAL) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:514:19: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause2801);
            	    flatten_generated_item319=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item319.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt95 >= 1 ) break loop95;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(95, input);
                        throw eee;
                }
                cnt95++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:517:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AliasMasker.nested_command_return nested_command() throws RecognitionException {
        AliasMasker.nested_command_return retval = new AliasMasker.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD320=null;
        CommonTree IDENTIFIER321=null;
        CommonTree NESTED_CMD_ASSI323=null;
        CommonTree IDENTIFIER324=null;
        AliasMasker.nested_op_return nested_op322 =null;

        AliasMasker.expr_return expr325 =null;


        CommonTree NESTED_CMD320_tree=null;
        CommonTree IDENTIFIER321_tree=null;
        CommonTree NESTED_CMD_ASSI323_tree=null;
        CommonTree IDENTIFIER324_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:518:5: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==NESTED_CMD) ) {
                alt96=1;
            }
            else if ( (LA96_0==NESTED_CMD_ASSI) ) {
                alt96=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;

            }
            switch (alt96) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:518:7: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD320=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command2819); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD320_tree = (CommonTree)adaptor.dupNode(NESTED_CMD320);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD320_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER321=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2821); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER321_tree = (CommonTree)adaptor.dupNode(IDENTIFIER321);


                    adaptor.addChild(root_1, IDENTIFIER321_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command2823);
                    nested_op322=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op322.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:519:7: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI323=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command2835); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI323_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI323);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI323_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER324=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2837); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER324_tree = (CommonTree)adaptor.dupNode(IDENTIFIER324);


                    adaptor.addChild(root_1, IDENTIFIER324_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command2839);
                    expr325=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr325.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:522:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AliasMasker.nested_op_return nested_op() throws RecognitionException {
        AliasMasker.nested_op_return retval = new AliasMasker.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_proj_return nested_proj326 =null;

        AliasMasker.nested_filter_return nested_filter327 =null;

        AliasMasker.nested_sort_return nested_sort328 =null;

        AliasMasker.nested_distinct_return nested_distinct329 =null;

        AliasMasker.nested_limit_return nested_limit330 =null;

        AliasMasker.nested_cross_return nested_cross331 =null;

        AliasMasker.nested_foreach_return nested_foreach332 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:522:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt97=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt97=1;
                }
                break;
            case FILTER:
                {
                alt97=2;
                }
                break;
            case ORDER:
                {
                alt97=3;
                }
                break;
            case DISTINCT:
                {
                alt97=4;
                }
                break;
            case LIMIT:
                {
                alt97=5;
                }
                break;
            case CROSS:
                {
                alt97=6;
                }
                break;
            case FOREACH:
                {
                alt97=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;

            }

            switch (alt97) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:522:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op2850);
                    nested_proj326=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj326.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:523:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op2864);
                    nested_filter327=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter327.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:524:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op2878);
                    nested_sort328=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort328.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:525:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op2892);
                    nested_distinct329=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct329.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:526:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op2906);
                    nested_limit330=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit330.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:527:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op2920);
                    nested_cross331=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross331.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:528:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op2934);
                    nested_foreach332=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach332.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:531:1: nested_proj : ^( NESTED_PROJ col_ref ( col_ref )+ ) ;
    public final AliasMasker.nested_proj_return nested_proj() throws RecognitionException {
        AliasMasker.nested_proj_return retval = new AliasMasker.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ333=null;
        AliasMasker.col_ref_return col_ref334 =null;

        AliasMasker.col_ref_return col_ref335 =null;


        CommonTree NESTED_PROJ333_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:532:5: ( ^( NESTED_PROJ col_ref ( col_ref )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:532:7: ^( NESTED_PROJ col_ref ( col_ref )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ333=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj2949); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ333_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ333);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ333_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj2951);
            col_ref334=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref334.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:532:30: ( col_ref )+
            int cnt98=0;
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==CUBE||LA98_0==DOLLARVAR||LA98_0==GROUP||LA98_0==IDENTIFIER) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:532:30: col_ref
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj2953);
            	    col_ref335=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref335.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt98 >= 1 ) break loop98;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(98, input);
                        throw eee;
                }
                cnt98++;
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
    // $ANTLR end "nested_proj"


    public static class nested_filter_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:535:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AliasMasker.nested_filter_return nested_filter() throws RecognitionException {
        AliasMasker.nested_filter_return retval = new AliasMasker.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER336=null;
        AliasMasker.nested_op_input_return nested_op_input337 =null;

        AliasMasker.cond_return cond338 =null;


        CommonTree FILTER336_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:536:5: ( ^( FILTER nested_op_input cond ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:536:7: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER336=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter2971); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER336_tree = (CommonTree)adaptor.dupNode(FILTER336);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER336_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter2973);
            nested_op_input337=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input337.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter2975);
            cond338=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond338.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:539:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AliasMasker.nested_sort_return nested_sort() throws RecognitionException {
        AliasMasker.nested_sort_return retval = new AliasMasker.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER339=null;
        AliasMasker.nested_op_input_return nested_op_input340 =null;

        AliasMasker.order_by_clause_return order_by_clause341 =null;

        AliasMasker.func_clause_return func_clause342 =null;


        CommonTree ORDER339_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:540:5: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:540:7: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER339=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort2992); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER339_tree = (CommonTree)adaptor.dupNode(ORDER339);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER339_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort2994);
            nested_op_input340=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input340.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort2996);
            order_by_clause341=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause341.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:540:48: ( func_clause )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==FUNC||LA99_0==FUNC_REF) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:540:48: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort2998);
                    func_clause342=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause342.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:543:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AliasMasker.nested_distinct_return nested_distinct() throws RecognitionException {
        AliasMasker.nested_distinct_return retval = new AliasMasker.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT343=null;
        AliasMasker.nested_op_input_return nested_op_input344 =null;


        CommonTree DISTINCT343_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:544:5: ( ^( DISTINCT nested_op_input ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:544:7: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT343=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct3016); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT343_tree = (CommonTree)adaptor.dupNode(DISTINCT343);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT343_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct3018);
            nested_op_input344=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input344.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:547:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AliasMasker.nested_limit_return nested_limit() throws RecognitionException {
        AliasMasker.nested_limit_return retval = new AliasMasker.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT345=null;
        CommonTree INTEGER347=null;
        AliasMasker.nested_op_input_return nested_op_input346 =null;

        AliasMasker.expr_return expr348 =null;


        CommonTree LIMIT345_tree=null;
        CommonTree INTEGER347_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:548:5: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:548:7: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT345=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit3035); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT345_tree = (CommonTree)adaptor.dupNode(LIMIT345);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT345_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit3037);
            nested_op_input346=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input346.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:548:32: ( INTEGER | expr )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==INTEGER) ) {
                int LA100_1 = input.LA(2);

                if ( (synpred179_AliasMasker()) ) {
                    alt100=1;
                }
                else if ( (true) ) {
                    alt100=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 100, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA100_0==BIGDECIMALNUMBER||LA100_0==BIGINTEGERNUMBER||LA100_0==CUBE||LA100_0==DIV||LA100_0==DOLLARVAR||LA100_0==DOUBLENUMBER||LA100_0==FALSE||LA100_0==FLOATNUMBER||LA100_0==GROUP||LA100_0==IDENTIFIER||LA100_0==LONGINTEGER||LA100_0==MINUS||LA100_0==NULL||LA100_0==PERCENT||LA100_0==PLUS||LA100_0==QUOTEDSTRING||LA100_0==STAR||LA100_0==TRUE||(LA100_0 >= BAG_VAL && LA100_0 <= BIN_EXPR)||(LA100_0 >= CASE_COND && LA100_0 <= CASE_EXPR)||LA100_0==CAST_EXPR||LA100_0==EXPR_IN_PAREN||LA100_0==FUNC_EVAL||(LA100_0 >= MAP_VAL && LA100_0 <= NEG)||LA100_0==TUPLE_VAL) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;

            }
            switch (alt100) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:548:34: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER347=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit3041); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER347_tree = (CommonTree)adaptor.dupNode(INTEGER347);


                    adaptor.addChild(root_1, INTEGER347_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:548:44: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit3045);
                    expr348=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr348.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:551:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AliasMasker.nested_cross_return nested_cross() throws RecognitionException {
        AliasMasker.nested_cross_return retval = new AliasMasker.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS349=null;
        AliasMasker.nested_op_input_list_return nested_op_input_list350 =null;


        CommonTree CROSS349_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:551:14: ( ^( CROSS nested_op_input_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:551:16: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS349=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross3060); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS349_tree = (CommonTree)adaptor.dupNode(CROSS349);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS349_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross3062);
            nested_op_input_list350=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list350.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:554:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AliasMasker.nested_foreach_return nested_foreach() throws RecognitionException {
        AliasMasker.nested_foreach_return retval = new AliasMasker.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH351=null;
        AliasMasker.nested_op_input_return nested_op_input352 =null;

        AliasMasker.generate_clause_return generate_clause353 =null;


        CommonTree FOREACH351_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:554:16: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:554:18: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH351=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach3075); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH351_tree = (CommonTree)adaptor.dupNode(FOREACH351);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH351_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach3077);
            nested_op_input352=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input352.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach3079);
            generate_clause353=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause353.getTree());


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


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:557:1: nested_op_input_list : ( nested_op_input )+ ;
    public final AliasMasker.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AliasMasker.nested_op_input_list_return retval = new AliasMasker.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_op_input_return nested_op_input354 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:557:22: ( ( nested_op_input )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:557:24: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:557:24: ( nested_op_input )+
            int cnt101=0;
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==CUBE||LA101_0==DOLLARVAR||LA101_0==GROUP||LA101_0==IDENTIFIER||LA101_0==NESTED_PROJ) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:557:24: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list3090);
            	    nested_op_input354=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input354.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt101 >= 1 ) break loop101;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(101, input);
                        throw eee;
                }
                cnt101++;
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


    public static class nested_op_input_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:560:1: nested_op_input : ( col_ref | nested_proj );
    public final AliasMasker.nested_op_input_return nested_op_input() throws RecognitionException {
        AliasMasker.nested_op_input_return retval = new AliasMasker.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.col_ref_return col_ref355 =null;

        AliasMasker.nested_proj_return nested_proj356 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:560:17: ( col_ref | nested_proj )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==CUBE||LA102_0==DOLLARVAR||LA102_0==GROUP||LA102_0==IDENTIFIER) ) {
                alt102=1;
            }
            else if ( (LA102_0==NESTED_PROJ) ) {
                alt102=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;

            }
            switch (alt102) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:560:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input3100);
                    col_ref355=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref355.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:560:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input3104);
                    nested_proj356=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj356.getTree());


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


    public static class stream_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:563:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AliasMasker.stream_clause_return stream_clause() throws RecognitionException {
        AliasMasker.stream_clause_return retval = new AliasMasker.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM357=null;
        CommonTree set359=null;
        AliasMasker.rel_return rel358 =null;

        AliasMasker.as_clause_return as_clause360 =null;


        CommonTree STREAM357_tree=null;
        CommonTree set359_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:564:5: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:564:7: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM357=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause3119); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM357_tree = (CommonTree)adaptor.dupNode(STREAM357);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM357_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause3121);
            rel358=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel358.getTree());


            _last = (CommonTree)input.LT(1);
            set359=(CommonTree)input.LT(1);

            if ( input.LA(1)==EXECCOMMAND||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set359_tree = (CommonTree)adaptor.dupNode(set359);


                adaptor.addChild(root_1, set359_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:564:50: ( as_clause )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==AS) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:564:50: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause3133);
                    as_clause360=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause360.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:567:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AliasMasker.mr_clause_return mr_clause() throws RecognitionException {
        AliasMasker.mr_clause_return retval = new AliasMasker.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE361=null;
        CommonTree QUOTEDSTRING362=null;
        CommonTree EXECCOMMAND366=null;
        AliasMasker.path_list_return path_list363 =null;

        AliasMasker.store_clause_return store_clause364 =null;

        AliasMasker.load_clause_return load_clause365 =null;


        CommonTree MAPREDUCE361_tree=null;
        CommonTree QUOTEDSTRING362_tree=null;
        CommonTree EXECCOMMAND366_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:568:5: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:568:7: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE361=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause3151); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE361_tree = (CommonTree)adaptor.dupNode(MAPREDUCE361);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE361_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING362=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause3153); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING362_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING362);


            adaptor.addChild(root_1, QUOTEDSTRING362_tree);
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:568:33: ( path_list )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==QUOTEDSTRING) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:568:33: path_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause3155);
                    path_list363=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list363.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause3158);
            store_clause364=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause364.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause3160);
            load_clause365=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause365.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:568:69: ( EXECCOMMAND )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==EXECCOMMAND) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:568:69: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND366=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause3162); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND366_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND366);


                    adaptor.addChild(root_1, EXECCOMMAND366_tree);
                    }


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:571:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final AliasMasker.split_clause_return split_clause() throws RecognitionException {
        AliasMasker.split_clause_return retval = new AliasMasker.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT367=null;
        AliasMasker.rel_return rel368 =null;

        AliasMasker.split_branch_return split_branch369 =null;

        AliasMasker.split_otherwise_return split_otherwise370 =null;


        CommonTree SPLIT367_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:572:5: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:572:7: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT367=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause3180); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT367_tree = (CommonTree)adaptor.dupNode(SPLIT367);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT367_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause3182);
            rel368=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel368.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:572:20: ( split_branch )+
            int cnt106=0;
            loop106:
            do {
                int alt106=2;
                int LA106_0 = input.LA(1);

                if ( (LA106_0==SPLIT_BRANCH) ) {
                    alt106=1;
                }


                switch (alt106) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:572:20: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause3184);
            	    split_branch369=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch369.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt106 >= 1 ) break loop106;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(106, input);
                        throw eee;
                }
                cnt106++;
            } while (true);


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:572:34: ( split_otherwise )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==OTHERWISE) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:572:34: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause3187);
                    split_otherwise370=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise370.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:575:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AliasMasker.split_branch_return split_branch() throws RecognitionException {
        AliasMasker.split_branch_return retval = new AliasMasker.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH371=null;
        AliasMasker.alias_return alias372 =null;

        AliasMasker.cond_return cond373 =null;


        CommonTree SPLIT_BRANCH371_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:576:5: ( ^( SPLIT_BRANCH alias cond ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:576:7: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH371=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch3205); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH371_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH371);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH371_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch3207);
            alias372=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias372.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch3209);
            cond373=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond373.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:579:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AliasMasker.split_otherwise_return split_otherwise() throws RecognitionException {
        AliasMasker.split_otherwise_return retval = new AliasMasker.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE374=null;
        AliasMasker.alias_return alias375 =null;


        CommonTree OTHERWISE374_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:580:5: ( ^( OTHERWISE alias ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:580:7: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE374=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise3226); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE374_tree = (CommonTree)adaptor.dupNode(OTHERWISE374);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE374_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise3228);
            alias375=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias375.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:583:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AliasMasker.col_ref_return col_ref() throws RecognitionException {
        AliasMasker.col_ref_return retval = new AliasMasker.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.alias_col_ref_return alias_col_ref376 =null;

        AliasMasker.dollar_col_ref_return dollar_col_ref377 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:583:9: ( alias_col_ref | dollar_col_ref )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==CUBE||LA108_0==GROUP||LA108_0==IDENTIFIER) ) {
                alt108=1;
            }
            else if ( (LA108_0==DOLLARVAR) ) {
                alt108=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;

            }
            switch (alt108) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:583:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref3239);
                    alias_col_ref376=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref376.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:583:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref3243);
                    dollar_col_ref377=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref377.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:586:1: alias_col_ref : ( GROUP | CUBE | IDENTIFIER );
    public final AliasMasker.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AliasMasker.alias_col_ref_return retval = new AliasMasker.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP378=null;
        CommonTree CUBE379=null;
        CommonTree IDENTIFIER380=null;

        CommonTree GROUP378_tree=null;
        CommonTree CUBE379_tree=null;
        CommonTree IDENTIFIER380_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:587:5: ( GROUP | CUBE | IDENTIFIER )
            int alt109=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt109=1;
                }
                break;
            case CUBE:
                {
                alt109=2;
                }
                break;
            case IDENTIFIER:
                {
                alt109=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;

            }

            switch (alt109) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:587:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP378=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref3256); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP378_tree = (CommonTree)adaptor.dupNode(GROUP378);


                    adaptor.addChild(root_0, GROUP378_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:588:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE379=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref3264); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE379_tree = (CommonTree)adaptor.dupNode(CUBE379);


                    adaptor.addChild(root_0, CUBE379_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:589:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER380=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref3272); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER380_tree = (CommonTree)adaptor.dupNode(IDENTIFIER380);


                    adaptor.addChild(root_0, IDENTIFIER380_tree);
                    }


                    if ( state.backtracking==0 ) {
                              String alias = (IDENTIFIER380!=null?IDENTIFIER380.getText():null);
                              String[] names = alias.split( "::" );
                              StringBuilder sb = new StringBuilder();
                              for( int i = 0; i < names.length; i++ ) {
                                  String name = names[i];
                                  sb.append( aliasSeen.contains( name ) ? getMask( name ) : name );
                                  if( i < names.length - 1 )
                                      sb.append( "::" );
                              }
                              IDENTIFIER380.token.setText( sb.toString() );
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
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:604:1: dollar_col_ref : DOLLARVAR ;
    public final AliasMasker.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AliasMasker.dollar_col_ref_return retval = new AliasMasker.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR381=null;

        CommonTree DOLLARVAR381_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:605:5: ( DOLLARVAR )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:605:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR381=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref3293); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR381_tree = (CommonTree)adaptor.dupNode(DOLLARVAR381);


            adaptor.addChild(root_0, DOLLARVAR381_tree);
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
    // $ANTLR end "dollar_col_ref"


    public static class const_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:608:1: const_expr : literal ;
    public final AliasMasker.const_expr_return const_expr() throws RecognitionException {
        AliasMasker.const_expr_return retval = new AliasMasker.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.literal_return literal382 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:608:12: ( literal )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:608:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr3302);
            literal382=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal382.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:611:1: literal : ( scalar | map | bag | tuple );
    public final AliasMasker.literal_return literal() throws RecognitionException {
        AliasMasker.literal_return retval = new AliasMasker.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.scalar_return scalar383 =null;

        AliasMasker.map_return map384 =null;

        AliasMasker.bag_return bag385 =null;

        AliasMasker.tuple_return tuple386 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:611:9: ( scalar | map | bag | tuple )
            int alt110=4;
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
                alt110=1;
                }
                break;
            case MAP_VAL:
                {
                alt110=2;
                }
                break;
            case BAG_VAL:
                {
                alt110=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt110=4;
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:611:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal3311);
                    scalar383=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar383.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:611:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal3315);
                    map384=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map384.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:611:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal3319);
                    bag385=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag385.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:611:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal3323);
                    tuple386=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple386.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:614:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AliasMasker.scalar_return scalar() throws RecognitionException {
        AliasMasker.scalar_return retval = new AliasMasker.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING388=null;
        CommonTree NULL389=null;
        CommonTree TRUE390=null;
        CommonTree FALSE391=null;
        AliasMasker.num_scalar_return num_scalar387 =null;


        CommonTree QUOTEDSTRING388_tree=null;
        CommonTree NULL389_tree=null;
        CommonTree TRUE390_tree=null;
        CommonTree FALSE391_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:614:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt111=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt111=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt111=2;
                }
                break;
            case NULL:
                {
                alt111=3;
                }
                break;
            case TRUE:
                {
                alt111=4;
                }
                break;
            case FALSE:
                {
                alt111=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;

            }

            switch (alt111) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:614:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar3332);
                    num_scalar387=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar387.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:614:23: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING388=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar3336); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING388_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING388);


                    adaptor.addChild(root_0, QUOTEDSTRING388_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:614:38: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL389=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar3340); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL389_tree = (CommonTree)adaptor.dupNode(NULL389);


                    adaptor.addChild(root_0, NULL389_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:614:45: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE390=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar3344); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE390_tree = (CommonTree)adaptor.dupNode(TRUE390);


                    adaptor.addChild(root_0, TRUE390_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:614:52: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE391=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar3348); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE391_tree = (CommonTree)adaptor.dupNode(FALSE391);


                    adaptor.addChild(root_0, FALSE391_tree);
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
    // $ANTLR end "scalar"


    public static class num_scalar_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:617:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final AliasMasker.num_scalar_return num_scalar() throws RecognitionException {
        AliasMasker.num_scalar_return retval = new AliasMasker.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS392=null;
        CommonTree set393=null;

        CommonTree MINUS392_tree=null;
        CommonTree set393_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:617:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:617:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:617:14: ( MINUS )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==MINUS) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:617:14: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS392=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar3357); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS392_tree = (CommonTree)adaptor.dupNode(MINUS392);


                    adaptor.addChild(root_0, MINUS392_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            set393=(CommonTree)input.LT(1);

            if ( input.LA(1)==BIGDECIMALNUMBER||input.LA(1)==BIGINTEGERNUMBER||input.LA(1)==DOUBLENUMBER||input.LA(1)==FLOATNUMBER||input.LA(1)==INTEGER||input.LA(1)==LONGINTEGER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set393_tree = (CommonTree)adaptor.dupNode(set393);


                adaptor.addChild(root_0, set393_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:620:1: map : ^( MAP_VAL ( keyvalue )* ) ;
    public final AliasMasker.map_return map() throws RecognitionException {
        AliasMasker.map_return retval = new AliasMasker.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL394=null;
        AliasMasker.keyvalue_return keyvalue395 =null;


        CommonTree MAP_VAL394_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:621:5: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:621:7: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL394=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map3399); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL394_tree = (CommonTree)adaptor.dupNode(MAP_VAL394);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL394_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:621:18: ( keyvalue )*
                loop113:
                do {
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( (LA113_0==KEY_VAL_PAIR) ) {
                        alt113=1;
                    }


                    switch (alt113) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:621:18: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map3401);
                	    keyvalue395=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue395.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop113;
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
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:624:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AliasMasker.keyvalue_return keyvalue() throws RecognitionException {
        AliasMasker.keyvalue_return retval = new AliasMasker.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR396=null;
        AliasMasker.map_key_return map_key397 =null;

        AliasMasker.const_expr_return const_expr398 =null;


        CommonTree KEY_VAL_PAIR396_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:625:5: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:625:7: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR396=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue3419); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR396_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR396);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR396_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue3421);
            map_key397=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key397.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue3423);
            const_expr398=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr398.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:628:1: map_key : QUOTEDSTRING ;
    public final AliasMasker.map_key_return map_key() throws RecognitionException {
        AliasMasker.map_key_return retval = new AliasMasker.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING399=null;

        CommonTree QUOTEDSTRING399_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:628:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:628:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING399=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key3434); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING399_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING399);


            adaptor.addChild(root_0, QUOTEDSTRING399_tree);
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
    // $ANTLR end "map_key"


    public static class bag_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:631:1: bag : ^( BAG_VAL ( tuple )* ) ;
    public final AliasMasker.bag_return bag() throws RecognitionException {
        AliasMasker.bag_return retval = new AliasMasker.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL400=null;
        AliasMasker.tuple_return tuple401 =null;


        CommonTree BAG_VAL400_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:632:5: ( ^( BAG_VAL ( tuple )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:632:7: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL400=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag3449); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL400_tree = (CommonTree)adaptor.dupNode(BAG_VAL400);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL400_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:632:18: ( tuple )*
                loop114:
                do {
                    int alt114=2;
                    int LA114_0 = input.LA(1);

                    if ( (LA114_0==TUPLE_VAL) ) {
                        alt114=1;
                    }


                    switch (alt114) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:632:18: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag3451);
                	    tuple401=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple401.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop114;
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
    // $ANTLR end "bag"


    public static class tuple_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:635:1: tuple : ^( TUPLE_VAL ( literal )* ) ;
    public final AliasMasker.tuple_return tuple() throws RecognitionException {
        AliasMasker.tuple_return retval = new AliasMasker.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL402=null;
        AliasMasker.literal_return literal403 =null;


        CommonTree TUPLE_VAL402_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:636:5: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:636:7: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL402=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple3469); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL402_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL402);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL402_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:636:20: ( literal )*
                loop115:
                do {
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( (LA115_0==BIGDECIMALNUMBER||LA115_0==BIGINTEGERNUMBER||LA115_0==DOUBLENUMBER||LA115_0==FALSE||LA115_0==FLOATNUMBER||LA115_0==INTEGER||LA115_0==LONGINTEGER||LA115_0==MINUS||LA115_0==NULL||LA115_0==QUOTEDSTRING||LA115_0==TRUE||LA115_0==BAG_VAL||LA115_0==MAP_VAL||LA115_0==TUPLE_VAL) ) {
                        alt115=1;
                    }


                    switch (alt115) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:636:20: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple3471);
                	    literal403=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal403.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop115;
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
    // $ANTLR end "tuple"


    public static class eid_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:640:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | PIVOT | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BIGINTEGER | BIGDECIMAL | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT );
    public final AliasMasker.eid_return eid() throws RecognitionException {
        AliasMasker.eid_return retval = new AliasMasker.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT405=null;
        CommonTree RETURNS406=null;
        CommonTree DEFINE407=null;
        CommonTree LOAD408=null;
        CommonTree FILTER409=null;
        CommonTree FOREACH410=null;
        CommonTree CUBE411=null;
        CommonTree ROLLUP412=null;
        CommonTree PIVOT413=null;
        CommonTree MATCHES414=null;
        CommonTree ORDER415=null;
        CommonTree RANK416=null;
        CommonTree DISTINCT417=null;
        CommonTree COGROUP418=null;
        CommonTree JOIN419=null;
        CommonTree CROSS420=null;
        CommonTree UNION421=null;
        CommonTree SPLIT422=null;
        CommonTree INTO423=null;
        CommonTree IF424=null;
        CommonTree ALL425=null;
        CommonTree AS426=null;
        CommonTree BY427=null;
        CommonTree USING428=null;
        CommonTree INNER429=null;
        CommonTree OUTER430=null;
        CommonTree PARALLEL431=null;
        CommonTree PARTITION432=null;
        CommonTree GROUP433=null;
        CommonTree AND434=null;
        CommonTree OR435=null;
        CommonTree NOT436=null;
        CommonTree GENERATE437=null;
        CommonTree FLATTEN438=null;
        CommonTree EVAL439=null;
        CommonTree ASC440=null;
        CommonTree DESC441=null;
        CommonTree BOOLEAN442=null;
        CommonTree INT443=null;
        CommonTree LONG444=null;
        CommonTree FLOAT445=null;
        CommonTree DOUBLE446=null;
        CommonTree DATETIME447=null;
        CommonTree CHARARRAY448=null;
        CommonTree BIGINTEGER449=null;
        CommonTree BIGDECIMAL450=null;
        CommonTree BYTEARRAY451=null;
        CommonTree BAG452=null;
        CommonTree TUPLE453=null;
        CommonTree MAP454=null;
        CommonTree IS455=null;
        CommonTree NULL456=null;
        CommonTree TRUE457=null;
        CommonTree FALSE458=null;
        CommonTree STREAM459=null;
        CommonTree THROUGH460=null;
        CommonTree STORE461=null;
        CommonTree MAPREDUCE462=null;
        CommonTree SHIP463=null;
        CommonTree CACHE464=null;
        CommonTree INPUT465=null;
        CommonTree OUTPUT466=null;
        CommonTree STDERROR467=null;
        CommonTree STDIN468=null;
        CommonTree STDOUT469=null;
        CommonTree LIMIT470=null;
        CommonTree SAMPLE471=null;
        CommonTree LEFT472=null;
        CommonTree RIGHT473=null;
        CommonTree FULL474=null;
        CommonTree IDENTIFIER475=null;
        CommonTree TOBAG476=null;
        CommonTree TOMAP477=null;
        CommonTree TOTUPLE478=null;
        CommonTree ASSERT479=null;
        AliasMasker.rel_str_op_return rel_str_op404 =null;


        CommonTree IMPORT405_tree=null;
        CommonTree RETURNS406_tree=null;
        CommonTree DEFINE407_tree=null;
        CommonTree LOAD408_tree=null;
        CommonTree FILTER409_tree=null;
        CommonTree FOREACH410_tree=null;
        CommonTree CUBE411_tree=null;
        CommonTree ROLLUP412_tree=null;
        CommonTree PIVOT413_tree=null;
        CommonTree MATCHES414_tree=null;
        CommonTree ORDER415_tree=null;
        CommonTree RANK416_tree=null;
        CommonTree DISTINCT417_tree=null;
        CommonTree COGROUP418_tree=null;
        CommonTree JOIN419_tree=null;
        CommonTree CROSS420_tree=null;
        CommonTree UNION421_tree=null;
        CommonTree SPLIT422_tree=null;
        CommonTree INTO423_tree=null;
        CommonTree IF424_tree=null;
        CommonTree ALL425_tree=null;
        CommonTree AS426_tree=null;
        CommonTree BY427_tree=null;
        CommonTree USING428_tree=null;
        CommonTree INNER429_tree=null;
        CommonTree OUTER430_tree=null;
        CommonTree PARALLEL431_tree=null;
        CommonTree PARTITION432_tree=null;
        CommonTree GROUP433_tree=null;
        CommonTree AND434_tree=null;
        CommonTree OR435_tree=null;
        CommonTree NOT436_tree=null;
        CommonTree GENERATE437_tree=null;
        CommonTree FLATTEN438_tree=null;
        CommonTree EVAL439_tree=null;
        CommonTree ASC440_tree=null;
        CommonTree DESC441_tree=null;
        CommonTree BOOLEAN442_tree=null;
        CommonTree INT443_tree=null;
        CommonTree LONG444_tree=null;
        CommonTree FLOAT445_tree=null;
        CommonTree DOUBLE446_tree=null;
        CommonTree DATETIME447_tree=null;
        CommonTree CHARARRAY448_tree=null;
        CommonTree BIGINTEGER449_tree=null;
        CommonTree BIGDECIMAL450_tree=null;
        CommonTree BYTEARRAY451_tree=null;
        CommonTree BAG452_tree=null;
        CommonTree TUPLE453_tree=null;
        CommonTree MAP454_tree=null;
        CommonTree IS455_tree=null;
        CommonTree NULL456_tree=null;
        CommonTree TRUE457_tree=null;
        CommonTree FALSE458_tree=null;
        CommonTree STREAM459_tree=null;
        CommonTree THROUGH460_tree=null;
        CommonTree STORE461_tree=null;
        CommonTree MAPREDUCE462_tree=null;
        CommonTree SHIP463_tree=null;
        CommonTree CACHE464_tree=null;
        CommonTree INPUT465_tree=null;
        CommonTree OUTPUT466_tree=null;
        CommonTree STDERROR467_tree=null;
        CommonTree STDIN468_tree=null;
        CommonTree STDOUT469_tree=null;
        CommonTree LIMIT470_tree=null;
        CommonTree SAMPLE471_tree=null;
        CommonTree LEFT472_tree=null;
        CommonTree RIGHT473_tree=null;
        CommonTree FULL474_tree=null;
        CommonTree IDENTIFIER475_tree=null;
        CommonTree TOBAG476_tree=null;
        CommonTree TOMAP477_tree=null;
        CommonTree TOTUPLE478_tree=null;
        CommonTree ASSERT479_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:640:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | PIVOT | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BIGINTEGER | BIGDECIMAL | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT )
            int alt116=76;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt116=1;
                }
                break;
            case IMPORT:
                {
                alt116=2;
                }
                break;
            case RETURNS:
                {
                alt116=3;
                }
                break;
            case DEFINE:
                {
                alt116=4;
                }
                break;
            case LOAD:
                {
                alt116=5;
                }
                break;
            case FILTER:
                {
                alt116=6;
                }
                break;
            case FOREACH:
                {
                alt116=7;
                }
                break;
            case CUBE:
                {
                alt116=8;
                }
                break;
            case ROLLUP:
                {
                alt116=9;
                }
                break;
            case PIVOT:
                {
                alt116=10;
                }
                break;
            case MATCHES:
                {
                alt116=11;
                }
                break;
            case ORDER:
                {
                alt116=12;
                }
                break;
            case RANK:
                {
                alt116=13;
                }
                break;
            case DISTINCT:
                {
                alt116=14;
                }
                break;
            case COGROUP:
                {
                alt116=15;
                }
                break;
            case JOIN:
                {
                alt116=16;
                }
                break;
            case CROSS:
                {
                alt116=17;
                }
                break;
            case UNION:
                {
                alt116=18;
                }
                break;
            case SPLIT:
                {
                alt116=19;
                }
                break;
            case INTO:
                {
                alt116=20;
                }
                break;
            case IF:
                {
                alt116=21;
                }
                break;
            case ALL:
                {
                alt116=22;
                }
                break;
            case AS:
                {
                alt116=23;
                }
                break;
            case BY:
                {
                alt116=24;
                }
                break;
            case USING:
                {
                alt116=25;
                }
                break;
            case INNER:
                {
                alt116=26;
                }
                break;
            case OUTER:
                {
                alt116=27;
                }
                break;
            case PARALLEL:
                {
                alt116=28;
                }
                break;
            case PARTITION:
                {
                alt116=29;
                }
                break;
            case GROUP:
                {
                alt116=30;
                }
                break;
            case AND:
                {
                alt116=31;
                }
                break;
            case OR:
                {
                alt116=32;
                }
                break;
            case NOT:
                {
                alt116=33;
                }
                break;
            case GENERATE:
                {
                alt116=34;
                }
                break;
            case FLATTEN:
                {
                alt116=35;
                }
                break;
            case EVAL:
                {
                alt116=36;
                }
                break;
            case ASC:
                {
                alt116=37;
                }
                break;
            case DESC:
                {
                alt116=38;
                }
                break;
            case BOOLEAN:
                {
                alt116=39;
                }
                break;
            case INT:
                {
                alt116=40;
                }
                break;
            case LONG:
                {
                alt116=41;
                }
                break;
            case FLOAT:
                {
                alt116=42;
                }
                break;
            case DOUBLE:
                {
                alt116=43;
                }
                break;
            case DATETIME:
                {
                alt116=44;
                }
                break;
            case CHARARRAY:
                {
                alt116=45;
                }
                break;
            case BIGINTEGER:
                {
                alt116=46;
                }
                break;
            case BIGDECIMAL:
                {
                alt116=47;
                }
                break;
            case BYTEARRAY:
                {
                alt116=48;
                }
                break;
            case BAG:
                {
                alt116=49;
                }
                break;
            case TUPLE:
                {
                alt116=50;
                }
                break;
            case MAP:
                {
                alt116=51;
                }
                break;
            case IS:
                {
                alt116=52;
                }
                break;
            case NULL:
                {
                alt116=53;
                }
                break;
            case TRUE:
                {
                alt116=54;
                }
                break;
            case FALSE:
                {
                alt116=55;
                }
                break;
            case STREAM:
                {
                alt116=56;
                }
                break;
            case THROUGH:
                {
                alt116=57;
                }
                break;
            case STORE:
                {
                alt116=58;
                }
                break;
            case MAPREDUCE:
                {
                alt116=59;
                }
                break;
            case SHIP:
                {
                alt116=60;
                }
                break;
            case CACHE:
                {
                alt116=61;
                }
                break;
            case INPUT:
                {
                alt116=62;
                }
                break;
            case OUTPUT:
                {
                alt116=63;
                }
                break;
            case STDERROR:
                {
                alt116=64;
                }
                break;
            case STDIN:
                {
                alt116=65;
                }
                break;
            case STDOUT:
                {
                alt116=66;
                }
                break;
            case LIMIT:
                {
                alt116=67;
                }
                break;
            case SAMPLE:
                {
                alt116=68;
                }
                break;
            case LEFT:
                {
                alt116=69;
                }
                break;
            case RIGHT:
                {
                alt116=70;
                }
                break;
            case FULL:
                {
                alt116=71;
                }
                break;
            case IDENTIFIER:
                {
                alt116=72;
                }
                break;
            case TOBAG:
                {
                alt116=73;
                }
                break;
            case TOMAP:
                {
                alt116=74;
                }
                break;
            case TOTUPLE:
                {
                alt116=75;
                }
                break;
            case ASSERT:
                {
                alt116=76;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;

            }

            switch (alt116) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:640:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid3484);
                    rel_str_op404=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op404.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:641:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT405=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid3492); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT405_tree = (CommonTree)adaptor.dupNode(IMPORT405);


                    adaptor.addChild(root_0, IMPORT405_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:642:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS406=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid3500); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS406_tree = (CommonTree)adaptor.dupNode(RETURNS406);


                    adaptor.addChild(root_0, RETURNS406_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:643:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE407=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid3508); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE407_tree = (CommonTree)adaptor.dupNode(DEFINE407);


                    adaptor.addChild(root_0, DEFINE407_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:644:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD408=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid3516); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD408_tree = (CommonTree)adaptor.dupNode(LOAD408);


                    adaptor.addChild(root_0, LOAD408_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:645:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER409=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid3524); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER409_tree = (CommonTree)adaptor.dupNode(FILTER409);


                    adaptor.addChild(root_0, FILTER409_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:646:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH410=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid3532); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH410_tree = (CommonTree)adaptor.dupNode(FOREACH410);


                    adaptor.addChild(root_0, FOREACH410_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:647:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE411=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid3540); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE411_tree = (CommonTree)adaptor.dupNode(CUBE411);


                    adaptor.addChild(root_0, CUBE411_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:648:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP412=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid3548); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP412_tree = (CommonTree)adaptor.dupNode(ROLLUP412);


                    adaptor.addChild(root_0, ROLLUP412_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:649:7: PIVOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PIVOT413=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_eid3556); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PIVOT413_tree = (CommonTree)adaptor.dupNode(PIVOT413);


                    adaptor.addChild(root_0, PIVOT413_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:650:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES414=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid3564); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES414_tree = (CommonTree)adaptor.dupNode(MATCHES414);


                    adaptor.addChild(root_0, MATCHES414_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:651:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER415=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid3572); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER415_tree = (CommonTree)adaptor.dupNode(ORDER415);


                    adaptor.addChild(root_0, ORDER415_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:652:7: RANK
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RANK416=(CommonTree)match(input,RANK,FOLLOW_RANK_in_eid3580); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RANK416_tree = (CommonTree)adaptor.dupNode(RANK416);


                    adaptor.addChild(root_0, RANK416_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:653:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT417=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid3588); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT417_tree = (CommonTree)adaptor.dupNode(DISTINCT417);


                    adaptor.addChild(root_0, DISTINCT417_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:654:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP418=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid3596); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP418_tree = (CommonTree)adaptor.dupNode(COGROUP418);


                    adaptor.addChild(root_0, COGROUP418_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:655:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN419=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid3604); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN419_tree = (CommonTree)adaptor.dupNode(JOIN419);


                    adaptor.addChild(root_0, JOIN419_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:656:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS420=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid3612); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS420_tree = (CommonTree)adaptor.dupNode(CROSS420);


                    adaptor.addChild(root_0, CROSS420_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:657:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION421=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid3620); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION421_tree = (CommonTree)adaptor.dupNode(UNION421);


                    adaptor.addChild(root_0, UNION421_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:658:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT422=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid3628); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT422_tree = (CommonTree)adaptor.dupNode(SPLIT422);


                    adaptor.addChild(root_0, SPLIT422_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:659:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO423=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid3636); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO423_tree = (CommonTree)adaptor.dupNode(INTO423);


                    adaptor.addChild(root_0, INTO423_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:660:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF424=(CommonTree)match(input,IF,FOLLOW_IF_in_eid3644); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF424_tree = (CommonTree)adaptor.dupNode(IF424);


                    adaptor.addChild(root_0, IF424_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:661:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL425=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid3652); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL425_tree = (CommonTree)adaptor.dupNode(ALL425);


                    adaptor.addChild(root_0, ALL425_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:662:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS426=(CommonTree)match(input,AS,FOLLOW_AS_in_eid3660); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS426_tree = (CommonTree)adaptor.dupNode(AS426);


                    adaptor.addChild(root_0, AS426_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:663:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY427=(CommonTree)match(input,BY,FOLLOW_BY_in_eid3668); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY427_tree = (CommonTree)adaptor.dupNode(BY427);


                    adaptor.addChild(root_0, BY427_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:664:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING428=(CommonTree)match(input,USING,FOLLOW_USING_in_eid3676); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING428_tree = (CommonTree)adaptor.dupNode(USING428);


                    adaptor.addChild(root_0, USING428_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:665:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER429=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid3684); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER429_tree = (CommonTree)adaptor.dupNode(INNER429);


                    adaptor.addChild(root_0, INNER429_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:666:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER430=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid3692); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER430_tree = (CommonTree)adaptor.dupNode(OUTER430);


                    adaptor.addChild(root_0, OUTER430_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:667:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL431=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid3700); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL431_tree = (CommonTree)adaptor.dupNode(PARALLEL431);


                    adaptor.addChild(root_0, PARALLEL431_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:668:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION432=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid3708); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION432_tree = (CommonTree)adaptor.dupNode(PARTITION432);


                    adaptor.addChild(root_0, PARTITION432_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:669:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP433=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid3716); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP433_tree = (CommonTree)adaptor.dupNode(GROUP433);


                    adaptor.addChild(root_0, GROUP433_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:670:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND434=(CommonTree)match(input,AND,FOLLOW_AND_in_eid3724); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND434_tree = (CommonTree)adaptor.dupNode(AND434);


                    adaptor.addChild(root_0, AND434_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:671:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR435=(CommonTree)match(input,OR,FOLLOW_OR_in_eid3732); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR435_tree = (CommonTree)adaptor.dupNode(OR435);


                    adaptor.addChild(root_0, OR435_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:672:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT436=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid3740); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT436_tree = (CommonTree)adaptor.dupNode(NOT436);


                    adaptor.addChild(root_0, NOT436_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:673:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE437=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid3748); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE437_tree = (CommonTree)adaptor.dupNode(GENERATE437);


                    adaptor.addChild(root_0, GENERATE437_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:674:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN438=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid3756); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN438_tree = (CommonTree)adaptor.dupNode(FLATTEN438);


                    adaptor.addChild(root_0, FLATTEN438_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:675:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL439=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid3764); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL439_tree = (CommonTree)adaptor.dupNode(EVAL439);


                    adaptor.addChild(root_0, EVAL439_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:676:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC440=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid3772); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC440_tree = (CommonTree)adaptor.dupNode(ASC440);


                    adaptor.addChild(root_0, ASC440_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:677:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC441=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid3780); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC441_tree = (CommonTree)adaptor.dupNode(DESC441);


                    adaptor.addChild(root_0, DESC441_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:678:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN442=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid3788); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN442_tree = (CommonTree)adaptor.dupNode(BOOLEAN442);


                    adaptor.addChild(root_0, BOOLEAN442_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:679:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT443=(CommonTree)match(input,INT,FOLLOW_INT_in_eid3796); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT443_tree = (CommonTree)adaptor.dupNode(INT443);


                    adaptor.addChild(root_0, INT443_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:680:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG444=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid3804); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG444_tree = (CommonTree)adaptor.dupNode(LONG444);


                    adaptor.addChild(root_0, LONG444_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:681:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT445=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid3812); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT445_tree = (CommonTree)adaptor.dupNode(FLOAT445);


                    adaptor.addChild(root_0, FLOAT445_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:682:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE446=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid3820); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE446_tree = (CommonTree)adaptor.dupNode(DOUBLE446);


                    adaptor.addChild(root_0, DOUBLE446_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:683:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME447=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid3828); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME447_tree = (CommonTree)adaptor.dupNode(DATETIME447);


                    adaptor.addChild(root_0, DATETIME447_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:684:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY448=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid3836); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY448_tree = (CommonTree)adaptor.dupNode(CHARARRAY448);


                    adaptor.addChild(root_0, CHARARRAY448_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:685:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER449=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid3844); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER449_tree = (CommonTree)adaptor.dupNode(BIGINTEGER449);


                    adaptor.addChild(root_0, BIGINTEGER449_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:686:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL450=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid3852); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL450_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL450);


                    adaptor.addChild(root_0, BIGDECIMAL450_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:687:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY451=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid3860); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY451_tree = (CommonTree)adaptor.dupNode(BYTEARRAY451);


                    adaptor.addChild(root_0, BYTEARRAY451_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:688:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG452=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid3868); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG452_tree = (CommonTree)adaptor.dupNode(BAG452);


                    adaptor.addChild(root_0, BAG452_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:689:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE453=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid3876); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE453_tree = (CommonTree)adaptor.dupNode(TUPLE453);


                    adaptor.addChild(root_0, TUPLE453_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:690:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP454=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid3884); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP454_tree = (CommonTree)adaptor.dupNode(MAP454);


                    adaptor.addChild(root_0, MAP454_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:691:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS455=(CommonTree)match(input,IS,FOLLOW_IS_in_eid3892); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS455_tree = (CommonTree)adaptor.dupNode(IS455);


                    adaptor.addChild(root_0, IS455_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:692:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL456=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid3900); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL456_tree = (CommonTree)adaptor.dupNode(NULL456);


                    adaptor.addChild(root_0, NULL456_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:693:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE457=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid3908); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE457_tree = (CommonTree)adaptor.dupNode(TRUE457);


                    adaptor.addChild(root_0, TRUE457_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:694:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE458=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid3916); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE458_tree = (CommonTree)adaptor.dupNode(FALSE458);


                    adaptor.addChild(root_0, FALSE458_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:695:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM459=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid3924); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM459_tree = (CommonTree)adaptor.dupNode(STREAM459);


                    adaptor.addChild(root_0, STREAM459_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:696:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH460=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid3932); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH460_tree = (CommonTree)adaptor.dupNode(THROUGH460);


                    adaptor.addChild(root_0, THROUGH460_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:697:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE461=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid3940); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE461_tree = (CommonTree)adaptor.dupNode(STORE461);


                    adaptor.addChild(root_0, STORE461_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:698:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE462=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid3948); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE462_tree = (CommonTree)adaptor.dupNode(MAPREDUCE462);


                    adaptor.addChild(root_0, MAPREDUCE462_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:699:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP463=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid3956); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP463_tree = (CommonTree)adaptor.dupNode(SHIP463);


                    adaptor.addChild(root_0, SHIP463_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:700:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE464=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid3964); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE464_tree = (CommonTree)adaptor.dupNode(CACHE464);


                    adaptor.addChild(root_0, CACHE464_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:701:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT465=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid3972); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT465_tree = (CommonTree)adaptor.dupNode(INPUT465);


                    adaptor.addChild(root_0, INPUT465_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:702:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT466=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid3980); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT466_tree = (CommonTree)adaptor.dupNode(OUTPUT466);


                    adaptor.addChild(root_0, OUTPUT466_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:703:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR467=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid3988); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR467_tree = (CommonTree)adaptor.dupNode(STDERROR467);


                    adaptor.addChild(root_0, STDERROR467_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:704:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN468=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid3996); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN468_tree = (CommonTree)adaptor.dupNode(STDIN468);


                    adaptor.addChild(root_0, STDIN468_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:705:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT469=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid4004); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT469_tree = (CommonTree)adaptor.dupNode(STDOUT469);


                    adaptor.addChild(root_0, STDOUT469_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:706:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT470=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid4012); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT470_tree = (CommonTree)adaptor.dupNode(LIMIT470);


                    adaptor.addChild(root_0, LIMIT470_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:707:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE471=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid4020); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE471_tree = (CommonTree)adaptor.dupNode(SAMPLE471);


                    adaptor.addChild(root_0, SAMPLE471_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:708:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT472=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid4028); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT472_tree = (CommonTree)adaptor.dupNode(LEFT472);


                    adaptor.addChild(root_0, LEFT472_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:709:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT473=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid4036); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT473_tree = (CommonTree)adaptor.dupNode(RIGHT473);


                    adaptor.addChild(root_0, RIGHT473_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:710:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL474=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid4044); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL474_tree = (CommonTree)adaptor.dupNode(FULL474);


                    adaptor.addChild(root_0, FULL474_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:711:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER475=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid4052); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER475_tree = (CommonTree)adaptor.dupNode(IDENTIFIER475);


                    adaptor.addChild(root_0, IDENTIFIER475_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:712:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG476=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid4060); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG476_tree = (CommonTree)adaptor.dupNode(TOBAG476);


                    adaptor.addChild(root_0, TOBAG476_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:713:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP477=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid4068); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP477_tree = (CommonTree)adaptor.dupNode(TOMAP477);


                    adaptor.addChild(root_0, TOMAP477_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 75 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:714:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE478=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid4076); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE478_tree = (CommonTree)adaptor.dupNode(TOTUPLE478);


                    adaptor.addChild(root_0, TOTUPLE478_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 76 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:715:7: ASSERT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASSERT479=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_eid4084); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSERT479_tree = (CommonTree)adaptor.dupNode(ASSERT479);


                    adaptor.addChild(root_0, ASSERT479_tree);
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
    // $ANTLR end "eid"


    public static class rel_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:719:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AliasMasker.rel_op_return rel_op() throws RecognitionException {
        AliasMasker.rel_op_return retval = new AliasMasker.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES486=null;
        AliasMasker.rel_op_eq_return rel_op_eq480 =null;

        AliasMasker.rel_op_ne_return rel_op_ne481 =null;

        AliasMasker.rel_op_gt_return rel_op_gt482 =null;

        AliasMasker.rel_op_gte_return rel_op_gte483 =null;

        AliasMasker.rel_op_lt_return rel_op_lt484 =null;

        AliasMasker.rel_op_lte_return rel_op_lte485 =null;


        CommonTree STR_OP_MATCHES486_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:720:5: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt117=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt117=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt117=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt117=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt117=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt117=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt117=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt117=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;

            }

            switch (alt117) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:720:7: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op4098);
                    rel_op_eq480=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq480.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:721:7: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op4106);
                    rel_op_ne481=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne481.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:722:7: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op4114);
                    rel_op_gt482=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt482.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:723:7: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op4122);
                    rel_op_gte483=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte483.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:724:7: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op4130);
                    rel_op_lt484=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt484.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:725:7: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op4138);
                    rel_op_lte485=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte485.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:726:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES486=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op4146); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES486_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES486);


                    adaptor.addChild(root_0, STR_OP_MATCHES486_tree);
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
    // $ANTLR end "rel_op"


    public static class rel_op_eq_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_eq"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:729:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final AliasMasker.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AliasMasker.rel_op_eq_return retval = new AliasMasker.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set487=null;

        CommonTree set487_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:730:5: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set487=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set487_tree = (CommonTree)adaptor.dupNode(set487);


                adaptor.addChild(root_0, set487_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:734:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final AliasMasker.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AliasMasker.rel_op_ne_return retval = new AliasMasker.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set488=null;

        CommonTree set488_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:735:5: ( STR_OP_NE | NUM_OP_NE )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set488=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set488_tree = (CommonTree)adaptor.dupNode(set488);


                adaptor.addChild(root_0, set488_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_op_ne"


    public static class rel_op_gt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gt"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:739:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final AliasMasker.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AliasMasker.rel_op_gt_return retval = new AliasMasker.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set489=null;

        CommonTree set489_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:740:5: ( STR_OP_GT | NUM_OP_GT )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set489=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set489_tree = (CommonTree)adaptor.dupNode(set489);


                adaptor.addChild(root_0, set489_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_op_gt"


    public static class rel_op_gte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gte"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:744:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final AliasMasker.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AliasMasker.rel_op_gte_return retval = new AliasMasker.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set490=null;

        CommonTree set490_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:745:5: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set490=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set490_tree = (CommonTree)adaptor.dupNode(set490);


                adaptor.addChild(root_0, set490_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_op_gte"


    public static class rel_op_lt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lt"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:749:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final AliasMasker.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AliasMasker.rel_op_lt_return retval = new AliasMasker.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set491=null;

        CommonTree set491_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:750:5: ( STR_OP_LT | NUM_OP_LT )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set491=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set491_tree = (CommonTree)adaptor.dupNode(set491);


                adaptor.addChild(root_0, set491_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_op_lt"


    public static class rel_op_lte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lte"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:754:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final AliasMasker.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AliasMasker.rel_op_lte_return retval = new AliasMasker.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set492=null;

        CommonTree set492_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:755:5: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set492=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set492_tree = (CommonTree)adaptor.dupNode(set492);


                adaptor.addChild(root_0, set492_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_op_lte"


    public static class rel_str_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:759:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AliasMasker.rel_str_op_return rel_str_op() throws RecognitionException {
        AliasMasker.rel_str_op_return retval = new AliasMasker.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set493=null;

        CommonTree set493_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:760:5: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set493=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= STR_OP_EQ && input.LA(1) <= STR_OP_NE) ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set493_tree = (CommonTree)adaptor.dupNode(set493);


                adaptor.addChild(root_0, set493_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred102_AliasMasker
    public final void synpred102_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:347:7: ( ^( MINUS expr expr ) )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:347:7: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred102_AliasMasker1717); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred102_AliasMasker1719);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred102_AliasMasker1721);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred102_AliasMasker

    // $ANTLR start synpred106_AliasMasker
    public final void synpred106_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:351:7: ( ^( CAST_EXPR type expr ) )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:351:7: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred106_AliasMasker1781); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred106_AliasMasker1783);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred106_AliasMasker1785);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred106_AliasMasker

    // $ANTLR start synpred107_AliasMasker
    public final void synpred107_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:352:7: ( const_expr )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:352:7: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred107_AliasMasker1795);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred107_AliasMasker

    // $ANTLR start synpred110_AliasMasker
    public final void synpred110_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:355:7: ( ^( CAST_EXPR type_cast expr ) )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:355:7: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred110_AliasMasker1827); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred110_AliasMasker1829);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred110_AliasMasker1831);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred110_AliasMasker

    // $ANTLR start synpred133_AliasMasker
    public final void synpred133_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:416:22: ( INTEGER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:416:22: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred133_AliasMasker2208); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred133_AliasMasker

    // $ANTLR start synpred134_AliasMasker
    public final void synpred134_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:416:32: ( LONGINTEGER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:416:32: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred134_AliasMasker2212); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred134_AliasMasker

    // $ANTLR start synpred135_AliasMasker
    public final void synpred135_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:420:24: ( DOUBLENUMBER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:420:24: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred135_AliasMasker2242); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred135_AliasMasker

    // $ANTLR start synpred161_AliasMasker
    public final void synpred161_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:477:7: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:477:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred161_AliasMasker2566);
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


        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:480:16: ( OUTER )?
        int alt126=2;
        int LA126_0 = input.LA(1);

        if ( (LA126_0==OUTER) ) {
            alt126=1;
        }
        switch (alt126) {
            case 1 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:480:16: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred161_AliasMasker2621); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred161_AliasMasker2624);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred161_AliasMasker

    // $ANTLR start synpred179_AliasMasker
    public final void synpred179_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:548:34: ( INTEGER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AliasMasker.g:548:34: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred179_AliasMasker3041); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred179_AliasMasker

    // Delegated rules

    public final boolean synpred106_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred161_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred161_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred107_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred110_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred110_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred134_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred134_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred179_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred179_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred133_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred133_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_QUERY_in_query80 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query82 = new BitSet(new long[]{0x0000000000000408L,0x0040000000000000L,0x0024000000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_assert_statement153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement178 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement182 = new BitSet(new long[]{0x0048400226400400L,0x1842020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_op_clause_in_general_statement195 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement197 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause210 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause212 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause214 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause230 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause232 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_op_clause518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause533 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_define_clause535 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause540 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause544 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd563 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd575 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd579 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd583 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd587 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd591 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause611 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause613 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list629 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause647 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause664 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause666 = new BitSet(new long[]{0x0000000000000008L,0x0600010000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd684 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd686 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd699 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd701 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd714 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause734 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause736 = new BitSet(new long[]{0x0000000000000008L,0x0600010000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause754 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause758 = new BitSet(new long[]{0x8000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause760 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause781 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause783 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause785 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause788 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause829 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause831 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def848 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def850 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0200040000004000L});
    public static final BitSet FOLLOW_type_in_field_def852 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def867 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def869 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list884 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_simple_type_in_type894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type970 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type972 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type990 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type992 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type995 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1009 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1011 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1029 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1031 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1043 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1045 = new BitSet(new long[]{0x0000000000000008L,0x0000010000000000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1047 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1063 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_set_in_func_name1067 = new BitSet(new long[]{0x7779D022AE6F5F50L,0xFF4B1A13D80C6E1DL,0x31C00000000003EFL});
    public static final BitSet FOLLOW_eid_in_func_name1077 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1093 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1109 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1111 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIVOT_in_pivot_clause1128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_pivot_clause1130 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1145 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1166 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1168 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1183 = new BitSet(new long[]{0x0000000004000002L,0x0001000000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1201 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1209 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1211 = new BitSet(new long[]{0x0000000000000008L,0x0000001000000000L});
    public static final BitSet FOLLOW_pivot_clause_in_cube_rollup_list1213 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1229 = new BitSet(new long[]{0x814410540400A002L,0x0080012400089000L,0x0800180107330040L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_group_clause1266 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1276 = new BitSet(new long[]{0x0148400226400408L,0x1842030210004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_group_type_in_group_clause1279 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1282 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1307 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1311 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1315 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1319 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_alias_in_rel1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1351 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1381 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1385 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1389 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1393 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1413 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1415 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1432 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_store_clause1434 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause1436 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1438 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSERT_in_assert_clause1456 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_assert_clause1458 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_assert_clause1460 = new BitSet(new long[]{0x0000000000000008L,0x0000010000000000L});
    public static final BitSet FOLLOW_comment_in_assert_clause1462 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_comment1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1491 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_filter_clause1493 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1510 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1512 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_cond1514 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1526 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1528 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_cond1530 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1542 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1544 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1556 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1558 = new BitSet(new long[]{0x0000000000000008L,0x0000000000040000L});
    public static final BitSet FOLLOW_NOT_in_cond1560 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1573 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1575 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_cond1577 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond1605 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1607 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval1624 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval1630 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1632 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval1638 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1640 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1662 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1664 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1666 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_real_arg1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr1701 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1703 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr1705 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1719 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr1721 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr1733 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1735 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr1737 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1749 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1751 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr1753 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr1765 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1767 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr1769 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1781 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr1783 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr1785 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr1813 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1815 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1827 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr1829 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_expr1831 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr1843 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1845 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast1864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1887 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast1889 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0400040000008000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1907 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast1909 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr1925 = new BitSet(new long[]{0x0000000000000002L,0x0000004800000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr1929 = new BitSet(new long[]{0x0000000000000002L,0x0000004800000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr1933 = new BitSet(new long[]{0x0000000000000002L,0x0000004800000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr1949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr1965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj1980 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj1982 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index1994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index2040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range2051 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range2053 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range2056 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range2058 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj2075 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_pound_proj2077 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr2102 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2104 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_bin_expr2106 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_bin_expr2108 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr2125 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr2131 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2133 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr2141 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2143 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond2167 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond2171 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond2173 = new BitSet(new long[]{0x0800000000000048L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_THEN_in_case_cond2180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond2182 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2202 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause2204 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause2208 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause2212 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause2216 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause2236 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause2238 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause2242 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause2246 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause2262 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause2264 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause2268 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement2285 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement2287 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement2291 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause2306 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause2325 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_col_range_in_rank_col2338 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_col_ref_in_rank_col2342 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ORDER_in_order_clause2370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause2372 = new BitSet(new long[]{0x0140001004000000L,0x0080000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause2374 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause2376 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause2392 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2411 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_col_range_in_order_col2426 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_col_ref_in_order_col2430 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause2457 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause2459 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause2461 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause2479 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause2481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause2498 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause2500 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause2502 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list2518 = new BitSet(new long[]{0x0148400226400402L,0x1842020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_JOIN_in_join_clause2534 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause2536 = new BitSet(new long[]{0x0000000000000008L,0x0000010200000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause2538 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause2541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type2553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2566 = new BitSet(new long[]{0x0010000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_set_in_join_sub_clause2568 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause2621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2632 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item2645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item2647 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item2649 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause2666 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2668 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180107330040L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr2684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr2688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr2692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause2707 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause2709 = new BitSet(new long[]{0x0148400226400400L,0x1842020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_rel_list_in_union_clause2712 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause2729 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause2731 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause2733 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2750 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan2752 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2764 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan2766 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk2781 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000000L,0x0000600000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause2799 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause2801 = new BitSet(new long[]{0x814490540400A008L,0x0080012400089000L,0x0800180107330040L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command2819 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2821 = new BitSet(new long[]{0x0008400202000000L,0x0000000010000200L,0x0000800000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command2823 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command2835 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2837 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_nested_command2839 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op2850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op2864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op2878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op2892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op2920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op2934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj2949 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2951 = new BitSet(new long[]{0x0140001004000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2953 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter2971 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter2973 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_nested_filter2975 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort2992 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort2994 = new BitSet(new long[]{0x0140001004000000L,0x0080000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort2996 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort2998 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct3016 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct3018 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit3035 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit3037 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit3041 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit3045 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross3060 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross3062 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach3075 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach3077 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach3079 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list3090 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input3100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input3104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause3119 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause3121 = new BitSet(new long[]{0x0100080000000000L});
    public static final BitSet FOLLOW_set_in_stream_clause3123 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause3133 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause3151 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause3153 = new BitSet(new long[]{0x0000000000000000L,0x0800010000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause3155 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause3158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause3160 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause3162 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause3180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause3182 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3184 = new BitSet(new long[]{0x0000000000000008L,0x0000000020000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause3187 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch3205 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch3207 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000010008000FL});
    public static final BitSet FOLLOW_cond_in_split_branch3209 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise3226 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise3228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref3239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref3243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref3264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref3272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref3293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal3311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal3315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal3319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal3323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar3340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar3344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar3348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar3357 = new BitSet(new long[]{0x800400400000A000L,0x0000000000001000L});
    public static final BitSet FOLLOW_set_in_num_scalar3360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map3399 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map3401 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue3419 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue3421 = new BitSet(new long[]{0x800410400000A000L,0x0000010000089000L,0x0800080000010040L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue3423 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key3434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag3449 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag3451 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple3469 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple3471 = new BitSet(new long[]{0x800410400000A008L,0x0000010000089000L,0x0800080000010040L});
    public static final BitSet FOLLOW_rel_str_op_in_eid3484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid3492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid3500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid3508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid3540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid3548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIVOT_in_eid3556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid3564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid3572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANK_in_eid3580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid3588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid3596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid3604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid3612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid3620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid3628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid3636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid3644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid3652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid3660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid3676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid3684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid3692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid3700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid3708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid3716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid3740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid3748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid3756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid3764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid3772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid3780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid3788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid3796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid3804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid3812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid3820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid3828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid3836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid3844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid3852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid3860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid3868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid3876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid3884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid3900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid3924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid3932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid3940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid3948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid3956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid3972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid3980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid3988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid3996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid4004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid4012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid4020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid4028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid4036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid4044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid4052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid4060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid4068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid4076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_eid4084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op4098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op4106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op4114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op4122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op4130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op4138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op4146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred102_AliasMasker1717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred102_AliasMasker1719 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_synpred102_AliasMasker1721 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred106_AliasMasker1781 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred106_AliasMasker1783 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_synpred106_AliasMasker1785 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred107_AliasMasker1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred110_AliasMasker1827 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred110_AliasMasker1829 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180105330040L});
    public static final BitSet FOLLOW_expr_in_synpred110_AliasMasker1831 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_synpred133_AliasMasker2208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred134_AliasMasker2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred135_AliasMasker2242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred161_AliasMasker2566 = new BitSet(new long[]{0x0010000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_set_in_synpred161_AliasMasker2568 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred161_AliasMasker2621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_join_item_in_synpred161_AliasMasker2624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred179_AliasMasker3041 = new BitSet(new long[]{0x0000000000000002L});

}