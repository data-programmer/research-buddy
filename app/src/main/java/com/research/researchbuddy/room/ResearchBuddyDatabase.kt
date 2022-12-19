package com.research.researchbuddy.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.research.researchbuddy.room.dao.DownloadDao
import com.research.researchbuddy.room.dao.FavoriteDao
import com.research.researchbuddy.room.entity.DownloadEntity
import com.research.researchbuddy.room.entity.FavoriteEntity

@Database(entities = [FavoriteEntity::class, DownloadEntity::class], version = 2)
abstract class ResearchBuddyDatabase: RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
    abstract fun downloadDao(): DownloadDao

    companion object {
        @Volatile private var INSTANCE: ResearchBuddyDatabase? = null
        fun getInstance(context: Context): ResearchBuddyDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            ResearchBuddyDatabase::class.java,
                            "research-buddy.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }

}