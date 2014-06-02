package rinoceronte;

import static javax.script.ScriptContext.ENGINE_SCOPE;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Esprima {
    
    static String readFile(String fileName) throws IOException,FileNotFoundException {
        return new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
    }    

    public static void main(String[] args) throws ScriptException, IOException, NoSuchMethodException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("nashorn");

        ScriptContext context = engine.getContext();

        engine.eval(readFile("src/js/rinoceronte/esprima.js"), context);

        context.setAttribute("__dirname", "/home/foo", ENGINE_SCOPE);
        context.setAttribute("__filename", "client.js", ENGINE_SCOPE);
        
        Invocable inv = (Invocable) engine;
        Object esprima = engine.get("esprima");
        
        Object tree = inv.invokeMethod(esprima, "parse", readFile("src/js/rinoceronte/client.js"));
        
        Object JSON = engine.get("JSON");

        String json = (String) inv.invokeMethod(JSON, "stringify", tree, null, 2);
        System.out.println(json);
    }
}
