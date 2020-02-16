package Ships;

import Buttons.ShipButtons;

public class Destroyer extends Ship implements IShipCreatable {
    private ShipButtons shipButtons;

    public Destroyer() {
        setSpacing(false);
        createShip();
    }

    @Override
    public void createShip() {
        for (int i = 0; i < 1; i++) {
            shipButtons = new ShipButtons();
            addComponent(shipButtons);
        }
    }

    public ShipButtons getShipButtons() {
        return shipButtons;
    }

    public void setShipButtons(ShipButtons shipButtons) {
        this.shipButtons = shipButtons;
    }
}
