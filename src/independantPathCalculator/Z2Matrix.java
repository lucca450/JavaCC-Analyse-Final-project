package independantPathCalculator;

/**
 * Matrice d'�l�ment sur le corps de Z_2. La taille de la matrice est immuable
 * apr�s la cr�ation, mais sont contenu peut �tre modifi� par des op�rations
 * �l�mentaires sur les lignes ou des mutateurs.
 * 
 * @author Alexandre Ouellet {alexandre.ouellet@uqtr.ca}
 */
class Z2Matrix {

	// Dimensions
	private int rows;
	private int cols;

	// �l�ments
	private byte[][] matrix;

	/**
	 * D�finit une nouvelle matrice avec les �l�ments s�lectionn�s.
	 * 
	 * @param elems
	 */
	Z2Matrix(final byte[][] elems) {
		matrix = elems.clone();
		rows = elems.length;
		cols = (rows > 0) ? elems[0].length : 0; // Si pas de ligne, le nombre de colonne n'importe pas.
	}

	/**
	 * D�finit une nouvelle matrice avec tous les �l�ments nuls.
	 * 
	 * @param rows le nombre de lignes
	 * @param cols le nombre de colonnes
	 */
	Z2Matrix(final int rows, final int cols) {
		matrix = new byte[rows][cols];
		this.rows = rows;
		this.cols = cols;
	}

	/**
	 * Retourne un �l�ment de la matrice � la position indiqu�e.
	 * 
	 * @param row la ligne de l'�l�ment
	 * @param col la colonne de l'�l�ment
	 * @return la valeur de l'�l�ment � la position indiqu�e
	 * @throws IndexOutOfBoundsException si les indices de l'�l�ment sont en dehors
	 *                                   des dimensions de la matrice
	 */
	int getElement(final int row, final int col) throws IndexOutOfBoundsException {
		if (row > -1 && row < rows && col > -1 && col < cols) {
			return matrix[row][col];
		}

		throw new IndexOutOfBoundsException(String.format("Impossible d'acc�der � l'�l�ment %d, %d de la matrice. "
				+ "Les dimensions de la matrice sont %d x %d.", row, col, rows, cols));
	}

	/**
	 * Modifie un �l�ment de la matrice � la position indiqu�e.
	 * 
	 * @param value la nouvelle valeur de l'�l�ment
	 * @param row   la ligne de l'�l�ment
	 * @param col   la colonne de l'�l�ment
	 * @throws IndexOutOfBoundsException si les indices de l'�l�ment sont en dehors
	 *                                   des dimensions de la matrice
	 */
	void setElement(final byte value, final int row, final int col) throws IndexOutOfBoundsException {
		if (row > -1 && row < rows && col > -1 && col < cols) {
			matrix[row][col] = value;
		} else {
			throw new IndexOutOfBoundsException(String.format("Impossible d'acc�der � l'�l�ment %d, %d de la matrice."
					+ " Les dimensions de la matrice sont %d x %d.", row, col, rows, cols));
		}
	}

	/**
	 * Retourne le nombre de lignes.
	 * 
	 * @return le nombre de lignes de la matrice
	 */
	int getRows() {
		return rows;
	}

	/**
	 * Retourne le nombre de colonnes.
	 * 
	 * @return le nombre de colonnes de la matrice
	 */
	int getCols() {
		return cols;
	}

	/**
	 * Retourne tous les �l�ments de la matrice.
	 * 
	 * @return les �l�ments de la matrice
	 */
	byte[][] getElements() {
		return matrix;
	}
	
	/**
	 * Retourne le rang de la matrice. Le rang d'une matrice est la taille de
	 * l'ensemble g�n�rateur de lignes (ou de colonnes). �quivalent � la taille de
	 * l'ensemble ind�pendant de lignes (ou de colonnes).
	 * 
	 * @return le nombre de colonnes de la matrice
	 */
	int getRank() {
		Z2MatrixRESolver _REMatrixSolver = new Z2MatrixRESolver(this);
		Z2Matrix _REMatrix = _REMatrixSolver.computeREMatrix();
		return _REMatrix.getNonNullRowsNumber();
	}

	/**
	 * Retourne le nombre de lignes dont les coefficients ne sont pas tous nuls
	 * 
	 * @return le nombre de lignes dont au moins un coefficient est non nul.
	 *         Correspond au rang si la matrice est ER.
	 */
	private int getNonNullRowsNumber() {
		int numberOfNonNullRows = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] != 0) {
					numberOfNonNullRows++;
					j = cols; // Sort de la boucle int�rieure et passe � la prochaine ligne
				}
			}
		}

		return numberOfNonNullRows;
	}

	/**
	 * Permutte deux lignes de la matrice
	 * 
	 * @param rowA la premi�re ligne � permutter
	 * @param rowB la seconde ligne � permutter
	 * @throws IndexOutOfBoundsException si les indices de lignes ne sont pas valide
	 *                                   pour la dimension de la matrice.
	 */
	void swapRows(int rowA, int rowB) throws IndexOutOfBoundsException {
		if (rowA < 0 || rowA >= rows || rowB < 0 || rowB >= rows) {
			throw new IndexOutOfBoundsException(String.format(
					"Impossible de permutter les lignes %d et %d de la matrice." + " La matrice comporte %d lignes.",
					rowA, rowB, rows));
		}

		for (int col = 0; col < cols; col++) {
			byte temp = matrix[rowA][col];
			matrix[rowA][col] = matrix[rowB][col];
			matrix[rowB][col] = temp;
		}
	}

	/**
	 * Ajoute une ligne � une autre. On ne permet pas la pr�sence d'un coefficient
	 * car on est sur Z_2
	 * 
	 * @param row   la ligne � laquelle faire l'ajout
	 * @param toAdd la ligne � ajouter
	 * @throws IndexOutOfBoundsException si les indices de lignes ne sont pas valide
	 *                                   pour la dimension de la matrice.
	 */
	void addToRow(int row, int toAdd) throws IndexOutOfBoundsException {
		if (row < 0 || row >= rows || toAdd < 0 || toAdd >= rows) {
			throw new IndexOutOfBoundsException(
					String.format("Impossible d'addition la ligne %d � la ligne %d de la matrice."
							+ " La matrice comporte %d lignes.", toAdd, row, rows));
		}

		for (int col = 0; col < cols; col++) {
			// Addition sur Z_2
			matrix[row][col] = (byte) ((matrix[row][col] + matrix[toAdd][col]) % 2);
		}
	}
	
	/**
	 * Affiche la matrice dans la console
	 */
	void printToConsole() {
		int rowIndex = 0, colIndex = 0;
		boolean printNextElem = (rows > 0 && cols > 0);
		
		while(printNextElem) {
			System.out.print(matrix[rowIndex][colIndex]);
			
			if(colIndex < cols - 1) {
				colIndex ++;
				System.out.print(" ");
			} else {
				if(rowIndex < rows - 1) {
					rowIndex ++;
					colIndex = 0;
					System.out.print("\n");
				} else {
					printNextElem = false;
				}
			}
		}
		System.out.print("\n");
	}
}
