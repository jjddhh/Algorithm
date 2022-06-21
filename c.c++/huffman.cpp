#include <stdio.h>
#include <algorithm>

int count[256];
int sort[256];
int inner_node[256];

int descending_comp(const void* a, const void* b)
{
	return(*(int*)b - *(int*)a); //내림차순 
}


int main() {

	int c;
	int exist_num = 0;

	FILE* p;
	if (fopen_s(&p, "anna-karerina.txt", "rt") == 0) {

		while ((c = fgetc(p)) != EOF) {
			count[c]++;
		}

		qsort(count, 256, sizeof(int), descending_comp);

		for (int i = 255; i >= 0; i--) {

			if (count[i] != 0) {
				sort[exist_num] = count[i];
				exist_num++;
			}

		}

		int k = 0;
		int t = 0;

		inner_node[0] = sort[0] + sort[1];

		for (int i = 2; i < exist_num; i++) {
			if (inner_node[k] + sort[i] < sort[i] + sort[i + 1]) {
				inner_node[++t] = inner_node[k] + sort[i];
				k++;
			}
			else {
				inner_node[++t] = sort[i] + sort[i + 1];
			}
		}

		int temp = t;
		for (int i = k; i < temp; i++) {
			inner_node[++t] = inner_node[k] + inner_node[k + 1];
		}

		int sum = 0;
		for (int i = 0; i <= t; i++) {
			sum += inner_node[i];
		}
		printf("compressed size : %d kb", sum / 8 / 1024);

		fclose(p);
	}
}