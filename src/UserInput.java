import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

abstract class SelectUser {
    private String name;
    private int id;

    public SelectUser(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }
    public abstract void display();
}

class Student extends SelectUser
{
    private String major;

    public Student(String name, int id, String major)
    {
        super(name, id);
        this.major = major;
    }

    @Override
    public void display()
    {
        System.out.println("이름: " + getName() + ", ID: " + getId() + ", 전공: " + major);
    }
}

class Professor extends SelectUser
{
    public Professor(String name, int id, String department)
    {
        super(name, id);
    }
    @Override
    public void display()
    {
        System.out.println("이름: " + getName() + ", ID: " + getId());
    }
}
public class UserInput
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<SelectUser> userList = new ArrayList<>();

        while(true)
        {
            System.out.println("사용자 모드를 선택하세요. [professor, student] * 종료하려면 exit를 입력하세요.");
            String userType = sc.nextLine();

            if(userType.equals("exit"))
            {
                break;
            }
            System.out.println("이름을 입력하세요.");
            String name = sc.nextLine();

            System.out.println("ID를 입력하세요.");
            int id = Integer.parseInt(sc.nextLine());

            if(userType.equals("Student"))
            {
                System.out.println("전공을 입력하세요.");
                String major = sc.nextLine();
                userList.add(new Student(name, id, major));
            }
            else if(userType.equals("Professor"))
            {
                System.out.println("교수님 입니다.");
            }
            else
            {
                System.out.println("잘못된 입력입니다.");
            }
        }
        System.out.println("====사용자 목록====");
        System.out.println("\n[ 교수 목록 ]");
        System.out.printf("%-10s %-5s %-15s%n", "이름", "ID", ""); // %-10s %-5s %-15s%n은 출력을 정렬하는 데 사용.(포맷 문자열) [%-10s은 문자열(s), 최소 10칸], [%-5s는 문자열(s) 최소 5칸], [%-15s은 문자열(s), 최소 15칸]
        for (SelectUser user : userList)
        {
            if (user instanceof Professor)
            {
                user.display();
            }
        }

        System.out.println("\n[ 학생 목록 ]");
        System.out.printf("%-10s %-5s %-15s%n", "이름", "ID", "전공");
        for (SelectUser user : userList)
        {
            if (user instanceof Student)
            {
                user.display();
            }
        }
    }
}