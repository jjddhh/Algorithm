#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
char bt[15];
char input[15];
char alpha[5] = { 'a', 'e', 'i', 'o', 'u' };
int alpha_count;
bool is_used[15];

void func(int k)
{
	if (k == M) {
		if (1 <= alpha_count && M - alpha_count >= 2) {
			for (int i = 0; i < M; i++) {
				cout << bt[i];
			}
			cout << '\n';
			return;
		}
	}

	for (int i = 0; i < N; i++) {
		int check = 0;
		if (k == 0 || (!is_used[i] && bt[k - 1] <= input[i])) {
			bt[k] = input[i];
			for (int sub_i = 0; sub_i < 5; sub_i++) {
				if (bt[k] == alpha[sub_i]) {
					alpha_count++;
					check = 1;
					break;
				}
			}
			is_used[i] = 1;

			func(k + 1);

			if (check) alpha_count--;
			is_used[i] = 0;
		}
		
	}
}



int main() 
{
	cin >> M >> N;

	for (int i = 0; i < N; i++) {
		cin >> input[i];
	}

	sort(input, input + N);

	func(0);


	return 0;
}


