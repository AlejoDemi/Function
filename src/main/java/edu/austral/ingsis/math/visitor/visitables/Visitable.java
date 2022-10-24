package edu.austral.ingsis.math.visitor.visitables;

import edu.austral.ingsis.math.visitor.visitors.Visitor;

public interface Visitable {

    <T> T accept(Visitor<T> visitor);
}
