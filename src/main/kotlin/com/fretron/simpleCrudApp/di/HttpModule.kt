package com.fretron.simpleCrudApp.di

import com.fretron.simpleCrudApp.resources.StudentResource
import com.fretron.simpleCrudApp.resources.TeacherResource
import dagger.Module
import dagger.Provides
import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import java.net.URI
import javax.ws.rs.core.UriBuilder

@Module
class HttpModule {

    @Provides
    fun provideResourceConfig(
        studentRes : StudentResource,
        teacherRes : TeacherResource
    ): ResourceConfig {
        return ResourceConfig()
            .register(studentRes)
            .register(teacherRes)
    }

    @Provides
    fun provideAppServer(config : ResourceConfig) : HttpServer{
        val uri : URI = UriBuilder.fromUri("http://localhost/").port(8084).build()
        println(uri)
        return GrizzlyHttpServerFactory.createHttpServer(uri,config,false);
    }
}