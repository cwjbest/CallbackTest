/**
 * Created by cwj on 2017/10/13.
 * #待解决的作业
 String aHomeWork = "1+1=?";
 #室友写出答案
 String theAnswer = roomMate.getAnswer(aHomeWork);
 #该同学调用，自己把答案写到作业本。（也即是这个步骤不给调用了）
 student.doHomeWork(aHomeWork, theAnswer);
 #做作业必须得调用这个方法，而根据需求这个方法必须由室友去调用。那很显然，该室友得保持一个该同学的引用，才能正常调用啊。
 #灯灯灯~
 #室友说，那你在调用getAnswer方法的时候，除了传入作业，还需要把自己的引用放里面。这样我做完了，直接调用你的做作业方法就行了。
 roomMate.getAnswer(aHomeWork,student);

 作者：futeng
 链接：https://www.zhihu.com/question/19801131/answer/26586203
 来源：知乎
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Student3 {
    public void doHomework(String homework, String answer){
        System.out.println("作业本");
        if (answer != null){
            System.out.println("作业：" + homework + " 答案：2");
        }else{
            System.out.println("作业：" + homework + " 答案：不知道");
        }
    }

    public static void main(String[] args) {
        Student3 student3 = new Student3();
        String homework = "1+1=?";

        Roommate2 roommate2 = new Roommate2();
        roommate2.getAnswer(homework, student3);
    }
}

class Roommate2{
    public void getAnswer(String homework, Student3 student3){
        if ("1+1=?".equals(homework)){
            student3.doHomework(homework, "2");
        }else {
            student3.doHomework(homework, "不知道");
        }
    }
}
/**
 * 回调方法在上述“让室友直接把作业写了”的例子中，其实已经体现了回调的意思。场景的核心在于这位学生要把作业给做了。
 *
 * 简单点描述：这位学生告诉室友要做什么作业，并把自己的引用也给了室友。
 * 该室友得到作业，做完后直接引用该学生并调用其做作业的方法，完成代写作业的任务。
 *
 * 稍微复杂点描述：该学生做作业的方法有两个入参，一个是作业题目（已知），一个是作业答案（未知）。
 * 室友为了帮助他写作业提供了一个方法，该方法有两个入参，一个是作业题目，一个是该学生的引用（解出答案得知道往哪写）。
 * 程序执行时，该学生只要调用室友的代写作业方法就行了。一旦室友得到答案，因为有该学生的引用，所以直接找到对应方法，帮助其完成作业。
 *
 * 再复杂点描述：学生调用室友的替写作业方法，注册了题目和自己的引用。
 * 室友的替写作业方法被调用，则会根据题目完成作业后，再回调该同学写作业方法，完成作业。
 *
 * 再抽象点描述：类A调用类B的方法b（传入相关信息），类B的方法在执行完后，会将结果写到（再回调）类A的方法a，完成动作。
 * （其实方法a就是传说中的回调方法啦）
 *
 * 最抽象的描述：调用，回调。

 作者：futeng
 链接：https://www.zhihu.com/question/19801131/answer/26586203
 来源：知乎
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * */
