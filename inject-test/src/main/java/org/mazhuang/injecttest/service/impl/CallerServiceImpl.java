package org.mazhuang.injecttest.service.impl;

import jdk.nashorn.internal.codegen.CompilerConstants;
import org.mazhuang.injecttest.service.CalleeService;
import org.mazhuang.injecttest.service.CallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author mazhuang
 */
@Service
public class CallerServiceImpl implements CallerService {

    // Case 1: Resource + 不指定 name 和 type + 不匹配 Bean name 的变量名
    // 运行结果：异常
    // Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'org.mazhuang.injecttest.service.CalleeService' available: expected single matching bean but found 2: callee1ServiceImpl,callee2ServiceImpl
    @Resource
    private CalleeService calleeService;

    // Case 2: Resource + 不指定 name 和 type + 匹配 Bean name 的变量名
    // 运行结果：正常，按变量名匹配的 Bean 进行注入
//    @Resource
//    private CalleeService callee1ServiceImpl;
//
//    @PostConstruct
//    public void test() {
//        System.out.println(callee1ServiceImpl.getClass().getName());
//    }

    // Case 3: Resource + 指定 name + 不匹配 Bean name 的变量名
    // 运行结果：正常
//    @Resource(name = "callee2ServiceImpl")
//    private CalleeService calleeService;

    // Case 4: Resource + 指定 name + 匹配 Bean name 的变量名
    // 运行结果：正常，按 name 指定的 Bean 进入注入，变量名被忽略
//    @Resource(name = "callee2ServiceImpl")
//    private CalleeService callee1ServiceImpl;
//
//    @PostConstruct
//    public void test() {
//        System.out.println(callee1ServiceImpl.getClass().getName());
//    }

    // Case 5: Resource + 指定 type + 不匹配 Bean name 的变量名
    // 运行结果：正常
//    @Resource(type = Callee1ServiceImpl.class)
//    private CalleeService calleeService;

    // Case 6: Resource + 指定 type + 匹配该 type Bean name 的变量名
    // 运行结果：正常
//    @Resource(type = Callee1ServiceImpl.class)
//    private CalleeService callee1ServiceImpl;

    // Case 7: Resource + 指定 type + 匹配其它 type Bean name 的变量名
    // 运行结果：异常
    // Caused by: org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'callee2ServiceImpl' is expected to be of type 'org.mazhuang.injecttest.service.impl.Callee1ServiceImpl' but was actually of type 'org.mazhuang.injecttest.service.impl.Callee2ServiceImpl'
//    @Resource(type = Callee1ServiceImpl.class)
//    private CalleeService callee2ServiceImpl;

    // Case 8: Resource + 指定正确 name + 指定 name 对应 type + 不匹配 Bean name 的变量名
    // 运行结果：正常
//    @Resource(name = "callee1ServiceImpl", type = Callee1ServiceImpl.class)
//    private CalleeService calleeService;

    // Case 9: Resource + 指定正确 name + 指定 name 对应 type + 匹配 Bean name 的变量名
    // 运行结果：正常
    // 指定 name 后，变量名对注入不再产生影响。
//    @Resource(name = "callee1ServiceImpl", type = Callee1ServiceImpl.class)
//    private CalleeService callee2ServiceImpl;

    // Case 10: Resource + 指定正确 name + 指定 name 不对应 type
    // 运行结果：异常
    // Caused by: org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'callee1ServiceImpl' is expected to be of type 'org.mazhuang.injecttest.service.impl.Callee2ServiceImpl' but was actually of type 'org.mazhuang.injecttest.service.impl.Callee1ServiceImpl'
//    @Resource(name = "callee1ServiceImpl", type = Callee2ServiceImpl.class)
//    private CalleeService calleeService;

    // Case 11: Resource + 指定不正确 name + 指定 type
    // 运行结果：异常
    // Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'callerServiceImpl': Injection of resource dependencies failed; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'callee3ServiceImpl' available
//    @Resource(name = "callee3ServiceImpl", type = Callee2ServiceImpl.class)
//    private CalleeService calleeService;

    // Case 12: Resource + 注掉 CalleeService 的所有实现
    // 运行结果：异常
    // Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'callerServiceImpl': Injection of resource dependencies failed; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.mazhuang.injecttest.service.CalleeService' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@javax.annotation.Resource(shareable=true, lookup=, name=, description=, authenticationType=CONTAINER, type=class java.lang.Object, mappedName=)}
//    @Resource
//    private CalleeService calleeService;

    // Case 13: Autowired + 匹配 Bean name 的变量名
    // 运行结果：正常
//    @Autowired
//    private CalleeService callee1ServiceImpl;

    // Case 14: Autowired + 不匹配 Bean name 的变量名
    // 运行结果：异常
    // 此时将 Callee1ServiceImpl 和 Callee2ServiceImpl 注释掉其中一个就运行正常了。说明 Autowired 是优先按变量名寻找 Bean，如果找不到再按类型搜索。
    // Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'callerServiceImpl': Unsatisfied dependency expressed through field 'calleeService'; nested exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'org.mazhuang.injecttest.service.CalleeService' available: expected single matching bean but found 2: callee1ServiceImpl,callee2ServiceImpl
//    @Autowired
//    private CalleeService calleeService;

    // Case 15: Autowired + 匹配 Bean name 的变量名 + Qualifier 匹配同一个 Bean name 的变量名
    // 运行结果：正常
//    @Autowired
//    @Qualifier("callee1ServiceImpl")
//    private CalleeService callee1ServiceImpl;

    // Case 16: Autowired + 匹配 Bean name 的变量名 + Qualifier 匹配另一个 Bean name 的变量名
    // 运行结果：正常
    // org.mazhuang.injecttest.service.impl.Callee1ServiceImpl
    // 通过 Qualifier 限定 Bean name 之后，变量名不再影响注入。
//    @Autowired
//    @Qualifier("callee1ServiceImpl")
//    private CalleeService callee2ServiceImpl;
//
//    @PostConstruct
//    public void test() {
//        System.out.println(callee2ServiceImpl.getClass().getName());
//    }

    // Case 17: Autowired + 注掉 CalleeService 的所有实现
    // 运行结果：异常
    // Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'callerServiceImpl': Unsatisfied dependency expressed through field 'calleeService'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.mazhuang.injecttest.service.CalleeService' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
//    @Autowired
//    private CalleeService calleeService;

    // Case 18: Autowired + 注掉 CalleeService 的所有实现 + required = false
    // 运行结果：正常
//    @Autowired(required = false)
//    private CalleeService calleeService;
}
