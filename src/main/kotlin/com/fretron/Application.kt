package com.fretron

import com.fretron.simpleCrudApp.resources.StudentResource
import com.fretron.simpleCrudApp.resources.TeacherResource
import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import javax.ws.rs.core.UriBuilder

fun main(args : Array<String>){
    val uri   = UriBuilder.fromUri("http://localhost/").port(8084).build()
    val config: ResourceConfig = ResourceConfig(StudentResource::class.java,TeacherResource::class.java)
    val server : HttpServer = GrizzlyHttpServerFactory.createHttpServer(uri,config)
}