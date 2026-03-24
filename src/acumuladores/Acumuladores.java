package acumuladores;

public class Acumuladores {
//Gabriel Emanuel Blanco COM2
//Ej 1

	static boolean hayMultiploFila(int fila[], int num) {
		boolean hayMultiplo = true;
		for (int i = 0; i < fila.length; i++) {
			hayMultiplo = hayMultiplo && fila[i] % num == 0;
		}
		return hayMultiplo;
	}

	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
		boolean multiploEnAlgunaFila = false;
		boolean algunaFilaMultiplo;
		if (num == 0 || mat.length == 0 || num < 0) {
			return false;
		} else {
			for (int fila = 0; fila < mat.length; fila++) {
				algunaFilaMultiplo = true;
				for (int col = 0; col < mat[fila].length; col++) {
					algunaFilaMultiplo = algunaFilaMultiplo && hayMultiploFila(mat[fila], num);
				}
				multiploEnAlgunaFila = multiploEnAlgunaFila || algunaFilaMultiplo;
			}
			return multiploEnAlgunaFila;
		}
	}

//Ej 2
	public boolean hayInterseccionPorFila(int[][] mat1, int[][] mat2) {
		boolean hayInterseccion;
		boolean hayUnaPorFila = true;
		if (mat1.length == 0 || mat2.length == 0 || mat1.length != mat2.length) {
			return false;
		} else {
			for (int fila = 0; fila < mat1.length; fila++) {
				hayInterseccion = false;
				for (int col = 0; col < mat1[0].length; col++) {
					for (int i = 0; i < mat2[0].length; i++) {
						hayInterseccion = hayInterseccion || (mat1[fila][col] == mat2[fila][i]);

					}
				}
				hayUnaPorFila = hayUnaPorFila && hayInterseccion;
			}
		}
		return hayUnaPorFila;
	}

//Ej 3
	public static int sumarPorFilas(int[] fila) {
		int sumaFila = 0;
		for (int elem = 0; elem < fila.length; elem++) {
			sumaFila += fila[elem];
		}
		return sumaFila;
	}

	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) {
		if (nColum < 0 || nColum > mat.length) {
			return false;
		} else {

			boolean filaSumaMas = false;
			int sumaCol = 0;
			for (int i = 0; i < mat.length; i++) {
				sumaCol = sumaCol + mat[i][nColum];
			}

			for (int fila = 0; fila < mat.length; fila++) {
				filaSumaMas = filaSumaMas || (sumarPorFilas(mat[fila]) > sumaCol);

			}
			return filaSumaMas;
		}
	}

// Ej 4

	public boolean hayInterseccionPorColumna(int[][] mat1, int[][] mat2) {
		boolean hayInterseccionColumna;
		boolean hayInterseccionEnTodas = true;
		if (mat1.length == 0 || mat2.length == 0 || mat1[0].length != mat2[0].length) {
			return false;
		} else {
			for (int col = 0; col < mat1[0].length; col++) {
				hayInterseccionColumna = false;
				for (int fila = 0; fila < mat1.length; fila++) {
					for (int i = 0; i < mat2.length; i++) {
						hayInterseccionColumna = hayInterseccionColumna || (mat1[fila][col] == mat2[i][col]);
					}
				}
				hayInterseccionEnTodas = hayInterseccionEnTodas && hayInterseccionColumna;
			}
		}
		return hayInterseccionEnTodas;
	}
}
