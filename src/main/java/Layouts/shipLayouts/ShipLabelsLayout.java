package Layouts.shipLayouts;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.awt.*;

public class ShipLabelsLayout extends VerticalLayout {
    Label battleshipLabel;
    Label cruiserLabel;
    Label submarineLabel;
    Label destroyerLabel;

    public ShipLabelsLayout() {
        setSpacing(false);

        createLabels();

    }

    private void createLabels() {
        battleshipLabel = new Label("BATTLESHIP (2)");
        battleshipLabel.addStyleName("label");
        battleshipLabel.addStyleName(ValoTheme.LABEL_BOLD);
        battleshipLabel.addStyleName(ValoTheme.LABEL_H3);

        cruiserLabel = new Label("CRUISER (2)");
        cruiserLabel.addStyleName("label");
        cruiserLabel.addStyleName(ValoTheme.LABEL_BOLD);
        cruiserLabel.addStyleName(ValoTheme.LABEL_H3);

        submarineLabel = new Label("SUBMARINE (2)");
        submarineLabel.addStyleName("label");
        submarineLabel.addStyleName(ValoTheme.LABEL_BOLD);
        submarineLabel.addStyleName(ValoTheme.LABEL_H3);

        destroyerLabel = new Label("DESTROYER (4)");
        destroyerLabel.addStyleName("label");
        destroyerLabel.addStyleName(ValoTheme.LABEL_BOLD);
        destroyerLabel.addStyleName(ValoTheme.LABEL_H3);

        addComponent(battleshipLabel);
        addComponent(cruiserLabel);
        addComponent(submarineLabel);
        addComponent(destroyerLabel);
    }

    public Label getBattleshipLabel() {
        return battleshipLabel;
    }

    public void setBattleshipLabel(Label battleshipLabel) {
        this.battleshipLabel = battleshipLabel;
    }

    public Label getCruiserLabel() {
        return cruiserLabel;
    }

    public void setCruiserLabel(Label cruiserLabel) {
        this.cruiserLabel = cruiserLabel;
    }

    public Label getSubmarineLabel() {
        return submarineLabel;
    }

    public void setSubmarineLabel(Label submarineLabel) {
        this.submarineLabel = submarineLabel;
    }

    public Label getDestroyerLabel() {
        return destroyerLabel;
    }

    public void setDestroyerLabel(Label destroyerLabel) {
        this.destroyerLabel = destroyerLabel;
    }
}
