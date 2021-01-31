package com.vgu.cs.course2.group11.composite;

public interface Component {

    void add(Component component);

    void remove(Component component);

    void render();
}
