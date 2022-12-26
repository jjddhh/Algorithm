#include <iostream>
#include <string.h>

using namespace std;

int main() 
{
	int m, n = 2;
	
	cin >> m;


	while (m != 1) {
		if (m % n == 0) {
			cout << n << '\n';
			m /= n;
			n = 2;
		}
		else n++;
	}
	
	return 0;
}
	
