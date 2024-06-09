package com.hamri.java_scripting_01.scripting

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

@Service
class DefaultScriptingService implements ScriptingService {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ScriptEngineManager manager;
    private ScriptEngine scriptEngine;
    private Writer writer;
    private final static String APPLICATION_CONTEXT_NAME = "spring";

    public DefaultScriptingService() {
    }

    @PostConstruct
    private void init() {
        manager.getEngineFactories().forEach { f -> System.out.println(f.getEngineName())}
        manager.getEngineFactories().stream()
                .findFirst()
                .ifPresent {factory ->
                    scriptEngine = factory.getScriptEngine();
                    scriptEngine.put(APPLICATION_CONTEXT_NAME, applicationContext);
                    writer = new StringWriter();
                    scriptEngine.getContext().setWriter(writer);
                }

    }

    public ScriptResult execute(String script) {
        if (scriptEngine != null) {
            try {
                Object result = scriptEngine.eval(script);
                String output = writer.toString();
                writer = new StringWriter();
                return ScriptResult.success(result.toString(), output);

            }
            catch (Exception e) {
                return ScriptResult.error(e.getMessage());
            }
        }
        return null;
    }


}
