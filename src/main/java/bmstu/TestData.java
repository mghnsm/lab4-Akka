package bmstu;

import com.fasterxml.jackson.annotation.JsonCreator;

public class TestData {
    private Object[] params;
    private TestPackage parent;
    private String name;
    private String result;
    private String expected;

    @JsonCreator
    public TestData(String name, String expected) {
        this.name = name;
        this.expected = expected;
    }

    public Object[] getParams() { return this.params; }
    public String getResult() {
        return result;
    }
    public String getName() { return name; }
    public String getExpected() {
        return expected;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public void setParent(TestPackage parent) {
        this.parent = parent;
    }
    public TestPackage getParent() { return this.parent; }
}

