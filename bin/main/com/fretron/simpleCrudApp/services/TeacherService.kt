package com.fretron.simpleCrudApp.services

import com.fretron.simpleCrudApp.model.Teacher
import com.fretron.simpleCrudApp.repository.TeacherRepository

class TeacherService {
    private val teacherRepository : TeacherRepository = TeacherRepository()

    fun addTeacher(teacher: Teacher) : Teacher{
        if(teacher.name == null || teacher.email == null){
            throw  NullPointerException("Teacher's name or email is null")
        }
        return  teacherRepository.addTeacher(teacher)
    }

    fun getTeacher(name: String) : Teacher{
        if(name == null ) throw Error("cannot find teacher with name null")
        return teacherRepository.getTeacher(name)
    }

    fun updateEmail(name : String,email : String) : Unit{
        teacherRepository.updateEmail(name,email)
    }

    fun deleteTeacher(name : String) : Unit{
        teacherRepository.deleteTeacher(name)
    }

}