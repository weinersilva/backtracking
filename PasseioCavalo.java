package br.ufg;


import java.text.DecimalFormat;


public class PasseioCavalo {

	int[][] solucao;
	int caminho = 0;

	public PasseioCavalo(int N) {
		solucao = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solucao[i][j] = 0;
			}
		}
	}

	public void resolve() {
		if (procuracaminho(0, 0, 0, solucao.length)) {
			print();
		} else {
			System.out.println("Caminho não encontrado!");
		}
	}

	public boolean procuracaminho(int linha, int coluna, int indice, int N) {

		if (solucao[linha][coluna] != 0) {
			return false;
		}


		solucao[linha][coluna] = caminho++;
		
		if (indice == N * N - 1) {
			
			return true;
		}
		
		if (podeMover(linha + 2, coluna + 1, N)
				&& procuracaminho(linha + 2, coluna + 1, indice + 1, N)) {
			return true;
		}

		if (podeMover(linha + 1, coluna + 2, N)
				&& procuracaminho(linha + 1, coluna + 2, indice + 1, N)) {
			return true;
		}


		if (podeMover(linha - 1, coluna + 2, N)
				&& procuracaminho(linha - 1, coluna + 2, indice + 1, N)) {
			return true;
		}


		if (podeMover(linha - 2, coluna + 1, N)
				&& procuracaminho(linha - 2, coluna + 1, indice + 1, N)) {
			return true;
		}


		if (podeMover(linha - 2, coluna - 1, N)
				&& procuracaminho(linha - 2, coluna - 1, indice + 1, N)) {
			return true;
		}


		if (podeMover(linha - 1, coluna - 2, N)
				&& procuracaminho(linha - 1, coluna - 2, indice + 1, N)) {
			return true;
		}


		if (podeMover(linha + 1, coluna - 2, N)
				&& procuracaminho(linha + 1, coluna - 2, indice + 1, N)) {
			return true;
		}


		if (podeMover(linha + 2, coluna - 1, N)
				&& procuracaminho(linha + 2, coluna - 1, indice + 1, N)) {
			return true;
		}


		solucao[linha][coluna] = 0;
		caminho--;
		return false;

	}

	public boolean podeMover(int linha, int col, int N) {
		if (linha >= 0 && col >= 0 && linha < N && col < N) {
			return true;
		}
		return false;
	}

	public void print() {
		DecimalFormat doisdigitos = new DecimalFormat("00");
		for (int i = 0; i < solucao.length; i++) {
			for (int j = 0; j < solucao.length; j++) {
				System.out.print("   " + doisdigitos.format(solucao[i][j]));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int N = 8;
		PasseioCavalo i = new PasseioCavalo(N);
		i.resolve();
	}

}