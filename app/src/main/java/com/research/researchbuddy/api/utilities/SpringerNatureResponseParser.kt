package com.research.researchbuddy.api.utilities

import com.research.researchbuddy.models.Paper
import com.research.researchbuddy.models.SpringerNatureResponse

class SpringerNatureResponseParser {

    companion object {
        fun parseResponseObject(response: SpringerNatureResponse): List<Paper> {
            val parsedData: MutableList<Paper> = mutableListOf()
            for (record in response.records) {
                parsedData.add(Paper(
                    paperId = record.identifier,
                    sourceId = 1,
                    doi = record.doi,
                    title = record.title,
                    publisher = record.publisher,
                    year = record.publicationDate,
                    authors = record.creators.map { it.creator },
                    abstract = record.abstract.p,
                    urls = record.url.map { it.value },
                    pdfUrl = ""
                ))
            }
            return parsedData
        }
    }

}