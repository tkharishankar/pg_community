
package com.pg_community_android.di.component;

import com.pg_community_android.di.PerService;
import com.pg_community_android.di.module.ServiceModule;
import com.pg_community_android.service.SyncService;

import dagger.Component;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}
