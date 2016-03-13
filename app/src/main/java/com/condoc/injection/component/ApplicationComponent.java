package com.condoc.injection.component;

import com.condoc.injection.module.ApplicationModule;
import com.condoc.ui.activities.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jo on 3/13/2016.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);
}
