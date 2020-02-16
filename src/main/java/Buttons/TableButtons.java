package Buttons;

import buttonAdress.Adress;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;


public class TableButtons extends Button {

    Adress adress;

    public TableButtons() {

        setSizeFull();
        addStyleName("table1");
        setWidth("50px");
        setHeight("50px");

    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
