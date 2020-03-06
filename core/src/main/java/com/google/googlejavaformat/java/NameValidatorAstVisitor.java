package com.google.googlejavaformat.java;

import org.openjdk.source.tree.ClassTree;
import org.openjdk.source.tree.IntersectionTypeTree;
import org.openjdk.source.tree.MethodTree;
import org.openjdk.source.tree.ModifiersTree;
import org.openjdk.source.tree.ParameterizedTypeTree;
import org.openjdk.source.tree.PrimitiveTypeTree;
import org.openjdk.source.tree.UnionTypeTree;
import org.openjdk.source.tree.VariableTree;
import org.openjdk.source.util.TreeScanner;

public class NameValidatorAstVisitor extends TreeScanner<Void, Void> {

    @Override
    public Void visitClass(ClassTree node, Void p) {
        String name = node.getSimpleName().toString();
        if (Character.isLowerCase(name.charAt(0)) || name.contains("_")) {
            System.err.println("\"" + name + "\"" + " is not upper camel-case!");
        }
        return super.visitClass(node, p);
    }

    @Override
    public Void visitMethod(MethodTree node, Void p) {
        String name = node.getName().toString();
        if (Character.isUpperCase(name.charAt(0)) || name.contains("_")) {
            System.err.println("\"" + name + "\"" + " is not lower camel-case!");
        }
        return super.visitMethod(node, p);
    }

    @Override
    public Void visitVariable(VariableTree node, Void p) {
        //TODO this is super-sketch, but I don't think var is really supported here yet (not primitive type)
        if (node.getType().toString().contentEquals("var")) {
            System.err.println("var" + " is not allowed to be used");
        }
        return super.visitVariable(node, p);
    }

}