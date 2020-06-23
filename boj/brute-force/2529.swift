import Foundation

let range = 10

var k = Int()
var marks = [String]()
var visited = [Bool]()
var result = [String]()

var maxRes = "", minRes = "\(Int.max)"

func search(_ num: Int, _ order: Int, _ index: Int) {
    if order == marks.count {
        let resNum = result.joined(separator: "")
        maxRes = max(maxRes, resNum)
        minRes = min(minRes, resNum)
        return
    }
    
    for nextNum in 0..<range {
        if visited[nextNum] { continue }
        
        visited[nextNum] = true
        if marks[order] == "<" {
            if num < nextNum {
                result[index] = "\(nextNum)"
                search(nextNum, order + 1, index + 1)
            }
        }
        else {
            if num > nextNum {
                result[index] = "\(nextNum)"
                search(nextNum, order + 1, index + 1)
            }
        }
        visited[nextNum] = false
    }
    
}

func solution() {
    k = Int(readLine()!)!
    marks = readLine()!.split(separator: " ").compactMap { String($0) }
    let range = 10
    
    result = [String](repeating: String(), count: k + 1)
    visited = [Bool](repeating: false, count: range)
    
    for num in 0..<range {
        visited[num] = true
        result[0] = "\(num)"
        search(num, 0, 1)
        visited[num] = false
    }
    
    print(maxRes)
    print(minRes)
}

solution()


