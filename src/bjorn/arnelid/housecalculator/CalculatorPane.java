package bjorn.arnelid.housecalculator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CalculatorPane extends GridPane {
    private final Label spendAmountLabel;

    public CalculatorPane() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));

        Label toSpendLabel = new Label("To spend:");
        add(toSpendLabel, 0, 1);

        spendAmountLabel = new Label("0");
        add(spendAmountLabel, 1, 1);
    }

    public void updateToSpend(int amount) {
        spendAmountLabel.setText(String.valueOf(amount));
    }
}
