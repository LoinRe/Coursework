public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
//Задание 7
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


//Задание 8a
        for (Employee employee : employees) {
            System.out.println(employee);
        }

//Задание 8b
        System.out.println("Общая сумма затрат на зарплату в месяц: " + getSumInMonth(employees));

//Задание 8c
        Employee minSalaryEmployee = getEmplWithMinSalary(employees);
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee.getName() + " " + minSalaryEmployee.getSurname());

//Задание 8d
        Employee maxSalaryEmployee = getEmplWithMaxSalary(employees);
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee.getName() + " " + maxSalaryEmployee.getSurname());

//Задание 8e
        System.out.println("Среднее значение зарплат у сотрудников: " + getAverageSalary(employees));

//Задание 8f
        printEmployees(employees);
    }


    //МЕТОДЫ
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
            if (employees[i].getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employees[i];
            }
        }
        return minSalaryEmployee;
    }

    //Задание 8d
    public static Employee getEmplWithMaxSalary(Employee[] employees) {
        Employee maxSalaryEmployee = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employees[i];
            }
        }
        return maxSalaryEmployee;
    }

    //Задание 8e
    public static double getAverageSalary(Employee[] employees) {
        int sumInMonth = getSumInMonth(employees);
        return (double) (sumInMonth / employees.length);
    }

    //Задание 8f
    public static void printEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getSurname() + " " + employees[i].getName() + " " + employees[i].getPatronymic());
        }
    }
}