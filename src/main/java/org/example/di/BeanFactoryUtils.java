package org.example.di;

import org.example.annotation.Inject;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.Set;

public class BeanFactoryUtils {
    public static Constructor<?> getInjectedConstructor(Class<?> clazz) {
        // 클래스 타입 객체의 Inject annotation이 붙은 모든 생성자를 가져와서
        Set<Constructor> injectedConstructors = ReflectionUtils.getAllConstructors(clazz, ReflectionUtils.withAnnotation(Inject.class));
        if (injectedConstructors.isEmpty()){
            return null;
        }
        // 일단 첫 번째 요소만 리턴
        return injectedConstructors.iterator().next();
    }
}
