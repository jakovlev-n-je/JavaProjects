package com.vgu.cs.course2.group11.composite;

import java.util.Arrays;
import java.util.List;

public class GroupComponent implements Component {

    private final List<Component> groupComponents;

    public GroupComponent(Component... components) {
        this.groupComponents = Arrays.asList(components);
    }

    @Override
    public void add(Component component) {
        groupComponents.add(component);
    }

    @Override
    public void remove(Component component) {
        groupComponents.remove(component);
    }

    @Override
    public void render() {
        for (Component component : groupComponents) {
            component.render();
        }
    }
}
