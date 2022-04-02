package bjorn.arnelid.housecalculator;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class HouseCalculator extends Application {
    private final List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("House Calculator");
        MenuBar mb = new MenuBar();

        Menu userMenu = new Menu("User");
        mb.getMenus().add(userMenu);

        for (User user : this.users) {
            addUserItem(userMenu, user);
        }

        userMenu.getItems().add(new SeparatorMenuItem());

        MenuItem newUser = new MenuItem("New User");
        userMenu.getItems().add(newUser);

        EventHandler<ActionEvent> event = actionEvent -> {
            UserDialog dialog = new UserDialog(null);
            Optional<User> result = dialog.show();
            result.ifPresent(user -> addUserItem(userMenu, user));
        };
        newUser.setOnAction(event);

        CalculatorPane root = new CalculatorPane();

        VBox vb = new VBox(mb, root);

        stage.setScene(new Scene(vb, 600, 500));
        stage.show();
    }

    private void addUserItem(Menu userMenu, User user) {
        users.add(user);

        MenuItem existingUser= new MenuItem(user.getName());
        userMenu.getItems().add(0, existingUser);

        EventHandler<ActionEvent> event = actionEvent -> {
            UserDialog dialog = new UserDialog(user);
            Optional<User> result = dialog.show();
            // TODO update user
            result.ifPresent(user::update);
        };
        existingUser.setOnAction(event);
    }
}
