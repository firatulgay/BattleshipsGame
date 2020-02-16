package Layouts.shipLayouts;

import com.vaadin.ui.HorizontalLayout;

public class ShipsAndLabelsLayout extends HorizontalLayout {

    public ShipsAndLabelsLayout() {

        setSpacing(true);

        ShipLabelsLayout shipLabelsLayout = new ShipLabelsLayout();
        ShipsLayout shipsLayout = new ShipsLayout();

        addComponent(shipLabelsLayout);
        addComponent(shipsLayout);

    }

}
