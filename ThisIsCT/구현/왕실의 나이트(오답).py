horizontal = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
moveX = [-1, 1]
moveY = [-1, 1]
move_horizontal = ['L', 'R']
move_vertical = ['U', 'D']

print('현재 위치를 입력하세요')
position = str(input())
positionX = int(position[1]) - 1
positionY = horizontal.index(position[0])

count = 0
for move_h in move_horizontal:
    for move_v in move_vertical:
        temp_X = (positionX + moveX[(move_horizontal.index(move_h))] * 2)
        temp_Y = (positionY + moveY[(move_vertical.index(move_v))])
        if temp_X > 0 and temp_X < 9 and temp_Y > 0 and temp_Y < 9:
            count += 1

for move_v in move_vertical:
    for move_h in move_horizontal:
        temp_X = (positionX + moveX[(move_horizontal.index(move_h))])
        temp_Y = (positionY + moveY[(move_vertical.index(move_v))] * 2)
        if temp_X > 0 and temp_X < 9 and temp_Y > 0 and temp_Y < 9:
            count += 1

print(count)