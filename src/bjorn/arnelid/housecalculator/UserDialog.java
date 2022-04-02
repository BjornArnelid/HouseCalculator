package bjorn.arnelid.housecalculator;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class UserDialog {
    private final Dialog<User> dialog;

    public UserDialog(User user) {
        dialog = new Dialog<>();
        if(user == null) {
            dialog.setTitle("New User");
        } else {
            dialog.setTitle(user.getName());
        }

        ButtonType loginButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField name = new TextField();
        name.setPromptText("Name");
        TextField income = new TextField();
        if (user != null) {
            name.setText(user.getName());
            income.setText(String.valueOf(user.getPay()));
        } else {
            income.setText("0");
        }

        grid.add(new Label("Name:"), 0, 0);
        grid.add(name, 1, 0);
        grid.add(new Label("Income:"), 0, 1);
        grid.add(income, 1, 1);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new User(name.getText(), income.getText());
            }
            return null;
        });
    }

    /**
     * Display the user dialog
     *
     * @return created user or null
     */
    public Optional<User> show() {
        return dialog.showAndWait();
    }
}
