# Selection Sorting
##### Author: Yoonjin Park
##### Date: 190326

## Key Idea
1) find the smallest
2) comparing with one index with the rest of others

## Pseudo Code
```
for i=1:n,
	int idx=i
	for j=i+1:n
		if a[idx]>a[j]
		 swap(idx,j)
		 idx=j
	end
end
```
## Time/Space Complexity
| Best | Average | Worst | Space 
|--------|--------|--------|--------|
| $$$\Omega(n^2)$$$ |$$$\Theta(n^2)$$$| $$$O(n^2)$$$|$$$O(1)$$$|


## Question

#### Reference
[Toptal Sort](https://www.toptal.com/developers/sorting-algorithms/)