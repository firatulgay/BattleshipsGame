package Layouts.shipLayouts;

import Buttons.ShipButtons;
import Ships.*;
import com.vaadin.shared.ui.dnd.EffectAllowed;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.dnd.DragSourceExtension;

public class ShipsLayout extends VerticalLayout {

    DragSourceExtension<BattleShip> dragSource;

    Ship selectedShip;
    ShipButtons firstBattleshipButton;
    ShipButtons firstCruiserButton;
    ShipButtons firstSubmarineButton;
    ShipButtons firstDestroyerButton;

    BattleShip battleShip;
    Cruiser cruiser;
    Destroyer destroyer;
    Submarine submarine;

    public ShipsLayout() {

        createShips();
        getFirstButtons();
        addListener();
        dragSource = new DragSourceExtension<BattleShip>(battleShip);
        dragSource.setEffectAllowed(EffectAllowed.MOVE);
        dragSource.addDragStartListener(event ->
                dragSource.setDragData(1)
        );

    }

    private void createShips() {
        battleShip = new BattleShip();
        cruiser = new Cruiser();
        destroyer = new Destroyer();
        submarine = new Submarine();

        addComponent(battleShip);
        addComponent(cruiser);
        addComponent(submarine);
        addComponent(destroyer);
    }

    private void getFirstButtons() {

        firstBattleshipButton = (ShipButtons) battleShip.getComponent(0);
        firstCruiserButton = (ShipButtons) cruiser.getComponent(0);
        firstSubmarineButton = (ShipButtons) submarine.getComponent(0);
        firstDestroyerButton = (ShipButtons) destroyer.getComponent(0);
    }

    private void addListener() {

        firstBattleshipButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                setSelectedShip(battleShip);
                Notification.show("SELECT A BUTTON FROM THE TABLE!", "", Notification.Type.WARNING_MESSAGE);
            }
        });

        firstCruiserButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                setSelectedShip(cruiser);
                Notification.show("SELECT A BUTTON FROM THE TABLE!", "", Notification.Type.WARNING_MESSAGE);
            }
        });

        firstSubmarineButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                setSelectedShip(submarine);
                Notification.show("SELECT A BUTTON FROM THE TABLE!", "", Notification.Type.WARNING_MESSAGE);
            }
        });

        firstDestroyerButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                setSelectedShip(destroyer);
                Notification.show("SELECT A BUTTON FROM THE TABLE", "", Notification.Type.WARNING_MESSAGE);

            }
        });
    }

    public Ship getSelectedShip() {
        return selectedShip;
    }

    public void setSelectedShip(Ship selectedShip) {
        this.selectedShip = selectedShip;
    }

    public BattleShip getBattleShip() {
        return battleShip;
    }

    public void setBattleShip(BattleShip battleShip) {
        this.battleShip = battleShip;
    }

    public Cruiser getCruiser() {
        return cruiser;
    }

    public void setCruiser(Cruiser cruiser) {
        this.cruiser = cruiser;
    }

    public Destroyer getDestroyer() {
        return destroyer;
    }

    public void setDestroyer(Destroyer destroyer) {
        this.destroyer = destroyer;
    }

    public Submarine getSubmarine() {
        return submarine;
    }

    public void setSubmarine(Submarine submarine) {
        this.submarine = submarine;
    }

    public ShipButtons getFirstBattleshipButton() {
        return firstBattleshipButton;
    }

    public void setFirstBattleshipButton(ShipButtons firstBattleshipButton) {
        this.firstBattleshipButton = firstBattleshipButton;
    }

    public ShipButtons getFirstCruiserButton() {
        return firstCruiserButton;
    }

    public void setFirstCruiserButton(ShipButtons firstCruiserButton) {
        this.firstCruiserButton = firstCruiserButton;
    }

    public ShipButtons getFirstSubmarineButton() {
        return firstSubmarineButton;
    }

    public void setFirstSubmarineButton(ShipButtons firstSubmarineButton) {
        this.firstSubmarineButton = firstSubmarineButton;
    }

    public ShipButtons getFirstDestroyerButton() {
        return firstDestroyerButton;
    }

    public void setFirstDestroyerButton(ShipButtons firstDestroyerButton) {
        this.firstDestroyerButton = firstDestroyerButton;
    }

    public DragSourceExtension<BattleShip> getDragSource() {
        return dragSource;
    }

    public void setDragSource(DragSourceExtension<BattleShip> dragSource) {
        this.dragSource = dragSource;
    }
}
