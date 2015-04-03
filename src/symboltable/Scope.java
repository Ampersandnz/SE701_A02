package symboltable;

public interface Scope {
	public String getScopeName();
	public Scope getEnclosingScope();
	public void setEnclosingScope(Scope scope);
	public void define(Symbol symbol);
	public Symbol resolve(String name);
}
