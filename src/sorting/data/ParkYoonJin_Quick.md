# Quick Sorting
##### Author: Yoonjin Park
##### Date: 190326

## Key Idea
1) Divide and Conquer
2) partition 
3) Smaller numbers on the left side of the pivot and vice versa

## More
* 재귀 

## Pseudo Code
```
quicksort(list, left, right){
	if lef>= right 
	 	return

	pi = partition(list, left, right)
 
	quicksort(array, left, pi-1)
	quicksort(arraym pi+1, right)
}

//returns rightful pivot index
partition(list, left, right){
	set pivot as the most left
	
	compare from pivot+1 to rightmost and move it near the pivot if it is less than list[pivot] 
		increase the storing index
	
	move pivot to the last storing place
}



```
## Time/Space Complexity
| Best | Average | Worst | Space 
|--------|--------|--------|--------|
| $$$\Omega(nlogn)$$$ |$$$\Theta(nlogn)$$$| $$$O(n^2)$$$|$$$$$$|


## Improvement
pivot Idx를 중간 Idx로 하면 최악인 경우를 피할 수 있음

## Question

#### Reference
[Toptal Sort](https://www.toptal.com/developers/sorting-algorithms/)
[Quick Sort Animation](http://www.cs.armstrong.edu/liang/animation/web/QuickSortPartition.html)