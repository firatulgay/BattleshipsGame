package Ships;

import Buttons.ShipButtons;

public class BattleShip extends Ship implements IShipCreatable {

    private ShipButtons shipButtons;

    public BattleShip() {
        setSpacing(false);
        createShip();
    }

    @Override
    public void createShip() {
        for (int i = 0; i < 4; i++) {
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
