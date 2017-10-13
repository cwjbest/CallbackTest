/**
 * Created by cwj on 2017/10/13.
 * # 1. 有个学生
 Student student = new Student();
 # 2. 该学生有写作业这个动作需要执行
 student.doHomeWork(someHomeWork);
 # 3. 注意到这个写作业这个动作是需要得到入参“作业”的后才能进行的。所以给这个学生new了个简单的题目做。
 String aHomeWork = "1+1=?";
 student.doHomeWork(aHomeWork);

 作者：futeng
 链接：https://www.zhihu.com/question/19801131/answer/26586203
 来源：知乎
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Student1 {
    public void doHomework(String homework){
        System.out.println("作业本");
        if ("1+1=?".equals(homework)){
            System.out.println("作业：" + homework + " 答案：2");
        }else {
            System.out.println("作业：" + homework + " 答案：不知道");
        }
    }

    public static void main(String[] args) {
        Student1 student1 = new Student1();
        String homework = "1+1=?";
        student1.doHomework(homework);
    }
}

