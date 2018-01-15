
package com.pg_community_android.di.component;

import android.app.Application;
import android.content.Context;

import com.pg_community_android.PgApplication;
import com.pg_community_android.data.DataManager;
import com.pg_community_android.di.ApplicationContext;
import com.pg_community_android.di.module.ApplicationModule;
import com.pg_community_android.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(PgApplication app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}