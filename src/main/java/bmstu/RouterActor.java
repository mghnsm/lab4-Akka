package bmstu;

import akka.actor.*;
import akka.actor.dsl.Creators;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

public class RouterActor extends AbstractActor {
    public static final int MAX_NR_OF_RETRIES = 4;
    public static final int WORKERS_COUNT = 5;
    private ActorRef storageActor;
    private SupervisorStrategy strategy;
    private ActorRef testerActor;

    RouterActor(ActorSystem sys) {
        this.storageActor = sys.actorOf(Props.create(StorageActor.class), "StorageActor");
        this.strategy = new OneForOneStrategy(MAX_NR_OF_RETRIES, Duration.ofMinutes(1), Collections.singletonList(Exception.class));
        this.testerActor = sys.actorOf(new RoundRobinPool(WORKERS_COUNT).withSupervisorStrategy(strategy).props(Props.create(TesterActor.class, storageActor)));
    }

    public void runTests(TestPackage testPackage) {
        for (TestData test : testPackage.getTests()) {
            test.setParent(testPackage);
            testerActor.tell(test, ActorRef.noSender());
        }
    }

    @Override
    public Receive createRecieve() {
        return ReceiveBuilder.create()
                .match(TestPackage.class, message -> runTests(message))
                .match(String.class, message -> storageActor.forward(message, getContext()))
                .build();
    }
}
