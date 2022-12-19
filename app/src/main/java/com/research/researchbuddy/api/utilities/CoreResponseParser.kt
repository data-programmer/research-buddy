package com.research.researchbuddy.api.utilities

import com.research.researchbuddy.models.CoreResponse
import com.research.researchbuddy.models.Paper

class CoreResponseParser {

    companion object {
        fun parseResponseObject(response: CoreResponse): List<Paper> {
            val parsedData: MutableList<Paper> = mutableListOf()
            for (record in response.data) {
                // TODO: Fix the !! in the future
                parsedData.add(Paper(
                        paperId = record.id,
                        sourceId = 2,
                        doi = record.doi ?: "",
                        title = record.title,
                        publisher = record.publisher ?: "",
                        year = record.year.toString(),
                        authors = if (!record.authors.isNullOrEmpty()) record.authors.map { it } else listOf("No author provided"),
                        abstract = record.description,
                        urls = listOf(),
                        pdfUrl = ""
                ))
            }
            return parsedData
        }
    }

}