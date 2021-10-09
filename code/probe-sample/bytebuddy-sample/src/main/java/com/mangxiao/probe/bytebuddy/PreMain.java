package com.mangxiao.probe.bytebuddy;

import com.mangxiao.probe.bytebuddy.core.MonitorMethod;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class PreMain {

    public static void premain(String agentArgs, Instrumentation inst) {
        AgentBuilder.Transformer transformer = (builder, typeDescription, classLoader, javaModule) -> {
            return builder.method(ElementMatchers.any()) // 拦截任意方法
                    .intercept(MethodDelegation.to(MonitorMethod.class)); // 委托
        };

        new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith("com.mangxiao.probe.web")) // 指定需要拦截的类，本例子指定的是用于测试的springboot示例项目包
                .transform(transformer)
                .installOn(inst);
    }

    public static void premain(String agentArgs) {

    }
}
