package com.fretron.simpleCrudApp.di

//import com.mongodb.MongoClient
import com.fretron.MONGODB_HOST
import com.fretron.MONGODB_PORT
import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    @Named("first")
    fun provideMongoClient(
        @Named(MONGODB_HOST) host: String,
        @Named(MONGODB_PORT) port: Int
    ): MongoClient {
        return MongoClient(host, port)
    }

    @Provides
    fun provideDatabase(@Named("first") mongoClient: MongoClient): MongoDatabase {
        return mongoClient.getDatabase("CrudApp")
    }

}