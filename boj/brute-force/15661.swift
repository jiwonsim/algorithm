import Foundation

var map = [[Int]]()
var visited = [Bool]()
var sameTeam = [Bool]()

var result = Int.max

func calculateScore(_ array: [Int]) -> Int {
    var sum = 0
    
    for i in 0..<array.count {
        for j in i+1..<array.count {
            sum += map[array[i]][array[j]] + map[array[j]][array[i]]
        }
    }
    
    return sum
}


func divideTeams() -> Int {
    var team1 = [Int]()
    var team2 = [Int]()
    
    for i in 0..<sameTeam.count {
        if sameTeam[i] {
            team1.append(i)
        }
        else { team2.append(i) }
    }
    
    let scoreOfFirst = calculateScore(team1)
    let scoreOfSecond = calculateScore(team2)

    return abs(scoreOfFirst-scoreOfSecond)
}

func search(_ index: Int, _ depth: Int, _ D: Int, _ N: Int) {
    if depth == D {
        result = min(divideTeams(), result)
        return
    }
    
    for i in index..<N {
        sameTeam[i] = true
        search(i+1, depth+1, D, N)
        sameTeam[i] = false
    }
}

if let input = readLine() {
    if let N = Int(input) {
        
        // init
        map = [[Int]](repeating: [Int](repeating: 0, count: N), count: N)
        visited = [Bool](repeating: false, count: N)
        sameTeam = [Bool](repeating: false, count: N)

        for i in 0..<N {
            guard let input = readLine()?.split(separator: " ").compactMap({ Int(String($0)) }) else { break }
            for j in 0..<N {
                map[i][j] = input[j]
            }
        }
        
        sameTeam[0] = true
        for depth in 0..<N {
            search(1, 1, depth, N)
        }
        
        print(result)
    }
}
