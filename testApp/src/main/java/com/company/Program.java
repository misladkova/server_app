package com.company;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

import java.util.Random;

public class Program extends AbstractVerticle {

    private int ID = new Random().nextInt(1000000);

    @Override
    public void start() {
        System.out.println("start");

        String hostname = System.getenv("HOSTNAME");

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route(HttpMethod.GET, "/").handler(ctx -> {

            // This handler will be called for every get request
            HttpServerResponse response = ctx.response();
            response.putHeader("content-type", "text/plain");

            // Write to the response and end it
            System.out.println(response.getStatusCode());
            response.end("Hello from web server "+ID+" with hostname "+hostname);
        });

        server.requestHandler(router).listen(8088);

    }
}