package com.mangxiao.probe.asm;

import com.mangxiao.probe.asm.core.ProfilingTransformer;

import java.lang.instrument.Instrumentation;

public class PreMain {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new ProfilingTransformer());
    }

    public static void premain(String agentArgs) {

    }
}
