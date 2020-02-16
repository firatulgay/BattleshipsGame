package Buttons;

import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

import java.awt.*;

public class StartButton extends Button {

    public StartButton() {

        setEnabled(false);
        setCaption("START");
        addStyleName(ValoTheme.BUTTON_PRIMARY);
        setWidth("570px");
        setHeight("50px");

    }
}
