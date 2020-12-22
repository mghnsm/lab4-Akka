package bmstu;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.SupervisorStrategy;
import akka.actor.dsl.Creators;

public class RouterActor implements AbstractActor {
    private ActorRef storageActor;
    private SupervisorStrategy strategy;
    private ActorRef testerActor;

}
