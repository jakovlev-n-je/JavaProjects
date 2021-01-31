package com.vgu.cs.course2.group11.command;

public class Command {

    private final int index;

    private final Object[] parameters;

    public Command(int index) {
        this.index = index;
        this.parameters = null;
    }

    public Command(int index, Object[] parameters) {
        this.index = index;
        this.parameters = parameters;
    }

    public int getIndex() {
        return index;
    }

    public Object[] getParameters() {
        return parameters;
    }
}
