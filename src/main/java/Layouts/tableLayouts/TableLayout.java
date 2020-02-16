package Layouts.tableLayouts;

import Buttons.ShipButtons;
import Buttons.StartButton;
import Buttons.TableButtons;
import Layouts.ContainerLayout;
import Layouts.CounterLayout;
import Layouts.shipLayouts.ShipLabelsLayout;
import Layouts.shipLayouts.ShipsContainerLayout;
import Layouts.shipLayouts.ShipsLayout;
import Ships.*;
import buttonAdress.Adress;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

public class TableLayout extends VerticalLayout {

    private boolean isStartButtonClicked;

    private TableButtons tableButton;
    private StartButton startButton;
    private ShipsLayout shipsLayout;
    private ShipLabelsLayout shipLabelsLayout;

    private List<TableButtons> tableButtonsList = new ArrayList<>();
    private List<TableButtons> plantedButtonsList = new ArrayList<>();
    private List<TableButtons> plantedButtonsListforBattleShip = new ArrayList<>();
    private List<TableButtons> plantedButtonsListforCruiser = new ArrayList<>();
    private List<TableButtons> plantedButtonsListforSubmarine = new ArrayList<>();
    private List<TableButtons> plantedButtonsListforDestroyer = new ArrayList<>();
    private List<TableButtons> allPlantedButtonList = new ArrayList<>();

    private TableLayout instance;

    public TableLayout(ShipsLayout shipsLayout, ShipLabelsLayout shipLabelsLayout, StartButton startButton) {
        instance = this;
        this.startButton = startButton;
        this.shipsLayout = shipsLayout;
        this.shipLabelsLayout = shipLabelsLayout;
        buildTable();
        setSpacing(false);
        startButtonListener(startButton);
        Notification.show("START PLANTING YOUR SHIPS!", "", Notification.Type.WARNING_MESSAGE);

    }

