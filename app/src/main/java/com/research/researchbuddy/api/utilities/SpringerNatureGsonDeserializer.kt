package com.research.researchbuddy.api.utilities

import com.google.gson.*
import com.research.researchbuddy.models.*
import java.lang.reflect.Type

// TODO: Recover from exceptions when deserializing JSON.
//  Deserializing should continue after an exception is throw

class SpringerNatureGsonDeserializer: JsonDeserializer<SpringerNatureResponse> {

    override fun deserialize(
            json: JsonElement,
            typeOfT: Type,
            context: JsonDeserializationContext
    ): SpringerNatureResponse {

        val resultType = mutableListOf<Result>()::class.java
        val facetType = mutableListOf<Facet>()::class.java

        val apiResult: JsonObject = json.asJsonObject

        return SpringerNatureResponse(
                apiMessage = apiResult.get("apiMessage").asString,
                query = apiResult.get("query").asString,
                apiKey = apiResult.get("apiKey").asString,
                result = context.deserialize(apiResult.get("result"), resultType),
                records = deserializeRecords(context, apiResult.get("records").asJsonArray),
                facets = context.deserialize(apiResult.get("facets"), facetType)
        )
    }

    private fun deserializeRecords(
            context: JsonDeserializationContext,
            recordsJson: JsonArray,
    ): List<Record> {
        val stringListType = mutableListOf<String>()::class.java

        val recordList = mutableListOf<Record>()

        for (item in recordsJson) {
            var h1 = ""
            var p = ""
            var genre = mutableListOf<String>()
            val recordJson = item.asJsonObject
            val abstractJson = recordJson.get("abstract")
            val genreJson = recordJson.get("genre")
            if (abstractJson.isJsonObject) {
                val abstractJsonObject = abstractJson.asJsonObject
                val h1Json = abstractJsonObject.get("h1")
                val pJson = abstractJsonObject.get("p")
                h1 = when {
                    h1Json == null -> { "No headline provided." }
                    h1Json.isJsonArray -> {
                        val h1ArrayList = context.deserialize<List<String>>(h1Json, stringListType)
                        h1ArrayList.joinToString { it }
                    }
                    else -> { context.deserialize(h1Json, String::class.java) }
                }
                p = when {
                    pJson == null -> { "No abstract provided." }
                    pJson.isJsonArray -> {
                        val h1JsonArray = context.deserialize<List<String>>(pJson, stringListType)
                        h1JsonArray.joinToString { it }
                    }
                    else -> { context.deserialize(pJson, String::class.java) }
                }
            }
            if (genreJson.isJsonPrimitive) {
                genre.add(context.deserialize(genreJson, String::class.java))
            } else {
                genre = context.deserialize(genreJson, mutableListOf<String>()::class.java)
            }
            recordJson.remove("genre")
            recordJson.remove("abstract")
            val abstract = Abstract(h1, p)
            val record = context.deserialize<Record>(recordJson, Record::class.java)
            record.abstract = abstract
            record.genre = genre
            recordList.add(record)
        }

        return recordList
    }

}