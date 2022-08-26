package com.example.customerapi.agent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AgentMetaInfo {

    String name();

    String version();

    String author();

}
