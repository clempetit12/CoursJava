package org.example.visiteur;

public class Keyboard  implements PartElement{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
