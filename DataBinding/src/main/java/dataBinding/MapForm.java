package dataBinding;

import java.util.Map;

public class MapForm {

    private Map<String,String> map;

    private Map<String,User> userMap;

    @Override
    public String toString() {
        return "map=" + map+"   userMap: "+userMap;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
