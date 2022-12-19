package com.research.researchbuddy.models

import com.google.gson.annotations.SerializedName

data class CoreResponse (
        val status: String,
        val totalHits: Long,
        val data: List<Datum>
)

data class Datum (
        val id: String,
        val authors: List<String>,
        val contributors: List<String>,
        val description: String,
        val identifiers: List<String?>,
        val relations: List<String>,
        val repositories: List<Repository>,
        val repositoryDocument: RepositoryDocument,
        val subjects: List<String>,
        val title: String,
        val topics: List<String>,
        val types: List<Any?>,
        val year: Long,
        val oai: String,

        @SerializedName("downloadUrl")
        val downloadURL: String,

        val language: Language? = null,
        val publisher: String? = null,
        val fulltextIdentifier: String? = null,
        val doi: String? = null
)

data class Language (
        val code: String,
        val id: Long,
        val name: String
)

data class Repository (
        val id: String,

        @SerializedName("openDoarId")
        val openDoarID: Long,

        val name: String,
        val urlHomepage: Any? = null,
        val urlOaipmh: Any? = null,
        val uriJournals: Any? = null,
        val physicalName: PhysicalName,
        val source: Any? = null,
        val software: Any? = null,
        val metadataFormat: Any? = null,
        val description: Any? = null,
        val journal: Any? = null,

        //@Json(name = "roarId")
        val roarID: Long,

        //@Json(name = "baseId")
        val baseID: Long,

        val pdfStatus: Any? = null,
        val nrUpdates: Long,
        val disabled: Boolean,
        val lastUpdateTime: Any? = null,
        val repositoryLocation: Any? = null
)

enum class PhysicalName(val value: String) {

    Noname("noname");

    companion object {
        public fun fromValue(value: String): PhysicalName = when (value) {
            "noname" -> Noname
            else     -> throw IllegalArgumentException()
        }
    }
}

data class RepositoryDocument (
        val pdfStatus: Long,
        val metadataAdded: Long,
        val metadataUpdated: Long,
        val depositedDate: Long
)
