package fpt.assignment_java6.assignment_java6.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "Hello World";
    }
}