    private void startButtonListener(StartButton startButton) {
        startButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                setIsStartButtonClicked(true);

                setVisible(false);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
                Notification.show("SINK THE PLANTED SHIPS !", "", Notification.Type.WARNING_MESSAGE);

                ShipsContainerLayout shipsContainerLayout = (ShipsContainerLayout) (((ContainerLayout) instance.getParent()).getComponent(1));
                ((ContainerLayout) instance.getParent()).removeComponent(shipsContainerLayout);

                CounterLayout counterLayout = new CounterLayout();
                ((ContainerLayout) instance.getParent()).addComponent(counterLayout);

                NewTableLayout newTableLayout = new NewTableLayout(instance, tableButton, counterLayout);
                ((ContainerLayout) instance.getParent()).replaceComponent(instance, newTableLayout);

            }
        });
    }

    private void buildTable() {
        for (int i = 0; i < 10; i++) {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            horizontalLayout.setSpacing(false);
            for (int j = 0; j < 10; j++) {
                createTableButtons(i, horizontalLayout, j);
            }
        }
    }

    private void createTableButtons(int i, HorizontalLayout horizontalLayout, int j) {

        tableButton = new TableButtons();
        setButtonAdress(i, j, tableButton);
        tableButton.setData(0);
        tableButtonsList.add(tableButton);
        horizontalLayout.addComponent(tableButton);
        tableButtonListener(tableButton);
        addComponent(horizontalLayout);

    }

    private void setButtonAdress(int i, int j, TableButtons tableButton) {
        Adress adress = new Adress();
        adress.setRow(i);
        adress.setColumn(j);
        tableButton.setAdress(adress);
    }

    private void tableButtonListener(TableButtons selectedTableButton) {
        selectedTableButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Ship selectedShip = shipsLayout.getSelectedShip();

                if (selectedShip == null) {
                    Notification.show("SELECT A SHIP FIRST !", "", Notification.Type.WARNING_MESSAGE);
                }

                if (selectedShip != null) {

                    Adress adress = selectedTableButton.getAdress();
                    int selectedBtnColumn = adress.getColumn();
                    int selectedBtnRow = adress.getRow();

                    for (TableButtons tableButtons : tableButtonsList) {

                        int nextBtnColumn = tableButtons.getAdress().getColumn();
                        int nextBtnRow = tableButtons.getAdress().getRow();

                        BattleShip battleShip = (BattleShip) shipsLayout.getComponent(0);
                        Cruiser cruiser = (Cruiser) shipsLayout.getComponent(1);
                        Submarine submarine = (Submarine) shipsLayout.getComponent(2);
                        Destroyer destroyer = (Destroyer) shipsLayout.getComponent(3);

                        if (selectedShip == battleShip) {

                            if (selectedBtnRow == nextBtnRow && selectedBtnColumn == nextBtnColumn ||
                                    selectedBtnRow == nextBtnRow && selectedBtnColumn + 1 == nextBtnColumn ||
                                    selectedBtnRow == nextBtnRow && selectedBtnColumn + 2 == nextBtnColumn ||
                                    selectedBtnRow == nextBtnRow && selectedBtnColumn + 3 == nextBtnColumn) {

                                if (selectedBtnRow == nextBtnRow && selectedBtnColumn != 7 && selectedBtnColumn != 8 && selectedBtnColumn != 9) {
                                    tableButtons.setData(1);
                                    tableButtons.addStyleName(ValoTheme.BUTTON_DANGER);
                                    tableButtons.setIcon(FontAwesome.SHIP);
                                    tableButtons.setEnabled(false);
                                    allPlantedButtonList.add(tableButtons);

                                    if (selectedBtnRow == nextBtnRow && selectedBtnColumn + 3 == nextBtnColumn) {

                                        plantedButtonsList.add(selectedTableButton);
                                        plantedButtonsListforBattleShip.add(selectedTableButton);

                                        int plantedButtonListSizeForBattleShip = plantedButtonsListforBattleShip.size();
                                        int leftBattleshipSize = 2 - plantedButtonListSizeForBattleShip;
                                        shipLabelsLayout.getBattleshipLabel().setValue("BATTLESHIP" + " " + "(" + leftBattleshipSize + ")");

                                        if (plantedButtonListSizeForBattleShip == 2) {

                                            ShipButtons firstBattleshipButton = shipsLayout.getFirstBattleshipButton();
                                            firstBattleshipButton.setEnabled(false);
                                            shipsLayout.setSelectedShip(null);
                                            if (plantedButtonsList.size() == 10) {

                                                Notification notification = new Notification("PLEASE TAB THE START BUTTON!", "", Notification.Type.WARNING_MESSAGE);
                                                notification.setStyleName("mystyle");
                                                notification.show(UI.getCurrent().getPage());
                                                startButton.setEnabled(true);

                                            } else {
                                                Notification.show("SELECT ANOTHER SHIP!", "", Notification.Type.WARNING_MESSAGE);
                                            }
                                        }
                                    }
                                } else {
                                    Notification.show("WRONG ACTION!", "YOU CAN'T PLANT A SHIP HERE", Notification.Type.WARNING_MESSAGE);
                                }

                            }
                        } else if (selectedShip == cruiser) {

                            if (selectedBtnRow == nextBtnRow && selectedBtnColumn == nextBtnColumn ||
                                    selectedBtnRow == nextBtnRow && selectedBtnColumn + 1 == nextBtnColumn ||
                                    selectedBtnRow == nextBtnRow && selectedBtnColumn + 2 == nextBtnColumn) {

                                if (selectedBtnRow == nextBtnRow &&
                                        selectedBtnColumn != 8 &&
                                        selectedBtnColumn != 9) {

                                    tableButtons.setData(1);
                                    tableButtons.addStyleName(ValoTheme.BUTTON_DANGER);
                                    tableButtons.setIcon(FontAwesome.SHIP);
                                    tableButtons.setEnabled(false);
                                    allPlantedButtonList.add(tableButtons);

                                    if (selectedBtnRow == nextBtnRow && selectedBtnColumn + 2 == nextBtnColumn) {

                                        plantedButtonsList.add(selectedTableButton);
                                        plantedButtonsListforCruiser.add(selectedTableButton);

                                        int plantedButtonListSizeForCruiser = plantedButtonsListforCruiser.size();
                                        int leftCruiserSize = 2 - plantedButtonListSizeForCruiser;
                                        shipLabelsLayout.getCruiserLabel().setValue("CRUISER" + " " + "(" + leftCruiserSize + ")");

                                        if (plantedButtonListSizeForCruiser == 2) {

                                            ShipButtons firstCruiserButton = shipsLayout.getFirstCruiserButton();
                                            firstCruiserButton.setEnabled(false);
                                            shipsLayout.setSelectedShip(null);
                                            if (plantedButtonsList.size() == 10) {

                                                Notification notification = new Notification("PLEASE TAB THE START BUTTON!", "", Notification.Type.WARNING_MESSAGE);
                                                notification.setStyleName("mystyle");
                                                notification.show(UI.getCurrent().getPage());
                                                startButton.setEnabled(true);

                                            } else {
                                                Notification.show("SELECT ANOTHER SHIP!", "", Notification.Type.WARNING_MESSAGE);
                                            }
                                        }
                                    }
                                } else {
                                    Notification.show("WRONG ACTION!", "YOU CAN'T PLANT A SHIP HERE", Notification.Type.WARNING_MESSAGE);
                                }


                            }
                        } else if (selectedShip == submarine) {

                            if (selectedBtnRow == nextBtnRow && selectedBtnColumn == nextBtnColumn ||
                                    selectedBtnRow == nextBtnRow && selectedBtnColumn + 1 == nextBtnColumn) {

                                if (selectedBtnRow == nextBtnRow &&
                                        selectedBtnColumn != 9) {
                                    tableButtons.setData(1);
                                    tableButtons.addStyleName(ValoTheme.BUTTON_DANGER);
                                    tableButtons.setIcon(FontAwesome.SHIP);
                                    tableButtons.setEnabled(false);
                                    allPlantedButtonList.add(tableButtons);

                                    if (selectedBtnRow == nextBtnRow && selectedBtnColumn + 1 == nextBtnColumn) {

                                        plantedButtonsList.add(selectedTableButton);
                                        plantedButtonsListforSubmarine.add(selectedTableButton);

                                        int plantedButtonListSizeForSubmarine = plantedButtonsListforSubmarine.size();
                                        int leftSubmarineSize = 2 - plantedButtonListSizeForSubmarine;
                                        shipLabelsLayout.getSubmarineLabel().setValue("SUBMARINE" + " " + "(" + leftSubmarineSize + ")");

                                        if (plantedButtonListSizeForSubmarine == 2) {

                                            ShipButtons firstSubmarineButton = shipsLayout.getFirstSubmarineButton();
                                            firstSubmarineButton.setEnabled(false);
                                            shipsLayout.setSelectedShip(null);
                                            if (plantedButtonsList.size() == 10) {

                                                Notification notification = new Notification("PLEASE TAB THE START BUTTON!", "", Notification.Type.WARNING_MESSAGE);
                                                notification.setStyleName("mystyle");
                                                notification.show(UI.getCurrent().getPage());
                                                startButton.setEnabled(true);

                                            } else {
                                                Notification.show("SELECT ANOTHER SHIP!", "", Notification.Type.WARNING_MESSAGE);
                                            }
                                        }
                                    }
                                } else {
                                    Notification.show("WRONG ACTION!", "YOU CAN'T PLANT A SHIP HERE", Notification.Type.WARNING_MESSAGE);
                                }
                            }

                        } else if (selectedShip == destroyer) {

                            if (selectedBtnRow == nextBtnRow && selectedBtnColumn == nextBtnColumn) {

                                tableButtons.setData(1);
                                tableButtons.addStyleName(ValoTheme.BUTTON_DANGER);
                                tableButtons.setIcon(FontAwesome.SHIP);
                                tableButtons.setEnabled(false);
                                allPlantedButtonList.add(tableButtons);

                                plantedButtonsList.add(selectedTableButton);
                                plantedButtonsListforDestroyer.add(selectedTableButton);

                                int plantedButtonListSizeForDestroyer = plantedButtonsListforDestroyer.size();
                                int leftDestroyerSize = 4 - plantedButtonListSizeForDestroyer;
                                shipLabelsLayout.getDestroyerLabel().setValue("DESTROYER" + " " + "(" + leftDestroyerSize + ")");

                                if (plantedButtonListSizeForDestroyer == 4) {

                                    ShipButtons firstDestroyerButton = shipsLayout.getFirstDestroyerButton();
                                    firstDestroyerButton.setEnabled(false);
                                    shipsLayout.setSelectedShip(null);

                                    if (plantedButtonsList.size() == 10) {

                                        Notification notification = new Notification("PLEASE TAB THE START BUTTON!", "", Notification.Type.WARNING_MESSAGE);
                                        notification.setStyleName("mystyle");
                                        notification.show(UI.getCurrent().getPage());
                                        startButton.setEnabled(true);

                                    } else {
                                        Notification.show("SELECT ANOTHER SHIP!", "", Notification.Type.WARNING_MESSAGE);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public ShipsLayout getShipsLayout() {
        return shipsLayout;
    }

    public void setShipsLayout(ShipsLayout shipsLayout) {
        this.shipsLayout = shipsLayout;
    }


    public TableButtons getTableButton() {
        return tableButton;
    }

    public void setTableButton(TableButtons tableButton) {
        this.tableButton = tableButton;
    }

    public List<TableButtons> getTableButtonsList() {
        return tableButtonsList;
    }

    public void setTableButtonsList(List<TableButtons> tableButtonsList) {
        this.tableButtonsList = tableButtonsList;
    }

    public boolean isStartButtonClicked() {
        return isStartButtonClicked;
    }

    public void setIsStartButtonClicked(boolean isStartButtonClicked) {
        this.isStartButtonClicked = isStartButtonClicked;
    }

    public List<TableButtons> getAllPlantedButtonList() {
        return allPlantedButtonList;
    }

    public void setAllPlantedButtonList(List<TableButtons> allPlantedButtonList) {
        this.allPlantedButtonList = allPlantedButtonList;
    }
}
