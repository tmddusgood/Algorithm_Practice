#입력받기
n, m = map(int, input().split())
posRow, posColumn, direction = map(int, input().split())

#배열 만들기
map_array = []
map_visited = [[0] * m for _ in range(n)]
map_visited[posRow][posColumn] = 1

#방향 설정을 위한 배열
drow = [-1, 0, 1, 0]
dcolumn = [0, 1, 0, -1]
count = 1
turn = 0

#입력 받아 지도 모양 정하기
for _ in range(n):
    map_array.append(list(map(int, input().split())))

while True:
    #왼쪽으로 턴한다
    if direction < 1:
        direction += 4
    direction -= 1

    #유효성 검사 이전의 row와 column을 정한다.
    tempRow = posRow + drow[direction]
    tempColumn = posColumn + dcolumn[direction]

    #둘 중 하나라도 음수라면 무효
    if tempRow < 0 or tempColumn < 0:
        turn += 1
        pass
    #1조건 통과했어도,
    elif map_visited[tempRow][tempColumn] == 1 or map_array[tempRow][tempColumn] == 1:
        if turn == 4:
            direction += 1

            tempRow = posRow - drow[direction]
            tempColumn = posColumn - dcolumn[direction]

            if map_array[tempRow][tempColumn] == 1:
                break
            else:
                posRow = tempRow
                posColumn = tempColumn
                map_visited[posRow][posColumn] = 1
                turn = 0
        else:
            turn += 1
            pass
    else:
        posRow = tempRow
        posColumn = tempColumn
        map_visited[posRow][posColumn] = 1
        turn = 0
        count += 1

print(count)