package com.mangxiao.probe.asm;

import com.mangxiao.probe.asm.core.ProfilingTransformer;

import java.lang.instrument.Instrumentation;

public class PreMain {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("探针开始=========================");
        inst.addTransformer(new ProfilingTransformer());
        System.out.println("探针结束=========================");
    }

    public static void premain(String agentArgs) {

    }
}
