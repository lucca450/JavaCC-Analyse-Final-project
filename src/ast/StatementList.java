package ast;

import java.util.ArrayList;
import java.util.List;

public class StatementList extends ASTNode{
	List<Statement> statement_list = new ArrayList<Statement>();

	public StatementList(List<Statement> statement_list) {
		this.statement_list = statement_list;
	}
	
	public StatementList() {
		
	}

	public List<Statement> getStatement_list() {
		return statement_list;
	}

	public void setStatement_list(List<Statement> statement_list) {
		this.statement_list = statement_list;
	}
	
	public void add(Statement s) {
		statement_list.add(s);
	}

	public void accept(VisitorPrint visitor, int nbTab) {
		for(Statement s : statement_list) {
			s.accept(visitor, nbTab);
		}

	}
}
