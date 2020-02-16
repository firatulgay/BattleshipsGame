package Layouts.shipLayouts;

import Layouts.StartButtonLayout;
import com.vaadin.ui.*;

public class ShipsContainerLayout extends VerticalLayout {

    public ShipsContainerLayout() {
        setSpacing(false);

        ShipsHeaderLayout shipsHeaderLayout = new ShipsHeaderLayout();
        ShipsAndLabelsLayout shipsAndLabelsLayout = new ShipsAndLabelsLayout();
        StartButtonLayout startButtonLayout = new StartButtonLayout();

        addComponent(shipsHeaderLayout);
        addComponent(shipsAndLabelsLayout);
        addComponent(startButtonLayout);


    }
}


