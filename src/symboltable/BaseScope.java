package symboltable;

import java.util.HashMap;

public class BaseScope implements Scope  {

	protected HashMap<String, Symbol> symbols = new HashMap<String, Symbol>();
	protected Scope enclosingScope = null;

	public BaseScope() {
	}

	@Override
	public String getScopeName() {
		return null;
	}

	@Override
	public Scope getEnclosingScope() {
		return null;
	}

	@Override
	public void setEnclosingScope(Scope scope) {

	}

	@Override
	public void define(Symbol symbol) {
		
	}

	@Override
	public Symbol resolve(String name) {
		return null;
	}
}
