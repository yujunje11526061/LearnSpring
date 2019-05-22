package dataBinding;

import java.util.List;

public class ListForm {

    private List<Integer> list;

    private List<User> users;

    @Override
    public String toString() {
        return list+ "    "+users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
