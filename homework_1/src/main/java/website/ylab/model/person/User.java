package website.ylab.model.person;

public class User extends Person {
    public User(String login, String password, String email) {
        super(login, password, email);
    }

    @Override
    public int getInfoKcalSpent() {
        return 0;
    }
}
