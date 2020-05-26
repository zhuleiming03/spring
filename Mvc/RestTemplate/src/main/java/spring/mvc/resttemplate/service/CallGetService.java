package spring.mvc.resttemplate.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import spring.mvc.resttemplate.domain.User;

import java.net.URI;
import java.util.*;

public class CallGetService {

    public CallGetService(String serviceHome) {
        this.serviceHome = serviceHome;
        this.restTemplate = new RestTemplate();
    }

    private String serviceHome;

    private RestTemplate restTemplate;

    public ResponseEntity<User> getUserEntityOne() {
        String url = serviceHome + "get/user?id=1";
        return restTemplate.getForEntity(url, User.class);
    }

    public ResponseEntity<User> getUserEntityTwo() {
        String url = serviceHome + "get/user?id={id}";
        Map<String, String> params = new HashMap<>(1);
        params.put("id", "1");
        return restTemplate.getForEntity(url, User.class, params);
    }

    public ResponseEntity<User> getUserEntityThree() {
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(serviceHome + "get/user?id={id}")
                .build()
                .expand(1)
                .encode();
        URI uri = uriComponents.toUri();
        return restTemplate.getForEntity(uri, User.class);
    }

    public User getUserOne() {
        String url = serviceHome + "get/user?id=2";
        return restTemplate.getForObject(url, User.class);
    }

    public User getUserTwo() {
        String url = serviceHome + "get/user?id={id}";
        Map<String, String> params = new HashMap<>(1);
        params.put("id", "2");
        return restTemplate.getForObject(url, User.class, params);
    }

    public User getUserThree() {
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(serviceHome + "get/user?id={id}")
                .build()
                .expand(2)
                .encode();
        URI uri = uriComponents.toUri();
        return restTemplate.getForObject(uri, User.class);
    }

    public List<User> getUserFour() {
        String url = serviceHome + "get/list";
        User[] users = restTemplate.getForObject(url, User[].class);
        if (users != null) {
            return Arrays.asList(users);
        }
        return null;
    }
}
