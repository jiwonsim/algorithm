# Python List 



## List Time Complexity 

![image-20211129235122410](/Users/simjiwon/Library/Application Support/typora-user-images/image-20211129235122410.png)

## List Slicing Performance

파이썬의 문자열 슬라이싱은 내부적으로 C로 매우 빠르게 구현되어 있어 좋은 성능을 보인다. 하지만 문자열이 아닌 다른 타입의 리스트를 슬라이싱하는 경우에는 전체적으로 낮은 성능을 낸다. 

파이썬에서 리스트를 뒤집는 방법은 슬라이싱 기법과 reversed() 메소드를 이용하는 것인데, 두 방법 간의 성능에는 약간의 차이가 있다. 

```python
>>> lis = range(10)
>>> lis[::-1]
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
>>> reversed(lis)
<listreverseiterator object at 0x909dd0c>
```

reversed 는 iterator 를 반환하기 때문에 slicing 이 전체 리스트를 반환하는 동안에 이미 반환이 끝나버린다.