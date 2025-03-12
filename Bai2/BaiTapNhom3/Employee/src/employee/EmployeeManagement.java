/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {
    private ArrayList<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
    }

    // Them nhan vien
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Xoa nhan vien dua tren ID
    public void removeEmployee(String employeeId) {
        employees.removeIf(employee -> employee.getEmployeeId().equals(employeeId));
    }

    // Sua thong tin nhan vien dua tren ID
    public void updateEmployee(String employeeId, String fieldToUpdate, String newValue, double newSalary) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                switch (fieldToUpdate) {
                    case "id":
                        employee.setEmployeeId(newValue);
                        break;
                    case "name":
                        employee.setEmployeeName(newValue);
                        break;
                    case "salary":
                        employee.setSalary(newSalary);
                        break;
                    default:
                        System.out.println("Lua chon khong hop le.");
                }
            }
        }
    }

    // Hien thi thong tin tat ca nhan vien
    public void displayEmployees() {
        System.out.println("+----------------+----------------+---------------+");
        System.out.println("| Employee ID    | Employee Name  | Salary        |");
        System.out.println("+----------------+----------------+---------------+");
        for (Employee employee : employees) {
            System.out.printf("| %-14s | %-14s | %-13.2f |%n", employee.getEmployeeId(), employee.getEmployeeName(), employee.getSalary());
        }
        System.out.println("+----------------+----------------+---------------+");
    }

    // Chay chuong trinh
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Sua thong tin nhan vien");
            System.out.println("4. Hien thi thong tin nhan vien");
            System.out.println("5. Thoat");
            System.out.print("Chon mot lua chon: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Doc dong moi bo qua

            if (choice == 1) {
                System.out.print("Nhap ID: ");
                String id = scanner.nextLine();
                System.out.print("Nhap ten: ");
                String name = scanner.nextLine();
                System.out.print("Nhap luong: ");
                double salary = scanner.nextDouble();
                management.addEmployee(new Employee(id, name, salary));
            } else if (choice == 2) {
                System.out.print("Nhap ID cua nhan vien can xoa: ");
                String removeId = scanner.nextLine();
                management.removeEmployee(removeId);
            } else if (choice == 3) {
                System.out.print("Nhap ID cua nhan vien can sua: ");
                String updateId = scanner.nextLine();
                System.out.println("1. Sua ID");
                System.out.println("2. Sua ten");
                System.out.println("3. Sua luong");
                System.out.print("Chon mot lua chon de sua: ");
                int updateChoice = scanner.nextInt();
                scanner.nextLine(); // Doc dong moi bo qua

                switch (updateChoice) {
                    case 1:
                        System.out.print("Nhap ID moi: ");
                        String newId = scanner.nextLine();
                        management.updateEmployee(updateId, "id", newId, 0);
                        break;
                    case 2:
                        System.out.print("Nhap ten moi: ");
                        String newName = scanner.nextLine();
                        management.updateEmployee(updateId, "name", newName, 0);
                        break;
                    case 3:
                        System.out.print("Nhap luong moi: ");
                        double newSalary = scanner.nextDouble();
                        management.updateEmployee(updateId, "salary", "", newSalary);
                        break;
                    default:
                        System.out.println("Lua chon khong hop le.");
                }
            } else if (choice == 4) {
                management.displayEmployees();
            } else if (choice == 5) {
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Lua chon khong hop le.");
            }
        }
    }
}
