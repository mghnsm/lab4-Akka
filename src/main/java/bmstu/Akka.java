package bmstu;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.routing.RouterActor;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.util.concurrent.Future;

public class Akka extends AllDirectives {
    private ActorRef actorRouter;

    private Akka(ActorRef actorRouter) {
        this.actorRouter = actorRouter;
    }

    private Route createRoute() {
        return get(() ->
                pathPrefix("getPackage", () ->
                        path() -> {
                    Future<Object> res = Patterns.ask();
                    return 
        })
                )
    }

    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("Akka");
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        //MainHttp instance = new MainHttp(system);

        ActorRef actorRouter = system.actorOf(Props.create(RouterActor.class, system), "actorRouter");
        Akka instance = new Akka(actorRouter);

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = instance.createRoute(system, actorRouter).flow(system, materializer);
    }
}
