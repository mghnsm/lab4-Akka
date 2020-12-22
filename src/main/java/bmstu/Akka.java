package bmstu;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.routing.RouterActor;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import scala.concurrent.Future;

import static akka.http.javadsl.server.PathMatchers.segment;

import java.util.concurrent.CompletionStage;

public class Akka extends AllDirectives {
    public static final int PORT = 8080;
    public static final int TIMEOUT_MILLIS = 3000;
    private ActorRef actorRouter;

    private Akka(ActorRef actorRouter) {
        this.actorRouter = actorRouter;
    }

    private Route createRoute() {
        return concat(
                get(() ->
                        pathPrefix("getPackage", () ->
                                path(segment(), (String id) -> {
                                    Future<Object> res = Patterns.ask(actorRouter, id, TIMEOUT_MILLIS);
                                    return completeOKWithFuture(res, Jackson.marshaller());
                                }))),
                post(() ->
                        path("postPackage", () ->
                                entity(Jackson.unmarshaller(TestPackage.class), testPackage -> {
                                    actorRouter.tell(testPackage, ActorRef.noSender());
                                    return complete("Start");
                                })))

        );
    }

    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("Akka");
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        ActorRef actorRouter = system.actorOf(Props.create(RouterActor.class, system), "actorRouter");
        Akka instance = new Akka(actorRouter);

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = instance.createRoute().flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost("localhost", PORT),
                materializer
        );
        System.out.println("///////");
        System.in.read();
    }
}
