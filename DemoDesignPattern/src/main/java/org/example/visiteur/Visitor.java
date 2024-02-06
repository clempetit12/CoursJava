package org.example.visiteur;

import java.security.Key;

public interface Visitor {

    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}
