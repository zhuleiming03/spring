package spring.mvc.resttemplate.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class CallDeleteService {

    public CallDeleteService(String serviceHome) {
        this.serviceHome = serviceHome;
        this.restTemplate = new RestTemplate();
    }

    private String serviceHome;

    private RestTemplate restTemplate;

    public void deleteUserOne() {
        String url = serviceHome + "delete/user?id=1";
        restTemplate.delete(url);
    }

    public void deleteUserTwo() {
        String url = serviceHome + "delete/user?id={id}";
        Map<String, String> params = new HashMap<>(1);
        params.put("id", "2");
        restTemplate.delete(url, params);
    }

    public void deleteUserThree() {
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(serviceHome + "delete/user?id={id}")
                .build()
                .expand(2)
                .encode();
        URI uri = uriComponents.toUri();
        restTemplate.delete(uri);
    }
}
