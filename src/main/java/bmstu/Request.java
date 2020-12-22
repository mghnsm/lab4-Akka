package bmstu;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class Request {
    private String packageId;
    private List<TestResult> tests;

    @JsonCreator
    public Request(String packageId, List<TestResult> tests) {
        this.packageId = packageId;
        this.tests = tests;
    }
}
