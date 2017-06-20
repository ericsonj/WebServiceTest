package net.juan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import wsclientlibtest.model.MessageRequest;
import wsclientlibtest.model.MessageResponse;

/**
 *
 * @author ejoseph
 */
@Path("/myservice")
public class MyService {

    @GET
    @Path("/getObjectByGet")
    @Produces({MediaType.APPLICATION_JSON})
    public MessageResponse getObjectByGet() {
        return new MessageResponse(200, "OK");
    }

    @POST
    @Path("/getObjectByPost")
    @Produces({MediaType.APPLICATION_JSON})
    public MessageResponse getObjectByPost() {
        return new MessageResponse(200, "OK");
    }

    @GET
    @Path("/getListByGet")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageResponse> getListByGet() {
        List<MessageResponse> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MessageResponse(i, "message " + i));
        }
        return list;
    }

    @POST
    @Path("/getListByPost")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageResponse> getListByPost() {
        List<MessageResponse> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MessageResponse(i, "message " + i));
        }
        return list;
    }

    @POST
    @Path("/getObjectByQuery")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public MessageResponse getObjectByQuery(MessageRequest register) {
        return new MessageResponse(200, register.getMessage());
    }
 
    @POST
    @Path("/sendList")
    @Consumes({MediaType.APPLICATION_JSON})
    public MessageResponse sendList(List<MessageRequest> list) {
        for (MessageRequest message : list) {
            System.out.println("> " + message);
        }
        return new MessageResponse(200, "OK");
    }

}
