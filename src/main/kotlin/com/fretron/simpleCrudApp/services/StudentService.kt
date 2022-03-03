package com.fretron.simpleCrudApp.services

import com.fretron.simpleCrudApp.model.Student
import com.fretron.simpleCrudApp.repository.StudentRepository
class StudentService {
    private  val studentRepository = StudentRepository()
    fun addUser(student: Student): Student {
        if(student.name== null || student.email ==null){
            throw NullPointerException("Student's name or email is null")
         }
         return studentRepository.addStudent(student)
    }

    fun getStudent(name : String) : Student {
        if(name == null) throw  Error("cannot find student with name = null")
        return studentRepository.getStudent(name)
    }

    fun updateEmail(name : String,email : String) : Unit{
        studentRepository.updateEmail(name,email)
    }

    fun deleteStudent(name : String) : Unit{
        studentRepository.deleteStudent(name)
    }
}