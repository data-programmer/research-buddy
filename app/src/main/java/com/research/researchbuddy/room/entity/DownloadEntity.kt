package com.research.researchbuddy.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Downloads")
data class DownloadEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "paperId") val paperId: String,
    @ColumnInfo(name = "sourceId") val sourceId: Int,
    @ColumnInfo(name = "title") val title: String
)