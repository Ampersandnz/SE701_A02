package city.compiler;

import java.io.*;

import city.*;
import city.ast.*;
import city.visitor.CheckHouseLikeVisitor;
import city.visitor.CheckUseVisitor;
import city.visitor.CreateScopesVisitor;
import city.visitor.DefineMembersVisitor;

public class CityCompiler {
	
	public static void compile(File file) throws ParseException, FileNotFoundException  {
		
		CityParser parser = new CityParser (new FileReader(file));
		CityNode city = parser.City();
		
		CreateScopesVisitor visitor1 = new CreateScopesVisitor();
		city.accept(visitor1);
		
		CheckHouseLikeVisitor visitor2 = new CheckHouseLikeVisitor();
		city.accept(visitor2);
		
		DefineMembersVisitor visitor3 = new DefineMembersVisitor();
		city.accept(visitor3);
		
		CheckUseVisitor visitor4 = new CheckUseVisitor();
		city.accept(visitor4);
		
	}
}
