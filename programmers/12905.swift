import Foundation

func solution(_ board:[[Int]]) -> Int
{
    var answer:Int = 0
    
    var dp = board
    
    for i in 1..<board.count {
        for j in 1..<board[i].count {
            if board[i][j] == 0 {
                continue
            }
            dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
        }
    }
    
    for i in 0..<board.count {
        for j in 0..<board[i].count {
            answer = max(dp[i][j], answer)
        }
    }
    
    return answer*answer
}
