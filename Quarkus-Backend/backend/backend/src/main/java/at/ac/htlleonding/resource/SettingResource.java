package at.ac.htlleonding.resource;

import at.ac.htlleonding.model.Setting;
import at.ac.htlleonding.model.dto.SettingDTO;
import at.ac.htlleonding.repository.SettingRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/andromeda/setting")
public class SettingResource {

    @Inject
    SettingRepository settingRepository;

    @POST
    @Path("/addSettingToUser")
    @Consumes(MediaType.APPLICATION_JSON)
    //wobei das ID feld leer zu sein hat
    public Response addSetting(SettingDTO settingDTO) {
        try {
        Setting setting = settingRepository.addSetting(settingDTO);
            return Response.status(Response.Status.OK)
                    .entity(setting)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/removeSettingOfUser/{userId}/{settingName}")
    public Response removeSetting(@PathParam("userId") Long userId, @PathParam("settingName") String settingName) {
        try {
            settingRepository.deleteSetting(userId, settingName);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/updateSettingOfUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSetting(SettingDTO settingDTO) {
        try {
            //muss die komplette Setting Daten enthalten und wird quasi einfach überschrieben.
            settingRepository.updateSetting(settingDTO);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.OK).build();

    }

    @GET
    @Path("/getSettingsByUser/{userId}")
    public Response getSettingsByUser(@PathParam("userId") Long userId) {
        try {
            List<SettingDTO> settings = settingRepository.getSettingsByUser(userId);
            return Response.status(Response.Status.OK).entity(settings).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/getSettingByUser/{userId}/{settingName}")
    public Response getSettingByUser(@PathParam("userId") Long userId, @PathParam("settingName") String settingName) {
        try {
            SettingDTO settingDTO = settingRepository.getSettingByUser(userId, settingName);
            return Response.status(Response.Status.OK).entity(settingDTO).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
