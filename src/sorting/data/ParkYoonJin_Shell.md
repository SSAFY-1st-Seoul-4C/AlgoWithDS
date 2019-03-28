# Shell Sorting
##### Author: Yoonjin Park
##### Date: 190326

## Key Idea
 Upgraded from Insertion Sort
 1) gap : distance between two target numbers
 2) gap diminishes from size/2 to 1

## Pseudo Code
```
for gap=n/2:gap/2:1,
	make gap odd number
	
	do insertion sort with the gap
end

insertion_sort:
for i=1:1:n-1,
	if list[n+gap] is smaller than list[n],
		find the appropriate spot 
	
	end
end
end
```

## Time/Space Complexity
| Best | Average | Worst | Space(Worst) 
|--------|--------|--------|--------|
| $$$\Omega(nlogn)$$$ |$$$\Theta(nlogn)$$$| $$$O(nlogn)$$$|$$$O()$$$|


## Question
1. Insertion Sort와 비교하여 Shell Sort의  장점은?
2. gap은 왜 홀수가 되어야 하는가?


#### Reference
[Toptal Sort](https://www.toptal.com/developers/sorting-algorithms/)
[쉘 정렬(shell sort)이란](https://gmlwjd9405.github.io/2018/05/08/algorithm-shell-sort.html)
[Shell Sort Animation](https://www.youtube.com/watch?v=WbbyrrbbWTU)