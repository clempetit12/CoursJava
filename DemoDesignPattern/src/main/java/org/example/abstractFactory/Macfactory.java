package org.example.abstractFactory;

public class Macfactory extends GUIFactory {

    @Override
    Button createButton() {
        return new MacButton();
    }

    @Override
    CheckBox createCheckBox() {
        return  new MacCheckBox();
    }
}
