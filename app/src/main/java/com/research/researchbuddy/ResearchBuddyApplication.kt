package com.research.researchbuddy

import android.app.Application
import com.research.researchbuddy.room.ResearchBuddyDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ResearchBuddyApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ResearchBuddyApplication))

        bind() from singleton { ResearchBuddyDatabase.getInstance(applicationContext) }
        bind() from singleton { instance<ResearchBuddyDatabase>().favoriteDao() }
        bind() from singleton { instance<ResearchBuddyDatabase>().downloadDao() }
        //bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptor(instance()) }
        //bind() from singleton { SpringerNatureApiService(instance()) }
        // bind() from singleton { CoreApiService(instance()) }
        //bind<SpringerNatureDataSource>() with singleton { SpringerNatureDataSource(instance()) }
        // Maybe add repository? Only if used...
        //bind() from provider { SearchViewModelFactory(instance()) }
    }

}