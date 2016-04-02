package net.bingyan.logger.level;

import android.support.annotation.Nullable;

public abstract class Level {
    public boolean enable = true;

    /**
     * 打印普通字符串
     */
    public abstract Level string(@Nullable String content);

    /**
     * 打印格式化的字符串
     * 类似{@link String#format(String, Object...)}
     */
    public abstract Level string(@Nullable String content, Object... args);

    /**
     * 打印普通throwable
     */
    public abstract Level throwable(@Nullable Throwable throwable);

    /**
     * 打印一个bean实例
     * 会打印这个bean所有的public field,或者public get/set方法
     */
    public abstract Level bean(@Nullable Object bean);

}
