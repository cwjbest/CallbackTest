/**
 * Created by cwj on 2017/10/13.
 * #1. 因为室友帮忙写，所以在doHomeWork动作里面，就不需要有逻辑判断的代码，因为舍友会直接把答案写进来。改成：
 student.doHomeWork(aHomeWork, theAnswer);
 #上句中做作业的动作支持传入“作业”和“答案”，有了这两个，就说明能做好作业了。
 #其中aHomeWork作业是已知的，但是theAnswer这个答案却是室友提供的。
 #室友怎么才能提供答案呢，最简单是，室友这个对象直接提供一个传入作业，传出答案的方法，这样该同学就可以直接调用了。
 RoomMate roomMate = new RoomMate();
 String theAnswer = roomMate.getAnswer(aHomeWork);
 student.doHomeWork(aHomeWork, theAnswer);

 作者：futeng
 链接：https://www.zhihu.com/question/19801131/answer/26586203
 来源：知乎
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Student2 {
    public void doHomework(String homework, String answer){
        System.out.println("作业本");
        if (answer != null){
            System.out.println("作业：" + homework + " 答案：2");
        }else{
            System.out.println("作业：" + homework + " 答案：不知道");
        }
    }

    public static void main(String[] args) {
        Student2 student2 = new Student2();
        String homework = "1+1=?";
        Roommate1 roommate = new Roommate1();

        String answer = roommate.getAnswer(homework);
        student2.doHomework(homework, answer);
    }
}

class Roommate1{
    public String getAnswer(String homework){
        if ("1+1=?".equals(homework)){
            return "2";
        }else{
            return null;
        }
    }
}