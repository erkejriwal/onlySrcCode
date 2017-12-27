package onlySrcCode.onlySrcCodeProject.advancedJavaLynda.data;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult postVisitDirectory(Path path, IOException arg1)
			throws IOException {
		System.out.println("just visited directory "+ path);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes arg1)
			throws IOException {
		System.out.println("just to visit directory "+ path);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path path, BasicFileAttributes attr)
			throws IOException {
		if(attr.isRegularFile()){
			System.out.print("just visited regular file ");		
		}
		System.out.println(path);		
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path arg0, IOException arg1)
			throws IOException {
		System.err.println(arg1.getMessage());		
		return FileVisitResult.CONTINUE;
	}
	
}
