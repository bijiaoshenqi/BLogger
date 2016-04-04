package net.bingyan.logger.level;

import android.support.annotation.Nullable;
import android.util.Log;

/**
 * verbose等级的logger
 *
 * @author 王博煜
 * @version 1.0
 */
public class Verbose extends Level {

    @Override
    public Level string(@Nullable String content) {
        setDefaultTag();
        Log.v(this.tag, wrapToEmptyIfNull(content));
        return this;
    }

    @Override
    public Level string(@Nullable String tag, @Nullable String content) {
        setTag(tag);
        Log.v(this.tag, wrapToEmptyIfNull(content));
        return this;
    }

    @Override
    public Level string(@Nullable String content, Object... args) {
        setDefaultTag();
        Log.v(this.tag, String.format(wrapToEmptyIfNull(content), args));
        return this;
    }

    @Override
    public Level string(@Nullable String tag, @Nullable String content, Object... args) {
        setTag(tag);
        Log.v(this.tag, String.format(wrapToEmptyIfNull(content), args));
        return this;
    }

    @Override
    public Level throwable(@Nullable Throwable throwable) {
        setDefaultTag();
        if (throwable == null) {
            Log.v(this.tag, "");
        } else {
            Log.v(this.tag, "", throwable);
        }
        return this;
    }

    @Override
    public Level throwable(@Nullable String tag, @Nullable Throwable throwable) {
        setTag(tag);
        if (throwable == null) {
            Log.v(this.tag, "");
        } else {
            Log.v(this.tag, "", throwable);
        }
        return this;
    }
}
