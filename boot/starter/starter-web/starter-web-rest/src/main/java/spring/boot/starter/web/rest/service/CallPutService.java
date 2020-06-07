package spring.boot.starter.web.rest.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import spring.boot.starter.web.rest.domain.User;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class CallPutService {

    public CallPutService(String serviceHome) {
        this.serviceHome = serviceHome;
        this.restTemplate = new RestTemplate();
    }

    private String serviceHome;

    private RestTemplate restTemplate;

    public void putUserOne() {
        String url = serviceHome + "put/user";
        User user = new User();
        user.setId(20);
        restTemplate.put(url, user);
    }

    public void putUserTwo() {
        String url = serviceHome + "put/user/id?id={id}";
        User user = new User(16, "Daniel", 0.77f);
        Map<String, String> params = new HashMap<>(1);
        params.put("id", "14");
        restTemplate.put(url, user, params);
    }

    public void putUserThree() {
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(serviceHome + "put/user")
                .build()
                .encode();
        URI uri = uriComponents.toUri();
        User user = new User(14, "Daniel", 0.85f);
        restTemplate.put(uri, user);
    }
}
