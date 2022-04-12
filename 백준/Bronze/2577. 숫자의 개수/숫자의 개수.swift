import Foundation

var line: [Int] = []
for _ in 1...3 {
    line.append(Int(readLine()!)!)
}

func countOfNumber(_ a: Int, _ b: Int, _ c: Int) {
    var multiple = a*b*c
    
    var count = [Int](repeating: 0, count: 10)
    
    while multiple > 0 {
        count[multiple % 10] += 1
        multiple /= 10
    }
    
    for n in count {
        print(n)
    }
}

countOfNumber(line[0], line[1], line[2])