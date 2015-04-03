package se701;

import japa.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;

public class A2MainRunner {

	public static void main(String[] args) {
		
		/*
		 * These tests will be testing correctness of your Semantic Analysis visitors. The marker will be using their own files here. 
		 */
		for (int i = 1; i <= 2; i++) { 
			String file = "tests"+System.getProperty("file.separator")+"Test"+i+".javax";
			try {
				A2Compiler.compile(new File(file));
				System.out.println(file+" ... OK");
			} catch (ParseException e) {
				System.err.println(file+" Parser exception... "+e.getMessage());
				e.printStackTrace();
			} catch (A2SemanticsException e) {
				System.err.println(file+" Semantics exception... "+e.getMessage());
				e.printStackTrace();
			}  catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		

		/*
		 * This is to compile YOUR supplied sample, make sure it compiles (i.e. should not throw a ParseException or anything). It should compile, and the marker
		 * should be able to run it (so it needs to have a main() file inside it!)
		 */


		// try {
		// A2Compiler.compile(new
		// File("src"+System.getProperty("file.separator")+"se701"+System.getProperty("file.separator")+"StudentSample.javax"));
		// System.out.println("src/se701.StudentSample compiled correctly");
		// } catch (ParseException e) {
		// System.err.println("Student file should not have any errors!");
		// e.printStackTrace();
		// } catch (A2SemanticsException e) {
		// System.err.println("Student file should not have any errors!");
		// e.printStackTrace();
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }

	}
}
