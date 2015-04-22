package symboltable;


public class OpenScope extends BaseScope {

	public OpenScope() {
		super();
	}

	@Override
	public String getScopeName() {
		return "OpenScope";
	}
}

// Scope to represent open block. TODO: Upon creation, define variable b_reader
// (BufferedReader) or b_writer (BufferedWriter) as appropriate.