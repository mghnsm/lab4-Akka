package bmstu;

import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.stream.ActorMaterializer;

public class Akka {
    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("Akka");
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        MainHttp instance = new MainHttp(system);
    }
}
