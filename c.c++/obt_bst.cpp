#include <iostream>

using namespace std;

float opt_table[100][100];
int k_table[100][100];
float d[100];
int n;


float obt_bst(int fir, int las) {
	if (opt_table[fir][las] != 1) return opt_table[fir][las];
	else if (fir == las) {
		k_table[fir][las] = fir;
		return opt_table[fir][las];
	}

	float min;


	for (int k = fir; k <= las; k++) {

		float pl = 0, pr = 0, p = 0;

		for (int i = fir; i <= las; i++) {
			if (i < k) pl += d[i];
			else if (i > k) pr += d[i];
			p += d[i];
		}

		if (k == fir) min = 1 + pr / p * obt_bst(k + 1, las);
		else if (k == las) min = 1 + pl / p * obt_bst(fir, k - 1);
		else min = 1 + pl / p * obt_bst(fir, k - 1) + pr / p * obt_bst(k + 1, las);

		if (k == fir) {
			opt_table[fir][las] = min;
			k_table[fir][las] = k;
		}

		if (opt_table[fir][las] > min) {
			opt_table[fir][las] = min;
			k_table[fir][las] = k;
		}
	}

	return opt_table[fir][las];
}

int main() {

	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> d[i];

		for (int sub_i = 1; sub_i <= n; sub_i++) {
			opt_table[i][sub_i] = 1;
		}
	}

	obt_bst(1, n);

	printf("\ntable of opt[i, j]\n\n");

	for (int i = 1; i <= n; i++) {

		for (int sub_i = 1; sub_i < i; sub_i++) {
			printf("\t");
		}

		for (int sub_i = i; sub_i <= n; sub_i++) {
			printf("%.2f\t", opt_table[i][sub_i]);

		}

		printf("\n");
	}

	printf("\ntable of k[i, j]\n\n");

	for (int i = 1; i <= n; i++) {

		for (int sub_i = 1; sub_i < i; sub_i++) {
			printf("\t");
		}

		for (int sub_i = i; sub_i <= n; sub_i++) {
			printf("%d\t", k_table[i][sub_i]);

		}

		printf("\n");
	}
}