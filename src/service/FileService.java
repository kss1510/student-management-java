package service;
import model.Student;
import java.io.*;
import java.util.*;
public class FileService{
    private static final String FILE = "students.txt";
    public static void save(List<Student> students){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))){
            for(Student s : students){
                writer.write(s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getGrade());
                writer.newLine();
            }
        } 
	catch(IOException e){
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    public static List<Student> load(){
        List<Student> students = new ArrayList<>();
        File file = new File(FILE);
        if(!file.exists()) return students;
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE))){
            String line;
            while((line = reader.readLine()) != null){
                String[] p = line.split(",");
                if (p.length == 4) {
                    students.add(new Student(Integer.parseInt(p[0]), p[1], Integer.parseInt(p[2]), p[3]));
                }
            }
        } 
	catch(IOException e){
            System.out.println("Error loading file: " + e.getMessage());
        }
        return students;
    }
}