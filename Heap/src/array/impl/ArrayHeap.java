package array.impl;

// MinHeap
// TODO : debug 0 and fix
public class ArrayHeap {
	
	public static void main(String[] args) {
		int [] arr = {1,5,2,7,3,9,4, 10, 15, 11, 19, 21,13, 12};
		
		ArrayHeap minHeap = new ArrayHeap();
		
		for(int i: arr){
			minHeap.print();
			minHeap.insert(i);
		}
		
		//minHeap.print();
		
		while(minHeap.size() > 0){
			System.out.println(minHeap.deleteMin());
		}
	}
	
	int [] arr = new int[10];
	int size = 0;
	
	public ArrayHeap(){}// constructor
	
	public int size(){
		return this.size;
	}
	public void insert(int elem){
		if(size == arr.length) sizeDouble();
		arr[ size++ ] = elem;
		
		int i=size;
		for(i=size; i>1; ){
			if(arr[i-1] <= arr[i/2 -1]){
				arr[i-1] = arr[i/2 -1 ];
				i = i/2;
			}else break;
		}
		arr[i-1] = elem;
	}
	
	public int deleteMin(){
		int ans = arr[0];
		
		arr[0] = arr[size-1];
		
		int leftChild, rightChild;
		
		for(int i=1; 2*i<=size;){
			leftChild = 2*i;
			rightChild = 2*i +1;
			if(arr[leftChild-1] < arr[rightChild-1] ){
				if(arr[i-1] > arr[leftChild-1]){//swap
					arr[i-1] = arr[leftChild-1];
					arr[leftChild-1] = arr[size-1];
					i = leftChild;
				}else break;
			}else{
				if(arr[i-1] > arr[rightChild-1]){//swap
					arr[i-1] = arr[rightChild-1];
					arr[rightChild-1] = arr[size-1];
					i=rightChild;
				} else break;
			}
		}
		
		size--;
		
		return ans;
	}
	
	public void sizeDouble(){
		int[] arr2 = new int[arr.length * 2]; 
		
		for(int i=0; i<arr.length; i++){
			arr2[i] = arr[i];
		}
		
		arr = arr2;
	}
	
	public void print(){
		if(size == 0) {
			System.out.println("[]");
			return;
		}
		for(int i=1; i<size; i++){
			System.out.print(arr[i-1] + ", ");
		}
		System.out.println(arr[size-1]);
	}

}
