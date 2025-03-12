package EmployeeManagement;

import static org.junit.Assert.*; // Import các phương thức assert từ JUnit
import org.junit.Before; // Import annotation @Before từ JUnit
import org.junit.Test; // Import annotation @Test từ JUnit

public class EmployeeManagementTest {

    private EmployeeManagement management;

    @Before
    public void setUp() {
        management = new EmployeeManagement();
    }

    @Test
    public void testAddEmployee() {
        // Tạo một đối tượng Employee và thêm vào danh sách quản lý
        Employee employee = new Employee("E001", "Nguyen Van A", 5000.0);
        management.addEmployee(employee);
        
        // Kiểm tra xem nhân viên đã được thêm vào hay chưa
        assertEquals(1, management.getEmployeeCount());
        assertTrue(management.containsEmployee(employee));
    }

    @Test
    public void testRemoveEmployee() {
        // Tạo một đối tượng Employee và thêm vào danh sách quản lý
        Employee employee = new Employee("E002", "Tran Thi B", 6000.0);
        management.addEmployee(employee);
        
        // Xóa nhân viên ra khỏi danh sách quản lý
        management.removeEmployee("E002");
        
        // Kiểm tra xem nhân viên đã được xóa hay chưa
        assertEquals(0, management.getEmployeeCount());
        assertFalse(management.containsEmployee(employee));
    }

    @Test
    public void testUpdateEmployee() {
        // Tạo một đối tượng Employee và thêm vào danh sách quản lý
        Employee employee = new Employee("E003", "Le Van C", 7000.0);
        management.addEmployee(employee);

        // Cập nhật ID của nhân viên
        management.updateEmployee("E003", "id", "E004", 0);
        assertEquals("E004", management.getEmployee(0).getEmployeeId());

        // Cập nhật tên của nhân viên
        management.updateEmployee("E004", "name", "Pham Thi D", 0);
        assertEquals("Pham Thi D", management.getEmployee(0).getEmployeeName());

        // Cập nhật lương của nhân viên
        management.updateEmployee("E004", "salary", "", 8000.0);
        assertEquals(8000.0, management.getEmployee(0).getSalary(), 0.001);
    }

    @Test
    public void testDisplayEmployees() {
        // Thêm hai nhân viên vào danh sách quản lý
        management.addEmployee(new Employee("E001", "Nguyen Van A", 5000.0));
        management.addEmployee(new Employee("E002", "Tran Thi B", 6000.0));

        // Kiểm tra xem danh sách có đúng số lượng nhân viên hay không
        assertEquals(2, management.getEmployeeCount());
        assertTrue(management.containsEmployee(new Employee("E001", "Nguyen Van A", 5000.0)));
        assertTrue(management.containsEmployee(new Employee("E002", "Tran Thi B", 6000.0)));
    }

    @Test
    public void testAddDuplicateEmployee() {
        // Thêm hai nhân viên có cùng ID vào danh sách quản lý
        Employee employee1 = new Employee("E001", "Nguyen Van A", 5000.0);
        Employee employee2 = new Employee("E001", "Tran Thi B", 6000.0); // ID trùng

        management.addEmployee(employee1);
        management.addEmployee(employee2);

        // Kiểm tra xem danh sách có đúng số lượng nhân viên hay không
        assertEquals(2, management.getEmployeeCount());
        assertTrue(management.containsEmployee(employee1));
        assertTrue(management.containsEmployee(employee2));
    }

    @Test
    public void testRemoveNonExistentEmployee() {
        // Xóa nhân viên không tồn tại trong danh sách quản lý
        management.removeEmployee("E999"); // ID không tồn tại

        // Kiểm tra xem danh sách có đúng số lượng nhân viên hay không
        assertEquals(0, management.getEmployeeCount());
    }

    @Test
    public void testUpdateNonExistentEmployee() {
        // Cập nhật thông tin nhân viên không tồn tại trong danh sách quản lý
        management.updateEmployee("E999", "name", "New Name", 0); // ID không tồn tại

        // Kiểm tra xem danh sách có đúng số lượng nhân viên hay không
        assertEquals(0, management.getEmployeeCount());
    }

    @Test
    public void testDisplayEmptyEmployees() {
        // Kiểm tra danh sách khi chưa thêm nhân viên nào
        assertEquals(0, management.getEmployeeCount());
    }
}
