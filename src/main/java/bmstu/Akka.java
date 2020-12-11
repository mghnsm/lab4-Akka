package bmstu;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.routing.RouterActor;
import akka.stream.ActorMaterializer;

public class Akka {
    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("Akka");
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        //MainHttp instance = new MainHttp(system);

        ActorRef actorRouter = system.actorOf(Props.create(RouterActor.class, system), "actorRouter");
        Akka instance = new Akka(actorRouter);

        
    }
}
