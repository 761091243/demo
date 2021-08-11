package dwp.IO.lambda;

import org.junit.Test;

import java.awt.print.Printable;
import java.util.Comparator;
import java.util.Objects;

/**
 * @description:
 * @author: Dunn
 * @create: 2021-08-11 09:22
 */
public class LambdaDemo1 {


    @Test
    public void method1() {
        method2(() -> {
            System.out.println("当参数是函数式接口是可使用lambda表达式");
        });
    }

    /**
     * 参数是函数式接口
     *
     * @param fun1
     */
    public void method2(FunctionInterface1 fun1) {
        fun1.method1();
    }

    //--------lambda执行的延迟性
    @Test
    public void method3() {
        // 把1换成2试下
        method4(1, () -> {
            System.out.println("当条件判断成功时才会调用接口的方法");
            return "a" + "b" + "c";
        });
    }

    public void method4(int level, FunctionInterface2 fun2) {
        if (level == 1) {
            System.out.println(fun2.add());
        }

    }

    // --------方法引用



}
