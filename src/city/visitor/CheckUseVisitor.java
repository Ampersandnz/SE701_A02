package city.visitor;

import city.ast.CityNode;
import city.ast.HouseNode;
import city.ast.ItemNode;
import city.ast.MemberNode;
import city.ast.Node;
import city.ast.PersonNode;
import city.ast.UseNode;
import city.compiler.CitySemanticsException;
import city.symtab.HouseSymbol;
import city.symtab.ItemSymbol;
import city.symtab.PersonSymbol;
import city.symtab.Symbol;

public class CheckUseVisitor implements CityVisitor {

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
	}

	@Override
	public void visit(HouseNode n) {
		// for each MemberNode, ask it to accept this visitor
		for (MemberNode m: n.getMembers()) {
			m.accept(this);
		}
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

		HouseSymbol house = (HouseSymbol) n.getScope();

		Symbol theUser = house.resolve(n.getUser());
		
		if (!(theUser instanceof PersonSymbol)) {
			throw new CitySemanticsException(theUser.getName() + " is not a valid person!");
		}

		String itemName = n.getItemUsed();

		if (!itemName.contains(".")) {
			Symbol item = house.resolve(itemName);
			
			if (!(item instanceof ItemSymbol)) {
				throw new CitySemanticsException(item.getName()
						+ " is not a valid item in house " + house.getName());
			}
		} else {
			Symbol otherHouse = house.resolve(itemName.split(".")[0]);

			if (!(otherHouse instanceof HouseSymbol)) {
				throw new CitySemanticsException(otherHouse.getName()
						+ " is not a valid house!");
			}
			
			HouseSymbol otherHouseSymbol = (HouseSymbol) otherHouse;

			if (!(otherHouseSymbol.getLikes() == house)) {
				throw new CitySemanticsException(otherHouseSymbol.getName()
						+ " does not like " + house.getName()
						+ " and will not share items with them!");
			}

			Symbol item = otherHouseSymbol.resolve(itemName);

			if (!(item instanceof ItemSymbol)) {
				throw new CitySemanticsException(item.getName()
						+ " is not a valid item in house "
						+ otherHouseSymbol.getName());
			}
		}

		/*
		 * get the HouseSymbol from this node
		 * 
		 * resolve the user of this node, to a Symbol
		 * 
		 * if that symbol is not a PersonSymbol throw SemanticException that
		 * says XYZ is not a valid person
		 * 
		 * get a String of the item name being used
		 * 
		 * if it does not contain a "." resolve the item within the current
		 * house to a Symbol if it is not an ItemSymbol throw SemanticException
		 * that says XYZ is not a valid item inside this house
		 * 
		 * else resolve the name of the otherHouse to a Symbol, as a substring
		 * up until the "."
		 * 
		 * if that symbol is not HouseSymbol throw SemanticException that says
		 * XYZ is not a valid house
		 * 
		 * if the otherHouseSymbol does not like thisHouseSymbol throw
		 * SemanticException that says XYZ and ABC are not friends and cannot
		 * use their items
		 * 
		 * resolve the name of the item to a Symbol, within if it is not
		 * ItemSymbol throw SemanticException that says XYZ is not a item inside
		 * this house
		 */

	}
}
