import java.util.concurrent.TimeUnit;

/**
 * Created by cwj on 2017/10/13.
 * 作者：futeng
 链接：https://www.zhihu.com/question/19801131/answer/26586203
 来源：知乎
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 回调方法的优势回调方法最大的优势在于，异步回调，这样是其最被广为使用的原因。
 下面将沿用“中国好室友” 来对回调方法做异步实现。回调接口不用变
 为了体现异步的意思，我们给好室友设置了个较难的问题，希望好室友能多好点时间思考。
 #给学生新建个ask方法，该方法中另开一个线程，来等待回调方法的结果反馈。
 student.ask(homework, new RoomMate());

 #新开的线程纯粹用来等待好室友来写完作用。由于在好室友类中设置了3秒的等待时间，所以可以看到goHome方法将先执行。
 #意味着该学生在告知好室友做作用后，就可以做自己的事情去了，不需要同步阻塞去等待结果。
 #一旦好室友完成作用，写入作业本，该现场也就结束运行了。
 */
public class Student5 implements DoWork {
    @Override
    public void doWork(String work, String answer) {
        System.out.println("作业本");
        if(answer != null) {
            System.out.println("作业："+work+" 答案："+ answer);
        } else {
            System.out.println("作业："+work+" 答案："+ "不知道");
        }
    }

    public void ask(final String work, final Roommate4 roommate4){
        new Thread(new Runnable() {
            @Override
            public void run() {
                roommate4.getAnswer(work, Student5.this);
            }
        }).start();

        goHome();
    }

    public void goHome(){
        System.out.println("我先回家，好室友帮我写下作业。。。");
    }

    public static void main(String[] args) {
        Student5 student5 = new Student5();
        String work = "当x趋向于0，sin(x)/x =?";

        student5.ask(work, new Roommate4());
    }

}

class Roommate4{
    public void getAnswer(String work, DoWork someone){

        if ("1+1=?".equals(work)) {
            someone.doWork(work, "2");
        } else if("当x趋向于0，sin(x)/x =?".equals(work)) {

            System.out.print("思考：");
            for(int i=1; i<=3; i++) {
                System.out.print(i+"秒 ");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            someone.doWork(work, "1");
        } else {
            someone.doWork(work, "(空白)");
        }
    }
}