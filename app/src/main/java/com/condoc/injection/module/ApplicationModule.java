package com.condoc.injection.module;

import android.app.Application;

import com.condoc.core.PreferencesManager;
import com.easyliteorm.EasyLite;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jo on 3/13/2016.
 */
@Module
public class ApplicationModule {
    final Application app;

    public ApplicationModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    PreferencesManager providePreferenceManager() {
        return new PreferencesManager(app);
    }

    @Provides
    @Singleton
    EasyLite provideEasyLite()
    {
        return EasyLite.getInstance();
    }
}
