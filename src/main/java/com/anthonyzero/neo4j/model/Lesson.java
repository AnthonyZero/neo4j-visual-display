package com.anthonyzero.neo4j.model;

import com.anthonyzero.neo4j.config.CustomIdStrategy;
import com.anthonyzero.neo4j.core.Constant;
import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
@Builder
@NodeEntity
public class Lesson {
    /**
     * 主键，自定义主键策略，使用UUID生成
     */
    @Id
    @GeneratedValue(strategy = CustomIdStrategy.class)
    private String id;

    /**
     * 课程名称
     */
    @NonNull
    private String name;

    /**
     * 任教老师
     */
    @Relationship(Constant.R_TEACHER_OF_LESSON)
    @NonNull
    private Teacher teacher;
}

