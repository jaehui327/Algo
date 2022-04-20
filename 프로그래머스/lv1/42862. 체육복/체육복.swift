import Foundation

func solution(_ n:Int, _ lost:[Int], _ reserve:[Int]) -> Int {
    let re = Set(reserve).subtracting(lost)
    var lo = Set(lost).subtracting(reserve)
    
    for r in re {
        if lo.contains(r - 1) {
            lo.remove(r - 1)
            continue
        }
        if lo.contains(r + 1) {
            lo.remove(r + 1)
        }
    }
    
    return n - lo.count
}