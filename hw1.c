//지능데이터융합학부 임준수
//개념 확인 과제 
//2개의 정수를 입력 받아, AND,OR,XOR한 결과를 출력하는 프로그램을 작성하세요.
#include <stdio.h>
#pragma warning(disable:4996)

int main(void)
{
	int num1 = 0, num2 = 0;

	printf("Input two integers:");
	scanf("%d %d", &num1, &num2);



	printf("%d & %d: %d\n", num1,num2,num1 & num2);
	printf("%d | %d: %d\n", num1,num2,num1 | num2);
	printf("%d ^ %d: %d\n", num1,num2,num1 ^ num2);


	return 0;
}