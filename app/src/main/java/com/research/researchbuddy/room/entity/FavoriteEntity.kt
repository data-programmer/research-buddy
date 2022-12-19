package com.research.researchbuddy.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favorites")
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "paperId") val paperId: String,
    @ColumnInfo(name = "sourceId") val sourceId: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "publisher" ) val publisher: String,
    @ColumnInfo(name = "year") val year: String,
    //@ColumnInfo(name = "authors") val authors: List<String>,
    @ColumnInfo(name = "description") val description: String,
    //@ColumnInfo(name = "urls") val urls: List<String>,
    @ColumnInfo(name = "pdfUrl") val pdfUrl: String,
    @ColumnInfo(name = "language") val language: String
)
