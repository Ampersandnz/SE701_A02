/*
 * Copyright (C) 2007 J�lio Vilmar Gesser.
 * 
 * This file is part of Java 1.5 parser and Abstract Syntax Tree.
 *
 * Java 1.5 parser and Abstract Syntax Tree is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Java 1.5 parser and Abstract Syntax Tree is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Java 1.5 parser and Abstract Syntax Tree.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * Created on 05/10/2006
 */
package japa.parser.ast.body;

import japa.parser.ast.Node;
import symboltable.Scope;

/**
 * @author Julio Vilmar Gesser
 */
public abstract class BodyDeclaration extends Node {

    private final JavadocComment javaDoc;
	protected Scope enclosingScope;

    public BodyDeclaration(int line, int column, JavadocComment javaDoc) {
        super(line, column);
        this.javaDoc = javaDoc;
    }

    public JavadocComment getJavaDoc() {
        return javaDoc;
    }

	public void setScope(Scope enclosingScope) {
		this.enclosingScope = enclosingScope;
	}

	public Scope getScope() {
		return enclosingScope;
	}

}
