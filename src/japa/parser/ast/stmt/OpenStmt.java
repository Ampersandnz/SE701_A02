package japa.parser.ast.stmt;

import japa.parser.ast.visitor.GenericVisitor;
import japa.parser.ast.visitor.VoidVisitor;

import java.util.List;

/**
 * @author Michael Lo
 */
public final class OpenStmt extends Statement {

	private final List<Statement> stmts;
	private boolean isReader;
	private boolean isFile;
	private String target;

	public OpenStmt(int beginLine, int beginColumn, int endLine, int endColumn,
			boolean isReader, boolean isFile, String target,
			List<Statement> stmts) {
        super(beginLine, beginColumn, endLine, endColumn);

        this.isReader = isReader;
        this.isFile = isFile;
        
		this.target = target;

		this.stmts = stmts;
    }

	public List<Statement> getStmts() {
		return this.stmts;
	}

	public String getTarget() {
		return this.target;
	}

	public boolean getIsReader() {
		return this.isReader;
	}

	public boolean getIsFile() {
		return this.isFile;
	}

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    @Override
    public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
        return v.visit(this, arg);
    }
}
