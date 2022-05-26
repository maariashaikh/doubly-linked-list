public class DoublyLinkedListMain {
    public static void main (String[] args){
        try{
            int[] numbers = {2, 3, 5, 7, 11, 13, 17};
            DoublyLinkedList list = Utility.arrayToList(numbers);
            System.out.println("Following is the list : " + list);
            // Found
            int existingvalue = 5; // tested 2,3,5,17
            if(Utility.isFound(list, existingvalue)){
                System.out.println(existingvalue + " exists in the list.");
            }
            // Not found
            int nonExistingvalue = 10;
            if(!Utility.isFound(list, nonExistingvalue)){
                System.out.println(nonExistingvalue + " does not exist in the list.");
            }
        }catch(IndexOutOfBoundsException iobe){
            System.out.println("MainApplication.main() : Could not proceed with the application : The program has issues with accessing array elements." + iobe);
        }
    }
    
}