//���� Ȯ�� ����
//ǥ���Է����� km�� �Ҽ��� �Է� �޾� ���Ϸ� ����Ͽ�, �� ������� �Ҽ��� ù°�ڸ����� ����ϴ� ���α׷��� �ۼ��ϼ���.
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