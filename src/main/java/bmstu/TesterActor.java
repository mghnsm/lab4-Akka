package bmstu;

import akka.actor.ActorRef;

import javax.script.*;
import java.io.Reader;

public class TesterActor {
    private ActorRef storageActor;

    TesterActor(ActorRef storageActor) {
        this.storageActor = storageActor;
    }

    public String runTest(TestData data) {
        ScriptEngine engine = new ScriptEngine() {
            @Override
            public Object eval(String script, ScriptContext context) throws ScriptException {
                return null;
            }

            @Override
            public Object eval(Reader reader, ScriptContext context) throws ScriptException {
                return null;
            }

            @Override
            public Object eval(String script) throws ScriptException {
                return null;
            }

            @Override
            public Object eval(Reader reader) throws ScriptException {
                return null;
            }

            @Override
            public Object eval(String script, Bindings n) throws ScriptException {
                return null;
            }

            @Override
            public Object eval(Reader reader, Bindings n) throws ScriptException {
                return null;
            }

            @Override
            public void put(String key, Object value) {

            }

            @Override
            public Object get(String key) {
                return null;
            }

            @Override
            public Bindings getBindings(int scope) {
                return null;
            }

            @Override
            public void setBindings(Bindings bindings, int scope) {

            }

            @Override
            public Bindings createBindings() {
                return null;
            }

            @Override
            public ScriptContext getContext() {
                return null;
            }

            @Override
            public void setContext(ScriptContext context) {

            }

            @Override
            public ScriptEngineFactory getFactory() {
                return null;
            }
        }
    }
}
