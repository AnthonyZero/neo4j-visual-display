package com.anthonyzero.neo4j.model;

import com.anthonyzero.neo4j.config.CustomIdStrategy;
import com.anthonyzero.neo4j.core.Constant;
import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
@Builder
@NodeEntity
public class Student {
    /**
     * 主键，自定义主键策略，使用UUID生成
     */
    @Id
    @GeneratedValue(strategy = CustomIdStrategy.class)
    private String id;

    /**
     * 学生姓名
     */
    @NonNull
    private String name;

    /**
     * 学生选的所有课程
     */
    @Relationship(Constant.R_LESSON_OF_STUDENT)
    @NonNull
    private List<Lesson> lessons;

    /**
     * 学生所在班级
     */
    @Relationship(Constant.R_STUDENT_OF_CLASS)
    @NonNull
    private Class clazz;

}