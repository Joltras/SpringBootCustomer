package com.example.customerapi.agent;

public class AbstractAgent {

    private transient AgentMetaInfo metaInfo;

    public AbstractAgent() {
        this.getMetaInfo();
    }

    public AgentMetaInfo getMetaInfo() {
        if (metaInfo == null) {
            var metaInfoAnnotation = getClass().getAnnotation(AgentMetaInfo.class);

            if (metaInfoAnnotation == null) {
                throw new IllegalStateException("AgentMetaInfo annotation is missing");
            }

            this.metaInfo = metaInfoAnnotation;
        }
        return metaInfo;
    }

    public String getName() {
        return getMetaInfo().name();
    }

    public String getVersion() {
        return getMetaInfo().version();
    }

    public String getAuthor() {
        return getMetaInfo().author();
    }
}
