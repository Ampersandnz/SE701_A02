package symboltable;


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
		define(new BuiltInTypeSymbol("String"));
		define(new BuiltInTypeSymbol("void"));
		define(new BuiltInTypeSymbol("null"));
		define(new BuiltInTypeSymbol("BufferedReader"));
		define(new BuiltInTypeSymbol("BufferedWriter"));

		define(new VariableSymbol("true", resolveType("boolean")));
		define(new VariableSymbol("false", resolveType("boolean")));
		define(new VariableSymbol("reader", resolveType("BufferedReader")));
		define(new VariableSymbol("writer", resolveType("BufferedWriter")));

		MethodSymbol symbol = new MethodSymbol("readLine");
		symbol.setReturnType(resolveType("String"));
		define(symbol);

		symbol = new MethodSymbol("write");
		symbol.setReturnType(resolveType("String"));
		define(symbol);
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
}
