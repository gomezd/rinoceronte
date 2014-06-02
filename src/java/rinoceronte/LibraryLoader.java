package rinoceronte;

import static javax.script.ScriptContext.ENGINE_SCOPE;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class LibraryLoader {

    public static void main(String[] args) {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("nashorn");

        ScriptContext context = engine.getContext();

        FileReader in = null;
        try {
            in = new FileReader("src/js/rinoceronte/library.js");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            engine.eval(in, context);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        context.setAttribute("__dirname", "/home/foo", ENGINE_SCOPE);
        context.setAttribute("__filename", "client.js", ENGINE_SCOPE);

        try {
            in = new FileReader("src/js/rinoceronte/client.js");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            engine.eval(in, context);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }
}
