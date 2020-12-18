# def solution(phone_book):
#     digits = ["1", "2", "3", "4", "5", "6", "7", "8", '9', "0"]
#     phone_book_hash = []
#     numberHashDict = {}
#
#     for digit in digits:
#         numberHashDict[digit] = hash(digit)
#
#     for number in phone_book:
#         temp = 0
#         for i in range(len(number)):
#             temp += numberHashDict[number[i]]
#         phone_book_hash.append(temp)
#
#     for hash in phone_book_hash:
#
#
#
#
#
# solution(["119", '97674223', '1195524421'])