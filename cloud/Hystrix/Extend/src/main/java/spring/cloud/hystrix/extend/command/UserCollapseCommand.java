package spring.cloud.hystrix.extend.command;

import com.netflix.hystrix.*;
import spring.cloud.hystrix.extend.domain.User;
import spring.cloud.hystrix.extend.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserCollapseCommand extends HystrixCollapser<List<User>,User,Integer> {

    private UserService userService;
    private Integer userId;

    public UserCollapseCommand(UserService userService, Integer userId) {
        super(Setter
                .withCollapserKey(HystrixCollapserKey
                        .Factory
                        .asKey("userCollapseCommand"))
                .andScope(Scope.GLOBAL)
                .andCollapserPropertiesDefaults(HystrixCollapserProperties
                        .Setter()
                        .withTimerDelayInMilliseconds(100)
                        .withMaxRequestsInBatch(5)));
        this.userService = userService;
        this.userId = userId;
    }

    @Override
    public Integer getRequestArgument() {
        return userId;
    }

    @Override
    protected HystrixCommand<List<User>> createCommand(
            Collection<CollapsedRequest<User, Integer>> collection) {
        List<Integer> userIds = new ArrayList<>(collection.size());
        userIds.addAll(collection
                .stream()
                .map(CollapsedRequest::getArgument)
                .collect(Collectors.toList()));
        return new UserBatchCommand(userService, userIds);
    }

    @Override
    protected void mapResponseToRequests(
            List<User> users,
            Collection<CollapsedRequest<User, Integer>> collection) {
        int count = 0;
        for (CollapsedRequest<User, Integer> collapsedRequest : collection) {
            User user = users.get(count++);
            collapsedRequest.setResponse(user);
        }
    }
}
