package bt_file;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;
public class Main {
		 public static void main(String[] args) {
			 
			  String inputFilePath = "E:/javahk2/bt_file/src/inputt";
		        String outputFilePath = "E:/javahk2/bt_file/src/outputt"; // Move this line here

		        Scanner scanner = new Scanner(System.in);

		        // Nhập số lượng học viên từ bàn phím
		        System.out.print("Nhập số lượng học viên: ");
		        int n = scanner.nextInt();
		        scanner.nextLine(); // Đọc ký tự Enter

		        ArrayList<Student> students = new ArrayList<>();

		        // Nhập thông tin học viên từ bàn phím
		        for (int i = 0; i < n; i++) {
		            System.out.println("Nhập thông tin học viên thứ " + (i + 1) + ":");
		            System.out.print("Mã sinh viên: ");
		            String studentID = scanner.nextLine();
		            System.out.print("Họ tên: ");
		            String fullName = scanner.nextLine();
		            System.out.print("Giới tính: ");
		            String gender = scanner.nextLine();
		            System.out.print("Điểm Python: ");
		            double pythonScore = scanner.nextDouble();
		            System.out.print("Điểm Java: ");
		            double javaScore = scanner.nextDouble();
		            scanner.nextLine(); // Đọc ký tự Enter

		            // Tạo đối tượng Student và thêm vào danh sách
		            Student student = new Student(studentID, fullName, gender, pythonScore, javaScore);
		            students.add(student);
		        }

		        // Sắp xếp học viên theo điểm trung bình giảm dần
		        Collections.sort(students, Comparator.comparingDouble((Student s) -> s.avgScore).reversed());

		        // Ghi thông tin học viên vào tệp tin output
		        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
		            writer.println("Danh sách học viên:");
		            writer.printf("%-10s %-20s %-10s %-10s %-10s %-10s %-10s\n", "Mã SV", "Họ và tên", "Giới tính", "Python", "Java", "Điểm TB", "Kết quả");
		            for (Student student : students) {
		                writer.println(student);
		            }
		            System.out.println("Đã ghi danh sách học viên vào file " + outputFilePath);
		        } catch (IOException e) {
		            System.err.println("Lỗi khi ghi vào file: " + e.getMessage());
		        }

		        // Hiển thị thông tin những bạn đã đậu
		        System.out.println("\nThông tin những bạn đã đậu:");
		        System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s %-10s\n", "Mã SV", "Họ và tên", "Giới tính", "Python", "Java", "Điểm TB", "Kết quả");
		        for (Student student : students) {
		            if (student.result.equals("Đậu")) {
		                System.out.println(student);
		            }
		        }

		        // Hiển thị thông tin những bạn đã trượt
		        System.out.println("\nThông tin những bạn đã trượt:");
		        System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s %-10s\n", "Mã SV", "Họ và tên", "Giới tính", "Python", "Java", "Điểm TB", "Kết quả");
		        for (Student student : students) {
		            if (student.result.equals("Trượt")) {
		                System.out.println(student);
		            }
		        }

		        // Tìm kiếm học viên theo họ tên
		        System.out.print("\nNhập họ tên học viên cần tìm: ");
		        String searchName = scanner.nextLine();
		        boolean found = false;
		        System.out.println("Kết quả tìm kiếm:");
		        for (Student student : students) {
		            if (student.fullName.equalsIgnoreCase(searchName)) {
		                System.out.println(student);
		                found = true;
		            }
		        }
		        if (!found) {
		            System.out.println("Không tìm thấy học viên có họ tên '" + searchName + "'");
		        }
		    }
		}