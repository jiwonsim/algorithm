import Foundation

func rotateMap(_ map: [[Int]]) -> [[Int]] {
    let n = map.count
    var rotated = map
    
    for i in 0..<n {
        for j in 0..<n {
            rotated[i][j] = map[n-j-1][i]
        }
    }
    return rotated
}

func isValid(_ map: [[Int]]) -> Bool {
    let m = map.count/3
    
    for r in m..<m*2 {
        for c in m..<m*2 {
            if map[r][c] == 0 || map[r][c] == 2 {
                return false
            }
        }
    }
    return true
}

func solution(_ key:[[Int]], _ lock:[[Int]]) -> Bool {
    let n = key.count // 열쇠의 크기
    let m = lock.count // 자물쇠의 크기
    
    // 3배로 확장한 자물쇠 배열 만들기
    var extended = [[Int]](repeating: [Int](repeating: 0, count: m*3), count: m*3)
    
    for i in 0..<m {
        for j in 0..<m {
            extended[i+m][j+m] = lock[i][j]
        }
    }
    
    for i in 0..<m*2 {
        for j in 0..<m*2 {
            var rotated = key
            for k in 0..<4 {
                // 열쇠 배열을 돌린다
                rotated = rotateMap(rotated)
                
                // 열쇠 배열을 끼운다
                var copied = extended
                for r in 0..<n {
                    for c in 0..<n {
                        copied[i+r][j+c] += rotated[r][c]
                    }
                }
                // 잘 맞는지 확인
                if isValid(copied) { return true }
            }
        }
    }
    
    
    return false
}
