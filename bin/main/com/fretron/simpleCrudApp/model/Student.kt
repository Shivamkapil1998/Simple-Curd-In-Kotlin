package com.fretron.simpleCrudApp.model

import org.json.JSONObject


class Student() {
    var rollNo : String? = null
    var name : String? = null
    var age : Int? = null
    var email : String? = null


    override fun toString(): String {
        return JSONObject()
            .put("rollNo",this.rollNo)
            .put("name",this.name)
            .put("age",this.age)
            .put("email",this.email)
            .toString()
    }
}