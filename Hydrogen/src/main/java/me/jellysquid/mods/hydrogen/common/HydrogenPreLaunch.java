package me.jellysquid.mods.hydrogen.common;

import me.jellysquid.mods.hydrogen.common.jvm.ClassConstructors;
//import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class HydrogenPreLaunch {

    public void onLaunch() {
        ClassConstructors.init();
    }
}