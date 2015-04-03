package city.visitor;

import city.ast.*;
import city.symtab.*;

public class CheckHouseLikeVisitor implements CityVisitor {

	@Override
	public void visit(Node n) {
		throw new IllegalStateException(n.getClass().getName());
	}

	@Override
	public void visit(CityNode n) {
		// for each HouseNode, ask it to accept this visitor
		for (HouseNode h: n.getHouses()) {
			h.accept(this);
		}
				
		// we don't need to visit the ItemNode in this visit, we are just interested in the relationship between houses
	}

	@Override
	public void visit(HouseNode n) {
		
		if (n.getLikes() != null) {
			
			HouseSymbol thisHouseSymbol = (HouseSymbol) n.getScope();
			
			String whoWeLike = n.getLikes();
			
			Symbol symWhoWeLike = thisHouseSymbol.resolve(whoWeLike);
			
			if (symWhoWeLike == null ) {
				// throw exception
			} 
			if (! (symWhoWeLike instanceof HouseSymbol)) {
				// throw execption can only like other houses
			}
			HouseSymbol otherHouseSymbol = (HouseSymbol) symWhoWeLike;
			
			thisHouseSymbol.setLikes(otherHouseSymbol);
		}
		
		
		/*
		 *  if this HouseNode like another house 
		 *  	get the HouseSymbol scope that we stashed into the HouseNode in the earlier visitor
		 *  
		 *  	within that scope, resolve() the house name this node supposedly likes
		 *  
		 *  	if that "otherHouse" doesn't represent a HouseSymbole
		 *  		throw SemanticException that says XYZ is not a valid house
		 *  
		 *  	otherwise, store the relationship into thisHouseSymbol that it likes otherHouse
		 */	
		
	}

	@Override
	public void visit(ItemNode n) {
		// nothing to do
	}

	@Override
	public void visit(PersonNode n) {
		// nothing to do
	}

	@Override
	public void visit(UseNode n) {
		// nothing to do
	}
}
