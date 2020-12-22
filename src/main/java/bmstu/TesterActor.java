package bmstu;

import akka.actor.ActorRef;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TesterActor {
    private ActorRef storageActor;

    TesterActor(ActorRef storageActor) {
        this.storageActor = storageActor;
    }

    public String runTest(TestData data) throws NoSuchMethodException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName();
        engine.eval(data.getParent().getJsScript());
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(data.getParent().getFunctionName(), data.getParams()).toString();
    }

    public TestData checkRes(TestData data) {
        try {
            String getRes = runTest(data);
            data.setResult(getRes);
        } catch (Exception exception) {
            
        }
        return data;
    }

}
