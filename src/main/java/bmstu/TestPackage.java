package bmstu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class TestPackage implements Serializable {
    private String packageId;
    private String functionName;
    private String jsScript;
    private ArrayList<TestData> test;

    @JsonCreator
    public TestPackage(String packageId, String functionName, String jsScript, ArrayList<TestData> test) {
        this.packageId = packageId;
        this.functionName = functionName;
        this.jsScript = jsScript;
        this.test = test;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getJsScript() {
        return jsScript;
    }
}
