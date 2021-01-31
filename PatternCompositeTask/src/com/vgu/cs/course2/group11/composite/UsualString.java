package com.vgu.cs.course2.group11.composite;

public class UsualString implements Component {

    private String text;

    public UsualString(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void render() {
        System.out.print(text);
    }
}
