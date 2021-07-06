def solution1(genres, plays):
    genres_plays = {}
    genres_song = {}
    song_plays = {}

    for i in range(len(genres)):
        if genres[i] not in genres_plays:
            genres_plays[genres[i]] = plays[i]
        else:
            genres_plays[genres[i]] += plays[i]

        if genres[i] not in genres_song:
            temp = []
            temp.append(i)
            genres_song[genres[i]] = temp
        else:
            temp = genres_song[genres[i]]
            temp.append(i)
            genres_song[genres[i]] = temp

    detail = [item for item in zip(genres, plays)]
    print(detail)

    print(sorted(genres_plays, reverse=True))
    print(genres_song)



    answer = ""
    return answer

def solution2(genres, plays):
    detail = [item for item in zip(genres, plays)]
    number_detail = {}
    type = {}
    type_dict = {}

    for i in range(len(detail)):
        number_detail[i] = detail[i]
    for i in range(len(detail)):
        if number_detail[i][0] not in type:
            type[number_detail[i][0]] = number_detail[i][1]
        else:
            type[number_detail[i][0]] += number_detail[i][1]

    for i in number_detail:
        if number_detail[i][0] not in type_dict:
            type_dict[number_detail[i][0]] = []
            type_dict[number_detail[i][0]].append(i)
        else:
            if number_detail[type_dict[number_detail[i][0]][0]][1] < number_detail[i][1]:
                type_dict[number_detail[i][0]].insert(0, i)
            elif number_detail[type_dict[number_detail[i][0]][0]][1] == number_detail[i][1]:
                if type_dict[number_detail[i][0]][0] > i:
                    type_dict[number_detail[i][0]].insert(0, i)
                else:
                    type_dict[number_detail[i][0]].append(i)
            else:
                type_dict[number_detail[i][0]].append(i)

    type = sorted(type, reverse=True)

    answer = []
    for item in type[:2]:
        if len(type_dict[item]) > 2:
            answer.extend(type_dict[item][:2])
        else:
            answer.extend(type_dict[item])

    print(answer)
    return answer

import numpy as np
import pandas as pd

def solution3(genres, plays):
    musics = pd.DataFrame()
    musics['id'] = range(len(plays))
    musics['plays'] = plays
    musics['genres'] = genres

    musics['genres_plays'] = musics.groupby('genres').transform(np.sum)['plays']
    musics['genres_head_id'] = musics.groupby('genres').transform(np.min)['id']
    musics['order'] = musics['genres_plays']*1000000 + musics['genres_head_id']*1000 + musics['plays']

    answer = musics.sort_values('order', ascending=False).groupby('genres').head(2)['id']
    answer = list(answer)

    return answer


genres = ["classic", "pop", "classic", 'classic', 'pop']
plays = [500, 600, 150, 800, 2500]
print(solution3(genres, plays))

