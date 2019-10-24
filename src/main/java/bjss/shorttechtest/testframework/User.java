package bjss.shorttechtest.testframework;

class User {

    private String name;
    private String salary;
    private String age;

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public User setAge(String age) {
        this.age = age;
        return this;
    }
}