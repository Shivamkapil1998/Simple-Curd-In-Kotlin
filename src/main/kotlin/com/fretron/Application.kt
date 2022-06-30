package com.fretron

import com.fretron.simpleCrudApp.di.AppComponent
import com.fretron.simpleCrudApp.di.ConfigModule
import com.fretron.simpleCrudApp.di.DaggerAppComponent
import org.glassfish.grizzly.http.server.HttpServer

fun main(args : Array<String>){
    val configModule = ConfigModule()
    val component : AppComponent = DaggerAppComponent.create()
    val server : HttpServer = component.server()
    server.start()
}


/**
 * val device = JSONObject()
val type = if(device.has("type")) device.getString("type") else null
if(type == "INVENTORY"){
val usedBy : String? = if(device.has("usedBy")) device.getString("usedBy") else null
println(usedBy)
val usedByArr = arrayOf("VENDOR","CUSTOMER","IN_TRANSIT")
if(usedBy in usedByArr || usedBy == null) {
when (usedBy) {
"IN_TRANSIT" -> println("inTransit")
"CUSTOMER" -> println("customer")
"VENDOR" -> println("vendor")
else -> println("available")
}
}
}else{
println("type : $type")
val usedBy : String? = if(device.has("usedBy")) device.getString("usedBy") else null
println("usedBy : $usedBy")
}
 */

