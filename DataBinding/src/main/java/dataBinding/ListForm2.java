package dataBinding;

import java.util.List;

public class ListForm2 {


    private List<User> users;

    @Override
    public String toString() {
        return "users: "+users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
