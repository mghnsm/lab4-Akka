package bmstu;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.routing.RouterActor;
import akka.stream.ActorMaterializer;

public class Akka extends AllDirectives {
    private ActorRef actorRouter;

    private Akka(ActorRef actorRouter) {
        this.actorRouter = actorRouter;
    }

    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("Akka");
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        //MainHttp instance = new MainHttp(system);

        ActorRef actorRouter = system.actorOf(Props.create(RouterActor.class, system), "actorRouter");
        Akka instance = new Akka(actorRouter);

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = instance.
    }
}
