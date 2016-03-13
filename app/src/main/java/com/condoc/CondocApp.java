package com.condoc;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.condoc.injection.component.ApplicationComponent;
import com.condoc.injection.component.DaggerApplicationComponent;
import com.condoc.injection.module.ApplicationModule;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.orm.SugarApp;
import com.squareup.picasso.Picasso;

import net.danlew.android.joda.JodaTimeAndroid;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Jo on 3/13/2016.
 */
public class CondocApp extends SugarApp {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        generalInit();
        dependencyInjectionInit();
        fontsInit();
        imageLoadingInit();
    }

    /*
   * Creates the dagger component that will be
   * injected throughout the app for dependencies.
   * */
    private void dependencyInjectionInit() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    private void generalInit() {
        //Date library that needs initializing for timezone changes etc.
        JodaTimeAndroid.init(this);

    }



    private void imageLoadingInit()
    {
        DrawerImageLoader.init(new AbstractDrawerImageLoader() {
            @Override
            public void set(ImageView imageView, Uri uri, Drawable placeholder) {
                Picasso.with(imageView.getContext()).load(uri).placeholder(placeholder).into(imageView);
            }

            @Override
            public void cancel(ImageView imageView) {
                Picasso.with(imageView.getContext()).cancelRequest(imageView);
            }


            @Override
            public Drawable placeholder(Context ctx, String tag) {
                //define different placeholders for different imageView targets
                //default tags are accessible via the DrawerImageLoader.Tags
                //custom ones can be checked via string. see the CustomUrlBasePrimaryDrawerItem LINE 111
                if (DrawerImageLoader.Tags.PROFILE.name().equals(tag)) {
                    return DrawerUIUtils.getPlaceHolder(ctx);
                } else if (DrawerImageLoader.Tags.ACCOUNT_HEADER.name().equals(tag)) {
                    return new IconicsDrawable(ctx).iconText(" ").backgroundColorRes(com.mikepenz.materialdrawer.R.color.primary).sizeDp(56);
                } else if ("customUrlItem".equals(tag)) {
                    return new IconicsDrawable(ctx).iconText(" ").backgroundColorRes(R.color.md_red_500).sizeDp(56);
                }

                //we use the default one for
                //DrawerImageLoader.Tags.PROFILE_DRAWER_ITEM.name()

                return super.placeholder(ctx, tag);
            }
        });


    }

    /*
   * Calligraphy is used to apply a font to the entire app
   * also as a means of adding custom fonts to views.
   *
   * Iconics allow the usage of font icons instead of using drawables.
   * */
    private void fontsInit() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("Roboto-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );

        Iconics.registerFont(new CommunityMaterial());
    }


    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    public static CondocApp get(Context context) {
        return (CondocApp) context.getApplicationContext();
    }






}
