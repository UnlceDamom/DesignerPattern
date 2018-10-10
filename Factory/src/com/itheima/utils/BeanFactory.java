package com.itheima.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 每次在web，service，dao层里面调用getBean（）方法的时候都会解析xml；
 * 能不能一开始就全部解析好，然后存到一个容器Map<String,Object> beans里面，调用getBean（）的时候 直接从容器里面取值
 */
public class BeanFactory {

    //定义map
    private static Map<String,Object> beans;

    static {
        try {
            beans = new HashMap<String,Object>();
            //解析xml，初始化beans集合
            //1.创建SAXReader对象
            SAXReader saxReader = new SAXReader();
            //2.读取配置文件 获得document对象(获取流：通用)
            Document document = saxReader.read(BeanFactory.class.getClassLoader().getResourceAsStream("applicationContext.xml"));
            //3.获得所有的bean标签对象List
            List<Element> beanList = document.selectNodes("//bean");
            //4.遍历
            for (Element element : beanList) {
                //获得id的属性值作为map的key
                String id = element.attributeValue("id");

                //获得class的属性值，反射得到对象作为map的value
                String className = element.attributeValue("class");
                beans.put(id,Class.forName(className).newInstance());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static Object getBean(String id){
        return beans.get(id);

        /*try {
            //解析xml配置文件dom4j+Xpath
            //1.创建SAXReader对象
            SAXReader saxReader = new SAXReader();
            //2.读取配置文件 获得document对象(获取流：通用)
            Document document = saxReader.read(BeanFactory.class.getClassLoader().getResourceAsStream("applicationContext.xml"));
            //3.使用xpath从文档对象中查找元素
            Element beanEle = (Element) document.selectSingleNode("//bean[@id='"+id+"']");
            //4.获得当前bean标签的class属性值
            String className = beanEle.attributeValue("class");
            //5.通过反射获得对象
            return Class.forName(className).newInstance();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }*/
    }
}
