package spring.boot.starter.validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.starter.validation.domain.Message;
import spring.boot.starter.validation.service.IndexService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class MessageTests {

    @Autowired
    IndexService service;

    @Test
    void success() {
        System.out.println("result: " + service.messageHandler(getMessage()));
    }

    private Message getMessage() {

        List<String> list = Arrays.asList("a", "b", "c");

        Message message = new Message();
        message.setAssertFalse(false);
        message.setAssertTrue(true);
        message.setDecimalMax("453.56");
        message.setDecimalMin("342.01");
        message.setDigits(34.12);
        message.setEmail("12306@qq.com");
        message.setFuture(LocalDateTime.now().plusDays(1));
        message.setFutureOrPresent(LocalDateTime.now().plusHours(1));
        message.setMax(999);
        message.setMin(100);
        message.setNegative(-11);
        message.setNegativeOrZero(0);
        message.setNotBlank("blank");
        message.setNotEmpty("empty");
        message.setNotNull("");
        message.setMustNull(null);
        message.setPast(LocalDate.now().minusDays(1));
        message.setPastOrPresent(LocalDate.now());
        message.setPattern("12306");
        message.setPositive(12.45f);
        message.setPositiveOrZero(0.0f);
        message.setSize(list);
        message.setAmount(new BigDecimal("0.5001"));

        return message;
    }
}
