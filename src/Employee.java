public class Employee {
    private String name;
    private String surname;
    private String patronymic;
    private int department; //отдел 1-5
    private int salary;
    private static int count; //переменная счетчик отвечает за id
    private int id;

    // конструктор
    //Задание 6
    public Employee(String name, String surname, String patronymic, int department, int salary) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        this.id = ++Employee.count;
    }

    public String getName() { //геттеры
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) { //сеттеры
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //Задание 5
    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee a2 = (Employee) other;
        return name.equals(a2.name) && surname.equals(a2.surname) && patronymic.equals(a2.patronymic) && department == a2.department && salary == a2.salary && id == a2.id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, surname, patronymic, department, salary, id);
    }

    //Задание 8a
    @Override
    public String toString() {       //выводим строку
        return surname + " " + name + " " + patronymic + ", отдел: " + department + ", зарплата: " + salary + ", ID: " + this.id;
    }
}

