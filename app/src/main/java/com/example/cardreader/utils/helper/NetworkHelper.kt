package com.example.cardreader.utils.helper

import org.json.JSONObject
import retrofit2.Response



open class NetworkHelper<T>(var data: T? = null, var message: String? = null) {

    class Success<T>(data: T, message: String? = null) : NetworkHelper<T>(data, message)
    class Message<T>(message: String?, data: T? = null) : NetworkHelper<T>(data, message)
    class Loading<T> : NetworkHelper<T>()
}


class BaseClient {


    fun <T> handleResponse(response: Response<T>): NetworkHelper<T> {

        println("HELLOBODYURL: ${response.raw().request().url()}")
        println("HELLOBODYURL: ${response.raw().request().body()}")



        when {
            response.isSuccessful -> {
                println("HELLOBODY: ${response.body()}")
                println("HELLOBODYURL: ${response.raw().request().url()}")
                var body = response.body()!!
                return NetworkHelper.Success(body)
            }

            response.code() == 404 || response.code() == 400 || response.code() == 401 || response.code() == 403 || response.code() == 500 || response.code() == 503 || response.code() == 422 -> {
                println("HELLOBODY: ${response.body()}")
                println("HELLOBODYURL: ${response.raw().request().url()}")

                var message = response.errorBody()?.string()

                if (message != null) {
                    decodeMessage(message)
                }
                    return NetworkHelper.Message(decodeMessage(message!!))

//                println("DSA: ${realmessage}")
//                println("HELLOMESSAGE: ${message}")

            }

            else -> {
                return NetworkHelper.Message("Error Fetching Response")
            }
        }
    }

}

fun decodeMessage(statusresponse: String): String{
    val keyValuePairs = statusresponse
        .replace("{", "")
        .replace("}", "")
        .split(",")

    val keyValueMap = keyValuePairs.associate {
        val (key, value) = it.split(":").map { it.trim('"', ' ') }
        key to value
    }


    val specificKey = keyValueMap.keys.find { it == "responseMessage" || it == "message" }
    if (specificKey != null) {
        val value = keyValueMap.getValue(specificKey)
        println("Message Key: $specificKey, Value: $value")

        return  value
    } else {
       return  "Error Fetching Response"
    }
}

















