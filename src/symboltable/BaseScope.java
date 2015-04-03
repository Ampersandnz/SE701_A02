package symboltable;

public class BaseScope implements Scope  {

	public BaseScope() {
		define(new BuiltInTypeSymbol("int"));
		define(new BuiltInTypeSymbol("boolean"));
		define(new BuiltInTypeSymbol("double"));
		define(new BuiltInTypeSymbol("float"));
		define(new BuiltInTypeSymbol("byte"));
		define(new BuiltInTypeSymbol("short"));
		define(new BuiltInTypeSymbol("char"));

		define(new ClassSymbol("String"));
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
