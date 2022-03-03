package com.fretron.simpleCrudApp.repository

class MongoClient {
    companion object{
        val client = com.mongodb.MongoClient("localhost",27017)
        val database = client.getDatabase("CrudApp")
    }
}