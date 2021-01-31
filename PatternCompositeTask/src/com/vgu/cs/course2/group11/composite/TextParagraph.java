package com.vgu.cs.course2.group11.composite;

public class TextParagraph implements Component {

    private String text;

    public TextParagraph(String text) {
        this.text = String.format("<p>%s</p>", text);
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
