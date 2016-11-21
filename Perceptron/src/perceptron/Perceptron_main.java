package perceptron;

public class Perceptron_main {
	
	/*全てCorrectになった時点で終了し、何回で終了したかを表示するようにした。
	  試行回数の上限は10000回にし、それを超えたら終了して成功しなかったと表示する。*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double nu[] = {1,1};
		Perceptron_lib plib = new Perceptron_lib(2,nu,0.01,0.5);
		
		//学習データ
		double input[][] = {{1,1},{1,0},{0,1},{0,0}};
		double output[] = {1,0,0,0};
	
		//学習
		int index,kaisuu = 0;
		for(int i = 0; i < 10000; i++){
			int k = 0;
			index = (int)(Math.random()*4); //0~3の乱数発生
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
		//結果確認
		for(int i = 0; i < output.length; i++){
			if(plib.getOutput(input[i]) == output[i])
				System.out.println("Correct! : input("+input[i][0]+","+input[i][1]+") to output("+output[i]+")");
			else System.out.println("Miss! : input("+input[i][0]+","+input[i][1]+") to output("+output[i]+")");
		}
		if(kaisuu == 10000)
			System.out.println("10000回試行しましたが、成功しませんでした。");
		else
			System.out.println(kaisuu+"回の試行で全て成功しました。");
		System.out.println("Check : nu = "+nu[0]+", "+nu[1]);

	}

}
