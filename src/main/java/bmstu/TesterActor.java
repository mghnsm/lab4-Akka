package bmstu;

import akka.actor.ActorRef;

public class TesterActor {
    private ActorRef storageActor;

    TesterActor(ActorRef storageActor) {
        this.storageActor = storageActor;
    }
}
