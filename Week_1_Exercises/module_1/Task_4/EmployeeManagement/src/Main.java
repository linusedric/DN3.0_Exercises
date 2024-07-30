import java.util.*;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("ID: " + employeeId );
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
    }
}

class EmployeeManagement {
    private Employee[] employees;
    private int count;

    public EmployeeManagement(int size) {
        employees = new Employee[size];
        count = 0;
    }


    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
            System.out.println("Employee added: " + employee.name);
        } else {
            System.out.println("Employee limit reached");
        }
    }


    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }


    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            employees[i].displayEmployee();
        }
    }


    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[count - 1] = null;
            count--;
            System.out.println("Employee with ID " + employeeId + " deleted.");
        } else {
            System.out.println("Employee ID not found.");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagement empMgmt = new EmployeeManagement(10); // Assume max 10 employees


        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter the choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter the Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter the Salary: ");
                    double salary = scanner.nextDouble();

                    Employee employee = new Employee(id, name, position, salary);
                    empMgmt.addEmployee(employee);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to be searched: ");
                    int searchId = scanner.nextInt();
                    Employee foundEmployee = empMgmt.searchEmployee(searchId);
                    if (foundEmployee != null) {
                        foundEmployee.displayEmployee();
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;

                case 3:
                    System.out.println("Employee List:");
                    empMgmt.traverseEmployees();
                    break;

                case 4:
                    System.out.print("Enter Employee ID to be deleted: ");
                    int deleteId = scanner.nextInt();
                    empMgmt.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("Closing the Employee Management");
                    scanner.close();
                    return;

                default:
                    System.out.println("Try one of these choices");
            }
        }
    }
}
