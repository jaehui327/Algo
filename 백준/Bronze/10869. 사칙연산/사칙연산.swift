import Foundation

let line = readLine()!.split(separator: " ").map { Int(String($0))!}
let a = line[0]
let b = line[1]
print(a+b)
print(a-b)
print(a*b)
print(Int(a/b))
print(a%b)
