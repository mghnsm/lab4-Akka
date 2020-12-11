package bmstu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class TestPackage {
    private String packageId;
    private String functionName;
    private String jsScript;
    private ArrayList<> test;

    @JsonCreator
    public TestPackage(String packageId, String functionName, String jsScript, ArrayList<> test) {
        this.packageId = packageId;
        this.functionName = functionName;
        this.jsScript = jsScript;
        this.test = test;
    }
}
