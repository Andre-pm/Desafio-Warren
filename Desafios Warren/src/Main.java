import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao = 0;
		
		while(opcao != 4) {
		System.out.println("Escolha o desafio que deseja executar:");
		System.out.println("1- Desafio 1");
		System.out.println("Todos os números n onde a soma de n + reverso(n) resultem em números ímpares que estão abaixo de 1 milhão.\n");
		
		System.out.println("2- Desafio 2");
		System.out.println("Dado o tempo de chegada de cada aluno e o limite x de alunos presentes, determina se a classe vai ser cancelada ou não.\n");
		
		
		System.out.println("3- Desafio 3");
		System.out.println("Determine a soma com o menor número de elementos entre os números do vetor mais próxima de n e também mostre os elementos que compõem a soma.\n");
		System.out.println("4- Sair"); 
		opcao = sc.nextInt();
		
		switch(opcao) {
		
		case 1:
			System.out.println("Desafio 1");
			Desafio1();
			break;
			
		case 2:
			System.out.println("Desafio 2");
			Desafio2();
			break;
			
		case 3:
			System.out.println("Desafio 3");
			Desafio3();
			break;
			
		case 4:
			System.out.println("Programa encerrado, até mais!");
			break;
			
		default:
			System.out.println("Número inválido, tente novamente");
		}
	}
}

	
private static void Desafio1() {
	int contador = 0;
	int impares[];
	
	System.out.println("Números reversos: ");

	for (int i = 1; i <= 1000000; i++) {
	
		int num;
		int inverso = 0;
		
		num = i;
		
		while (num > 0) {
	        inverso = 10 * inverso + num % 10;
	        num /= 10;
	    }
			
		if((primeiro(i) != 0) && (String.valueOf(i).length() == String.valueOf(inverso).length()) && (inverso > i)) {
			if(((i+inverso)%2 != 0)) {
				if(contador%5 == 0) {
					System.out.println(i + ",");
				}else {
					System.out.print(i + ",");	
				}
				contador++;
				
			}
			
		}
		
	}
	System.out.println("\nTotal de números: "+ contador + "\n");

}

private static int primeiro(int primeiro) {
	while(primeiro >= 10){
		primeiro = primeiro / 10;
    }
	return primeiro;
}


private static void Desafio2() {
	int qtd, limite;
	int presente = 0;
	int[] tempoChegada;
	
	System.out.println("Insira o total de alunos: ");
	qtd = sc.nextInt();
	
	tempoChegada = new int[qtd];
	
	for (int i = 0; i < qtd; i++) {
		System.out.println("Insira tempo de chegada do aluno número " + (i+1));
		tempoChegada[i] = sc.nextInt();
		if(tempoChegada[i] >= 0){
			presente++;
		}
	}
	
	System.out.println("Qual o limite de alunos: ");
	limite = sc.nextInt();
	
	if (presente >= limite){
		System.out.println("Aula normal!\n");
	}else{
		System.out.println("Aula cancelada!\n");
	}
	
}

private static void Desafio3() {
	int[] vetor = new int[3];
	int[] vetorFinal = new int [999];
	int soma;
	int aux = 0;
	
	System.out.println("Insira o número a ser somado:");
	soma = sc.nextInt();
	
	for (int i = 0; i < vetor.length; i++) {
		System.out.println("Insira o número "+ (i+1) +" do vetor");
		vetor[i] = sc.nextInt();
	}
	
	for (int i = 0; i < 3 - 1; ++i) {
        for (int j = i + 1; j < 3; ++j) {
            if (vetor[i] < vetor[j]) {
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
    }
	int x = 0;
	int j = 0;
	aux = soma;
	
		while(aux > 0) {
			if(vetor[j] <= aux) {
				aux = aux - vetor[j];
				vetorFinal[x] = vetor[j];
				x++;
			}else {
				j++;
			}
		}
	
	
	System.out.print("Vetor Final[");
	for (int z = 0; z < vetorFinal.length; z++) {
		if(vetorFinal[z] != 0) {
			if(z == 0) {
				System.out.print(vetorFinal[z]);
			}else {
				System.out.print("," + vetorFinal[z]);
			}
		}
	}
	System.out.print("]\n");

}

}