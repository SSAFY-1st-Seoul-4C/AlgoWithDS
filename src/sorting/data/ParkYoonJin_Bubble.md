# Bubble Sorting
##### Author: Yoonjin Park
##### Date: 190326

## Key Idea
1) Finding the smalles/biggest number per iteration 2) By comparing with the number rigth next to it 
3) Swapping two adjacent numbers (Ordering in a minimal way) -> Like dragging the number

## Pseudo Code
```
for i=1:n, // poiting index(position) to be saved in
	isSwapped = false
	for j=n:i+1, //pointing smalles number
    	if a[j] < a[j-1],
        	swap(j, j-1)
            isSwapped = true
         end
     end
     break if not swapped // in a good order
end
```
## Time/Space Complexity
| Best | Average | Worst | Space 
|--------|--------|--------|--------|
| $$$\Omega(n)$$$ |$$$\Theta(n^2)$$$| $$$O(n^2)$$$|$$$O(1)$$$|

Best Time Complexity $$$\Omega(n)$$$: 모든 것이 이미 정렬된 상태일 때, isSwapped=true가 되는 경우 없이 sorting 종료 (n+etc>=n)
Average Time Complexity $$$\Theta(n^2)$$$: 2중 loop이 실행됨
Worst Time Complexity $$$O(n^2)$$$ : 2중 loop이 끝까지 실행됨
$$ n+(n-1)+(n-2)+...+1 = n*(n-1)/2 < n^2 $$ 



## Question
1. 둘째 for loop이 첫째 for loop의 인자부터 내림차순으로 도는 이유는?
==둘째 for loop에서 찾은 가장 작은 수를 저장할 index를 따로 변수에 담지 않아도 되어서 더 깔끔한 코드가 되기 때문에==

2. Bubble Sort가 실제 사용되는 사례는?
==잘 사용이 안 됨==

#### Reference
[Toptal Bubble Sort](https://www.toptal.com/developers/sorting-algorithms/bubble-sort)
