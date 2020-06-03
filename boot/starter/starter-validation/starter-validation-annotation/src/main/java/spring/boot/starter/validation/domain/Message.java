package spring.boot.starter.validation.domain;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Message {

    /**
     * 所注解的元素必须是Boolean类型，且值为false
     */
    @AssertFalse
    private Boolean assertFalse;

    /**
     * 所注解的元素必须是Boolean类型，且值为true
     */
    @AssertTrue
    private Boolean assertTrue;

    /**
     * 所注解的元素必须是数字，且值小于等于给定的值
     */
    @DecimalMax("10000.00")
    private String decimalMax;

    /**
     * 所注解的元素必须是数字，且值大于等于给定的值
     */
    @DecimalMin("199.99")
    private String decimalMin;

    /**
     * 所注解的元素必须是数字，且值必须是指定的位数
     */
    @Digits(integer = 3, fraction = 2)
    private Double digits;

    /**
     * 所注解的元素需满足Email格式
     */
    @Email
    private String email;

    /**
     * 所注解的元素必须是将来某个日期
     */
    @Future
    private LocalDateTime future;

    /**
     * 所注解的元素必须是将来某个或现在日期
     */
    @FutureOrPresent
    private LocalDateTime futureOrPresent;

    /**
     * 所注解的元素必须是数字，且值小于等于给定的值
     */
    @Max(1000)
    private Integer max;

    /**
     * 所注解的元素必须是数字，且值小于等于给定的值
     */
    @Min(100)
    private Integer min;

    /**
     * 所注解的元素必须是负数
     */
    @Negative
    private Integer negative;

    /**
     * 所注解的元素必须是负数或零
     */
    @NegativeOrZero
    private Integer negativeOrZero;

    /**
     * 所注解的元素值有内容
     */
    @NotBlank
    private String notBlank;

    @NotEmpty
    private String notEmpty;

    /**
     * 所注解的元素值不能为null
     */
    @NotNull
    private String notNull;

    /**
     * 所注解的元素值为null
     */
    @Null
    private String mustNull;

    /**
     * 所注解的元素必须是某个过去的日期
     */
    @Past
    private LocalDate past;

    /**
     * 所注解的元素必须是过去某个或现在日期
     */
    @PastOrPresent
    private LocalDate pastOrPresent;

    /**
     * 所注解的元素必须满足给定的正则表达式
     */
    @Pattern(regexp = "\\d+")
    private String pattern;

    /**
     * 所注解的元素必须是正数
     */
    @Positive
    private Float positive;

    /**
     * 所注解的元素必须是正数或零
     */
    @PositiveOrZero
    private Float positiveOrZero;

    /**
     * 所注解的元素必须是String、集合或数组，且长度大小需保证在给定范围之内
     */
    @Size(max = 10, min = 1)
    private List<String> size;

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "assertFalse=" + assertFalse +
                ", assertTrue=" + assertTrue +
                ", decimalMax=" + decimalMax +
                ", decimalMin=" + decimalMin +
                ", digits=" + digits +
                ", email='" + email + '\'' +
                ", future=" + future +
                ", futureOrPresent='" + futureOrPresent + '\'' +
                ", max=" + max +
                ", min=" + min +
                ", negative='" + negative + '\'' +
                ", negativeOrZero='" + negativeOrZero + '\'' +
                ", notBlank='" + notBlank + '\'' +
                ", notEmpty='" + notEmpty + '\'' +
                ", notNull='" + notNull + '\'' +
                ", mustNull='" + mustNull + '\'' +
                ", past=" + past +
                ", pastOrPresent=" + pastOrPresent +
                ", pattern='" + pattern + '\'' +
                ", positive='" + positive + '\'' +
                ", positiveOrZero='" + positiveOrZero + '\'' +
                ", size=" + size +
                '}';
    }

    public Boolean getAssertFalse() {
        return assertFalse;
    }

    public void setAssertFalse(Boolean assertFalse) {
        this.assertFalse = assertFalse;
    }

    public Boolean getAssertTrue() {
        return assertTrue;
    }

    public void setAssertTrue(Boolean assertTrue) {
        this.assertTrue = assertTrue;
    }

    public String getDecimalMax() {
        return decimalMax;
    }

    public void setDecimalMax(String decimalMax) {
        this.decimalMax = decimalMax;
    }

    public String getDecimalMin() {
        return decimalMin;
    }

    public void setDecimalMin(String decimalMin) {
        this.decimalMin = decimalMin;
    }

    public Double getDigits() {
        return digits;
    }

    public void setDigits(Double digits) {
        this.digits = digits;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getFuture() {
        return future;
    }

    public void setFuture(LocalDateTime future) {
        this.future = future;
    }

    public LocalDateTime getFutureOrPresent() {
        return futureOrPresent;
    }

    public void setFutureOrPresent(LocalDateTime futureOrPresent) {
        this.futureOrPresent = futureOrPresent;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getNegative() {
        return negative;
    }

    public void setNegative(Integer negative) {
        this.negative = negative;
    }

    public Integer getNegativeOrZero() {
        return negativeOrZero;
    }

    public void setNegativeOrZero(Integer negativeOrZero) {
        this.negativeOrZero = negativeOrZero;
    }

    public String getNotBlank() {
        return notBlank;
    }

    public void setNotBlank(String notBlank) {
        this.notBlank = notBlank;
    }

    public String getNotEmpty() {
        return notEmpty;
    }

    public void setNotEmpty(String notEmpty) {
        this.notEmpty = notEmpty;
    }

    public String getNotNull() {
        return notNull;
    }

    public void setNotNull(String notNull) {
        this.notNull = notNull;
    }

    public String getMustNull() {
        return mustNull;
    }

    public void setMustNull(String mustNull) {
        this.mustNull = mustNull;
    }

    public LocalDate getPast() {
        return past;
    }

    public void setPast(LocalDate past) {
        this.past = past;
    }

    public LocalDate getPastOrPresent() {
        return pastOrPresent;
    }

    public void setPastOrPresent(LocalDate pastOrPresent) {
        this.pastOrPresent = pastOrPresent;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Float getPositive() {
        return positive;
    }

    public void setPositive(Float positive) {
        this.positive = positive;
    }

    public Float getPositiveOrZero() {
        return positiveOrZero;
    }

    public void setPositiveOrZero(Float positiveOrZero) {
        this.positiveOrZero = positiveOrZero;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }
}
