package com.example.student2;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentCrontroller {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public ResponseEntity create(@RequestBody Student student){
        try {
            student = studentService.createStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        }catch (Exception e){
            System.out.println("error");
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        }
    }
    @GetMapping
    public ResponseEntity getList(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getList());
    }
    @GetMapping("/{id}")
    public ResponseEntity getStudent(@PathVariable long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudent(id));
        }catch (Exception e) {
            System.out.println("null");
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable long id,@RequestParam boolean isWorking){
      //  student.setId(id);
        //studentService.editIsWorking(id, isWorking);
       return ResponseEntity.status(HttpStatus.OK).body(studentService.editIsWorking(id, isWorking));
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity editStudent(@PathVariable long id, @RequestBody Student student){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.editStudent(id, student));

    }
}
