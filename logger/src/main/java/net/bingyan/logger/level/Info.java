package net.bingyan.logger.level;

import android.support.annotation.Nullable;

/**
 * Created by bijia on 2016/4/1.
 */
public class Info implements Level {
    @Override
    public Level string(@Nullable String content) {
        return null;
    }
    @Override
    public Level string(@Nullable String content, Object... args) {
        return null;
    }
    @Override
    public Level throwable(@Nullable Throwable throwable) {
        return null;
    }
    @Override
    public Level bean(@Nullable Object bean) {
        return null;
    }
}
