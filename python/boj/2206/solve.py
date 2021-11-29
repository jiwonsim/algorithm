from typing import List, Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    
  front_pointer = [] 
  def recursive(self, head: Optional[ListNode]) -> bool:
    global front_pointer
    if head.next is None: # reach to the end 
      if head.val == front_pointer.val: 
        front_pointer = front_pointer.next 
        return True 
      return False 
    return self.recursive(head.next) 

  def isPalindrome(self, head: Optional[ListNode]) -> bool:
    global front_pointer
    front_pointer = head 
    return self.recursive(head) 

Solution().isPalindrome([1, 1, 2, 1])