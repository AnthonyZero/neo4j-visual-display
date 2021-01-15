package com.anthonyzero.neo4j.repository;

import com.anthonyzero.neo4j.payload.RealPayload;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface NeoRepository extends Neo4jRepository<String, String> {


    /**
     * 获取所有节点-[关系]-节点
     * @return
     */
    @Query("match(s)-[real]->(n) return s.name as leftNodeName,type(real) as realName,n.name as rightNodeName")
    List<RealPayload> findAllNodeRealNode();
}
