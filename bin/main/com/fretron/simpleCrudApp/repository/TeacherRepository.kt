package com.fretron.simpleCrudApp.repository

import com.fasterxml.jackson.databind.ObjectMapper
import com.fretron.simpleCrudApp.model.Teacher
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Updates
import com.mongodb.util.JSON
import org.bson.Document

class TeacherRepository {
    private val objectMapper  = ObjectMapper()
    private val collection : MongoCollection<Document> = MongoClient.database.getCollection("teacher")

    fun addTeacher(teacher: Teacher) : Teacher{
        println(teacher)
        val doc = Document.parse(teacher.toString())
        collection.insertOne(doc)
        return teacher
    }

    fun getTeacher(name : String) : Teacher{
        val cursor  = collection.find(Filters.eq("name",name)).iterator()
        val doc = cursor.next()
        doc.remove("_id")
        val serialized = JSON.serialize(doc)
        val teacher = objectMapper.readValue(serialized,Teacher::class.java)
        return teacher
    }

    fun updateEmail(name: String,email: String) : Unit{
        collection.updateOne(Filters.eq("name",name),Updates.set("email",email))
    }

    fun deleteTeacher(name : String): Unit{
        collection.deleteOne(Filters.eq("name",name))
    }
}