package Lesson_1;

public class Main {
    public static void main(String[] args) {
        Team team[] = new Competitor[4];

        team[0] = new Competitor("Russia", "Ivan", "Ivanov", 31, 17.5, 9.0, 2.1);
        team[1] = new Competitor("Russia", "Lena", "Lenina", 28, 15.4, 8.42, 2.0);
        team[2] = new Competitor("Russia", "Olga", "Timchenko", 26, 16.3, 7.5, 1.95);
        team[3] = new Competitor("Russia", "Marat", "Dubnov", 33, 18.1, 8.02, 2.2);

        Course c = new Course(100, 200, 2);

        for (Team newTeam : team) {
            newTeam.dolt(c);
            System.out.println(" ");
        }

        for (Team newTeam : team) {
            newTeam.infoAboutMembersOfTeam();
            newTeam.showResults(c);
            System.out.println(" ");
        }
    }
}
