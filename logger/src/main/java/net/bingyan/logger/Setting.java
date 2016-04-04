package net.bingyan.logger;

import android.support.annotation.NonNull;

/**
 * 整个Logger的设置
 * <p>
 * constructor package access
 * 由{@link BLogger#getSetting()}获得实例
 *
 * @author 王博煜
 * @version 1.0
 */
public class Setting {

    /**
     * The order in terms of verbosity, from least to most is ERROR, WARN, INFO, DEBUG, VERBOSE.
     * Verbose should never be compiled into an application except during development.
     * Debug logs are compiled in but stripped at runtime.
     * Error, warning and info logs are always kept.
     */
    public enum WhichLevel {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR,
    }

    /* package */ Setting() { }

    /**
     * 开启某个等级的logger
     *
     * @param which 指定要开启的level
     * @return chained mode
     */
    public Setting enable(@NonNull WhichLevel which) {
        switch (which) {
            case ERROR: { BLogger.e.enable = true; break; }
            case WARN: { BLogger.w.enable = true; break; }
            case INFO: { BLogger.i.enable = true; break; }
            case DEBUG: { BLogger.d.enable = true; break; }
            case VERBOSE: { BLogger.v.enable = true; break; }
        }
        return this;
    }

    /**
     * 关闭某个等级的logger
     *
     * @param which 指定要关闭的level
     * @return chained mode
     */
    public Setting disable(@NonNull WhichLevel which) {
        switch (which) {
            case ERROR: { BLogger.e.enable = false; break; }
            case WARN: { BLogger.w.enable = false; break; }
            case INFO: { BLogger.i.enable = false; break; }
            case DEBUG: { BLogger.d.enable = false; break; }
            case VERBOSE: { BLogger.v.enable = false; break; }
        }
        return this;
    }

    /**
     * 启用比which等级低的level
     *
     * @param which   启用level的参考标准
     * @param include 是否启用which当前等级,如果为false,则忽略;true代表当前which等级enable
     * @param only    是否只启用比which等级低的level,如果为false则忽略upper level;true代表将upper level设为false
     */
    public Setting enableLower(@NonNull WhichLevel which, boolean include, boolean only) {
        for (WhichLevel level : WhichLevel.values()) {
            if (level.ordinal() < which.ordinal()) {
                enable(level);
            } else if (level.ordinal() == which.ordinal()) {
                if (include) {
                    enable(level);
                }
            } else {
                if (only) {
                    disable(level);
                }
            }
        }
        return this;
    }

    /**
     * 启用比which等级高的level
     *
     * @param which   启用level的参考标准
     * @param include 是否启用which当前等级,如果为false,则忽略;true代表当前which等级enable
     * @param only    是否只启用比which等级高的level,如果为false则忽略upper level;true代表将lower level设为false
     */
    public Setting enableUpper(@NonNull WhichLevel which, boolean include, boolean only) {
        for (WhichLevel level : WhichLevel.values()) {
            if (level.ordinal() > which.ordinal()) {
                enable(level);
            } else if (level.ordinal() == which.ordinal()) {
                if (include) {
                    enable(level);
                } else {
                    if (only) {
                        disable(level);
                    }
                }
            }
        }
        return this;
    }

    /**
     * 禁用比which等级低的level
     *
     * @param which   禁用level的参考标准
     * @param include 是否禁用which当前等级,如果为false,则忽略;true代表当前which等级disable
     * @param only    是否只禁用比which等级低的level,如果为false则忽略upper level;true代表将upper level enable
     */
    public Setting disableLower(@NonNull WhichLevel which, boolean include, boolean only) {
        for (WhichLevel level : WhichLevel.values()) {
            if (level.ordinal() < which.ordinal()) {
                disable(level);
            } else if (level.ordinal() == which.ordinal()) {
                if (include) {
                    disable(level);
                }
            } else {
                if (only) {
                    enable(level);
                }
            }
        }
        return this;
    }


    /**
     * 禁用比which等级高的level
     *
     * @param which   禁用level的参考标准
     * @param include 是否禁用which当前等级,如果为false,则忽略;true代表当前which等级disable
     * @param only    是否只禁用比which等级高的level,如果为false则忽略lower level;true代表将lower level enable
     */
    public Setting disableUpper(@NonNull WhichLevel which, boolean include, boolean only) {
        for (WhichLevel level : WhichLevel.values()) {
            if (level.ordinal() > which.ordinal()) {
                disable(level);
            } else if (level.ordinal() == which.ordinal()) {
                if (include) {
                    disable(level);
                }
            } else {
                if (only) {
                    enable(level);
                }
            }
        }
        return this;
    }

}
