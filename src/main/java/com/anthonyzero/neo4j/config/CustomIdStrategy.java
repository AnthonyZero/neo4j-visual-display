package com.anthonyzero.neo4j.config;

import cn.hutool.core.util.IdUtil;
import org.neo4j.ogm.id.IdStrategy;

/**
 * 自定义主键策略
 */
public class CustomIdStrategy implements IdStrategy {
    @Override
    public Object generateId(Object o) {
        return IdUtil.fastUUID();
    }
}
