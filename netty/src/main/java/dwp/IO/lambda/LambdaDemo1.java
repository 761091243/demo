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
            System.out.println("�������Ǻ���ʽ�ӿ��ǿ�ʹ��lambda���ʽ");
        });
    }

    /**
     * �����Ǻ���ʽ�ӿ�
     *
     * @param fun1
     */
    public void method2(FunctionInterface1 fun1) {
        fun1.method1();
    }

    //--------lambdaִ�е��ӳ���
    @Test
    public void method3() {
        // ��1����2����
        method4(1, () -> {
            System.out.println("�������жϳɹ�ʱ�Ż���ýӿڵķ���");
            return "a" + "b" + "c";
        });
    }

    public void method4(int level, FunctionInterface2 fun2) {
        if (level == 1) {
            System.out.println(fun2.add());
        }

    }

    // --------��������



}
