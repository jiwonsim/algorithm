import Foundation

struct Emotion {
    var screen: Int
    var clip: Int
    var time: Int
    
    init(_ screen: Int, _ clip: Int, _ time: Int) {
        self.screen = screen
        self.clip = clip
        self.time = time
    }
}


func solution() {
    let target = readLine().map { Int(String($0)) }
    
    var visited = [[Bool]](repeating: [Bool](repeating: false, count: 10000), count: 10000)
    var que = [Emotion]()
    que.append(Emotion(1, 0, 0))
    visited[1][0] = true
    
    var head = 0
    while !que.isEmpty {
        let cur = que[head]
        head+=1
        
        if cur.screen == target {
            print(cur.time)
            return
        }
        
        if cur.screen > 0 {
            if !visited[cur.screen-1][cur.clip] {
                visited[cur.screen-1][cur.clip] = true
                que.append(Emotion(cur.screen-1, cur.clip, cur.time+1))
            }
            if !visited[cur.screen][cur.screen] {
                visited[cur.screen][cur.screen] = true
                que.append(Emotion(cur.screen, cur.screen, cur.time+1))
            }
        }
        if cur.clip > 0 {
            if !visited[cur.screen+cur.clip][cur.clip] {
                visited[cur.screen+cur.clip][cur.clip] = true
                que.append(Emotion(cur.screen+cur.clip, cur.clip, cur.time+1))
            }
        }
    }
    
}

solution()
