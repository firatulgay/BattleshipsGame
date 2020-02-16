package Layouts.shipLayouts;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ShipsHeaderLayout extends VerticalLayout {
    public ShipsHeaderLayout() {

        setMargin(false);
        setSizeFull();
        setHeight(62, Sizeable.Unit.PIXELS);
        addStyleName("shipHeader");

        Label shipsLabel = new Label("SHIPS");
        shipsLabel.setSizeFull();
        shipsLabel.addStyleName("label");
        shipsLabel.addStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
        shipsLabel.addStyleName(ValoTheme.LABEL_BOLD);
        shipsLabel.addStyleName(ValoTheme.LABEL_H2);

        addComponent(shipsLabel);
    }
}
