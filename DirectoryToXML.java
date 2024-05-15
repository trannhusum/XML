package XML;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class DirectoryToXML {
    public static void main(String[] args) {
        String directoryPath = "vidu";
        File directory = new File(directoryPath);
        
        if (!directory.isDirectory()) {
            System.out.println("Đường dẫn không phải là thư mục.");
            return;
        }

        StringBuilder xmlContent = new StringBuilder();
        xmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlContent.append("<directory>\n");

        processDirectory(directory, xmlContent, "    ");

        xmlContent.append("</directory>");

        try (FileWriter writer = new FileWriter("directory_structure.xml")) {
            writer.write(xmlContent.toString());
            System.out.println("Đã xuất cấu trúc thư mục ra file directory_structure.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processDirectory(File directory, StringBuilder xmlContent, String indent) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                xmlContent.append(indent).append("<").append(file.getName()).append(">\n");
                processDirectory(file, xmlContent, indent + "    ");
                xmlContent.append(indent).append("</").append(file.getName()).append(">\n");
            } else {
                xmlContent.append(indent).append("<file>").append(file.getName()).append("</file>\n");
            }
        }
    }
}
