package com.anthonyzero.neo4j.model;

import lombok.Data;

@Data
public class GraphNode {
    private String source;
    private String type;
    private String rela;
    private String target;

    public GraphNode(String source, String rela, String target) {
        this.source = source;
        this.rela = rela;
        this.target = target;
        this.type = "resolved";
    }
}
