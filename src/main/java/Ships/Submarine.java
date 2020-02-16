package Ships;

import Buttons.ShipButtons;

public class Submarine extends Ship implements IShipCreatable {
    private ShipButtons shipButtons;

    public Submarine() {
        setSpacing(false);
        createShip();
    }

    @Override
    public void createShip() {
        for (int i = 0; i < 2; i++) {
            shipButtons = new ShipButtons();
            if (i > 0) {
                shipButtons.setEnabled(false);
                addComponent(shipButtons);
            } else {
                addComponent(shipButtons);
            }
        }
    }

    public ShipButtons getShipButtons() {
        return shipButtons;
    }

    public void setShipButtons(ShipButtons shipButtons) {
        this.shipButtons = shipButtons;
    }
}
