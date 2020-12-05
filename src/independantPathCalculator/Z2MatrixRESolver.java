/**
 * 
 */
package independantPathCalculator;

/**
 * Permet de transformer une matrice en forme �chelonn�e sur le lignes (Row echelon form).
 * 
 * @author Alexandre Ouellet {alexandre.ouellet@uqtr.ca}
 */
class Z2MatrixRESolver {

	// La matrice utilis�e par le solveur
	private Z2Matrix _REMatrix;
	
	/**
	 * Cr�e un nouveau solveur pour calculer des matrices �chelonn�e sur les lignes.
	 * 
	 * @param matrix la matrice a r�duire
	 */
	Z2MatrixRESolver(final Z2Matrix matrix) {
		_REMatrix = new Z2Matrix(matrix.getElements());;
	}
	
	/**
	 * Retourne une matrice �chelonn�e sur les lignes.
	 * 
	 * @return la matrice �chelonn�e sur les lignes
	 */
	Z2Matrix computeREMatrix() {		
		final int cols = _REMatrix.getCols();
		final int rows = _REMatrix.getRows();
		boolean skipCol;
		int colPivot = 0;

		for(int rowPivot = 0; rowPivot < rows && colPivot < cols; rowPivot ++) {
			int pivot = _REMatrix.getElement(rowPivot , colPivot);
			skipCol = false;
			
			if(pivot == 0) {
				int nonNullPivotRow = -1;
				
				for(int row = rowPivot + 1; row < rows; row++) {
					if(_REMatrix.getElement(row, colPivot) != 0) {
						nonNullPivotRow = row;
						row = rows;		// break 
					}
				}
				
				if(nonNullPivotRow == -1) {
					// Tous les potentiels sont nuls, on saute la colonne
					skipCol = true;
				} else {
					// Ramener une ligne avec un pivot non nul 
					_REMatrix.swapRows(rowPivot, nonNullPivotRow);
				}
			}
			
			if(!skipCol) {				
				// Mise � jour de chaque ligne
				for(int row = rowPivot + 1; row < rows; row++) {
					if(_REMatrix.getElement(row, colPivot) == 1) {
						// On ajoute la ligne pour r�duire le pivot a 0
						_REMatrix.addToRow(row, rowPivot);
					}
				}
			} else {
				rowPivot--;
			}
			
			colPivot++;
		}
		
		return _REMatrix;
	}
	
}
