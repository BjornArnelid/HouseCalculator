package bjorn.arnelid.housecalculator;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Economy {
    ArrayList<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public int getIncome() {
        return users.stream().collect(Collectors.summingInt(User::getPay));
    }

    public int getDisposableIncome() {
        return (int) Math.round(0.25 * getIncome());
    }
}
