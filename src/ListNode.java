public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString(){
        StringBuffer str = null;
        while (null != next){
            str.append(String.valueOf(val));
            next = next.next;
        }
        return str.toString();
    }
}