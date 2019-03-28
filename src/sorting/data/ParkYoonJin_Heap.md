# Heap Sorting
##### Author: Yoonjin Park
##### Date: 190326

## Key Idea
1) Using Heap
2) Heap automatically sorts 


## Pseudo Code
```
class Heap
	int[] list;
	int cnt
	
	void add(int x)
		add to the last and go up
	end
	
	int delete()
		return the first 
		
		swap with the last node
		
		rearrange from the start
	end
end
```

## Time/Space Complexity
| Best | Average | Worst | Space(Worst) 
|--------|--------|--------|--------|
| $$$\Omega(nlogn)$$$ |$$$\Theta(nlogn)$$$| $$$O(nlogn)$$$|$$$O()$$$|


## Question
1. 왜 Heap sort는 unstable 한가?


#### Reference
[Toptal Sort](https://www.toptal.com/developers/sorting-algorithms/)
[힙 정렬(heap sort)이란](https://gmlwjd9405.github.io/2018/05/10/algorithm-heap-sort.html**)