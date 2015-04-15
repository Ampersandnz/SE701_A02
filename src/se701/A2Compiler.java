package se701;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.visitor.CheckVariableUseVisitor;
import japa.parser.ast.visitor.CreateScopesVisitor;
import japa.parser.ast.visitor.CreateTypesVisitor;
import japa.parser.ast.visitor.CreateVariablesVisitor;
import japa.parser.ast.visitor.DumpVisitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class A2Compiler {
	
	/*
	 * This is the only method you should need to change inside this class. But do not modify the signature of the method! 
	 */
	public static void compile(File file) throws ParseException, FileNotFoundException {

		// parse the input, performs lexical and syntatic analysis
		JavaParser parser = new JavaParser(new FileReader(file));
		CompilationUnit ast = parser.CompilationUnit();

		// Create scopes
		CreateScopesVisitor createScopes = new CreateScopesVisitor();
		ast.accept(createScopes, null);

		// Create types
		CreateTypesVisitor createTypes = new CreateTypesVisitor();
		ast.accept(createTypes, null);

		// Create variables
		CreateVariablesVisitor createVariables = new CreateVariablesVisitor();
		ast.accept(createVariables, null);

		// Check that all variables have been accessed only after their
		// creation, and that any assignments are of the correct type.
		CheckVariableUseVisitor checkVariables = new CheckVariableUseVisitor();
		ast.accept(checkVariables, null);

		/*
		 * // Check that all method calls are to methods that exist, and pass in
		 * // the correct type for each parameter. CheckMethodCallsVisitor
		 * checkMethods = new CheckMethodCallsVisitor();
		 * ast.accept(checkMethods, null);
		 */

		// Visitor that (should) visit every node in the AST and print its class
		// name.
		// TODO: For debugging purposes only, remove before completion.
		// PrintASTNodeNameVisitor printASTNodeNameVisitor = new
		// PrintASTNodeNameVisitor();
		// ast.accept(printASTNodeNameVisitor, null);

		// Print the output .java file. Other than my additional feature, should
		// be identical to the input .javax file.
		DumpVisitor printVisitor = new DumpVisitor();
		ast.accept(printVisitor, null);
		
		String result = printVisitor.getSource();
		
		// save the result into a *.java file, same level as the original file
		File javaFile = getAsJavaFile(file);
		writeToFile(javaFile, result);
	}
	
	/*
	 * Given a *.javax File, this method returns a *.java File at the same directory location  
	 */
	private static File getAsJavaFile(File javaxFile) {
		String javaxFileName = javaxFile.getName();
		File containingDirectory = javaxFile.getAbsoluteFile().getParentFile();
		String path = containingDirectory.getAbsolutePath()+System.getProperty("file.separator");
		String javaFilePath = path + javaxFileName.substring(0,javaxFileName.lastIndexOf("."))+".java";
		return new File(javaFilePath);
	}
	
	/*
	 * Given the specified file, writes the contents into it.
	 */
	private static void writeToFile(File file, String contents) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(file);
		writer.print(contents);
		writer.close();
	}
}
