// $ANTLR 3.4 /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g 2014-09-17 14:41:19

package org.apache.pig.parser;

import org.apache.pig.data.DataType;
import org.apache.pig.impl.util.NumValCarrier;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


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
public class AstValidator extends TreeParser {
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


    public AstValidator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AstValidator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AstValidator.tokenNames; }
    public String getGrammarFileName() { return "/home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g"; }



    private static Log log = LogFactory.getLog( AstValidator.class );

    @Override
    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
    throws RecognitionException {
        throw new MismatchedTokenException( ttype, input );
    }

    @Override
    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
    throws RecognitionException {
        throw e;
    }

    private void validateSchemaAliasName(Set<String> fieldNames, CommonTree node, String name)
    throws DuplicatedSchemaAliasException {
        if( fieldNames.contains( name ) ) {
            throw new DuplicatedSchemaAliasException( input,
                new SourceLocation( (PigParserNode)node ), name );
        } else {
            fieldNames.add( name );
        }
    }

    private void validateAliasRef(Set<String> aliases, CommonTree node, String alias)
    throws UndefinedAliasException {
        if( !aliases.contains( alias ) ) {
            throw new UndefinedAliasException( input, new SourceLocation( (PigParserNode)node ), alias );
        }
    }

    private void checkDuplication(int count, CommonTree node) throws ParserValidationException {
        if( count > 1 ) {
            throw new ParserValidationException( input, new SourceLocation( (PigParserNode)node ),
                "Duplicated command option" );
        }
    }

    private String lastRel = null;

    private String getLastRel(CommonTree node) throws UndefinedAliasException {
        if (lastRel != null) {
            return lastRel;
        }
        throw new UndefinedAliasException( input, new SourceLocation((PigParserNode)node), "@");
    }

    private Set<String> aliases = new HashSet<String>() {
        @Override
        public boolean add(String e) {
            lastRel = e;
            return super.add(e);
        }
    };



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:113:1: query : ^( QUERY ( statement )* ) ;
    public final AstValidator.query_return query() throws RecognitionException {
        AstValidator.query_return retval = new AstValidator.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AstValidator.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:113:7: ( ^( QUERY ( statement )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:113:9: ^( QUERY ( statement )* )
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
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:113:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ASSERT||LA1_0==REGISTER||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:113:18: statement
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:116:1: statement : ( general_statement | split_statement | realias_statement | register_statement | assert_statement );
    public final AstValidator.statement_return statement() throws RecognitionException {
        AstValidator.statement_return retval = new AstValidator.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.general_statement_return general_statement3 =null;

        AstValidator.split_statement_return split_statement4 =null;

        AstValidator.realias_statement_return realias_statement5 =null;

        AstValidator.register_statement_return register_statement6 =null;

        AstValidator.assert_statement_return assert_statement7 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:116:11: ( general_statement | split_statement | realias_statement | register_statement | assert_statement )
            int alt2=5;
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
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:116:13: general_statement
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:117:13: split_statement
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:118:13: realias_statement
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:119:13: register_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_register_statement_in_statement136);
                    register_statement6=register_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, register_statement6.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:120:13: assert_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_statement_in_statement150);
                    assert_statement7=assert_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_statement7.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:123:1: split_statement : split_clause ;
    public final AstValidator.split_statement_return split_statement() throws RecognitionException {
        AstValidator.split_statement_return retval = new AstValidator.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.split_clause_return split_clause8 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:123:17: ( split_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:123:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement159);
            split_clause8=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause8.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:126:1: realias_statement : realias_clause ;
    public final AstValidator.realias_statement_return realias_statement() throws RecognitionException {
        AstValidator.realias_statement_return retval = new AstValidator.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.realias_clause_return realias_clause9 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:126:19: ( realias_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:126:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement168);
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


    public static class register_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "register_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:129:1: register_statement : ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) ;
    public final AstValidator.register_statement_return register_statement() throws RecognitionException {
        AstValidator.register_statement_return retval = new AstValidator.register_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REGISTER10=null;
        CommonTree QUOTEDSTRING11=null;
        CommonTree USING12=null;
        CommonTree IDENTIFIER13=null;
        CommonTree AS14=null;
        CommonTree IDENTIFIER15=null;

        CommonTree REGISTER10_tree=null;
        CommonTree QUOTEDSTRING11_tree=null;
        CommonTree USING12_tree=null;
        CommonTree IDENTIFIER13_tree=null;
        CommonTree AS14_tree=null;
        CommonTree IDENTIFIER15_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:129:20: ( ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:129:22: ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REGISTER10=(CommonTree)match(input,REGISTER,FOLLOW_REGISTER_in_register_statement179); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REGISTER10_tree = (CommonTree)adaptor.dupNode(REGISTER10);


            root_1 = (CommonTree)adaptor.becomeRoot(REGISTER10_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING11=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_register_statement181); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING11_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING11);


            adaptor.addChild(root_1, QUOTEDSTRING11_tree);
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:129:47: ( USING IDENTIFIER AS IDENTIFIER )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==USING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:129:48: USING IDENTIFIER AS IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    USING12=(CommonTree)match(input,USING,FOLLOW_USING_in_register_statement184); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING12_tree = (CommonTree)adaptor.dupNode(USING12);


                    adaptor.addChild(root_1, USING12_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER13=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement186); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER13_tree = (CommonTree)adaptor.dupNode(IDENTIFIER13);


                    adaptor.addChild(root_1, IDENTIFIER13_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    AS14=(CommonTree)match(input,AS,FOLLOW_AS_in_register_statement188); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS14_tree = (CommonTree)adaptor.dupNode(AS14);


                    adaptor.addChild(root_1, AS14_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER15=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement190); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER15_tree = (CommonTree)adaptor.dupNode(IDENTIFIER15);


                    adaptor.addChild(root_1, IDENTIFIER15_tree);
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
    // $ANTLR end "register_statement"


    public static class assert_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:132:1: assert_statement : assert_clause ;
    public final AstValidator.assert_statement_return assert_statement() throws RecognitionException {
        AstValidator.assert_statement_return retval = new AstValidator.assert_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.assert_clause_return assert_clause16 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:132:18: ( assert_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:132:20: assert_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assert_clause_in_assert_statement203);
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


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:135:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AstValidator.general_statement_return general_statement() throws RecognitionException {
        AstValidator.general_statement_return retval = new AstValidator.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT17=null;
        AstValidator.alias_return alias18 =null;

        AstValidator.op_clause_return op_clause19 =null;

        AstValidator.parallel_clause_return parallel_clause20 =null;


        CommonTree STATEMENT17_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:135:19: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:135:21: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT17=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement214); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT17_tree = (CommonTree)adaptor.dupNode(STATEMENT17);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT17_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:135:34: ( alias )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENTIFIER) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:135:36: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement218);
                    alias18=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias18.getTree());


                    if ( state.backtracking==0 ) { aliases.add( (alias18!=null?alias18.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement225);
            op_clause19=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause19.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:135:87: ( parallel_clause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PARALLEL) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:135:87: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement227);
                    parallel_clause20=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause20.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:138:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AstValidator.realias_clause_return realias_clause() throws RecognitionException {
        AstValidator.realias_clause_return retval = new AstValidator.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS21=null;
        CommonTree IDENTIFIER23=null;
        AstValidator.alias_return alias22 =null;


        CommonTree REALIAS21_tree=null;
        CommonTree IDENTIFIER23_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:138:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:138:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS21=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause240); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS21_tree = (CommonTree)adaptor.dupNode(REALIAS21);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS21_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause242);
            alias22=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias22.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER23=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause244); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER23_tree = (CommonTree)adaptor.dupNode(IDENTIFIER23);


            adaptor.addChild(root_1, IDENTIFIER23_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias22!=null?alias22.name:null) );
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:144:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AstValidator.parallel_clause_return parallel_clause() throws RecognitionException {
        AstValidator.parallel_clause_return retval = new AstValidator.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL24=null;
        CommonTree INTEGER25=null;

        CommonTree PARALLEL24_tree=null;
        CommonTree INTEGER25_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:144:17: ( ^( PARALLEL INTEGER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:144:19: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL24=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause261); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL24_tree = (CommonTree)adaptor.dupNode(PARALLEL24);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL24_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER25=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause263); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER25_tree = (CommonTree)adaptor.dupNode(INTEGER25);


            adaptor.addChild(root_1, INTEGER25_tree);
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
        public String name;
        public CommonTree node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:147:1: alias returns [String name, CommonTree node] : IDENTIFIER ;
    public final AstValidator.alias_return alias() throws RecognitionException {
        AstValidator.alias_return retval = new AstValidator.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER26=null;

        CommonTree IDENTIFIER26_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:148:2: ( IDENTIFIER )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:148:4: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER26=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias278); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER26_tree = (CommonTree)adaptor.dupNode(IDENTIFIER26);


            adaptor.addChild(root_0, IDENTIFIER26_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.name = (IDENTIFIER26!=null?IDENTIFIER26.getText():null);
                   retval.node = IDENTIFIER26;
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


    public static class previous_rel_return extends TreeRuleReturnScope {
        public String name;
        public CommonTree node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "previous_rel"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:155:1: previous_rel returns [String name, CommonTree node] : ARROBA ;
    public final AstValidator.previous_rel_return previous_rel() throws RecognitionException {
        AstValidator.previous_rel_return retval = new AstValidator.previous_rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARROBA27=null;

        CommonTree ARROBA27_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:156:2: ( ARROBA )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:156:4: ARROBA
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            ARROBA27=(CommonTree)match(input,ARROBA,FOLLOW_ARROBA_in_previous_rel296); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARROBA27_tree = (CommonTree)adaptor.dupNode(ARROBA27);


            adaptor.addChild(root_0, ARROBA27_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.name = getLastRel(ARROBA27);
                   retval.node = ARROBA27;
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
    // $ANTLR end "previous_rel"


    public static class op_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:163:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause );
    public final AstValidator.op_clause_return op_clause() throws RecognitionException {
        AstValidator.op_clause_return retval = new AstValidator.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.define_clause_return define_clause28 =null;

        AstValidator.load_clause_return load_clause29 =null;

        AstValidator.group_clause_return group_clause30 =null;

        AstValidator.store_clause_return store_clause31 =null;

        AstValidator.filter_clause_return filter_clause32 =null;

        AstValidator.distinct_clause_return distinct_clause33 =null;

        AstValidator.limit_clause_return limit_clause34 =null;

        AstValidator.sample_clause_return sample_clause35 =null;

        AstValidator.order_clause_return order_clause36 =null;

        AstValidator.rank_clause_return rank_clause37 =null;

        AstValidator.cross_clause_return cross_clause38 =null;

        AstValidator.join_clause_return join_clause39 =null;

        AstValidator.union_clause_return union_clause40 =null;

        AstValidator.stream_clause_return stream_clause41 =null;

        AstValidator.mr_clause_return mr_clause42 =null;

        AstValidator.split_clause_return split_clause43 =null;

        AstValidator.foreach_clause_return foreach_clause44 =null;

        AstValidator.cube_clause_return cube_clause45 =null;

        AstValidator.assert_clause_return assert_clause46 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:163:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause )
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:163:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause310);
                    define_clause28=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause28.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:164:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause324);
                    load_clause29=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause29.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:165:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause338);
                    group_clause30=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause30.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:166:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause352);
                    store_clause31=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause31.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:167:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause366);
                    filter_clause32=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause32.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:168:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause380);
                    distinct_clause33=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause33.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:169:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause394);
                    limit_clause34=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause34.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:170:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause408);
                    sample_clause35=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause35.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:171:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause422);
                    order_clause36=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause36.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:172:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause436);
                    rank_clause37=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause37.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:173:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause450);
                    cross_clause38=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause38.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:174:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause464);
                    join_clause39=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause39.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:175:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause478);
                    union_clause40=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause40.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:176:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause492);
                    stream_clause41=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause41.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:177:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause506);
                    mr_clause42=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause42.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:178:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause520);
                    split_clause43=split_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_clause43.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:179:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause534);
                    foreach_clause44=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause44.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:180:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause548);
                    cube_clause45=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause45.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:181:13: assert_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_clause_in_op_clause562);
                    assert_clause46=assert_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_clause46.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:184:1: define_clause : ^( DEFINE alias ( cmd | func_clause ) ) ;
    public final AstValidator.define_clause_return define_clause() throws RecognitionException {
        AstValidator.define_clause_return retval = new AstValidator.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE47=null;
        AstValidator.alias_return alias48 =null;

        AstValidator.cmd_return cmd49 =null;

        AstValidator.func_clause_return func_clause50 =null;


        CommonTree DEFINE47_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:184:15: ( ^( DEFINE alias ( cmd | func_clause ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:184:17: ^( DEFINE alias ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE47=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause573); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE47_tree = (CommonTree)adaptor.dupNode(DEFINE47);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE47_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_define_clause575);
            alias48=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias48.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:184:33: ( cmd | func_clause )
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:184:35: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause579);
                    cmd49=cmd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd49.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:184:41: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause583);
                    func_clause50=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause50.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:187:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AstValidator.cmd_return cmd() throws RecognitionException {
        AstValidator.cmd_return retval = new AstValidator.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND51=null;
        AstValidator.ship_clause_return ship_clause52 =null;

        AstValidator.cache_clause_return cache_clause53 =null;

        AstValidator.input_clause_return input_clause54 =null;

        AstValidator.output_clause_return output_clause55 =null;

        AstValidator.error_clause_return error_clause56 =null;


        CommonTree EXECCOMMAND51_tree=null;


            int ship = 0;
            int cache = 0;
            int in = 0;
            int out = 0;
            int error = 0;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:195:2: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:195:4: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND51=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd604); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND51_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND51);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND51_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:195:19: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
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
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:195:21: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd608);
                	    ship_clause52=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause52.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++ship, (ship_clause52!=null?((CommonTree)ship_clause52.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:196:21: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd632);
                	    cache_clause53=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause53.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++cache, (cache_clause53!=null?((CommonTree)cache_clause53.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:197:21: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd656);
                	    input_clause54=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause54.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++in, (input_clause54!=null?((CommonTree)input_clause54.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:198:21: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd680);
                	    output_clause55=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause55.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++out, (output_clause55!=null?((CommonTree)output_clause55.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:199:21: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd704);
                	    error_clause56=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause56.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++error, (error_clause56!=null?((CommonTree)error_clause56.start):null) ); }

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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:204:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AstValidator.ship_clause_return ship_clause() throws RecognitionException {
        AstValidator.ship_clause_return retval = new AstValidator.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP57=null;
        AstValidator.path_list_return path_list58 =null;


        CommonTree SHIP57_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:204:13: ( ^( SHIP ( path_list )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:204:15: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP57=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause743); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP57_tree = (CommonTree)adaptor.dupNode(SHIP57);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP57_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:204:23: ( path_list )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:204:23: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause745);
                        path_list58=path_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list58.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:207:1: path_list : ( QUOTEDSTRING )+ ;
    public final AstValidator.path_list_return path_list() throws RecognitionException {
        AstValidator.path_list_return retval = new AstValidator.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING59=null;

        CommonTree QUOTEDSTRING59_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:207:11: ( ( QUOTEDSTRING )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:207:13: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:207:13: ( QUOTEDSTRING )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:207:13: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING59=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list757); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING59_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING59);


            	    adaptor.addChild(root_0, QUOTEDSTRING59_tree);
            	    }


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:210:1: cache_clause : ^( CACHE path_list ) ;
    public final AstValidator.cache_clause_return cache_clause() throws RecognitionException {
        AstValidator.cache_clause_return retval = new AstValidator.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE60=null;
        AstValidator.path_list_return path_list61 =null;


        CommonTree CACHE60_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:210:14: ( ^( CACHE path_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:210:16: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE60=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause769); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE60_tree = (CommonTree)adaptor.dupNode(CACHE60);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE60_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause771);
            path_list61=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list61.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:213:1: input_clause : ^( INPUT ( stream_cmd )+ ) ;
    public final AstValidator.input_clause_return input_clause() throws RecognitionException {
        AstValidator.input_clause_return retval = new AstValidator.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT62=null;
        AstValidator.stream_cmd_return stream_cmd63 =null;


        CommonTree INPUT62_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:213:14: ( ^( INPUT ( stream_cmd )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:213:16: ^( INPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT62=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause784); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT62_tree = (CommonTree)adaptor.dupNode(INPUT62);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT62_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:213:25: ( stream_cmd )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==QUOTEDSTRING||(LA11_0 >= STDIN && LA11_0 <= STDOUT)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:213:25: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause786);
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
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:216:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AstValidator.stream_cmd_return stream_cmd() throws RecognitionException {
        AstValidator.stream_cmd_return retval = new AstValidator.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN64=null;
        CommonTree STDOUT66=null;
        CommonTree QUOTEDSTRING68=null;
        AstValidator.func_clause_return func_clause65 =null;

        AstValidator.func_clause_return func_clause67 =null;

        AstValidator.func_clause_return func_clause69 =null;


        CommonTree STDIN64_tree=null;
        CommonTree STDOUT66_tree=null;
        CommonTree QUOTEDSTRING68_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:216:12: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:216:14: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN64=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd800); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN64_tree = (CommonTree)adaptor.dupNode(STDIN64);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN64_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:216:23: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:216:23: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd802);
                                func_clause65=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause65.getTree());


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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:217:14: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT66=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd822); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT66_tree = (CommonTree)adaptor.dupNode(STDOUT66);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT66_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:217:24: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:217:24: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd824);
                                func_clause67=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause67.getTree());


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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:218:14: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING68=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd844); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING68_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING68);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING68_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:218:30: ( func_clause )?
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==FUNC||LA14_0==FUNC_REF) ) {
                            alt14=1;
                        }
                        switch (alt14) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:218:30: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd846);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:221:1: output_clause : ^( OUTPUT ( stream_cmd )+ ) ;
    public final AstValidator.output_clause_return output_clause() throws RecognitionException {
        AstValidator.output_clause_return retval = new AstValidator.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT70=null;
        AstValidator.stream_cmd_return stream_cmd71 =null;


        CommonTree OUTPUT70_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:221:15: ( ^( OUTPUT ( stream_cmd )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:221:17: ^( OUTPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT70=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause860); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT70_tree = (CommonTree)adaptor.dupNode(OUTPUT70);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT70_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:221:27: ( stream_cmd )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==QUOTEDSTRING||(LA16_0 >= STDIN && LA16_0 <= STDOUT)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:221:27: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause862);
            	    stream_cmd71=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd71.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:224:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AstValidator.error_clause_return error_clause() throws RecognitionException {
        AstValidator.error_clause_return retval = new AstValidator.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR72=null;
        CommonTree QUOTEDSTRING73=null;
        CommonTree INTEGER74=null;

        CommonTree STDERROR72_tree=null;
        CommonTree QUOTEDSTRING73_tree=null;
        CommonTree INTEGER74_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:224:14: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:224:16: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR72=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause876); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR72_tree = (CommonTree)adaptor.dupNode(STDERROR72);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR72_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:224:29: ( QUOTEDSTRING ( INTEGER )? )?
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==QUOTEDSTRING) ) {
                    alt18=1;
                }
                switch (alt18) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:224:31: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING73=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause881); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING73_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING73);


                        adaptor.addChild(root_1, QUOTEDSTRING73_tree);
                        }


                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:224:44: ( INTEGER )?
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==INTEGER) ) {
                            alt17=1;
                        }
                        switch (alt17) {
                            case 1 :
                                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:224:44: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER74=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause883); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER74_tree = (CommonTree)adaptor.dupNode(INTEGER74);


                                adaptor.addChild(root_1, INTEGER74_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:227:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AstValidator.load_clause_return load_clause() throws RecognitionException {
        AstValidator.load_clause_return retval = new AstValidator.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD75=null;
        AstValidator.filename_return filename76 =null;

        AstValidator.func_clause_return func_clause77 =null;

        AstValidator.as_clause_return as_clause78 =null;


        CommonTree LOAD75_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:227:13: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:227:15: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD75=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause900); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD75_tree = (CommonTree)adaptor.dupNode(LOAD75);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD75_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause902);
            filename76=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename76.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:227:32: ( func_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==FUNC||LA19_0==FUNC_REF) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:227:32: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause904);
                    func_clause77=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause77.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:227:45: ( as_clause )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==AS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:227:45: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause907);
                    as_clause78=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause78.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:230:1: filename : QUOTEDSTRING ;
    public final AstValidator.filename_return filename() throws RecognitionException {
        AstValidator.filename_return retval = new AstValidator.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING79=null;

        CommonTree QUOTEDSTRING79_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:230:10: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:230:12: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING79=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename919); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING79_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING79);


            adaptor.addChild(root_0, QUOTEDSTRING79_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:233:1: as_clause : ^( AS field_def_list ) ;
    public final AstValidator.as_clause_return as_clause() throws RecognitionException {
        AstValidator.as_clause_return retval = new AstValidator.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS80=null;
        AstValidator.field_def_list_return field_def_list81 =null;


        CommonTree AS80_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:233:10: ( ^( AS field_def_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:233:12: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS80=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause929); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS80_tree = (CommonTree)adaptor.dupNode(AS80);


            root_1 = (CommonTree)adaptor.becomeRoot(AS80_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause931);
            field_def_list81=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list81.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:236:1: field_def[Set<String> fieldNames, NumValCarrier nvc] : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) );
    public final AstValidator.field_def_return field_def(Set<String> fieldNames, NumValCarrier nvc) throws RecognitionException, DuplicatedSchemaAliasException {
        AstValidator.field_def_return retval = new AstValidator.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF82=null;
        CommonTree IDENTIFIER83=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER85=null;
        AstValidator.type_return type84 =null;

        AstValidator.type_return type86 =null;


        CommonTree FIELD_DEF82_tree=null;
        CommonTree IDENTIFIER83_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER85_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:237:2: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==FIELD_DEF) ) {
                alt22=1;
            }
            else if ( (LA22_0==FIELD_DEF_WITHOUT_IDENTIFIER) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:237:4: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF82=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def950); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF82_tree = (CommonTree)adaptor.dupNode(FIELD_DEF82);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF82_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER83=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER83_tree = (CommonTree)adaptor.dupNode(IDENTIFIER83);


                    adaptor.addChild(root_1, IDENTIFIER83_tree);
                    }


                    if ( state.backtracking==0 ) { validateSchemaAliasName( fieldNames, IDENTIFIER83, (IDENTIFIER83!=null?IDENTIFIER83.getText():null) ); }

                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:237:102: ( type )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==BIGDECIMAL||LA21_0==BIGINTEGER||LA21_0==BOOLEAN||LA21_0==BYTEARRAY||LA21_0==CHARARRAY||LA21_0==DATETIME||LA21_0==DOUBLE||LA21_0==FLOAT||LA21_0==INT||LA21_0==LONG||LA21_0==BAG_TYPE||LA21_0==MAP_TYPE||LA21_0==TUPLE_TYPE) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:237:102: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def956);
                            type84=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type84.getTree());


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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:238:4: ^( FIELD_DEF_WITHOUT_IDENTIFIER type )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER85=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def966); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER85_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER85);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER85_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def968);
                    type86=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type86.getTree());


                    if ( state.backtracking==0 ) { validateSchemaAliasName ( fieldNames, FIELD_DEF_WITHOUT_IDENTIFIER85, nvc.makeNameFromDataType ( (type86!=null?type86.typev:0) ) ); }

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


    protected static class field_def_list_scope {
        Set<String> fieldNames;
        NumValCarrier nvc;
    }
    protected Stack field_def_list_stack = new Stack();


    public static class field_def_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:241:1: field_def_list : ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+ ;
    public final AstValidator.field_def_list_return field_def_list() throws RecognitionException, DuplicatedSchemaAliasException {
        field_def_list_stack.push(new field_def_list_scope());
        AstValidator.field_def_list_return retval = new AstValidator.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.field_def_return field_def87 =null;




            ((field_def_list_scope)field_def_list_stack.peek()).fieldNames = new HashSet<String>();
            ((field_def_list_scope)field_def_list_stack.peek()).nvc = new NumValCarrier();

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:250:2: ( ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:250:4: ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:250:4: ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0 >= FIELD_DEF && LA23_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:250:6: field_def[$field_def_list::fieldNames, $field_def_list::nvc]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list996);
            	    field_def87=field_def(((field_def_list_scope)field_def_list_stack.peek()).fieldNames, ((field_def_list_scope)field_def_list_stack.peek()).nvc);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def87.getTree());


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
            field_def_list_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        public byte typev;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:253:1: type returns [byte typev] : ( simple_type | tuple_type | bag_type | map_type );
    public final AstValidator.type_return type() throws RecognitionException {
        AstValidator.type_return retval = new AstValidator.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.simple_type_return simple_type88 =null;

        AstValidator.tuple_type_return tuple_type89 =null;

        AstValidator.bag_type_return bag_type90 =null;

        AstValidator.map_type_return map_type91 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:254:3: ( simple_type | tuple_type | bag_type | map_type )
            int alt24=4;
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
                alt24=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt24=2;
                }
                break;
            case BAG_TYPE:
                {
                alt24=3;
                }
                break;
            case MAP_TYPE:
                {
                alt24=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:254:5: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type1015);
                    simple_type88=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type88.getTree());


                    if ( state.backtracking==0 ) { retval.typev = (simple_type88!=null?simple_type88.typev:0); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:255:5: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type1023);
                    tuple_type89=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type89.getTree());


                    if ( state.backtracking==0 ) { retval.typev = DataType.TUPLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:256:5: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type1031);
                    bag_type90=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type90.getTree());


                    if ( state.backtracking==0 ) { retval.typev = DataType.BAG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:257:5: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type1039);
                    map_type91=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type91.getTree());


                    if ( state.backtracking==0 ) { retval.typev = DataType.MAP; }

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
        public byte typev;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:260:1: simple_type returns [byte typev] : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY );
    public final AstValidator.simple_type_return simple_type() throws RecognitionException {
        AstValidator.simple_type_return retval = new AstValidator.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN92=null;
        CommonTree INT93=null;
        CommonTree LONG94=null;
        CommonTree FLOAT95=null;
        CommonTree DOUBLE96=null;
        CommonTree BIGINTEGER97=null;
        CommonTree BIGDECIMAL98=null;
        CommonTree DATETIME99=null;
        CommonTree CHARARRAY100=null;
        CommonTree BYTEARRAY101=null;

        CommonTree BOOLEAN92_tree=null;
        CommonTree INT93_tree=null;
        CommonTree LONG94_tree=null;
        CommonTree FLOAT95_tree=null;
        CommonTree DOUBLE96_tree=null;
        CommonTree BIGINTEGER97_tree=null;
        CommonTree BIGDECIMAL98_tree=null;
        CommonTree DATETIME99_tree=null;
        CommonTree CHARARRAY100_tree=null;
        CommonTree BYTEARRAY101_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:261:3: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY )
            int alt25=10;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt25=1;
                }
                break;
            case INT:
                {
                alt25=2;
                }
                break;
            case LONG:
                {
                alt25=3;
                }
                break;
            case FLOAT:
                {
                alt25=4;
                }
                break;
            case DOUBLE:
                {
                alt25=5;
                }
                break;
            case BIGINTEGER:
                {
                alt25=6;
                }
                break;
            case BIGDECIMAL:
                {
                alt25=7;
                }
                break;
            case DATETIME:
                {
                alt25=8;
                }
                break;
            case CHARARRAY:
                {
                alt25=9;
                }
                break;
            case BYTEARRAY:
                {
                alt25=10;
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:261:5: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN92=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1056); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN92_tree = (CommonTree)adaptor.dupNode(BOOLEAN92);


                    adaptor.addChild(root_0, BOOLEAN92_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BOOLEAN; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:262:5: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT93=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1064); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT93_tree = (CommonTree)adaptor.dupNode(INT93);


                    adaptor.addChild(root_0, INT93_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.INTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:263:5: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG94=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1072); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG94_tree = (CommonTree)adaptor.dupNode(LONG94);


                    adaptor.addChild(root_0, LONG94_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.LONG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:264:5: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT95=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1080); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT95_tree = (CommonTree)adaptor.dupNode(FLOAT95);


                    adaptor.addChild(root_0, FLOAT95_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.FLOAT; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:265:5: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE96=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1088); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE96_tree = (CommonTree)adaptor.dupNode(DOUBLE96);


                    adaptor.addChild(root_0, DOUBLE96_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.DOUBLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:266:5: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER97=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_simple_type1096); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER97_tree = (CommonTree)adaptor.dupNode(BIGINTEGER97);


                    adaptor.addChild(root_0, BIGINTEGER97_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BIGINTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:267:5: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL98=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_simple_type1104); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL98_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL98);


                    adaptor.addChild(root_0, BIGDECIMAL98_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BIGDECIMAL; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:268:5: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME99=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1112); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME99_tree = (CommonTree)adaptor.dupNode(DATETIME99);


                    adaptor.addChild(root_0, DATETIME99_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.DATETIME; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:269:5: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY100=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1120); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY100_tree = (CommonTree)adaptor.dupNode(CHARARRAY100);


                    adaptor.addChild(root_0, CHARARRAY100_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.CHARARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:270:5: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY101=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1128); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY101_tree = (CommonTree)adaptor.dupNode(BYTEARRAY101);


                    adaptor.addChild(root_0, BYTEARRAY101_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BYTEARRAY; }

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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:273:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AstValidator.tuple_type_return tuple_type() throws RecognitionException {
        AstValidator.tuple_type_return retval = new AstValidator.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE102=null;
        AstValidator.field_def_list_return field_def_list103 =null;


        CommonTree TUPLE_TYPE102_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:273:12: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:273:14: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE102=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1141); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE102_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE102);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE102_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:273:28: ( field_def_list )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0 >= FIELD_DEF && LA26_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:273:28: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1143);
                        field_def_list103=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list103.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:276:1: bag_type : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final AstValidator.bag_type_return bag_type() throws RecognitionException {
        AstValidator.bag_type_return retval = new AstValidator.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE104=null;
        CommonTree IDENTIFIER105=null;
        AstValidator.tuple_type_return tuple_type106 =null;


        CommonTree BAG_TYPE104_tree=null;
        CommonTree IDENTIFIER105_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:276:10: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:276:12: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE104=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1157); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE104_tree = (CommonTree)adaptor.dupNode(BAG_TYPE104);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE104_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:276:24: ( IDENTIFIER )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDENTIFIER) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:276:24: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER105=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1159); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER105_tree = (CommonTree)adaptor.dupNode(IDENTIFIER105);


                        adaptor.addChild(root_1, IDENTIFIER105_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:276:36: ( tuple_type )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==TUPLE_TYPE) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:276:36: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1162);
                        tuple_type106=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type106.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:279:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AstValidator.map_type_return map_type() throws RecognitionException {
        AstValidator.map_type_return retval = new AstValidator.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE107=null;
        AstValidator.type_return type108 =null;


        CommonTree MAP_TYPE107_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:279:10: ( ^( MAP_TYPE ( type )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:279:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE107=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1176); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE107_tree = (CommonTree)adaptor.dupNode(MAP_TYPE107);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE107_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:279:24: ( type )?
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==BIGDECIMAL||LA29_0==BIGINTEGER||LA29_0==BOOLEAN||LA29_0==BYTEARRAY||LA29_0==CHARARRAY||LA29_0==DATETIME||LA29_0==DOUBLE||LA29_0==FLOAT||LA29_0==INT||LA29_0==LONG||LA29_0==BAG_TYPE||LA29_0==MAP_TYPE||LA29_0==TUPLE_TYPE) ) {
                    alt29=1;
                }
                switch (alt29) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:279:24: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1178);
                        type108=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type108.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:282:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AstValidator.func_clause_return func_clause() throws RecognitionException {
        AstValidator.func_clause_return retval = new AstValidator.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF109=null;
        CommonTree FUNC111=null;
        AstValidator.func_name_return func_name110 =null;

        AstValidator.func_name_return func_name112 =null;

        AstValidator.func_args_return func_args113 =null;


        CommonTree FUNC_REF109_tree=null;
        CommonTree FUNC111_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:282:13: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==FUNC_REF) ) {
                alt31=1;
            }
            else if ( (LA31_0==FUNC) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }
            switch (alt31) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:282:15: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF109=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1192); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF109_tree = (CommonTree)adaptor.dupNode(FUNC_REF109);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF109_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1194);
                    func_name110=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name110.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:283:15: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC111=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1214); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC111_tree = (CommonTree)adaptor.dupNode(FUNC111);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC111_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1216);
                    func_name112=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name112.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:283:33: ( func_args )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==MULTILINE_QUOTEDSTRING||LA30_0==QUOTEDSTRING) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:283:33: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1218);
                            func_args113=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args113.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:286:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AstValidator.func_name_return func_name() throws RecognitionException {
        AstValidator.func_name_return retval = new AstValidator.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set115=null;
        AstValidator.eid_return eid114 =null;

        AstValidator.eid_return eid116 =null;


        CommonTree set115_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:286:11: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:286:13: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1230);
            eid114=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid114.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:286:17: ( ( PERIOD | DOLLAR ) eid )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==DOLLAR||LA32_0==PERIOD) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:286:19: ( PERIOD | DOLLAR ) eid
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    set115=(CommonTree)input.LT(1);

            	    if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) {
            	        set115_tree = (CommonTree)adaptor.dupNode(set115);


            	        adaptor.addChild(root_0, set115_tree);
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
            	    pushFollow(FOLLOW_eid_in_func_name1244);
            	    eid116=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid116.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop32;
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


    public static class func_args_string_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args_string"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:289:1: func_args_string : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING );
    public final AstValidator.func_args_string_return func_args_string() throws RecognitionException {
        AstValidator.func_args_string_return retval = new AstValidator.func_args_string_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set117=null;

        CommonTree set117_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:289:18: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set117=(CommonTree)input.LT(1);

            if ( input.LA(1)==MULTILINE_QUOTEDSTRING||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set117_tree = (CommonTree)adaptor.dupNode(set117);


                adaptor.addChild(root_0, set117_tree);
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
    // $ANTLR end "func_args_string"


    public static class func_args_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:292:1: func_args : ( func_args_string )+ ;
    public final AstValidator.func_args_return func_args() throws RecognitionException {
        AstValidator.func_args_return retval = new AstValidator.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.func_args_string_return func_args_string118 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:292:11: ( ( func_args_string )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:292:13: ( func_args_string )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:292:13: ( func_args_string )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==MULTILINE_QUOTEDSTRING||LA33_0==QUOTEDSTRING) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:292:13: func_args_string
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_func_args_string_in_func_args1269);
            	    func_args_string118=func_args_string();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, func_args_string118.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:295:1: cube_clause : ^( CUBE cube_item ) ;
    public final AstValidator.cube_clause_return cube_clause() throws RecognitionException {
        AstValidator.cube_clause_return retval = new AstValidator.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE119=null;
        AstValidator.cube_item_return cube_item120 =null;


        CommonTree CUBE119_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:296:2: ( ^( CUBE cube_item ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:296:4: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE119=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1282); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE119_tree = (CommonTree)adaptor.dupNode(CUBE119);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE119_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1284);
            cube_item120=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item120.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:299:1: pivot_clause : ^( PIVOT INTEGER ) ;
    public final AstValidator.pivot_clause_return pivot_clause() throws RecognitionException {
        AstValidator.pivot_clause_return retval = new AstValidator.pivot_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PIVOT121=null;
        CommonTree INTEGER122=null;

        CommonTree PIVOT121_tree=null;
        CommonTree INTEGER122_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:300:5: ( ^( PIVOT INTEGER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:300:7: ^( PIVOT INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PIVOT121=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_pivot_clause1301); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PIVOT121_tree = (CommonTree)adaptor.dupNode(PIVOT121);


            root_1 = (CommonTree)adaptor.becomeRoot(PIVOT121_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER122=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_pivot_clause1303); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER122_tree = (CommonTree)adaptor.dupNode(INTEGER122);


            adaptor.addChild(root_1, INTEGER122_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:303:1: cube_item : rel ( cube_by_clause ) ;
    public final AstValidator.cube_item_return cube_item() throws RecognitionException {
        AstValidator.cube_item_return retval = new AstValidator.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.rel_return rel123 =null;

        AstValidator.cube_by_clause_return cube_by_clause124 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:304:2: ( rel ( cube_by_clause ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:304:4: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1315);
            rel123=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel123.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:304:8: ( cube_by_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:304:10: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1319);
            cube_by_clause124=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause124.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:307:1: cube_by_clause : ^( BY cube_or_rollup ) ;
    public final AstValidator.cube_by_clause_return cube_by_clause() throws RecognitionException {
        AstValidator.cube_by_clause_return retval = new AstValidator.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY125=null;
        AstValidator.cube_or_rollup_return cube_or_rollup126 =null;


        CommonTree BY125_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:308:2: ( ^( BY cube_or_rollup ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:308:4: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY125=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1333); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY125_tree = (CommonTree)adaptor.dupNode(BY125);


            root_1 = (CommonTree)adaptor.becomeRoot(BY125_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1335);
            cube_or_rollup126=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup126.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:311:1: cube_or_rollup : ( cube_rollup_list )+ ;
    public final AstValidator.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        AstValidator.cube_or_rollup_return retval = new AstValidator.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.cube_rollup_list_return cube_rollup_list127 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:312:2: ( ( cube_rollup_list )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:312:4: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:312:4: ( cube_rollup_list )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==CUBE||LA34_0==ROLLUP) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:312:4: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1347);
            	    cube_rollup_list127=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list127.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:315:1: cube_rollup_list : ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ( pivot_clause )? ) );
    public final AstValidator.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        AstValidator.cube_rollup_list_return retval = new AstValidator.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE128=null;
        CommonTree ROLLUP130=null;
        AstValidator.cube_by_expr_list_return cube_by_expr_list129 =null;

        AstValidator.cube_by_expr_list_return cube_by_expr_list131 =null;

        AstValidator.pivot_clause_return pivot_clause132 =null;


        CommonTree CUBE128_tree=null;
        CommonTree ROLLUP130_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:316:2: ( ^( CUBE cube_by_expr_list ) | ^( ROLLUP cube_by_expr_list ( pivot_clause )? ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==CUBE) ) {
                alt36=1;
            }
            else if ( (LA36_0==ROLLUP) ) {
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:316:4: ^( CUBE cube_by_expr_list )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CUBE128=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_rollup_list1360); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE128_tree = (CommonTree)adaptor.dupNode(CUBE128);


                    root_1 = (CommonTree)adaptor.becomeRoot(CUBE128_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1362);
                    cube_by_expr_list129=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list129.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:316:34: ^( ROLLUP cube_by_expr_list ( pivot_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    ROLLUP130=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_cube_rollup_list1370); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP130_tree = (CommonTree)adaptor.dupNode(ROLLUP130);


                    root_1 = (CommonTree)adaptor.becomeRoot(ROLLUP130_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1372);
                    cube_by_expr_list131=cube_by_expr_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cube_by_expr_list131.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:316:62: ( pivot_clause )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==PIVOT) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:316:62: pivot_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_pivot_clause_in_cube_rollup_list1374);
                            pivot_clause132=pivot_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, pivot_clause132.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:319:1: cube_by_expr_list : ( cube_by_expr )+ ;
    public final AstValidator.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        AstValidator.cube_by_expr_list_return retval = new AstValidator.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.cube_by_expr_return cube_by_expr133 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:320:2: ( ( cube_by_expr )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:320:4: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:320:4: ( cube_by_expr )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==BIGDECIMALNUMBER||LA37_0==BIGINTEGERNUMBER||LA37_0==CUBE||LA37_0==DIV||LA37_0==DOLLARVAR||LA37_0==DOUBLENUMBER||LA37_0==FALSE||LA37_0==FLOATNUMBER||LA37_0==GROUP||LA37_0==IDENTIFIER||LA37_0==INTEGER||LA37_0==LONGINTEGER||LA37_0==MINUS||LA37_0==NULL||LA37_0==PERCENT||LA37_0==PLUS||LA37_0==QUOTEDSTRING||LA37_0==STAR||LA37_0==TRUE||(LA37_0 >= BAG_VAL && LA37_0 <= BIN_EXPR)||(LA37_0 >= CASE_COND && LA37_0 <= CASE_EXPR)||(LA37_0 >= CAST_EXPR && LA37_0 <= EXPR_IN_PAREN)||LA37_0==FUNC_EVAL||LA37_0==INVOKER_FUNC_EVAL||(LA37_0 >= MAP_VAL && LA37_0 <= NEG)||LA37_0==TUPLE_VAL) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:320:4: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1387);
            	    cube_by_expr133=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr133.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:323:1: cube_by_expr : ( col_range | expr | STAR );
    public final AstValidator.cube_by_expr_return cube_by_expr() throws RecognitionException {
        AstValidator.cube_by_expr_return retval = new AstValidator.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR136=null;
        AstValidator.col_range_return col_range134 =null;

        AstValidator.expr_return expr135 =null;


        CommonTree STAR136_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:324:2: ( col_range | expr | STAR )
            int alt38=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt38=1;
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
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt38=2;
                }
                break;
            case STAR:
                {
                int LA38_3 = input.LA(2);

                if ( (LA38_3==DOWN) ) {
                    alt38=2;
                }
                else if ( (LA38_3==EOF||LA38_3==UP||LA38_3==BIGDECIMALNUMBER||LA38_3==BIGINTEGERNUMBER||LA38_3==CUBE||LA38_3==DIV||LA38_3==DOLLARVAR||LA38_3==DOUBLENUMBER||LA38_3==FALSE||LA38_3==FLOATNUMBER||LA38_3==GROUP||LA38_3==IDENTIFIER||LA38_3==INTEGER||LA38_3==LONGINTEGER||LA38_3==MINUS||LA38_3==NULL||LA38_3==PERCENT||(LA38_3 >= PIVOT && LA38_3 <= PLUS)||LA38_3==QUOTEDSTRING||LA38_3==STAR||LA38_3==TRUE||(LA38_3 >= BAG_VAL && LA38_3 <= BIN_EXPR)||(LA38_3 >= CASE_COND && LA38_3 <= CASE_EXPR)||(LA38_3 >= CAST_EXPR && LA38_3 <= EXPR_IN_PAREN)||LA38_3==FUNC_EVAL||LA38_3==INVOKER_FUNC_EVAL||(LA38_3 >= MAP_VAL && LA38_3 <= NEG)||LA38_3==TUPLE_VAL) ) {
                    alt38=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }

            switch (alt38) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:324:4: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1398);
                    col_range134=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range134.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:324:16: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1402);
                    expr135=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr135.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:324:23: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR136=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1406); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR136_tree = (CommonTree)adaptor.dupNode(STAR136);


                    adaptor.addChild(root_0, STAR136_tree);
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


    protected static class group_clause_scope {
        int arity;
    }
    protected Stack group_clause_stack = new Stack();


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:327:1: group_clause : ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) ;
    public final AstValidator.group_clause_return group_clause() throws RecognitionException {
        group_clause_stack.push(new group_clause_scope());
        AstValidator.group_clause_return retval = new AstValidator.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set137=null;
        AstValidator.group_item_return group_item138 =null;

        AstValidator.group_type_return group_type139 =null;

        AstValidator.partition_clause_return partition_clause140 =null;


        CommonTree set137_tree=null;


            ((group_clause_scope)group_clause_stack.peek()).arity = 0;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:334:2: ( ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:334:4: ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set137=(CommonTree)input.LT(1);

            if ( input.LA(1)==COGROUP||input.LA(1)==GROUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set137_tree = (CommonTree)adaptor.dupNode(set137);


                root_1 = (CommonTree)adaptor.becomeRoot(set137_tree, root_1);
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
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:334:27: ( group_item )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==ARROBA||LA39_0==ASSERT||LA39_0==COGROUP||(LA39_0 >= CROSS && LA39_0 <= CUBE)||LA39_0==DEFINE||LA39_0==DISTINCT||LA39_0==FILTER||LA39_0==FOREACH||LA39_0==GROUP||LA39_0==IDENTIFIER||LA39_0==JOIN||(LA39_0 >= LIMIT && LA39_0 <= LOAD)||LA39_0==MAPREDUCE||LA39_0==ORDER||LA39_0==RANK||LA39_0==SAMPLE||LA39_0==SPLIT||(LA39_0 >= STORE && LA39_0 <= STREAM)||LA39_0==UNION) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:334:27: group_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1437);
            	    group_item138=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item138.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt39 >= 1 ) break loop39;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
            } while (true);


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:334:39: ( group_type )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==QUOTEDSTRING) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:334:39: group_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1440);
                    group_type139=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type139.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:334:51: ( partition_clause )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==PARTITION) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:334:51: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1443);
                    partition_clause140=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause140.getTree());


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
            group_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:337:1: group_type : QUOTEDSTRING ;
    public final AstValidator.group_type_return group_type() throws RecognitionException {
        AstValidator.group_type_return retval = new AstValidator.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING141=null;

        CommonTree QUOTEDSTRING141_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:337:12: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:337:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING141=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1455); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING141_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING141);


            adaptor.addChild(root_0, QUOTEDSTRING141_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:340:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AstValidator.group_item_return group_item() throws RecognitionException {
        AstValidator.group_item_return retval = new AstValidator.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL144=null;
        CommonTree ANY145=null;
        CommonTree set146=null;
        AstValidator.rel_return rel142 =null;

        AstValidator.join_group_by_clause_return join_group_by_clause143 =null;


        CommonTree ALL144_tree=null;
        CommonTree ANY145_tree=null;
        CommonTree set146_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:341:2: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:341:4: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1465);
            rel142=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel142.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:341:8: ( join_group_by_clause | ALL | ANY )
            int alt42=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt42=1;
                }
                break;
            case ALL:
                {
                alt42=2;
                }
                break;
            case ANY:
                {
                alt42=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }

            switch (alt42) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:341:10: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1469);
                    join_group_by_clause143=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause143.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:341:33: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL144=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1473); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL144_tree = (CommonTree)adaptor.dupNode(ALL144);


                    adaptor.addChild(root_0, ALL144_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:341:39: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY145=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1477); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY145_tree = (CommonTree)adaptor.dupNode(ANY145);


                    adaptor.addChild(root_0, ANY145_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:341:45: ( INNER | OUTER )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==INNER||LA43_0==OUTER) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set146=(CommonTree)input.LT(1);

                    if ( input.LA(1)==INNER||input.LA(1)==OUTER ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set146_tree = (CommonTree)adaptor.dupNode(set146);


                        adaptor.addChild(root_0, set146_tree);
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
                   if( ((group_clause_scope)group_clause_stack.peek()).arity == 0 ) {
                       // For the first input
                       ((group_clause_scope)group_clause_stack.peek()).arity = (join_group_by_clause143!=null?join_group_by_clause143.exprCount:0);
                   } else if( (join_group_by_clause143!=null?join_group_by_clause143.exprCount:0) != ((group_clause_scope)group_clause_stack.peek()).arity ) {
                       throw new ParserValidationException( input, new SourceLocation( (PigParserNode)((CommonTree)retval.start) ),
                           "The arity of the group by columns do not match." );
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
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:353:1: rel : ( alias | previous_rel | op_clause ( parallel_clause )? );
    public final AstValidator.rel_return rel() throws RecognitionException {
        AstValidator.rel_return retval = new AstValidator.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.alias_return alias147 =null;

        AstValidator.previous_rel_return previous_rel148 =null;

        AstValidator.op_clause_return op_clause149 =null;

        AstValidator.parallel_clause_return parallel_clause150 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:353:5: ( alias | previous_rel | op_clause ( parallel_clause )? )
            int alt45=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt45=1;
                }
                break;
            case ARROBA:
                {
                alt45=2;
                }
                break;
            case ASSERT:
            case COGROUP:
            case CROSS:
            case CUBE:
            case DEFINE:
            case DISTINCT:
            case FILTER:
            case FOREACH:
            case GROUP:
            case JOIN:
            case LIMIT:
            case LOAD:
            case MAPREDUCE:
            case ORDER:
            case RANK:
            case SAMPLE:
            case SPLIT:
            case STORE:
            case STREAM:
            case UNION:
                {
                alt45=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:353:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1504);
                    alias147=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias147.getTree());


                    if ( state.backtracking==0 ) {  validateAliasRef( aliases, (alias147!=null?alias147.node:null), (alias147!=null?alias147.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:354:7: previous_rel
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_previous_rel_in_rel1514);
                    previous_rel148=previous_rel();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, previous_rel148.getTree());


                    if ( state.backtracking==0 ) { validateAliasRef( aliases, (previous_rel148!=null?previous_rel148.node:null), (previous_rel148!=null?previous_rel148.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:355:7: op_clause ( parallel_clause )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1524);
                    op_clause149=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause149.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:355:17: ( parallel_clause )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==PARALLEL) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:355:17: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1526);
                            parallel_clause150=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause150.getTree());


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
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:358:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AstValidator.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AstValidator.flatten_generated_item_return retval = new AstValidator.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR154=null;
        AstValidator.flatten_clause_return flatten_clause151 =null;

        AstValidator.col_range_return col_range152 =null;

        AstValidator.expr_return expr153 =null;

        AstValidator.field_def_list_return field_def_list155 =null;


        CommonTree STAR154_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:358:24: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:358:26: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:358:26: ( flatten_clause | col_range | expr | STAR )
            int alt46=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt46=1;
                }
                break;
            case COL_RANGE:
                {
                alt46=2;
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
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt46=3;
                }
                break;
            case STAR:
                {
                int LA46_4 = input.LA(2);

                if ( (LA46_4==DOWN) ) {
                    alt46=3;
                }
                else if ( (LA46_4==EOF||LA46_4==UP||LA46_4==BIGDECIMALNUMBER||LA46_4==BIGINTEGERNUMBER||LA46_4==CUBE||LA46_4==DIV||LA46_4==DOLLARVAR||LA46_4==DOUBLENUMBER||LA46_4==FALSE||LA46_4==FLATTEN||LA46_4==FLOATNUMBER||LA46_4==GROUP||LA46_4==IDENTIFIER||LA46_4==INTEGER||LA46_4==LONGINTEGER||LA46_4==MINUS||LA46_4==NULL||LA46_4==PERCENT||LA46_4==PLUS||LA46_4==QUOTEDSTRING||LA46_4==STAR||LA46_4==TRUE||(LA46_4 >= BAG_VAL && LA46_4 <= BIN_EXPR)||(LA46_4 >= CASE_COND && LA46_4 <= CASE_EXPR)||(LA46_4 >= CAST_EXPR && LA46_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA46_4==FUNC_EVAL||LA46_4==INVOKER_FUNC_EVAL||(LA46_4 >= MAP_VAL && LA46_4 <= NEG)||LA46_4==TUPLE_VAL) ) {
                    alt46=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 4, input);

                    throw nvae;

                }
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:358:28: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1538);
                    flatten_clause151=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause151.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:358:45: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1542);
                    col_range152=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range152.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:358:57: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1546);
                    expr153=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr153.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:358:64: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR154=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1550); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR154_tree = (CommonTree)adaptor.dupNode(STAR154);


                    adaptor.addChild(root_0, STAR154_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:358:71: ( field_def_list )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0 >= FIELD_DEF && LA47_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:358:71: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1554);
                    field_def_list155=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list155.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:361:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AstValidator.flatten_clause_return flatten_clause() throws RecognitionException {
        AstValidator.flatten_clause_return retval = new AstValidator.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN156=null;
        AstValidator.expr_return expr157 =null;


        CommonTree FLATTEN156_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:361:16: ( ^( FLATTEN expr ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:361:18: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN156=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1566); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN156_tree = (CommonTree)adaptor.dupNode(FLATTEN156);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN156_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1568);
            expr157=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr157.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:364:1: store_clause : ^( STORE rel filename ( func_clause )? ) ;
    public final AstValidator.store_clause_return store_clause() throws RecognitionException {
        AstValidator.store_clause_return retval = new AstValidator.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE158=null;
        AstValidator.rel_return rel159 =null;

        AstValidator.filename_return filename160 =null;

        AstValidator.func_clause_return func_clause161 =null;


        CommonTree STORE158_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:364:14: ( ^( STORE rel filename ( func_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:364:16: ^( STORE rel filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE158=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1581); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE158_tree = (CommonTree)adaptor.dupNode(STORE158);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE158_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause1583);
            rel159=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel159.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1585);
            filename160=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename160.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:364:38: ( func_clause )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==FUNC||LA48_0==FUNC_REF) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:364:38: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1587);
                    func_clause161=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause161.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:367:1: assert_clause : ^( ASSERT rel cond ( comment )? ) ;
    public final AstValidator.assert_clause_return assert_clause() throws RecognitionException {
        AstValidator.assert_clause_return retval = new AstValidator.assert_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSERT162=null;
        AstValidator.rel_return rel163 =null;

        AstValidator.cond_return cond164 =null;

        AstValidator.comment_return comment165 =null;


        CommonTree ASSERT162_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:367:15: ( ^( ASSERT rel cond ( comment )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:367:17: ^( ASSERT rel cond ( comment )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSERT162=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause1601); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSERT162_tree = (CommonTree)adaptor.dupNode(ASSERT162);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSERT162_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_assert_clause1603);
            rel163=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel163.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_assert_clause1605);
            cond164=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond164.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:367:36: ( comment )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==QUOTEDSTRING) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:367:36: comment
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comment_in_assert_clause1607);
                    comment165=comment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, comment165.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:370:1: comment : QUOTEDSTRING ;
    public final AstValidator.comment_return comment() throws RecognitionException {
        AstValidator.comment_return retval = new AstValidator.comment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING166=null;

        CommonTree QUOTEDSTRING166_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:370:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:370:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING166=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_comment1620); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING166_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING166);


            adaptor.addChild(root_0, QUOTEDSTRING166_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:373:1: filter_clause : ^( FILTER rel cond ) ;
    public final AstValidator.filter_clause_return filter_clause() throws RecognitionException {
        AstValidator.filter_clause_return retval = new AstValidator.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER167=null;
        AstValidator.rel_return rel168 =null;

        AstValidator.cond_return cond169 =null;


        CommonTree FILTER167_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:373:15: ( ^( FILTER rel cond ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:373:17: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER167=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1631); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER167_tree = (CommonTree)adaptor.dupNode(FILTER167);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER167_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1633);
            rel168=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel168.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1635);
            cond169=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond169.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:376:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) );
    public final AstValidator.cond_return cond() throws RecognitionException {
        AstValidator.cond_return retval = new AstValidator.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR170=null;
        CommonTree AND173=null;
        CommonTree NOT176=null;
        CommonTree NULL178=null;
        CommonTree NOT180=null;
        CommonTree BOOL_COND186=null;
        AstValidator.cond_return cond171 =null;

        AstValidator.cond_return cond172 =null;

        AstValidator.cond_return cond174 =null;

        AstValidator.cond_return cond175 =null;

        AstValidator.cond_return cond177 =null;

        AstValidator.expr_return expr179 =null;

        AstValidator.rel_op_return rel_op181 =null;

        AstValidator.expr_return expr182 =null;

        AstValidator.expr_return expr183 =null;

        AstValidator.in_eval_return in_eval184 =null;

        AstValidator.func_eval_return func_eval185 =null;

        AstValidator.expr_return expr187 =null;


        CommonTree OR170_tree=null;
        CommonTree AND173_tree=null;
        CommonTree NOT176_tree=null;
        CommonTree NULL178_tree=null;
        CommonTree NOT180_tree=null;
        CommonTree BOOL_COND186_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:376:6: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) )
            int alt51=8;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt51=1;
                }
                break;
            case AND:
                {
                alt51=2;
                }
                break;
            case NOT:
                {
                alt51=3;
                }
                break;
            case NULL:
                {
                alt51=4;
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
                alt51=5;
                }
                break;
            case IN:
                {
                alt51=6;
                }
                break;
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt51=7;
                }
                break;
            case BOOL_COND:
                {
                alt51=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }

            switch (alt51) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:376:8: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR170=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR170_tree = (CommonTree)adaptor.dupNode(OR170);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR170_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1650);
                    cond171=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond171.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1652);
                    cond172=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond172.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:377:8: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND173=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1665); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND173_tree = (CommonTree)adaptor.dupNode(AND173);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND173_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1667);
                    cond174=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond174.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1669);
                    cond175=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond175.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:378:8: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT176=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1682); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT176_tree = (CommonTree)adaptor.dupNode(NOT176);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT176_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1684);
                    cond177=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond177.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:379:8: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL178=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1697); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL178_tree = (CommonTree)adaptor.dupNode(NULL178);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL178_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1699);
                    expr179=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr179.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:379:21: ( NOT )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==NOT) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:379:21: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT180=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1701); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT180_tree = (CommonTree)adaptor.dupNode(NOT180);


                            adaptor.addChild(root_1, NOT180_tree);
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:380:8: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1715);
                    rel_op181=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op181.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1717);
                    expr182=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr182.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1719);
                    expr183=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr183.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:381:8: in_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond1730);
                    in_eval184=in_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval184.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:382:8: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1739);
                    func_eval185=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval185.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:383:8: ^( BOOL_COND expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND186=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond1750); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND186_tree = (CommonTree)adaptor.dupNode(BOOL_COND186);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND186_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1752);
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

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:386:1: in_eval : ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ ) ;
    public final AstValidator.in_eval_return in_eval() throws RecognitionException {
        AstValidator.in_eval_return retval = new AstValidator.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN188=null;
        CommonTree IN_LHS189=null;
        CommonTree IN_RHS191=null;
        AstValidator.expr_return expr190 =null;

        AstValidator.expr_return expr192 =null;


        CommonTree IN188_tree=null;
        CommonTree IN_LHS189_tree=null;
        CommonTree IN_RHS191_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:386:8: ( ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:386:10: ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN188=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval1764); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN188_tree = (CommonTree)adaptor.dupNode(IN188);


            root_1 = (CommonTree)adaptor.becomeRoot(IN188_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:386:16: ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==IN_LHS) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:386:18: ^( IN_LHS expr ) ^( IN_RHS expr )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_LHS189=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval1770); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_LHS189_tree = (CommonTree)adaptor.dupNode(IN_LHS189);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS189_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1772);
            	    expr190=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr190.getTree());


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
            	    IN_RHS191=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval1778); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_RHS191_tree = (CommonTree)adaptor.dupNode(IN_RHS191);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS191_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1780);
            	    expr192=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr192.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt52 >= 1 ) break loop52;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:389:1: func_eval : ( ^( FUNC_EVAL func_name ( real_arg )* ) | ^( INVOKER_FUNC_EVAL func_name IDENTIFIER ( real_arg )* ) );
    public final AstValidator.func_eval_return func_eval() throws RecognitionException {
        AstValidator.func_eval_return retval = new AstValidator.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL193=null;
        CommonTree INVOKER_FUNC_EVAL196=null;
        CommonTree IDENTIFIER198=null;
        AstValidator.func_name_return func_name194 =null;

        AstValidator.real_arg_return real_arg195 =null;

        AstValidator.func_name_return func_name197 =null;

        AstValidator.real_arg_return real_arg199 =null;


        CommonTree FUNC_EVAL193_tree=null;
        CommonTree INVOKER_FUNC_EVAL196_tree=null;
        CommonTree IDENTIFIER198_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:389:10: ( ^( FUNC_EVAL func_name ( real_arg )* ) | ^( INVOKER_FUNC_EVAL func_name IDENTIFIER ( real_arg )* ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==FUNC_EVAL) ) {
                alt55=1;
            }
            else if ( (LA55_0==INVOKER_FUNC_EVAL) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }
            switch (alt55) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:389:12: ^( FUNC_EVAL func_name ( real_arg )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL193=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1797); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL193_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL193);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL193_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval1799);
                    func_name194=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name194.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:389:35: ( real_arg )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==BIGDECIMALNUMBER||LA53_0==BIGINTEGERNUMBER||LA53_0==CUBE||LA53_0==DIV||LA53_0==DOLLARVAR||LA53_0==DOUBLENUMBER||LA53_0==FALSE||LA53_0==FLOATNUMBER||LA53_0==GROUP||LA53_0==IDENTIFIER||LA53_0==INTEGER||LA53_0==LONGINTEGER||LA53_0==MINUS||LA53_0==NULL||LA53_0==PERCENT||LA53_0==PLUS||LA53_0==QUOTEDSTRING||LA53_0==STAR||LA53_0==TRUE||(LA53_0 >= BAG_VAL && LA53_0 <= BIN_EXPR)||(LA53_0 >= CASE_COND && LA53_0 <= CASE_EXPR)||(LA53_0 >= CAST_EXPR && LA53_0 <= EXPR_IN_PAREN)||LA53_0==FUNC_EVAL||LA53_0==INVOKER_FUNC_EVAL||(LA53_0 >= MAP_VAL && LA53_0 <= NEG)||LA53_0==TUPLE_VAL) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:389:35: real_arg
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval1801);
                    	    real_arg195=real_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg195.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:389:49: ^( INVOKER_FUNC_EVAL func_name IDENTIFIER ( real_arg )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    INVOKER_FUNC_EVAL196=(CommonTree)match(input,INVOKER_FUNC_EVAL,FOLLOW_INVOKER_FUNC_EVAL_in_func_eval1810); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INVOKER_FUNC_EVAL196_tree = (CommonTree)adaptor.dupNode(INVOKER_FUNC_EVAL196);


                    root_1 = (CommonTree)adaptor.becomeRoot(INVOKER_FUNC_EVAL196_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval1812);
                    func_name197=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name197.getTree());


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER198=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval1814); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER198_tree = (CommonTree)adaptor.dupNode(IDENTIFIER198);


                    adaptor.addChild(root_1, IDENTIFIER198_tree);
                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:389:91: ( real_arg )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==BIGDECIMALNUMBER||LA54_0==BIGINTEGERNUMBER||LA54_0==CUBE||LA54_0==DIV||LA54_0==DOLLARVAR||LA54_0==DOUBLENUMBER||LA54_0==FALSE||LA54_0==FLOATNUMBER||LA54_0==GROUP||LA54_0==IDENTIFIER||LA54_0==INTEGER||LA54_0==LONGINTEGER||LA54_0==MINUS||LA54_0==NULL||LA54_0==PERCENT||LA54_0==PLUS||LA54_0==QUOTEDSTRING||LA54_0==STAR||LA54_0==TRUE||(LA54_0 >= BAG_VAL && LA54_0 <= BIN_EXPR)||(LA54_0 >= CASE_COND && LA54_0 <= CASE_EXPR)||(LA54_0 >= CAST_EXPR && LA54_0 <= EXPR_IN_PAREN)||LA54_0==FUNC_EVAL||LA54_0==INVOKER_FUNC_EVAL||(LA54_0 >= MAP_VAL && LA54_0 <= NEG)||LA54_0==TUPLE_VAL) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:389:91: real_arg
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval1816);
                    	    real_arg199=real_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg199.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:392:1: real_arg : ( expr | STAR | col_range );
    public final AstValidator.real_arg_return real_arg() throws RecognitionException {
        AstValidator.real_arg_return retval = new AstValidator.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR201=null;
        AstValidator.expr_return expr200 =null;

        AstValidator.col_range_return col_range202 =null;


        CommonTree STAR201_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:392:10: ( expr | STAR | col_range )
            int alt56=3;
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
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt56=1;
                }
                break;
            case STAR:
                {
                int LA56_2 = input.LA(2);

                if ( (LA56_2==DOWN) ) {
                    alt56=1;
                }
                else if ( (LA56_2==EOF||LA56_2==UP||LA56_2==BIGDECIMALNUMBER||LA56_2==BIGINTEGERNUMBER||LA56_2==CUBE||LA56_2==DIV||LA56_2==DOLLARVAR||LA56_2==DOUBLENUMBER||LA56_2==FALSE||LA56_2==FLOATNUMBER||LA56_2==GROUP||LA56_2==IDENTIFIER||LA56_2==INTEGER||LA56_2==LONGINTEGER||LA56_2==MINUS||LA56_2==NULL||LA56_2==PERCENT||LA56_2==PLUS||LA56_2==QUOTEDSTRING||LA56_2==STAR||LA56_2==TRUE||(LA56_2 >= BAG_VAL && LA56_2 <= BIN_EXPR)||(LA56_2 >= CASE_COND && LA56_2 <= CASE_EXPR)||(LA56_2 >= CAST_EXPR && LA56_2 <= EXPR_IN_PAREN)||LA56_2==FUNC_EVAL||LA56_2==INVOKER_FUNC_EVAL||(LA56_2 >= MAP_VAL && LA56_2 <= NEG)||LA56_2==TUPLE_VAL) ) {
                    alt56=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt56=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }

            switch (alt56) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:392:12: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg1828);
                    expr200=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr200.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:392:19: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR201=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg1832); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR201_tree = (CommonTree)adaptor.dupNode(STAR201);


                    adaptor.addChild(root_0, STAR201_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:392:26: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg1836);
                    col_range202=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range202.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:395:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AstValidator.expr_return expr() throws RecognitionException {
        AstValidator.expr_return retval = new AstValidator.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS203=null;
        CommonTree MINUS206=null;
        CommonTree STAR209=null;
        CommonTree DIV212=null;
        CommonTree PERCENT215=null;
        CommonTree CAST_EXPR218=null;
        CommonTree NEG223=null;
        CommonTree CAST_EXPR225=null;
        CommonTree EXPR_IN_PAREN228=null;
        AstValidator.expr_return expr204 =null;

        AstValidator.expr_return expr205 =null;

        AstValidator.expr_return expr207 =null;

        AstValidator.expr_return expr208 =null;

        AstValidator.expr_return expr210 =null;

        AstValidator.expr_return expr211 =null;

        AstValidator.expr_return expr213 =null;

        AstValidator.expr_return expr214 =null;

        AstValidator.expr_return expr216 =null;

        AstValidator.expr_return expr217 =null;

        AstValidator.type_return type219 =null;

        AstValidator.expr_return expr220 =null;

        AstValidator.const_expr_return const_expr221 =null;

        AstValidator.var_expr_return var_expr222 =null;

        AstValidator.expr_return expr224 =null;

        AstValidator.type_cast_return type_cast226 =null;

        AstValidator.expr_return expr227 =null;

        AstValidator.expr_return expr229 =null;


        CommonTree PLUS203_tree=null;
        CommonTree MINUS206_tree=null;
        CommonTree STAR209_tree=null;
        CommonTree DIV212_tree=null;
        CommonTree PERCENT215_tree=null;
        CommonTree CAST_EXPR218_tree=null;
        CommonTree NEG223_tree=null;
        CommonTree CAST_EXPR225_tree=null;
        CommonTree EXPR_IN_PAREN228_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:395:6: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt57=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt57=1;
                }
                break;
            case MINUS:
                {
                int LA57_2 = input.LA(2);

                if ( (synpred109_AstValidator()) ) {
                    alt57=2;
                }
                else if ( (synpred114_AstValidator()) ) {
                    alt57=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 57, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt57=3;
                }
                break;
            case DIV:
                {
                alt57=4;
                }
                break;
            case PERCENT:
                {
                alt57=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA57_6 = input.LA(2);

                if ( (synpred113_AstValidator()) ) {
                    alt57=6;
                }
                else if ( (synpred117_AstValidator()) ) {
                    alt57=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 57, 6, input);

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
                alt57=7;
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
            case INVOKER_FUNC_EVAL:
                {
                alt57=8;
                }
                break;
            case NEG:
                {
                alt57=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt57=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }

            switch (alt57) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:395:8: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS203=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1847); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS203_tree = (CommonTree)adaptor.dupNode(PLUS203);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS203_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1849);
                    expr204=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr204.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1851);
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
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:396:8: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS206=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1864); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS206_tree = (CommonTree)adaptor.dupNode(MINUS206);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS206_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1866);
                    expr207=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr207.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1868);
                    expr208=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr208.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:397:8: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR209=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr1881); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR209_tree = (CommonTree)adaptor.dupNode(STAR209);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR209_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1883);
                    expr210=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr210.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1885);
                    expr211=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr211.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:398:8: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV212=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1898); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV212_tree = (CommonTree)adaptor.dupNode(DIV212);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV212_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1900);
                    expr213=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr213.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1902);
                    expr214=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr214.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:399:8: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT215=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr1915); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT215_tree = (CommonTree)adaptor.dupNode(PERCENT215);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT215_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1917);
                    expr216=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr216.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1919);
                    expr217=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr217.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:400:8: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR218=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1932); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR218_tree = (CommonTree)adaptor.dupNode(CAST_EXPR218);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR218_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr1934);
                    type219=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type219.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1936);
                    expr220=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr220.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:401:8: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr1947);
                    const_expr221=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr221.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:402:8: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr1956);
                    var_expr222=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr222.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:403:8: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG223=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr1967); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG223_tree = (CommonTree)adaptor.dupNode(NEG223);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG223_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1969);
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
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:404:8: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR225=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1982); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR225_tree = (CommonTree)adaptor.dupNode(CAST_EXPR225);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR225_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr1984);
                    type_cast226=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast226.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1986);
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
                case 11 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:405:8: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN228=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr1999); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN228_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN228);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN228_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2001);
                    expr229=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr229.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:408:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AstValidator.type_cast_return type_cast() throws RecognitionException {
        AstValidator.type_cast_return retval = new AstValidator.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.simple_type_return simple_type230 =null;

        AstValidator.map_type_return map_type231 =null;

        AstValidator.tuple_type_cast_return tuple_type_cast232 =null;

        AstValidator.bag_type_cast_return bag_type_cast233 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:408:11: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt58=4;
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
                alt58=1;
                }
                break;
            case MAP_TYPE:
                {
                alt58=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt58=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt58=4;
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:408:13: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast2012);
                    simple_type230=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type230.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:408:27: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast2016);
                    map_type231=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type231.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:408:38: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast2020);
                    tuple_type_cast232=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast232.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:408:56: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast2024);
                    bag_type_cast233=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast233.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:411:1: tuple_type_cast : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final AstValidator.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AstValidator.tuple_type_cast_return retval = new AstValidator.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST234=null;
        AstValidator.type_cast_return type_cast235 =null;


        CommonTree TUPLE_TYPE_CAST234_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:411:17: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:411:19: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST234=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2035); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST234_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST234);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST234_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:411:38: ( type_cast )*
                loop59:
                do {
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==BIGDECIMAL||LA59_0==BIGINTEGER||LA59_0==BOOLEAN||LA59_0==BYTEARRAY||LA59_0==CHARARRAY||LA59_0==DATETIME||LA59_0==DOUBLE||LA59_0==FLOAT||LA59_0==INT||LA59_0==LONG||LA59_0==BAG_TYPE_CAST||LA59_0==MAP_TYPE||LA59_0==TUPLE_TYPE_CAST) ) {
                        alt59=1;
                    }


                    switch (alt59) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:411:38: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2037);
                	    type_cast235=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast235.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop59;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:414:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AstValidator.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AstValidator.bag_type_cast_return retval = new AstValidator.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST236=null;
        AstValidator.tuple_type_cast_return tuple_type_cast237 =null;


        CommonTree BAG_TYPE_CAST236_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:414:15: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:414:17: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST236=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2051); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST236_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST236);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST236_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:414:34: ( tuple_type_cast )?
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==TUPLE_TYPE_CAST) ) {
                    alt60=1;
                }
                switch (alt60) {
                    case 1 :
                        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:414:34: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast2053);
                        tuple_type_cast237=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast237.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:417:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AstValidator.var_expr_return var_expr() throws RecognitionException {
        AstValidator.var_expr_return retval = new AstValidator.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.projectable_expr_return projectable_expr238 =null;

        AstValidator.dot_proj_return dot_proj239 =null;

        AstValidator.pound_proj_return pound_proj240 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:417:10: ( projectable_expr ( dot_proj | pound_proj )* )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:417:12: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr2065);
            projectable_expr238=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr238.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:417:29: ( dot_proj | pound_proj )*
            loop61:
            do {
                int alt61=3;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==PERIOD) ) {
                    alt61=1;
                }
                else if ( (LA61_0==POUND) ) {
                    alt61=2;
                }


                switch (alt61) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:417:31: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr2069);
            	    dot_proj239=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj239.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:417:42: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr2073);
            	    pound_proj240=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj240.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop61;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:420:1: projectable_expr : ( func_eval | col_ref | bin_expr | case_expr | case_cond );
    public final AstValidator.projectable_expr_return projectable_expr() throws RecognitionException {
        AstValidator.projectable_expr_return retval = new AstValidator.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.func_eval_return func_eval241 =null;

        AstValidator.col_ref_return col_ref242 =null;

        AstValidator.bin_expr_return bin_expr243 =null;

        AstValidator.case_expr_return case_expr244 =null;

        AstValidator.case_cond_return case_cond245 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:420:17: ( func_eval | col_ref | bin_expr | case_expr | case_cond )
            int alt62=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt62=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt62=2;
                }
                break;
            case BIN_EXPR:
                {
                alt62=3;
                }
                break;
            case CASE_EXPR:
                {
                alt62=4;
                }
                break;
            case CASE_COND:
                {
                alt62=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }

            switch (alt62) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:420:19: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr2084);
                    func_eval241=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval241.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:420:31: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr2088);
                    col_ref242=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref242.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:420:41: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr2092);
                    bin_expr243=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr243.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:420:52: case_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr2096);
                    case_expr244=case_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr244.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:420:64: case_cond
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr2100);
                    case_cond245=case_cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond245.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:423:1: dot_proj : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final AstValidator.dot_proj_return dot_proj() throws RecognitionException {
        AstValidator.dot_proj_return retval = new AstValidator.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD246=null;
        AstValidator.col_alias_or_index_return col_alias_or_index247 =null;


        CommonTree PERIOD246_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:423:10: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:423:12: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD246=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj2111); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD246_tree = (CommonTree)adaptor.dupNode(PERIOD246);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD246_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:423:22: ( col_alias_or_index )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==CUBE||LA63_0==DOLLARVAR||LA63_0==GROUP||LA63_0==IDENTIFIER) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:423:22: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2113);
            	    col_alias_or_index247=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index247.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:426:1: col_alias_or_index : ( col_alias | col_index );
    public final AstValidator.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AstValidator.col_alias_or_index_return retval = new AstValidator.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.col_alias_return col_alias248 =null;

        AstValidator.col_index_return col_index249 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:426:20: ( col_alias | col_index )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==CUBE||LA64_0==GROUP||LA64_0==IDENTIFIER) ) {
                alt64=1;
            }
            else if ( (LA64_0==DOLLARVAR) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }
            switch (alt64) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:426:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index2125);
                    col_alias248=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias248.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:426:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index2129);
                    col_index249=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index249.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:429:1: col_alias : ( GROUP | CUBE | IDENTIFIER );
    public final AstValidator.col_alias_return col_alias() throws RecognitionException {
        AstValidator.col_alias_return retval = new AstValidator.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set250=null;

        CommonTree set250_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:429:11: ( GROUP | CUBE | IDENTIFIER )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set250=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set250_tree = (CommonTree)adaptor.dupNode(set250);


                adaptor.addChild(root_0, set250_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:432:1: col_index : DOLLARVAR ;
    public final AstValidator.col_index_return col_index() throws RecognitionException {
        AstValidator.col_index_return retval = new AstValidator.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR251=null;

        CommonTree DOLLARVAR251_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:432:11: ( DOLLARVAR )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:432:13: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR251=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index2155); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR251_tree = (CommonTree)adaptor.dupNode(DOLLARVAR251);


            adaptor.addChild(root_0, DOLLARVAR251_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:435:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AstValidator.col_range_return col_range() throws RecognitionException {
        AstValidator.col_range_return retval = new AstValidator.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE252=null;
        CommonTree DOUBLE_PERIOD254=null;
        AstValidator.col_ref_return col_ref253 =null;

        AstValidator.col_ref_return col_ref255 =null;


        CommonTree COL_RANGE252_tree=null;
        CommonTree DOUBLE_PERIOD254_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:435:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:435:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE252=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range2166); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE252_tree = (CommonTree)adaptor.dupNode(COL_RANGE252);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE252_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:435:26: ( col_ref )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==CUBE||LA65_0==DOLLARVAR||LA65_0==GROUP||LA65_0==IDENTIFIER) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:435:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2168);
                    col_ref253=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref253.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD254=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range2171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD254_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD254);


            adaptor.addChild(root_1, DOUBLE_PERIOD254_tree);
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:435:49: ( col_ref )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==CUBE||LA66_0==DOLLARVAR||LA66_0==GROUP||LA66_0==IDENTIFIER) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:435:49: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2173);
                    col_ref255=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref255.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:439:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AstValidator.pound_proj_return pound_proj() throws RecognitionException {
        AstValidator.pound_proj_return retval = new AstValidator.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND256=null;
        CommonTree set257=null;

        CommonTree POUND256_tree=null;
        CommonTree set257_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:439:12: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:439:14: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND256=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj2187); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND256_tree = (CommonTree)adaptor.dupNode(POUND256);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND256_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            set257=(CommonTree)input.LT(1);

            if ( input.LA(1)==NULL||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set257_tree = (CommonTree)adaptor.dupNode(set257);


                adaptor.addChild(root_1, set257_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:442:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AstValidator.bin_expr_return bin_expr() throws RecognitionException {
        AstValidator.bin_expr_return retval = new AstValidator.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR258=null;
        AstValidator.cond_return cond259 =null;

        AstValidator.expr_return expr260 =null;

        AstValidator.expr_return expr261 =null;


        CommonTree BIN_EXPR258_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:442:10: ( ^( BIN_EXPR cond expr expr ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:442:12: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR258=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr2210); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR258_tree = (CommonTree)adaptor.dupNode(BIN_EXPR258);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR258_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2212);
            cond259=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond259.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2214);
            expr260=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr260.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2216);
            expr261=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr261.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:445:1: case_expr : ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ ) ;
    public final AstValidator.case_expr_return case_expr() throws RecognitionException {
        AstValidator.case_expr_return retval = new AstValidator.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR262=null;
        CommonTree CASE_EXPR_LHS263=null;
        CommonTree CASE_EXPR_RHS265=null;
        AstValidator.expr_return expr264 =null;

        AstValidator.expr_return expr266 =null;


        CommonTree CASE_EXPR262_tree=null;
        CommonTree CASE_EXPR_LHS263_tree=null;
        CommonTree CASE_EXPR_RHS265_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:445:10: ( ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:445:12: ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR262=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr2228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR262_tree = (CommonTree)adaptor.dupNode(CASE_EXPR262);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR262_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:445:25: ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+
            int cnt68=0;
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==CASE_EXPR_LHS) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:445:27: ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_LHS263=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr2234); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_LHS263_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS263);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS263_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr2236);
            	    expr264=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr264.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:445:51: ( ^( CASE_EXPR_RHS expr ) )+
            	    int cnt67=0;
            	    loop67:
            	    do {
            	        int alt67=2;
            	        int LA67_0 = input.LA(1);

            	        if ( (LA67_0==CASE_EXPR_RHS) ) {
            	            alt67=1;
            	        }


            	        switch (alt67) {
            	    	case 1 :
            	    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:445:53: ^( CASE_EXPR_RHS expr )
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    {
            	    	    CommonTree _save_last_2 = _last;
            	    	    CommonTree _first_2 = null;
            	    	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    	    _last = (CommonTree)input.LT(1);
            	    	    CASE_EXPR_RHS265=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr2244); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    CASE_EXPR_RHS265_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS265);


            	    	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS265_tree, root_2);
            	    	    }


            	    	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    	    _last = (CommonTree)input.LT(1);
            	    	    pushFollow(FOLLOW_expr_in_case_expr2246);
            	    	    expr266=expr();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) 
            	    	    adaptor.addChild(root_2, expr266.getTree());


            	    	    match(input, Token.UP, null); if (state.failed) return retval;
            	    	    adaptor.addChild(root_1, root_2);
            	    	    _last = _save_last_2;
            	    	    }


            	    	    if ( state.backtracking==0 ) {
            	    	    }
            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt67 >= 1 ) break loop67;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(67, input);
            	                throw eee;
            	        }
            	        cnt67++;
            	    } while (true);


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt68 >= 1 ) break loop68;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(68, input);
                        throw eee;
                }
                cnt68++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:448:1: case_cond : ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ;
    public final AstValidator.case_cond_return case_cond() throws RecognitionException {
        AstValidator.case_cond_return retval = new AstValidator.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND267=null;
        CommonTree WHEN268=null;
        CommonTree THEN270=null;
        AstValidator.cond_return cond269 =null;

        AstValidator.expr_return expr271 =null;


        CommonTree CASE_COND267_tree=null;
        CommonTree WHEN268_tree=null;
        CommonTree THEN270_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:448:10: ( ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:448:12: ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND267=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond2265); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND267_tree = (CommonTree)adaptor.dupNode(CASE_COND267);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND267_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN268=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond2269); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN268_tree = (CommonTree)adaptor.dupNode(WHEN268);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN268_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:448:33: ( cond )+
            int cnt69=0;
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==AND||LA69_0==IN||(LA69_0 >= NOT && LA69_0 <= NUM_OP_NE)||LA69_0==OR||(LA69_0 >= STR_OP_EQ && LA69_0 <= STR_OP_NE)||LA69_0==BOOL_COND||LA69_0==FUNC_EVAL||LA69_0==INVOKER_FUNC_EVAL) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:448:33: cond
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond2271);
            	    cond269=cond();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond269.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt69 >= 1 ) break loop69;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(69, input);
                        throw eee;
                }
                cnt69++;
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
            THEN270=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond2278); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN270_tree = (CommonTree)adaptor.dupNode(THEN270);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN270_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:448:49: ( expr )+
            int cnt70=0;
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==BIGDECIMALNUMBER||LA70_0==BIGINTEGERNUMBER||LA70_0==CUBE||LA70_0==DIV||LA70_0==DOLLARVAR||LA70_0==DOUBLENUMBER||LA70_0==FALSE||LA70_0==FLOATNUMBER||LA70_0==GROUP||LA70_0==IDENTIFIER||LA70_0==INTEGER||LA70_0==LONGINTEGER||LA70_0==MINUS||LA70_0==NULL||LA70_0==PERCENT||LA70_0==PLUS||LA70_0==QUOTEDSTRING||LA70_0==STAR||LA70_0==TRUE||(LA70_0 >= BAG_VAL && LA70_0 <= BIN_EXPR)||(LA70_0 >= CASE_COND && LA70_0 <= CASE_EXPR)||LA70_0==CAST_EXPR||LA70_0==EXPR_IN_PAREN||LA70_0==FUNC_EVAL||LA70_0==INVOKER_FUNC_EVAL||(LA70_0 >= MAP_VAL && LA70_0 <= NEG)||LA70_0==TUPLE_VAL) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:448:49: expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond2280);
            	    expr271=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr271.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt70 >= 1 ) break loop70;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(70, input);
                        throw eee;
                }
                cnt70++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:451:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AstValidator.limit_clause_return limit_clause() throws RecognitionException {
        AstValidator.limit_clause_return retval = new AstValidator.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT272=null;
        CommonTree INTEGER274=null;
        CommonTree LONGINTEGER275=null;
        AstValidator.rel_return rel273 =null;

        AstValidator.expr_return expr276 =null;


        CommonTree LIMIT272_tree=null;
        CommonTree INTEGER274_tree=null;
        CommonTree LONGINTEGER275_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:451:14: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:451:16: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT272=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2296); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT272_tree = (CommonTree)adaptor.dupNode(LIMIT272);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT272_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause2298);
            rel273=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel273.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:451:29: ( INTEGER | LONGINTEGER | expr )
            int alt71=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA71_1 = input.LA(2);

                if ( (synpred140_AstValidator()) ) {
                    alt71=1;
                }
                else if ( (true) ) {
                    alt71=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA71_2 = input.LA(2);

                if ( (synpred141_AstValidator()) ) {
                    alt71=2;
                }
                else if ( (true) ) {
                    alt71=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 2, input);

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
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt71=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }

            switch (alt71) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:451:31: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER274=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause2302); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER274_tree = (CommonTree)adaptor.dupNode(INTEGER274);


                    adaptor.addChild(root_1, INTEGER274_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:451:41: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER275=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause2306); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER275_tree = (CommonTree)adaptor.dupNode(LONGINTEGER275);


                    adaptor.addChild(root_1, LONGINTEGER275_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:451:55: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause2310);
                    expr276=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr276.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:454:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AstValidator.sample_clause_return sample_clause() throws RecognitionException {
        AstValidator.sample_clause_return retval = new AstValidator.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE277=null;
        CommonTree DOUBLENUMBER279=null;
        AstValidator.rel_return rel278 =null;

        AstValidator.expr_return expr280 =null;


        CommonTree SAMPLE277_tree=null;
        CommonTree DOUBLENUMBER279_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:454:15: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:454:17: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE277=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause2325); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE277_tree = (CommonTree)adaptor.dupNode(SAMPLE277);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE277_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause2327);
            rel278=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel278.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:454:31: ( DOUBLENUMBER | expr )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==DOUBLENUMBER) ) {
                int LA72_1 = input.LA(2);

                if ( (synpred142_AstValidator()) ) {
                    alt72=1;
                }
                else if ( (true) ) {
                    alt72=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA72_0==BIGDECIMALNUMBER||LA72_0==BIGINTEGERNUMBER||LA72_0==CUBE||LA72_0==DIV||LA72_0==DOLLARVAR||LA72_0==FALSE||LA72_0==FLOATNUMBER||LA72_0==GROUP||LA72_0==IDENTIFIER||LA72_0==INTEGER||LA72_0==LONGINTEGER||LA72_0==MINUS||LA72_0==NULL||LA72_0==PERCENT||LA72_0==PLUS||LA72_0==QUOTEDSTRING||LA72_0==STAR||LA72_0==TRUE||(LA72_0 >= BAG_VAL && LA72_0 <= BIN_EXPR)||(LA72_0 >= CASE_COND && LA72_0 <= CASE_EXPR)||LA72_0==CAST_EXPR||LA72_0==EXPR_IN_PAREN||LA72_0==FUNC_EVAL||LA72_0==INVOKER_FUNC_EVAL||(LA72_0 >= MAP_VAL && LA72_0 <= NEG)||LA72_0==TUPLE_VAL) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }
            switch (alt72) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:454:33: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER279=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause2331); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER279_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER279);


                    adaptor.addChild(root_1, DOUBLENUMBER279_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:454:48: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause2335);
                    expr280=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr280.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:457:1: rank_clause : ^( RANK rel ( rank_by_statement )? ) ;
    public final AstValidator.rank_clause_return rank_clause() throws RecognitionException {
        AstValidator.rank_clause_return retval = new AstValidator.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK281=null;
        AstValidator.rel_return rel282 =null;

        AstValidator.rank_by_statement_return rank_by_statement283 =null;


        CommonTree RANK281_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:457:13: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:457:15: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK281=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause2350); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK281_tree = (CommonTree)adaptor.dupNode(RANK281);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK281_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause2352);
            rel282=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel282.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:457:27: ( rank_by_statement )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==BY) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:457:29: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause2356);
                    rank_by_statement283=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement283.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:460:1: rank_by_statement : ^( BY rank_by_clause ( DENSE )? ) ;
    public final AstValidator.rank_by_statement_return rank_by_statement() throws RecognitionException {
        AstValidator.rank_by_statement_return retval = new AstValidator.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY284=null;
        CommonTree DENSE286=null;
        AstValidator.rank_by_clause_return rank_by_clause285 =null;


        CommonTree BY284_tree=null;
        CommonTree DENSE286_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:460:19: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:460:21: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY284=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement2372); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY284_tree = (CommonTree)adaptor.dupNode(BY284);


            root_1 = (CommonTree)adaptor.becomeRoot(BY284_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement2374);
            rank_by_clause285=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause285.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:460:42: ( DENSE )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==DENSE) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:460:44: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE286=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement2378); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE286_tree = (CommonTree)adaptor.dupNode(DENSE286);


                    adaptor.addChild(root_1, DENSE286_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:463:1: rank_by_clause : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final AstValidator.rank_by_clause_return rank_by_clause() throws RecognitionException {
        AstValidator.rank_by_clause_return retval = new AstValidator.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR287=null;
        CommonTree set288=null;
        AstValidator.rank_col_return rank_col289 =null;


        CommonTree STAR287_tree=null;
        CommonTree set288_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:463:16: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==STAR) ) {
                alt77=1;
            }
            else if ( (LA77_0==CUBE||LA77_0==DOLLARVAR||LA77_0==GROUP||LA77_0==IDENTIFIER||LA77_0==COL_RANGE) ) {
                alt77=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;

            }
            switch (alt77) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:463:18: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR287=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause2392); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR287_tree = (CommonTree)adaptor.dupNode(STAR287);


                    adaptor.addChild(root_0, STAR287_tree);
                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:463:23: ( ASC | DESC )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==ASC||LA75_0==DESC) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set288=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set288_tree = (CommonTree)adaptor.dupNode(set288);


                                adaptor.addChild(root_0, set288_tree);
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:464:18: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:464:18: ( rank_col )+
                    int cnt76=0;
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==CUBE||LA76_0==DOLLARVAR||LA76_0==GROUP||LA76_0==IDENTIFIER||LA76_0==COL_RANGE) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:464:18: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause2422);
                    	    rank_col289=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col289.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt76 >= 1 ) break loop76;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(76, input);
                                throw eee;
                        }
                        cnt76++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:467:1: rank_col : ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? );
    public final AstValidator.rank_col_return rank_col() throws RecognitionException {
        AstValidator.rank_col_return retval = new AstValidator.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set291=null;
        CommonTree set293=null;
        AstValidator.col_range_return col_range290 =null;

        AstValidator.col_ref_return col_ref292 =null;


        CommonTree set291_tree=null;
        CommonTree set293_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:467:10: ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? )
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:467:12: col_range ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col2432);
                    col_range290=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range290.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:467:22: ( ASC | DESC )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==ASC||LA78_0==DESC) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set291=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set291_tree = (CommonTree)adaptor.dupNode(set291);


                                adaptor.addChild(root_0, set291_tree);
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:468:12: col_ref ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col2454);
                    col_ref292=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref292.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:468:20: ( ASC | DESC )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==ASC||LA79_0==DESC) ) {
                        alt79=1;
                    }
                    switch (alt79) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set293=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set293_tree = (CommonTree)adaptor.dupNode(set293);


                                adaptor.addChild(root_0, set293_tree);
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

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:471:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AstValidator.order_clause_return order_clause() throws RecognitionException {
        AstValidator.order_clause_return retval = new AstValidator.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER294=null;
        AstValidator.rel_return rel295 =null;

        AstValidator.order_by_clause_return order_by_clause296 =null;

        AstValidator.func_clause_return func_clause297 =null;


        CommonTree ORDER294_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:471:14: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:471:16: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER294=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause2476); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER294_tree = (CommonTree)adaptor.dupNode(ORDER294);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER294_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause2478);
            rel295=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel295.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause2480);
            order_by_clause296=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause296.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:471:45: ( func_clause )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==FUNC||LA81_0==FUNC_REF) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:471:45: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause2482);
                    func_clause297=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause297.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:474:1: order_by_clause : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final AstValidator.order_by_clause_return order_by_clause() throws RecognitionException {
        AstValidator.order_by_clause_return retval = new AstValidator.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR298=null;
        CommonTree set299=null;
        AstValidator.order_col_return order_col300 =null;


        CommonTree STAR298_tree=null;
        CommonTree set299_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:474:17: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==STAR) ) {
                alt84=1;
            }
            else if ( (LA84_0==CUBE||LA84_0==DOLLARVAR||LA84_0==GROUP||LA84_0==IDENTIFIER||LA84_0==COL_RANGE) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;

            }
            switch (alt84) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:474:19: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR298=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause2494); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR298_tree = (CommonTree)adaptor.dupNode(STAR298);


                    adaptor.addChild(root_0, STAR298_tree);
                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:474:24: ( ASC | DESC )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==ASC||LA82_0==DESC) ) {
                        alt82=1;
                    }
                    switch (alt82) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set299=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set299_tree = (CommonTree)adaptor.dupNode(set299);


                                adaptor.addChild(root_0, set299_tree);
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:475:19: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:475:19: ( order_col )+
                    int cnt83=0;
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==CUBE||LA83_0==DOLLARVAR||LA83_0==GROUP||LA83_0==IDENTIFIER||LA83_0==COL_RANGE) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:475:19: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause2525);
                    	    order_col300=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col300.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt83 >= 1 ) break loop83;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(83, input);
                                throw eee;
                        }
                        cnt83++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:478:1: order_col : ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? );
    public final AstValidator.order_col_return order_col() throws RecognitionException {
        AstValidator.order_col_return retval = new AstValidator.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set302=null;
        CommonTree set304=null;
        AstValidator.col_range_return col_range301 =null;

        AstValidator.col_ref_return col_ref303 =null;


        CommonTree set302_tree=null;
        CommonTree set304_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:478:11: ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==COL_RANGE) ) {
                alt87=1;
            }
            else if ( (LA87_0==CUBE||LA87_0==DOLLARVAR||LA87_0==GROUP||LA87_0==IDENTIFIER) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;

            }
            switch (alt87) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:478:13: col_range ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col2535);
                    col_range301=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range301.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:478:23: ( ASC | DESC )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==ASC||LA85_0==DESC) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set302=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set302_tree = (CommonTree)adaptor.dupNode(set302);


                                adaptor.addChild(root_0, set302_tree);
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:479:13: col_ref ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col2558);
                    col_ref303=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref303.getTree());


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:479:21: ( ASC | DESC )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==ASC||LA86_0==DESC) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set304=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set304_tree = (CommonTree)adaptor.dupNode(set304);


                                adaptor.addChild(root_0, set304_tree);
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

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:482:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AstValidator.distinct_clause_return distinct_clause() throws RecognitionException {
        AstValidator.distinct_clause_return retval = new AstValidator.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT305=null;
        AstValidator.rel_return rel306 =null;

        AstValidator.partition_clause_return partition_clause307 =null;


        CommonTree DISTINCT305_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:482:17: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:482:19: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT305=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause2580); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT305_tree = (CommonTree)adaptor.dupNode(DISTINCT305);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT305_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause2582);
            rel306=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel306.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:482:35: ( partition_clause )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==PARTITION) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:482:35: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause2584);
                    partition_clause307=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause307.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:485:1: partition_clause : ^( PARTITION func_name ) ;
    public final AstValidator.partition_clause_return partition_clause() throws RecognitionException {
        AstValidator.partition_clause_return retval = new AstValidator.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION308=null;
        AstValidator.func_name_return func_name309 =null;


        CommonTree PARTITION308_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:485:18: ( ^( PARTITION func_name ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:485:20: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION308=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause2598); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION308_tree = (CommonTree)adaptor.dupNode(PARTITION308);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION308_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause2600);
            func_name309=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name309.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:488:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AstValidator.cross_clause_return cross_clause() throws RecognitionException {
        AstValidator.cross_clause_return retval = new AstValidator.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS310=null;
        AstValidator.rel_list_return rel_list311 =null;

        AstValidator.partition_clause_return partition_clause312 =null;


        CommonTree CROSS310_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:488:14: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:488:16: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS310=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause2613); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS310_tree = (CommonTree)adaptor.dupNode(CROSS310);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS310_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause2615);
            rel_list311=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list311.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:488:34: ( partition_clause )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==PARTITION) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:488:34: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause2617);
                    partition_clause312=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause312.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:491:1: rel_list : ( rel )+ ;
    public final AstValidator.rel_list_return rel_list() throws RecognitionException {
        AstValidator.rel_list_return retval = new AstValidator.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.rel_return rel313 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:491:10: ( ( rel )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:491:12: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:491:12: ( rel )+
            int cnt90=0;
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==ARROBA||LA90_0==ASSERT||LA90_0==COGROUP||(LA90_0 >= CROSS && LA90_0 <= CUBE)||LA90_0==DEFINE||LA90_0==DISTINCT||LA90_0==FILTER||LA90_0==FOREACH||LA90_0==GROUP||LA90_0==IDENTIFIER||LA90_0==JOIN||(LA90_0 >= LIMIT && LA90_0 <= LOAD)||LA90_0==MAPREDUCE||LA90_0==ORDER||LA90_0==RANK||LA90_0==SAMPLE||LA90_0==SPLIT||(LA90_0 >= STORE && LA90_0 <= STREAM)||LA90_0==UNION) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:491:12: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list2629);
            	    rel313=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel313.getTree());


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


    protected static class join_clause_scope {
        int arity;
    }
    protected Stack join_clause_stack = new Stack();


    public static class join_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:494:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AstValidator.join_clause_return join_clause() throws RecognitionException {
        join_clause_stack.push(new join_clause_scope());
        AstValidator.join_clause_return retval = new AstValidator.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN314=null;
        AstValidator.join_sub_clause_return join_sub_clause315 =null;

        AstValidator.join_type_return join_type316 =null;

        AstValidator.partition_clause_return partition_clause317 =null;


        CommonTree JOIN314_tree=null;


            ((join_clause_scope)join_clause_stack.peek()).arity = 0;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:501:2: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:501:4: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN314=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause2651); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN314_tree = (CommonTree)adaptor.dupNode(JOIN314);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN314_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause2653);
            join_sub_clause315=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause315.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:501:28: ( join_type )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==QUOTEDSTRING) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:501:28: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause2655);
                    join_type316=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type316.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:501:39: ( partition_clause )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==PARTITION) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:501:39: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause2658);
                    partition_clause317=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause317.getTree());


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
            join_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:504:1: join_type : QUOTEDSTRING ;
    public final AstValidator.join_type_return join_type() throws RecognitionException {
        AstValidator.join_type_return retval = new AstValidator.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING318=null;

        CommonTree QUOTEDSTRING318_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:504:11: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:504:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING318=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type2670); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING318_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING318);


            adaptor.addChild(root_0, QUOTEDSTRING318_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:507:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final AstValidator.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AstValidator.join_sub_clause_return retval = new AstValidator.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set320=null;
        CommonTree OUTER321=null;
        AstValidator.join_item_return join_item319 =null;

        AstValidator.join_item_return join_item322 =null;

        AstValidator.join_item_return join_item323 =null;


        CommonTree set320_tree=null;
        CommonTree OUTER321_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:508:2: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==JOIN_ITEM) ) {
                int LA95_1 = input.LA(2);

                if ( (synpred172_AstValidator()) ) {
                    alt95=1;
                }
                else if ( (true) ) {
                    alt95=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 95, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;

            }
            switch (alt95) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:508:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2680);
                    join_item319=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item319.getTree());


                    _last = (CommonTree)input.LT(1);
                    set320=(CommonTree)input.LT(1);

                    if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set320_tree = (CommonTree)adaptor.dupNode(set320);


                        adaptor.addChild(root_0, set320_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:508:38: ( OUTER )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==OUTER) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:508:38: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER321=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause2696); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER321_tree = (CommonTree)adaptor.dupNode(OUTER321);


                            adaptor.addChild(root_0, OUTER321_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2699);
                    join_item322=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item322.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:509:4: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:509:4: ( join_item )+
                    int cnt94=0;
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==JOIN_ITEM) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                    	case 1 :
                    	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:509:4: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause2704);
                    	    join_item323=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item323.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt94 >= 1 ) break loop94;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(94, input);
                                throw eee;
                        }
                        cnt94++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:512:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AstValidator.join_item_return join_item() throws RecognitionException {
        AstValidator.join_item_return retval = new AstValidator.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM324=null;
        AstValidator.rel_return rel325 =null;

        AstValidator.join_group_by_clause_return join_group_by_clause326 =null;


        CommonTree JOIN_ITEM324_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:513:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:513:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM324=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item2717); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM324_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM324);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM324_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item2719);
            rel325=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel325.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item2721);
            join_group_by_clause326=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause326.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   if( ((join_clause_scope)join_clause_stack.peek()).arity == 0 ) {
                       // For the first input
                       ((join_clause_scope)join_clause_stack.peek()).arity = (join_group_by_clause326!=null?join_group_by_clause326.exprCount:0);
                   } else if( (join_group_by_clause326!=null?join_group_by_clause326.exprCount:0) != ((join_clause_scope)join_clause_stack.peek()).arity ) {
                       throw new ParserValidationException( input, new SourceLocation( (PigParserNode)((CommonTree)retval.start) ),
                           "The arity of the join columns do not match." );
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
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        public int exprCount;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:525:1: join_group_by_clause returns [int exprCount] : ^( BY ( join_group_by_expr )+ ) ;
    public final AstValidator.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AstValidator.join_group_by_clause_return retval = new AstValidator.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY327=null;
        AstValidator.join_group_by_expr_return join_group_by_expr328 =null;


        CommonTree BY327_tree=null;


            retval.exprCount = 0;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:529:2: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:529:4: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY327=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause2748); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY327_tree = (CommonTree)adaptor.dupNode(BY327);


            root_1 = (CommonTree)adaptor.becomeRoot(BY327_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:529:10: ( join_group_by_expr )+
            int cnt96=0;
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==BIGDECIMALNUMBER||LA96_0==BIGINTEGERNUMBER||LA96_0==CUBE||LA96_0==DIV||LA96_0==DOLLARVAR||LA96_0==DOUBLENUMBER||LA96_0==FALSE||LA96_0==FLOATNUMBER||LA96_0==GROUP||LA96_0==IDENTIFIER||LA96_0==INTEGER||LA96_0==LONGINTEGER||LA96_0==MINUS||LA96_0==NULL||LA96_0==PERCENT||LA96_0==PLUS||LA96_0==QUOTEDSTRING||LA96_0==STAR||LA96_0==TRUE||(LA96_0 >= BAG_VAL && LA96_0 <= BIN_EXPR)||(LA96_0 >= CASE_COND && LA96_0 <= CASE_EXPR)||(LA96_0 >= CAST_EXPR && LA96_0 <= EXPR_IN_PAREN)||LA96_0==FUNC_EVAL||LA96_0==INVOKER_FUNC_EVAL||(LA96_0 >= MAP_VAL && LA96_0 <= NEG)||LA96_0==TUPLE_VAL) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:529:12: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2752);
            	    join_group_by_expr328=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr328.getTree());


            	    if ( state.backtracking==0 ) { retval.exprCount++; }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt96 >= 1 ) break loop96;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(96, input);
                        throw eee;
                }
                cnt96++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:532:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AstValidator.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AstValidator.join_group_by_expr_return retval = new AstValidator.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR331=null;
        AstValidator.col_range_return col_range329 =null;

        AstValidator.expr_return expr330 =null;


        CommonTree STAR331_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:532:20: ( col_range | expr | STAR )
            int alt97=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt97=1;
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
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt97=2;
                }
                break;
            case STAR:
                {
                int LA97_3 = input.LA(2);

                if ( (LA97_3==DOWN) ) {
                    alt97=2;
                }
                else if ( (LA97_3==EOF||LA97_3==UP||LA97_3==BIGDECIMALNUMBER||LA97_3==BIGINTEGERNUMBER||LA97_3==CUBE||LA97_3==DIV||LA97_3==DOLLARVAR||LA97_3==DOUBLENUMBER||LA97_3==FALSE||LA97_3==FLOATNUMBER||LA97_3==GROUP||LA97_3==IDENTIFIER||LA97_3==INTEGER||LA97_3==LONGINTEGER||LA97_3==MINUS||LA97_3==NULL||LA97_3==PERCENT||LA97_3==PLUS||LA97_3==QUOTEDSTRING||LA97_3==STAR||LA97_3==TRUE||(LA97_3 >= BAG_VAL && LA97_3 <= BIN_EXPR)||(LA97_3 >= CASE_COND && LA97_3 <= CASE_EXPR)||(LA97_3 >= CAST_EXPR && LA97_3 <= EXPR_IN_PAREN)||LA97_3==FUNC_EVAL||LA97_3==INVOKER_FUNC_EVAL||(LA97_3 >= MAP_VAL && LA97_3 <= NEG)||LA97_3==TUPLE_VAL) ) {
                    alt97=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 97, 3, input);

                    throw nvae;

                }
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:532:22: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr2768);
                    col_range329=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range329.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:532:35: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr2773);
                    expr330=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr330.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:532:42: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR331=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr2777); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR331_tree = (CommonTree)adaptor.dupNode(STAR331);


                    adaptor.addChild(root_0, STAR331_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:535:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AstValidator.union_clause_return union_clause() throws RecognitionException {
        AstValidator.union_clause_return retval = new AstValidator.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION332=null;
        CommonTree ONSCHEMA333=null;
        AstValidator.rel_list_return rel_list334 =null;


        CommonTree UNION332_tree=null;
        CommonTree ONSCHEMA333_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:535:14: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:535:16: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION332=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause2788); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION332_tree = (CommonTree)adaptor.dupNode(UNION332);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION332_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:535:25: ( ONSCHEMA )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==ONSCHEMA) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:535:25: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA333=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause2790); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA333_tree = (CommonTree)adaptor.dupNode(ONSCHEMA333);


                    adaptor.addChild(root_1, ONSCHEMA333_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause2793);
            rel_list334=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list334.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:538:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AstValidator.foreach_clause_return foreach_clause() throws RecognitionException {
        AstValidator.foreach_clause_return retval = new AstValidator.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH335=null;
        AstValidator.rel_return rel336 =null;

        AstValidator.foreach_plan_return foreach_plan337 =null;


        CommonTree FOREACH335_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:538:16: ( ^( FOREACH rel foreach_plan ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:538:18: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH335=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause2806); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH335_tree = (CommonTree)adaptor.dupNode(FOREACH335);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH335_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause2808);
            rel336=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel336.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause2810);
            foreach_plan337=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan337.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:541:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AstValidator.foreach_plan_return foreach_plan() throws RecognitionException {
        AstValidator.foreach_plan_return retval = new AstValidator.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE338=null;
        CommonTree FOREACH_PLAN_COMPLEX340=null;
        AstValidator.generate_clause_return generate_clause339 =null;

        AstValidator.nested_blk_return nested_blk341 =null;


        CommonTree FOREACH_PLAN_SIMPLE338_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX340_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:541:14: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==FOREACH_PLAN_SIMPLE) ) {
                alt99=1;
            }
            else if ( (LA99_0==FOREACH_PLAN_COMPLEX) ) {
                alt99=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;

            }
            switch (alt99) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:541:16: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE338=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2823); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE338_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE338);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE338_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan2825);
                    generate_clause339=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause339.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:542:16: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX340=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2846); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX340_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX340);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX340_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan2848);
                    nested_blk341=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk341.getTree());


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


    protected static class nested_blk_scope {
        Set<String> ids;
    }
    protected Stack nested_blk_stack = new Stack();


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:545:1: nested_blk : ( nested_command )* generate_clause ;
    public final AstValidator.nested_blk_return nested_blk() throws RecognitionException {
        nested_blk_stack.push(new nested_blk_scope());
        AstValidator.nested_blk_return retval = new AstValidator.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_command_return nested_command342 =null;

        AstValidator.generate_clause_return generate_clause343 =null;



         ((nested_blk_scope)nested_blk_stack.peek()).ids = new HashSet<String>(); 
        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:548:2: ( ( nested_command )* generate_clause )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:548:4: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:548:4: ( nested_command )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( ((LA100_0 >= NESTED_CMD && LA100_0 <= NESTED_CMD_ASSI)) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:548:4: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk2868);
            	    nested_command342=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command342.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop100;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk2871);
            generate_clause343=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause343.getTree());


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
            nested_blk_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "nested_blk"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:551:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final AstValidator.generate_clause_return generate_clause() throws RecognitionException {
        AstValidator.generate_clause_return retval = new AstValidator.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE344=null;
        AstValidator.flatten_generated_item_return flatten_generated_item345 =null;


        CommonTree GENERATE344_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:551:17: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:551:19: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE344=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause2882); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE344_tree = (CommonTree)adaptor.dupNode(GENERATE344);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE344_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:551:31: ( flatten_generated_item )+
            int cnt101=0;
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==BIGDECIMALNUMBER||LA101_0==BIGINTEGERNUMBER||LA101_0==CUBE||LA101_0==DIV||LA101_0==DOLLARVAR||LA101_0==DOUBLENUMBER||LA101_0==FALSE||LA101_0==FLATTEN||LA101_0==FLOATNUMBER||LA101_0==GROUP||LA101_0==IDENTIFIER||LA101_0==INTEGER||LA101_0==LONGINTEGER||LA101_0==MINUS||LA101_0==NULL||LA101_0==PERCENT||LA101_0==PLUS||LA101_0==QUOTEDSTRING||LA101_0==STAR||LA101_0==TRUE||(LA101_0 >= BAG_VAL && LA101_0 <= BIN_EXPR)||(LA101_0 >= CASE_COND && LA101_0 <= CASE_EXPR)||(LA101_0 >= CAST_EXPR && LA101_0 <= EXPR_IN_PAREN)||LA101_0==FUNC_EVAL||LA101_0==INVOKER_FUNC_EVAL||(LA101_0 >= MAP_VAL && LA101_0 <= NEG)||LA101_0==TUPLE_VAL) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:551:31: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause2884);
            	    flatten_generated_item345=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item345.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:554:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AstValidator.nested_command_return nested_command() throws RecognitionException {
        AstValidator.nested_command_return retval = new AstValidator.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD346=null;
        CommonTree IDENTIFIER347=null;
        CommonTree NESTED_CMD_ASSI349=null;
        CommonTree IDENTIFIER350=null;
        AstValidator.nested_op_return nested_op348 =null;

        AstValidator.expr_return expr351 =null;


        CommonTree NESTED_CMD346_tree=null;
        CommonTree IDENTIFIER347_tree=null;
        CommonTree NESTED_CMD_ASSI349_tree=null;
        CommonTree IDENTIFIER350_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:555:2: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==NESTED_CMD) ) {
                alt102=1;
            }
            else if ( (LA102_0==NESTED_CMD_ASSI) ) {
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:555:4: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD346=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command2899); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD346_tree = (CommonTree)adaptor.dupNode(NESTED_CMD346);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD346_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER347=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2901); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER347_tree = (CommonTree)adaptor.dupNode(IDENTIFIER347);


                    adaptor.addChild(root_1, IDENTIFIER347_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command2903);
                    nested_op348=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op348.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((nested_blk_scope)nested_blk_stack.peek()).ids.add( (IDENTIFIER347!=null?IDENTIFIER347.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:559:4: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI349=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command2917); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI349_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI349);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI349_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER350=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2919); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER350_tree = (CommonTree)adaptor.dupNode(IDENTIFIER350);


                    adaptor.addChild(root_1, IDENTIFIER350_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command2921);
                    expr351=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr351.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((nested_blk_scope)nested_blk_stack.peek()).ids.add( (IDENTIFIER350!=null?IDENTIFIER350.getText():null) );
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:565:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AstValidator.nested_op_return nested_op() throws RecognitionException {
        AstValidator.nested_op_return retval = new AstValidator.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_proj_return nested_proj352 =null;

        AstValidator.nested_filter_return nested_filter353 =null;

        AstValidator.nested_sort_return nested_sort354 =null;

        AstValidator.nested_distinct_return nested_distinct355 =null;

        AstValidator.nested_limit_return nested_limit356 =null;

        AstValidator.nested_cross_return nested_cross357 =null;

        AstValidator.nested_foreach_return nested_foreach358 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:565:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt103=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt103=1;
                }
                break;
            case FILTER:
                {
                alt103=2;
                }
                break;
            case ORDER:
                {
                alt103=3;
                }
                break;
            case DISTINCT:
                {
                alt103=4;
                }
                break;
            case LIMIT:
                {
                alt103=5;
                }
                break;
            case CROSS:
                {
                alt103=6;
                }
                break;
            case FOREACH:
                {
                alt103=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }

            switch (alt103) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:565:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op2937);
                    nested_proj352=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj352.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:566:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op2951);
                    nested_filter353=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter353.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:567:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op2965);
                    nested_sort354=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort354.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:568:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op2979);
                    nested_distinct355=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct355.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:569:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op2993);
                    nested_limit356=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit356.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:570:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op3007);
                    nested_cross357=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross357.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:571:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op3021);
                    nested_foreach358=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach358.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:574:1: nested_proj : ^( NESTED_PROJ col_ref ( col_ref )+ ) ;
    public final AstValidator.nested_proj_return nested_proj() throws RecognitionException {
        AstValidator.nested_proj_return retval = new AstValidator.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ359=null;
        AstValidator.col_ref_return col_ref360 =null;

        AstValidator.col_ref_return col_ref361 =null;


        CommonTree NESTED_PROJ359_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:574:13: ( ^( NESTED_PROJ col_ref ( col_ref )+ ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:574:15: ^( NESTED_PROJ col_ref ( col_ref )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ359=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj3032); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ359_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ359);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ359_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj3034);
            col_ref360=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref360.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:574:38: ( col_ref )+
            int cnt104=0;
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==CUBE||LA104_0==DOLLARVAR||LA104_0==GROUP||LA104_0==IDENTIFIER) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:574:38: col_ref
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj3036);
            	    col_ref361=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref361.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt104 >= 1 ) break loop104;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(104, input);
                        throw eee;
                }
                cnt104++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:577:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AstValidator.nested_filter_return nested_filter() throws RecognitionException {
        AstValidator.nested_filter_return retval = new AstValidator.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER362=null;
        AstValidator.nested_op_input_return nested_op_input363 =null;

        AstValidator.cond_return cond364 =null;


        CommonTree FILTER362_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:578:2: ( ^( FILTER nested_op_input cond ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:578:4: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER362=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter3051); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER362_tree = (CommonTree)adaptor.dupNode(FILTER362);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER362_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter3053);
            nested_op_input363=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input363.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter3055);
            cond364=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond364.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:581:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AstValidator.nested_sort_return nested_sort() throws RecognitionException {
        AstValidator.nested_sort_return retval = new AstValidator.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER365=null;
        AstValidator.nested_op_input_return nested_op_input366 =null;

        AstValidator.order_by_clause_return order_by_clause367 =null;

        AstValidator.func_clause_return func_clause368 =null;


        CommonTree ORDER365_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:581:13: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:581:15: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER365=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort3068); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER365_tree = (CommonTree)adaptor.dupNode(ORDER365);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER365_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort3070);
            nested_op_input366=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input366.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort3073);
            order_by_clause367=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause367.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:581:57: ( func_clause )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==FUNC||LA105_0==FUNC_REF) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:581:57: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort3075);
                    func_clause368=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause368.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:584:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AstValidator.nested_distinct_return nested_distinct() throws RecognitionException {
        AstValidator.nested_distinct_return retval = new AstValidator.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT369=null;
        AstValidator.nested_op_input_return nested_op_input370 =null;


        CommonTree DISTINCT369_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:584:17: ( ^( DISTINCT nested_op_input ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:584:19: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT369=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct3089); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT369_tree = (CommonTree)adaptor.dupNode(DISTINCT369);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT369_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct3091);
            nested_op_input370=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input370.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:587:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AstValidator.nested_limit_return nested_limit() throws RecognitionException {
        AstValidator.nested_limit_return retval = new AstValidator.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT371=null;
        CommonTree INTEGER373=null;
        AstValidator.nested_op_input_return nested_op_input372 =null;

        AstValidator.expr_return expr374 =null;


        CommonTree LIMIT371_tree=null;
        CommonTree INTEGER373_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:587:14: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:587:16: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT371=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit3104); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT371_tree = (CommonTree)adaptor.dupNode(LIMIT371);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT371_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit3106);
            nested_op_input372=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input372.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:587:41: ( INTEGER | expr )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==INTEGER) ) {
                int LA106_1 = input.LA(2);

                if ( (synpred190_AstValidator()) ) {
                    alt106=1;
                }
                else if ( (true) ) {
                    alt106=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 106, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA106_0==BIGDECIMALNUMBER||LA106_0==BIGINTEGERNUMBER||LA106_0==CUBE||LA106_0==DIV||LA106_0==DOLLARVAR||LA106_0==DOUBLENUMBER||LA106_0==FALSE||LA106_0==FLOATNUMBER||LA106_0==GROUP||LA106_0==IDENTIFIER||LA106_0==LONGINTEGER||LA106_0==MINUS||LA106_0==NULL||LA106_0==PERCENT||LA106_0==PLUS||LA106_0==QUOTEDSTRING||LA106_0==STAR||LA106_0==TRUE||(LA106_0 >= BAG_VAL && LA106_0 <= BIN_EXPR)||(LA106_0 >= CASE_COND && LA106_0 <= CASE_EXPR)||LA106_0==CAST_EXPR||LA106_0==EXPR_IN_PAREN||LA106_0==FUNC_EVAL||LA106_0==INVOKER_FUNC_EVAL||(LA106_0 >= MAP_VAL && LA106_0 <= NEG)||LA106_0==TUPLE_VAL) ) {
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:587:43: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER373=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit3110); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER373_tree = (CommonTree)adaptor.dupNode(INTEGER373);


                    adaptor.addChild(root_1, INTEGER373_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:587:53: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit3114);
                    expr374=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr374.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:590:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AstValidator.nested_cross_return nested_cross() throws RecognitionException {
        AstValidator.nested_cross_return retval = new AstValidator.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS375=null;
        AstValidator.nested_op_input_list_return nested_op_input_list376 =null;


        CommonTree CROSS375_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:590:14: ( ^( CROSS nested_op_input_list ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:590:16: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS375=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross3129); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS375_tree = (CommonTree)adaptor.dupNode(CROSS375);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS375_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross3131);
            nested_op_input_list376=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list376.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:593:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AstValidator.nested_foreach_return nested_foreach() throws RecognitionException {
        AstValidator.nested_foreach_return retval = new AstValidator.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH377=null;
        AstValidator.nested_op_input_return nested_op_input378 =null;

        AstValidator.generate_clause_return generate_clause379 =null;


        CommonTree FOREACH377_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:593:16: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:593:18: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH377=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach3144); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH377_tree = (CommonTree)adaptor.dupNode(FOREACH377);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH377_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach3146);
            nested_op_input378=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input378.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach3148);
            generate_clause379=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause379.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:596:1: nested_op_input : ( col_ref | nested_proj );
    public final AstValidator.nested_op_input_return nested_op_input() throws RecognitionException {
        AstValidator.nested_op_input_return retval = new AstValidator.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.col_ref_return col_ref380 =null;

        AstValidator.nested_proj_return nested_proj381 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:596:17: ( col_ref | nested_proj )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==CUBE||LA107_0==DOLLARVAR||LA107_0==GROUP||LA107_0==IDENTIFIER) ) {
                alt107=1;
            }
            else if ( (LA107_0==NESTED_PROJ) ) {
                alt107=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;

            }
            switch (alt107) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:596:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input3159);
                    col_ref380=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref380.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:596:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input3163);
                    nested_proj381=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj381.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:599:1: nested_op_input_list : ( nested_op_input )+ ;
    public final AstValidator.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AstValidator.nested_op_input_list_return retval = new AstValidator.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_op_input_return nested_op_input382 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:599:22: ( ( nested_op_input )+ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:599:24: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:599:24: ( nested_op_input )+
            int cnt108=0;
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==CUBE||LA108_0==DOLLARVAR||LA108_0==GROUP||LA108_0==IDENTIFIER||LA108_0==NESTED_PROJ) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:599:24: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list3172);
            	    nested_op_input382=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input382.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt108 >= 1 ) break loop108;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(108, input);
                        throw eee;
                }
                cnt108++;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:602:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AstValidator.stream_clause_return stream_clause() throws RecognitionException {
        AstValidator.stream_clause_return retval = new AstValidator.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM383=null;
        CommonTree set385=null;
        AstValidator.rel_return rel384 =null;

        AstValidator.as_clause_return as_clause386 =null;


        CommonTree STREAM383_tree=null;
        CommonTree set385_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:602:15: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:602:17: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM383=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause3184); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM383_tree = (CommonTree)adaptor.dupNode(STREAM383);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM383_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause3186);
            rel384=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel384.getTree());


            _last = (CommonTree)input.LT(1);
            set385=(CommonTree)input.LT(1);

            if ( input.LA(1)==EXECCOMMAND||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set385_tree = (CommonTree)adaptor.dupNode(set385);


                adaptor.addChild(root_1, set385_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:602:60: ( as_clause )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==AS) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:602:60: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause3198);
                    as_clause386=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause386.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:605:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AstValidator.mr_clause_return mr_clause() throws RecognitionException {
        AstValidator.mr_clause_return retval = new AstValidator.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE387=null;
        CommonTree QUOTEDSTRING388=null;
        CommonTree EXECCOMMAND392=null;
        AstValidator.path_list_return path_list389 =null;

        AstValidator.store_clause_return store_clause390 =null;

        AstValidator.load_clause_return load_clause391 =null;


        CommonTree MAPREDUCE387_tree=null;
        CommonTree QUOTEDSTRING388_tree=null;
        CommonTree EXECCOMMAND392_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:605:11: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:605:13: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE387=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause3212); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE387_tree = (CommonTree)adaptor.dupNode(MAPREDUCE387);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE387_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING388=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause3214); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING388_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING388);


            adaptor.addChild(root_1, QUOTEDSTRING388_tree);
            }


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:605:39: ( path_list )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==QUOTEDSTRING) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:605:39: path_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause3216);
                    path_list389=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list389.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause3219);
            store_clause390=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause390.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause3221);
            load_clause391=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause391.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:605:75: ( EXECCOMMAND )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==EXECCOMMAND) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:605:75: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND392=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause3223); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND392_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND392);


                    adaptor.addChild(root_1, EXECCOMMAND392_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:608:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final AstValidator.split_clause_return split_clause() throws RecognitionException {
        AstValidator.split_clause_return retval = new AstValidator.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT393=null;
        AstValidator.rel_return rel394 =null;

        AstValidator.split_branch_return split_branch395 =null;

        AstValidator.split_otherwise_return split_otherwise396 =null;


        CommonTree SPLIT393_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:608:14: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:608:16: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT393=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause3237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT393_tree = (CommonTree)adaptor.dupNode(SPLIT393);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT393_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause3239);
            rel394=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel394.getTree());


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:608:29: ( split_branch )+
            int cnt112=0;
            loop112:
            do {
                int alt112=2;
                int LA112_0 = input.LA(1);

                if ( (LA112_0==SPLIT_BRANCH) ) {
                    alt112=1;
                }


                switch (alt112) {
            	case 1 :
            	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:608:29: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause3241);
            	    split_branch395=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch395.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt112 >= 1 ) break loop112;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(112, input);
                        throw eee;
                }
                cnt112++;
            } while (true);


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:608:43: ( split_otherwise )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==OTHERWISE) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:608:43: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause3244);
                    split_otherwise396=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise396.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:611:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AstValidator.split_branch_return split_branch() throws RecognitionException {
        AstValidator.split_branch_return retval = new AstValidator.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH397=null;
        AstValidator.alias_return alias398 =null;

        AstValidator.cond_return cond399 =null;


        CommonTree SPLIT_BRANCH397_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:612:2: ( ^( SPLIT_BRANCH alias cond ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:612:4: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH397=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch3259); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH397_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH397);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH397_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch3261);
            alias398=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias398.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch3263);
            cond399=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond399.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias398!=null?alias398.name:null) );
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:618:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AstValidator.split_otherwise_return split_otherwise() throws RecognitionException {
        AstValidator.split_otherwise_return retval = new AstValidator.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE400=null;
        AstValidator.alias_return alias401 =null;


        CommonTree OTHERWISE400_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:618:17: ( ^( OTHERWISE alias ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:618:19: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE400=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise3281); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE400_tree = (CommonTree)adaptor.dupNode(OTHERWISE400);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE400_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise3283);
            alias401=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias401.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias401!=null?alias401.name:null) );
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:624:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AstValidator.col_ref_return col_ref() throws RecognitionException {
        AstValidator.col_ref_return retval = new AstValidator.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.alias_col_ref_return alias_col_ref402 =null;

        AstValidator.dollar_col_ref_return dollar_col_ref403 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:624:9: ( alias_col_ref | dollar_col_ref )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==CUBE||LA114_0==GROUP||LA114_0==IDENTIFIER) ) {
                alt114=1;
            }
            else if ( (LA114_0==DOLLARVAR) ) {
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:624:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref3299);
                    alias_col_ref402=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref402.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:624:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref3303);
                    dollar_col_ref403=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref403.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:627:1: alias_col_ref : ( GROUP | CUBE | IDENTIFIER );
    public final AstValidator.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AstValidator.alias_col_ref_return retval = new AstValidator.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set404=null;

        CommonTree set404_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:627:15: ( GROUP | CUBE | IDENTIFIER )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set404=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set404_tree = (CommonTree)adaptor.dupNode(set404);


                adaptor.addChild(root_0, set404_tree);
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
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:630:1: dollar_col_ref : DOLLARVAR ;
    public final AstValidator.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AstValidator.dollar_col_ref_return retval = new AstValidator.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR405=null;

        CommonTree DOLLARVAR405_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:630:16: ( DOLLARVAR )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:630:18: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR405=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref3329); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR405_tree = (CommonTree)adaptor.dupNode(DOLLARVAR405);


            adaptor.addChild(root_0, DOLLARVAR405_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:633:1: const_expr : literal ;
    public final AstValidator.const_expr_return const_expr() throws RecognitionException {
        AstValidator.const_expr_return retval = new AstValidator.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.literal_return literal406 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:633:12: ( literal )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:633:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr3338);
            literal406=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal406.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:636:1: literal : ( scalar | map | bag | tuple );
    public final AstValidator.literal_return literal() throws RecognitionException {
        AstValidator.literal_return retval = new AstValidator.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.scalar_return scalar407 =null;

        AstValidator.map_return map408 =null;

        AstValidator.bag_return bag409 =null;

        AstValidator.tuple_return tuple410 =null;



        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:636:9: ( scalar | map | bag | tuple )
            int alt115=4;
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
                alt115=1;
                }
                break;
            case MAP_VAL:
                {
                alt115=2;
                }
                break;
            case BAG_VAL:
                {
                alt115=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt115=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;

            }

            switch (alt115) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:636:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal3347);
                    scalar407=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar407.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:636:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal3351);
                    map408=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map408.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:636:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal3355);
                    bag409=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag409.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:636:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal3359);
                    tuple410=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple410.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:639:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AstValidator.scalar_return scalar() throws RecognitionException {
        AstValidator.scalar_return retval = new AstValidator.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING412=null;
        CommonTree NULL413=null;
        CommonTree TRUE414=null;
        CommonTree FALSE415=null;
        AstValidator.num_scalar_return num_scalar411 =null;


        CommonTree QUOTEDSTRING412_tree=null;
        CommonTree NULL413_tree=null;
        CommonTree TRUE414_tree=null;
        CommonTree FALSE415_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:639:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt116=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt116=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt116=2;
                }
                break;
            case NULL:
                {
                alt116=3;
                }
                break;
            case TRUE:
                {
                alt116=4;
                }
                break;
            case FALSE:
                {
                alt116=5;
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
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:639:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar3368);
                    num_scalar411=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar411.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:639:23: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING412=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar3372); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING412_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING412);


                    adaptor.addChild(root_0, QUOTEDSTRING412_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:639:38: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL413=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar3376); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL413_tree = (CommonTree)adaptor.dupNode(NULL413);


                    adaptor.addChild(root_0, NULL413_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:639:45: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE414=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar3380); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE414_tree = (CommonTree)adaptor.dupNode(TRUE414);


                    adaptor.addChild(root_0, TRUE414_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:639:52: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE415=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar3384); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE415_tree = (CommonTree)adaptor.dupNode(FALSE415);


                    adaptor.addChild(root_0, FALSE415_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:642:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final AstValidator.num_scalar_return num_scalar() throws RecognitionException {
        AstValidator.num_scalar_return retval = new AstValidator.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS416=null;
        CommonTree set417=null;

        CommonTree MINUS416_tree=null;
        CommonTree set417_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:642:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:642:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:642:14: ( MINUS )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==MINUS) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:642:14: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS416=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar3393); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS416_tree = (CommonTree)adaptor.dupNode(MINUS416);


                    adaptor.addChild(root_0, MINUS416_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            set417=(CommonTree)input.LT(1);

            if ( input.LA(1)==BIGDECIMALNUMBER||input.LA(1)==BIGINTEGERNUMBER||input.LA(1)==DOUBLENUMBER||input.LA(1)==FLOATNUMBER||input.LA(1)==INTEGER||input.LA(1)==LONGINTEGER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set417_tree = (CommonTree)adaptor.dupNode(set417);


                adaptor.addChild(root_0, set417_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:645:1: map : ^( MAP_VAL ( keyvalue )* ) ;
    public final AstValidator.map_return map() throws RecognitionException {
        AstValidator.map_return retval = new AstValidator.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL418=null;
        AstValidator.keyvalue_return keyvalue419 =null;


        CommonTree MAP_VAL418_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:645:5: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:645:7: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL418=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map3431); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL418_tree = (CommonTree)adaptor.dupNode(MAP_VAL418);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL418_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:645:18: ( keyvalue )*
                loop118:
                do {
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( (LA118_0==KEY_VAL_PAIR) ) {
                        alt118=1;
                    }


                    switch (alt118) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:645:18: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map3433);
                	    keyvalue419=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue419.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop118;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:648:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AstValidator.keyvalue_return keyvalue() throws RecognitionException {
        AstValidator.keyvalue_return retval = new AstValidator.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR420=null;
        AstValidator.map_key_return map_key421 =null;

        AstValidator.const_expr_return const_expr422 =null;


        CommonTree KEY_VAL_PAIR420_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:648:10: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:648:12: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR420=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue3447); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR420_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR420);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR420_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue3449);
            map_key421=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key421.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue3451);
            const_expr422=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr422.getTree());


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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:651:1: map_key : QUOTEDSTRING ;
    public final AstValidator.map_key_return map_key() throws RecognitionException {
        AstValidator.map_key_return retval = new AstValidator.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING423=null;

        CommonTree QUOTEDSTRING423_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:651:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:651:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING423=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key3462); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING423_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING423);


            adaptor.addChild(root_0, QUOTEDSTRING423_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:654:1: bag : ^( BAG_VAL ( tuple )* ) ;
    public final AstValidator.bag_return bag() throws RecognitionException {
        AstValidator.bag_return retval = new AstValidator.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL424=null;
        AstValidator.tuple_return tuple425 =null;


        CommonTree BAG_VAL424_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:654:5: ( ^( BAG_VAL ( tuple )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:654:7: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL424=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag3473); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL424_tree = (CommonTree)adaptor.dupNode(BAG_VAL424);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL424_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:654:18: ( tuple )*
                loop119:
                do {
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( (LA119_0==TUPLE_VAL) ) {
                        alt119=1;
                    }


                    switch (alt119) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:654:18: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag3475);
                	    tuple425=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple425.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop119;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:657:1: tuple : ^( TUPLE_VAL ( literal )* ) ;
    public final AstValidator.tuple_return tuple() throws RecognitionException {
        AstValidator.tuple_return retval = new AstValidator.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL426=null;
        AstValidator.literal_return literal427 =null;


        CommonTree TUPLE_VAL426_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:657:7: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:657:9: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL426=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple3489); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL426_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL426);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL426_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:657:22: ( literal )*
                loop120:
                do {
                    int alt120=2;
                    int LA120_0 = input.LA(1);

                    if ( (LA120_0==BIGDECIMALNUMBER||LA120_0==BIGINTEGERNUMBER||LA120_0==DOUBLENUMBER||LA120_0==FALSE||LA120_0==FLOATNUMBER||LA120_0==INTEGER||LA120_0==LONGINTEGER||LA120_0==MINUS||LA120_0==NULL||LA120_0==QUOTEDSTRING||LA120_0==TRUE||LA120_0==BAG_VAL||LA120_0==MAP_VAL||LA120_0==TUPLE_VAL) ) {
                        alt120=1;
                    }


                    switch (alt120) {
                	case 1 :
                	    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:657:22: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple3491);
                	    literal427=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal427.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop120;
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:661:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | PIVOT | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT );
    public final AstValidator.eid_return eid() throws RecognitionException {
        AstValidator.eid_return retval = new AstValidator.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT429=null;
        CommonTree RETURNS430=null;
        CommonTree DEFINE431=null;
        CommonTree LOAD432=null;
        CommonTree FILTER433=null;
        CommonTree FOREACH434=null;
        CommonTree CUBE435=null;
        CommonTree ROLLUP436=null;
        CommonTree PIVOT437=null;
        CommonTree MATCHES438=null;
        CommonTree ORDER439=null;
        CommonTree RANK440=null;
        CommonTree DISTINCT441=null;
        CommonTree COGROUP442=null;
        CommonTree JOIN443=null;
        CommonTree CROSS444=null;
        CommonTree UNION445=null;
        CommonTree SPLIT446=null;
        CommonTree INTO447=null;
        CommonTree IF448=null;
        CommonTree ALL449=null;
        CommonTree AS450=null;
        CommonTree BY451=null;
        CommonTree USING452=null;
        CommonTree INNER453=null;
        CommonTree OUTER454=null;
        CommonTree PARALLEL455=null;
        CommonTree PARTITION456=null;
        CommonTree GROUP457=null;
        CommonTree AND458=null;
        CommonTree OR459=null;
        CommonTree NOT460=null;
        CommonTree GENERATE461=null;
        CommonTree FLATTEN462=null;
        CommonTree EVAL463=null;
        CommonTree ASC464=null;
        CommonTree DESC465=null;
        CommonTree BOOLEAN466=null;
        CommonTree INT467=null;
        CommonTree LONG468=null;
        CommonTree FLOAT469=null;
        CommonTree DOUBLE470=null;
        CommonTree BIGINTEGER471=null;
        CommonTree BIGDECIMAL472=null;
        CommonTree DATETIME473=null;
        CommonTree CHARARRAY474=null;
        CommonTree BYTEARRAY475=null;
        CommonTree BAG476=null;
        CommonTree TUPLE477=null;
        CommonTree MAP478=null;
        CommonTree IS479=null;
        CommonTree NULL480=null;
        CommonTree TRUE481=null;
        CommonTree FALSE482=null;
        CommonTree STREAM483=null;
        CommonTree THROUGH484=null;
        CommonTree STORE485=null;
        CommonTree MAPREDUCE486=null;
        CommonTree SHIP487=null;
        CommonTree CACHE488=null;
        CommonTree INPUT489=null;
        CommonTree OUTPUT490=null;
        CommonTree STDERROR491=null;
        CommonTree STDIN492=null;
        CommonTree STDOUT493=null;
        CommonTree LIMIT494=null;
        CommonTree SAMPLE495=null;
        CommonTree LEFT496=null;
        CommonTree RIGHT497=null;
        CommonTree FULL498=null;
        CommonTree IDENTIFIER499=null;
        CommonTree TOBAG500=null;
        CommonTree TOMAP501=null;
        CommonTree TOTUPLE502=null;
        CommonTree ASSERT503=null;
        AstValidator.rel_str_op_return rel_str_op428 =null;


        CommonTree IMPORT429_tree=null;
        CommonTree RETURNS430_tree=null;
        CommonTree DEFINE431_tree=null;
        CommonTree LOAD432_tree=null;
        CommonTree FILTER433_tree=null;
        CommonTree FOREACH434_tree=null;
        CommonTree CUBE435_tree=null;
        CommonTree ROLLUP436_tree=null;
        CommonTree PIVOT437_tree=null;
        CommonTree MATCHES438_tree=null;
        CommonTree ORDER439_tree=null;
        CommonTree RANK440_tree=null;
        CommonTree DISTINCT441_tree=null;
        CommonTree COGROUP442_tree=null;
        CommonTree JOIN443_tree=null;
        CommonTree CROSS444_tree=null;
        CommonTree UNION445_tree=null;
        CommonTree SPLIT446_tree=null;
        CommonTree INTO447_tree=null;
        CommonTree IF448_tree=null;
        CommonTree ALL449_tree=null;
        CommonTree AS450_tree=null;
        CommonTree BY451_tree=null;
        CommonTree USING452_tree=null;
        CommonTree INNER453_tree=null;
        CommonTree OUTER454_tree=null;
        CommonTree PARALLEL455_tree=null;
        CommonTree PARTITION456_tree=null;
        CommonTree GROUP457_tree=null;
        CommonTree AND458_tree=null;
        CommonTree OR459_tree=null;
        CommonTree NOT460_tree=null;
        CommonTree GENERATE461_tree=null;
        CommonTree FLATTEN462_tree=null;
        CommonTree EVAL463_tree=null;
        CommonTree ASC464_tree=null;
        CommonTree DESC465_tree=null;
        CommonTree BOOLEAN466_tree=null;
        CommonTree INT467_tree=null;
        CommonTree LONG468_tree=null;
        CommonTree FLOAT469_tree=null;
        CommonTree DOUBLE470_tree=null;
        CommonTree BIGINTEGER471_tree=null;
        CommonTree BIGDECIMAL472_tree=null;
        CommonTree DATETIME473_tree=null;
        CommonTree CHARARRAY474_tree=null;
        CommonTree BYTEARRAY475_tree=null;
        CommonTree BAG476_tree=null;
        CommonTree TUPLE477_tree=null;
        CommonTree MAP478_tree=null;
        CommonTree IS479_tree=null;
        CommonTree NULL480_tree=null;
        CommonTree TRUE481_tree=null;
        CommonTree FALSE482_tree=null;
        CommonTree STREAM483_tree=null;
        CommonTree THROUGH484_tree=null;
        CommonTree STORE485_tree=null;
        CommonTree MAPREDUCE486_tree=null;
        CommonTree SHIP487_tree=null;
        CommonTree CACHE488_tree=null;
        CommonTree INPUT489_tree=null;
        CommonTree OUTPUT490_tree=null;
        CommonTree STDERROR491_tree=null;
        CommonTree STDIN492_tree=null;
        CommonTree STDOUT493_tree=null;
        CommonTree LIMIT494_tree=null;
        CommonTree SAMPLE495_tree=null;
        CommonTree LEFT496_tree=null;
        CommonTree RIGHT497_tree=null;
        CommonTree FULL498_tree=null;
        CommonTree IDENTIFIER499_tree=null;
        CommonTree TOBAG500_tree=null;
        CommonTree TOMAP501_tree=null;
        CommonTree TOTUPLE502_tree=null;
        CommonTree ASSERT503_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:661:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | PIVOT | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT )
            int alt121=76;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt121=1;
                }
                break;
            case IMPORT:
                {
                alt121=2;
                }
                break;
            case RETURNS:
                {
                alt121=3;
                }
                break;
            case DEFINE:
                {
                alt121=4;
                }
                break;
            case LOAD:
                {
                alt121=5;
                }
                break;
            case FILTER:
                {
                alt121=6;
                }
                break;
            case FOREACH:
                {
                alt121=7;
                }
                break;
            case CUBE:
                {
                alt121=8;
                }
                break;
            case ROLLUP:
                {
                alt121=9;
                }
                break;
            case PIVOT:
                {
                alt121=10;
                }
                break;
            case MATCHES:
                {
                alt121=11;
                }
                break;
            case ORDER:
                {
                alt121=12;
                }
                break;
            case RANK:
                {
                alt121=13;
                }
                break;
            case DISTINCT:
                {
                alt121=14;
                }
                break;
            case COGROUP:
                {
                alt121=15;
                }
                break;
            case JOIN:
                {
                alt121=16;
                }
                break;
            case CROSS:
                {
                alt121=17;
                }
                break;
            case UNION:
                {
                alt121=18;
                }
                break;
            case SPLIT:
                {
                alt121=19;
                }
                break;
            case INTO:
                {
                alt121=20;
                }
                break;
            case IF:
                {
                alt121=21;
                }
                break;
            case ALL:
                {
                alt121=22;
                }
                break;
            case AS:
                {
                alt121=23;
                }
                break;
            case BY:
                {
                alt121=24;
                }
                break;
            case USING:
                {
                alt121=25;
                }
                break;
            case INNER:
                {
                alt121=26;
                }
                break;
            case OUTER:
                {
                alt121=27;
                }
                break;
            case PARALLEL:
                {
                alt121=28;
                }
                break;
            case PARTITION:
                {
                alt121=29;
                }
                break;
            case GROUP:
                {
                alt121=30;
                }
                break;
            case AND:
                {
                alt121=31;
                }
                break;
            case OR:
                {
                alt121=32;
                }
                break;
            case NOT:
                {
                alt121=33;
                }
                break;
            case GENERATE:
                {
                alt121=34;
                }
                break;
            case FLATTEN:
                {
                alt121=35;
                }
                break;
            case EVAL:
                {
                alt121=36;
                }
                break;
            case ASC:
                {
                alt121=37;
                }
                break;
            case DESC:
                {
                alt121=38;
                }
                break;
            case BOOLEAN:
                {
                alt121=39;
                }
                break;
            case INT:
                {
                alt121=40;
                }
                break;
            case LONG:
                {
                alt121=41;
                }
                break;
            case FLOAT:
                {
                alt121=42;
                }
                break;
            case DOUBLE:
                {
                alt121=43;
                }
                break;
            case BIGINTEGER:
                {
                alt121=44;
                }
                break;
            case BIGDECIMAL:
                {
                alt121=45;
                }
                break;
            case DATETIME:
                {
                alt121=46;
                }
                break;
            case CHARARRAY:
                {
                alt121=47;
                }
                break;
            case BYTEARRAY:
                {
                alt121=48;
                }
                break;
            case BAG:
                {
                alt121=49;
                }
                break;
            case TUPLE:
                {
                alt121=50;
                }
                break;
            case MAP:
                {
                alt121=51;
                }
                break;
            case IS:
                {
                alt121=52;
                }
                break;
            case NULL:
                {
                alt121=53;
                }
                break;
            case TRUE:
                {
                alt121=54;
                }
                break;
            case FALSE:
                {
                alt121=55;
                }
                break;
            case STREAM:
                {
                alt121=56;
                }
                break;
            case THROUGH:
                {
                alt121=57;
                }
                break;
            case STORE:
                {
                alt121=58;
                }
                break;
            case MAPREDUCE:
                {
                alt121=59;
                }
                break;
            case SHIP:
                {
                alt121=60;
                }
                break;
            case CACHE:
                {
                alt121=61;
                }
                break;
            case INPUT:
                {
                alt121=62;
                }
                break;
            case OUTPUT:
                {
                alt121=63;
                }
                break;
            case STDERROR:
                {
                alt121=64;
                }
                break;
            case STDIN:
                {
                alt121=65;
                }
                break;
            case STDOUT:
                {
                alt121=66;
                }
                break;
            case LIMIT:
                {
                alt121=67;
                }
                break;
            case SAMPLE:
                {
                alt121=68;
                }
                break;
            case LEFT:
                {
                alt121=69;
                }
                break;
            case RIGHT:
                {
                alt121=70;
                }
                break;
            case FULL:
                {
                alt121=71;
                }
                break;
            case IDENTIFIER:
                {
                alt121=72;
                }
                break;
            case TOBAG:
                {
                alt121=73;
                }
                break;
            case TOMAP:
                {
                alt121=74;
                }
                break;
            case TOTUPLE:
                {
                alt121=75;
                }
                break;
            case ASSERT:
                {
                alt121=76;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;

            }

            switch (alt121) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:661:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid3504);
                    rel_str_op428=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op428.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:662:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT429=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid3512); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT429_tree = (CommonTree)adaptor.dupNode(IMPORT429);


                    adaptor.addChild(root_0, IMPORT429_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:663:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS430=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid3520); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS430_tree = (CommonTree)adaptor.dupNode(RETURNS430);


                    adaptor.addChild(root_0, RETURNS430_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:664:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE431=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid3528); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE431_tree = (CommonTree)adaptor.dupNode(DEFINE431);


                    adaptor.addChild(root_0, DEFINE431_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:665:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD432=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid3536); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD432_tree = (CommonTree)adaptor.dupNode(LOAD432);


                    adaptor.addChild(root_0, LOAD432_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:666:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER433=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid3544); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER433_tree = (CommonTree)adaptor.dupNode(FILTER433);


                    adaptor.addChild(root_0, FILTER433_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:667:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH434=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid3552); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH434_tree = (CommonTree)adaptor.dupNode(FOREACH434);


                    adaptor.addChild(root_0, FOREACH434_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:668:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE435=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid3560); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE435_tree = (CommonTree)adaptor.dupNode(CUBE435);


                    adaptor.addChild(root_0, CUBE435_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:669:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP436=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid3568); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP436_tree = (CommonTree)adaptor.dupNode(ROLLUP436);


                    adaptor.addChild(root_0, ROLLUP436_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:670:7: PIVOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PIVOT437=(CommonTree)match(input,PIVOT,FOLLOW_PIVOT_in_eid3576); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PIVOT437_tree = (CommonTree)adaptor.dupNode(PIVOT437);


                    adaptor.addChild(root_0, PIVOT437_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:671:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES438=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid3584); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES438_tree = (CommonTree)adaptor.dupNode(MATCHES438);


                    adaptor.addChild(root_0, MATCHES438_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:672:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER439=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid3592); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER439_tree = (CommonTree)adaptor.dupNode(ORDER439);


                    adaptor.addChild(root_0, ORDER439_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:673:7: RANK
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RANK440=(CommonTree)match(input,RANK,FOLLOW_RANK_in_eid3600); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RANK440_tree = (CommonTree)adaptor.dupNode(RANK440);


                    adaptor.addChild(root_0, RANK440_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:674:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT441=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid3608); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT441_tree = (CommonTree)adaptor.dupNode(DISTINCT441);


                    adaptor.addChild(root_0, DISTINCT441_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:675:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP442=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid3616); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP442_tree = (CommonTree)adaptor.dupNode(COGROUP442);


                    adaptor.addChild(root_0, COGROUP442_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:676:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN443=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid3624); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN443_tree = (CommonTree)adaptor.dupNode(JOIN443);


                    adaptor.addChild(root_0, JOIN443_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:677:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS444=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid3632); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS444_tree = (CommonTree)adaptor.dupNode(CROSS444);


                    adaptor.addChild(root_0, CROSS444_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:678:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION445=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid3640); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION445_tree = (CommonTree)adaptor.dupNode(UNION445);


                    adaptor.addChild(root_0, UNION445_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:679:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT446=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid3648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT446_tree = (CommonTree)adaptor.dupNode(SPLIT446);


                    adaptor.addChild(root_0, SPLIT446_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:680:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO447=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid3656); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO447_tree = (CommonTree)adaptor.dupNode(INTO447);


                    adaptor.addChild(root_0, INTO447_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:681:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF448=(CommonTree)match(input,IF,FOLLOW_IF_in_eid3664); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF448_tree = (CommonTree)adaptor.dupNode(IF448);


                    adaptor.addChild(root_0, IF448_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:682:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL449=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid3672); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL449_tree = (CommonTree)adaptor.dupNode(ALL449);


                    adaptor.addChild(root_0, ALL449_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:683:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS450=(CommonTree)match(input,AS,FOLLOW_AS_in_eid3680); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS450_tree = (CommonTree)adaptor.dupNode(AS450);


                    adaptor.addChild(root_0, AS450_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:684:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY451=(CommonTree)match(input,BY,FOLLOW_BY_in_eid3688); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY451_tree = (CommonTree)adaptor.dupNode(BY451);


                    adaptor.addChild(root_0, BY451_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:685:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING452=(CommonTree)match(input,USING,FOLLOW_USING_in_eid3696); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING452_tree = (CommonTree)adaptor.dupNode(USING452);


                    adaptor.addChild(root_0, USING452_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:686:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER453=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid3704); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER453_tree = (CommonTree)adaptor.dupNode(INNER453);


                    adaptor.addChild(root_0, INNER453_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:687:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER454=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid3712); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER454_tree = (CommonTree)adaptor.dupNode(OUTER454);


                    adaptor.addChild(root_0, OUTER454_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:688:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL455=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid3720); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL455_tree = (CommonTree)adaptor.dupNode(PARALLEL455);


                    adaptor.addChild(root_0, PARALLEL455_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:689:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION456=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid3728); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION456_tree = (CommonTree)adaptor.dupNode(PARTITION456);


                    adaptor.addChild(root_0, PARTITION456_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:690:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP457=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid3736); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP457_tree = (CommonTree)adaptor.dupNode(GROUP457);


                    adaptor.addChild(root_0, GROUP457_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:691:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND458=(CommonTree)match(input,AND,FOLLOW_AND_in_eid3744); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND458_tree = (CommonTree)adaptor.dupNode(AND458);


                    adaptor.addChild(root_0, AND458_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:692:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR459=(CommonTree)match(input,OR,FOLLOW_OR_in_eid3752); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR459_tree = (CommonTree)adaptor.dupNode(OR459);


                    adaptor.addChild(root_0, OR459_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:693:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT460=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid3760); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT460_tree = (CommonTree)adaptor.dupNode(NOT460);


                    adaptor.addChild(root_0, NOT460_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:694:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE461=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid3768); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE461_tree = (CommonTree)adaptor.dupNode(GENERATE461);


                    adaptor.addChild(root_0, GENERATE461_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:695:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN462=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid3776); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN462_tree = (CommonTree)adaptor.dupNode(FLATTEN462);


                    adaptor.addChild(root_0, FLATTEN462_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:696:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL463=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid3784); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL463_tree = (CommonTree)adaptor.dupNode(EVAL463);


                    adaptor.addChild(root_0, EVAL463_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:697:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC464=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid3792); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC464_tree = (CommonTree)adaptor.dupNode(ASC464);


                    adaptor.addChild(root_0, ASC464_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:698:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC465=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid3800); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC465_tree = (CommonTree)adaptor.dupNode(DESC465);


                    adaptor.addChild(root_0, DESC465_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:699:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN466=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid3808); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN466_tree = (CommonTree)adaptor.dupNode(BOOLEAN466);


                    adaptor.addChild(root_0, BOOLEAN466_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:700:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT467=(CommonTree)match(input,INT,FOLLOW_INT_in_eid3816); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT467_tree = (CommonTree)adaptor.dupNode(INT467);


                    adaptor.addChild(root_0, INT467_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:701:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG468=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid3824); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG468_tree = (CommonTree)adaptor.dupNode(LONG468);


                    adaptor.addChild(root_0, LONG468_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:702:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT469=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid3832); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT469_tree = (CommonTree)adaptor.dupNode(FLOAT469);


                    adaptor.addChild(root_0, FLOAT469_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:703:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE470=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid3840); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE470_tree = (CommonTree)adaptor.dupNode(DOUBLE470);


                    adaptor.addChild(root_0, DOUBLE470_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:704:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER471=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid3848); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER471_tree = (CommonTree)adaptor.dupNode(BIGINTEGER471);


                    adaptor.addChild(root_0, BIGINTEGER471_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:705:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL472=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid3856); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL472_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL472);


                    adaptor.addChild(root_0, BIGDECIMAL472_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:706:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME473=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid3864); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME473_tree = (CommonTree)adaptor.dupNode(DATETIME473);


                    adaptor.addChild(root_0, DATETIME473_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:707:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY474=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid3872); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY474_tree = (CommonTree)adaptor.dupNode(CHARARRAY474);


                    adaptor.addChild(root_0, CHARARRAY474_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:708:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY475=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid3880); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY475_tree = (CommonTree)adaptor.dupNode(BYTEARRAY475);


                    adaptor.addChild(root_0, BYTEARRAY475_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:709:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG476=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid3888); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG476_tree = (CommonTree)adaptor.dupNode(BAG476);


                    adaptor.addChild(root_0, BAG476_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:710:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE477=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid3896); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE477_tree = (CommonTree)adaptor.dupNode(TUPLE477);


                    adaptor.addChild(root_0, TUPLE477_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:711:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP478=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid3904); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP478_tree = (CommonTree)adaptor.dupNode(MAP478);


                    adaptor.addChild(root_0, MAP478_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:712:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS479=(CommonTree)match(input,IS,FOLLOW_IS_in_eid3912); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS479_tree = (CommonTree)adaptor.dupNode(IS479);


                    adaptor.addChild(root_0, IS479_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:713:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL480=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid3920); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL480_tree = (CommonTree)adaptor.dupNode(NULL480);


                    adaptor.addChild(root_0, NULL480_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:714:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE481=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid3928); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE481_tree = (CommonTree)adaptor.dupNode(TRUE481);


                    adaptor.addChild(root_0, TRUE481_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:715:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE482=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid3936); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE482_tree = (CommonTree)adaptor.dupNode(FALSE482);


                    adaptor.addChild(root_0, FALSE482_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:716:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM483=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid3944); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM483_tree = (CommonTree)adaptor.dupNode(STREAM483);


                    adaptor.addChild(root_0, STREAM483_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:717:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH484=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid3952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH484_tree = (CommonTree)adaptor.dupNode(THROUGH484);


                    adaptor.addChild(root_0, THROUGH484_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:718:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE485=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid3960); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE485_tree = (CommonTree)adaptor.dupNode(STORE485);


                    adaptor.addChild(root_0, STORE485_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:719:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE486=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid3968); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE486_tree = (CommonTree)adaptor.dupNode(MAPREDUCE486);


                    adaptor.addChild(root_0, MAPREDUCE486_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:720:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP487=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid3976); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP487_tree = (CommonTree)adaptor.dupNode(SHIP487);


                    adaptor.addChild(root_0, SHIP487_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:721:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE488=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid3984); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE488_tree = (CommonTree)adaptor.dupNode(CACHE488);


                    adaptor.addChild(root_0, CACHE488_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:722:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT489=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid3992); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT489_tree = (CommonTree)adaptor.dupNode(INPUT489);


                    adaptor.addChild(root_0, INPUT489_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:723:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT490=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid4000); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT490_tree = (CommonTree)adaptor.dupNode(OUTPUT490);


                    adaptor.addChild(root_0, OUTPUT490_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:724:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR491=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid4008); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR491_tree = (CommonTree)adaptor.dupNode(STDERROR491);


                    adaptor.addChild(root_0, STDERROR491_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:725:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN492=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid4016); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN492_tree = (CommonTree)adaptor.dupNode(STDIN492);


                    adaptor.addChild(root_0, STDIN492_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:726:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT493=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid4024); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT493_tree = (CommonTree)adaptor.dupNode(STDOUT493);


                    adaptor.addChild(root_0, STDOUT493_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:727:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT494=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid4032); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT494_tree = (CommonTree)adaptor.dupNode(LIMIT494);


                    adaptor.addChild(root_0, LIMIT494_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:728:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE495=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid4040); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE495_tree = (CommonTree)adaptor.dupNode(SAMPLE495);


                    adaptor.addChild(root_0, SAMPLE495_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:729:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT496=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid4048); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT496_tree = (CommonTree)adaptor.dupNode(LEFT496);


                    adaptor.addChild(root_0, LEFT496_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:730:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT497=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid4056); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT497_tree = (CommonTree)adaptor.dupNode(RIGHT497);


                    adaptor.addChild(root_0, RIGHT497_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:731:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL498=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid4064); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL498_tree = (CommonTree)adaptor.dupNode(FULL498);


                    adaptor.addChild(root_0, FULL498_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:732:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER499=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid4072); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER499_tree = (CommonTree)adaptor.dupNode(IDENTIFIER499);


                    adaptor.addChild(root_0, IDENTIFIER499_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:733:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG500=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid4080); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG500_tree = (CommonTree)adaptor.dupNode(TOBAG500);


                    adaptor.addChild(root_0, TOBAG500_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:734:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP501=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid4088); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP501_tree = (CommonTree)adaptor.dupNode(TOMAP501);


                    adaptor.addChild(root_0, TOMAP501_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 75 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:735:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE502=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid4096); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE502_tree = (CommonTree)adaptor.dupNode(TOTUPLE502);


                    adaptor.addChild(root_0, TOTUPLE502_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 76 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:736:7: ASSERT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASSERT503=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_eid4104); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSERT503_tree = (CommonTree)adaptor.dupNode(ASSERT503);


                    adaptor.addChild(root_0, ASSERT503_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:740:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AstValidator.rel_op_return rel_op() throws RecognitionException {
        AstValidator.rel_op_return retval = new AstValidator.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES510=null;
        AstValidator.rel_op_eq_return rel_op_eq504 =null;

        AstValidator.rel_op_ne_return rel_op_ne505 =null;

        AstValidator.rel_op_gt_return rel_op_gt506 =null;

        AstValidator.rel_op_gte_return rel_op_gte507 =null;

        AstValidator.rel_op_lt_return rel_op_lt508 =null;

        AstValidator.rel_op_lte_return rel_op_lte509 =null;


        CommonTree STR_OP_MATCHES510_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:740:8: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt122=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt122=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt122=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt122=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt122=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt122=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt122=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt122=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;

            }

            switch (alt122) {
                case 1 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:740:10: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op4114);
                    rel_op_eq504=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq504.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:741:10: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op4125);
                    rel_op_ne505=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne505.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:742:10: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op4136);
                    rel_op_gt506=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt506.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:743:10: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op4147);
                    rel_op_gte507=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte507.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:744:10: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op4158);
                    rel_op_lt508=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt508.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:745:10: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op4169);
                    rel_op_lte509=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte509.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:746:10: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES510=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op4180); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES510_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES510);


                    adaptor.addChild(root_0, STR_OP_MATCHES510_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:749:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final AstValidator.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AstValidator.rel_op_eq_return retval = new AstValidator.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set511=null;

        CommonTree set511_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:749:11: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set511=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set511_tree = (CommonTree)adaptor.dupNode(set511);


                adaptor.addChild(root_0, set511_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:752:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final AstValidator.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AstValidator.rel_op_ne_return retval = new AstValidator.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set512=null;

        CommonTree set512_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:752:11: ( STR_OP_NE | NUM_OP_NE )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set512=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set512_tree = (CommonTree)adaptor.dupNode(set512);


                adaptor.addChild(root_0, set512_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:755:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final AstValidator.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AstValidator.rel_op_gt_return retval = new AstValidator.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set513=null;

        CommonTree set513_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:755:11: ( STR_OP_GT | NUM_OP_GT )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set513=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set513_tree = (CommonTree)adaptor.dupNode(set513);


                adaptor.addChild(root_0, set513_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:758:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final AstValidator.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AstValidator.rel_op_gte_return retval = new AstValidator.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set514=null;

        CommonTree set514_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:758:12: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set514=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set514_tree = (CommonTree)adaptor.dupNode(set514);


                adaptor.addChild(root_0, set514_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:761:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final AstValidator.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AstValidator.rel_op_lt_return retval = new AstValidator.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set515=null;

        CommonTree set515_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:761:11: ( STR_OP_LT | NUM_OP_LT )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set515=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set515_tree = (CommonTree)adaptor.dupNode(set515);


                adaptor.addChild(root_0, set515_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:764:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final AstValidator.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AstValidator.rel_op_lte_return retval = new AstValidator.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set516=null;

        CommonTree set516_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:764:12: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set516=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set516_tree = (CommonTree)adaptor.dupNode(set516);


                adaptor.addChild(root_0, set516_tree);
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
    // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:767:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AstValidator.rel_str_op_return rel_str_op() throws RecognitionException {
        AstValidator.rel_str_op_return retval = new AstValidator.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set517=null;

        CommonTree set517_tree=null;

        try {
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:767:12: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set517=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= STR_OP_EQ && input.LA(1) <= STR_OP_NE) ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set517_tree = (CommonTree)adaptor.dupNode(set517);


                adaptor.addChild(root_0, set517_tree);
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

    // $ANTLR start synpred109_AstValidator
    public final void synpred109_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:396:8: ( ^( MINUS expr expr ) )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:396:8: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred109_AstValidator1864); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred109_AstValidator1866);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred109_AstValidator1868);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred109_AstValidator

    // $ANTLR start synpred113_AstValidator
    public final void synpred113_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:400:8: ( ^( CAST_EXPR type expr ) )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:400:8: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred113_AstValidator1932); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred113_AstValidator1934);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred113_AstValidator1936);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred113_AstValidator

    // $ANTLR start synpred114_AstValidator
    public final void synpred114_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:401:8: ( const_expr )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:401:8: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred114_AstValidator1947);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred114_AstValidator

    // $ANTLR start synpred117_AstValidator
    public final void synpred117_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:404:8: ( ^( CAST_EXPR type_cast expr ) )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:404:8: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred117_AstValidator1982); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred117_AstValidator1984);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred117_AstValidator1986);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred117_AstValidator

    // $ANTLR start synpred140_AstValidator
    public final void synpred140_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:451:31: ( INTEGER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:451:31: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred140_AstValidator2302); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred140_AstValidator

    // $ANTLR start synpred141_AstValidator
    public final void synpred141_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:451:41: ( LONGINTEGER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:451:41: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred141_AstValidator2306); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred141_AstValidator

    // $ANTLR start synpred142_AstValidator
    public final void synpred142_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:454:33: ( DOUBLENUMBER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:454:33: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred142_AstValidator2331); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred142_AstValidator

    // $ANTLR start synpred172_AstValidator
    public final void synpred172_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:508:4: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:508:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred172_AstValidator2680);
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


        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:508:38: ( OUTER )?
        int alt134=2;
        int LA134_0 = input.LA(1);

        if ( (LA134_0==OUTER) ) {
            alt134=1;
        }
        switch (alt134) {
            case 1 :
                // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:508:38: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred172_AstValidator2696); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred172_AstValidator2699);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred172_AstValidator

    // $ANTLR start synpred190_AstValidator
    public final void synpred190_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:587:43: ( INTEGER )
        // /home/hoang/DATA/workspace/JIRA/trunk-11-09/src/org/apache/pig/parser/AstValidator.g:587:43: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred190_AstValidator3110); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred190_AstValidator

    // Delegated rules

    public final boolean synpred142_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred142_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred172_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred172_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred140_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred140_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred141_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred141_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred190_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred190_AstValidator_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_statement_in_query82 = new BitSet(new long[]{0x0000000000000408L,0x0040040000000000L,0x0024000000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_register_statement_in_statement136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGISTER_in_register_statement179 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_register_statement181 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_USING_in_register_statement184 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_register_statement186 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_AS_in_register_statement188 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_register_statement190 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_assert_clause_in_assert_statement203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement214 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement218 = new BitSet(new long[]{0x0048400226400400L,0x1842020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_op_clause_in_general_statement225 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement227 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause242 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause244 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause261 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause263 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARROBA_in_previous_rel296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_op_clause562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause573 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause575 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause579 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause583 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd604 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd608 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd632 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd656 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd680 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd704 = new BitSet(new long[]{0x2000000000080008L,0x0108000080000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause743 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause745 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list757 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause769 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause771 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause784 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause786 = new BitSet(new long[]{0x0000000000000008L,0x0600010000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd800 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd802 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd822 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd824 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd844 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd846 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause860 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause862 = new BitSet(new long[]{0x0000000000000008L,0x0600010000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause876 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause881 = new BitSet(new long[]{0x8000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause883 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause900 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause902 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause904 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause907 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause929 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause931 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def950 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def952 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0200040000004000L});
    public static final BitSet FOLLOW_type_in_field_def956 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def966 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def968 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list996 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_simple_type_in_type1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_simple_type1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_simple_type1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_simple_type1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1141 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1143 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1157 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1159 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1162 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1176 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1178 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1192 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1214 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1216 = new BitSet(new long[]{0x0000000000000008L,0x0000010000020000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1218 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1230 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_set_in_func_name1234 = new BitSet(new long[]{0x7779D022AE6F5F50L,0xFF4B1A13D80C6E1DL,0x31C00000000003EFL});
    public static final BitSet FOLLOW_eid_in_func_name1244 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_func_args_string_in_func_args1269 = new BitSet(new long[]{0x0000000000000002L,0x0000010000020000L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1282 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1284 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PIVOT_in_pivot_clause1301 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_pivot_clause1303 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1315 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1333 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1335 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1347 = new BitSet(new long[]{0x0000000004000002L,0x0001000000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1360 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1372 = new BitSet(new long[]{0x0000000000000008L,0x0000001000000000L});
    public static final BitSet FOLLOW_pivot_clause_in_cube_rollup_list1374 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1387 = new BitSet(new long[]{0x814410540400A002L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_group_clause1427 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1437 = new BitSet(new long[]{0x0148400226400488L,0x1842030210004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_group_type_in_group_clause1440 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1443 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1465 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1469 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1473 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1477 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_alias_in_rel1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_previous_rel_in_rel1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1524 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1538 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1542 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1546 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1550 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1566 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1568 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1581 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause1583 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause1585 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1587 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSERT_in_assert_clause1601 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_assert_clause1603 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_cond_in_assert_clause1605 = new BitSet(new long[]{0x0000000000000008L,0x0000010000000000L});
    public static final BitSet FOLLOW_comment_in_assert_clause1607 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_comment1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1631 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1633 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_cond_in_filter_clause1635 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1648 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1650 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_cond_in_cond1652 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1665 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1667 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_cond_in_cond1669 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1682 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1684 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1697 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1699 = new BitSet(new long[]{0x0000000000000008L,0x0000000000040000L});
    public static final BitSet FOLLOW_NOT_in_cond1701 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1715 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1717 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_cond1719 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond1750 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1752 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval1764 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval1770 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1772 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval1778 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1780 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1797 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1799 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1801 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_INVOKER_FUNC_EVAL_in_func_eval1810 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1812 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval1814 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1816 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_expr_in_real_arg1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr1847 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1849 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr1851 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1864 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1866 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr1868 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr1881 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1883 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr1885 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1898 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1900 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr1902 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr1915 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1917 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr1919 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1932 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr1934 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr1936 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr1956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr1967 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1969 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1982 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr1984 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_expr1986 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr1999 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2001 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast2012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast2024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2035 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2037 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0400040000008000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2051 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast2053 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr2065 = new BitSet(new long[]{0x0000000000000002L,0x0000004800000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr2069 = new BitSet(new long[]{0x0000000000000002L,0x0000004800000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr2073 = new BitSet(new long[]{0x0000000000000002L,0x0000004800000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr2092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr2096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj2111 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2113 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range2166 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range2168 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range2171 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range2173 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj2187 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_pound_proj2189 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr2210 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2212 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_bin_expr2214 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_bin_expr2216 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr2228 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr2234 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2236 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr2244 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2246 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond2265 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond2269 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond2271 = new BitSet(new long[]{0x0800000000000048L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_THEN_in_case_cond2278 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond2280 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2296 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause2298 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause2302 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause2306 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause2310 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause2325 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause2327 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause2331 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause2335 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause2350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause2352 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause2356 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement2372 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement2374 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement2378 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause2392 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause2422 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_col_range_in_rank_col2432 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_col_ref_in_rank_col2454 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ORDER_in_order_clause2476 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause2478 = new BitSet(new long[]{0x0140001004000000L,0x0080000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause2480 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause2482 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause2494 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2525 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_col_range_in_order_col2535 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_col_ref_in_order_col2558 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause2580 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause2582 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause2584 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause2598 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause2600 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause2613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause2615 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause2617 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list2629 = new BitSet(new long[]{0x0148400226400482L,0x1842020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_JOIN_in_join_clause2651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause2653 = new BitSet(new long[]{0x0000000000000008L,0x0000010200000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause2655 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause2658 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type2670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2680 = new BitSet(new long[]{0x0010000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_set_in_join_sub_clause2682 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause2696 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2704 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item2717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item2719 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item2721 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause2748 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2752 = new BitSet(new long[]{0x814410540400A008L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr2768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr2773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr2777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause2788 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause2790 = new BitSet(new long[]{0x0148400226400480L,0x1842020010004608L,0x0000000000000100L});
    public static final BitSet FOLLOW_rel_list_in_union_clause2793 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause2806 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause2808 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause2810 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2823 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan2825 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2846 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan2848 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk2868 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000000L,0x0000600000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk2871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause2882 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause2884 = new BitSet(new long[]{0x814490540400A008L,0x0080012400089000L,0x0800180507330040L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command2899 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2901 = new BitSet(new long[]{0x0008400202000000L,0x0000000010000200L,0x0000800000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command2903 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command2917 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2919 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_nested_command2921 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op2951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op2965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op2979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op2993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op3007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op3021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj3032 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3034 = new BitSet(new long[]{0x0140001004000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3036 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter3051 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter3053 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_cond_in_nested_filter3055 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort3068 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort3070 = new BitSet(new long[]{0x0140001004000000L,0x0080000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort3073 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000280000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort3075 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct3089 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct3091 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit3104 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit3106 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit3110 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit3114 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross3129 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross3131 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach3144 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach3146 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach3148 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input3163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list3172 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause3184 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause3186 = new BitSet(new long[]{0x0100080000000000L});
    public static final BitSet FOLLOW_set_in_stream_clause3188 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause3198 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause3212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause3214 = new BitSet(new long[]{0x0000000000000000L,0x0800010000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause3216 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause3219 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause3221 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause3223 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause3237 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause3239 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3241 = new BitSet(new long[]{0x0000000000000008L,0x0000000020000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause3244 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch3259 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch3261 = new BitSet(new long[]{0x0800000000000040L,0xE00000000BFC0000L,0x000000050008000FL});
    public static final BitSet FOLLOW_cond_in_split_branch3263 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise3281 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise3283 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref3303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref3329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr3338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal3347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal3351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal3355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal3359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar3368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar3376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar3393 = new BitSet(new long[]{0x800400400000A000L,0x0000000000001000L});
    public static final BitSet FOLLOW_set_in_num_scalar3396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map3431 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map3433 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue3447 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue3449 = new BitSet(new long[]{0x800410400000A000L,0x0000010000089000L,0x0800080000010040L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue3451 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key3462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag3473 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag3475 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple3489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple3491 = new BitSet(new long[]{0x800410400000A008L,0x0000010000089000L,0x0800080000010040L});
    public static final BitSet FOLLOW_rel_str_op_in_eid3504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid3520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid3528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid3536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid3544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid3552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIVOT_in_eid3576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid3592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANK_in_eid3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid3616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid3624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid3632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid3648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid3656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid3672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid3680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid3688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid3696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid3704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid3712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid3720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid3728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid3744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid3752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid3768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid3776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid3784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid3800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid3808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid3824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid3832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid3840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid3848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid3864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid3872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid3880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid3888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid3896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid3904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid3912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid3920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid3928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid3936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid3944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid3952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid3960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid3968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid3976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid3984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid3992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid4000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid4016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid4024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid4032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid4040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid4048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid4056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid4064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid4072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid4080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid4088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid4096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_eid4104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op4114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op4125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op4136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op4147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op4158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op4169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op4180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred109_AstValidator1864 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred109_AstValidator1866 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_synpred109_AstValidator1868 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred113_AstValidator1932 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred113_AstValidator1934 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_synpred113_AstValidator1936 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred114_AstValidator1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred117_AstValidator1982 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred117_AstValidator1984 = new BitSet(new long[]{0x814410540400A000L,0x0080012400089000L,0x0800180505330040L});
    public static final BitSet FOLLOW_expr_in_synpred117_AstValidator1986 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_synpred140_AstValidator2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred141_AstValidator2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred142_AstValidator2331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred172_AstValidator2680 = new BitSet(new long[]{0x0010000000000000L,0x0000100000000010L});
    public static final BitSet FOLLOW_set_in_synpred172_AstValidator2682 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred172_AstValidator2696 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_join_item_in_synpred172_AstValidator2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred190_AstValidator3110 = new BitSet(new long[]{0x0000000000000002L});

}