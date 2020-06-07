package spring.boot.starter.web.rest.service;

import org.springframework.stereotype.Service;
import spring.boot.starter.web.rest.domain.User;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private Map<Integer, User> userMap;

    public UserService() {
        this.userMap = new ConcurrentHashMap<>(16);
        this.userMap.put(1, new User(1, "Tom", 0.87f));
        this.userMap.put(2, new User(2, "Sean", 0.69f));
    }

    public void updateUser(User user) {
        this.userMap.put(user.getId(), user);
    }

    public User readUser(Integer id) {
        User user = this.userMap.get(id);
        if (user == null) {
            return null;
        } else {
            return new User(user.getId(), user.getName(), user.getRebate());
        }
    }

    public void deleteUser(Integer id) {
        this.userMap.remove(id);
    }

    public Map<Integer, User> queryUser() {
        return this.userMap;
    }

    public User defaultUser() {
        Integer newId = this.userMap.keySet().
                stream().max(Integer::compareTo).orElse(1) + 1;
        return new User(newId, "visitor", new Random().nextFloat());
    }
}
