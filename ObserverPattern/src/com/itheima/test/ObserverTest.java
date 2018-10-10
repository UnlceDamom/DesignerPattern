package com.itheima.test;

import com.itheima.observer.Subject;
import com.itheima.observer.impl.Observer1;
import com.itheima.observer.impl.Observer2;
import com.itheima.observer.impl.SubjectFor3D;

@SuppressWarnings("ALL")
public class ObserverTest {
    public static void main(String[] orgs){
        //模拟一个3D服务号
        SubjectFor3D subjectFor3D = new SubjectFor3D();
        //用户1
        Observer1 observer1 = new Observer1(subjectFor3D);
        //用户2
        Observer2 observer2 = new Observer2(subjectFor3D);
        //服务号更新
        //可以看出：服务号中维护了所有向它订阅消息的使用者，当服务号有新消息时，通知所有的使用者。
        //整个架构是一种松耦合，主题的实现不依赖与使用者，当增加新的使用者时，主题的代码不需要改变；使用者如何处理得到的数据与主题无关；
        subjectFor3D.setMsg("20180720期的3D号码是:127");
        subjectFor3D.setMsg("20180721期的3D号码是:325");
    }
}
