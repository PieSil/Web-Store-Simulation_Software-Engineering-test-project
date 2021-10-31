package com.company.ui;

import com.company.constants.ButtonIdentifier;
import com.company.constants.ViewIdentifier;
import com.company.factory.Factory;
import com.company.constants.Constants;

public final class ButtonFactory implements Factory {
    private ButtonFactory() {

    }

    public static ButtonFactory getInstance() {
        if (instance == null)
            instance = new ButtonFactory();
        return instance;
    }

    @Override
    public Button factoryMethod(Object... params) {
        //params[0] = ButtonIdentifier
        //paras[1] = ViewIdentifier - for BACK button only

        Button newButton = null;

        if (params[0] instanceof ButtonIdentifier) {

            ButtonIdentifier requestedButton = (ButtonIdentifier) params[0];
            switch (requestedButton) {
                case BACK:
                    if (params[1] instanceof ViewIdentifier) {
                        newButton = createBackButton((ViewIdentifier) params[1]);
                    } else {
                        //TODO: throw exception
                    }
                    break;

                case CATALOG:
                    newButton = createCatalogButton();
                    break;

                default:
                    //TODO: throw exception
            }
        } else {
            //TODO: throw exception
        }

        return newButton;
    }

    private NavigationButton createBackButton(ViewIdentifier nextView) {
        NavigationButton newBackButton = new NavigationButton(Constants.BACK_TEXT, nextView);
        return newBackButton;
    }

    private NavigationButton createCatalogButton() {
        NavigationButton newCatalogButton = new NavigationButton(Constants.TO_CATALOG_TEXT, ViewIdentifier.CATALOG);
        return newCatalogButton;
    }

    private static ButtonFactory instance = null;
}
