package Layouts;

import Buttons.StartButton;
import Buttons.TableButtons;
import Layouts.shipLayouts.ShipLabelsLayout;
import Layouts.shipLayouts.ShipsAndLabelsLayout;
import Layouts.shipLayouts.ShipsContainerLayout;
import Layouts.shipLayouts.ShipsLayout;
import Layouts.tableLayouts.TableLayout;
import Ships.BattleShip;
import com.vaadin.shared.ui.dnd.DropEffect;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.dnd.DragSourceExtension;
import com.vaadin.ui.dnd.DropTargetExtension;

import java.util.List;
import java.util.Optional;

public class ContainerLayout extends HorizontalLayout {
    private TableLayout tableLayout;
    private ShipsContainerLayout shipsContainerLayout;

    public ContainerLayout() {

        setSizeFull();
        addStyleName("container");

        shipsContainerLayout = new ShipsContainerLayout();
        ShipsAndLabelsLayout shipsAndLabelsLayout = (ShipsAndLabelsLayout)shipsContainerLayout.getComponent(1);
        ShipsLayout shipsLayout = (ShipsLayout)shipsAndLabelsLayout.getComponent(1);

        StartButtonLayout startButtonLayout = (StartButtonLayout) shipsContainerLayout.getComponent(2);
        StartButton startButton = (StartButton) startButtonLayout.getComponent(0);

        ShipLabelsLayout shipLabelsLayout = (ShipLabelsLayout) shipsAndLabelsLayout.getComponent(0);
        tableLayout = new TableLayout(shipsLayout,shipLabelsLayout,startButton);

//        DragSourceExtension<BattleShip> dragSource = shipsLayout.getDragSource();
//        List<TableButtons> tableButtonsList = tableLayout.getTableButtonsList();

//        for (TableButtons tableButtons : tableButtonsList) {
//            DropTargetExtension<TableButtons> dropTarget = new DropTargetExtension<TableButtons>(tableButtons);
//            dropTarget.setDropEffect(DropEffect.MOVE);
//
//            dropTarget.addDropListener(event -> {
//                // if the drag source is in the same UI as the target
//                Optional<AbstractComponent> battleShip = event.getDragSourceComponent();
//                if (battleShip.isPresent() && battleShip.get() instanceof BattleShip) {
//                    // move the label to the layout
//                    tableLayout.addComponent(battleShip.get());
//
//                    // get possible transfer data
//                    Optional<String> message = event.getDataTransferData("text/html");
//                    if (message != null) {
//                        Notification.show("DropEvent with data transfer html: " + message);
//                    } else {
//                        // get transfer text
//                        message = Optional.ofNullable(event.getDataTransferText());
//                        Notification.show("DropEvent with data transfer text: " + message);
//                    }
//
//                }
//            });
//        }

        addComponent(tableLayout);
        addComponent(shipsContainerLayout);

    }

    public TableLayout getTableLayout() {
        return tableLayout;
    }

    public void setTableLayout(TableLayout tableLayout) {
        this.tableLayout = tableLayout;
    }

    public ShipsContainerLayout getShipsContainerLayout() {
        return shipsContainerLayout;
    }

    public void setShipsContainerLayout(ShipsContainerLayout shipsContainerLayout) {
        this.shipsContainerLayout = shipsContainerLayout;
    }
}
