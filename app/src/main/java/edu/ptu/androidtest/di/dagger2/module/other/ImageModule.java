package edu.ptu.androidtest.di.dagger2.module.other;

import dagger.Module;
import dagger.Provides;

@Module
public class ImageModule {
    public static class ImageUtils {

    }
    @Provides
    public ImageUtils provideImageLoader(){
        return new ImageUtils();
    }
}
