package training.input_output;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

public class FileUtils {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("1.txt");

        System.out.println(path); // return 1.txt
        Path absPath = path.toAbsolutePath();
        System.out.println(absPath); //return C:\Users\Instyle\IdeaProjects\OOP\1.txt

        System.out.println(path.getParent()); //return null
        System.out.println(absPath.getParent()); //return C:\Users\Instyle\IdeaProjects\OOP

        System.out.println(path.getRoot()); //return null
        System.out.println(absPath.getRoot()); //return C:\

        Path filesPath = absPath.getParent().resolve("AAA");
        if (Files.notExists(filesPath))
            Files.createDirectory(filesPath);

        Files.copy(absPath, filesPath.resolve("1.txt"), StandardCopyOption.REPLACE_EXISTING);

        Files.delete(filesPath.resolve("1.txt"));
        Files.delete(filesPath);

        BufferedReader br = new BufferedReader(new FileReader("1.txt"));
    }


    public void printNioDetails(String filePath) {

        Path path = Paths.get(filePath);
        Path path1 = FileSystems.getDefault().getPath(filePath);
        Path path2 = Paths.get(System.getProperty("user.dir"), filePath);

        FileSystem fileSystem = path.getFileSystem();

    }

    public void processDir() throws IOException {


        Files.createDirectories(Paths.get("temp/a/b/c"));

        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        for (Path rootDir : rootDirectories){
            System.out.println(rootDir);
        }

        Path dir = Paths.get("temp"); //будет создана в корневой директории нашего проекта
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(dir, path -> Files.isDirectory(path))){
            for (Path p : paths)
                System.out.println(p);
        }

    }
}
