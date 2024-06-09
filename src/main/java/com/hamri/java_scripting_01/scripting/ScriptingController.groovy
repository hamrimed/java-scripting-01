package com.hamri.java_scripting_01.scripting

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/scripting")
class ScriptingController {
    @Autowired
    private ScriptingService scriptingService;
    @PostMapping("/script")
    public ResponseEntity<ScriptResult> execute(@RequestBody String script) {
        ScriptResult result = scriptingService.execute(script);
        if (result.getSatckTrace() != null) {
            return ResponseEntity.internalServerError().body(result);
        }
        else {
            return ResponseEntity.ok(result);
        }
    }
}
