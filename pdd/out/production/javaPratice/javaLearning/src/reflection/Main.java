package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        Class<?> targetClass = Class.forName("reflection.TargetObject");
        TargetObject targetObject = (TargetObject) targetClass.newInstance();

        TargetObject targetObject1 = new TargetObject();
        Class<? extends TargetObject> aClass = targetObject1.getClass();

        Class<TargetObject> targetObjectClass = TargetObject.class;


        Method[] methods = targetClass.getDeclaredMethods();

        Method publicMethods = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethods.invoke(targetObject, "zjy");
        Field value = targetClass.getDeclaredField("value");
        value.setAccessible(true);
        value.set(targetObject, "zjy");

        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
