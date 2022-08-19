#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
int bt[8];
int input[8];
bool is_used[8];

void func(int k)
{
	if (k == M) {
		for (int i = 0; i < M; i++) {
			cout << bt[i] << " ";
		}
		cout << '\n';
		return;
	}

	for (int i = 0; i < N; i++) {
		if (k == 0 || bt[k - 1] <= input[i]) {
			bt[k] = input[i];
			//is_used[i] = 1;
			func(k + 1);
			//is_used[i] = 0;
		}
		
	}
}



int main() 
{
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		cin >> input[i];
	}

	sort(input, input + N);
	func(0);


	return 0;
}


