package Layouts;

import Buttons.StartButton;
import com.vaadin.ui.HorizontalLayout;

public class StartButtonLayout extends HorizontalLayout {

    public StartButtonLayout() {

        setMargin(true);
        StartButton startButton = new StartButton();
        addComponent(startButton);


    }
}
