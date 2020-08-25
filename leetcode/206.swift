class Solution {
    
    func reverseList(_ head: ListNode?) -> ListNode? {
        
        var prev: ListNode? = nil
        var curr: ListNode? = head
        
        while curr != nil {
            let next: ListNode? = curr?.next
            
            curr?.next = prev
            prev = curr
            curr = next
        }
        return prev
    }
}
