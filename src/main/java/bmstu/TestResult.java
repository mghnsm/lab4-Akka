package bmstu;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;

public class TestResult implements Serializable {
    private String result;
    private String expected;
    private Boolean success;

    @JsonCreator
    public TestResult(String result, String expected, Boolean success) {
        this.result = result;
        this.expected = expected;
        this.success = success;
    }
}
