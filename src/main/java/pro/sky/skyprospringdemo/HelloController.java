package pro.sky.skyprospringdemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping
    public String hello() {
        return "<b>hello еп</b>та";
    }

    @GetMapping(path = "/hello")
    public String answerHello(@RequestParam("name")String userName) {
        return "<b>Helloooooooy!</b>"+ userName;
    }
}
