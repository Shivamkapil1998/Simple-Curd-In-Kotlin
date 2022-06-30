package com.fretron.simpleCrudApp.repository

import com.fasterxml.jackson.databind.ObjectMapper
import com.fretron.simpleCrudApp.model.Student
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Updates
import com.mongodb.util.JSON
import org.bson.Document

class StudentRepository {

    private val collection : MongoCollection<Document> = MongoClient.database.getCollection("student")
    private val objectMapper = ObjectMapper()

    fun addStudent(student: Student) : Student {
        println(student)
        val doc = Document.parse(student.toString())
        collection.insertOne(doc)
        return student
    }

    fun getStudent(name : String) : Student{
        val cursor = collection.find(Filters.eq("name",name)).iterator()
        val doc = cursor.next()
        doc.remove("_id")
        val serialize = JSON.serialize(doc)
        val student = objectMapper.readValue(serialize,Student::class.java)
        return  student
    }

    fun updateEmail(name: String,email: String) : Unit{
        collection.updateOne(Filters.eq("name",name), Updates.set("email",email))
    }

    fun deleteStudent(name : String): Unit{
        collection.deleteOne(Filters.eq("name",name))
    }
}