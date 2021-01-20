# Private vs Default vs Protected vs Public

| 접근 지정자 | 자신의 클래스 | 같은 패키지 | 자식 클래스 | 다른 패키지 |
| -------- | --------- | ---------| -------- | -------- |
| private | O | X | X | X |
| default | O | O| X | X |
| protected | O | O| O | X |
| public | O | O| O | O |

## 부모 클래스 예시
~~~java
package test.testOne;

/**
 * 다른 패키지에서 가져다 사용 할 클래스.
 * @author tmddusgood
 *
 */
public class SuperClass {
    private int a = 10;
    int b = 20;
    protected int c = 30;
    public int d = 40;
    
    public int getA() {
        return a;
    }
    
    public void setA(int a) {
        this.a = a;
    }
 
    public int getB() {
        return b;
    }
 
    public void setB(int b) {
        this.b = b;
    }
 
    public int getC() {
        return c;
    }
 
    public void setC(int c) {
        this.c = c;
    }
 
}
~~~

## SuperSubA.java

~~~java
package test.testTwo;
 
import paskTest.paskOne.SuperClass;
 
/**
 * AccessTest 클래스를 상속받는 클래스
 * @author tmddusgood
 *
 */
class SubOne extends SuperClass{
    void subPrn(){
        System.out.println(a);    // private    : 다른 클래스에서는 사용 불가
        System.out.println(b);    // 생략        : 다른 패키지에서는 사용 불가
        System.out.println(c);    // protected : 서브클래스에서는 public으로 사용됨으로 사용 가능.
        System.out.println(d);    // public    : 모든 객체에서 접근 가능
    }
}
 
/**
 * 객체생성으로 AccessTest클래스 사용하는 클래스
 * @author tmddusgood
 *
 */
public class SuperSubA {
 
    public static void main(String[] args) {
        
        SuperClass at = new SuperClass();
        
        System.out.println(at.a);    // private     : 다른 클래스에서는 사용 불가
        System.out.println(at.b);    // 생략        : 다른 패키지에서는 사용 불가
        System.out.println(at.c);    // protected : 다른패키지의 외부 클래스에서는 사용 불가
        System.out.println(at.d);    // public     : 모든 객체에서 접근 가능.
    
    }
 
}
~~~

##SuperSubB.java

~~~java
package test.testOne;

/**
 * 같은 패키지에 있는 자식 클래스
 * @author tmddusgood
 *
 */
public class SuperSubB{

    public static void main(String[] args) {
        
        SuperClass t = new SuperClass();
        System.out.println(t.c);
    }

}
~~~