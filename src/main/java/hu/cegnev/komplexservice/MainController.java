package hu.cegnev.komplexservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @ResponseBody
    @GetMapping(path = "/")
    public String getMessage(@RequestParam int age) {
        return String.format("hello %s", age * 2);
    }
}