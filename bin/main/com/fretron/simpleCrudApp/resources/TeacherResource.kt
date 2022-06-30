package com.fretron.simpleCrudApp.resources

import com.fasterxml.jackson.databind.ObjectMapper
import com.fretron.simpleCrudApp.model.Teacher
import com.fretron.simpleCrudApp.services.TeacherService
import org.json.JSONObject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/teacher")
class TeacherResource {

    private  val objectMapper : ObjectMapper = ObjectMapper()
    private val teacherService : TeacherService = TeacherService()

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addTeacher(request : String) : Response{
        val teacher = teacherService.addTeacher(objectMapper.readValue(request,Teacher::class.java))
        return Response.ok(teacher.toString()).build()
    }

    @GET
    @Path("/find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun getTeacher(@QueryParam("name") name : String) : Response{
        val teacher = teacherService.getTeacher(name)
        return Response.ok(teacher.toString()).build()
    }

    @PUT
    @Path("/new/email")
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateEmail(@QueryParam("name") name : String,request: String) : Response{
        val email:String = JSONObject(request).getString("email")
        teacherService.updateEmail(name,email)
        return Response.ok("DONE").build()
    }

    @DELETE
    @Path("/delete")
    fun deleteTeacher(@QueryParam("name") name: String) : Response{
        teacherService.deleteTeacher(name)
        return Response.ok("DONE").build()
    }
}