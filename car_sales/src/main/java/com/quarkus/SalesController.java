package com.quarkus;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDate;
import java.util.List;

@Path("/purchase")
public class SalesController {

    @RestClient
    ProcessorClient processorClient;

    @Inject
    CarService carService;


    @POST
    public Uni<String> purchaseCar(){
        Car volvo = new Car("Volvo", "c70", LocalDate.of(2007, 2, 17));

        Uni<String> result = processorClient.processPurchase(volvo)
                .onFailure().invoke(e -> Log.errorf("Error processing purchase. Exception: %s", e));

        return result;

    }

    @POST
    @Path("/multi")
    public Uni<List<String>> purchaseMultipleCars(){
        List<Car> cars = carService.getCars();

        return Multi.createFrom().items(cars.stream())
                .onItem().transformToUniAndMerge(processorClient::processPurchase)
                .collect().asList()
                .onFailure().invoke(e -> Log.errorf("Error processing multiple cars. Exception: %s", e));
    }
}
