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
    fun provideMongoClient(
        @Named(MONGODB_HOST) host : String
    ) : MongoClient {
        return MongoClient(host, MONGODB_PORT)
    }

    @Provides
    fun provideDatabase
                (mongoClient: MongoClient

    ) : MongoDatabase{
        return mongoClient.getDatabase("CrudApp")
    }

}