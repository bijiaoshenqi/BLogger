package net.bingyan.logger.level;

import android.support.annotation.Nullable;
import android.util.Log;

/**
 * error等级的logger
 *
 * @author 王博煜
 * @version 1.0
 */
public class Error extends Level {
    @Override
    public Level string(@Nullable String content) {
        if (!enable) return this;
        setDefaultTag();
        Log.e(this.tag, wrapToEmptyIfNull(content));
        return this;
    }

    @Override
    public Level string(@Nullable String tag, @Nullable String content) {
        if (!enable) return this;
        setTag(tag);
        Log.e(this.tag, wrapToEmptyIfNull(content));
        return this;
    }

    @Override
    public Level string(@Nullable String content, Object... args) {
        if (!enable) return this;
        setDefaultTag();
        Log.e(this.tag, String.format(wrapToEmptyIfNull(content), args));
        return this;
    }

    @Override
    public Level string(@Nullable String tag, @Nullable String content, Object... args) {
        if (!enable) return this;
        setTag(tag);
        Log.e(this.tag, String.format(wrapToEmptyIfNull(content), args));
        return this;
    }

    @Override
    public Level throwable(@Nullable Throwable throwable) {
        if (!enable) return this;
        setDefaultTag();
        if (throwable == null) {
            Log.e(this.tag, "");
        } else {
            Log.e(this.tag, "", throwable);
        }
        return this;
    }

    @Override
    public Level throwable(@Nullable String tag, @Nullable Throwable throwable) {
        if (!enable) return this;
        setTag(tag);
        if (throwable == null) {
            Log.e(this.tag, "");
        } else {
            Log.e(this.tag, "", throwable);
        }
        return this;
    }

}
