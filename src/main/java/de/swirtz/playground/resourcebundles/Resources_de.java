package de.swirtz.playground.resourcebundles;

import java.util.ListResourceBundle;

/**
 * Created by simonw on 14.04.17.
 */
public class Resources_de extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{{"loc", "Ort"}, {"str", "Straße"}};
    }
}