/* Generated By:JavaCC: Do not edit this line. Grammaire.java */
import java.io.*;
import ast.*;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class Grammaire implements GrammaireConstants {

  static Stack stack = new Stack();
  static int uniqueID = 0;


  public static void main(String args []) throws ParseException
  {
    try {
            InputStream inputStream = new FileInputStream(new File("test.txt"));
            Grammaire parser = new Grammaire(inputStream);

            parser.function();



                /*System.out.println("yo");
		stack.push("bot");
		stack.push("mid");
		stack.push("top");*/
                //System.out.println(stack.peek());


                          System.out.println(stack.peek());


         } catch(IOException exception) {
                exception.printStackTrace();
         }
  }

  final public void function() throws ParseException {
  Token ident = null;
  Token f_type = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_TYPE:
    case DECIMAL_TYPE:
    case BOOLEAN:
      f_type = type();
      break;
    case VOID:
      f_type = jj_consume_token(VOID);
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    ident = jj_consume_token(IDENTIFIER);
          stack.push(new Function(f_type.toString() , ident.toString()));
          Function myFunction = (Function)stack.peek();
    jj_consume_token(42);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_TYPE:
    case DECIMAL_TYPE:
    case BOOLEAN:
      parameter_declaration();
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 43:
          ;
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_1;
        }
        jj_consume_token(43);
        parameter_declaration();
      }
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    jj_consume_token(44);
    jj_consume_token(45);
    function_body();
    jj_consume_token(46);
          myFunction.accept(new VisitorPrint(0));
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_TYPE:
      case DECIMAL_TYPE:
      case BOOLEAN:
      case VOID:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      function();
    }
    jj_consume_token(0);
  }

  final public void parameter_declaration() throws ParseException {
    Token ident = null;
    Token type = null;
          Parameter_declaration myParameter_declaration = new Parameter_declaration();
          stack.push(myParameter_declaration);
    type = type();
    ident = jj_consume_token(IDENTIFIER);
                myParameter_declaration = (Parameter_declaration)stack.pop();
                myParameter_declaration.setParameter_name(ident.toString());
                myParameter_declaration.setType(type.toString());

                Function myFunction = (Function)stack.peek();

                List<Parameter_declaration> parameter_declaration_list = myFunction.getParameter_declaration_list();
                parameter_declaration_list.add(myParameter_declaration);

                myFunction.setParameter_declaration_list(parameter_declaration_list);

                /*
		Function myFunc = (Function)stack.pop();
		
		List<Parameter_declaration> myList =  myFunc.getParameter_declaration_list();

		Parameter_declaration myParameter_declaration = new Parameter_declaration(type.toString(), ident.toString());
		
		myList.add(myParameter_declaration);

		myFunc.setParameter_declaration_list(myList);
		
		stack.push(myFunc);
		*/

  }

  final public void function_body() throws ParseException {
            Function_body myFunction_body = new Function_body();
                stack.push(myFunction_body);
                StatementList myStatementList = new StatementList();
                stack.push(myStatementList);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER_TYPE:
      case DECIMAL_TYPE:
      case BOOLEAN:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
      variable_declaration();
      jj_consume_token(47);
    }
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case FOR:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
      statement();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RETURN:
      return_statement();
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
                    myStatementList = (StatementList)stack.pop();
                        myFunction_body = (Function_body)stack.pop();
                        myFunction_body.setStatement_list(myStatementList);
                        Function myFunction = (Function)stack.peek();
                        myFunction.setFunction_body(myFunction_body);
  }

  final public void statement() throws ParseException {
                Statement myStatement = new Statement();
                stack.push(myStatement);


          /*Function myFunc = (Function)stack.pop();

		Function_body fb = myFunc.getFunction_body();

		List<Statement> myStatementList =  fb.getStatement_list();

		Statement myStatement = new Statement();
		
		myStatementList.add(myStatement);

		fb.setStatement_list(myStatementList);

		myFunc.setFunction_body(fb);
		
		stack.push(myFunc);*/

/*
		Statement myStatement = new Statement();
		try {
		  		  System.out.println("TRY");
		  Conditional_statement myConditionnal_statement = new Conditional_statement();
		  myConditionnal_statement = (Conditional_statement)stack.peek();
		  List<Statement> statement_list = new ArrayList<Statement>();
		  statement_list = myConditionnal_statement.getStatement_list();
		  statement_list.add(mystatement);
		  myConditionnal_statement.setStatement_list(statement_list);
		  
		//  myConditionnal_statement = (Conditional_statement)stack.pop();
		 // myStatement.setConditional_statement(myConditionnal_statement);

		}
		catch(Exception e) {
		  		  System.out.println("catch");
		}
		  stack.push(myStatement);
*/

    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      if (jj_2_1(2)) {
        assignment();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          function_call();
          break;
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      jj_consume_token(47);
      break;
    case IF:
      conditional_statement();
      break;
    case WHILE:
      while_loop();
      break;
    case FOR:
      for_loop();
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                myStatement = (Statement)stack.pop();
                StatementList myStatementList = (StatementList)stack.peek();
                myStatementList.add(myStatement);
  }

  final public void variable_declaration() throws ParseException {
    type();
    assignment();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 43:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_5;
      }
      jj_consume_token(43);
      assignment();
    }
  }

  final public Token litteral_value() throws ParseException {
  Token t = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
      t = jj_consume_token(INTEGER);
      break;
    case DECIMAL:
      t = jj_consume_token(DECIMAL);
      break;
    case TRUE:
    case FALSE:
      boolean_value();
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                          {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  final public void boolean_value() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
      jj_consume_token(TRUE);
      break;
    case FALSE:
      jj_consume_token(FALSE);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public Token type() throws ParseException {
  Token tok=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_TYPE:
      tok = jj_consume_token(INTEGER_TYPE);
      break;
    case DECIMAL_TYPE:
      tok = jj_consume_token(DECIMAL_TYPE);
      break;
    case BOOLEAN:
      tok = jj_consume_token(BOOLEAN);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return tok;}
    throw new Error("Missing return statement in function");
  }

  final public void conditional_statement() throws ParseException {
          Conditional_statement myConditional_statement = new Conditional_statement();
          stack.push(myConditional_statement);



          /*	Function myFunc = (Function)stack.pop();

		Function_body fb = myFunc.getFunction_body();

		List<Statement> myStatementList =  fb.getStatement_list();

		for (Statement s : myStatementList) 
		{ 
		    if(s.getConditional_statement() == null)
		    {
		      Conditional_statement myConditional_statement = new Conditional_statement();
		      //myConditional_statement.ShowMessage();
		      s.setConditional_statement(myConditional_statement);
		      break;
		    }
		}
		
		fb.setStatement_list(myStatementList);

		myFunc.setFunction_body(fb);
		
		stack.push(myFunc);*/

    jj_consume_token(IF);
    jj_consume_token(42);
    expression();
    jj_consume_token(44);
          StatementList myStatementList = new StatementList();
          stack.push(myStatementList);
    jj_consume_token(45);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case FOR:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_6;
      }
      statement();
    }
    if (jj_2_2(2)) {
      jj_consume_token(46);
      jj_consume_token(ELSE);
      jj_consume_token(45);
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IF:
        case WHILE:
        case FOR:
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[14] = jj_gen;
          break label_7;
        }
        statement();
      }
    } else {
      ;
    }
    jj_consume_token(46);
                        myStatementList = (StatementList)stack.pop();
                        myConditional_statement = (Conditional_statement)stack.pop();
                        myConditional_statement.setStatement_list(myStatementList);
                        Statement myStatement = (Statement)stack.peek();
                        myStatement.setConditional_statement(myConditional_statement);



            /*
		myConditional_statement = new Conditional_statement();
		myConditional_statement = (Conditional_statement)stack.pop();

		Statement myStatement = new Statement();
		myStatement = (Statement)stack.pop();

		myStatement.setConditional_statement(myConditional_statement);
		stack.push(myStatement);
		*/

  }

  final public void expression() throws ParseException {
          Expression myExpression = new Expression();
          stack.push(myExpression);
    comparaison_expression();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
      case OR:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_8;
      }
      logical_connector();
      comparaison_expression();
    }
                myExpression = (Expression)stack.pop();

                Conditional_statement myConditional_statement = (Conditional_statement)stack.peek();
                myConditional_statement.setExpression(myExpression);
  }

  final public void comparaison_expression() throws ParseException {
                Comparaison_expression myComparaison_expression = new Comparaison_expression();
                stack.push(myComparaison_expression);
    arithmetic_expression_priority_low();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQUAL:
      case NOT_EQUAL:
      case GREATER:
      case GREATER_OR_EQUAL:
      case LOWER:
      case LOWER_OR_EQUAL:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_9;
      }
      comparaison_operator();
      arithmetic_expression_priority_low();
    }
                myComparaison_expression = new Comparaison_expression();
                myComparaison_expression = (Comparaison_expression)stack.pop();

                Expression myExpression = new Expression();
                myExpression = (Expression)stack.pop();

                myExpression.setComparaison_expression(myComparaison_expression);
                stack.push(myExpression);
  }

  final public void arithmetic_expression_priority_low() throws ParseException {
    arithmetic_expression();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_10;
      }
      arithmetic_operation_piority_low();
      arithmetic_expression();
    }
  }

  final public void arithmetic_expression() throws ParseException {
    unary_expression();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
      case DIVIDE:
      case MODULO:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_11;
      }
      arithmetic_operation();
      unary_expression();
    }
  }

  final public void unary_expression() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
    case PREFIX_INCREMENT:
    case PREFIX_DECREMENT:
      unary_operator();
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
    term();
  }

  final public void term() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
    case FALSE:
    case INTEGER:
    case DECIMAL:
    case IDENTIFIER:
      value();
      break;
    case 42:
      jj_consume_token(42);
      expression();
      jj_consume_token(44);
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void unary_operator() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PREFIX_INCREMENT:
      jj_consume_token(PREFIX_INCREMENT);
      break;
    case PREFIX_DECREMENT:
      jj_consume_token(PREFIX_DECREMENT);
      break;
    case NOT:
      jj_consume_token(NOT);
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void value() throws ParseException {
  Token t = null ;
    if (jj_2_3(2)) {
      function_call();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        t = jj_consume_token(IDENTIFIER);
        break;
      case TRUE:
      case FALSE:
      case INTEGER:
      case DECIMAL:
        t = litteral_value();
        break;
      default:
        jj_la1[22] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
                                Comparaison_expression myComparaison_expression = new Comparaison_expression();
                                myComparaison_expression = (Comparaison_expression)stack.pop();

                                            if(myComparaison_expression.getValue() == null)
                                            {
                                                         Value myValue = new Value(t.toString(), "RIEN");
                                                         myComparaison_expression.setValue(myValue);
                                            }
                                            else if(myComparaison_expression.getValue2() == null)
                                            {
                                                                  Value myValue = new Value(t.toString(), "RIEN");
                                                              myComparaison_expression.setValue2(myValue);
                                                }

                                stack.push(myComparaison_expression);


                /*if(t != null)
		{ 
		
		
				Function myFunc = (Function)stack.pop();
		
				Function_body fb = myFunc.getFunction_body();
		
				List<Statement> myStatementList =  fb.getStatement_list();
		
				for (Statement s : myStatementList) 
				{
				  Conditional_statement myConditional_statement = s.getConditional_statement();
				  Expression myExpression = myConditional_statement.getExpression();
				  Comparaison_expression myComparaison_expression = myExpression.getComparaison_expression();
		
		
				  for (Parameter_declaration pd : myFunc.getParameter_declaration_list()) 
				  {
				    
					    if(myComparaison_expression.getValue() == null)
					    {
					     		 Value myValue = new Value(t.toString(), pd.getType());
					     		 myComparaison_expression.setValue(myValue);
					     		 break;
					    }
					    else if(myComparaison_expression.getValue2() == null)
					    {
								  Value myValue = new Value(t.toString(),pd.getType());
							      myComparaison_expression.setValue2(myValue);
							      break;
					  	}
				  }  	
				}
				
				fb.setStatement_list(myStatementList);
		
				myFunc.setFunction_body(fb);
				
				stack.push(myFunc);
		}*/

  }

  final public void arithmetic_operation() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MULTIPLY:
      jj_consume_token(MULTIPLY);
      break;
    case DIVIDE:
      jj_consume_token(DIVIDE);
      break;
    case MODULO:
      jj_consume_token(MODULO);
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void arithmetic_operation_piority_low() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
      break;
    case MINUS:
      jj_consume_token(MINUS);
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void comparaison_operator() throws ParseException {
  Token comp_operator=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQUAL:
      comp_operator = jj_consume_token(EQUAL);
      break;
    case NOT_EQUAL:
      comp_operator = jj_consume_token(NOT_EQUAL);
      break;
    case GREATER:
      comp_operator = jj_consume_token(GREATER);
      break;
    case GREATER_OR_EQUAL:
      comp_operator = jj_consume_token(GREATER_OR_EQUAL);
      break;
    case LOWER:
      comp_operator = jj_consume_token(LOWER);
      break;
    case LOWER_OR_EQUAL:
      comp_operator = jj_consume_token(LOWER_OR_EQUAL);
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                                Comparaison_expression myComparaison_expression = new Comparaison_expression();
                                myComparaison_expression = (Comparaison_expression)stack.pop();

                                if(comp_operator.toString() == ">")
                            {
                                        Comparaison_operator myOperator = new Comparaison_operator(">");
                                        myComparaison_expression.setComparaison_operator(myOperator);
                                        stack.push(myComparaison_expression);
                                }



                /*
		Function myFunc = (Function)stack.pop();

		Function_body fb = myFunc.getFunction_body();

		List<Statement> myStatementList =  fb.getStatement_list();

		for (Statement s : myStatementList) 
		{
		  Conditional_statement myConditional_statement = s.getConditional_statement();
		  Expression myExpression = myConditional_statement.getExpression();
		  Comparaison_expression myComparaison_expression = myExpression.getComparaison_expression();
		    if(myComparaison_expression.getComparaison_operator() == null)
		    {
		      if(comp_operator.toString() == ">")
			  {
			      Comparaison_operator myComparaison_operator = new Comparaison_operator(">");
			      myComparaison_expression.setComparaison_operator(myComparaison_operator);
			      break;
		      }
		    }
		}
		
		fb.setStatement_list(myStatementList);

		myFunc.setFunction_body(fb);
		
		stack.push(myFunc);
		*/

  }

  final public void logical_connector() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AND:
      jj_consume_token(AND);
      break;
    case OR:
      jj_consume_token(OR);
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void function_call() throws ParseException {
    jj_consume_token(IDENTIFIER);
    jj_consume_token(42);
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NOT:
      case PREFIX_INCREMENT:
      case PREFIX_DECREMENT:
      case TRUE:
      case FALSE:
      case INTEGER:
      case DECIMAL:
      case IDENTIFIER:
      case 42:
        ;
        break;
      default:
        jj_la1[27] = jj_gen;
        break label_12;
      }
      expression();
      label_13:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 43:
          ;
          break;
        default:
          jj_la1[28] = jj_gen;
          break label_13;
        }
        jj_consume_token(43);
        expression();
      }
    }
    jj_consume_token(44);
  }

  final public void assignment() throws ParseException {
    jj_consume_token(IDENTIFIER);
    jj_consume_token(ASSIGN);
    expression();
  }

  final public void while_loop() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(42);
    expression();
    jj_consume_token(44);
    jj_consume_token(45);
    label_14:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case FOR:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[29] = jj_gen;
        break label_14;
      }
      statement();
    }
    jj_consume_token(46);
  }

  final public void for_loop() throws ParseException {
    jj_consume_token(FOR);
    jj_consume_token(42);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      assignment();
      break;
    default:
      jj_la1[30] = jj_gen;
      ;
    }
    jj_consume_token(47);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
    case PREFIX_INCREMENT:
    case PREFIX_DECREMENT:
    case TRUE:
    case FALSE:
    case INTEGER:
    case DECIMAL:
    case IDENTIFIER:
    case 42:
      expression();
      break;
    default:
      jj_la1[31] = jj_gen;
      ;
    }
    jj_consume_token(47);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      assignment();
      break;
    default:
      jj_la1[32] = jj_gen;
      ;
    }
    jj_consume_token(44);
    jj_consume_token(45);
    label_15:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case FOR:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[33] = jj_gen;
        break label_15;
      }
      statement();
    }
    jj_consume_token(46);
  }

  final public void return_statement() throws ParseException {
    jj_consume_token(RETURN);
    expression();
    jj_consume_token(47);
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_3_3() {
    if (jj_3R_17()) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(46)) return true;
    if (jj_scan_token(ELSE)) return true;
    return false;
  }

  private boolean jj_3R_16() {
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(ASSIGN)) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_16()) return true;
    return false;
  }

  private boolean jj_3R_17() {
    if (jj_scan_token(IDENTIFIER)) return true;
    if (jj_scan_token(42)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public GrammaireTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[34];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x0,0x0,0x0,0x1a000000,0x80000000,0x0,0x1a000000,0x0,0x60000000,0x60000000,0x0,0x1a000000,0x1a000000,0x300000,0xfc000,0x300,0x1c00,0x1c00000,0x60000000,0x1c00000,0x60000000,0x1c00,0x300,0xfc000,0x300000,0x61c00000,0x0,0x1a000000,0x0,0x61c00000,0x0,0x1a000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x1e,0x800,0xe,0x1e,0xe,0x200,0x0,0x200,0x200,0x800,0x180,0x0,0xe,0x200,0x200,0x0,0x0,0x0,0x0,0x0,0x780,0x0,0x380,0x0,0x0,0x0,0x0,0x780,0x800,0x200,0x200,0x780,0x200,0x200,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[3];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Grammaire(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Grammaire(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new GrammaireTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Grammaire(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GrammaireTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Grammaire(GrammaireTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(GrammaireTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 34; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[48];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 34; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 48; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 3; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
