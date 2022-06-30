package com.fretron.simpleCrudApp.model

import org.json.JSONObject


class Teacher {
    var name : String? = null
    var email : String? = null
    var age : Int? = null

    override fun toString(): String {
        return JSONObject()
            .put("name",this.name)
            .put("email",this.email)
            .put("age",this.age)
            .toString()
    }

}