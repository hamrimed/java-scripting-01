package com.hamri.java_scripting_01.scripting;

import org.apache.logging.log4j.util.Strings;

public class ScriptResult {
    private String result;
    private String output;
    private String satckTrace;

    public static ScriptResult success(String result, String output) {
        ScriptResult scriptResult = new ScriptResult();
        scriptResult.setResult(result);
        scriptResult.setOutput(output);
        return scriptResult;
    }

    public static ScriptResult error(String satckTrace) {
        ScriptResult scriptResult = new ScriptResult();
        scriptResult.setSatckTrace(satckTrace);
        return scriptResult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        if (result == null) {
            this.result = "";
        }
        else {
            this.result = result;
        }
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        if (output == null) {
            this.output = "";
        }
        else {
            this.output = output;
        }
    }

    public String getSatckTrace() {
        return satckTrace;
    }

    public void setSatckTrace(String satckTrace) {
        this.satckTrace = satckTrace;
    }
}
