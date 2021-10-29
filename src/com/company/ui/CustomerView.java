package com.company.ui;

import com.company.mvc.View;

import java.util.List;
import java.util.LinkedList;

public class CustomerView implements View {

    public CustomerView(String textField) {
        this.topText = textField;
        readButtons();
    }

    @Override
    public void refresh() {
        clear();
        readContents();
        render();
    }

    @Override
    public void render() {
        System.out.println(contents);
    }

    @Override
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void readButtons() {

        for (int index = 0; index < buttons.size(); index++) {
            if (index == currentButtonIndex) {
                contents.append("->");
            }

            Button button = buttons.get(index);
            contents.append("[");
            contents.append(button.getText());
            contents.append("]\n");
        }
    }

    public void moveUp() {
        if (currentButtonIndex > 0) {
            currentButtonIndex--;
        }
    }

    public void moveDown() {
        if (currentButtonIndex < buttons.size() - 1) {
            currentButtonIndex++;
        }
    }


    public void setWarning(String warning) {
        this.warning = warning;
    }

    public Button getCurrentButton() {
        return buttons.get(currentButtonIndex);
    }

    public void addButton(Button button) {
        if (buttons.isEmpty()) {
            currentButtonIndex = 0;
        }
        buttons.add(button);
    }

    private void readTopText() {
        if (topText != null) {
            contents.append(topText).append("\n");
        }
    }

    public void readContents() {
        contents.setLength(0);
        readTopText();
        readButtons();
        readWarning();
    }

    public void readWarning() {
        contents.append(warning);
    }

    private int currentButtonIndex = -1;
    private final List<Button> buttons = new LinkedList<>();
    private final StringBuilder contents = new StringBuilder();
    private final String topText;
    private String warning = "";
}
