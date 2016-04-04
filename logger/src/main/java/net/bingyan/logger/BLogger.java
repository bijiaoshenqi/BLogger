package net.bingyan.logger;

import android.support.annotation.Nullable;

import net.bingyan.logger.level.Debug;
import net.bingyan.logger.level.Error;
import net.bingyan.logger.level.Info;
import net.bingyan.logger.level.Level;
import net.bingyan.logger.level.Verbose;
import net.bingyan.logger.level.Warn;

public class BLogger {
    public static final Level e = new Error();
    public static final Level w = new Warn();
    public static final Level i = new Info();
    public static final Level d = new Debug();
    public static final Level v = new Verbose();

    private static final Setting setting = new Setting();

    /**
     * @return 整个logger的设置
     */
    public static Setting getSetting() {
        return setting;
    }

    public static void e(@Nullable String content) {
        e.string(content);
    }

    public static void w(@Nullable String content) {
        w.string(content);
    }

    public static void i(@Nullable String content) {
        i.string(content);
    }

    public static void d(@Nullable String content) {
        d.string(content);
    }

    public static void v(@Nullable String content) {
        v.string(content);
    }
}
