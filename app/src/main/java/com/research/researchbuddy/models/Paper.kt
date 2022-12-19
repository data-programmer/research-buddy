package com.research.researchbuddy.models

data class Paper(
        val paperId: String,
        val sourceId: Int,
        val doi: String,
        val title: String,
        val publisher: String,
        val year: String,
        val authors: List<String>,
        val abstract: String,
        val urls: List<String>,
        val pdfUrl: String,
)
