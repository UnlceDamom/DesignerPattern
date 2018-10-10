package com.itheima.test;

import com.itheima.observeJavainner.Observer1;
import com.itheima.observeJavainner.SubjectFor3D;
import com.itheima.observeJavainner.SubjectForSSQ;

@SuppressWarnings("ALL")
public class ObserverTest02 {
    public static void main(String[] args) {
        //模拟服务号平台
        SubjectFor3D subjectFor3D = new SubjectFor3D();
        SubjectForSSQ subjectForSSQ = new SubjectForSSQ();
        
        //用户注册
        Observer1 observer1 = new Observer1();
        observer1.registSubject(subjectFor3D);
        observer1.registSubject(subjectForSSQ);
        
        subjectFor3D.setMsg("hello 3D's num:110");
        subjectForSSQ.setMsg("SSQ'nums:12,13,14,15,16");
    }
}
