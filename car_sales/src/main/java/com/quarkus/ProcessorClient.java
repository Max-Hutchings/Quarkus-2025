package com.quarkus;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "car-processor")
@ClientHeaderParam(name = "Authorization", value = "{getAccessToken}")
public interface ProcessorClient {

    default String getAccessToken() {
        String token = "Bearer " + ConfigProvider.getConfig().getValue("car-processor.access-token", String.class);
        Log.info(token);
        return token;
    }

    @POST
    @Path("/process-car")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Uni<String> processPurchase(Car car);


}