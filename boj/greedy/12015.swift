import Foundation

class Boj12015 {
    
    private func go(_ ele: Int, _ size: Int, _ array: [Int]) -> Int {
        var left = 0, right = size
        
        // ele가 들어가야 할 위치를 찾아서 이분탐색 -> log(1,000,000)
        while left < right {
            let mid = (left+right)/2
            
            if ele <= array[mid] { right = mid  }
            else { left = mid+1 }
        }
        return left
    }
    
    func main() {
        guard let _ = readLine(), let array = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
        
        var result = [Int](repeating: 0, count: array.count)
        var size = 0
        
        for element in array { // 1,000,000
            // 현재의 수가 이전의 값들 중에 어디에 속해야 하는지 탐색
            let found = go(element, size, result) // 반환된 인덱스에 값 할당
            result[found] = element
            // result에 들어가는 요소 중에 element가 들어갈 위치를 찾아서 넣어주고,
            // result의 끝 값이 커지면 size가 증가하게 되면서
            // size에는 언제나 최대값이 들어간다!
            if size == found { size += 1 }
        }
        
        print(size)
    }
}

Boj12015().main()
