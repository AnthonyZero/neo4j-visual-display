package com.anthonyzero.neo4j.payload;

import com.anthonyzero.neo4j.model.Student;
import lombok.Data;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

/**
 * 师生关系
 */
@Data
@QueryResult
public class TeacherStudent {
    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 学生信息
     */
    private List<Student> students;
}
