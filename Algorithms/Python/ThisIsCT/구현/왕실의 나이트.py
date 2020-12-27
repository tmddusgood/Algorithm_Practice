horizontal = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']

dx = [-2, -2, 2, 2, -1, 1, -1, 1]
dy = [-1, 1, -1, 1, -2, -2, 2, 2]

inputString = input()
initialPosX = horizontal.index(inputString[0]) + 1
initialPosY = int(inputString[1])

count = 0

for i in range(8):
    posX = initialPosX + dx[i]
    posY = initialPosY + dy[i]

    if posX > 1 and posX < 9 and posY > 1 and posY < 9:
        count += 1

print(count)