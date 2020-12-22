package bmstu;

import akka.actor.ActorRef;
import akka.actor.SupervisorStrategy;
import akka.actor.dsl.Creators;

public class RouterActor {
    private ActorRef storageActor;
    private SupervisorStrategy strategy;
    private ActorRef testerActor;


}
