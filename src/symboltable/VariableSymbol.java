package symboltable;

public class VariableSymbol extends Symbol {

	private int definedLine;

	public VariableSymbol(String name, Type type) {
		super(name, type);
	}

	public int getDefinedLine() {
		return definedLine;
	}

	public void setDefinedLine(int definedLine) {
		this.definedLine = definedLine;
	}

}
