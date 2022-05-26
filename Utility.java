public class Utility {
    
    private static DoublyLinkedList.Node getNode(DoublyLinkedList list, int i) throws NullPointerException {
        DoublyLinkedList.Node p ;
        if (i < list.getSize() / 2) {
            p = list.getHeader().getNext();
            for (int j = 0; j < i; j++)
                p = p.getNext();
        } else {
            p = list.getTrailer();
            for (int j = list.getSize(); j > i; j--)
                p = p.getPrev();
        }
        return p;
    }
    
    private static int binarySearch(DoublyLinkedList list, int searchValue, int start, int end) throws IllegalArgumentException{
            int middle = (start + end) / 2;
            if (list.isEmpty()) {
               System.out.println("Utility.binarySearch() : The list is empty, poplate the list first before doing search on it."); 
               throw new IllegalArgumentException() ;
            }
            if (start < 0 || end < 0 ) {
               System.out.println("Utility.binarySearch() : Check start and end indices. Both should be positive values."); 
               throw new IllegalArgumentException() ;
            }
            if (start > end){
               return -1;
            }
            try{
                int middleValue = (Integer) (getNode(list,middle).getElement());
                if (middleValue == searchValue) {
                        return middle;
                }
                if (middleValue > searchValue) {
                        return binarySearch(list, searchValue, start, middle - 1);
                }
                if (middleValue < searchValue) {
                        return binarySearch(list, searchValue, middle + 1, end);
                }
            }catch(NullPointerException npe){
                System.out.println("Utility.binarySearch() : Could not proceed with the search : make sure the related elements are not null." + npe);
            }
            return -1;
    }
    
    public static boolean isFound(DoublyLinkedList list, int searchValue) {
        int start = 0;
        int end = list.getSize();
        boolean found = false;   
        try{
            if(binarySearch( list,  searchValue,  start,  end) != -1){
                found = true;
            }
        }catch(Exception e){
            System.out.println("Utility.isFound() : Could not proceed with the search. Plesae fix issues.");
        }
        return found;
    }
    public static DoublyLinkedList arrayToList(int[] numbers) throws IndexOutOfBoundsException{
        DoublyLinkedList list = new DoublyLinkedList();
        for(int i = 0 ; i < numbers.length ; i ++){
            list.addlast(numbers[i]);
        }
        return list;
    }
    
}
