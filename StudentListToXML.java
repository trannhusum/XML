package XML;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentListToXML {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyen Van A", 20, 3.5));
        students.add(new Student("Le Thi B", 22, 3.8));
        students.add(new Student("Tran Van C", 21, 3.2));

        StringBuilder xmlContent = new StringBuilder();
        xmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlContent.append("<students>\n");

        for (Student student : students) {
            xmlContent.append("    <student>\n");
            xmlContent.append("        <name>").append(student.getName()).append("</name>\n");
            xmlContent.append("        <age>").append(student.getAge()).append("</age>\n");
            xmlContent.append("        <gpa>").append(student.getGpa()).append("</gpa>\n");
            xmlContent.append("    </student>\n");
        }

        xmlContent.append("</students>");

        try (FileWriter writer = new FileWriter("students.xml")) {
            writer.write(xmlContent.toString());
            System.out.println("Đã xuất danh sách sinh viên ra file students.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
