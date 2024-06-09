package com.hamri.java_scripting_01.scripting

import com.hamri.java_scripting_01.app.entities.Item
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.script.ScriptEngineManager

@Configuration
public class Config {

    @Bean("scriptEngineManager")
    public ScriptEngineManager scriptEngineManager() {
        ScriptEngineManager manager = new ScriptEngineManager();
        return manager;
    }

    @Bean("item01")
    public Item i01(){
        new Item(77, "item bean");
    }


}
