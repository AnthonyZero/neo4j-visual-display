package com.anthonyzero.neo4j.payload;

import lombok.Data;
import org.springframework.data.neo4j.annotation.QueryResult;

@Data
@QueryResult
public class RealPayload {

    /**
     * 开始节点 名称
     */
    private String leftNodeName;

    /**
     * 关系名称
     */
    private String realName;

    /**
     * 结束节点 名称
     */
    private String rightNodeName;
}
