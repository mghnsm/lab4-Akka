package bmstu;

import akka.actor.*;
import akka.actor.dsl.Creators;
import akka.routing.RoundRobinPool;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

public class RouterActor implements AbstractActor {
    private ActorRef storageActor;
    private SupervisorStrategy strategy;
    private ActorRef testerActor;

    RouterActor(ActorSystem sys) {
        this.storageActor = sys.actorOf(Props.create(StorageActor.class), "StorageActor");
        this.strategy = new OneForOneStrategy(4, Duration.ofMinutes(1), Collections.singletonList(Exception.class));
        this.testerActor = sys.actorOf(new RoundRobinPool(5).withSupervisorStrategy(strategy).props(Props.create(TesterActor.class, storageActor)));
    }

    
}
