//개념 확인 과제
//표준입력으로 km를 소수로 입력 받아 마일로 계산하여, 이 결과값을 소수점 첫째자리까지 출력하는 프로그램을 작성하세요.
#include <stdio.h>
#pragma warning(disable:4996)

int main(void)

{
	double num1, miles;
	printf("Please enter kilometers:");
	scanf("%lf", &num1);

	miles = num1 / 1.609;

	printf("%.1lf km is equal to %.1lf miles.", num1, miles);

	return 0;
}