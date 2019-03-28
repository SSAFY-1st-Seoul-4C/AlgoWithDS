# Insertion Sorting
##### Author: Yoonjin Park
##### Date: 190326

## Key Idea
1) Divide and Conquer
Divide : start from the small section and sort 
Conqueuer : find the right place for next input number

## Pseudo Code
```
for i=2:n, // poiting index(position) to be saved in
	int j=i;
	while(j>=i && a[j] < a[j-1])
        swap(j, j-1)
		j-=1
     end
end
```
## Time/Space Complexity
| Best | Average | Worst | Space 
|--------|--------|--------|--------|
| $$$\Omega(n)$$$ |$$$\Theta(n^2)$$$| $$$O(n^2)$$$|$$$O(1)$$$|

Best Time Complexity $$$\Omega(n)$$$: 모든 것이 이미 정렬된 상태일 때, 둘째 loop가 실행되지 않는다
Average Time Complexity $$$\Theta(n^2)$$$: 2중 loop이 실행이 되지만 full로 돌지는 않을 수도 있다
Worst Time Complexity $$$O(n^2)$$$ : 2중 loop이 끝까지 실행됨
ex) 5 4 3 2 1 을 오름차순으로 정렬
$$ n+(n-1)+(n-2)+...+1 = n*(n-1)/2 < n^2 $$ 




## Question
1. Bubble Sort와 비교했을 때, 장점은?
==Worst Scenario에서 Insertion Sort가 조금 더 연산량이 적을 수 있다== 

#### Reference
[Toptal Insertion Sort](https://www.toptal.com/developers/sorting-algorithms/insertion-sort)