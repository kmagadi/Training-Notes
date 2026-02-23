import java.io.IOException;
import java.nio.file.*;

public class FileOperationsDemo 
{
    public static void main( String[] args ) 
    {

        Path path = Paths.get("samxzple.txt");

        try 
        {
            if (Files.notExists(path)) {
                Files.createFile(path);
                System.out.println("File created successfully.");
            } else {
                throw new FileAlreadyExistingException(); // Add this
            }   

            writeToFile( path );

            readFromFile( path );

            appendToFile( path );

            readFromFile( path );

        } 
        catch (FileAlreadyExistingException e) {
            System.out.println(e.getMessage());
        }   
        catch ( Exception e ) 
        {
            System.out.println("Unexpected error occurred.");
            e.printStackTrace();
        }
    }

    public static class FileAlreadyExistingException extends Exception {
        public FileAlreadyExistingException() {
            super("File already exists!!!");
        }
    }   

    // Write method
    public static void writeToFile(Path path) throws IOException 
    {
        String content = "Hello! This is the first write.\n";
        Files.write(path, content.getBytes());
        System.out.println("Initial write completed.");
    }

    // Append method
    public static void appendToFile(Path path) throws IOException 
    {
        String content = "This is appended content.\n";
        Files.write(path, content.getBytes(), StandardOpenOption.APPEND);
        System.out.println("Append completed.");
    }

    // Read method
    public static void readFromFile(Path path) throws IOException 
    {
        System.out.println("\nReading file:");
        String data = Files.readString(path);
        System.out.println(data);
    }
}