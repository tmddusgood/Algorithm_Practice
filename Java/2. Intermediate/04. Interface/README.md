# 인터페이스 Interface

## 인터페이스란?

![interface](./img/interface.png)

- 모든 메서드가 추상 메서드로 선언됨 public abstract

- 모든 변수는 상수로 선언됨 public static final

```
interface 인터페이스 이름{

    public static final float pi = 3.14F;
    public void makeSomething();
}
```

- 자바 8 부터 디폴트 메서드(default method)와 정적 메서드(static method) 기능의 제공으로 일부 구현 코드가 있음

## 인터페이스 정의와 구현

![calc](./img/calc.png)

Calc.java
```
public interface Calc {

	double PI = 3.14;
	int ERROR = -99999999;
	
	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
}
```

Calculator.java
```
public abstract class Calculator implements Calc{

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}
}
```

CompleteCalc.java
```
public class CompleteCalc extends Calculator{
	
	@Override
	public int times(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		if( num2 == 0 )
			return ERROR;
		else 
			return num1 / num2;
	}
	
	public void showInfo() {
		System.out.println("모두 구현하였습니다.");
	}
}
```

CalculatorTest.java
```
public class CalculatorTest {

	public static void main(String[] args) {
		Calc calc = new CompleteCalc();
		int num1 = 10;
		int num2 = 2;
		
		System.out.println(num1 + "+" + num2 + "=" + calc.add(num1, num2));
		System.out.println(num1 + "-" + num2 + "=" +calc.substract(num1, num2));
		System.out.println(num1 + "*" + num2 + "=" +calc.times(num1, num2));
		System.out.println(num1 + "/" + num2 + "=" +calc.divide(num1, num2));
	}
}
```

![out](./img/out.png)


## 인터페이스 구현과 형 변환

- 인터페이스를 구현한 클래스는 인터페이스 형으로 선언한 변수로 형 변환 할 수 있음

Calc calc = new CompleteCalc();

- 상속에서의 형 변환과 동일한 의미

- 클래스 상속과 달리 구현 코드가 없으므로 여러 인터페이스를 구현할 수 있음 ( cf. extends)

- 형 변환되는 경우 인터페이스에 선언된 메서드만을 사용가능함

![type](./img/type.png)

# 인터페이스는 왜 쓰는가?

## 인터페이스가 하는 일

- 클래스나 프로그램이 제공하는 기능을 명시적으로 선언

- 일종의 클라이언트 코드와의 약속이며 클래스나 프로그램이 제공하는 명세(specification)

- 클라이언트 프로그램은 인터페이스에 선언된 메서드 명세만 보고 이를 구현한 클래스를 사용할 수 있음

- 어떤 객체가 하나의 인터페이스 타입이라는 것은 그 인터페이스가 제공하는 모든 메서드를 구현했다는 의미임

- 인터페이스를 구현한 다양한 객체를 사용함 - 다형성

- 예) JDBC 인터페이스

# 인터페이스를 활용한 다형성 구현 (dao 구현하기)

## 인터페이스와 다형성

- 하나의 인터페이스를 여러 객체가 구현하게 되면 클라이언트 프로그램은 인터페이스의 메서드를 활용하여 여러 객체의 구현을 사용할 수 있음 ( 다형성)

- 여러가지 예

![sorting](./img/sorting.png)

![dao](./img/dao.png)

## 인터페이스를 활용한 dao 구현하기

- DB에 회원 정보를 넣는 dao(data access object)를 여러 DB 제품이 지원될 수 있게 구현함

- 환경파일(db.properties) 에서 database의 종류에 대한 정보를 읽고 그 정보에 맞게 dao 인스턴스를 생성하여 실행될 수 있게 함

- source hierachy

![userinfo](./img/userinfo.png)

UserInfo.java (사용자 정보 클래스)
```
public class UserInfo {
	
	private String userId;
	private String passwd;
	private String userName;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
```

UserInfoDao.java ( dao 에서 제공되어야 할 메서드를 선언한 인터페이스 )
```
public interface UserInfoDao {

	void insertUserInfo(UserInfo userInfo);
	void updateUserInfo(UserInfo userInfo);
	void deleteUserInf(UserInfo userInfo);
}
```

UserInfoMySqlDao.java (UserInfoDao 인터페이스를 구현한 MySql 버전 dao)
```
public class UserInfoMySqlDao implements UserInfoDao{

	@Override
	public void insertUserInfo(UserInfo userInfo) {
		System.out.println("insert into MYSQL DB userId =" + userInfo.getUserId() );		
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		System.out.println("update into MYSQL DB userId = " + userInfo.getUserId());		
	}

	@Override
	public void deleteUserInf(UserInfo userInfo) {
		System.out.println("delete from MYSQL DB userId = " + userInfo.getUserId());
		
	}

}
```

