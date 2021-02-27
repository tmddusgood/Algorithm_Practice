## ArrayList vs Array
### 일반적인 특징
* 들어가는 데이터의 수를 명확하게 특정할 수 있을 때: array
* 들어가는 데이터의 수를 명확하게 특정할 수 없을 때: ArrayList

### Case 1 (TC = 100,000)
노드 5개, 간선(edge)에 대한 정보 X
~~~
// Array
int[] array = new int[100000][100000]
// ArrayList
ArrayList arrayList = new ArrayList(100000)
for (int o : arrayList){
    o.add()
  }
~~~
* 10만의 경우
    * Array: 100000 * 100000 * 4byte = 40,000,000,000 byte (40GB)
    * ArrayList:
### Case 2
노드 5개, 간선(edge)에 대한 정보 O
~~~

~~~
* 들어가는 데이터의 수를 명확하게 특정할 수 있을 때
* 정점(노드)의 갯수는 아는데 edge의 갯수를 모른다면?