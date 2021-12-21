# 14장 | 점진적인 개선

깨끗하고 우아한 프로그램을 한 방에 뚝딱 내놓을 수 없다. 프로그래밍은 과학보다 공예에 가깝다.  
깨끗한 코드를 짜려면 먼저 지저분한 코드를 **짠 뒤에 정리해야 한다**.

먼저 1차 초안을 쓰고, 그 초안을 고쳐 2차 초안을 만들고, 계속 고쳐 최종안을 만들어야 한다.  
깔끔한 작품을 내놓으려면 단계적으로 개선해야 한다.

대다수 신참 프로그래머는 (대다수 초딩과 마찬가지로) 이 충고를 충실히 따르지 않는다.  
그들은 무조건 돌아가는 프로그램을 목표로 잡는다. 일단 프로그램이 '돌아가면' 다음 업무로 넘어간다.  
경험이 풍부한 전문 프로그래머라면 이런 행동이 전문가로서 자살 행위라는 사실을 안다.

##

### 📃 유틸리티 Args

프로그램을 짜다보면 종종 명령행 인수의 구문ㅇ르 분석할 필요가 생긴다. 편리한 유틸리티가 없다면 main 함수로 넘어오는 문자열 배열을 직접 분석하게 된다. 새로짠 유틸리티를 Args라 부르겠다.

##

### 📃 간단한 Args 사용법

Args 생성자에 입력으로 들어온 인수 문자열과 형식 문자열을 넘겨 Args 인스턴스를 생성한 후 Args 인스턴스에다 인수 값을 질의한다.

```java
public static void main(String[] args) {
	try {
		Args arg = new Args("l,p#,d*", args);
		boolean logging = arg.getBoolean('l');
		int port = arg.getInt('p');
		String directory = arg.getString('d');
		executeAppliocation(logging, port, directory);
	} catch (ArgsException e) {
		System.out.printf("Argument error: %s\n", e.errorMessage());
	}
}
```

Args 클래스의 첫째 매개변수는 형식 또는 스키마를 지정한다. 이 문자열은 명령행 인수 세 개를 정의한다.  
첫 번째 -l은 부울 인수다. 두 번째 -p는 정수 인수다. 세 번째 -d는 answkduf dlstnek.   
Args 생성자로 넘긴 둘째 매개변수는 main으로 넘어온 명령행 인수 배열 자체다.

생성자에서 ArgsException이 발생하지 않으면 명령행 인수의 구문을 성공적으로 분석했으며 Args 인스턴스에 질의를 던져도 좋다. 인수 값을 가져오려면 `getBoolean`, `getInteger`, `getString` 등을 이용한다.  
형식 문자열이나 명령행 인수 자체에 문제가 있다면 ArgsException이 발생한다.

##

### 📃 Args 구현

