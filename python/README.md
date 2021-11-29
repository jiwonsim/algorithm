# List and Deque 



## Time Complexity of List  

![image-20211129235122410](/Users/simjiwon/Library/Application Support/typora-user-images/image-20211129235122410.png)



## Time Complexity of Deque 

![image-20211130001427533](/Users/simjiwon/Library/Application Support/typora-user-images/image-20211130001427533.png)



Python에서 List는 pop()과 pop(0)을 가지고 있기 때문에 Deque와 같은 역할을 하는 것처럼 보인다. 하지만 Deque는 Double-ended 형태로 양 끝에 접근하는 것이 굉장히 빠르게 동작하여 pop(), popleft(), append(), appendleft()는 O(1)밖에 소요되지 않는다. 하지만 List의 insert(k), pop(0)을 하게 됐을 땐 리스트의 메모리를 재할당해야 하기 때문에 O(n)가 걸리게 된다. 그렇다면 어떻게 List의 append()는 O(1)이 걸리게 되는 것일까? 이것도 리스트의 메모리를 재할당해야 하는 것이 아닐까? 

알고리즘 성능에는 **분할 상환 분석(amortized analysis)**를 이용하여 **고비용을 일정 기간으로 분산시켜 성능을 평가** 한다. 대표적인 예로 동적 배열이 있다. 8개의 요소를 넣을 수 있는 배열이 있고, 배열이 가득차면 공간을 두 배로 할당 받아서 기존 요소를 옮긴 후에 더 많은 요소를 추가할 수 있다고 가정하자. 배열에 새로운 요소를 추가하는 시간 복잡도는 O(1)이다. 배열에 요소가 가득 차기 전에 배열은 16개로 크기를 늘린다. 이때는 O(n)이 걸린다. 그리고 새로운 요소들은 계속 추가가 되다가 16개를 넘기 전에 배열은 O(n)의 시간을 지나 다시 크기를 늘려 32개를 수용할 수 있게 된다. 이를 계속 반복하게 되면, 배열의 크기를 키우는 것은 고비용의 연산이 필요하지만 새로운 값을 추가하는 것은 비용이 거의 들지 않기 때문에, 이를 분산하면 성능은 상수 시간과 비슷하게 된다. 이를 분할 상환 분석 기법이라고 하며, 알고리즘 전체를 보지 않고 최악의 경우만을 고려한 기존의 방법과는 차이가 있다. 따라서 동적 배열을 사용하는 파이썬에서는 append()는 O(1)이 걸린다고 할 수 있다. 

위의 내용을 정리하게 되면, list와 deque의 차이는 deque.popleft(), deque.appendleft()와 list.pop(0), list.insert(k)에서 성능 차이를 보이는 것이다. 이 말인 즉슨, deque와 list를 stack처럼 사용하게 되면 거의 비슷한 성능을 내지만, queue로 이용하게 된다면 deque가 list보다 훨씬 빠르게 동작할 수 있다는 것을 의미한다. deque가 무조건 더 빠르다고 볼 수는 없는 것이다. 

