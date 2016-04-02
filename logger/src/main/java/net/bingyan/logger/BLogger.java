package net.bingyan.logger;

import android.support.annotation.NonNull;

import net.bingyan.logger.level.Debug;
import net.bingyan.logger.level.Error;
import net.bingyan.logger.level.Info;
import net.bingyan.logger.level.Level;
import net.bingyan.logger.level.Verbose;
import net.bingyan.logger.level.Warn;

/**
 * The order in terms of verbosity, from least to most is ERROR, WARN, INFO, DEBUG, VERBOSE.
 * Verbose should never be compiled into an application except during development.
 * Debug logs are compiled in but stripped at runtime.
 * Error, warning and info logs are always kept.
 */
public class BLogger {
    public static final Level e = new Error();
    public static final Level w = new Warn();
    public static final Level i = new Info();
    public static final Level d = new Debug();
    public static final Level v = new Verbose();

    public static final Setting setting = new Setting();

}
