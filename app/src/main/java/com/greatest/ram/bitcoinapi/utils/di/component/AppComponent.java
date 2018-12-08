package com.greatest.ram.bitcoinapi.utils.di.component;

import android.app.Application;
import com.greatest.ram.bitcoinapi.utils.App;
import com.greatest.ram.bitcoinapi.utils.di.modules.ActivityModule;
import com.greatest.ram.bitcoinapi.utils.di.modules.AppModules;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

import javax.inject.Singleton;

@Singleton
@Component(modules={AndroidSupportInjectionModule.class, ActivityModule.class, AppModules.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(App app);
}
