package Buttons;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class ShipButtons extends Button {
    public ShipButtons() {
        setData(1);
        setIcon(FontAwesome.SHIP);
        addStyleName(ValoTheme.BUTTON_DANGER);
        setWidth("55px");
        setHeight("55px");
    }
}
