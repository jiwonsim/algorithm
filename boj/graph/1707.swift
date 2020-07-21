import Foundation

var map = [[Int]](), parties = [Int]()

func search(_ cur: Int, _ party: Int) -> Bool {
    
    var result = true
    
    parties[cur] = party
    
    for element in map[cur] {
        if parties[element] == -1 {
            if party == 0 {
                parties[element] = 1
            }
            else { parties[element] = 0 }
            
            result = search(element, parties[element])
        }
        else {
            if parties[cur] == parties[element] {
                return false
            }
        }
    }
    return result
}


if let K = readLine()?.compactMap({ Int(String($0)) })[0] {
    for _ in 0..<K {
        guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { exit(0) }
        
        let V = input[0]
        let E = input[1]
        
        map =  [[Int]](repeating: [Int](), count: V+1)
        parties = [Int](repeating: -1, count: V+1)
        
        for _ in 1...E {
            guard let connected = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { exit(0) }
            
            map[connected[0]].append(connected[1])
            map[connected[1]].append(connected[0])
        }
        
        var flag = true
        for v in 1...V {
            if parties[v] == -1 {
                let res = search(v, 0)
                if !res {
                    flag = false
                    break
                }
            }
        }
        
        if flag { print("YES") }
        else { print("NO") }
    }
}
