def solution(phone_book):
    for item1 in phone_book:
        count = 0
        for item2 in phone_book:
            for i in range(len(item2)):
                if item1 == item2[0:i+1]:
                    count += 1
        if count > 1:
            return False
    return True


phone_book = ["119", "97674223", "1195524421"]
print(solution(phone_book))