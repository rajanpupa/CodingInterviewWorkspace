# Array implementation of a Heap

* Left child is located at 2K index
* Right child is located at 2K+1 index
* The node's parent is located at K/2th index
* First elements index (K) is 1

#### Min Heap
* Every node is smaller than or equal to its children

#### Max Heap
* Every node is greater than or equal to its children

#### Operations

* Insert

Insert element at the end of the array, compare with parent and swap until the heap property is met.


* DeleteMin

Remove element from the root and replace with end of array. pre-colate down .

* HeadSort

- prepare Heap
- keepCalling deleteMin()
