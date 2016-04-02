package net.bingyan.logger;

import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;

public class Setting {

    public enum WhichLevel {
        ERROR,
        WARN,
        INFO,
        DEBUG,
        VERBOSE,
    }

    /* package */ Setting() { }

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
     * @param include 是否启用which当前等级,如果为false,则不动;true代表upper level设为true
     * @param only    是否只启用比which等级低的level,如果为false则不动upper level;true代表将upper level设为false
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
     * @param include 是否启用which当前等级,如果为false,则不动;true代表lower level设为
     * @param only    是否只启用比which等级低的level,如果为false则不动lower level;true代表将lower level设为false
     */
    public Setting enableUpper(@NonNull WhichLevel which, boolean include, boolean only) {
        for (WhichLevel level : WhichLevel.values()) {
            if (level.ordinal() > which.ordinal()) {
                enable(which);
            } else if (level.ordinal() == which.ordinal()) {
                if (include) {
                    enable(which);
                } else {

                }
            }

        }
    }
}
