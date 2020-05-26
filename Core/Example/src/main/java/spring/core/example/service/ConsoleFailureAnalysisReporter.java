package spring.core.example.service;

import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalysisReporter;

public class ConsoleFailureAnalysisReporter implements FailureAnalysisReporter {

    @Override
    public void report(FailureAnalysis analysis) {
        System.out.printf("故障描述： %s \n执行动作： %s \n异常堆栈： %s \n",
                analysis.getDescription(),
                analysis.getAction(),
                analysis.getCause());
    }
}
