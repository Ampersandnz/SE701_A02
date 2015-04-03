package symboltable;

import java.util.HashMap;

import se701.A2SemanticsException;

public class LocalScope extends BaseScope {

	private HashMap<String, Symbol> symbols = new HashMap<String, Symbol>();
	protected Scope enclosingScope = null;

	public LocalScope() {
		super();
	}

	@Override
	public String getScopeName() {
		return "LocalScope";
	}

	@Override
	public Scope getEnclosingScope() {
		return enclosingScope;
	}

	@Override
	public void setEnclosingScope(Scope scope) {
		this.enclosingScope = scope;
	}

	@Override
	public void define(Symbol symbol) {
		String name = symbol.getName();
		if (symbols.get(name) != null) {
			throw new A2SemanticsException("\"" + name
					+ "\" is already defined in scope " + getScopeName());
		}
		symbols.put(name, symbol);
	}

	@Override
	public Symbol resolve(String name) {
		// if the symbol exists in the current scope, return it
		Symbol s = symbols.get(name);
		if (s != null)
			return s;

		// otherwise look in the enclosing scope, if there is one
		if (enclosingScope != null)
			return enclosingScope.resolve(name);

		// otherwise it doesn't exist
		return null;
	}
}
