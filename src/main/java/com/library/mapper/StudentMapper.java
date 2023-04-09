package com.library.mapper;

import com.library.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("SELECT * FROM students")
    List<Student> selectAll();

}
