package com.example.student2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public List<Student> getList(){
        return studentRepository.findAll();
    }

    public Student getStudent(long id){
        Optional<Student>student=studentRepository.findById(id);
        if (student.isPresent()){return student.get();}
        else {
            return null ;

        }

    }

    public Student editStudent(long id,Student student){
        if(!studentRepository.existsById(id)){
            return null;
        }else {
            student.setId(id);
            return studentRepository.save(student);
        }
    }

    public Student editIsWorking(long id, boolean isWorking){
        Optional<Student> student=studentRepository.findById(id);
        if (!student.isPresent()) {
            return null;
        }else {
            student.get().setWorking(isWorking);
            return studentRepository.save(student.get());
        }
    }
}
