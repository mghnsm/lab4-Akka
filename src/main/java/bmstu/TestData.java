package bmstu;

import com.fasterxml.jackson.annotation.JsonCreator;

public class TestData {
    private TestPackage parent;
    private String name;
    private String result;
    private String expected;

    @JsonCreator
    public TestData(String name, String expected) {
        this.name = name;
        this.expected = expected;
    }
}
