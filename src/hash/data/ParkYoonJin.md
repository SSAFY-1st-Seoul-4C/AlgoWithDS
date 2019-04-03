#Hash
##Hashing 정의
- to chop into small pieces([Merrian-Webseter](https://www.merriam-webster.com/dictionary/hash))
- 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑(정수형)
key <----hashing----> hash value

## Hash Table 특징
- many-to-one (collision 해결 필요)
- 적은 리소스로 많은 데이터 효율적 관리
- hash value 를 index 값으로 (O(1))
 


##Intro: Dictionary 구현 방법
1) Balanced Binary Search Tree : all operations (O(logn))
2) Doubly Linked List : Insert&Delete(O(n)), Search(O(n))
**3) Hash Table**
##Direct-address Table:Hash Table의 기초
Premise: 
1. 각 요소는 인덱스로 활용할 수 있는 key 를 가지고 있다
2. 다른 요소는 다른 Key 값을 가진다

Problem: 
1.  메모리의 한계로 모든 요소가 다른 key 값(Index)을 가지게 할 수 없다.즉, 한정된 메모리만 사용 가능 -> ***"Hash Table(Hash Func)"***
2. Hash Table 사용시, 다른 요소가 같은 키값을 가지는 경우 (***"Collision"***) -> ***"Chaining", "Open Addressing"***

Solution: Hash Table 
##Hash Table
Hash Collision 해결 방법
###1. Chaining: slot을 linked list로 구현하여 덧 붙이는 것
(Worst Case Scenario: only one slot is used)

| Insert | Delete | Search |
|--------|--------|--------|
| O(1)   |   O(1) | O(n)|
(Average Case Scenario, load factor = $$$\alpha$$$= n(# of elements)/m(number of slots))

| Insert | Delete | Search |
|--------|--------|--------|
| O(1)   |  O(1) | $$$\Theta(1+\alpha)$$$|
####Hash Function
Then, next to is how to implement good hash function to do efficient Search!
1. Division Method
> Hash Value = Key % M(# of slots)
M : prime number(usually)
2. Multiplication Method
>Hash Value = (Key\*A)%1 \* m
3. Universal Hashing
다수의 Hash Func을 만들어 무작위로 Hash Func 고르는 방법

Average case runtime analysis : Time for Successful Search
 
###2. Open Addressing
- No Linked List
- Fill up the Hash Table orderly
- Order depends on the hash value(key) -> **probe sequence** 

##### 저장 및 조회 방식 
1. Lineary Probing : h(k,i)=(h'(k)+i)%M
h'(k) 번 째 slot을 찾아서 확인 후 없으면 그 다음 slot으로 이동하여 빈 곳을 찾아 넣는 방식
Prob: 저장된 slot이 많으면 Search() 시간이 증가, 시작하는 곳에 cluster 생김
2. Quadratic Probing : h(k,i)=(h'(k)+c1\*i+c2\*i\*i)%M
3. Double Hashing : h(k,i) = (h1(k)+ih2(k))
두 개의 Hash func 사용

## API
Insert, Delete, Search (,Resize)
- Open Addressing의 경우, delete이 어렵기 때문에 chaining으로 Java는 구현하고 있으므로 Separate Chaining을 사용!
- Java 8 에서는 RedBlack Tree로 chaining 구현! 
$$$O(\alpha)->O(log\alpha)$$$

##Pseudo Code
- table 선언
- Add
hashval()

hash val가 없다면 새로 생성

hash val과 key값이 있으면 갱신

hash val은 있지만 key가 다르면 chain

- Delete
hashval()

해당 hash val의 key값을 찾아 지우기

- Search
hashval() 

해당 hash val의 key값 있으면 그 값 return

없으면 특정 값 return




## 응용
Cache L2 에 사용

##Reference 정리
[CSI Lecture(Jessica Su)]("DirectTableAddress_lecture9.pdf")
[Hash 알고리즘 요약 정리 테스트 알고리즘](https://hsp1116.tistory.com/35)
[Hash 구현](https://d2.naver.com/helloworld/831311)






`

