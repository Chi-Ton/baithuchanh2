/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.student;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class StudentTest {
    
    private Student student;

    @BeforeMethod
    public void setUp() {
        // Khởi tạo đối tượng Student trước mỗi test case
        student = new Student("ST001", "Chi Ton", 20);
    }

    @AfterMethod
    public void tearDown() {
        // Dọn dẹp sau mỗi test case
        student = null;
    }

    @Test(description = "Test getName method returns correct name")
    public void testGetName() {
        String expected = "Chi Ton";
        String actual = student.getName();
        assertEquals(actual, expected, "The name should match the initialized value");
    }

    @Test(description = "Test setAge method updates age correctly")
    public void testSetAge() {
        int newAge = 25;
        student.setAge(newAge);
        assertEquals(student.getAge(), newAge, "The age should be updated to new value");
    }

    @Test(description = "Test updateName method updates name correctly")
    public void testUpdateName() {
        String newName = "Toan Smith";
        student.updateName(newName);
        assertEquals(student.getName(), newName, "The name should be updated to new value");
    }
}