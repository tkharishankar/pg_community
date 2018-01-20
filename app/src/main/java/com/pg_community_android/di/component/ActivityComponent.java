
package com.pg_community_android.di.component;


import com.pg_community_android.di.PerActivity;
import com.pg_community_android.di.module.ActivityModule;
import com.pg_community_android.functionalities.jobs.JobsActivity;
import com.pg_community_android.functionalities.login.LoginActivity;
import com.pg_community_android.functionalities.matrimony.MatrimonyActivity;
import com.pg_community_android.functionalities.profile.ProfileActivity;
import com.pg_community_android.functionalities.register.RegisterActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);

    void inject(RegisterActivity activity);

    void inject(ProfileActivity activity);

    void inject(JobsActivity activity);

    void inject(MatrimonyActivity activity);

}
