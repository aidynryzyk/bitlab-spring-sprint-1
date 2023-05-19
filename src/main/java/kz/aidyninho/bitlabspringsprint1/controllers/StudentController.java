package kz.aidyninho.bitlabspringsprint1.controllers;

import kz.aidyninho.bitlabspringsprint1.domain.Student;
import kz.aidyninho.bitlabspringsprint1.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    private final StudentRepository studentRepository = StudentRepository.getInstance();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentRepository.getStudents());
        return "index";
    }

    @GetMapping("/add")
    public String addGet(Model model) {
        return "add";
    }

    @PostMapping("/add")
    public String addPost(Model model, @RequestParam String name, @RequestParam String surname, @RequestParam int grade) {
        Student student = new Student(name, surname, grade);
        studentRepository.addStudent(student);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam String search) {
        model.addAttribute("students", studentRepository.getStudentsByWord(search));
        return "index";
    }

}
