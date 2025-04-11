package com.crud.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.crud.entity.Student;
import com.crud.crud.repository.StudentRepository;

@Controller
@RequestMapping("/students")
public class StudentController {
   @Autowired
    private StudentRepository studentRepo;

    @GetMapping
    public String listStudents(Model model){
        model.addAttribute("students",studentRepo.findAll());
        return "student-list";
    }

    @GetMapping("/new")
    public String showNewsStudentForm(Model model){
        model.addAttribute("student",new Student());
        return "student-form";
    }
    @PostMapping
    public String saveStudent(@ModelAttribute("student")Student student){
        studentRepo.save(student);
        return "redirect:/students";
        
    }

    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable long id, Model model){
        Student student=studentRepo.findById(id).orElseThrow(()->new IllegalArgumentException("inalid student id"));
        model.addAttribute("student",student);
        return "student-form";
        
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        studentRepo.deleteById(id);
        return "redirect:/students";
    }
}
