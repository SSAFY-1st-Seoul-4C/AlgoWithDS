# Merge Sorting
##### Author: Yoonjin Park
##### Date: 190326

## Key Idea
1) Divide and Conquer
2) Divide in half
3) sort each partitioned parts
4) combine two parts


## More
* 재귀 

## Pseudo Code
```
mergeSort(list, left, right)
	if left<right
		mid = (left+right)/2
		mergeSort(list, left, mid)
		mergeSort(list, med+1, right)
		merge(list,left,mid,right)
	end	
end

merge(list, left, mid, right)
	compare list[left:mid] and list[mid+1:right] and save it orderly in a new array
	
	put the ordered value back into list[left:right]
end

```
## Time/Space Complexity
| Best | Average | Worst | Space 
|--------|--------|--------|--------|
| $$$\Omega(nlogn)$$$ |$$$\Theta(nlogn)$$$| $$$O(nlogn)$$$|$$$O(n)$$$|


## Question
1. Quick Sort 와 다른 점은?
==merge sort는 정확히 반으로 나누고 sorting을 수행하고 quick sort는 비균형적인 pivot을 선택하여 pivot의 위치를 찾는 방법으로 sorting한다 ==

2. Quick Sort와 비교했을 때, 평균적으로 어느 것이 나은가?
== ==

#### Reference
[Toptal Sort](https://www.toptal.com/developers/sorting-algorithms/)
[퀵정렬(quick sort)이란](https://gmlwjd9405.github.io/2018/05/10/algorithm-quick-sort.html)