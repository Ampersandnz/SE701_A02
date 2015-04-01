package symtab;

import java.util.HashMap;

public class GlobalScope { // extends BaseScope {

	private HashMap<String, Symbol> symbols = new HashMap<String, Symbol>();
	
	public GlobalScope() {
		define(new BuiltInTypeSymbol("int"));
		define(new BuiltInTypeSymbol("boolean"));
		
		define(new ClassSymbol("String"));
		
		define(new MethodSymbol("foo", (symtab.Type) resolve("String")));
	}
	
	public String getScopeName() {
		return "GlobalScope";
	}

//	public Scope getEnclosingScope() {
//		return null;
//	}

	public void define(Symbol symbol) {
		symbols.put(symbol.getName(), symbol);
	}

	public Symbol resolve(String name) {
		return symbols.get(name);
	}
	
}
