package Layouts.tableLayouts;

import Buttons.RefreshButton;
import Buttons.TableButtons;
import Layouts.CounterLayout;
import buttonAdress.Adress;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FULGAY on 2/2/2020.
 */
public class NewTableLayout extends VerticalLayout {

    CounterLayout counterLayout;
    TableLayout tableLayout;
    TableButtons newTableButton;
    List<TableButtons> allPlantedButtonList;
    List<TableButtons> newTableButtonList = new ArrayList<>();
    List<TableButtons> gotShotTableButtonsList = new ArrayList<>();
    List<TableButtons> emptyTableButtonList = new ArrayList<>();
    RefreshButton refreshButton;

    public NewTableLayout(TableLayout tableLayout, TableButtons newTableButton, CounterLayout counterLayout) {

        this.counterLayout = counterLayout;
        this.tableLayout = tableLayout;
        this.newTableButton = newTableButton;
        refreshButton = counterLayout.getRefreshButton();

        setSpacing(false);
        buildTable();
        refreshBtnListener();
    }

    private void refreshBtnListener() {
        refreshButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().getPage().reload();
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

        allPlantedButtonList = tableLayout.getAllPlantedButtonList();

        newTableButton = new TableButtons();
        setButtonAdress(i, j, newTableButton);

        newTableButton.setData(0);

        int selectedBtnColumn = newTableButton.getAdress().getColumn();
        int selectedBtnRow = newTableButton.getAdress().getRow();

        for (TableButtons tableButtons : allPlantedButtonList) {

            int plantedBtnColumn = tableButtons.getAdress().getColumn();
            int plantedBtnRow = tableButtons.getAdress().getRow();

            if (selectedBtnRow == plantedBtnRow && selectedBtnColumn == plantedBtnColumn) {

                newTableButton.setData(1);
                newTableButtonList.add(newTableButton);

            }
        }
        selectedButtonListener(newTableButton);

        newTableButtonList.add(newTableButton);
        horizontalLayout.addComponent(newTableButton);
        addComponent(horizontalLayout);
    }

    private void setButtonAdress(int i, int j, TableButtons newTableButton) {

        Adress adress = new Adress();
        adress.setRow(i);
        adress.setColumn(j);
        newTableButton.setAdress(adress);
    }

    private void selectedButtonListener(TableButtons newTableButton) {

        newTableButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                Integer data = (Integer) newTableButton.getData();

                if (data == 1) {
                    newTableButton.addStyleName(ValoTheme.BUTTON_DANGER);
                    newTableButton.setIcon(FontAwesome.SHIP);
                    newTableButton.setEnabled(false);
                    gotShotTableButtonsList.add(newTableButton);
                    if (gotShotTableButtonsList.size() == 22) {

                        for (TableButtons tableButtons : newTableButtonList) {
                            tableButtons.setEnabled(false);
                        }
                        Notification notification = new Notification("CONGRATULATIONS!", "YOU WIN",Notification.TYPE_ERROR_MESSAGE);
                        notification.setStyleName("mystyle");
                        notification.show(UI.getCurrent().getPage());

                    } else {
                        Notification notification = new Notification("GOOD SHOT!!", "",Notification.Type.WARNING_MESSAGE);
                        notification.setStyleName("mystyle");
                        notification.show(UI.getCurrent().getPage());
                    }
                } else {

                    emptyTableButtonList.add(newTableButton);

                    int size = emptyTableButtonList.size();
                    int remainingShots = 40 - size;
                    counterLayout.getShotsLabel().setValue(String.valueOf(remainingShots));

                    Notification.show("OOPS!", "", Notification.Type.WARNING_MESSAGE);
                    newTableButton.setEnabled(false);

                    if (emptyTableButtonList.size() == 40) {

                        for (TableButtons tableButtons : newTableButtonList) {

                            tableButtons.setEnabled(false);

                            Integer data1 = (Integer) tableButtons.getData();

                            if (data1 == 1) {
                                tableButtons.addStyleName(ValoTheme.BUTTON_DANGER);
                                tableButtons.setIcon(FontAwesome.SHIP);
                            }
                        }

                        Notification.show("SORRY!", "YOU LOST", Notification.Type.ERROR_MESSAGE);

                    }
                }
            }
        });
    }
}