```java
import static com.objectmentor.utilities.args.ArgsException.ErrorCode.*;

public class Args {
	private Map<Character, ArgumentMarshaler> marshalers;
	private Set<Character> argsFound;
	private ListIterator<String> currentArgument;

	public Args(String schema, String[] args) throws ArgsException {
		marshalers = new HashMap<Character, ArgumentMarshaler>();
		argsFound = new HashSet<Character>();
    
    parseSchema(schema);
    parseArgumentStrings(Arrays.asList(args)); 
  }
  
  private void parseSchema(String schema) throws ArgsException { 
    for (String element : schema.split(","))
      if (element.length() > 0) 
        parseSchemaElement(element.trim());
  }
  
  private void parseSchemaElement(String element) throws ArgsException { 
    char elementId = element.charAt(0);
    String elementTail = element.substring(1); validateSchemaElementId(elementId);
    if (elementTail.length() == 0)
      marshalers.put(elementId, new BooleanArgumentMarshaler());
    else if (elementTail.equals("*")) 
      marshalers.put(elementId, new StringArgumentMarshaler());
    else if (elementTail.equals("#"))
      marshalers.put(elementId, new IntegerArgumentMarshaler());
    else if (elementTail.equals("##")) 
      marshalers.put(elementId, new DoubleArgumentMarshaler());
else if (elementTail.equals("[*]"))
      marshalers.put(elementId, new StringArrayArgumentMarshaler());
    else
      throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId, elementTail);
  }
  
  private void validateSchemaElementId(char elementId) throws ArgsException { 
    if (!Character.isLetter(elementId))
      throw new ArgsException(INVALID_ARGUMENT_NAME, elementId, null); 
  }
  
  private void parseArgumentStrings(List<String> argsList) throws ArgsException {
    for (currentArgument = argsList.listIterator(); currentArgument.hasNext();) {
      String argString = currentArgument.next(); 
      if (argString.startsWith("-")) {
        parseArgumentCharacters(argString.substring(1)); 
      } else {
        currentArgument.previous();
        break; 
      }
    } 
  }
  
  private void parseArgumentCharacters(String argChars) throws ArgsException { 
    for (int i = 0; i < argChars.length(); i++)
      parseArgumentCharacter(argChars.charAt(i)); 
  }
  
  private void parseArgumentCharacter(char argChar) throws ArgsException { 
    ArgumentMarshaler m = marshalers.get(argChar);
    if (m == null) {
      throw new ArgsException(UNEXPECTED_ARGUMENT, argChar, null); 
    } else {
      argsFound.add(argChar); 
      try {
        m.set(currentArgument); 
      } catch (ArgsException e) {
        e.setErrorArgumentId(argChar);
        throw e; 
      }
    } 
  }
  
  public boolean has(char arg) { 
    return argsFound.contains(arg);
  }
  
  public int nextArgument() {
    return currentArgument.nextIndex();
  }
  
  public boolean getBoolean(char arg) {
    return BooleanArgumentMarshaler.getValue(marshalers.get(arg));
  }
  
  public String getString(char arg) {
    return StringArgumentMarshaler.getValue(marshalers.get(arg));
  }
  
  public int getInt(char arg) {
    return IntegerArgumentMarshaler.getValue(marshalers.get(arg));
  }
  
  public double getDouble(char arg) {
    return DoubleArgumentMarshaler.getValue(marshalers.get(arg));
  }
  
  public String[] getStringArray(char arg) {
    return StringArrayArgumentMarshaler.getValue(marshalers.get(arg));
  } 
}
```

여기저기 뒤적일 필요 없이 위에서 아래로 코드가 읽힌다.  
주의 깊게 읽었다면 ArgumentMarshaler 인터페이스가 무엇이며 파생 클래스가 무슨 기능을 하는지 안다.

##

```java
public interface ArgumentMarshaler {
  void set(Iterator<String> currentArgument) throws ArgsException;
}
```

```java
public class BooleanArgumentMarshaler implements ArgumentMarshaler { 
  private boolean booleanValue = false;
  
  public void set(Iterator<String> currentArgument) throws ArgsException { 
    booleanValue = true;
  }
  
  public static boolean getValue(ArgumentMarshaler am) {
    if (am != null && am instanceof BooleanArgumentMarshaler)
      return ((BooleanArgumentMarshaler) am).booleanValue; 
    else
      return false; 
  }
}

public class StringArgumentMarshaler implements ArgumentMarshaler { 
  private String stringValue = "";
  
  public void set(Iterator<String> currentArgument) throws ArgsException { 
    try {
      stringValue = currentArgument.next(); 
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_STRING); 
    }
  }
  
  public static String getValue(ArgumentMarshaler am) {
    if (am != null && am instanceof StringArgumentMarshaler)
      return ((StringArgumentMarshaler) am).stringValue; 
    else
      return ""; 
  }
}

public class IntegerArgumentMarshaler implements ArgumentMarshaler { 
  private int intValue = 0;
  
  public void set(Iterator<String> currentArgument) throws ArgsException { 
    String parameter = null;
    try {
      parameter = currentArgument.next();
      intValue = Integer.parseInt(parameter);
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_INTEGER);
    } catch (NumberFormatException e) {
      throw new ArgsException(INVALID_INTEGER, parameter); 
    }
  }
  
  public static int getValue(ArgumentMarshaler am) {
    if (am != null && am instanceof IntegerArgumentMarshaler)
      return ((IntegerArgumentMarshaler) am).intValue; 
    else
    return 0; 
  }
}
```

##

오류코드 상수를 정의하는 부분

