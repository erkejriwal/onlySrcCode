package javatpoint.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornExample {

	public static void main(String[] args) throws FileNotFoundException, ScriptException {
		// TODO Auto-generated method stub
		ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");
		ee.eval(new FileReader("js/hello.js"));
		 ee.eval("print('Hello Nashorn from direct java file code');");  
		 System.out.println(1 << 13);
	}

}
