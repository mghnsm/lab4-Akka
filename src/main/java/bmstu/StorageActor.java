package bmstu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StorageActor {
    private Map<String, ArrayList<TestData>> storage = new HashMap<>();
    public void add(TestData data) {
        String packageId = data.getParent().getPackageId();
        if(this.storage.containsKey(packageId)) {
            this.storage.get(packageId).add(data);
        } else {
            ArrayList<TestData> tests = new ArrayList<>();
            tests.add(data);
            this.storage.put(packageId, tests);
        }
    }
}
