package programmers.level2;

class 행렬테두리회전하기 {
    static int[][] MAP;

    public int[] solution(int rows, int columns, int[][] queries) {
        // 행렬 생성
        MAP = new int[rows][columns];

        // 정답 배열
        int[] answer = new int[queries.length];

        // 행렬 초기화
        for (int i = 0; i < rows; i++) for (int j = 0; j < columns; j++) MAP[i][j] = i * columns + j + 1;

        // length 만큼 회전
        for (int i = 0; i < queries.length; i++) answer[i] = rotate(queries[i]);

        return answer;
    }

    public int rotate(int[] query) {
        int startRow = query[0] - 1;
        int startColumn = query[1] - 1;
        int endRow = query[2] - 1;
        int endColumn = query[3] - 1;

        int start = MAP[startRow][startColumn];
        int min = start;

        // 회전 왼쪽 세로
        for (int i = startRow; i < endRow; i++) {
            MAP[i][startColumn] = MAP[i + 1][startColumn];
            if (min > MAP[i][startColumn]) min = MAP[i][startColumn];
        }

        // 회전 위 가로
        for (int i = startColumn; i < endColumn; i++) {
            MAP[endRow][i] = MAP[endRow][i + 1];
            if (min > MAP[endRow][i]) min = MAP[endRow][i];
        }

        //
        for (int i = endRow; i > startRow; i--) { //
            MAP[i][endColumn] = MAP[i - 1][endColumn];
            if (min > MAP[i][endColumn]) min = MAP[i][endColumn];
        }

        //
        for (int i = endColumn; i > startColumn; i--) {
            MAP[startRow][i] = MAP[startRow][i - 1];
            if (min > MAP[startRow][i]) min = MAP[startRow][i];
        }

        MAP[startRow][startColumn + 1] = start;

        return min;
    }
}