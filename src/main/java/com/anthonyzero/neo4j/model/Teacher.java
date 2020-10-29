package com.anthonyzero.neo4j.model;

import com.anthonyzero.neo4j.config.CustomIdStrategy;
import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
@Builder
@NodeEntity
public class Teacher {
    /**
     * 主键，自定义主键策略，使用UUID生成
     */
    @Id
    @GeneratedValue(strategy = CustomIdStrategy.class)
    private String id;

    /**
     * 教师姓名
     */
    @NonNull
    private String name;
}
