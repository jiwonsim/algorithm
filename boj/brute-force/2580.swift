import Foundation

class Boj2580 {
    private let ROW = 0, COL = 1, SQUARE = 2
    
    private var map = [[Int]]()
    private var checked = [[[Bool]]](repeating: [[Bool]](repeating: [Bool](repeating: false, count: 10), count: 9), count: 3)
    
    private func square(_ row: Int, _ col: Int) -> Int {
        return (row/3)*3+col/3
    }
    
    private func possible(_ row: Int, _ col: Int, _ val: Int) -> Bool {
        if checked[ROW][row][val] || checked[COL][col][val] || checked[SQUARE][square(row, col)][val] { return false }
        return true
    }
    
    private func check(_ row: Int, _ col: Int, _ val: Int, _ flag: Bool) {
        checked[ROW][row][val] = flag
        checked[COL][col][val] = flag
        checked[SQUARE][square(row, col)][val] = flag
    }
    
    func go(_ index: Int) {
        
        if index == 81 {
            for row in map {
                for col in row {
                    print(col, terminator: " ")
                }
                print()
            }
            exit(0)
        }

        let row = index/9
        let col = index%9
        
        if map[row][col] != 0 {
            go(index+1)
        }
        else {
            for k in 1..<10 {
                if !possible(row, col, k) { continue }
                
                check(row, col, k, true)
                map[row][col] = k
                go(index+1)
                map[row][col] = 0
                check(row, col, k, false)
            }
        }
    }

    func main() {
        map = [[Int]](repeating: [Int](), count: 9)
        
        for i in 0..<9 {
            guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
            map[i] = input
            for j in 0..<9 {
                if map[i][j] == 0 { continue }
                check(i, j, map[i][j], true)
            }
        }

        go(0)
    }
}

Boj2580().main()
