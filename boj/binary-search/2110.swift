import Foundation

class Boj2110 {
    func utilityCount(_ limit: Int, _ houses: [Int]) -> Int {
        var utilized = houses[0]
        var count = 1
        
        for house in houses {
            if house-utilized < limit { continue }
            count+=1
            utilized = house
        }
        
        return count
    }
    
    func main() {
        guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
        
        let N = Int(input[0])
        let C = Int(input[1])
        
        var houses = [Int]()
        for _ in 0..<N {
            guard let houseInput = readLine() else { return }
            houses.append(Int(houseInput) ?? 0)
        }
        
        houses.sort()
        
        var start = 1
        var end = houses.last ?? 0
        
        var result = 0
        
        while start <= end {
            let mid = (start+end)/2
            let midVal = utilityCount(mid, houses)
            
            if midVal >= C {
                start = mid+1
                result = mid
            }
            else { end = mid-1 }
        }
        
        print(result)
    }
}

Boj2110().main()
