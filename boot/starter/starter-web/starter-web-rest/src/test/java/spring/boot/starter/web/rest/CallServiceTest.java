package spring.boot.starter.web.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import spring.boot.starter.web.rest.domain.User;
import spring.boot.starter.web.rest.service.CallDeleteService;
import spring.boot.starter.web.rest.service.CallGetService;
import spring.boot.starter.web.rest.service.CallPostService;
import spring.boot.starter.web.rest.service.CallPutService;

import java.net.URI;
import java.util.List;

/**
 * 运行此Test前，请先package项目，并运行jar
 * java -jar starter-web-rest-0.0.1-SNAPSHOT.jar --server.port=8090
 */
@SpringBootTest
class CallServiceTest {

    private static final String SERVICE_HOME="http://localhost:8090/";

    @Test
    void getTest() {

        CallGetService callGetService = new CallGetService(SERVICE_HOME);

        ResponseEntity<User> entityOne = callGetService.getUserEntityOne();
        if (entityOne.getStatusCodeValue() == 200) {
            System.out.println(entityOne.getBody());
        }

        ResponseEntity<User> entityTwo = callGetService.getUserEntityTwo();
        if (entityTwo.getStatusCodeValue() == 200) {
            System.out.println(entityTwo.getBody());
        }

        ResponseEntity<User> entityThree = callGetService.getUserEntityThree();
        if (entityThree.getStatusCodeValue() == 200) {
            System.out.println(entityThree.getBody());
        }

        User userOne = callGetService.getUserOne();
        System.out.println(userOne);

        User userTwo = callGetService.getUserTwo();
        System.out.println(userTwo);

        User userThree = callGetService.getUserThree();
        System.out.println(userThree);

        List<User> userFour = callGetService.getUserFour();
        System.out.println(userFour);
    }

    @Test
    void postTest() {

        CallPostService callPostService = new CallPostService(SERVICE_HOME);

        ResponseEntity<User> entityOne = callPostService.postUserEntityOne();
        if (entityOne.getStatusCodeValue() == 200) {
            System.out.println(entityOne.getBody());
        }

        ResponseEntity<User> entityTwo = callPostService.postUserEntityTwo();
        if (entityTwo.getStatusCodeValue() == 200) {
            System.out.println(entityTwo.getBody());
        }

        ResponseEntity<User> entityThree = callPostService.postUserEntityThree();
        if (entityThree.getStatusCodeValue() == 200) {
            System.out.println(entityThree.getBody());
        }

        User userOne = callPostService.postUserOne();
        System.out.println(userOne);

        User userTwo = callPostService.postUserTwo();
        System.out.println(userTwo);

        User userThree = callPostService.postUserThree();
        System.out.println(userThree);

        URI uri = callPostService.postUri();
        System.out.println(uri);
    }

    @Test
    void putTest() {

        CallPutService callPutService = new CallPutService(SERVICE_HOME);
        callPutService.putUserOne();
        callPutService.putUserTwo();
        callPutService.putUserThree();
    }

    @Test
    void deleteTest() {

        CallDeleteService callDeleteService = new CallDeleteService(SERVICE_HOME);
        callDeleteService.deleteUserOne();
        callDeleteService.deleteUserTwo();
        callDeleteService.deleteUserThree();
    }
}