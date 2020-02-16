package Layouts;

import Buttons.RefreshButton;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class CounterLayout extends VerticalLayout {

    private Label headerLabel;
    private Label shotsLabel;
    private RefreshButton refreshButton;

    public CounterLayout() {

        setSizeFull();
        setSpacing(true);

        headerLabel = new Label("REMAINING SHOTS");
        headerLabel.setSizeFull();
        headerLabel.addStyleName("label1");
        headerLabel.addStyleName(ValoTheme.LABEL_BOLD);
        headerLabel.addStyleName(ValoTheme.LABEL_H2);
        headerLabel.addStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);

        shotsLabel = new Label("40");
        shotsLabel.setSizeFull();
        shotsLabel.addStyleName("");
        shotsLabel.addStyleName("label");
        shotsLabel.addStyleName(ValoTheme.LABEL_BOLD);
        shotsLabel.addStyleName(ValoTheme.LABEL_BOLD);
        shotsLabel.addStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
        shotsLabel.addStyleName(ValoTheme.LABEL_H2);

        refreshButton = new RefreshButton();

        addComponent(headerLabel);
        addComponent(shotsLabel);
        addComponent(refreshButton);

    }

    public Label getHeaderLabel() {
        return headerLabel;
    }

    public void setHeaderLabel(Label headerLabel) {
        this.headerLabel = headerLabel;
    }

    public Label getShotsLabel() {
        return shotsLabel;
    }

    public void setShotsLabel(Label shotsLabel) {
        this.shotsLabel = shotsLabel;
    }

    public RefreshButton getRefreshButton() {
        return refreshButton;
    }

    public void setRefreshButton(RefreshButton refreshButton) {
        this.refreshButton = refreshButton;
    }
}
