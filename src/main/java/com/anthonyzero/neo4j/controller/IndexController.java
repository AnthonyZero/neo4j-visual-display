package com.anthonyzero.neo4j.controller;

import com.anthonyzero.neo4j.model.GraphNode;
import com.anthonyzero.neo4j.payload.RealPayload;
import com.anthonyzero.neo4j.service.NeoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class IndexController {

    @Autowired
    private NeoService neoService;

    @GetMapping("/graph")
    public List<GraphNode> getGraphData(String keyword) {
        List<RealPayload> payloads = new ArrayList<>();
        if(StringUtils.isBlank(keyword)) {
            payloads = neoService.findAllNodeRealNode();
        } else {
            payloads = queryGraphNodeKw(keyword);
        }
        List<GraphNode> nodes = convertGraphNode(payloads);
        return nodes;
    }

    private List<GraphNode> convertGraphNode(List<RealPayload> payloads) {
        List<GraphNode> nodes = new ArrayList<>();
        for(RealPayload payload : payloads) {
            GraphNode node = new GraphNode(payload.getLeftNodeName(), payload.getRealName(),
                    payload.getRightNodeName());
            nodes.add(node);
        }
        return nodes;
    }


    private List<RealPayload> queryGraphNodeKw(String keyword) {
        List<RealPayload> payloads = neoService.findAllNodeRealNode();
        List<RealPayload> nodes = new ArrayList<>();
        for(RealPayload payload : payloads) {
            if(payload.getLeftNodeName().equals(keyword)
                || payload.getRightNodeName().equals(keyword)) {
                nodes.add(payload);
            }
        }
        return nodes;
    }
}
