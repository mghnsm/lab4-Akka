package bmstu;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StorageActor extends AbstractActor {
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

    private Request makeRes(String packageId) {
        ArrayList<TestResult> answers = new ArrayList<>();
        if (this.storage.containsKey(packageId)) {
            for ()
        }
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder
                .create()
                .match(TestData.class, test -> this.add(test))
                .match(String.class, id -> sender().tell());
    }
}