UserInfoOracleDao.java (UserInfoDao 인터페이스를 구현한 Oracle 버전 dao)
```
public class UserInfoOracleDao implements UserInfoDao{

	public void insertUserInfo(UserInfo userInfo){
		System.out.println("insert into ORACLE DB userId =" + userInfo.getUserId() );
	}
	
	public void updateUserInfo(UserInfo userInfo){
		System.out.println("update into ORACLE DB userId = " + userInfo.getUserId());
	}
	
	public void deleteUserInf(UserInfo userInfo){
		System.out.println("delete from ORACLE DB userId = " + userInfo.getUserId());
	}
}
```

UserInfoClient.java (UserInfoDao 인터페이스를 활용하는 클라이언트 프로그램)
```
public class UserInfoClient {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("db.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String dbType = prop.getProperty("DBTYPE");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("12345");
		userInfo.setPasswd("!@#$%");
		userInfo.setUserName("이순신");
		
		
		UserInfoDao userInfoDao = null;
		
		if(dbType.equals("ORACLE")){
			userInfoDao = new UserInfoOracleDao();
		}
		else if(dbType.endsWith("MYSQL")){
			userInfoDao = new UserInfoMySqlDao();
		}
		else{
			System.out.println("db support error");
			return;
		}
		
		userInfoDao.insertUserInfo(userInfo);
		userInfoDao.updateUserInfo(userInfo);
		userInfoDao.deleteUserInf(userInfo);
	}
}
```

db.properties 환경파일이 MYSQL 일때
```
DBTYPE=MYSQL
```
실행결과
![mysql](./img/mysql.png)

db.properties 환경파일이 ORACLE 일때
```
DBTYPE=ORACLE
```
실행결과
![mysql](./img/oracle.png)

# 인터페이스의 여러가지 요소


## 상수

- 모든 변수는 상수로 변환 됨 public static final
```
double PI = 3.14;
int ERROR = -999999999;
	
```
## 추상 메서드

- 모든 선언된 메서드는 추상 메서드 public abstract

## 디폴트 메서드 (자바 8이후)

- 구현을 가지는 메서드, 인터페이스를 구현하는 클래스들에서 공통으로 사용할 수 있는 기본 메서드

- default 키워드 사용
```
default void description() {
	System.out.println("정수 계산기를 구현합니다.");
	myMethod();
}
```
- 구현 하는 클래스에서 재정의 할 수 있음
```
@Override
public void description() {
	System.out.println("CompleteCalc에서 재정의한 default 메서드");
	//super.description();
}
```

- 인터페이스를 구현한 클래스의 인스턴스가 생성 되어야 사용 가능함



## 정적 메서드 (자바 8이후)

- 인스턴스 생성과 상관 없이 인터페이스 타입으로 사용할 수 있는 메서드
```
static int total(int[] arr) {
	int total = 0;
		
	for(int i: arr) {
		total += i;
	}
	mystaticMethod();
	return total;
}
```

## private 메서드 (자바 9이후)

- 인터페이스를 구현한 클래스에서 사용하거나 재정의 할 수 없음

- 인터페이스 내부에서만 사용하기 위해 구현하는 메서드

- default 메서드나 static 메서드에서 사용함

```
private void myMethod() {
	System.out.println("private method");
}
	
private static void mystaticMethod() {
	System.out.println("private static method");
}
```

# 15. 여러 인터페이스 구현하기, 인터페이스의 상속

## 여러 인터페이스 구현

- 자바의 인터페이스는 구현 코드가 없으므로 하나의 클래스가 여러 인터페이스는 구현 할 수 있음

- 디폴트 메서드가 중복 되는 경우는 구현 하는 클래스에서 재정의 하여야 함

- 여러 인터페이스를 구현한 클래스는 인터페이스 타입으로 형 변환 되는 경우 해당 인터페이스에 선언된 메서드만 사용 가능 함


![multi](./img/multi.png)


Sell.java
```
public interface Sell {

	void sell();
	
	
}
```

Buy.java
```
public interface Buy {

	void buy();

}
```

