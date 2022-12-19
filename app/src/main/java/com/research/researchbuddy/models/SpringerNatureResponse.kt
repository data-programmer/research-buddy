package com.research.researchbuddy.models

import com.google.gson.annotations.SerializedName

data class SpringerNatureResponse (
        val apiMessage: String,
        val query: String,
        val apiKey: String,
        val result: List<Result>,
        val records: List<Record>,
        val facets: List<Facet>
)

data class Facet (
        val name: String,
        val values: List<Value>
)

data class Value (
        val value: String,
        val count: String
)

data class Record (
    val contentType: String,
    val identifier: String,
    val url: List<URL>,
    val title: String,
    val creators: List<Creator>,
    val publicationName: String,
    val doi: String,
    val publisher: String,
    val publicationDate: String,
    val publicationType: String,
    val issn: String,
    val eIssn: String,
    val volume: String,
    val number: String,
    val issueType: String,
    val topicalCollection: String,
    var genre: List<String>,
    val startingPage: String,
    val endingPage: String,

    @SerializedName("journalId")
    val journalID: String,

    val openAccess: String,
    val onlineDate: String,
    val copyright: String,
    var abstract: Abstract
)

data class Abstract (
        val h1: String,
        val p: String
)

data class Creator (
        val creator: String
)

data class URL (
        val format: String,
        val platform: String,
        val value: String
)

data class Result (
        val total: String,
        val start: String,
        val pageLength: String,
        val recordsDisplayed: String
)
