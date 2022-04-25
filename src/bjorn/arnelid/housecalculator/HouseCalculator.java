package bjorn.arnelid.housecalculator;

import bjorn.arnelid.housecalculator.model.Economy;
import bjorn.arnelid.housecalculator.model.Member;
import bjorn.arnelid.housecalculator.ui.CalculatorPane;
import bjorn.arnelid.housecalculator.ui.UserDialog;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;


public class HouseCalculator extends Application {
    private final Economy economy = new Economy(32);
    private CalculatorPane root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("House Calculator");
        MenuBar mb = new MenuBar();

        Menu userMenu = new Menu("User");
        mb.getMenus().add(userMenu);

        for (Member member : this.economy.getMembers()) {
            addUserItem(userMenu, member);
        }

        userMenu.getItems().add(new SeparatorMenuItem());

        MenuItem newUser = new MenuItem("New User");
        userMenu.getItems().add(newUser);

        EventHandler<ActionEvent> event = actionEvent -> {
            UserDialog dialog = new UserDialog(null);
            Optional<Member> result = dialog.show();
            result.ifPresent(user -> addUserItem(userMenu, user));
            updateToSpend();
        };
        newUser.setOnAction(event);

        root = new CalculatorPane();
        VBox vb = new VBox(mb, root);
        stage.setScene(new Scene(vb, 600, 500));

        updateToSpend();
        stage.show();
    }

    private void addUserItem(Menu userMenu, Member member) {
        this.economy.addMember(member);

        MenuItem existingUser= new MenuItem(member.getName());
        userMenu.getItems().add(0, existingUser);

        EventHandler<ActionEvent> event = actionEvent -> {
            UserDialog dialog = new UserDialog(member);
            Optional<Member> result = dialog.show();
            result.ifPresent(member::update);
            updateToSpend();
        };
        existingUser.setOnAction(event);
    }

    private void updateToSpend() {
        Integer amount = this.economy.getToSpend();
        root.updateToSpend(amount);
    }
}
