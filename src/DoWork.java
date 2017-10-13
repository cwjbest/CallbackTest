/**
 * Created by cwj on 2017/10/13.
 *
 * 接口方式的回调方法常常使用回调方法的同学可能会说，我从来也没见过直接把对象的引用写到第一次调用方法里面的。
 * 嗯，是的，下面就来填上述例子留下的“天坑”（实际项目中常见到）。问题：在调用方法中直接传对象引用进去有什么不好？
 * 只说一点，只是让别人代写个方法，犯得着把自己全部暴露给别人吗。万一这个别人是竞争对手的接口咋办。这就是传说中的后面代码吗（/tx）
 * 总之这样做是非常不安全的。因此，最常规的《调用，回调》实现，是（你已经猜到了）使用接口作为引用（说的不严谨）传入调用的方法里面。
 *
 * 关键在于，该方法的用途是来解决某学生提出的某个问题。答案是通过学生的doHomeWork方法回调传回去的。
 * 那假设有个工人也有问题，这位室友该怎么解决呢。再开个方法，专门接收工人的引用作为传参？
 * 当然不用，只要你这个引用包含了doHomeWork()方法，那么不论你是工人、警察还是环卫工人，直接调用getAnswer()方法就能解决你提的问题。
 * 至此我们的思路达到了：所有的对象要有同一个方法，所以自热而然就引出了接口概念。
 * 只要这些对象都实现了某个接口就行了，这个接口的作用，仅仅是用来规定那个做作业的方法长什么样。
 * 这样工人实现了该接口，那么就有了默认继承的做作业方法。
 * 工人再把自己的引用抛给该室友的时候，这个室友就不需要改动任何代码，直接接触答案，完成任务了。
 * 创建一个做作业的接口，专门规定，需要哪些东西（问题和答案）就能做作业
 *
 * 改动下中国好室友的解答方法。任意一个实现了DoHomeWork 接口的someone，都拥有doHomeWork(String question,String answer)的方法。
 * 这个方法就是上面已经提到的“回调方法”。someone先调用下好室友的getAnswer()方法，把问题和自己传进来（此为调用），
 * 好室友把问题解答出之后，调用默认提供的方法，写完作业。思考下，因为是以接口作为参数类型的约定，
 * 在普通对象upcast向上转型之后将只暴露接口描述的那个方法，别人获取到这个引用，也只能使用这个（回调）方法。
 * 至此，遗留的重大安全隐患重要解决。

 作者：futeng
 链接：https://www.zhihu.com/question/19801131/answer/26586203
 来源：知乎
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public interface DoWork {
    void doWork(String work, String answer);
}

class Roommate3{
    public void getAnswer(String work, DoWork someone){
        if ("1+1=?".equals(work)){
            someone.doWork(work, "2");
        }else {
            someone.doWork(work, "不知道");
        }
    }
}

class Work1 implements DoWork{
    @Override
    public void doWork(String work, String answer) {
        System.out.println("作业本");
        if(answer != null) {
            System.out.println("作业："+work+" 答案："+ answer);
        } else {
            System.out.println("作业："+work+" 答案："+ "不知道");
        }
    }

    public static void main(String[] args) {
        Work1 work1 = new Work1();
        String work = "1+1=?";

        new Roommate3().getAnswer(work, work1);
    }
}

class Student4 implements DoWork{
    @Override
    public void doWork(String work, String answer) {
        System.out.println("作业本");
        if(answer != null) {
            System.out.println("作业："+work+" 答案："+ answer);
        } else {
            System.out.println("作业："+work+" 答案："+ "不知道");
        }
    }

    public static void main(String[] args) {
        Student4 student4 = new Student4();
        String work = "1+1=?";

        new Roommate3().getAnswer(work, student4);
    }
}