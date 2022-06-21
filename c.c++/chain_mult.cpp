#include <iostream>

using namespace std;

int opt_table[100][100];
int k_table[100][100];
int d[100];
int n;
int mult;

int chain_mult(int fir, int las) {
	if (opt_table[fir][las] != 0) return opt_table[fir][las];
	else if (fir == las) return opt_table[fir][las];

	int min;


	for (int k = fir; k < las; k++) {
		min = chain_mult(fir, k) + chain_mult(k + 1, las) + (d[fir] * d[k + 1] * d[las + 1]);
		mult++;

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

void opt_matrix(int fir, int las) {
	int k = k_table[fir][las];

	if (las - fir == 1) {
		printf("A%dA%d", fir, las);
		return;
	}

	if (fir == k) {
		printf("A%d", fir);
	}
	else {
		printf("("); opt_matrix(fir, k); printf(")");
	}

	if (k + 1 == las) {
		printf("A%d", las);
	}
	else {
		printf("("); opt_matrix(k + 1, las); printf(")");
	}
}

int main() {

	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> d[i];
	}

	chain_mult(1, n);

	printf("\ntable of opt[i, j]\n\n");

	for (int i = 1; i < n; i++) {

		for (int sub_i = 1; sub_i < i; sub_i++) {
			printf("\t");
		}

		for (int sub_i = i; sub_i < n; sub_i++) {
			printf("%d\t", opt_table[i][sub_i]);

		}

		printf("\n");
	}

	printf("\ntable of k[i, j]\n\n");

	for (int i = 1; i < n; i++) {

		for (int sub_i = 1; sub_i < i; sub_i++) {
			printf("\t");
		}

		for (int sub_i = i; sub_i < n; sub_i++) {
			printf("%d\t", k_table[i][sub_i]);

		}

		printf("\n");
	}

	opt_matrix(1, n - 1);
    
	printf("\nmult = %d", mult);
}