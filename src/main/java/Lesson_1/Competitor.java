package Lesson_1;

public class Competitor extends Team implements ICompetitor {
    private String name;
    private String surname;
    private int age;
    private double runSpeed;
    private double swimSpeed;
    private double maxJumpHeight;

    String swimResult;
    String runResult;
    String jumpResult;

    public double getRunSpeed() {
        return runSpeed;
    }

    public void setRunSpeed(double runSpeed) {
        this.runSpeed = runSpeed;
    }

    public double getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(double swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    public double getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public void setMaxJumpHeight(double maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Competitor(String nameOfTeam, String name, String surname,
                      int age, double runSpeed, double swimSpeed, double maxJumpHeight) {
        super(nameOfTeam);
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.maxJumpHeight = maxJumpHeight;
    }


    @Override
    public String run(Course course) {
        System.out.println(this.getName() + " " + this.getSurname() + " " + " бежит");
        return runResult = ("Марафон дистанция " + course.runDistance +
                "км: " + course.runDistance/getRunSpeed() + " мин") ;
    }


    @Override
    public String swim(Course course) {
        System.out.println(this.getName() + " " + this.getSurname() + " " + " плывет");
        return swimResult = ("Заплыв дистанция " + course.swimDistance +
                "м: " + course.swimDistance/getSwimSpeed() + " мин") ;
    }


    @Override
    public String jump(Course course) {
        System.out.println(this.getName() + " " + this.getSurname() + " " + " прыгает");
        if (course.jumpHeight <= getMaxJumpHeight()) {
            return jumpResult = "Прыжок высота " + course.jumpHeight + "м: успешно";
        } else {
            return jumpResult = "Прыжок высота " + course.jumpHeight + "м: Высота не взята";
        }
    }

    @Override
    public void dolt(Course course){
        run(course);
        swim(course);
        jump(course);
    }

    @Override
    public void infoAboutMembersOfTeam() {
        System.out.println(getNameOfTeam() + ", " + getName() + " " +
                getSurname() + ", Возраст: " + getAge());
    }

    @Override
    public void showResults(Course course){
        System.out.println(runResult);
        System.out.println(swimResult);
        System.out.println(jumpResult);
    }
}
