package AlgoExpert;

class SumOfLinkedLists {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedListsSolution(
            LinkedList linkedListOne, LinkedList linkedListTwo
    ) {

        int sum = sumOfLinkedList(getReverseLinkedList(linkedListOne))
                + sumOfLinkedList(getReverseLinkedList(linkedListTwo));
        LinkedList sumOfLists = new LinkedList(sum%10);
        sum /= 10;
        LinkedList temp = sumOfLists;
        while(sum > 0) {
            temp.next = new LinkedList(sum%10);
            sum /= 10;
            temp = temp.next;
        }
        return sumOfLists;
    }
    public static int sumOfLinkedList(LinkedList head) {
        int sum = 0;
        while(head.next != null) {
            sum += head.value;
            sum *= 10;
            head = head.next;
        }
        sum += head.value;
        return sum;
    }
    public static LinkedList getReverseLinkedList(LinkedList head) {
        LinkedList reverseLinkedList = null;
        while(head != null) {
            LinkedList newNode = head;
            head = head.next;
            newNode.next = null;

            newNode.next = reverseLinkedList;
            reverseLinkedList = newNode;
        }
        return reverseLinkedList;
    }
}

