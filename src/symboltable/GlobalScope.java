package symboltable;

import se701.A2SemanticsException;

public class GlobalScope extends BaseScope {
	
	public GlobalScope() {
		super();

		define(new BuiltInTypeSymbol("int"));
		define(new BuiltInTypeSymbol("boolean"));
		define(new BuiltInTypeSymbol("double"));
		define(new BuiltInTypeSymbol("float"));
		define(new BuiltInTypeSymbol("byte"));
		define(new BuiltInTypeSymbol("short"));
		define(new BuiltInTypeSymbol("char"));

		define(new BuiltInTypeSymbol("void"));
		define(new BuiltInTypeSymbol("null"));

		define(new ClassSymbol("String"));
	}
	
	@Override
	public String getScopeName() {
		return "GlobalScope";
	}

	@Override
	public Scope getEnclosingScope() {
		return null;
	}

	@Override
	public void setEnclosingScope(Scope scope) {
		throw new IllegalArgumentException(
				"GlobalScope cannot have an enclosing scope!");
	}

	@Override
	public void define(Symbol symbol) {
		String name = symbol.getName();

		if (this.resolve(name) != null) {
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
