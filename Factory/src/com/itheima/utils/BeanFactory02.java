package com.itheima.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 根据id（借口的名字）创建实现类对象
 */
public class BeanFactory02 {
    public static Object getBean(String id){
        try {
            //解析xml配置文件dom4j+Xpath
            //1.创建SAXReader对象
            SAXReader saxReader = new SAXReader();
            //2.读取配置文件 获得document对象(获取流：通用)
            Document document = saxReader.read(BeanFactory02.class.getClassLoader().getResourceAsStream("applicationContext.xml"));
            //3.使用xpath从文档对象中查找元素
            Element beanEle = (Element) document.selectSingleNode("//bean[@id='"+id+"']");
            //4.获得当前bean标签的class属性值
            String className = beanEle.attributeValue("class");
            //5.通过反射获得对象
            return Class.forName(className).newInstance();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
