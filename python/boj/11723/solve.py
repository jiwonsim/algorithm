import sys 

def solve(): 
  read = sys.stdin.readline
  cmd_cnt = int(read()) 
  res = 0 
  while cmd_cnt > 0: 
    cmds = read().split(" ")
    cmds[-1] = cmds[-1].strip()
    if cmds[0] == "add": 
      val = int(cmds[1]) 
      res |= (1 << (val-1))
    elif cmds[0] == "remove": 
      val = int(cmds[1]) 
      res ^= (res & (1 << val-1))
    elif cmds[0] == "check": 
      val = int(cmds[1]) 
      print(1 if (res & (1 << val-1) > 0) > 0 else 0)
    elif cmds[0] == "toggle": 
      val = int(cmds[1]) 
      res ^= (1 << val-1)
    elif cmds[0] == "all": 
      res |= ((1 << 20) - 1)
    elif cmds[0] == "empty": 
      res = 0 
    cmd_cnt -= 1 
solve() 