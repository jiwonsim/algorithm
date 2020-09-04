import Foundation

class Boj1931 {
    func main() {
        guard let inputN = readLine() else { return }
        let N = Int(inputN) ?? 0
        
        var map = [[Int]](repeating: [Int](), count: N)
        for i in 0..<N {
            guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return}
            map[i].append(contentsOf: input)
        }
        // 회의가 끝나는 순으로, 그 다음 시작하는 순으로 정렬
        let sortedMap = map.sorted(by: { $0[0] < $1[0] }).sorted(by: { $0[1] < $1[1] })
        
        var e = 0, c = 0
        for element in sortedMap {
            if e <= element[0] {
                e = element[1]
                c += 1
            }
        }
        print(c)
    }
}

Boj1931().main()
