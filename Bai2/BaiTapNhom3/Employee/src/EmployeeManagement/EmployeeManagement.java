package EmployeeManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {
    private ArrayList<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
    }

    // Thêm nhân viên
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Xóa nhân viên dựa trên ID
    public void removeEmployee(String employeeId) {
        employees.removeIf(employee -> employee.getEmployeeId().equals(employeeId));
    }

    // Sửa thông tin nhân viên dựa trên ID
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

    // Hiển thị thông tin tất cả nhân viên
    public void displayEmployees() {
        System.out.println("+----------------+----------------+---------------+");
        System.out.println("| Employee ID    | Employee Name  | Salary        |");
        System.out.println("+----------------+----------------+---------------+");
        for (Employee employee : employees) {
            System.out.printf("| %-14s | %-14s | %-13.2f |%n", employee.getEmployeeId(), employee.getEmployeeName(), employee.getSalary());
        }
        System.out.println("+----------------+----------------+---------------+");
    }

    // Lấy số lượng nhân viên
    public int getEmployeeCount() {
        return employees.size();
    }

    // Kiểm tra xem một nhân viên có trong danh sách hay không
    public boolean containsEmployee(Employee employee) {
        return employees.contains(employee);
    }

    // Lấy nhân viên theo chỉ số
    public Employee getEmployee(int index) {
        if (index >= 0 && index < employees.size()) {
            return employees.get(index);
        }
        return null;
    }

    // Chạy chương trình
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
            scanner.nextLine(); // Đọc dòng mới bỏ qua

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
                scanner.nextLine(); // Đọc dòng mới bỏ qua

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
