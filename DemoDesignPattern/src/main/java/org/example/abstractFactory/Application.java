package org.example.abstractFactory;

import java.util.zip.GZIPInputStream;

public class Application {

    private Button button;
    private CheckBox checkBox;

    public Application (GUIFactory factory) {
        button= factory.createButton();
        checkBox = factory.createCheckBox();
    }
}
