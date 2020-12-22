package bmstu;

import akka.actor.ActorRef;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TesterActor {
    private ActorRef storageActor;

    TesterActor(ActorRef storageActor) {
        this.storageActor = storageActor;
    }

    public String runTest(TestData data) {
        ScriptEngine engine = new ScriptEngineManager()
    }
}
