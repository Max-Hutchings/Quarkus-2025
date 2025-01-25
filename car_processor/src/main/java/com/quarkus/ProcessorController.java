package com.quarkus;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.Duration;

@Path("/process-car")
public class ProcessorController {


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<String> processCar(@HeaderParam("Authorization") String authorizationHeader, Car car){
//        @HeaderParam("Authorization") String authorizationHeader,
//        String authorizationHeader = "ddd";
        Log.infof("Received: %s", car);

        Log.infof("Received header: %s", authorizationHeader);


        // Check if Authorization header exists and is a Bearer token
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            Log.error("Missing or invalid Authorization header");
            return Uni.createFrom().failure(new RuntimeException("Unauthorized"));
        }

        String token = authorizationHeader.substring(7); // Extract token (skip "Bearer ")

        Log.infof("Extracted Access Token: %s", token);

        try{
            Thread.sleep(1000);
        }catch(Exception exception){
            Log.error("Failed to pause thread");
        }

        return Uni.createFrom().item(String.format("Completed process of car %s", car.getName()));

    }


}
