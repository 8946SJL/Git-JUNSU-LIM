//개념 확인 과제
//별('*')을 이용하여 아래와 같이 다섯 줄의 피라미드를 출력하도록 해 보세요. 단, for루프를 이용해야 합니다.
#include <stdio.h>
#pragma warning(disable:4996)

int main(void)

{
	int i, j;
		for (i = 1; i <= 5; i++)
		{
			for (j = 1; j <= 5 - i; j++)
			{
				printf(" ");
			}
			for (j = 1; j <= 2* i - 1;j++)
			{
				printf("*");
			}
			printf("\n");
		}
		return 0;
	}