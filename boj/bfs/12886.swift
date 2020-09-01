import Foundation

class Boj12886 {
    
    private var sum = 0
    private var visited = [[Bool]](repeating: [Bool](repeating: false, count: 1500+1), count: 1500+1)
    
    func go(_ X: Int, _ Y: Int) {
        
        let array = [X, Y, sum-X-Y]
        for i in 0..<3 {
            for j in 0..<3 {
                if array[i] < array[j] {
                    var temp = array
                    temp[i] += array[i]
                    temp[j] -= array[i]
                    
                    // 0번째, 1번째 값만 전달한다.
                    if visited[temp[0]][temp[1]] { continue }
                    visited[temp[0]][temp[1]] = true
                    go(temp[0], temp[1])
                }
            }
        }
    }
    
    func main() {
        guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
        
        let A = input[0]
        let B = input[1]
        let C = input[2]
        
        // 돌이 세 개 밖에 없지만, 모든 경우를 다 돌기 위해서는
        // O((500+500+500)^3) 의 시간복잡도와 공간복잡도가 소요된다.
        // A+B가 정해지면 C는 자동으로 정해진다는 점을 이용해서
        // O((500+500+500)^2) 의 복잡도로 줄일 수가 있다.
        
        sum = A+B+C
        if (sum%3) != 0 {
            print("0")
        }
        else {
            visited[A][B] = true
            go(A, B)
            print(visited[sum/3][sum/3] ? 1 : 0)
        }
    }
}

Boj12886().main()
