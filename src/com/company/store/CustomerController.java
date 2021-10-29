package com.company.store;
import com.company.constants.ButtonEvent;
import com.company.constants.ViewIdentifier;
import com.company.mvc.*;
import com.company.ui.CustomerView;
import com.company.ui.Button;
import com.company.ui.NavigationButton;
import com.company.ui.ViewFactory;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public final class CustomerController implements Controller {

    @Override
    public void getInput() {

        boolean keyPressed;

        while (active) {
            keyPressed = false;

            if (currentView != null) {
                String key = scanner.nextLine();

                if (key.equals("p") | key.equals("P")) {
                    checkButton(currentView.getCurrentButton());
                } else if (key.equals("u") | key.equals("U")) {
                    moveUp();
                } else if (key.equals("d") | key.equals("D")) {
                    moveDown();
                } else if (key.equals("e") | key.equals("E")) {
                    active = false;
                }
            } else {
                //TODO: throw exception
                System.out.println("No view");
                active = false;
            }
        }
    }

    public void init() {
        if (currentView != null) {
            currentView.refresh();
            getInput();
        }
    }

    //TODO: test view selection
    public void selectView(ViewIdentifier identifier) {
        currentView.clear();
        currentView = views.get(identifier);
        currentView.refresh();
    }

    public void checkButton(Button button) {
        ButtonEvent event = button.getEvent();

        switch(event) {
            case CHANGE_VIEW:
                if (button instanceof NavigationButton) {
                    selectView(((NavigationButton)button).getNextView());
                } else {
                    //TODO: throw exception
                }
                break;
            case CHANGE_ADDRESS:
                break;
            default:
        }
    }
    
    private String getText() {
        //get text from user
        String text = scanner.nextLine();
        return text;
    }

    private void moveUp() {
        currentView.moveUp();
        currentView.refresh();
    }

    private void moveDown() {
        currentView.moveDown();
        currentView.refresh();
    }

    public void addView(ViewIdentifier view) {
        CustomerView newView = (CustomerView) ViewFactory.getInstance().factoryMethod(view);
        if (views.isEmpty()) {
            views.put(view, newView);
            currentView = newView;
        } else if (!views.containsKey(view)) {
           views.put(view, newView);
        } else {
            //TODO: throw exception
        }
    }

    private boolean active = true;
    private CustomerView currentView = null;
    private final Map<ViewIdentifier, CustomerView> views = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
}
