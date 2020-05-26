package spring.cloud.hystrix.extend.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import spring.cloud.hystrix.extend.domain.User;
import spring.cloud.hystrix.extend.service.UserService;

import java.util.LinkedList;
import java.util.List;

public class UserBatchCommand extends HystrixCommand<List<User>> {

    private UserService userService;
    private List<Integer> userIds;

    public UserBatchCommand(UserService userService, List<Integer> userIds) {
        super(Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("user")));
        this.userService = userService;
        this.userIds = userIds;
    }

    @Override
    protected List<User> run() {
        return userService.findAllByCode(this.userIds);
    }

    @Override
    protected List<User> getFallback() {
        List<User> users = new LinkedList<>();
        this.userIds.forEach(id -> users.add(new User(0, "parallel query over 5")));
        return users;
    }
}
