package service;
import model.Student;
import java.util.*;
public class StudentService{
    private List<Student> students;
    public StudentService(){
        students = FileService.load();
    }
    public void addStudent(Student s){
        students.add(s);
        FileService.save(students);
    }
    public void viewStudents(){
        if(students.isEmpty()){
            System.out.println("No students found.");
        } 
	else{
            for(Student s : students){
                System.out.println(s);
            }
        }
    }
    public void updateStudent(int id, String name, int age, String grade){
        for(Student s : students){
            if(s.getId() == id){
                s.setName(name);
                s.setAge(age);
                s.setGrade(grade);
                FileService.save(students);
                return;
            }
        }
        System.out.println("Student not found.");
    }
    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
        FileService.save(students);
    }
}