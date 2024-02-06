package org.example.visiteur;

public class UpdateVisitor implements Visitor{
    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Update keyboard element");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Update monitor");
    }
}
