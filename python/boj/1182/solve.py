import sys
from typing import List 

result: int = 0

def recursive_search(target: int, arr: List[int], index: int): 
  global result
  if target == 0: 
    result += 1
  if index >= len(arr): return 

  for i in range(index+1, len(arr)): 
    recursive_search(target - arr[i], arr, i) 
  
def solve(): 
  read = sys.stdin.readline
  n, s = map(int, read().split())
  arr_obj = map(int, read().split())
  arr = list(arr_obj)
  for i in range(0, n): 
    recursive_search(s - arr[i], arr, i) 
  print(result)

solve()