package Layouts;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class HeaderLayout extends VerticalLayout {
    public HeaderLayout(){

        addStyleName("header");
        setMargin(false);

        setSizeFull();
        setHeight(75, Sizeable.Unit.PIXELS);
        Label label = new Label("BATTLESHIPS GAME!");
        label.setSizeFull();
        label.addStyleName("label");
        label.addStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
        label.addStyleName(ValoTheme.LABEL_BOLD);
        label.addStyleName(ValoTheme.LABEL_H2);
        addComponent(label);

    }
}
