package training.input_output;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MyReader {

    public void readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String string;
            while ((string = reader.readLine()) != null)
                System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> readObjects(String filepath) {

        List<Student> students = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(filepath)))) {
            while (true) {
                Student student = (Student) in.readObject();
                students.add(student);
            }
        } catch (EOFException e) {
            System.out.println("File was processed");
        } catch (IOException e) {
            System.out.println("Unable to open file " + filepath + ". Program terminates.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid object type");
            e.printStackTrace();
        }
        return students;
    }

    public void readFileSimple(String fileName) throws IOException {

        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);
    }

    public void nioReadFileWithBuffer(String fileName) {
        Path path = Paths.get(fileName);
        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String s;
            while ((s = reader.readLine()) != null)
                System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nioReadWithStream(String fileName) {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(path)))) {
            String s;
            while ((s = reader.readLine()) != null)
                System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nioReadWithChannel(String fileName)  {
        try {
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(100);
            int bytesNumber = channel.read(buffer);
            while (bytesNumber > 0){
                buffer.flip();
                while (buffer.hasRemaining()){
                    System.out.print((char)buffer.get());
                }
                buffer.clear();
                bytesNumber = channel.read(buffer);
            }
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
