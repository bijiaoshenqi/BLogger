package net.bingyan.logger.level;

import android.support.annotation.Nullable;
import android.util.Log;

/**
 * info等级的logger
 *
 * @author 王博煜
 * @version 1.0
 */
public class Info extends Level {

    @Override
    public Level string(@Nullable String content) {
        if (!enable) return this;
        setDefaultTag();
        Log.i(this.tag, wrapToEmptyIfNull(content));
        return this;
    }

    @Override
    public Level string(@Nullable String tag, @Nullable String content) {
        if (!enable) return this;
        setTag(tag);
        Log.i(this.tag, wrapToEmptyIfNull(content));
        return this;
    }

    @Override
    public Level string(@Nullable String content, Object... args) {
        if (!enable) return this;
        setDefaultTag();
        Log.i(this.tag, String.format(wrapToEmptyIfNull(content), args));
        return this;
    }

    @Override
    public Level string(@Nullable String tag, @Nullable String content, Object... args) {
        if (!enable) return this;
        setTag(tag);
        Log.i(this.tag, String.format(wrapToEmptyIfNull(content), args));
        return this;
    }

    @Override
    public Level throwable(@Nullable Throwable throwable) {
        if (!enable) return this;
        setDefaultTag();
        if (throwable == null) {
            Log.i(this.tag, "");
        } else {
            Log.i(this.tag, "", throwable);
        }
        return this;
    }

    @Override
    public Level throwable(@Nullable String tag, @Nullable Throwable throwable) {
        if (!enable) return this;
        setTag(tag);
        if (throwable == null) {
            Log.i(this.tag, "");
        } else {
            Log.i(this.tag, "", throwable);
        }
        return this;
    }
}
