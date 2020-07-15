import Foundation

let inputCnt = 9, resultCnt = 7
var heights = [Int]()

func solution() {
    
    for _ in 0..<inputCnt {
        let input: Int = Int(readLine()!)!
        heights.append(input)
    }
    
    let sum = heights.reduce(0) { lhs, rhs in lhs + rhs }
    
    for i in 0..<inputCnt {
        for j in i+1..<inputCnt {
            if sum - heights[i] - heights[j] == 100 {
                heights.remove(at: j)
                heights.remove(at: i)
                
                heights.sort()
                for ele in heights {
                    print(ele, terminator: "\n")
                }
                exit(0)
            }
        }
    }
}

solution()
