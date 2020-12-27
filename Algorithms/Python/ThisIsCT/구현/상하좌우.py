def solution(n, plan):
#    squareMap = [[0] * n for _ in range(n)]
    pointX = 0
    pointY = 0

    while len(plan) > 0:
        next = plan.pop(0)
        print(plan)

        if next == 'R' and (pointY +1) < n:
            pointY += 1
        elif next == 'L' and (pointY - 1) > 0:
            pointY -= 1
        elif next == 'U' and (pointX - 1) > 0:
            pointX -= 1
        elif next == 'D' and (pointX + 1) < n:
            pointX += 1

        print(pointX, pointY)

    return pointX + 1, pointY + 1


print(solution(5, ["R", 'R', 'R', 'U', 'D', 'D']))
