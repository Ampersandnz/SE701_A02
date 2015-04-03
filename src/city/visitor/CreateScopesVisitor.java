package city.visitor;

import city.ast.*;
import city.symtab.*;

public class CreateScopesVisitor implements CityVisitor {
	
	private Scope currentScope; 
	
	@Override
	public void visit(Node n) {
		throw new IllegalStateException(n.getClass().getName());
	}

	@Override
	public void visit(CityNode n) {
		// create a new CitySymbol scope as the currentScope
		currentScope = new CitySymbol(n.getName());

		// set scope into CityNode
		n.setScope(currentScope);
		
		// for each HouseNode, ask it to accept this visitor
		for (HouseNode h: n.getHouses()) {
			h.accept(this);
		}
		
		// for each ItemNode, ask it to accept this visitor
		for (ItemNode i: n.getCityItems()) {
			i.accept(this);
		}
	}
	
	@Override
	public void visit(HouseNode n) {
		// create a new HouseSymbol scope and define it in the currentScope 
		HouseSymbol houseSym = new HouseSymbol(n.getName(), currentScope);
		
		// The new scope becomes the currentScope 
		currentScope = houseSym;
				
		// set scope into HouseNode
		n.setScope(currentScope);
		
		// for each MemberNode, ask it to accept this visitor
		for (MemberNode m: n.getMembers()) {
			m.accept(this);
		}
		
		// pop the scope to the enclosing scope 
		currentScope = houseSym.getEnclosingScope();
	}

	@Override
	public void visit(ItemNode n) {
		// set scope
		n.setScope(currentScope);
	}
	
	@Override
	public void visit(PersonNode n) {
		// set scope
		n.setScope(currentScope);
	}

	@Override
	public void visit(UseNode n) {
		// set scope
		n.setScope(currentScope);
	}
}
