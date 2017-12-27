package onlySrcCode.onlySrcCodeProject.advancedJavaLynda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.jws.Oneway;
import javax.print.attribute.standard.MediaSize.Other;

import onlySrcCode.onlySrcCodeProject.advancedJavaLynda.data.MyFileFinder;
import onlySrcCode.onlySrcCodeProject.advancedJavaLynda.data.MyFileVisitor;
import onlySrcCode.onlySrcCodeProject.advancedJavaLynda.data.OliveJar;
import onlySrcCode.onlySrcCodeProject.advancedJavaLynda.multithreading.MultiThreading;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		String key = "one";
		switch(key){
		case "one":
			System.out.println(key);
			break;
		default:
			System.out.println("key not found");
		}
		
		int value = 2_00_000;
		NumberFormat format = NumberFormat.getInstance();
		System.out.println(format.format(value));
		
		Random random = new Random();
		System.out.println(random.nextInt(3));
		
		System.out.println(OliveJar.oliveList.size());
		
		OliveJar oliveJar = new OliveJar();
		oliveJar.print();
		oliveJar.print();
		
		Class<?> o = oliveJar.getClass();
		System.out.println(o.getName());
		System.out.println(o.getSimpleName());
		System.out.println(o.getTypeName());
		System.out.println(o.getName());
		
		Constructor<?>[] constructors = o.getConstructors();
		System.out.println(constructors.length);
		
		Constructor<?> con = constructors[0];
		try {
			con.newInstance();
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	assert false;
		System.out.println("assert-1");
		
		Path path1 = Paths.get("files/file1.txt");
		Path path2 = Paths.get("files/file2.txt");
		Path path3 = Paths.get("files/file3.txt");
		Path newDir = Paths.get("files/newDirectory");
		
		System.out.println(path1.getFileName());
		try {
			Files.createDirectories(newDir);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	//	Files.move(path1, newDir.resolve(path1.getFileName()), StandardCopyOption.REPLACE_EXISTING);
	//	Files.deleteIfExists(path2);
	//	Files.createFile(path2);
		Charset charset = Charset.forName("US-ASCII");
		try(
				BufferedReader bufferedReader = Files.newBufferedReader(path3,charset);
				BufferedWriter bufferedWriter = Files.newBufferedWriter(path2, charset);
			)
			{
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				bufferedWriter.append(line,0,line.length());
				bufferedWriter.newLine();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		Path fileMainDir = Paths.get("files");
		MyFileVisitor myFileVisitor = new MyFileVisitor();
		try {
			Files.walkFileTree(fileMainDir, myFileVisitor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyFileFinder myFileFinder = new MyFileFinder("file*.txt");
		try {
			Files.walkFileTree(fileMainDir, myFileFinder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Path> foundFiles = myFileFinder.foundPaths;
		if(foundFiles.size() > 0){
			System.out.print("found files are:- ");
			for (Path path : foundFiles) {
				try {
					System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			System.out.println("no file found");
		}
		
		//code for watch service
		
		/*try(
				WatchService service = FileSystems.getDefault().newWatchService();	
			) {
			
			Map<WatchKey, Path> keyMap = new HashMap<>();
			keyMap.put(fileMainDir.register(service, 
					StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY), fileMainDir);
			WatchKey watchKey;
			do {
				watchKey = service.take();
				Path eventDir = keyMap.get(watchKey);
				
				for (WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					Path eventPath = (Path)event.context();
					System.out.println(eventDir+" : "+kind+" : "+eventPath);
				}
				
			} while (watchKey.reset());
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		try(
				FileInputStream in = new FileInputStream("files/qa.jpg");
				FileOutputStream out = new FileOutputStream("files/qa3.jpg");
			) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//use file reader and writer just for files which has characters / alphabets 
		try(
				FileReader in = new FileReader("files/file2.txt");
				FileWriter out = new FileWriter("files/file2viareaderwriter.txt");
			) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//use file buffered reader and buffered writer just for files which has characters / alphabets 
		try(
				BufferedReader in = new BufferedReader(new FileReader("files/file2.txt"));
				BufferedWriter out = new BufferedWriter(new FileWriter("files/file3viareaderwriter.txt"));
			) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//use scanner to scane a file to seprate words with different delimiters (characters like ,)
		try(
				Scanner scanner = new Scanner(new BufferedReader(new FileReader("files/filecomma.txt")));
		//		BufferedWriter out = new BufferedWriter(new FileWriter("files/file3viareaderwriter.txt"));
			) {
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
			
			scanner.nextInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MultiThreading threading = new MultiThreading();
		threading.multiThreadingExample();
	}

}
