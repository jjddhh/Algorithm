#include <iostream>
#include <string.h>

using namespace std;
 
int arr[1000001];

int main() 
{

	int m, n;

	cin >> m >> n;
	
	arr[1] = 1;
	for (int i = 2; i <= n; i++) {
		for (int sub_i = 2 * i; sub_i <= n; sub_i += i) {
			if(!arr[sub_i]) arr[sub_i] = 1;
		}
	}

	for (int i = m; i <= n; i++) {
		if (!arr[i]) cout << i << '\n';
	}

	
	
	return 0;
}
	



	
