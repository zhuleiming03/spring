package spring.mvc.resttemplate.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import spring.mvc.resttemplate.domain.User;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class CallPostService {

    public CallPostService(String serviceHome) {
        this.serviceHome = serviceHome;
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<User> postUserEntityOne() {
        String url = serviceHome + "post/user";
        User user = new User();
        user.setId(11);
        return restTemplate.postForEntity(url, user, User.class);
    }

    public ResponseEntity<User> postUserEntityTwo() {
        String url = serviceHome + "post/user?id={id}";
        User user = new User(11, "Jewel", 0.95f);
        Map<String, String> params = new HashMap<>(1);
        params.put("id", "11");
        return restTemplate.postForEntity(url, user, User.class, params);
    }

    public ResponseEntity<User> postUserEntityThree() {
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(serviceHome + "post/user")
                .build()
                .encode();
        URI uri = uriComponents.toUri();
        User user = new User(12, "Jewel", 0.88f);
        return restTemplate.postForEntity(uri, user, User.class);
    }

    public User postUserOne() {
        String url = serviceHome + "post/user";
        User user = new User();
        user.setId(14);
        return restTemplate.postForObject(url, user, User.class);
    }

    public User postUserTwo() {
        String url = serviceHome + "post/user/id?id={id}";
        User user = new User(14, "Daniel", 0.77f);
        Map<String, String> params = new HashMap<>(1);
        params.put("id", "16");
        return restTemplate.postForObject(url, user, User.class, params);
    }

    public User postUserThree() {
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(serviceHome + "post/user")
                .build()
                .encode();
        URI uri = uriComponents.toUri();
        User user = new User(14, "Daniel", 0.85f);
        return restTemplate.postForObject(uri, user, User.class);
    }

    public URI postUri() {
        String url = serviceHome + "post/user";
        User user = new User();
        user.setId(15);
        return restTemplate.postForLocation(url, user);
    }

    private String serviceHome;

    private RestTemplate restTemplate;
}
