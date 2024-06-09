package com.hamri.java_scripting_01.scripting

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ConsoleController {
    private final static String CONSOLE = "/index.html"
    @GetMapping("/console")
    public String home(){
        return CONSOLE;
    }
}
