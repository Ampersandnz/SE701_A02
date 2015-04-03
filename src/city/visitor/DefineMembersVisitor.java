package city.visitor;

import city.ast.CityNode;
import city.ast.HouseNode;
import city.ast.ItemNode;
import city.ast.MemberNode;
import city.ast.Node;
import city.ast.PersonNode;
import city.ast.UseNode;
import city.symtab.ItemSymbol;
import city.symtab.PersonSymbol;
import city.symtab.Scope;

public class DefineMembersVisitor implements CityVisitor {

	private Scope currentScope;

	@Override
	public void visit(Node n) {
		throw new IllegalStateException(n.getClass().getName());
	}

	@Override
	public void visit(CityNode n) {
		// for each HouseNode, ask it to accept this visitor
		for (HouseNode h : n.getHouses()) {
			h.accept(this);
		}

		// for each ItemNode, ask it to accept this visitor
		for (ItemNode i : n.getCityItems()) {
			i.accept(this);
		}
	}

	@Override
	public void visit(HouseNode n) {
		// for each MemberNode, ask it to accept this visitor
		for (MemberNode m : n.getMembers()) {
			m.accept(this);
		}
	}

	@Override
	public void visit(ItemNode n) {
		// get the current scope of this node
		currentScope = n.getScope();

		// create a new ItemSymbol to represent this node
		ItemSymbol thisItem = new ItemSymbol(n.getName());

		// define() the symbol in the scope
		currentScope.define(thisItem);
	}

	@Override
	public void visit(PersonNode n) {
		// get the current scope of this node
		currentScope = n.getScope();

		// create a new PersonSymbol to represent this node
		PersonSymbol thisPerson = new PersonSymbol(n.getName());

		// define() the symbol in the scope
		currentScope.define(thisPerson);
	}

	@Override
	public void visit(UseNode n) {
		// nothing to do
	}
}
