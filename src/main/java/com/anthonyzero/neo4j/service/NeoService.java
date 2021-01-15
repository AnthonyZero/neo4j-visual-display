package com.anthonyzero.neo4j.service;

import com.anthonyzero.neo4j.payload.RealPayload;
import com.anthonyzero.neo4j.repository.NeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeoService {

    @Autowired
    private NeoRepository neoRepository;

    /**
     * 获取所有节点-[关系]-节点
     * @return
     */
    public List<RealPayload> findAllNodeRealNode() {
        return neoRepository.findAllNodeRealNode();
    }

}
