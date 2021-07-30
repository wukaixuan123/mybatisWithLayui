package com.hdax.mapper;

import com.hdax.pojo.Student;
import com.hdax.until.pageConfig;

import java.util.HashMap;
import java.util.List;

public interface studentMapper {
    List<Student> queryAllLimit(HashMap map);
    int queryCount();
    int delStudentWithId(int id);
    Student  queryWithId(int id);
    int updateStudent(Student student);
}