```java
import static com.objectmentor.utilities.args.ArgsException.ErrorCode.*;

public class ArgsException extends Exception { 
  private char errorArgumentId = '\0'; 
  private String errorParameter = null; 
  private ErrorCode errorCode = OK;
  
  public ArgsException() {}
  
  public ArgsException(String message) {super(message);}
  
  public ArgsException(ErrorCode errorCode) { 
    this.errorCode = errorCode;
  }
  
  public ArgsException(ErrorCode errorCode, String errorParameter) { 
    this.errorCode = errorCode;
    this.errorParameter = errorParameter;
  }
  
  public ArgsException(ErrorCode errorCode, char errorArgumentId, String errorParameter) {
    this.errorCode = errorCode; 
    this.errorParameter = errorParameter; 
    this.errorArgumentId = errorArgumentId;
  }
  
  public char getErrorArgumentId() { 
    return errorArgumentId;
  }
  
  public void setErrorArgumentId(char errorArgumentId) { 
    this.errorArgumentId = errorArgumentId;
  }
  
  public String getErrorParameter() { 
    return errorParameter;
  }
  
  public void setErrorParameter(String errorParameter) { 
    this.errorParameter = errorParameter;
  }
  
  public ErrorCode getErrorCode() { 
    return errorCode;
  }
  
  public void setErrorCode(ErrorCode errorCode) { 
    this.errorCode = errorCode;
  }
  
  public String errorMessage() { 
    switch (errorCode) {
      case OK:
        return "TILT: Should not get here.";
      case UNEXPECTED_ARGUMENT:
        return String.format("Argument -%c unexpected.", errorArgumentId);
      case MISSING_STRING:
        return String.format("Could not find string parameter for -%c.", errorArgumentId);
      case INVALID_INTEGER:
        return String.format("Argument -%c expects an integer but was '%s'.", errorArgumentId, errorParameter);
      case MISSING_INTEGER:
        return String.format("Could not find integer parameter for -%c.", errorArgumentId);
      case INVALID_DOUBLE:
        return String.format("Argument -%c expects a double but was '%s'.", errorArgumentId, errorParameter);
      case MISSING_DOUBLE:
        return String.format("Could not find double parameter for -%c.", errorArgumentId); 
      case INVALID_ARGUMENT_NAME:
        return String.format("'%c' is not a valid argument name.", errorArgumentId);
      case INVALID_ARGUMENT_FORMAT:
        return String.format("'%s' is not a valid argument format.", errorParameter);
    }
    return ""; 
  }
  
  public enum ErrorCode {
    OK, INVALID_ARGUMENT_FORMAT, UNEXPECTED_ARGUMENT, INVALID_ARGUMENT_NAME, 
    MISSING_STRING, MISSING_INTEGER, INVALID_INTEGER, MISSING_DOUBLE, INVALID_DOUBLE
  }
}
```
이름을 붙인 방법, 함수 크기, 코드 형식에 각별히 주목해 읽어보길 바란다.

예를 들어, 날짜 인수나 복소수 인수 등 새로운 인수 유형을 추가하는 방법이 명백하다. 고칠 코드도 별로 없다.  
ArgumentMarshaler에서 새 클래스를 파생해 getXXX 함수를 추가한 후 parseSchemaElement 함수에 새 case 문만 추가하면 끝이다.

##

### 📃 점진적으로 개선하다

프로그램을 망치는 가장 좋은 방법 중 하나는 개선이라는 이름 아래 구조를 크게 뒤집는 행위다.  
어떤 프로그램은 그저 그런 '개선'에서 결코 회복하지 못한다.

그래서 테스트 주도 개발(*Test-Driven Development, TDD*) 기법을 사용한다.  
TDD는 언제 어느 때라도 시스템이 돌아가야 한다는 원칙을 따른다.  
TDD는 시스템을 망가뜨리는 변경을 허용하지 않는다.  
변경을 가한 후에도 시스템이 변경 전과 똑같이 돌아가야 한다는 말이다.

변경 전 후에 시스템이 똑같이 돌아간다는 사실을 확인하려면 언제든 실행이 가능한 자동화된 테스트 슈트가 필요하다.

##

### 📃 결론

그저 돌아가는 코드만으로는 부족하다. 돌아가는 코드가 심하게 망가지는 사례는 흔하다.  
단순히 돌아가는 코드에 만족하는 프로그래머는 전문가 정신이 부족하다.  
나쁜 코드보다 더 오랫동안 더 심각하게 개발 프로젝트에 악영향을 미치는 요인도 없다.

나쁜 코드를 깨끗한 코드로 개선하려면 비용이 엄청나게 많이 든다.  
오래된 의존성을 찾아내 깨려면 상당한 시간과 인내심이 필요하다.  
반면 처음부터 코드를 깨끗하게 유지하기란 상대적으로 쉽다. 아침에 엉망으로 만든 코드를 오후에 정리하기는 어렵지 않다. 더욱이 5분 전에 엉망으로 만든 코드는 지금 당장 정리하기 아주 쉽다.

그러므로 코드는 언제나 최대한 깔끔하고 단순하게 정리해야 한다.