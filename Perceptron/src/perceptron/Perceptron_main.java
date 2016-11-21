package perceptron;

public class Perceptron_main {
	
	/*�S��Correct�ɂȂ������_�ŏI�����A����ŏI����������\������悤�ɂ����B
	  ���s�񐔂̏����10000��ɂ��A����𒴂�����I�����Đ������Ȃ������ƕ\������B*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double nu[] = {1,1};
		Perceptron_lib plib = new Perceptron_lib(2,nu,0.01,0.5);
		
		//�w�K�f�[�^
		double input[][] = {{1,1},{1,0},{0,1},{0,0}};
		double output[] = {1,0,0,0};
	
		//�w�K
		int index,kaisuu = 0;
		for(int i = 0; i < 10000; i++){
			int k = 0;
			index = (int)(Math.random()*4); //0~3�̗�������
			plib.getParameter(input[index], output[index]);
			System.out.println("index : "+i+"nu = "+nu[0]+", "+nu[1]);
			
			kaisuu++;
			
			for(int j = 0; j < output.length; j++){
				if(plib.getOutput(input[k]) == output[k])
					k++;
			}
			if(k == output.length)
				break;
		}
		//���ʊm�F
		for(int i = 0; i < output.length; i++){
			if(plib.getOutput(input[i]) == output[i])
				System.out.println("Correct! : input("+input[i][0]+","+input[i][1]+") to output("+output[i]+")");
			else System.out.println("Miss! : input("+input[i][0]+","+input[i][1]+") to output("+output[i]+")");
		}
		if(kaisuu == 10000)
			System.out.println("10000�񎎍s���܂������A�������܂���ł����B");
		else
			System.out.println(kaisuu+"��̎��s�őS�Đ������܂����B");
		System.out.println("Check : nu = "+nu[0]+", "+nu[1]);

	}

}
