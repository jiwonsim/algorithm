import Foundation

class Boj1561 {
    func main() -> Int {
        guard let nm = readLine()?.inlineInt,
            let playingTimes = readLine()?.inlineInt64
            else { return -1 }
        
        let N = nm[0]
        let M = nm[1]
        
        if N <= M { return N }
        
        var start: Int64 = 0
        var end: Int64 = 2000000000 * 10000 * 30 + 1
        
        while start <= end {
            let mid: Int64 = (start+end)/2
            
            var startedKid: Int64 = 0
            var endedKid: Int64 = Int64(M)
            
            for playingTime in playingTimes {
                endedKid += mid/playingTime
            }
            
            startedKid = endedKid
            for playingTime in playingTimes {
                if mid%playingTime==0 { startedKid-=1 }
            }
            startedKid += 1
            
            if startedKid > N {
                // 아직 너무 큼
                end = mid-1
            }
            else if endedKid < N {
                // 아직 너무 작음
                start = mid+1
            }
            else {
                for i in 0..<playingTimes.count {
                    let playingTime = playingTimes[i]
                    if mid%playingTime == 0 {
                        if N == startedKid {
                            return i+1
                        }
                        startedKid+=1
                    }
                }
            }
        }
        
        return 0
    }
}

print(Boj1561().main())

extension String {
    var inlineInt64: [Int64] {
        return self.split(separator: " ").compactMap({Int64(String($0))})
    }
    
    var inlineInt: [Int] {
        return self.split(separator: " ").compactMap({Int(String($0))})
    }
}
