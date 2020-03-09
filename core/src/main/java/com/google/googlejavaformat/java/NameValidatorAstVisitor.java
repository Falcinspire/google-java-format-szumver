package com.google.googlejavaformat.java;

import org.openjdk.javax.lang.model.element.Modifier;
import org.openjdk.source.tree.ClassTree;
import org.openjdk.source.tree.MethodTree;
import org.openjdk.source.tree.VariableTree;
import org.openjdk.source.util.TreeScanner;

public class NameValidatorAstVisitor extends TreeScanner<Void, Void> {

    @Override
    public Void visitClass(ClassTree node, Void p) {
        String name = node.getSimpleName().toString();
        if (!CamelCaseChecker.isProbablyUpperCamelCase(name)) {
            System.err.println("\"" + name + "\"" + " is not upper camel case");
        }
        return super.visitClass(node, p);
    }

    @Override
    public Void visitMethod(MethodTree node, Void p) {
        String name = node.getName().toString();
        if (!isConstructor(name)) {
            if (!CamelCaseChecker.isProbablyLowerCamelCase(name)) {
                System.err.println("\"" + name + "\"" + " is not lower camel case");
            }
        }
        return super.visitMethod(node, p);
    }

    @Override
    public Void visitVariable(VariableTree node, Void p) {
        String type = node.getType().toString();
        // 'var' is not a primitive/special type, it is recognized like any other
        if (type.contentEquals("var")) {
            System.err.println("var" + " is not allowed to be used");
        }
        String name = node.getName().toString();
        if (node.getModifiers().getFlags().contains(Modifier.FINAL)) {
            if (!CamelCaseChecker.probablyFollowsFinalConvention(name)) {
                System.err.println("final variable \"" + name + "\" is not following const naming conventions");
            }
        } else {
            if (!CamelCaseChecker.isProbablyLowerCamelCase(name)) {
                System.err.println("variable \"" + name + "\" is not lower camel case");
            }
        }
        
        return super.visitVariable(node, p);
    }

    public static boolean isConstructor(String name) {
        return name.contentEquals("<init>");
    }

}