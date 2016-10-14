package br.ufg;

public class NRainhas {
	public int[][] solucao;

	public NRainhas(int N) {
		solucao = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solucao[i][j] = 0;
			}
		}
	}

	public void resolver(int N) {
		if(lugarRainha(0, N)){
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(" " + solucao[i][j]);
				}
				System.out.println();
			}
		}else{
			System.out.println("Solução não existe!");
		}
	}

	public boolean lugarRainha(int rainha, int N) {
		 
		if(rainha==N){
			 
			return true;
		}
		for (int linha = 0; linha < N; linha++) {
			 
			if (canPlace(solucao, linha, rainha)) {
				 
				solucao[linha][rainha] = 1;
				 
				if(lugarRainha(rainha + 1, N)){
					return true;
				}
				 
				solucao[linha][rainha]=0;
			}
		}
		 
		return false;

	}

	 
	public boolean canPlace(int[][] matriz, int linha, int coluna) {
		 
		for (int i = 0; i < coluna; i++) {
			if (matriz[linha][i] == 1) {
				return false;
			}
		}
		 
		for (int i = linha, j = coluna; i >= 0 && j >= 0; i--, j--) {
			if (matriz[i][j] == 1) {
				return false;
			}
		}

		 
		for (int i = linha, j = coluna; i < matriz.length && j >= 0; i++, j--) {
			if (matriz[i][j] == 1) {
				return false;
			}
		}
		 
		return true;
	}

	public static void main(String[] args) {
		int N = 8;
		NRainhas q = new NRainhas(N);
		q.resolver(N);

	}

}