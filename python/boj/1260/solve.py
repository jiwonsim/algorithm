import sys 

def dfs(v): 
  visited_dfs[v] = True 
  print(v, end = " ") 

  for i in range(1, n+1):
    if graph[v][i] == 0: continue 
    if visited_dfs[i]: continue
    dfs(i)

def bfs(v): 
  que = [] 
  visited_bfs[v] = True 
  que.append(v) 

  while que: 
    next_node = que.pop(0) 
    print(next_node, end = " ") 
    
    for i in range(1, n+1): 
      if graph[next_node][i] == 0: continue 
      if visited_bfs[i]: continue 
      visited_bfs[i] = True 
      que.append(i) 

read = sys.stdin.readline
n, m, v = map(int, read().split()) 

graph = [[0] * (n + 1) for _ in range(n + 1)]

visited_dfs = [False] * (n + 1) 
visited_bfs = [False] * (n + 1) 

for _ in range(m): 
  a, b = map(int, read().split()) 
  graph[a][b] = graph[b][a] = 1 

dfs(v) 
print() 
bfs(v) 