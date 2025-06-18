public class LinearSearch {

	public static void main(String[] args) {
		
		int nums[] = {58,2,35,1,43,19,4,96,53};
		int target = 19;
		String result = linearSearch(nums,target);
		System.out.println(result);
	}
	
	public static String linearSearch(int arr[],int target) {
		
		if(arr.length == 0) 
			return "Array does not have any element";
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == target) 
				return "The given element "+arr[i]+" is present at index "+i;
		}
		return "The given element is not found";
	}
}