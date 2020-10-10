from math import log

def decToBin(s):
    if not s: return "0"
    ans = ""
    power = 1
    for i in range(int(log(s, 2)) + 1):
        ans = ["1", "0"][((1 << i) & s) == 0] + ans
        power *= 2
    return ans

if __name__ == '__main__':
    print(decToBin(100))
    print(decToBin(0))

