package com.vgu.cs.course2.group11;

import com.vgu.cs.course2.group11.composite.CodeBlock;
import com.vgu.cs.course2.group11.composite.GroupComponent;
import com.vgu.cs.course2.group11.composite.TextParagraph;
import com.vgu.cs.course2.group11.composite.UsualString;

public class Main {

    public static void main(String[] args) {
        TextParagraph textParagraph = new TextParagraph("Строка 1");
        UsualString usualString = new UsualString("Строка 2");
        CodeBlock codeBlock = new CodeBlock(textParagraph, usualString);
        codeBlock.render();
        GroupComponent groupComponent = new GroupComponent(codeBlock);
        groupComponent.render();
    }
}
