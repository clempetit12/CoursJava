package org.example.abstractFactory;

public class WinFactory extends GUIFactory {

    @Override
    Button createButton() {
        return new WinButton();
    }

    @Override
    CheckBox createCheckBox() {
        return new WinCheckbox();
    }
}
