//���ɵ����������к� ���ؼ�
//���� Ȯ�� ���� 
//2���� ������ �Է� �޾�, AND,OR,XOR�� ����� ����ϴ� ���α׷��� �ۼ��ϼ���.
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