Customer.java
```
public class Customer implements Buy, Sell{

	@Override
	public void sell() {
		System.out.println("customer sell");
	}

	@Override
	public void buy() {
		System.out.println("customer buy");		
	}

	public void sayHello() {
		System.out.println("Hello");
	}
}
```
CustomerTest.java
```
public class CustomerTest {

	public static void main(String[] args) {

		Customer customer = new Customer();
		customer.buy();
		customer.sell();
		customer.sayHello();
		
		Buy buyer = customer;
		buyer.buy();
		
		Sell seller = customer;
		seller.sell();

	}
}
```

## 디폴트 메서드가 중복 되는 경우

- 구현 코드를 가지고 인스턴스 생성된 경우만 호출되는 디폴트 메서드의 경우 두 개의 인터페이스에서 중복되면 구현하는 클래스에서 반드시 재정의를 해야 함

Sell.java
```
public interface Sell {

	void sell();
	
	default void order() {
		System.out.println("판매 주문");
	}
}
```

Buy.java
```
public interface Buy {

	void buy();

	default void order() {
		System.out.println("구매 주문");
	}
}
```

Customer.java
```
public class Customer implements Buy, Sell{

	@Override
	public void sell() {
		System.out.println("customer sell");
	}

	@Override
	public void buy() {
		System.out.println("customer buy");		
	}

	public void sayHello() {
		System.out.println("Hello");
	}

	@Override
	public void order() {
		System.out.println("customer order");
	}

}
```
CustomerTest.java
```
public class CustomerTest {

	public static void main(String[] args) {

		Customer customer = new Customer();
		customer.buy();
		customer.sell();
		customer.sayHello();
		
		Buy buyer = customer;
		buyer.buy();
		
		Sell seller = customer;
		seller.sell();
	
		buyer.order();
		seller.order();
	
	}
}
```



## 인터페이스의 상속

- 인터페이스 사이에도 상속을 사용할 수 있음

- extends 키워드를 사용

- 인터페이스는 다중 상속이 가능하고 구현 코드의 상속이 아니므로 타입 상속 이라고 함

![inheritance](./img/inheritance.png)

X.java
```
public interface X {

	void x();
}
```

Y.java
```
public interface Y {

	void y();
}
```

MyInterface.java
```
public interface MyInterface extends X, Y{

	void myMethod();
}
```

MyClass.java
```
public class MyClass implements MyInterface{

	@Override
	public void x() {
		System.out.println("x()");
	}

	@Override
	public void y() {
		System.out.println("y()");		
	}

	@Override
	public void myMethod() {
		System.out.println("myMethod()");		
	}
}
```

MyClassTest.java
```
public class MyClassTest {

	public static void main(String[] args) {

		MyClass mClass = new MyClass();
		
		X xClass = mClass;
		xClass.x();
		
		
		Y yClass = mClass;
		yClass.y();
		
		MyClass iClass = mClass;
		iClass.x();
		iClass.y();
		iClass.myMethod();
	}

}
```

## 클래스 상속과 인터페이스 구현 함께 쓰기

- 실무에서 프레임워크나 오픈소스와 함께 연동되는 구현을 하게 되면 클래스 상속과 인터페이스의 구현을 같이 사용하는 경우가 많음

![book](./img/book.png)

- 책이 순서대로 대여가 되는 도서관 구현

- 책을 보관하는 자료 구조가 Shelf에 구현됨 (ArrayList)

- Queue 인터페이스를 구현함

- Shelf 클래스를 상속 받고 Queue를 구현한다.

Shelf.java
```
public class Shelf {

	 protected ArrayList<String> shelf;
	 
	 public Shelf() {
		 shelf = new ArrayList<String>();
	 }
	 
	 public ArrayList<String> getShelf(){
		 return shelf;
	 }
	 
	 public int getCount() {
		 return shelf.size();
	 }
	 
}
```

Queue.java
```
public interface Queue {

	void enQueue(String title);
	String deQueue();
	
	int getSize();
}
```

BookShelf.java
```
public class BookShelf extends Shelf implements Queue{

	@Override
	public void enQueue(String title) {
		shelf.add(title);
	}

	@Override
	public String deQueue() {
		return shelf.remove(0);
	}

	@Override
	public int getSize() {
		return getCount();
	}

}
```

BookShelfTest.java
```
public class BookShelfTest {

	public static void main(String[] args) {

		Queue bookQueue = new BookShelf();
		bookQueue.enQueue("태백산맥1");
		bookQueue.enQueue("태백산맥2");
		bookQueue.enQueue("태백산맥3");
		
		System.out.println(bookQueue.deQueue());
		System.out.println(bookQueue.deQueue());
		System.out.println(bookQueue.deQueue());
	}

}
```

![bookshelf](./img/bookshelf.png)