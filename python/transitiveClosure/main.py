import sys

flag = []
p = 0


def dfs(depth, v):
    for u in range(V):
        if matrix[v][u] and flag[u]:
            flag[u] = 0
            dfs(depth + 1, u)
    if v == p and depth != 0:
        ans[p][v] = 1
    if v != p:
        ans[p][v] = 1
    return


if __name__ == '__main__':
    sys.stdin = open('stdin.inp', 'r')
    V = int(input())
    matrix = [[0 for i in range(V)] for j in range(V)]
    ans = [[0 for i in range(V)] for j in range(V)]
    for i in range(V):
        matrix[i] = [int(j) for j in input().split()]
        print(matrix[i])
    for v in range(V):
        for u in range(V):
            if(matrix[v][u]):
                print(str(v) + "->" + str(u))
    print()

    for i in range(V):
        flag = [1 for i in range(V)]
        p = i
        dfs(0, i)
    for i in range(V):
        print(ans[i])
    for v in range(V):
        for u in range(V):
            if(ans[v][u]):
                print(str(v) + "->" + str(u))
