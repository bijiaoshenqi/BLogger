package net.bingyan.logger.level;

import android.support.annotation.Nullable;

/**
 * 所有log等级的基础类
 *
 * @author 王博煜
 * @version 1.0
 */
public abstract class Level {
    public boolean enable = true;

    protected String tag;  // 打印log时的tag

    /**
     * 设置后续使用的tag
     *
     * @param tag 后续打印用的tag,如果为null,则代表着使用类名作为tag
     */
    public Level setTag(@Nullable String tag) {
        this.tag = tag;
        if (this.tag == null) setDefaultTag();
        return this;
    }

    /**
     * 设置后续使用的tag为默认tag ---- 调用方法所在的类的{@link Class#getSimpleName()}
     */
    public Level setDefaultTag() {
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        if (stackTraceElements == null) {
            this.tag = "unknown";
            return this;
        }

        StackTraceElement trace = null;
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            if (stackTraceElement.getClassName().startsWith("net.bingyan.logger")) continue;
            trace = stackTraceElement;
            break;
        }
        if (trace == null) {
            this.tag = "unknown";
            return this;
        }

        String name = trace.getClassName();
        int start = name.lastIndexOf('.');
        if (start == -1) {
            this.tag = name;
        } else {
            this.tag = name.substring(start);
        }

        return this;
    }

    /**
     * 如果string为null,则返回 ""
     * 否则返回原先的string
     */
    protected String wrapToEmptyIfNull(@Nullable String string) {
        return string == null ? "" : string;
    }

    /** 打印content */
    public abstract Level string(@Nullable String content);

    /** 指定tag打印content */
    public abstract Level string(@Nullable String tag, @Nullable String content);

    /** 打印formatted content */
    public abstract Level string(@Nullable String content, Object... args);

    /** 指定tag打印formatted content */
    public abstract Level string(@Nullable String tag, @Nullable String content, Object... args);

    /** 打印普通throwable */
    public abstract Level throwable(@Nullable Throwable throwable);

    /** 指定tag打印throwable */
    public abstract Level throwable(@Nullable String tag, @Nullable Throwable throwable);

    // TODO
//    /**
//     * 打印一个bean实例
//     * 会打印这个bean所有的public field,或者public get/set方法
//     */
//    public abstract Level bean(@Nullable Object bean);


}
