#include <bits/stdc++.h>
using namespace std;

int N;
int answer = 1;
deque<int> dq;
int arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
int buffer[10001];

void printPostFix(int startIndex, int endIndex){
    if (startIndex >= endIndex) return;

    int root = buffer[startIndex];
    int startOfRightSubTree = startIndex + 1;
    for (startOfRightSubTree = startIndex + 1; startOfRightSubTree < endIndex; startOfRightSubTree++){
        if (buffer[startOfRightSubTree] > buffer[startIndex]){
            break;
        }
    }
    printPostFix(startIndex + 1, startOfRightSubTree);
    printPostFix(startOfRightSubTree, endIndex);
    cout << root << '\n';
}


int main(int argc, char *argv[])
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int n = 0;
 	//cin >> n;
    //for (auto i = 0; i < n; i ++){
    //    cin >> buffer[i];
    //}
    string line;
    while (getline(cin, line)){
        buffer[n] = stoi(line);
        n++;
    }
    printPostFix(0, n);

	return 0;
}