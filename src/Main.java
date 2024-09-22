public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        //Задание 7 базовой сложности
        employees[0] = new Employee("Ivan", "Semin", "Ilyich", 1, 80000);
        employees[1] = new Employee("Ilya", "Matveev", "Ilyich", 1, 85000);
        employees[2] = new Employee("Oleg", "Adonin", "Ivanovich", 2, 75000);
        employees[3] = new Employee("Dmitriy", "Kumanin", "Olegovich", 2, 82000);
        employees[4] = new Employee("Ivan", "Akimov", "Dmitrievich", 3, 90000);
        employees[5] = new Employee("Olga", "Kostareva", "Igorevna", 3, 100300);
        employees[6] = new Employee("Ekaterina", "Semina", "Sergeevna", 4, 89000);
        employees[7] = new Employee("Anna", "Sinitsyna", "Nikolaevna", 4, 92400);
        employees[8] = new Employee("Vladislav", "Karpuchin", "Ilyich", 5, 120000);
        employees[9] = new Employee("Nikita", "Lushenkov", "Dmitrievich", 5, 73500);

        //БАЗОВАЯ СЛОЖНОСТЬ
        System.out.println("БАЗОВАЯ СЛОЖНОСТЬ");

        //Задание 8a
        System.out.println("Задание 8a");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        //Задание 8b
        System.out.println("Задание 8b");
        System.out.println("Общая сумма затрат на зарплату в месяц: " + getSumInMonth(employees));

        //Задание 8c
        Employee minSalaryEmployee = getEmplWithMinSalary(employees);
        System.out.println("Задание 8c");
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee.getName() + " " + minSalaryEmployee.getSurname());

        //Задание 8d
        Employee maxSalaryEmployee = getEmplWithMaxSalary(employees);
        System.out.println("Задание 8d");
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee.getName() + " " + maxSalaryEmployee.getSurname());

        //Задание 8e
        System.out.println("Задание 8е");
        System.out.println("Среднее значение зарплат у сотрудников: " + getAverageSalary(employees));

        //Задание 8f
        System.out.println("Задание 8f");
        printEmployees(employees);

        System.out.println("--------------");

        //ПОВЫШЕННАЯ СЛОЖНОСТЬ
        System.out.println("ПОВЫШЕННАЯ СЛОЖНОСТЬ");

        //Задание 1
        adjustSalaries(10);

        //Задание 2a
        Employee minSalaryEmployeeDepart = getEmplMinSalaryDepart(2);
        System.out.println("Сотрудник с минимальной зарплатой из отдела " + minSalaryEmployeeDepart.getDepartment() +
                ": " + minSalaryEmployeeDepart.getName() + " " + minSalaryEmployeeDepart.getSurname());

        //Задание 2b
        Employee maxSalaryEmployeeDepart = getEmplMaxSalaryDepart(2);
        System.out.println("Сотрудник с максимальной зарплатой из отдела " + maxSalaryEmployeeDepart.getDepartment() +
                ": " + maxSalaryEmployeeDepart.getName() + " " + maxSalaryEmployeeDepart.getSurname());

        //Задание 2c
        int departmentNumber = 3;
        int totalSalary = getSumSalaryInDepartment(departmentNumber);
        System.out.println("Сумма затрат на зарплату по отделу " + departmentNumber + ": " + totalSalary);

        //Задание 2d
        departmentNumber = 4; // Измените это на номер отдела, который хотите проверить
        double averageSalary = getAverageSalaryInDepart(departmentNumber);
        System.out.println("Средняя зарплата в отделе " + departmentNumber + ": " + averageSalary);

        //Задание 2e
        adjustSalariesInDepartment(1, 2);

        //Задание 2f
        printEmployeesInDepartment(5);

        //Задание 3
        getSalaryLessThanNumber(95000);

        //Задание 4
        getSalaryEqualsOrGreaterThanNum(92400);
    }


    //МЕТОДЫ (БАЗОВАЯ СЛОЖНОСТЬ)
    //Задание 8b
    public static int getSumInMonth(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    //Задание 8c
    public static Employee getEmplWithMinSalary(Employee[] employees) {
        Employee minSalaryEmployee = employees[0]; //допустим 1 сотрудник с мин зп
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employees[i];
            }
        }
        return minSalaryEmployee;
    }

    //Задание 8d
    public static Employee getEmplWithMaxSalary(Employee[] employees) {
        Employee maxSalaryEmployee = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employees[i];
            }
        }
        return maxSalaryEmployee;
    }

    //Задание 8e
    public static double getAverageSalary(Employee[] employees) {
        int sumInMonth = getSumInMonth(employees);
        return (double) sumInMonth / employees.length;
    }

    //Задание 8f
    public static void printEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getSurname() + " " + employees[i].getName() + " " + employees[i].getPatronymic());
        }
    }

    //МЕТОДЫ (ПОВЫШЕННАЯ СЛОЖНОСТЬ)
    //Задание 1
    public static void adjustSalaries(double percentage) {
        System.out.println("Задание 1");
        for (Employee employee : employees) {
            int newSalary = (int) (employee.getSalary() * (1 + percentage / 100));
            employee.setSalary(newSalary);
            System.out.println(employee); // Выводим обновленные данные сотрудника
        }
    }

    //Задание 2a
    public static Employee getEmplMinSalaryDepart(int department) {
        System.out.println("Задание 2a");
        Employee minSalaryEmployee = employees[0]; //допустим 1 сотрудник с мин зп
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalaryEmployee.getSalary() && employees[i].getDepartment() == department) {
                minSalaryEmployee = employees[i];
            }
        }
        return minSalaryEmployee;
    }

    //Задание 2b
    public static Employee getEmplMaxSalaryDepart(int department) {
        System.out.println("Задание 2b");
        Employee maxSalaryEmployee = employees[0]; //допустим 1 сотрудник с мин зп
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalaryEmployee.getSalary() && employees[i].getDepartment() == department) {
                maxSalaryEmployee = employees[i];
            }
        }
        return maxSalaryEmployee;
    }

    //Задание 2c
    public static int getSumSalaryInDepartment(int department) {
        System.out.println("Задание 2c");
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    //Задание 2d
    public static double getAverageSalaryInDepart(int department) {
        System.out.println("Задание 2d");
        int countEmployees = 0;
        int sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                countEmployees++;
                sumSalary += employees[i].getSalary();
            }
        }
        return (double) sumSalary / countEmployees;
    }

    //Задание 2e
    public static void adjustSalariesInDepartment(int department, double percentage) {
        System.out.println("Задание 2e");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                int newSalary = (int) (employees[i].getSalary() * (1 + percentage / 100));
                employees[i].setSalary(newSalary);
                System.out.println(employees[i]); // Выводим обновленные данные сотрудника
            }
        }
    }

    //Задание 2f
    public static void printEmployeesInDepartment(int department) {
        System.out.println("Задание 2f");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.println(employees[i].getSurname() + " " + employees[i].getName() + " " + employees[i].getPatronymic() +
                        ", зарплата: " + employees[i].getSalary() + ", ID: " + employees[i].getId());
            }
        }
    }

    //Задание 3
    public static void getSalaryLessThanNumber(int number) {
        System.out.println("Задание 3");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < number) {
                System.out.println("ID: " + employees[i].getId() + ", " + employees[i].getSurname() + " " + employees[i].getName() +
                        " " + employees[i].getPatronymic() + ", зарплата: " + employees[i].getSalary());
            }
        }
    }

    //Задание 4
    public static void getSalaryEqualsOrGreaterThanNum(int number) {
        //  Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль).
        System.out.println("Задание 4");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= number) {
                System.out.println("ID: " + employees[i].getId() + ", " + employees[i].getSurname() + " " + employees[i].getName() +
                        " " + employees[i].getPatronymic() + ", зарплата: " + employees[i].getSalary());
            }
        }
    }
}