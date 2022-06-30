package com.fretron.simpleCrudApp.di

import com.fretron.MONGODB_HOST
import com.fretron.MONGODB_PORT
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ConfigModule {

    @Provides
    @Named(MONGODB_HOST)
    fun provideAppHost(): String {
        return MONGODB_HOST
    }

    @Provides
    @Named(MONGODB_PORT)
    fun provideAppPort() : Int{
        return MONGODB_PORT.toInt()
    }
}