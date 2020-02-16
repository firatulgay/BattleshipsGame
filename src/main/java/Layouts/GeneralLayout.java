package Layouts;

import com.vaadin.ui.VerticalLayout;

public class GeneralLayout extends VerticalLayout {

    public GeneralLayout(){

        setSpacing(false);
        setMargin(false);

        HeaderLayout header = new HeaderLayout();
        ContainerLayout containerLayout = new ContainerLayout();

        addComponent(header);
        addComponent(containerLayout);

    }
}
