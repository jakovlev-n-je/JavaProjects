package com.vgu.cs.course2.group11.composite;

import java.util.Arrays;
import java.util.List;

public class CodeBlock implements Component {

    private final List<Component> blockComponents;

    public CodeBlock(Component... components) {
        this.blockComponents = Arrays.asList(components);
    }

    @Override
    public void add(Component component) {
        blockComponents.add(component);
    }

    @Override
    public void remove(Component component) {
        blockComponents.remove(component);
    }

    @Override
    public void render() {
        System.out.print("<div>");
        for (Component component : blockComponents) {
            component.render();
        }
        System.out.print("</div>");
    }
}
