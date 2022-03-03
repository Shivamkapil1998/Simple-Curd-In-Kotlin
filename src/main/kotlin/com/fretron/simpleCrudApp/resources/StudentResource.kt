package com.fretron.simpleCrudApp.resources

import com.fasterxml.jackson.databind.ObjectMapper
import com.fretron.simpleCrudApp.model.Student
import com.fretron.simpleCrudApp.services.StudentService
import org.json.JSONObject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/student")
class StudentResource {

    private val objectMapper = ObjectMapper()
    private val studentService : StudentService = StudentService()

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addStudent(request : String) : Response{
        println("Request: $request")
        val student = studentService.addUser(objectMapper.readValue(request,Student::class.java))
        return Response.ok(student.toString()).build()
    }

    @GET
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getStudent(@QueryParam("name") name : String) : Response{
        val student =  studentService.getStudent(name)
        return Response.ok(student.toString()).build()
    }

    @PUT
    @Path("/new/email")
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateEmail(@QueryParam("name") name : String,request: String) : Response{
        val email:String = JSONObject(request).getString("email")
        studentService.updateEmail(name,email)
        return Response.ok("DONE").build()
    }

    @DELETE
    @Path("/delete")
    fun deleteTeacher(@QueryParam("name") name: String) : Response{
        studentService.deleteStudent(name)
        return Response.ok("DONE").build()
    }
}