import org.apache.commons.beanutils.BeanComparator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());
        HelloWorld bean1 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean1.getMessage());

        Cat bean2 = (Cat) applicationContext.getBean("cat");
        System.out.println(bean2.getMessage());
        Cat bean3 = (Cat) applicationContext.getBean("cat");
        System.out.println(bean3.getMessage());
        BeanComparator<HelloWorld> comp = new BeanComparator("message");
        System.out.println(comp.compare(bean, bean1));
        BeanComparator<Cat> comp1 = new BeanComparator("message");
        System.out.println(comp1.compare(bean2, bean3));

    }
}