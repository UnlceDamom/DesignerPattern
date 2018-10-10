package com.itheima.observeJavainner;

import java.util.Observable;
import java.util.Observer;

public class Observer1 implements Observer {
    
    public void registSubject(Observable observable){
        observable.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof SubjectFor3D){
            SubjectFor3D subjectFor3D = (SubjectFor3D) o;
            System.out.println("subjectFor3D's msg -- >" + subjectFor3D.getMsg());
        }
        if (o instanceof SubjectForSSQ){
            SubjectForSSQ subjectForSSQ = (SubjectForSSQ) o;
            System.out.println("subjectForSSQ's msg -- >" + subjectForSSQ.getMsg());
        }
    }
}
