package Buttons;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class RefreshButton extends Button {
    public RefreshButton() {

        setSizeFull();
        setCaption("RESTART THE GAME");
        setIcon(FontAwesome.REFRESH);
        setWidth("600px");
        setHeight("50px");
        addStyleName(ValoTheme.BUTTON_DANGER);
    }
}
