from sys import stdin
from itertools import combinations

lengths = []
for _ in range(9):
    lengths.append(int(stdin.readline().rstrip()))
lengths.sort()
com = list(combinations(lengths, 7))

for c in com:
    sum = 0
    for i in c:
        sum += i
    if sum == 100:
        for i in c:
            print(i)
        exit(0)
