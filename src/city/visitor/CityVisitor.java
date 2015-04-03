package city.visitor;

import city.ast.*;

public interface CityVisitor {

	public void visit(Node n);
	public void visit(CityNode n);
	public void visit(HouseNode n);
	public void visit(ItemNode n);
	public void visit(PersonNode n);
	public void visit(UseNode n);
	
}
